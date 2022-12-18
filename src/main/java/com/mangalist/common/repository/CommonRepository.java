package com.mangalist.common.repository;

import java.util.List;
import java.util.Optional;

/**
 * Common repository operations.
 * Exist to not duplicate code all the time for every new repository.
 *
 * @param <D>  domain entity type
 * @param <ID> domain entity ID type
 * @author Artur Talik
 */
public interface CommonRepository<D, ID> {

    D save(D entity);

    List<D> saveAll(Iterable<D> entities);

    Optional<D> findById(ID id);

    boolean existsById(ID id);

    List<D> findAll();

    List<D> findAllById(Iterable<ID> ids);

    long count();

    void deleteById(ID id);

    void delete(D entity);

    void deleteAllById(Iterable<ID> ids);

    void deleteAll(Iterable<D> entities);

    void deleteAll();

}
