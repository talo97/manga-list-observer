package com.mangalist.manga.domain.ports;

import com.mangalist.manga.domain.model.value.Website;

/**
 * @author Artur Talik
 */
public interface WebsiteSearcherFactory {

    MangaWebsiteSearcher createWebsiteSearcher(Website website);

}
