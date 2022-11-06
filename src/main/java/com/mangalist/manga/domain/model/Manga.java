package com.mangalist.manga.domain.model;

import lombok.Data;

/**
 * @author Artur Talik
 */
@Data
public class Manga {

    private int id;
    private String name;
    private String author;
    private MangaType type;

}
