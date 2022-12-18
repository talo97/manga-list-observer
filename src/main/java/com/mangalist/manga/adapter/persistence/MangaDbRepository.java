package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.PersistenceAdapter;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.MangaId;
import com.mangalist.manga.domain.model.value.Website;
import com.mangalist.manga.domain.ports.MangaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Artur Talik
 */
@PersistenceAdapter
@RequiredArgsConstructor
class MangaDbRepository implements MangaRepository {

    private final SpringDataMangaRepository mangaRepository;
    private final SpringDataMangaWebsiteRepository mangaWebsiteRepository;
    private final MangaMapper mangaMapper;
    private final MangaWebsiteMapper mangaWebsiteMapper;


    @Override
    public Optional<Manga> findById(MangaId mangaId) {
        Optional<MangaEntity> entityById = mangaRepository.findById(mangaId.getId());
        return entityById.map(mangaMapper::mapToDomainEntity);
    }

    @Override
    public Iterable<Manga> findAll() {
        return mangaMapper.mapToDomainEntity(mangaRepository.findAll());
    }

    @Override
    public List<Manga> listByWebsite(Website website) {
        return mangaMapper.mapToDomainEntity(
                mangaWebsiteRepository.findAllByWebsite(website)
                        .stream()
                        .map(MangaWebsiteEntity::getMangaEntity)
                        .distinct()
                        .collect(Collectors.toList()));
    }

    @Override
    public Manga saveOrUpdate(Manga manga) {
        MangaEntity mangaEntity = mangaRepository.save(mangaMapper.mapToPersistenceEntity(manga));
        List<MangaWebsiteEntity> mangaWebsiteEntities = manga.getWebsiteList().stream()
                .map(website -> mangaWebsiteMapper.mapToPersistenceEntity(website, mangaEntity))
                .collect(Collectors.toList());
        mangaWebsiteRepository.saveAll(mangaWebsiteEntities);
        return mangaMapper.mapToDomainEntity(mangaEntity);
    }
}

