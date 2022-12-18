package com.mangalist.manga.domain.usecase;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.Website;
import com.mangalist.manga.domain.model.value.MangaId;

import java.util.Optional;

/**
 * @author Artur Talik
 */
public interface FindMangaUseCase {

    /**
     * Finds manga by ID. If manga with given ID doesn't exist returns {@code Optional.empty()}
     */
    Optional<Manga> findById(MangaId mangaId);

    /**
     * Lists all manga already registered in the system.
     */
    Iterable<Manga> listRegisteredManga();

    /**
     * Lists all manga that are found in given in the parameter website.
     */
    Iterable<Manga> listMangaSupportedByWebsite(Website website);

}
