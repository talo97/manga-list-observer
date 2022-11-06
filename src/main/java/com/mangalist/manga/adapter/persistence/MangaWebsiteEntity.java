package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.entity.CommonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Artur Talik
 */
@Getter
@Setter
@Entity(name = "manga_website")
class MangaWebsiteEntity extends CommonEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id")
    private MangaEntity mangaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "website_id")
    private WebsiteEntity website;

}
