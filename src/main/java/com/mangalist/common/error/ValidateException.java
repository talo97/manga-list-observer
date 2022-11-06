package com.mangalist.common.error;

/**
 * @author Artur Talik
 */
public class ValidateException extends RuntimeException {

    public ValidateException(String reason) {
        super(reason);
    }

}
