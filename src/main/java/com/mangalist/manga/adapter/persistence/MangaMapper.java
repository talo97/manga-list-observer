package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.Mapper;
import com.mangalist.common.PersistenceDomainMapperHelper;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.MangaWebsite;
import com.mangalist.manga.domain.model.value.Author;
import com.mangalist.manga.domain.model.value.MangaId;
import com.mangalist.manga.domain.model.value.MangaTitle;
import com.mangalist.manga.domain.model.value.MangaWebsiteId;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Artur Talik
 */
@Mapper
@RequiredArgsConstructor
class MangaMapper {

    private final MangaWebsiteMapper mangaWebsiteMapper;

    public Manga mapToDomainEntity(MangaEntity persistenceEntity) {
        List<MangaWebsite> mangaWebsiteList =
                Optional.ofNullable(persistenceEntity.getMangaWebsiteList())
                        .orElse(new ArrayList<>())
                        .stream()
                        .map(mangaWebsiteMapper::mapToDomainEntity)
                        .collect(Collectors.toList());

        return Manga.createFromExistingEntity(
                MangaId.of(persistenceEntity.getId()),
                MangaTitle.of(persistenceEntity.getName()),
                Author.of(persistenceEntity.getAuthor()),
                persistenceEntity.getType(),
                persistenceEntity.getMangaStatus(),
                mangaWebsiteList);
    }

    public List<Manga> mapToDomainEntity(Iterable<MangaEntity> persistenceEntities) {
        return PersistenceDomainMapperHelper.mapDomainEntitiesToPersistenceEntities(
                persistenceEntities,
                this::mapToDomainEntity);
    }

    public MangaEntity mapToPersistenceEntity(Manga domainEntity) {
        return MangaEntity.of(domainEntity);
    }

    public List<MangaEntity> mapToPersistenceEntity(Iterable<Manga> domainEntities) {
        return PersistenceDomainMapperHelper.mapPersistenceEntitiesToDomainEntities(
                domainEntities,
                this::mapToPersistenceEntity);
    }

}
