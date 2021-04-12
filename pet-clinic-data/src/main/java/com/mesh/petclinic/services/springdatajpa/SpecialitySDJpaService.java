package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Speciality;
import com.mesh.petclinic.repositories.SpecialityRepository;
import com.mesh.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository repository;

    public SpecialitySDJpaService(SpecialityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Speciality findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Speciality> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), true).collect(Collectors.toSet());
    }

    @Override
    public Speciality save(Speciality object) {
        return repository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
