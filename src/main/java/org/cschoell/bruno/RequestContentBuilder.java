package org.cschoell.bruno;

import org.cschoell.postman.model.Item;

public class RequestContentBuilder {
    Item item;
    StringBuilder content = new StringBuilder();

    public RequestContentBuilder(Item item) {
        this.item = item;
    }

    String build() {
        writeMeta();
        writeRequest();
        return null;
    }

    private void writeMeta() {
        startSection("meta");
        addKeyValue("name", item.getName());
        addKeyValue("type", "http");
        addKeyValue("seq", "1");
        finishSection();
    }

    private void writeRequest() {
        item.getRequest().getMethod();
        startSection("get");
    }

    private void startSection(String name) {
        addLine(name + " {");
    }

    private void finishSection() {
        addLine("}");
    }


    private void addKeyValue(String key, String value) {
        this.content.append("  ").append(key).append(": ").append(value).append("\n");
    }

    private void addLine(String string) {
        this.content.append(string).append("\n");
    }


}
