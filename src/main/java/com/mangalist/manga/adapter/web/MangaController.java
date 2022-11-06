package com.mangalist.manga.adapter.web;

import com.mangalist.manga.domain.model.Manga;
import com.mangalist.manga.domain.ports.usecase.FindMangaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

/**
 * @author Artur Talik
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class MangaController {

    private final FindMangaUseCase findMangaUseCase;
    private final MangaModelAssembler mangaModelAssembler;


    @GetMapping("/manga")
    CollectionModel<EntityModel<Manga>> findAll() {
        return mangaModelAssembler.toCollectionModel(findMangaUseCase.listAllManga());
    }
//
//    @GetMapping("/manga/{id}")
//    EntityModel<MangaEntity> findById(@PathVariable int id) {
//        MangaEntity entity = mangaService.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(MangaEntity.class, id));
//
//        return mangaModelAssembler.toModel(entity);
//    }
//
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
