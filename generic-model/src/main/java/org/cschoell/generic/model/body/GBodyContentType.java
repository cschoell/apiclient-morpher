package org.cschoell.generic.model.body;

import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.*;

@Getter
public enum GBodyContentType {
    none(BodyMode.raw),
    json(BodyMode.raw),
    text(BodyMode.raw),
    xml(BodyMode.raw),
    formUrlencoded(BodyMode.form),
    multipartForm(BodyMode.form),
    graphql(BodyMode.raw);

    private final BodyMode mode;

    GBodyContentType(BodyMode mode) {
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
