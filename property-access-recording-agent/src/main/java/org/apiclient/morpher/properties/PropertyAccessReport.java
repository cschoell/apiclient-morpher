package org.apiclient.morpher.properties;

import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyAccessReport {
    public static final Pattern PROPERTY_PATTERN = Pattern.compile("(?<ACCESSMOD>[a-z])+\\s(?<RETURNTYPE>[^ ]+)\\s(?<PACKAGE>(.*))\\.(?<ACCESSOR>set|get)(?<PROPERTY>[^(]+)\\((?<METHODPARAMS>[^)]*)\\)");

    private static final PropertyAccessReport INSTANCE = new PropertyAccessReport();

    public static PropertyAccessReport getInstance() {
        return INSTANCE;
    }

    private final List<String> propertiesAccessed = new LinkedList<>();

    public synchronized void addPropertyAccessed(String name) {
        synchronized (propertiesAccessed) {
            propertiesAccessed.add(name);
        }
    }

    public List<String> getPropertiesAccessed() {
        return Collections.unmodifiableList(propertiesAccessed);
    }


    public SortedSet<PropertyAccessDescription> getConvertedToPropertyDescriptions() {
        SortedSet<PropertyAccessDescription> propertyDescriptions = new TreeSet<>(Comparator.comparing(PropertyAccessDescription::getPackageName).thenComparing(PropertyAccessDescription::getClassName).thenComparing(PropertyAccessDescription::getPropertyName));
        Map<String, PropertyAccessDescription> alreadyMapped = new HashMap<>();
        Set<String> propertyAccessedSet = new TreeSet<>(propertiesAccessed);
        for (String s : propertyAccessedSet) {
            final Matcher matcher = PROPERTY_PATTERN.matcher(s);
            if (matcher.find()) {
                final String property = matcher.group("PROPERTY");
                final String returntype = matcher.group("RETURNTYPE");
                final String methodType = matcher.group("METHODPARAMS");
                String type = (methodType == null || methodType.isBlank()) ? returntype : methodType;
                String packageNameAndClass = matcher.group("PACKAGE");
                String packageName;
                String className;
                final int lastPackageIndex = packageNameAndClass.lastIndexOf(".");
                if (lastPackageIndex > 0) {
                    className = packageNameAndClass.substring(lastPackageIndex + 1);
                    packageName = packageNameAndClass.substring(0, lastPackageIndex);
                } else {
                    className = packageNameAndClass;
                    packageName = "";
                }
                final String accessor = matcher.group("ACCESSOR");
                final String key = packageName + property;

                PropertyAccessDescription propertyAccessDescription = alreadyMapped.computeIfAbsent(key, s1 -> {
                    final PropertyAccessDescription description = new PropertyAccessDescription(packageName, className, property, type);
                    propertyDescriptions.add(description);
                    return description;
                });

                if (Objects.equals(accessor, "get")) {
                    propertyAccessDescription.setGet(true);
                }
                if (Objects.equals(accessor, "set")) {
                    propertyAccessDescription.setSet(true);
                }

            }
        }

        return propertyDescriptions;

    }

    public void clearPropertiesAccessed() {
        synchronized (propertiesAccessed) {
            propertiesAccessed.clear();
        }
    }
}
