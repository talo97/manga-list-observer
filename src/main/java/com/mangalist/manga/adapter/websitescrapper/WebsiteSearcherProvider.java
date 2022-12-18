package com.mangalist.manga.adapter.websitescrapper;

import com.mangalist.manga.adapter.websitescrapper.impl.AsuraScanSearcher;
import com.mangalist.manga.domain.model.value.Website;
import com.mangalist.manga.domain.ports.MangaWebsiteSearcher;
import com.mangalist.manga.domain.ports.WebsiteSearcherFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Artur Talik
 */
@Component
@RequiredArgsConstructor
public class WebsiteSearcherProvider implements WebsiteSearcherFactory {

    private final AsuraScanSearcher asuraScanSearcher;

    @Override
    public MangaWebsiteSearcher createWebsiteSearcher(Website website) {
        if (website == Website.ASURA_SCAN) {
            return asuraScanSearcher;
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
