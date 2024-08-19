package com.mesh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner extends Person {

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
