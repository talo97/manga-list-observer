package com.mangalist.common.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Abstract class implementation of the interface for providing all the mapping operation on Collections.
 * Every mapper is expected to extend this abstract class to reduce boiler code.
 *
 * @param <D>   domain entity type
 * @param <E>   persistence entity type
 * @param <DID> domain entity ID type
 * @param <EID> persistence entity ID type
 * @author Artur Talik
 */
public abstract class CommonPersistenceDomainMapper<D, E, DID, EID>
        implements PersistenceDomainMapper<D, E, DID, EID> {

    @Override
    public List<DID> mapPersistenceIdToDomainId(Iterable<EID> persistenceIds) {
        return StreamSupport.stream(persistenceIds.spliterator(), false)
                .map(this::mapPersistenceIdToDomainId)
                .collect(Collectors.toList());
    }

    @Override
    public List<EID> mapDomainIdToPersistenceId(Iterable<DID> domainIds) {
        return StreamSupport.stream(domainIds.spliterator(), false)
                .map(this::mapDomainIdToPersistenceId)
                .collect(Collectors.toList());
    }

    @Override
    public List<D> mapToDomainEntity(Iterable<E> persistenceEntities) {
        return StreamSupport.stream(persistenceEntities.spliterator(), false)
                .map(this::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<E> mapToPersistenceEntity(Iterable<D> domainEntities) {
        return StreamSupport.stream(domainEntities.spliterator(), false)
                .map(this::mapToPersistenceEntity)
                .collect(Collectors.toList());
    }
}
