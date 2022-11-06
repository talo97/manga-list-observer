package com.mangalist.manga.domain.ports;

import com.mangalist.manga.domain.model.Manga;

import java.util.List;

/**
 * @author Artur Talik
 */
public interface MangaRepository {

    List<Manga> findAll();

}
