package com.mesh.petclinic.model;

import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, of = {})
@Entity
public class Speciality extends BaseEntity {
    private String description;
}
