package com.mesh.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetType extends BaseEntity {
    private String name;

    @Builder
    public PetType(Long id, String name) {
        super(id);
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
