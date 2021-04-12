package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Visit;
import com.mesh.petclinic.repositories.VisitRepository;
import com.mesh.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository repository;

    public VisitSDJpaService(VisitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Visit findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), true).collect(Collectors.toSet());
    }

    @Override
    public Visit save(Visit object) {
        return repository.save(object);
    }

    @Override
    public void delete(Visit object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
