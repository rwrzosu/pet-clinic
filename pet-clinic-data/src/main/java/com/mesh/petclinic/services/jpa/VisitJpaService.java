package com.mesh.petclinic.services.jpa;

import com.mesh.petclinic.model.Visit;
import com.mesh.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit item) {
        return findById(item.getId());
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> newSet = new HashSet<>();
        for (Visit visit : visitRepository.findAll()) {
            newSet.add(visit);
        }
        return newSet;
    }

    @Override
    public void delete(Visit item) {
        visitRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return visitRepository.count();
    }

}
