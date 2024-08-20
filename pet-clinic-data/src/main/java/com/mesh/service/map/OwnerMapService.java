package com.mesh.service.map;

import com.mesh.model.Owner;
import com.mesh.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends GenericMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return this.map.values().stream().filter(x -> x.getLastName().equals(lastName)).findFirst().orElse(null);
    }
}

