package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Vet;
import com.mesh.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet> implements VetService {

}
