package com.mangalist.common.configuration;

import com.mangalist.common.error.EntityNotFoundException;
import com.mangalist.common.error.ValidateException;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Artur Talik
 */
@SuppressWarnings("unused")
@ControllerAdvice
public class ExceptionInterceptor {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Problem handleNotFoundException(Exception ex) {
        return Problem.create()
                .withTitle("Entity not found")
                .withDetail(ex.getLocalizedMessage());
    }

    @ResponseBody
    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Problem handleValidateException(Exception ex) {
        return Problem.create()
                .withTitle("Validate exception")
                .withDetail(ex.getLocalizedMessage());
    }

}
