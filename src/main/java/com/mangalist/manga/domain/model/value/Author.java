package com.mangalist.manga.domain.model.value;

import lombok.Value;

/**
 * @author Artur Talik
 */
@Value(staticConstructor = "of")
public class Author {

    String name;

}
