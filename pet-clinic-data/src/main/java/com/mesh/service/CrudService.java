package com.mesh.service;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(T item);

    T save(T item);

    Set<T> findAll();

    void delete(T item);

    void deleteById(ID id);
}
