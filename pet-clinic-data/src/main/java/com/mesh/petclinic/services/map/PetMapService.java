package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Pet;
import com.mesh.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet> implements PetService {

}
