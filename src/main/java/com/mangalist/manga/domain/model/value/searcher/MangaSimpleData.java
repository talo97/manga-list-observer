package com.mangalist.manga.domain.model.value.searcher;

import lombok.Value;

/**
 * @author Artur Talik
 */
@Value
public class MangaSimpleData {

    public static MangaSimpleData createSimpleMangaData(String title, String url, String latestChapter) {
        return new MangaSimpleData(title, url, latestChapter);
    }

    String title;
    String pageUrl;
    String latestChapter;

}
