package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.PetType;
import com.mesh.petclinic.repositories.PetTypeRepository;
import com.mesh.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository repository;

    public PetTypeSDJpaService(PetTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PetType findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), true).collect(Collectors.toSet());
    }

    @Override
    public PetType save(PetType object) {
        return repository.save(object);
    }

    @Override
    public void delete(PetType object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
