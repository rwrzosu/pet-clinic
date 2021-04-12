package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.repositories.OwnerRepository;
import com.mesh.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastNameContainingIgnoreCase(lastName).stream().findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastName(String lastName) {
        return new ArrayList<>(ownerRepository.findByLastNameContainingIgnoreCase(lastName));
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        return StreamSupport.stream(ownerRepository.findAll().spliterator(), true).collect(Collectors.toSet());
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
