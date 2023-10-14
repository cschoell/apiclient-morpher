package org.cschoell.bruno.model;

import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.*;

@Getter
public enum BodyType {
    none(BodyMode.raw),
    json(BodyMode.raw),
    text(BodyMode.raw),
    xml(BodyMode.raw),
    formUrlencoded(BodyMode.form),
    multipartForm(BodyMode.form),
    graphql(BodyMode.raw),
    graphql_vars(BodyMode.raw);

    private final BodyMode mode;

    BodyType(BodyMode mode) {
        this.mode = mode;
    }

    /**
     * returns the name in bruno style: replaces _ with : and converts camelcase to - separated.
     * e.g. graphql_vars -> graphql:vars and urlEncoded -> url-encoded
     */
    public String inBrunoStyle() {
        return lowerCase(join(splitByCharacterTypeCamelCase(name()), "-").replace("_", ":")).replace("-:-", ":");
    }


    @Override
    public String toString() {
        return name();
    }

    public enum BodyMode {
        form,raw
    }
}
