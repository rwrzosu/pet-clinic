package com.mesh.petclinic.services;

import java.util.Set;

public interface GenericService<T> {
    T findById(Long id);

    T save(T item);

    Set<T> findAll();

    void delete(T item);

    void deleteById(Long id);

    Long count();
}
