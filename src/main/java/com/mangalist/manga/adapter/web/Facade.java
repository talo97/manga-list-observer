package com.mangalist.manga.adapter.web;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.MangaWebsite;
import com.mangalist.manga.domain.model.value.*;
import com.mangalist.manga.domain.usecase.FindMangaUseCase;
import com.mangalist.manga.domain.usecase.ManageMangaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Talik
 */
//TODO::TEST, delete later or rename and keep
@Component
@RequiredArgsConstructor
public class Facade {

    private final ManageMangaUseCase manageMangaUseCase;
    private final FindMangaUseCase findMangaUseCase;
    private final TransactionTemplate transactionTemplate;

    public void test() {
        List<MangaWebsite> websiteList = new ArrayList<>();
        websiteList.add(MangaWebsite.createNewEntity(Website.ASURA_SCAN, MangaTitle.of("Test fajny jest :)")));
        Manga manga = manageMangaUseCase.createNewManga(Manga.createNewEntity(
                MangaTitle.of("TitleTest"),
                Author.of("AuthorTest"),
                MangaType.MANGA,
                MangaStatus.ONGOING,
                websiteList));
        System.out.println(manga);
        // should rollback!!
//        if (true) throw new IllegalArgumentException("ROLLBACK PLZ");
    }

    public void test2() {
        Manga manga = findMangaUseCase.findById(MangaId.of(39)).get();
        manageMangaUseCase.changeStatus(manga, MangaStatus.HIATUS);
    }

}
