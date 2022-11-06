package com.mangalist.manga.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Artur Talik
 */
@Repository
interface SpringDataMangaRepository extends JpaRepository<MangaEntity, Integer> {
}
