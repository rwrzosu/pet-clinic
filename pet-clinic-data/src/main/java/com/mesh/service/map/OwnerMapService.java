package com.mesh.service.map;

import com.mesh.model.Owner;
import com.mesh.model.Pet;
import com.mesh.service.OwnerService;
import com.mesh.service.PetService;
import com.mesh.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OwnerMapService extends GenericMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.map.values().stream().filter(x -> x.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        Objects.requireNonNull(owner, "Owner must not be null");

        owner.getPets().forEach(pet -> {
            if (pet.getPetType().getId() == null) {
                pet.setPetType(petTypeService.save(pet.getPetType()));
            }
            if (pet.getId() == null) {
                Pet saved = petService.save(pet);
                pet.setId(saved.getId());
            }
        });
        return super.save(owner);
    }
}

