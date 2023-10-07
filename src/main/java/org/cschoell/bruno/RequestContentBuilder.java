package org.cschoell.bruno;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.cschoell.bruno.model.BrunoModelComponentRoot;
import org.cschoell.bruno.model.BrunoRequestFile;
import org.cschoell.bruno.model.BrunoValueBase;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestContentBuilder {
    public static final String DEFAULT_BODY_JSON = "json";
    BrunoRequestFile brunoRequestFile;
    StringBuilder content = new StringBuilder();

    public RequestContentBuilder(BrunoRequestFile file) {
        this.brunoRequestFile = file;
    }

    public String build() {

        try {
            final Class<BrunoRequestFile> clazz = BrunoRequestFile.class;
            final List<PropertyDescriptor> rootDescriptors = getPropertyDescriptors(clazz);


            for (PropertyDescriptor propertyDescriptor : rootDescriptors) {
                if (BrunoModelComponentRoot.class.isAssignableFrom(propertyDescriptor.getPropertyType())) {
                    final BrunoModelComponentRoot rootProp = (BrunoModelComponentRoot) PropertyUtils.getProperty(brunoRequestFile, propertyDescriptor.getName());
                    if (rootProp == null) continue;
                    startSection(rootProp.getComponentRootName());
                    if (rootProp instanceof Map<?, ?>) {
                        Map<String, String> mapBean = (Map) rootProp;
                        mapBean.forEach(this::addKeyValue);
                    } else if (rootProp instanceof BrunoValueBase) {
                        addIndented(((BrunoValueBase) rootProp).getValue());
                    } else  {
                        final List<PropertyDescriptor> propertyDescriptors = getPropertyDescriptors(rootProp.getClass()).stream()
                                .filter(propertyDescriptor1 -> !StringUtils.equals(propertyDescriptor1.getName(), "componentRootName")).toList();
                        for (PropertyDescriptor descriptor : propertyDescriptors) {
                            final Object property = PropertyUtils.getProperty(rootProp, descriptor.getName());
                            addKeyValue(descriptor.getName(), property);
                        }
                    }
                    finishSection();
                }
            }


            return content.toString();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private List<PropertyDescriptor> getPropertyDescriptors(Class clazz) {
        final JsonPropertyOrder annotation = (JsonPropertyOrder) clazz.getAnnotation(JsonPropertyOrder.class);
        if (annotation != null) {
            final String[] order = annotation.value();
            final Map<String, PropertyDescriptor> collect = Arrays.stream(PropertyUtils.getPropertyDescriptors(clazz))
                    .collect(Collectors.toMap(PropertyDescriptor::getName,
                            propertyDescriptor -> propertyDescriptor,
                            (t, t2) -> t
                    ));

            List<PropertyDescriptor> sorted = new ArrayList<>();
            for (String propName : order) {
                final PropertyDescriptor propertyDescriptor = collect.get(propName);
                if (!propertyDescriptor.getReadMethod().isAnnotationPresent(JsonIgnore.class)) sorted.add(propertyDescriptor);
            }
            return sorted;
        }
        return Arrays.asList(PropertyUtils.getPropertyDescriptors(clazz)).stream().filter(propertyDescriptor -> !propertyDescriptor.getReadMethod().isAnnotationPresent(JsonIgnore.class)).toList();
    }

    private String getComponentName(PropertyDescriptor propertyDescriptor, Map<String, String> mapBean) throws IllegalAccessException, InvocationTargetException {
        String componentName = propertyDescriptor.getName().toLowerCase();
        try {
            componentName = (String) PropertyUtils.getProperty(mapBean, "componentRootName");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return componentName;
    }


    private void addIndented(String toAdd) {
        if (StringUtils.isBlank(toAdd)) return;
        final String indented = toAdd.indent(2);
        content.append(indented);
    }


    private void startSection(String name) {
        addLine(name + " {");
    }

    private void finishSection() {
        addLine("}");
    }


    private void addKeyValue(String key, Object value) {
        if (key != null && value != null) this.content.append("  ").append(key).append(": ").append(value).append("\n");
    }

    private void addLine(String string) {
        if (string != null) this.content.append(string).append("\n");
    }


}
