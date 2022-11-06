package com.mangalist.manga.domain.ports;

import com.mangalist.manga.domain.model.WebsiteType;

/**
 * @author Artur Talik
 */
public interface WebsiteSearcherFactory {

    MangaWebsiteSearcher createWebsiteSearcher(WebsiteType websiteType);

}
