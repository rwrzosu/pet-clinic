package com.mesh.petclinic.bootstrap;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.model.Pet;
import com.mesh.petclinic.model.PetType;
import com.mesh.petclinic.model.Vet;
import com.mesh.petclinic.services.*;
import com.mesh.petclinic.services.map.OwnerMapService;
import com.mesh.petclinic.services.springdatajpa.OwnerSDJpaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VetService vetService;

    public void confirmProfile() {
        if (ownerService instanceof OwnerSDJpaService) {
            log.debug("Used Spring Data JPA Services");
            return;
        }
        if (ownerService instanceof OwnerMapService) {
            log.debug("Used Map Services");
            return;
        }
        throw new RuntimeException("unsoported service type");
    }

    public void loadData(boolean isShowing) {
        PetType dogPetType = PetType.builder().name("dog").build();
        PetType catPetType = PetType.builder().name("cat").build();

        petTypeService.save(dogPetType);
        petTypeService.save(catPetType);
        if (isShowing) this.printDomainObject(petTypeService);

        Owner lauraOwner = Owner.builder().firstName("Laura").lastName("Wrzos").build();
        Owner konstantyOwner = Owner.builder().firstName("Konstanty").lastName("Wrzos").build();

        ownerService.save(lauraOwner);
        ownerService.save(konstantyOwner);
        if (isShowing) this.printDomainObject(ownerService);

        Pet szczekacz = Pet.builder().name("szczekacz").petType(dogPetType).owner(lauraOwner).dob(LocalDate.of(2020, 1, 1)).build();
        Pet mruczek = Pet.builder().name("mruczek").petType(catPetType).owner(konstantyOwner).dob(LocalDate.of(2020, 2, 2)).build();

        petService.save(szczekacz);
        petService.save(mruczek);
        if (isShowing) this.printDomainObject(petService);

        Vet vet1 = Vet.builder().firstName("Aaa").lastName("Bbb").build();
        Vet vet2 = Vet.builder().firstName("Ccc").lastName("Ddd").build();
        Vet vet3 = Vet.builder().firstName("Eee").lastName("Fff").build();
        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);
        if (isShowing) this.printDomainObject(vetService);
    }

    @Override
    public void run(String... args) throws Exception {
        confirmProfile();
        loadData(false);
    }

    void printDomainObject(CrudService cs) {
        System.out.println("Cnt: " + cs.findAll().size());
        for (Object o : cs.findAll()) {
            System.out.println(o);
        }
    }
}
