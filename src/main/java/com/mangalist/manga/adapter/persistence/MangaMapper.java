package com.mangalist.manga.adapter.persistence;

import com.mangalist.manga.domain.model.Manga;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Artur Talik
 */
@Component
class MangaMapper {

    Manga mapToDomainEntity(MangaEntity mangaEntity) {
        //TODO::
        return new Manga();
    }

    List<Manga> mapToDomainEntity(List<MangaEntity> mangaEntityList) {
        return mangaEntityList
                .stream()
                .map(this::mapToDomainEntity)
                .collect(Collectors.toList());
    }

}
