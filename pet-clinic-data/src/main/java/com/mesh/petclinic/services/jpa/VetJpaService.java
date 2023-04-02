package com.mesh.petclinic.services.jpa;

import com.mesh.petclinic.model.Vet;
import com.mesh.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet item) {
        return vetRepository.save(item);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> newSet = new HashSet<>();
        for (Vet pet : vetRepository.findAll()) {
            newSet.add(pet);
        }
        return newSet;
    }

    @Override
    public void delete(Vet item) {
        vetRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return vetRepository.count();
    }

}
