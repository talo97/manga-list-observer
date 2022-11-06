package com.mangalist.manga.domain.model.searcher;

import lombok.Builder;
import lombok.Data;

/**
 * @author Artur Talik
 */
@Data
@Builder
public class MangaSimpleData {

    private String title;
    private String pageUrl;
    private String latestChapter;

}
