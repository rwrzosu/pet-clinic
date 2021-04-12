package com.mesh.petclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@ToString(callSuper = true)
@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets = new HashSet<>();

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Builder
    private Owner(Long id, String firstName, String lastName, String address, String city, String telephone) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public void addPet(Pet pet) {
        pet.setOwner(this);
        pets.add(pet);
    }

    public Pet getPet(String name) {
        return this.pets.stream().filter(pet -> Objects.equals(pet.getName(), name)).findAny().orElse(null);
    }
}
