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

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = Owner.builder().firstName("fn1").lastName("ln1").build();
        Owner owner2 = Owner.builder().firstName("fn2").lastName("ln2").build();

        this.ownerService.save(owner1);
        this.ownerService.save(owner2);

        Vet vet1 = Vet.builder().firstName("fn1").lastName("ln1").build();
        Vet vet2 = Vet.builder().firstName("fn2").lastName("ln2").build();

        this.vetService.save(vet1);
        this.vetService.save(vet2);


        assert 2 == this.ownerService.findAll().size();
        assert 2 == this.vetService.findAll().size();
    }
}
