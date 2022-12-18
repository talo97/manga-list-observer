package com.mangalist.manga.domain.model;

import com.mangalist.manga.domain.model.value.MangaTitle;
import com.mangalist.manga.domain.model.value.MangaUrl;
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
                                               MangaUrl mangaUrl,
                                               MangaTitle mangaTitle) {
        return createFromExistingEntity(MangaWebsiteId.newEntity(), website, mangaUrl, mangaTitle);
    }

    public static MangaWebsite createFromExistingEntity(MangaWebsiteId mangaWebsiteId,
                                                        Website website,
                                                        MangaUrl mangaUrl,
                                                        MangaTitle mangaTitle) {
        return new MangaWebsite(mangaWebsiteId, website, mangaUrl, mangaTitle);
    }

    private MangaWebsiteId mangaWebsiteId;
    private Website website;
    private MangaUrl mangaUrl;
    private MangaTitle mangaTitle;

}
