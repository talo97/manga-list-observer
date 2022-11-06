package com.mangalist.manga.adapter.websitescrapper.impl;

import com.mangalist.manga.adapter.websitescrapper.WebScrapperUtils;
import com.mangalist.manga.domain.model.searcher.MangaChapterData;
import com.mangalist.manga.domain.model.searcher.MangaDetailedData;
import com.mangalist.manga.domain.model.searcher.MangaSimpleData;
import com.mangalist.manga.domain.ports.MangaWebsiteSearcher;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Talik
 */
@Component
public class AsuraScanSearcher implements MangaWebsiteSearcher {

    private final static String BASE_URL = "https://asura.gg/";
    private final static String LIST_ALL_CHAPTERS_FIRST_PAGE_URL = "https://asura.gg/manga/?page=1&order=update";

    private final WebScrapperUtils scrapperUtils;

    public AsuraScanSearcher(WebScrapperUtils scrapperUtils) {
        this.scrapperUtils = scrapperUtils;
    }

    @Override
    public Iterable<MangaSimpleData> listAllManga() throws IOException {
        Document document = scrapperUtils.createJsoupConnection(LIST_ALL_CHAPTERS_FIRST_PAGE_URL).get();
        List<MangaSimpleData> mangaSimpleDataList = new ArrayList<>();
        boolean nextPageExist = true;
        while (nextPageExist) {
            Elements mangaList = document.select(".listupd").select(".bsx");
            for (Element element : mangaList) {
                String url = element.select("a[href]").attr("abs:href");
                String title = element.select(".tt").text();
                String latestChapter = element.select(".epxs").text();
                MangaSimpleData mangaSimpleData = MangaSimpleData.builder()
                        .pageUrl(url)
                        .title(title.trim())
                        .latestChapter(latestChapter)
                        .build();
                mangaSimpleDataList.add(mangaSimpleData);
            }
            nextPageExist = document.select("a[href].r:contains(Next)").size() > 0;
            if (nextPageExist) {
                scrapperUtils.randomSleep(500, 2000);
                String nextPageUrl = document.select("a[href].r:contains(Next)").attr("abs:href");
                document = scrapperUtils.createJsoupConnection(nextPageUrl).get();
            }
        }
        return mangaSimpleDataList;
    }

    @Override
    public MangaDetailedData getDetailedInformation(MangaSimpleData simpleData) throws IOException {
        // TODO::implement
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Iterable<MangaChapterData> listAllChapters(MangaSimpleData mangaPageUrl) throws IOException{
        // TODO::implement
        throw new UnsupportedOperationException("TODO");
    }

}
