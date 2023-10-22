package org.apiclient.morpher.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiConfigurationType {
    public static final ApiConfigurationType postman = new ApiConfigurationType("postman");
    public static final ApiConfigurationType bruno = new ApiConfigurationType("bruno");
    public static final ApiConfigurationType generic = new ApiConfigurationType("generic");

    String type;

}
