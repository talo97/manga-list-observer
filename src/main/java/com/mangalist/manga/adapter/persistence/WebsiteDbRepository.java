package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.PersistenceAdapter;
import com.mangalist.manga.domain.ports.WebsiteRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author Artur Talik
 */
@PersistenceAdapter
@RequiredArgsConstructor
class WebsiteDbRepository implements WebsiteRepository {

    private final SpringDataWebsiteRepository websiteRepository;

}
