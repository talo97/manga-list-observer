package com.mangalist.manga.domain.model;

import com.mangalist.manga.domain.model.value.MangaTitle;
import com.mangalist.manga.domain.model.value.MangaWebsiteId;
import com.mangalist.manga.domain.model.value.Website;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Artur Talik
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MangaWebsite {

    public static MangaWebsite createNewEntity(Website website,
                                               MangaTitle mangaTitle) {
        return createFromExistingEntity(MangaWebsiteId.newEntity(), website, mangaTitle);
    }

    public static MangaWebsite createFromExistingEntity(MangaWebsiteId mangaWebsiteId,
                                                        Website website,
                                                        MangaTitle mangaTitle) {
        return new MangaWebsite(mangaWebsiteId, website, mangaTitle);
    }

    private MangaWebsiteId mangaWebsiteId;
    private Website website;
    private MangaTitle mangaTitle;

}
