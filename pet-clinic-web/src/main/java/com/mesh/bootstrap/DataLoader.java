package com.mesh.bootstrap;

import com.mesh.model.Owner;
import com.mesh.model.Vet;
import com.mesh.service.OwnerService;
import com.mesh.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PropertyDummySource propertyDummySource;

    public DataLoader(OwnerService ownerService, VetService vetService, PropertyDummySource propertyDummySource) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.propertyDummySource = propertyDummySource;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(propertyDummySource.getUsername());
        System.out.println(propertyDummySource.getPassword());
        System.out.println(propertyDummySource.getUrl());

        Owner owner1 = Owner.builder().firstName("fn1").lastName("ln1").build();
        Owner owner2 = Owner.builder().firstName("fn2").lastName("ln2").build();
        Owner owner3 = Owner.builder().firstName("fn3").lastName("ln3").build();

        this.ownerService.save(owner1);
        this.ownerService.save(owner2);
        this.ownerService.save(owner3);

        Vet vet1 = Vet.builder().firstName("fn1").lastName("ln1").build();
        Vet vet2 = Vet.builder().firstName("fn2").lastName("ln2").build();
        Vet vet3 = Vet.builder().firstName("fn3").lastName("ln3").build();

        this.vetService.save(vet1);
        this.vetService.save(vet2);
        this.vetService.save(vet3);


        assert 3 == this.ownerService.findAll().size();
        assert 3 == this.vetService.findAll().size();
    }
}
