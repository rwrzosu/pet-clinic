package com.mesh.petclinic.services;

import com.mesh.petclinic.model.BaseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenericMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    protected Map<Long, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T save(T object) {
        if (object == null) throw new RuntimeException("Saved object can not be null.");

        if (object.getId() == null) {
            object.setId(getNextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    @Override
    public void delete(T object) {
        this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        return map.keySet().stream().max(Long::compareTo).orElse(0L) + 1;
    }
}
