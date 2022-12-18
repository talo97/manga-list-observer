package com.mangalist.manga.domain.usecase;

import com.mangalist.manga.domain.model.value.Website;
import com.mangalist.manga.domain.model.value.searcher.MangaSimpleData;

import java.util.List;

/**
 * @author Artur Talik
 */
public interface SearchWebsiteMangaUseCase {

    /**
     * Looks for unregistered yet in the system manga entities for given in the parameter website type.
     */
    List<MangaSimpleData> searchForNewMangaEntries(Website website);

}
