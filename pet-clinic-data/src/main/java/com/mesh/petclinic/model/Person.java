package com.mesh.petclinic.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;

    Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
