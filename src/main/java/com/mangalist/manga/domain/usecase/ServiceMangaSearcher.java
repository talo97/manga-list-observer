package com.mangalist.manga.domain.usecase;

import com.mangalist.common.UseCase;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.Website;
import com.mangalist.manga.domain.model.value.searcher.MangaSimpleData;
import com.mangalist.manga.domain.ports.MangaRepository;
import com.mangalist.manga.domain.ports.WebsiteSearcherFactory;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Talik
 */
@UseCase
@RequiredArgsConstructor
public class ServiceMangaSearcher implements SearchWebsiteMangaUseCase {

    private final MangaRepository mangaRepository;
    private final WebsiteSearcherFactory websiteSearcherFactory;

    @Override
    public List<MangaSimpleData> searchForNewMangaEntries(Website website) {
        Iterable<MangaSimpleData> foundMangaOnWebsiteList = websiteSearcherFactory
                .createWebsiteSearcher(website)
                .listAllManga();
        List<Manga> alreadySupportedMangaList = mangaRepository.listByWebsite(website);
        List<MangaSimpleData> listDiff = new ArrayList<>();

        for (MangaSimpleData mangaSimpleData : foundMangaOnWebsiteList) {
            boolean containsByTitle = alreadySupportedMangaList.stream()
                    .anyMatch(manga -> manga.getMangaTitle().getTitle().equals(mangaSimpleData.getTitle()));
            if (!containsByTitle) {
                listDiff.add(mangaSimpleData);
            }
        }
        return listDiff;
    }

}
