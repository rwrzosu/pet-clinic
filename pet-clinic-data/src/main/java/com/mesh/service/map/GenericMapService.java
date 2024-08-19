package com.mesh.service.map;

import com.mesh.model.BaseEntity;
import com.mesh.service.CrudService;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class GenericMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    protected final TreeMap<Long, T> map = new TreeMap<>();

    @Override
    public T findById(T item) {
        return map.get(item.getId());
    }

    @Override
    public T save(T item) {
        Long id = item.getId();
//        Optional<Long> maxId = map.keySet().stream().max(Long::compareTo);
        if (map.containsKey(id)) throw new RuntimeException("Duplicate key");
        if (id == null) {
            if (map.isEmpty()) {
                id = 1L;
            } else {
                id = map.lastKey() + 1;
            }
        }
        item.setId(id);
        T saved = map.put(id, item);
        return saved;
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void delete(T item) {
        map.remove(item.getId());
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}
