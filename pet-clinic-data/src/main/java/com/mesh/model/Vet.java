package com.mesh.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Vet extends Person {

    private final Set<Speciality> specialities = new HashSet<>();

    @Builder
    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vet vet)) return false;

        return getId().equals(vet.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
