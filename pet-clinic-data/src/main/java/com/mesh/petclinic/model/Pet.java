package com.mesh.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Pet extends BaseEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;
    private LocalDate birthDate;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
