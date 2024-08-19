package com.mesh.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Pet extends BaseEntity{
    private LocalDate birthDate;
    private Owner owner;
    private PetType petType;
}
