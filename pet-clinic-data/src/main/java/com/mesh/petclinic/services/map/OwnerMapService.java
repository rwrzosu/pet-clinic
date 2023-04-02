package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().orElse(null);
    }
}
