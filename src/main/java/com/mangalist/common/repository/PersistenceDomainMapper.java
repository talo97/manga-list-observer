package com.mangalist.common.repository;

import java.util.List;

/**
 * @param <D>   domain entity type
 * @param <E>   persistence entity type
 * @param <DID> domain entity ID type
 * @param <EID> persistence entity ID type
 * @author Artur Talik
 */
public interface PersistenceDomainMapper<D, E, DID, EID> {

    DID mapPersistenceIdToDomainId(EID persistenceId);

    List<DID> mapPersistenceIdToDomainId(Iterable<EID> persistenceIds);

    EID mapDomainIdToPersistenceId(DID domainId);

    List<EID> mapDomainIdToPersistenceId(Iterable<DID> domainIds);

    D mapToDomainEntity(E persistenceEntity);

    List<D> mapToDomainEntity(Iterable<E> persistenceEntities);

    E mapToPersistenceEntity(D domainEntity);

    List<E> mapToPersistenceEntity(Iterable<D> domainEntities);

}
