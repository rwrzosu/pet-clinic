package com.mesh.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Pet extends BaseEntity{
    private LocalDate birthDate;
    private Owner owner;
    private PetType petType;

    @Builder
    public Pet(Long id, LocalDate birthDate, Owner owner, PetType petType) {
        super(id);
        this.birthDate = birthDate;
        this.owner = owner;
        this.petType = petType;
    }
}
