package com.mesh.service.map;

import com.mesh.model.Visit;
import com.mesh.service.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends GenericMapService<Visit, Long> implements VisitService {

}

