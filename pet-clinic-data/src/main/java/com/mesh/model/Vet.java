package com.mesh.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Vet extends Person {

    @Builder
    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
