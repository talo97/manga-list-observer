package com.mangalist.manga.domain.usecase;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.Website;
import com.mangalist.manga.domain.model.value.MangaStatus;
import com.mangalist.manga.domain.model.value.MangaTitle;

/**
 * @author Artur Talik
 */
public interface ManageMangaUseCase {

    Manga createNewManga(Manga manga);

    Manga changeStatus(Manga manga, MangaStatus mangaStatus);

    Manga addSupportedWebsite(Manga manga, Website website, MangaTitle title);

    Manga selectPrimaryTitle(Manga manga, MangaTitle mangaTitle);

    //TODO:: this one
//    Manga mergeMangaAndAddAsAlternateTitle(Manga manga, Manga mangaToMerge);

}
