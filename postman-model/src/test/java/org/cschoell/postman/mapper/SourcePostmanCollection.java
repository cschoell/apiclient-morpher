package org.cschoell.postman.mapper;

import org.cschoell.postman.model.*;

import java.util.*;

public class SourcePostmanCollection {

    public PostmanCollection generateCollection() {
        final Description description = createDescription();
        final Version version = new Version(1, 0, 4, "beta", null, createAdditionalProperties());
        final Info info = new Info("name", "pid", description, version, "schema", null);

        final List<PostmanPolymorphicBase> items = createItems();
        final List<Event> events = createEvents();
        final List<Variable> variables = createVariables();
        final ProtocolProfileBehavior protocolProfileBehavior = new ProtocolProfileBehavior(null);
        return new PostmanCollection(info, items, events, variables, null, protocolProfileBehavior, null);
    }

    private List<Variable> createVariables() {
        return new ArrayList<>();
    }

    private ArrayList<PostmanPolymorphicBase> createItems() {
        final ArrayList<PostmanPolymorphicBase> items = new ArrayList<>();
        final Item request = createRequest();
        request.getRequest().setAuth(createAuth());
        items.add(request);
        items.add(createFolder());
        return items;
    }

    private PostmanPolymorphicBase createFolder() {
        final ArrayList<Item> requests = new ArrayList<>();
        requests.add(createRequest());
        return new VirtualFolder("folder.name", createDescription(), createVariables(), null, new ProtocolProfileBehavior(), requests, null);
    }

    private Item createRequest() {
        final Url url = createUrl();
        final ProxyConfig proxy = new ProxyConfig("match", "host", 8443, false, true, null);
        final Certificate certificate = new Certificate("cert.name", Arrays.asList("match1", "match2"), new Key("key.src", null),
                new Cert("cert.src", null), "passphrase", null);
        final Body body = new Body(Body.Mode.URLENCODED, "raw", createUrlEncoded(), createFormData(), new File("file.src", "file.content", null), new Graphql("graphql.query", "graphql.variables", null), new Options(null), false, null);
        final Request request = new Request(url, null, proxy, certificate, Request.Method.GET, createDescription(), createHeaders(), body, null);
        return new Item("request.name", createDescription(), createVariables(), createEvents(), new ProtocolProfileBehavior(),
                "rid", request, Collections.emptyList(), null);
    }

    private Url createUrl() {
        return new Url("https://somehwere.com", "https", Arrays.asList("host", "name"), Arrays.asList("my", "path"),
                "8080", createQueries(), "hash", createVariables(), null);
    }

    private List<Urlencoded> createUrlEncoded() {
        final ArrayList<Urlencoded> urlencodeds = new ArrayList<>();
        urlencodeds.add(new Urlencoded("urlencoded.key", "urlencoded.value", false, createDescription(), null));
        return urlencodeds;
    }

    private List<Formdatum> createFormData() {
        final ArrayList<Formdatum> forms = new ArrayList<>();
        forms.add(new Formdatum("formdata.key", "formdata.value", "formdata.src", false, Formdatum.Type.TEXT, "formdata.contenttype", createDescription(), null));
        return forms;
    }

    private List<Query> createQueries() {
        final ArrayList<Query> queries = new ArrayList<>();
        queries.add(new Query("query.key", "query.value", false, createDescription(), null));
        return queries;
    }

    private List<Header> createHeaders() {
        final ArrayList<Header> headers = new ArrayList<>();
        headers.add(new Header("header.key", "header.value", false, createDescription(), null));
        return headers;
    }

    private List<Event> createEvents() {
        final ArrayList<Event> events = new ArrayList<>();
        events.add(createEvent("test"));
        events.add(createEvent("prerequest"));
        events.add(createEvent("postresponse"));
        return events;
    }

    private Event createEvent(String test) {
        return new Event("event.id", test, new Script("script.id", "script.type", Arrays.asList("exec1", "exec2"), createUrl(), "event.name", createAdditionalProperties()), false, createAdditionalProperties());
    }

    private Auth createAuth() {
        return new Auth(Auth.Type.BASIC, createAuthProperties(), createAuthProperties(), createAuthProperties(), createAuthProperties(), createAuthProperties(), createAuthProperties(), createAuthProperties(), createAuthProperties(), createAuthProperties(), createAuthProperties(), null);
    }

    private List<AuthAttribute> createAuthProperties() {
        final LinkedList<AuthAttribute> authAttributes = new LinkedList<>();
        authAttributes.add(new AuthAttribute("authattribute.key", "authattribute.value", "type", null));
        return authAttributes;
    }

    private Map<String, AdditionalProperty> createAdditionalProperties() {
        final HashMap<String, AdditionalProperty> props = new HashMap<>();
        final HashMap<String, String> properties = new HashMap<>();
        properties.put("subprop", "provalue");
        props.put("property", new AdditionalProperty(properties, "value", true));
        return props;

    }


    private Description createDescription() {
        return new Description("description", "text/html", null, null);
    }

}
