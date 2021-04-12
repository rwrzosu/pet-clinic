package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends GenericMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return map.values().stream().filter(owner -> lastName.equals(owner.getLastName())).findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastName(String lastName) {
        return map.values().stream().filter(owner -> lastName.equals(owner.getLastName())).collect(Collectors.toList());
    }
}
