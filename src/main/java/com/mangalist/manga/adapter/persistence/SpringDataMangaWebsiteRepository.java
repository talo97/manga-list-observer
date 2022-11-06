package com.mangalist.manga.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Artur Talik
 */
@Repository
interface SpringDataMangaWebsiteRepository extends JpaRepository<MangaWebsiteEntity, Integer> {

    List<MangaWebsiteEntity> findAllByWebsiteId(Integer websiteEntityId);

}
