package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Vet;
import com.mesh.petclinic.repositories.VetRepository;
import com.mesh.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository repository;

    public VetSDJpaService(VetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vet findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Vet> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), true).collect(Collectors.toSet());
    }

    @Override
    public Vet save(Vet object) {
        return repository.save(object);
    }

    @Override
    public void delete(Vet object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
