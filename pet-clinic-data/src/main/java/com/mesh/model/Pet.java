package com.mesh.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Pet extends BaseEntity {
    private String name;
    private LocalDate birthDate;
    private Owner owner;
    private PetType petType;

    @Builder
    public Pet(Long id, LocalDate birthDate, Owner owner, PetType petType, String name) {
        super(id);
        this.birthDate = birthDate;
        this.owner = owner;
        this.petType = petType;
        this.name = name;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;

        return getId().equals(pet.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
