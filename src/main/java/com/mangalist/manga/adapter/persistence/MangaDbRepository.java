package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.PersistenceAdapter;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.ports.MangaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Artur Talik
 */
@PersistenceAdapter
@RequiredArgsConstructor
class MangaDbRepository implements MangaRepository {

    private final SpringDataMangaRepository repository;
    private final MangaMapper mangaMapper;

    @Override
    public List<Manga> findAll() {
        return mangaMapper.mapToDomainEntity(repository.findAll());
    }
}
