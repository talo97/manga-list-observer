package com.mangalist.manga.domain.ports;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.MangaId;
import com.mangalist.manga.domain.model.value.Website;

import java.util.List;
import java.util.Optional;

/**
 * @author Artur Talik
 */
public interface MangaRepository {

    Optional<Manga> findById(MangaId mangaId);

    Iterable<Manga> findAll();

    List<Manga> listByWebsite(Website website);

    Manga saveOrUpdate(Manga manga);

}
