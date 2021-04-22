package com.mesh.petclinic.controllers;

import com.mesh.petclinic.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    ModelAndView defaultExceptionHandler(Exception exp) {
        ModelAndView mav = new ModelAndView("customError");
        mav.addObject("errorMsg", exp.toString());
        return mav;
    }

    @ExceptionHandler(NotFoundException.class)
    ModelAndView notFoundExceptionHandler(Exception exp) {
        ModelAndView mav = new ModelAndView("customError");
        mav.addObject("errorMsg", "NFE: " + exp.toString());
        return mav;
    }
}
