package com.mesh.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"id"})
public class BaseEntity implements Serializable {
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }
}
