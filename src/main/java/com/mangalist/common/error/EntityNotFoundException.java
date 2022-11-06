package com.mangalist.common.error;

import com.mangalist.common.entity.CommonEntity;

/**
 * @author Artur Talik
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<? extends CommonEntity> clazz, int id) {
        super(String.format("%s record with ID %s is not present in database.", clazz.getSimpleName(), id));
    }

}
