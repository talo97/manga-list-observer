package com.mangalist.manga.domain.model.value;

import lombok.Value;

/**
 * @author Artur Talik
 */
@Value(staticConstructor = "of")
public class MangaId {

    public static MangaId newEntity() {
        return MangaId.of(0);
    }

    int id;

}
