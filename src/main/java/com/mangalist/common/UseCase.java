package com.mangalist.common;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Artur Talik
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {
}
