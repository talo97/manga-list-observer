package com.mangalist;

import com.mangalist.manga.domain.model.searcher.MangaSimpleData;
import com.mangalist.manga.adapter.websitescrapper.WebScrapperUtils;
import com.mangalist.manga.adapter.websitescrapper.impl.AsuraScanSearcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author Artur Talik
 */
@SpringBootApplication
public class MangaListObserverApplication {

    /*
     *TODO:
     * - Implement rotating proxy for web scrapping
     * - Implement user and observing module
     * - Add preferred sites for observed manga
     *
     * regex for taking number out of chapter name
     *  private final static String FLOATING_POINT_REGEX = "(?:\\d+(?:\\.\\d*)?|\\.\\d+)";
     *  private final static Pattern FLOATING_POINT_PATTERN = Pattern.compile(FLOATING_POINT_REGEX);
     *
     * QUICK NOTES:
     * MangaEntity
     * MangaChapterEntity
     * Website enum and implementation for web scraping for each website
     * Table for manga and websites (manga can be found on various websites so many to many connection here)
     * User
     * User observed manga (add stalled/dropped/finished/waiting for next season etc.)
     * User last read chapter for manga
     *
     */

    public static void main(String[] args) {
        // TODO:: test only, delete later
//        AsuraScanSearcher test = new AsuraScanSearcher(new WebScrapperUtils());
//        try {
//            Iterable<MangaSimpleData> mangaSimpleData = test.listAllManga();
//            for (MangaSimpleData mangaSimpleDatum : mangaSimpleData) {
//                System.out.println(mangaSimpleDatum.getTitle());
//                System.out.println(mangaSimpleDatum.getPageUrl());
//                System.out.println(mangaSimpleDatum.getLatestChapter());
//
//                System.out.println("\n\n");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        SpringApplication.run(MangaListObserverApplication.class, args);
    }

}
