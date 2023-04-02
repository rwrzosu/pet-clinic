package com.mesh.petclinic.services.jpa;

import com.mesh.petclinic.model.PetType;
import com.mesh.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType item) {
        return petTypeRepository.save(item);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> newSet = new HashSet<>();
        for (PetType petType : petTypeRepository.findAll()) {
            newSet.add(petType);
        }
        return newSet;
    }

    @Override
    public void delete(PetType item) {
        petTypeRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return petTypeRepository.count();
    }

}
