package com.mangalist.manga.domain.usecase;

import com.mangalist.common.UseCase;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.MangaStatus;
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
        return mangaRepository.save(manga);
    }

    @Override
    public Manga changeStatus(Manga manga, MangaStatus mangaStatus) {
        manga.changeStatus(mangaStatus);
        return mangaRepository.save(manga);
    }

    @Override
    public Manga addSupportedWebsite(Manga manga, Website website, MangaTitle title) {
        manga.addSupportedWebsite(website, title);
        return mangaRepository.save(manga);
    }

    @Override
    public Manga selectPrimaryTitle(Manga manga, MangaTitle mangaTitle) {
        manga.selectPrimaryTitle(mangaTitle);
        return mangaRepository.save(manga);
    }
}
