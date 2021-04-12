package com.mesh.petclinic.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    ModelAndView defaultExceptionHandler(Exception exp){
        ModelAndView mav = new ModelAndView("error");
        return mav;
    }
}
