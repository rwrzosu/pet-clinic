package com.mesh.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BaseEntity implements Serializable {
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }
}
