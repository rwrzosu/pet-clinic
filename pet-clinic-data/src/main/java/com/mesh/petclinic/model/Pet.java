package com.mesh.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Pet extends BaseEntity {
    private String name;
    private Owner owner;
    private PetType type;
    private LocalDate birthDate;
}
