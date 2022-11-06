package com.mangalist.manga.domain.ports;

import com.mangalist.common.UseCase;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.Website;
import com.mangalist.manga.domain.model.searcher.MangaSimpleData;
import com.mangalist.manga.domain.ports.usecase.FindMangaUseCase;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Talik
 */
@UseCase
@RequiredArgsConstructor
public class ServiceManga implements FindMangaUseCase {

    private final MangaRepository mangaRepository;
    private final MangaWebsiteRepository mangaWebsiteRepository;
    private final WebsiteRepository websiteRepository;
    private final WebsiteSearcherFactory websiteSearcherFactory;

    @Override
    public List<Manga> listAllManga() {
        return mangaRepository.findAll();
    }

    @Override
    public List<Manga> listAllMangaSupportedByWebsite(Website website) {
        return null;
    }

    @Override
    public List<MangaSimpleData> findNotRegisteredManga(Website website) throws IOException {
        Iterable<MangaSimpleData> allMangaFound = websiteSearcherFactory
                .createWebsiteSearcher(website.getWebsiteType())
                .listAllManga();
        List<Manga> listSupportedManga = mangaWebsiteRepository.listSupportedManga(website);
        // TODO:: add diff
        List<MangaSimpleData> listDiff = new ArrayList<>();
        return listDiff;
    }
}
