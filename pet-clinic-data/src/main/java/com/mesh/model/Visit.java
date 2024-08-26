package com.mesh.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Pet pet;

    @Builder
    public Visit(Long id, LocalDate date, String description, Pet pet) {
        super(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit visit)) return false;

        return getId().equals(visit.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
