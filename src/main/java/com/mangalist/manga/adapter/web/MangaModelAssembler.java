package com.mangalist.manga.adapter.web;

import com.mangalist.manga.domain.model.Manga;
import lombok.NonNull;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Artur Talik
 */
@Component
class MangaModelAssembler implements RepresentationModelAssembler<Manga, EntityModel<Manga>> {

    @NonNull
    @Override
    public EntityModel<Manga> toModel(@NonNull Manga entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(MangaController.class)
                        .findAll())
                        .withRel("manga"),
                linkTo(methodOn(MangaController.class)
                        .findById(entity.getMangaId().getId()))
                        .withSelfRel());
    }

    @NonNull
    @Override
    public CollectionModel<EntityModel<Manga>> toCollectionModel(@NonNull Iterable<? extends Manga> entities) {
        List<EntityModel<Manga>> mappedList = new ArrayList<>();
        entities.forEach(mangaEntity -> mappedList.add(toModel(mangaEntity)));
        return CollectionModel.of(
                mappedList,
                linkTo(methodOn(MangaController.class)
                        .findAll())
                        .withSelfRel());
    }
}
