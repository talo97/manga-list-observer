package com.mangalist.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Artur Talik
 */
@Data
@AllArgsConstructor
public class ValidateResponse {

    private boolean valid;
    private String errorReason;

    public static ValidateResponse createOk(){
        return new ValidateResponse(true, "");
    }

    public static ValidateResponse createError(String reason){
        return new ValidateResponse(false, reason);
    }

}
