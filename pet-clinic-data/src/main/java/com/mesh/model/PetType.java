package com.mesh.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class PetType extends BaseEntity {
    private String name;

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }
}
