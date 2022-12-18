package com.mangalist.manga.domain.model;

import com.mangalist.manga.domain.model.value.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author Artur Talik
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Manga {

    public static Manga createNewEntity(MangaTitle name,
                                        Author author,
                                        MangaType mangaType,
                                        MangaStatus mangaStatus,
                                        List<MangaWebsite> websiteList) {
        return createFromExistingEntity(MangaId.newEntity(), name, author, mangaType, mangaStatus, websiteList);
    }

    public static Manga createFromExistingEntity(MangaId id,
                                                 MangaTitle name,
                                                 Author author,
                                                 MangaType mangaType,
                                                 MangaStatus mangaStatus,
                                                 List<MangaWebsite> websiteList) {
        return new Manga(id, name, author, mangaType, mangaStatus, websiteList);
    }

    private MangaId mangaId;
    private MangaTitle mangaTitle;
    private Author author;
    private MangaType type;
    private MangaStatus mangaStatus;
    private List<MangaWebsite> websiteList;

    public void changeStatus(MangaStatus mangaStatus) {
        this.mangaStatus = mangaStatus;
    }

    public void addSupportedWebsite(Website website, MangaTitle mangaTitle) {
        if (websiteList.stream().anyMatch(mangaWebsite ->
                mangaWebsite.getMangaTitle().equals(mangaTitle)
                        && mangaWebsite.getWebsite().equals(website))) {
            throw new IllegalArgumentException("Such record already exist in the system. Duplicated data not allowed");
        }
        websiteList.add(MangaWebsite.createNewEntity(website, mangaTitle));
    }

    public void selectPrimaryTitle(MangaTitle primaryTitle) {
        mangaTitle = primaryTitle;
    }

}
