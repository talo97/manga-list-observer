package com.mangalist.manga.domain.ports.usecase;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.Website;
import com.mangalist.manga.domain.model.searcher.MangaSimpleData;

import java.io.IOException;
import java.util.List;

/**
 * @author Artur Talik
 */
public interface FindMangaUseCase {

    /**
     * Lists all manga already registered in the system.
     */
    List<Manga> listAllManga();

    /**
     * Lists all manga that are found in given in the parameter website.
     */
    List<Manga> listAllMangaSupportedByWebsite(Website website);

    /**
     * Looks for unregistered yet in the system manga entities for given in the parameter website type.
     */
    List<MangaSimpleData> findNotRegisteredManga(Website websiteType) throws IOException;

}
