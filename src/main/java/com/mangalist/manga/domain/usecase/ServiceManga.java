package com.mangalist.manga.domain.usecase;

import com.mangalist.common.UseCase;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.MangaWebsite;
import com.mangalist.manga.domain.model.value.MangaPublicationStatus;
import com.mangalist.manga.domain.model.value.MangaTitle;
import com.mangalist.manga.domain.model.value.Website;
import com.mangalist.manga.domain.model.value.MangaId;
import com.mangalist.manga.domain.ports.MangaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author Artur Talik
 */
@UseCase
@RequiredArgsConstructor
public class ServiceManga implements FindMangaUseCase, ManageMangaUseCase {

    private final MangaRepository mangaRepository;

    @Override
    public Optional<Manga> findById(MangaId mangaId) {
        return mangaRepository.findById(mangaId);
    }

    @Override
    public Iterable<Manga> listRegisteredManga() {
        return mangaRepository.findAll();
    }

    @Override
    public Iterable<Manga> listMangaSupportedByWebsite(Website website) {
        return mangaRepository.listByWebsite(website);
    }

    @Override
    public Manga createNewManga(Manga manga) {
        // TODO:: add validation (maybe duplicate titles not allowed?)
        return mangaRepository.saveOrUpdate(manga);
    }

    @Override
    public Manga changeStatus(Manga manga, MangaPublicationStatus mangaPublicationStatus) {
        manga.changeStatus(mangaPublicationStatus);
        return mangaRepository.saveOrUpdate(manga);
    }

    @Override
    public Manga addSupportedWebsite(Manga manga, MangaWebsite mangaWebsite) {
        manga.addSupportedWebsite(mangaWebsite);
        return mangaRepository.saveOrUpdate(manga);
    }

    @Override
    public Manga selectPrimaryTitle(Manga manga, MangaTitle mangaTitle) {
        manga.selectPrimaryTitle(mangaTitle);
        return mangaRepository.saveOrUpdate(manga);
    }

}
