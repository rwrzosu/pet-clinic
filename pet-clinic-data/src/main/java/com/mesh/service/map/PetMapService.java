package com.mesh.service.map;

import com.mesh.model.Pet;
import com.mesh.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends GenericMapService<Pet, Long> implements PetService {

}

