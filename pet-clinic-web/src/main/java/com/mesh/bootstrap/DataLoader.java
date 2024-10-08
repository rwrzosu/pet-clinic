package com.mesh.bootstrap;

import com.mesh.model.*;
import com.mesh.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PropertyDummySource propertyDummySource;
    private final PropertyDummySourceByContructor propertyDummySourceByContructor;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PropertyDummySource propertyDummySource, PropertyDummySourceByContructor propertyDummySourceByContructor, PetTypeService petTypeService, PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.propertyDummySource = propertyDummySource;
        this.propertyDummySourceByContructor = propertyDummySourceByContructor;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if ((long) petTypeService.findAll().size() == 0) loadData();

    }

    private void loadData() {
        //        System.out.println(propertyDummySource.getUsername());
//        System.out.println(propertyDummySource.getPassword());
//        System.out.println(propertyDummySource.getUrl());

        System.out.println(propertyDummySourceByContructor.getUsername());
//        System.out.println(propertyDummySourceByContructor.getPassword());
//        System.out.println(propertyDummySourceByContructor.getUrl());

        PetType dogPetType = PetType.builder().name("dog").build();
        PetType catPetType = PetType.builder().name("cat").build();
        petTypeService.save(dogPetType);
        petTypeService.save(catPetType);

        Owner owner1 = Owner.builder().firstName("fn1").lastName("ln1").build();
        Owner owner2 = Owner.builder().firstName("fn2").lastName("ln2").build();
        Owner owner3 = Owner.builder().firstName("fn3").lastName("ln3").build();

        Pet dog1 = Pet.builder().name("dog1").owner(owner1).birthDate(LocalDate.now()).petType(dogPetType).build();
        Pet dog2 = Pet.builder().name("dog2").owner(owner2).birthDate(LocalDate.now()).petType(dogPetType).build();
        Pet cat1 = Pet.builder().name("cat1").owner(owner3).birthDate(LocalDate.now()).petType(catPetType).build();
        petService.save(dog1);
        petService.save(cat1);
        petService.save(dog2);

        owner1.getPets().add(dog1);
        owner2.getPets().add(dog2);
        owner3.getPets().add(cat1);

        this.ownerService.save(owner1);
        this.ownerService.save(owner2);
        this.ownerService.save(owner3);

        Speciality speciality1 = Speciality.builder().name("speciality1").build();
        Speciality speciality2 = Speciality.builder().name("speciality2").build();
        Speciality speciality3 = Speciality.builder().name("speciality3").build();
        specialityService.save(speciality1);
        specialityService.save(speciality2);
        specialityService.save(speciality3);

        Vet vet1 = Vet.builder().firstName("fn1").lastName("ln1").build();
        Vet vet2 = Vet.builder().firstName("fn2").lastName("ln2").build();
        Vet vet3 = Vet.builder().firstName("fn3").lastName("ln3").build();
        vet1.getSpecialities().add(speciality1);
        vet2.getSpecialities().add(speciality2);
        vet3.getSpecialities().add(speciality3);

        this.vetService.save(vet1);
        this.vetService.save(vet2);
        this.vetService.save(vet3);


        assert 3 == this.ownerService.findAll().size();
        assert 3 == this.vetService.findAll().size();
        assert 2 == this.petTypeService.findAll().size();
    }
}
