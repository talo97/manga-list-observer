package com.mangalist.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of common operations of all repositories for Spring Data JPA.
 *
 * @param <D>   domain entity type
 * @param <E>   persistence entity type
 * @param <DID> domain entity ID type
 * @param <EID> persistence entity ID type
 * @author Artur Talik
 */
public abstract class CommonSpringJpaRepositoryImpl<D, E, DID, EID> implements CommonRepository<D, DID> {

    private final JpaRepository<E, EID> repository;
    private final PersistenceDomainMapper<D, E, DID, EID> mapper;

    public CommonSpringJpaRepositoryImpl(JpaRepository<E, EID> repository, PersistenceDomainMapper<D, E, DID, EID> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public D save(D entity) {
        return mapper.mapToDomainEntity(
                repository.save(mapper.mapToPersistenceEntity(entity)));
    }

    @Override
    public List<D> saveAll(Iterable<D> entities) {
        return mapper.mapToDomainEntity(
                repository.saveAll(mapper.mapToPersistenceEntity(entities)));
    }

    @Override
    public Optional<D> findById(DID id) {
        Optional<E> entityById = repository.findById(mapper.mapDomainIdToPersistenceId(id));
        return entityById.map(mapper::mapToDomainEntity);
    }

    @Override
    public boolean existsById(DID id) {
        return repository.existsById(mapper.mapDomainIdToPersistenceId(id));
    }

    @Override
    public List<D> findAll() {
        return mapper.mapToDomainEntity(repository.findAll());
    }

    @Override
    public List<D> findAllById(Iterable<DID> ids) {
        return mapper.mapToDomainEntity(repository.findAllById(
                mapper.mapDomainIdToPersistenceId(ids)));
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(DID id) {
        repository.deleteById(mapper.mapDomainIdToPersistenceId(id));
    }

    @Override
    public void delete(D entity) {
        repository.delete(mapper.mapToPersistenceEntity(entity));
    }

    @Override
    public void deleteAllById(Iterable<DID> ids) {
        repository.deleteAllById(mapper.mapDomainIdToPersistenceId(ids));
    }

    @Override
    public void deleteAll(Iterable<D> entities) {
        repository.deleteAll(mapper.mapToPersistenceEntity(entities));
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
