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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * @author Artur Talik
 */
@RestController
@Transactional
@RequestMapping("/api")
@RequiredArgsConstructor
class MangaController {

    private final FindMangaUseCase findMangaUseCase;
    private final ManageMangaUseCase manageMangaUseCase;
    private final SearchWebsiteMangaUseCase searchWebsiteMangaUseCase;
    private final MangaModelAssembler mangaModelAssembler;

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

}
