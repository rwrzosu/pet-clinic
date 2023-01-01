package com.mesh.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
    private Owner owner;
    private PetType type;
    private LocalDate birthDate;
}
