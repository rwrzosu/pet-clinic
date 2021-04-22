package com.mesh.petclinic.controllers;

import com.mesh.petclinic.exceptions.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping({"oups"})
    public String oups() {
        return "notimplemented";
    }

    @GetMapping({"oups2"})
    public String oups2() {
        throw new NotFoundException("kaboom");
    }
}
