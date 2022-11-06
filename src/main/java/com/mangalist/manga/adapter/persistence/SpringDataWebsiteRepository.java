package com.mangalist.manga.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Artur Talik
 */
@Repository
interface SpringDataWebsiteRepository extends JpaRepository<WebsiteEntity, Integer> {
}
