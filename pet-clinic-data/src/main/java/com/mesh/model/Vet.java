package com.mesh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vet extends Person {

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
