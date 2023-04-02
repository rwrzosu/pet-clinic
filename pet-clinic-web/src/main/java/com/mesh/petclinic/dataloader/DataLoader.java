package com.mesh.petclinic.dataloader;

import com.mesh.petclinic.config.FakeDataSource;
import com.mesh.petclinic.model.*;
import com.mesh.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final FakeDataSource fakeDataSource;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, FakeDataSource fakeDataSource, PetService petService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.fakeDataSource = fakeDataSource;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.count() == 0){
            loadData();
        }

//        System.out.println(fakeDataSource.getUsername());
//        System.out.println(fakeDataSource.getPassword());
//        System.out.println(fakeDataSource.getJdbcurl());
    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("dog");
        PetType savedPetType1 = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("cat");
        PetType savedPetType2 = petTypeService.save(petType2);

        Pet pet1 = new Pet();
        pet1.setType(savedPetType1);
//        Pet savedPet1 = petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setType(savedPetType2);
//        Pet savedPet2 = petService.save(pet2);

        Owner owner1 = new Owner();
        owner1.setFirstName("FN1");
        owner1.setLastName("LN1");
        owner1.addPet(pet1);
        owner1.setCity("city1");
        owner1.setStreet("street1");
        owner1.setTelephone("telephone1");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("FN2");
        owner2.setLastName("LN2");
        owner2.addPet(pet2);
        owner2.setCity("city2");
        owner2.setStreet("street2");
        owner2.setTelephone("telephone2");
        ownerService.save(owner2);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDenistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("VFN1");
        vet1.setLastName("VLN1");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("VFN2");
        vet2.setLastName("VLN2");
        vet2.getSpecialities().add(savedDenistry);
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);


        if(ownerService.count() != 2){
            throw new RuntimeException("!=2");
        }

        if(vetService.count() != 2){
            throw new RuntimeException("!=2");
        }

        if(specialityService.count() != 3){
            throw new RuntimeException("!=3");
        }
    }
}
