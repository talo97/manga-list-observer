package com.mangalist.manga.domain.model;

import lombok.Data;

/**
 * @author Artur Talik
 */
@Data
public class Website {

    private int id;
    private WebsiteType websiteType;
    private String listAllChaptersUrl;

}
