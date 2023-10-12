package org.cschoell.postman.schematoobject.postmanconverter;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import lombok.Data;
import org.jsonschema2pojo.AbstractAnnotator;

public class LombokAnnotator extends AbstractAnnotator {

    @Override
    public void typeInfo(JDefinedClass clazz, JsonNode schema) {
        super.typeInfo(clazz, schema);

    }

    @Override
    public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
        super.propertyOrder(clazz, propertiesNode);
        clazz.annotate(Data.class);
    }
}
