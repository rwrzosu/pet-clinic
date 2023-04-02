package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Speciality;
import com.mesh.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality> implements SpecialityService {

}
