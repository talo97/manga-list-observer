package com.mangalist.manga.domain.model.value.searcher;

import lombok.Value;

import java.time.LocalDateTime;

/**
 * @author Artur Talik
 */
@Value
public class MangaChapterData {

    String number;
    LocalDateTime releaseDate;

}
