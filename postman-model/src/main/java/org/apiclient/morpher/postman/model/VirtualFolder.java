package org.apiclient.morpher.postman.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class VirtualFolder extends ItemBase {

    @JsonProperty("item")
    private List<Item> item;

    @JsonProperty("auth")
    private Auth auth;

    public VirtualFolder(String name, Description description, List<Variable> variable, List<Event> event, ProtocolProfileBehavior protocolProfileBehavior, List<Item> item, Auth auth) {
        super(name, description, variable, event, protocolProfileBehavior);
        this.item = item;
        this.auth = auth;
    }

}
