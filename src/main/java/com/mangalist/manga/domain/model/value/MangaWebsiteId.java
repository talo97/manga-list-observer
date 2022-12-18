package com.mangalist.manga.domain.model.value;

import lombok.Value;

/**
 * @author Artur Talik
 */
@Value(staticConstructor = "of")
public class MangaWebsiteId {

    public static MangaWebsiteId newEntity() {
        return MangaWebsiteId.of(0);
    }

    int id;

}
