package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.services.OwnerService;

public class OwnerMapService extends GenericMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return this.map.values().stream()
                .filter(o -> o.getLastName().equals(lastName))
                .findAny()
                .orElse(null);
    }
}
