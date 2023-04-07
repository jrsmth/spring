package com.jrsmiffy.springguru.recipes.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@ControllerAdvice @Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(NumberFormatException.class) @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleNumberFormatException(Exception exception) {
        log.error("Handling NumberFormatException!");

        return new ModelAndView("error/bad-request", Map.of("exception", exception));
    }
}
