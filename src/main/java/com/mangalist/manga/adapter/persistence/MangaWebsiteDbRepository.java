package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.PersistenceAdapter;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.Website;
import com.mangalist.manga.domain.ports.MangaWebsiteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Artur Talik
 */
@PersistenceAdapter
@RequiredArgsConstructor
class MangaWebsiteDbRepository implements MangaWebsiteRepository {

    private final SpringDataMangaWebsiteRepository mangaWebsiteRepository;
    private final MangaMapper mangaMapper;

    @Override
    public List<Manga> listSupportedManga(Website website) {
        List<MangaWebsiteEntity> list = mangaWebsiteRepository.findAllByWebsiteId(website.getId());
        List<MangaEntity> mangaList = list.stream()
                .map(MangaWebsiteEntity::getMangaEntity)
                .collect(Collectors.toList());
        return mangaMapper.mapToDomainEntity(mangaList);
    }
}
