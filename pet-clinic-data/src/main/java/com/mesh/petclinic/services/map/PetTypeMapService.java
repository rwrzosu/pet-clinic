package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.PetType;
import com.mesh.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends GenericMapService<PetType, Long> implements PetTypeService {
}
