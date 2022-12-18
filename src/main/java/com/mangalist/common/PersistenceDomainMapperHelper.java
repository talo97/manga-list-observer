package com.mangalist.common;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Artur Talik
 */
public class PersistenceDomainMapperHelper {

    public static <I, O> List<O> mapPersistenceIdsToDomainIds(Iterable<I> ids, Function<I, O> mapper) {
        return StreamSupport.stream(ids.spliterator(), false)
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static <I, O> List<O> mapDomainIdsToPersistenceIds(Iterable<I> ids, Function<I, O> mapper) {
        return StreamSupport.stream(ids.spliterator(), false)
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static <D, E> List<D> mapPersistenceEntitiesToDomainEntities(Iterable<E> entities, Function<E, D> mapper) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static <D, E> List<E> mapDomainEntitiesToPersistenceEntities(Iterable<D> entities, Function<D, E> mapper) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(mapper)
                .collect(Collectors.toList());
    }

}
