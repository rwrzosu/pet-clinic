package com.mesh.service.map;

import com.mesh.model.PetType;
import com.mesh.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends GenericMapService<PetType, Long> implements PetTypeService {

}

