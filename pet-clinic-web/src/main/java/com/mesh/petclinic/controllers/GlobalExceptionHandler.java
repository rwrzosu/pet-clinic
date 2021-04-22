package com.mesh.petclinic.controllers;

import com.mesh.petclinic.exceptions.NotFoundException;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Environment environment;

    public GlobalExceptionHandler(Environment environment) {
        this.environment = environment;
    }

    private boolean isDebugActive() {
        return Arrays.asList(this.environment.getActiveProfiles()).contains("debug");
    }

    private void addStackTrace(ModelAndView mav, Exception exp) {
        if (isDebugActive()) {
            mav.addObject("stackTrace", Arrays.stream(exp.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.joining("\n")));
        }
    }

    private void addErrorMsg(ModelAndView mav, String msg) {
        mav.addObject("errorMsg", msg);
    }


    @ExceptionHandler(RuntimeException.class)
    ModelAndView defaultExceptionHandler(Exception exp) {
        ModelAndView mav = new ModelAndView("customError");
        this.addErrorMsg(mav, exp.toString());
        this.addStackTrace(mav, exp);
        return mav;
    }

    @ExceptionHandler(NotFoundException.class)
    ModelAndView notFoundExceptionHandler(Exception exp) {
        ModelAndView mav = new ModelAndView("customError");
        this.addErrorMsg(mav, "NFE: " + exp.toString());
        this.addStackTrace(mav, exp);
        return mav;
    }


    @ExceptionHandler(NumberFormatException.class)
    ModelAndView numberFormatExceptionHandler(Exception exp) {
        ModelAndView mav = new ModelAndView("customError");
        this.addErrorMsg(mav, "Can not parse number : '" + exp.getMessage() + "'");
        this.addStackTrace(mav, exp);
        return mav;
    }
}
