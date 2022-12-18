package com.mangalist.manga.adapter.web;

import com.mangalist.common.error.EntityNotFoundException;
import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.model.value.*;
import com.mangalist.manga.domain.usecase.FindMangaUseCase;
import com.mangalist.manga.domain.usecase.ManageMangaUseCase;
import com.mangalist.manga.domain.usecase.SearchWebsiteMangaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * @author Artur Talik
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class MangaController {

    // TODO:: implement facade to not worry here about mapping domain to response model
    private final Facade facade;
    private final FindMangaUseCase findMangaUseCase;
    private final ManageMangaUseCase manageMangaUseCase;
    private final SearchWebsiteMangaUseCase searchWebsiteMangaUseCase;
    private final MangaModelAssembler mangaModelAssembler;

    private final TransactionTemplate template;

    @GetMapping("/manga")
    public CollectionModel<EntityModel<Manga>> findAll() {
        return mangaModelAssembler.toCollectionModel(
                findMangaUseCase.listRegisteredManga());
    }

    @GetMapping("/manga/{id}")
    public EntityModel<Manga> findById(@PathVariable int id) {
        Manga entity = findMangaUseCase.findById(MangaId.of(id))
                .orElseThrow(() -> new EntityNotFoundException(Manga.class, id));
        return mangaModelAssembler.toModel(entity);
    }

    @GetMapping(value = "/manga", params = "website")
    public CollectionModel<EntityModel<Manga>> findAllByWebsite(@RequestParam(name = "website") Website website) {
        return mangaModelAssembler.toCollectionModel(
                findMangaUseCase.listMangaSupportedByWebsite(website));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
//        Manga manga = manageMangaUseCase.createNewManga(Manga.createNewEntity(
//                MangaTitle.of("TitleTest"),
//                Author.of("AuthorTest"),
//                MangaType.MANGA,
//                MangaStatus.ONGOING,
//                Collections.emptyList()));
//        // should rollback!!
//        if (true) throw new IllegalArgumentException("ROLLBACK PLZ");

        facade.test2();
//        template.execute(status -> {
//        // Testing rollbacks
//        Manga manga = manageMangaUseCase.createNewManga(Manga.createNewEntity(
//                MangaTitle.of("TitleTest"),
//                Author.of("AuthorTest"),
//                MangaType.MANGA,
//                MangaStatus.ONGOING,
//                Collections.emptyList()));
//        // should rollback!!
//        if (true) throw new IllegalArgumentException("ROLLBACK PLZ");
//            manageMangaUseCase.addSupportedWebsite(manga, Website.ASURA_SCAN, MangaTitle.of("TitleTest"));
//            return null;
//        });


        // Testing web scraping
//        Website website = new Website();
//        //TEST
//        website.setWebsiteType(WebsiteType.ASURA_SCAN);
//        website.setId(WebsiteId.of(1));
//        website.setListAllChaptersUrl(WebsiteUrlInformation.of("xd",
//                "https://asura.gg/manga/?page=1&order=update"));
//        List<MangaSimpleData> mangaSimpleData = searchWebsiteMangaUseCase.searchForNewMangaEntries(website);
//        System.out.println("test");
//        for (MangaSimpleData mangaSimpleDatum : mangaSimpleData) {
//            System.out.println(mangaSimpleDatum);
//        }
        return ResponseEntity.ok().build();
    }


//    @PostMapping("/manga")
//    ResponseEntity<EntityModel<MangaEntity>> addNewManga(@RequestBody MangaEntity manga) {
//        MangaEntity mangaEntity = mangaService.save(manga);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(mangaModelAssembler.toModel(mangaEntity));
//    }
//
//    @PutMapping("/manga/{id}")
//    ResponseEntity<?> editManga(@PathVariable int id, @RequestBody MangaEntity manga) {
//        MangaEntity oldEntity = mangaService.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(MangaEntity.class, id));
//        mangaService.update(oldEntity, manga);
//
//       return ResponseEntity.status(HttpStatus.NO_CONTENT)
//               .build();
//    }


}
