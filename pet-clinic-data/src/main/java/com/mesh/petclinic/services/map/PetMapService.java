package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Pet;
import com.mesh.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends GenericMapService<Pet, Long> implements PetService {
}
