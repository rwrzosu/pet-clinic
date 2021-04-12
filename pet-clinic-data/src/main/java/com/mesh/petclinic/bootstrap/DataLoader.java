package com.mesh.petclinic.bootstrap;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.model.Pet;
import com.mesh.petclinic.model.PetType;
import com.mesh.petclinic.model.Vet;
import com.mesh.petclinic.services.*;
import com.mesh.petclinic.services.map.OwnerMapService;
import com.mesh.petclinic.services.springdatajpa.OwnerSDJpaService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VetService vetService;

    public void confirmProfile() {
        if (ownerService instanceof OwnerSDJpaService) {
            System.out.println("Used Spring Data JPA Services");
            return;
        }
        if (ownerService instanceof OwnerMapService) {
            System.out.println("Used Map Services");
            return;
        }
        throw new RuntimeException("unsoported service type");
    }

    public void loadData(boolean isShowing) {
        PetType dogPetType = new PetType("dog");
        PetType catPetType = new PetType("cat");

        petTypeService.save(dogPetType);
        petTypeService.save(catPetType);
        if (isShowing) this.printDomainObject(petTypeService);

        Owner lauraOwner = new Owner("Laura", "Wrzos1");
        Owner konstantyOwner = new Owner("Konstanty", "Wrzos2");

        ownerService.save(lauraOwner);
        ownerService.save(konstantyOwner);
        if (isShowing) this.printDomainObject(ownerService);

        Pet szczekacz = new Pet(dogPetType, lauraOwner, LocalDate.of(2020, 1, 1));
        Pet mruczek = new Pet(catPetType, konstantyOwner, LocalDate.of(2020, 2, 2));

        petService.save(szczekacz);
        petService.save(mruczek);
        if (isShowing) this.printDomainObject(petService);

        Vet vet1 = new Vet("Aaa", "Bbb");
        Vet vet2 = new Vet("Ccc", "Ddd");
        Vet vet3 = new Vet("Eee", "Fff");
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
