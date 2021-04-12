package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Pet;
import com.mesh.petclinic.repositories.PetRepository;
import com.mesh.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository repository;

    public PetSDJpaService(PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pet findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), true).collect(Collectors.toSet());
    }

    @Override
    public Pet save(Pet object) {
        return repository.save(object);
    }

    @Override
    public void delete(Pet object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
