package com.mesh.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Speciality extends BaseEntity {
    private String name;

    @Builder
    public Speciality(Long id, String name) {
        super(id);
        this.name = name;
    }
}
