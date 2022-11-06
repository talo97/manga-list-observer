package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.entity.CommonEntity;
import com.mangalist.manga.domain.model.MangaType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Artur Talik
 */
@Getter
@Setter
@Entity(name = "manga")
class MangaEntity extends CommonEntity {

    @Column(name = "name", unique = true)
    private String name = "";

    @Column(name = "author")
    private String author = "";

    @Column(name = "type")
    private MangaType type;

}
