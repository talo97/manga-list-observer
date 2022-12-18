package com.mangalist.manga.adapter.websitescrapper.impl;

import com.mangalist.manga.adapter.websitescrapper.WebScrapperUtils;
import com.mangalist.manga.domain.model.value.searcher.MangaChapterData;
import com.mangalist.manga.domain.model.value.searcher.MangaDetailedData;
import com.mangalist.manga.domain.model.value.searcher.MangaSimpleData;
import com.mangalist.manga.domain.ports.MangaWebsiteSearcher;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

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
    @SneakyThrows
    public Iterable<MangaSimpleData> listAllManga() {
        Document document = scrapperUtils.createJsoupConnection(LIST_ALL_CHAPTERS_FIRST_PAGE_URL).get();
        List<MangaSimpleData> mangaSimpleDataList = new ArrayList<>();
        boolean nextPageExist = true;
        while (nextPageExist) {
            Elements mangaList = document.select(".listupd").select(".bsx");
            for (Element element : mangaList) {
                String url = element.select("a[href]").attr("abs:href");
                String title = element.select(".tt").text();
                String latestChapter = element.select(".epxs").text();
                MangaSimpleData mangaSimpleData = MangaSimpleData.createSimpleMangaData(title, url, latestChapter);
                mangaSimpleDataList.add(mangaSimpleData);
            }
            nextPageExist = document.select("a[href].r:contains(Next)").size() > 0;
            if (nextPageExist) {
                scrapperUtils.randomSleep(300, 1000);
                String nextPageUrl = document.select("a[href].r:contains(Next)").attr("abs:href");
                document = scrapperUtils.createJsoupConnection(nextPageUrl).get();
            }
        }
        return mangaSimpleDataList;
    }

    @Override
    public MangaDetailedData getDetailedInformation(MangaSimpleData simpleData) {
        // TODO::implement
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Iterable<MangaChapterData> listAllChapters(MangaSimpleData mangaPageUrl) {
        // TODO::implement
        throw new UnsupportedOperationException("TODO");
    }

}