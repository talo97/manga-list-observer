package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.entity.CommonEntity;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.MangaStatus;
import com.mangalist.manga.domain.model.value.MangaType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Artur Talik
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "manga")
class MangaEntity extends CommonEntity {

    public static MangaEntity of(Manga domainEntity) {
        return new MangaEntity(
                domainEntity.getMangaId().getId(),
                domainEntity.getMangaTitle().getTitle(),
                domainEntity.getAuthor().getName(),
                domainEntity.getType(),
                domainEntity.getMangaStatus());
    }

    private MangaEntity(int id, String name, String author, MangaType type, MangaStatus mangaStatus) {
        setId(id);
        this.name = name;
        this.author = author;
        this.type = type;
        this.mangaStatus = mangaStatus;
    }

    @Column(name = "name", unique = true)
    private String name = "";

    @Column(name = "author")
    private String author = "";

    @Column(name = "type")
    private MangaType type = MangaType.UNDEFINED;

    @Column(name = "status")
    private MangaStatus mangaStatus = MangaStatus.UNDEFINED;

    @OneToMany(mappedBy = "mangaEntity", fetch = FetchType.LAZY)
    private List<MangaWebsiteEntity> mangaWebsiteList;

}
