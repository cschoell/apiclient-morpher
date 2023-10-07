package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "description",
        "variable",
        "item",
        "request",
        "auth",
        "protocolProfileBehavior"
})
@Data
public class Folder extends ItemBase {

    @JsonProperty("item")
    private List<Item> item;

    @JsonProperty("auth")
    private Auth auth;

}
