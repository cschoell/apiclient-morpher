package org.apiclient.morpher.properties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PropertyAccessDescription {

    private String packageName;
    private String className;
    private String propertyName;
    private String type;
    private boolean get;
    private boolean set;

    public PropertyAccessDescription(String packageName, String className, String propertyName, String type) {
        this.packageName = packageName;
        this.className = className;
        this.propertyName = propertyName;
        this.type = type;
    }
}
