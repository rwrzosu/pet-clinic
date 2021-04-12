package com.mesh.petclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"owner"})
@Entity
public class Pet extends BaseEntity {
    private String name;
    @ManyToOne
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    private Set<Visit> visits = new HashSet<>();

    public Pet(PetType petType, Owner owner, LocalDate dob) {
        super();
        this.petType = petType;
        this.owner = owner;
        this.dob = dob;
    }
}
