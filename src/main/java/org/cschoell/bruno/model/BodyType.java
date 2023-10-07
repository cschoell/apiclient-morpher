package org.cschoell.bruno.model;

import static org.apache.commons.lang3.StringUtils.*;

public enum BodyType {
    none,
    json,
    text,
    xml,
    urlEncoded,
    multipartForm,
    graphql,
    graphql_vars;

    /**
     * returns the name in bruno style: replaces _ with : and converts camelcase to - separated.
     * e.g. graphql_vars -> graphql:vars and urlEncoded -> url-encoded
     */
    public String inBrunoStyle() {
        return lowerCase(join(splitByCharacterTypeCamelCase(name()), "-").replace("_", ":"));
    }


    @Override
    public String toString() {
        return inBrunoStyle();
    }
}
