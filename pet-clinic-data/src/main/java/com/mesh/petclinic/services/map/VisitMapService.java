package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Visit;
import com.mesh.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {

}
