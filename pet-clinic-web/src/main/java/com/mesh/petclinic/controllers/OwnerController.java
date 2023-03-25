package com.mesh.petclinic.controllers;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model, @RequestParam(required = false) String lastName) {
        if(Objects.nonNull(lastName)){
            model.addAttribute("owners", ownerService.findByLastName(lastName));
        }else {
            model.addAttribute("owners", ownerService.findAll());
        }
        return "owners/index";
    }

    @RequestMapping({"find"})
    public String find(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

}
