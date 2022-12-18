package com.mangalist.common;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * @author Artur Talik
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Transactional
public @interface UseCase {

    /*
        TODO:: can remove @Component annotation and add following code to the configuration or main class:

        @ComponentScan(basePackages = {"*"},
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = {MyCustomComponent.class}))

        It would decouple Spring framework from domain layer completely but w/e
     */

}
