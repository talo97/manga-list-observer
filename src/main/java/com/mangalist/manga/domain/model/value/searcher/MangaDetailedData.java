package com.mangalist.manga.domain.model.value.searcher;

import lombok.Value;

import java.time.LocalDateTime;

/**
 * @author Artur Talik
 */
@Value
public class MangaDetailedData {

    String title;
    String pageUrl;
    String author;
    String artist;
    String serialization;
    String thumbnailUrl;
    LocalDateTime lastUpdateDate;
    LocalDateTime firstPostDate;

}
