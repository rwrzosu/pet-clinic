package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.services.OwnerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerService ownerService;
    Owner owner1;
    Owner owner2;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService();
        owner1 = new Owner();
        owner1.setFirstName("FirstName1");
        owner1.setLastName("LastName1");
        this.ownerService.save(owner1);
        owner2 = new Owner();
        owner2.setFirstName("FirstName2");
        owner2.setLastName("LastName2");
        this.ownerService.save(owner2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Owner saved = this.ownerService.save(new Owner());
        assertNotNull(saved.getId());
    }

    @Test
    void findById() {
        Owner found = this.ownerService.findById(1L);
        assertNotNull(found);
    }

    @Test
    void findAll() {
        Set<Owner> owners = this.ownerService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        this.ownerService.delete(owner1);
        assertEquals(1, this.ownerService.count());
    }

    @Test
    void deleteById() {
        this.ownerService.deleteById(owner1.getId());
        assertEquals(1, this.ownerService.count());
    }

    @Test
    void count() {
        Long count = this.ownerService.count();
        assertEquals(2, count);
    }

}