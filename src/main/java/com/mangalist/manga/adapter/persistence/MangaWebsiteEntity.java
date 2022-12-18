package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.entity.CommonEntity;
import com.mangalist.manga.domain.model.value.Website;
import lombok.*;

import javax.persistence.*;

/**
 * @author Artur Talik
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "manga_website")
class MangaWebsiteEntity extends CommonEntity {

    public static MangaWebsiteEntity of(int id, MangaEntity mangaEntity, Website website, String url, String title) {
        return new MangaWebsiteEntity(id, mangaEntity, website, url, title);
    }

    private MangaWebsiteEntity(int id, MangaEntity mangaEntity, Website website, String url, String title) {
        setId(id);
        this.mangaEntity = mangaEntity;
        this.website = website;
        this.title = title;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id")
    private MangaEntity mangaEntity;

    @Column(name = "website")
    private Website website;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

}
