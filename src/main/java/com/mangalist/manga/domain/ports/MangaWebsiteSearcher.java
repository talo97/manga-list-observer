package com.mangalist.manga.domain.ports;

import com.mangalist.manga.domain.model.value.searcher.MangaChapterData;
import com.mangalist.manga.domain.model.value.searcher.MangaDetailedData;
import com.mangalist.manga.domain.model.value.searcher.MangaSimpleData;

/**
 * @author Artur Talik
 */
public interface MangaWebsiteSearcher {

    Iterable<MangaSimpleData> listAllManga();

    MangaDetailedData getDetailedInformation(MangaSimpleData simpleData);

    Iterable<MangaChapterData> listAllChapters(MangaSimpleData mangaPageUrl);

}