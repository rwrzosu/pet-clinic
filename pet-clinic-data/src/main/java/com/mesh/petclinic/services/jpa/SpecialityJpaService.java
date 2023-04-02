package com.mesh.petclinic.services.jpa;

import com.mesh.petclinic.model.Speciality;
import com.mesh.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class SpecialityJpaService implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialityJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality item) {
        return findById(item.getId());
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> newSet = new HashSet<>();
        for (Speciality speciality : specialityRepository.findAll()) {
            newSet.add(speciality);
        }
        return newSet;
    }

    @Override
    public void delete(Speciality item) {
        specialityRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return specialityRepository.count();
    }

}
