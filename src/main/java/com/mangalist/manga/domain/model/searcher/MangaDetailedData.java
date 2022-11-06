package com.mangalist.manga.domain.model.searcher;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Artur Talik
 */
@Data
public class MangaDetailedData {

    private String title;
    private String pageUrl;
    private String author;
    private String artist;
    private String serialization;
    private String thumbnailUrl;
    private LocalDateTime lastUpdateDate;
    private LocalDateTime firstPostDate;

}
