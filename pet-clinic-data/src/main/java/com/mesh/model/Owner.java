package com.mesh.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;

    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner owner)) return false;

        return getId().equals(owner.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
