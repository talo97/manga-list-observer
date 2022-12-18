package com.mangalist.common.error;

/**
 * @author Artur Talik
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> clazz, int id) {
        super(String.format("%s record with ID %s is not present in database.", clazz.getSimpleName(), id));
    }

}
