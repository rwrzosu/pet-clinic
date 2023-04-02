package com.mesh.petclinic.services.jpa;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class OwnerJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner item) {
        return ownerRepository.save(item);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> newOwners = new HashSet<>();
        for (Owner owner : ownerRepository.findAll()) {
            newOwners.add(owner);
        }
        return newOwners;
    }

    @Override
    public void delete(Owner item) {
        ownerRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return ownerRepository.count();
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }
}
