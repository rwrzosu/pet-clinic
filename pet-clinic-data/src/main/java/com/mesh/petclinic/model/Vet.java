package com.mesh.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Vet extends Person {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "vet_speciality",
            joinColumns = @JoinColumn(name = "vet_id")
            , inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }


}
