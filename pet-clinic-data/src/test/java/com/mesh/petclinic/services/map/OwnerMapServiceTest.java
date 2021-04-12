package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {
    OwnerMapService oms;

    @BeforeEach
    void setUp() {
        oms = new OwnerMapService();
    }

    @Test
    void findByLastName() {
        oms.save(new Owner("a", "b"));
        oms.save(new Owner("b", "c"));
        Owner owner = oms.findByLastName("b");

        assertNotNull(owner);
        assertEquals("b", owner.getLastName());
    }

    @Test
    void checkEquals() {
        Owner o1 = new Owner("a", "b");
        Owner o2 = new Owner("a", "b");
        oms.save(o1);
        oms.save(o2);
        assertEquals(2L, oms.findAll().size()); // should be diffrent by id
    }
}