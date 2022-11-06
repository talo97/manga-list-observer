package com.mangalist.manga.domain.ports;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.Website;

import java.util.List;

/**
 * @author Artur Talik
 */
public interface MangaWebsiteRepository {

    List<Manga> listSupportedManga(Website website);
}
