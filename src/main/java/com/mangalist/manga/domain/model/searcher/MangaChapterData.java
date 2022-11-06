package com.mangalist.manga.domain.model.searcher;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Artur Talik
 */
@Data
public class MangaChapterData {

    private String number;
    private LocalDateTime releaseDate;

}
