package org.cschoell.bruno.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "meta",
        "request",
        "query",
        "headers",
        "auth",
        "body",
        "preRequestVars",
        "postResponseVars",
        "asserts",
        "preRequestScript",
        "postResponseScript",
        "tests"
})
public class BrunoRequestFile {

    private Meta meta;

    private Request request;

    private Query query;

    private Headers headers;

    private Auth auth;

    private Body body;

    private PreRequestVars preRequestVars;

    private PostResponseVars postResponseVars;

    private Assert asserts;

    private PreRequestScript preRequestScript;

    private PostResponseScript postResponseScript;

    private Tests tests;
}
