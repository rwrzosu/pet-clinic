package com.mesh.petclinic.model;


import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {})
@Entity
public class PetType extends BaseEntity {
    private String name;

    @Override
    public String toString() {
        return getName();
    }

    @Builder
    private PetType(Long id, String name) {
        super(id);
        this.name = name;
    }
}
