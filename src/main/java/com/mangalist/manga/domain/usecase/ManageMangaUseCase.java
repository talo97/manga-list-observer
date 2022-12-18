package com.mangalist.manga.domain.usecase;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.MangaWebsite;
import com.mangalist.manga.domain.model.value.MangaPublicationStatus;
import com.mangalist.manga.domain.model.value.MangaTitle;

/**
 * @author Artur Talik
 */
public interface ManageMangaUseCase {

    Manga createNewManga(Manga manga);

    Manga changeStatus(Manga manga, MangaPublicationStatus mangaPublicationStatus);

    Manga addSupportedWebsite(Manga manga, MangaWebsite mangaWebsite);

    Manga selectPrimaryTitle(Manga manga, MangaTitle mangaTitle);

    //TODO:: this one
//    Manga mergeMangaAndAddAsAlternateTitle(Manga sourceManga, Manga targetManga);

}
