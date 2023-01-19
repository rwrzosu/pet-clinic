package com.mesh.petclinic.dataloader;

import com.mesh.petclinic.config.FakeDataSource;
import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.model.Vet;
import com.mesh.petclinic.services.OwnerService;
import com.mesh.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final FakeDataSource fakeDataSource;

    public DataLoader(OwnerService ownerService, VetService vetService, FakeDataSource fakeDataSource) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.fakeDataSource = fakeDataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("FN1");
        owner1.setLastName("LN1");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("FN2");
        owner2.setLastName("LN2");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("VFN1");
        vet1.setLastName("VLN1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("VFN2");
        vet2.setLastName("VLN2");
        vetService.save(vet2);

        if(ownerService.count() != 2){
            throw new RuntimeException("!=2");
        }

        if(vetService.count() != 2){
            throw new RuntimeException("!=2");
        }

//        System.out.println(fakeDataSource.getUsername());
//        System.out.println(fakeDataSource.getPassword());
//        System.out.println(fakeDataSource.getJdbcurl());
    }
}
