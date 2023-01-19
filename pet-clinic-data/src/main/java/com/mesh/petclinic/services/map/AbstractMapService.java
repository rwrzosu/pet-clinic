package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.BaseEntity;
import com.mesh.petclinic.services.GenericService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity> implements GenericService<T> {

    private Map<Long, T> map = new HashMap<>();

    @Override
    public T findById(Long id) {
        return this.map.get(id);
    }

    @Override
    public T save(T item) {
        if (item.getId() == null) {
            if (map.size() == 0)
                item.setId(1L);
            else
                item.setId(this.map.keySet().stream().max(Long::compareTo).get() + 1L);
        }
        this.map.put(item.getId(), item);
        return item;
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(this.map.values());
    }

    @Override
    public void delete(T item) {
        this.map.entrySet().removeIf(entry -> entry.getValue().equals(item));
    }

    @Override
    public void deleteById(Long id) {
        this.map.remove(id);
    }

    @Override
    public Long count() {
        return (long) this.map.size();
    }
}
