package com.mangalist.manga.adapter.persistence;

import com.mangalist.common.entity.CommonEntity;
import com.mangalist.manga.domain.model.WebsiteType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Artur Talik
 */
@Getter
@Setter
@Entity(name = "website")
class WebsiteEntity extends CommonEntity {

    @Column(name = "url")
    private String url;

    @Column(name = "website_type")
    private WebsiteType websiteType;

}
