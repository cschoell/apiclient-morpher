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
        "jsonBody",
        "textBody",
        "xmlBody",
        "urlEncodedBody",
        "multipartFormBody",
        "graphqlBody",
        "graphqlVarsBody",
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

    private RawBody jsonBody;
    private RawBody textBody;
    private RawBody xmlBody;
    private FormBody urlEncodedBody;
    private FormBody multipartFormBody;
    private RawBody graphqlBody;
    private RawBody graphqlVarsBody;

    private PreRequestVars preRequestVars;

    private PostResponseVars postResponseVars;

    private Assert asserts;

    private PreRequestScript preRequestScript;

    private PostResponseScript postResponseScript;

    private Tests tests;

    public void setGraphqlBody(RawBody body) {
        this.graphqlBody = onlyWithContent(body, BodyType.graphql);
    }

    public void setGraphqlVarsBody(RawBody body) {
        this.graphqlVarsBody = onlyWithContent(body, BodyType.graphql_vars);
    }

    public void setJsonBody(RawBody body) {
        this.jsonBody = onlyWithContent(body, BodyType.json);
    }

    public void setTextBody(RawBody body) {
        this.textBody = onlyWithContent(body, BodyType.text);
    }

    public void setXmlBody(RawBody body) {
        this.xmlBody = onlyWithContent(body, BodyType.xml);
    }

    public void setUrlEncodedBody(FormBody body) {
        this.urlEncodedBody = onlyWithContent(body, BodyType.formUrlencoded);
    }

    public void setMultipartFormBody(FormBody body) {
        this.multipartFormBody = onlyWithContent(body, BodyType.multipartForm);
    }

    private <T extends Body> T onlyWithContent(T body, BodyType bodyType) {
        if (body == null || !body.hasContent()) return null;
        body.setType(bodyType);
        return body;
    }
}
