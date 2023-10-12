package org.cschoell.postman.schematoobject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.cschoell.postman.model.VirtualFolder;
import org.cschoell.postman.model.Item;
import org.cschoell.postman.model.PostmanPolymorphicBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PostmanObjectMapperBuilder {


    public JsonMapper build() {
        PolymorphicDeserializer deserializer =
                new PolymorphicDeserializer();
        deserializer.registerItem("item", VirtualFolder.class);
        deserializer.registerItem("request", Item.class);
        SimpleModule module =
                new SimpleModule("PolymorphicItemDeserializerModule",
                        new Version(1, 0, 0, null));
        module.addDeserializer(PostmanPolymorphicBase.class, deserializer);




        final JsonMapper build = JsonMapper.builder()
                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                .addModule(module)
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES).build();

        return build;
    }

    static class PolymorphicDeserializer extends StdDeserializer<PostmanPolymorphicBase> {
        private final Map<String, Class<? extends PostmanPolymorphicBase>> registry =
                new HashMap<>();

        PolymorphicDeserializer() {
            super(PostmanPolymorphicBase.class);
        }

        void registerItem(String uniqueAttribute,
                          Class<? extends PostmanPolymorphicBase> itemBaseClass) {
            registry.put(uniqueAttribute, itemBaseClass);
        }

        @Override
        public PostmanPolymorphicBase deserialize(
                JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            ObjectMapper mapper = (ObjectMapper) jp.getCodec();
            ObjectNode root = mapper.readTree(jp);
            Class<? extends PostmanPolymorphicBase> itemBaseClass = null;
            Iterator<Map.Entry<String, JsonNode>> elementsIterator =
                    root.fields();
            while (elementsIterator.hasNext()) {
                Map.Entry<String, JsonNode> element = elementsIterator.next();
                String name = element.getKey();
                if (registry.containsKey(name)) {
                    itemBaseClass = registry.get(name);
                    break;
                }
            }
            if (itemBaseClass == null) return null;
            return mapper.readValue(root.traverse(), itemBaseClass);
        }
    }
}
