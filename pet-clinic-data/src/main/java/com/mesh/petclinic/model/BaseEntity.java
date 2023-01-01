package com.mesh.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseEntity implements Serializable {
    private Long id;    //używamy boxowanego longa bo rekomendowane przez hibernate i może być null
}
