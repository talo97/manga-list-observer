package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.Mapper;
import com.mangalist.manga.domain.model.MangaWebsite;
import com.mangalist.manga.domain.model.value.MangaTitle;
import com.mangalist.manga.domain.model.value.MangaWebsiteId;

/**
 * @author Artur Talik
 */
@Mapper
public class MangaWebsiteMapper {

    public MangaWebsite mapToDomainEntity(MangaWebsiteEntity entity) {
        return MangaWebsite.createFromExistingEntity(
                MangaWebsiteId.of(entity.getId()),
                entity.getWebsite(),
                MangaTitle.of(entity.getTitle()));
    }

    public MangaWebsiteEntity mapToPersistenceEntity(MangaWebsite domainEntity, MangaEntity mangaEntity) {
        return MangaWebsiteEntity.of(
                domainEntity.getMangaWebsiteId().getId(),
                mangaEntity,
                domainEntity.getWebsite(),
                domainEntity.getMangaTitle().getTitle());
    }
}
