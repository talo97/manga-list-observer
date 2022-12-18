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
                                        MangaPublicationStatus mangaPublicationStatus,
                                        List<MangaWebsite> websiteList) {
        return createFromExistingEntity(MangaId.newEntity(), name, author, mangaType, mangaPublicationStatus, websiteList);
    }

    public static Manga createFromExistingEntity(MangaId id,
                                                 MangaTitle name,
                                                 Author author,
                                                 MangaType mangaType,
                                                 MangaPublicationStatus mangaPublicationStatus,
                                                 List<MangaWebsite> websiteList) {
        return new Manga(id, name, author, mangaType, mangaPublicationStatus, websiteList);
    }

    private MangaId mangaId;
    private MangaTitle mangaTitle;
    private Author author;
    private MangaType type;
    private MangaPublicationStatus mangaPublicationStatus;
    private List<MangaWebsite> websiteList;

    public void changeStatus(MangaPublicationStatus mangaPublicationStatus) {
        this.mangaPublicationStatus = mangaPublicationStatus;
    }

    public void addSupportedWebsite(MangaWebsite mangaWebsiteToAdd) {
        if (websiteList.stream().anyMatch(mangaWebsite ->
                mangaWebsite.getWebsite().equals(mangaWebsiteToAdd.getWebsite()))) {
            String errorMessage =
                    "Website is already registered for this manga. Duplicated website records aren't allowed";
            throw new IllegalArgumentException(errorMessage);
        }
        websiteList.add(mangaWebsiteToAdd);
    }

    public void selectPrimaryTitle(MangaTitle primaryTitle) {
        mangaTitle = primaryTitle;
    }

}
