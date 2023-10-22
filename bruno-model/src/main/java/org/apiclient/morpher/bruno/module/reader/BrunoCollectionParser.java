package org.apiclient.morpher.bruno.module.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apiclient.morpher.bruno.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class BrunoCollectionParser {

    public static final String ID = "ID";
    private static final Pattern ID_PATTERN = Pattern.compile("(?<" + ID + ">[^#][^ \t]+) \\{");
    private static final Pattern END_PATTERN = Pattern.compile("}\\s*");
    private final BrunoCollection brunoCollection;
    private final File sourcePath;

    private static final Map<String, ValueContextToCollectionMapper> ID_TO_TARGETCLASS = new HashMap<>();

    static {
        ID_TO_TARGETCLASS.put("meta", new MetaMapper());
        ID_TO_TARGETCLASS.put("query", new GeneralMapper<>(Query.class, BrunoRequestFile::setQuery));

        final GeneralMapper<Request> RequestMapper = new GeneralMapper<>(Request.class, BrunoRequestFile::setRequest);
        ID_TO_TARGETCLASS.put("get", RequestMapper);
        ID_TO_TARGETCLASS.put("post", RequestMapper);
        ID_TO_TARGETCLASS.put("put", RequestMapper);
        ID_TO_TARGETCLASS.put("delete", RequestMapper);
        ID_TO_TARGETCLASS.put("patch", RequestMapper);
        ID_TO_TARGETCLASS.put("options", RequestMapper);
        ID_TO_TARGETCLASS.put("head", RequestMapper);

        ID_TO_TARGETCLASS.put("headers", new GeneralMapper<>(Headers.class, BrunoRequestFile::setHeaders));
        ID_TO_TARGETCLASS.put("tests", new GeneralMapper<>(Tests.class, BrunoRequestFile::setTests));

        final AuthBodyMapper authGeneralMapper = new AuthBodyMapper();
        ID_TO_TARGETCLASS.put("auth:basic", authGeneralMapper);
        ID_TO_TARGETCLASS.put("auth:bearer", authGeneralMapper);


        ID_TO_TARGETCLASS.put("body:json", new RawBodyMapper(BrunoRequestFile::setJsonBody));
        ID_TO_TARGETCLASS.put("body:xml", new RawBodyMapper(BrunoRequestFile::setXmlBody));
        ID_TO_TARGETCLASS.put("body:text", new RawBodyMapper(BrunoRequestFile::setTextBody));
        ID_TO_TARGETCLASS.put("body:multipart-form", new GeneralMapper<>(FormBody.class, BrunoRequestFile::setMultipartFormBody));
        ID_TO_TARGETCLASS.put("body:form-urlencoded", new GeneralMapper<>(FormBody.class, BrunoRequestFile::setUrlEncodedBody));
        ID_TO_TARGETCLASS.put("body:graphql", new RawBodyMapper(BrunoRequestFile::setGraphqlBody));
        ID_TO_TARGETCLASS.put("body:graphql:vars", new RawBodyMapper(BrunoRequestFile::setGraphqlVarsBody));
        ID_TO_TARGETCLASS.put(PreRequestVars.NAME, new GeneralMapper<>(PreRequestVars.class, BrunoRequestFile::setPreRequestVars));
        ID_TO_TARGETCLASS.put(PostResponseVars.NAME, new GeneralMapper<>(PostResponseVars.class, BrunoRequestFile::setPostResponseVars));
        ID_TO_TARGETCLASS.put("assert", new GeneralMapper<>(Assert.class, BrunoRequestFile::setAsserts));
        ID_TO_TARGETCLASS.put(PreRequestScript.NAME, new GeneralMapper<>(PreRequestScript.class, BrunoRequestFile::setPreRequestScript));
        ID_TO_TARGETCLASS.put(PostResponseScript.NAME, new GeneralMapper<>(PostResponseScript.class, BrunoRequestFile::setPostResponseScript));
    }


    private ParserState currentState = ParserState.MAIN;

    public BrunoCollectionParser(BrunoCollection brunoCollection, File sourcePath) {
        this.brunoCollection = brunoCollection;
        this.sourcePath = sourcePath;
    }

    public void readCollection() {
        readCollection(sourcePath, null);
    }

    private void readCollection(File sourcePath, Folder parent) {
        final File[] requestFiles = sourcePath.listFiles((dir, name) -> name.endsWith(".bru"));
        if (requestFiles != null) {
            final List<BrunoRequestFile> collect = Arrays.stream(requestFiles).map(this::readRequest).collect(Collectors.toList());
            if (parent == null) {
                brunoCollection.getRequests().addAll(collect);
            } else {
                parent.getRequests().addAll(collect);
            }
        }

        final File[] folders = sourcePath.listFiles(File::isDirectory);
        if (folders != null) {
            for (File folder : folders) {
                final Folder brunoFolder = new Folder(folder.getName());
                readCollection(folder, brunoFolder);
                if (parent == null) {
                    brunoCollection.getFolders().add(brunoFolder);
                } else {
                    parent.getSubFolder().add(brunoFolder);
                }
            }
        }
    }


    private BrunoRequestFile readRequest(File sourcePath) {
        try {
            List<String> source = FileUtils.readLines(sourcePath, StandardCharsets.UTF_8);
            List<ValueContext> valueContexts = new ArrayList<>();
            String currentId = "";
            List<String> currentBody = new LinkedList<>();
            for (String s : source) {
                switch (currentState) {
                    case MAIN -> {
                        final Matcher matcher = ID_PATTERN.matcher(s);
                        if (matcher.matches()) {
                            currentId = matcher.group(ID);
                            currentState = ParserState.VALUE;
                        }
                    }
                    case VALUE -> {
                        final Matcher matcher = END_PATTERN.matcher(s);
                        if (matcher.matches() && StringUtils.isNotBlank(currentId)) {
                            currentState = ParserState.MAIN;

                            final ValueContext valueContext = new ValueContext(currentId, currentBody);
                            valueContexts.add(valueContext);
                            currentId = "";
                            currentBody = new LinkedList<>();
                        } else {
                            currentBody.add(s);
                        }
                    }
                }
            }
            final BrunoRequestFile requestFile = new BrunoRequestFile();
            for (ValueContext valueContext : valueContexts) {
                mapValueContextToCollection(valueContext, requestFile);
            }
            log.info("Read Request: {}", requestFile);
            return requestFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void mapValueContextToCollection(ValueContext valueContext, BrunoRequestFile requestFile) {
        final ValueContextToCollectionMapper valueContextToCollectionMapper = ID_TO_TARGETCLASS.get(valueContext.getId());
        valueContextToCollectionMapper.mapToCollection(valueContext, requestFile);
    }

    private static Object createInstance(Class aClass) {
        final Object valueObjectInstance;
        try {
            valueObjectInstance = aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return valueObjectInstance;
    }


    @Getter
    @AllArgsConstructor
    @ToString
    private static class ValueContext {

        String id;
        List<String> body;

        public String getBodyAsString() {
            return StringUtils.join(body, "\n");
        }


        public Map<String, String> parseKeyValues() {
            Map<String, String> keyValues = new LinkedHashMap<>();
            for (String line : body) {
                final String[] keyValue = StringUtils.split(line, ":", 2);
                String key = StringUtils.trim(keyValue[0]);
                String value = "";
                if (keyValue.length > 1) {
                    value = StringUtils.trim(keyValue[1]);
                }
                keyValues.put(key, value);
            }
            return keyValues;
        }

    }

    enum ParserState {
        MAIN, VALUE
    }

    interface ValueContextToCollectionMapper<T> {
        void mapToCollection(ValueContext context, BrunoRequestFile target);

    }


    static class RawBodyMapper extends GeneralMapper<RawBody> {

        public RawBodyMapper(BiConsumer<BrunoRequestFile, RawBody> setter) {
            this(RawBody.class, setter);
        }

        public RawBodyMapper(Class<RawBody> targetClass, BiConsumer<BrunoRequestFile, RawBody> setter) {
            super(targetClass, setter);
        }

        @Override
        protected void accept(BrunoRequestFile target, RawBody value, ValueContext context) {
            super.accept(target, value, context);
        }
    }
    static class MetaMapper extends GeneralMapper<Meta> {

        public MetaMapper() {
            this(Meta.class, BrunoRequestFile::setMeta);
        }

        public MetaMapper(Class<Meta> targetClass, BiConsumer<BrunoRequestFile, Meta> setter) {
            super(targetClass, setter);
        }

        @Override
        protected void accept(BrunoRequestFile target, Meta value, ValueContext context) {
            final Map<String, String> keyValues = context.parseKeyValues();
            value.setName(keyValues.get("name"));
            value.setSeq(keyValues.getOrDefault("seq", "1"));
            value.setType(keyValues.getOrDefault("type", "http"));
        }
    }

    static class AuthBodyMapper extends GeneralMapper<Auth> {

        public AuthBodyMapper() {
            this(Auth.class, BrunoRequestFile::setAuth);
        }

        public AuthBodyMapper(Class<Auth> targetClass, BiConsumer<BrunoRequestFile, Auth> setter) {
            super(targetClass, setter);
        }

        @Override
        protected void accept(BrunoRequestFile target, Auth value, ValueContext context) {
            final String id = context.getId();
            final String[] strings = StringUtils.split(id, ":", 2);

            String type = "none";
            if (strings.length > 1) {
                type = StringUtils.trim(strings[1]);
            }
            value.setType(type);
            super.accept(target, value, context);
        }
    }

    static class GeneralMapper<T> implements ValueContextToCollectionMapper<T> {

        private final Class<T> targetClass;
        private final BiConsumer<BrunoRequestFile, T> setter;

        public GeneralMapper(Class<T> targetClass, BiConsumer<BrunoRequestFile, T> setter) {
            this.targetClass = targetClass;
            this.setter = setter;
        }

        @Override
        public void mapToCollection(ValueContext context, BrunoRequestFile target) {
            final Object valueObjectInstance = createInstance(targetClass);
            if (valueObjectInstance instanceof Map) {
                final Map o = (Map) valueObjectInstance;
                o.putAll(context.parseKeyValues());
                accept(target, (T) o, context);
            }
            if (valueObjectInstance instanceof BrunoValueBase) {
                final BrunoValueBase o = (BrunoValueBase) valueObjectInstance;
                o.setValue(context.getBodyAsString());
                accept(target, (T) o, context);
            }
        }

        protected void accept(BrunoRequestFile target, T value, ValueContext context) {
            setter.accept(target, value);
        }
    }


}

