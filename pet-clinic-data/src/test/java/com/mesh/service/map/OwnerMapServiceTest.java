package com.mesh.service.map;

import com.mesh.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Owner owner1;
    Owner owner2;

    @BeforeEach
    void setUp() {
        this.ownerMapService = new OwnerMapService();
        this.owner1 = Owner.builder().id(1L).firstName("fn1").lastName("ln1").build();
        this.owner2 = Owner.builder().id(2L).firstName("fn2").lastName("ln2").build();
        this.ownerMapService.save(owner1);
        this.ownerMapService.save(owner2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
        Owner found = ownerMapService.findById(owner1);

        assertEquals(owner1.getId(), found.getId());
        assertEquals(owner1.getFirstName(), found.getFirstName());
        assertEquals(owner1.getLastName(), found.getLastName());
    }

    @Test
    void save() {
        Owner owner3 = Owner.builder().id(3L).firstName("fn3").lastName("ln3").build();
        ownerMapService.save(owner3);
        Long count = ownerMapService.count();

        assertEquals(3, count);
    }

    @Test
    void findAll() {
        Set<Owner> all = ownerMapService.findAll();
        assertEquals(2, all.size());
    }

    @Test
    void delete() {
        ownerMapService.delete(owner1);
        Long count = ownerMapService.count();

        assertEquals(1, count);
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(owner1.getId());

        Long count = ownerMapService.count();

        assertEquals(1, count);
    }

    @Test
    void findByLastName() {
        Owner found = ownerMapService.findByLastName(owner1.getLastName());
        assertEquals(owner1.getLastName(), found.getLastName());
    }

    @Test
    void hashAndEquals() {
        Owner found = ownerMapService.findByLastName(owner1.getLastName());
        assertEquals(owner1.getLastName(), found.getLastName());
    }
}