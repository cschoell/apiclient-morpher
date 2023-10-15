package org.cschoell.apiclient.converter.api;

import org.cschoell.generic.model.GCollection;

public interface ModelMapper<T extends ConfigurationModel<?>> {

    GCollection mapToGeneric(T from);
    T mapFromGeneric(GCollection from);

}
