package com.mesh.petclinic.services.jpa;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.model.Pet;
import com.mesh.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetJpaService implements PetService {
    private final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet item) {
        return findById(item.getId());
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> newSet = new HashSet<>();
        for (Pet pet : petRepository.findAll()) {
            newSet.add(pet);
        }
        return newSet;
    }

    @Override
    public void delete(Pet item) {
        petRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return petRepository.count();
    }

}
