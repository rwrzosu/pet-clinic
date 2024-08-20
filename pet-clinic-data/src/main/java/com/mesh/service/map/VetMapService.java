package com.mesh.service.map;

import com.mesh.model.Vet;
import com.mesh.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends GenericMapService<Vet, Long> implements VetService {

}

