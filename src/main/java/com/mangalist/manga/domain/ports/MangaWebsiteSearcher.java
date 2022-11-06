package com.mangalist.manga.domain.ports;

import com.mangalist.manga.domain.model.searcher.MangaChapterData;
import com.mangalist.manga.domain.model.searcher.MangaDetailedData;
import com.mangalist.manga.domain.model.searcher.MangaSimpleData;

import java.io.IOException;

/**
 * @author Artur Talik
 */
public interface MangaWebsiteSearcher {

    Iterable<MangaSimpleData> listAllManga() throws IOException;

    MangaDetailedData getDetailedInformation(MangaSimpleData simpleData) throws IOException;

    Iterable<MangaChapterData> listAllChapters(MangaSimpleData mangaPageUrl) throws IOException;

}