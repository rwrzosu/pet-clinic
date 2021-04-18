package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {
    OwnerMapService oms;

    Long ownerId = 1L;
    String lastName = "Kowalski";

    @BeforeEach
    void setUp() {
        oms = new OwnerMapService();
        oms.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void saveWithoutId() {
        oms.save(Owner.builder().build());
        assertEquals(2, oms.findAll().size());
    }

    @Test
    void saveWithId() {
        Long id = 101L;
        oms.save(Owner.builder().id(id).build());
        List<Owner> owners = oms.findAll().stream().filter(o -> o.getId().equals(id)).collect(Collectors.toList());
        assertEquals(1L, owners.size());
        assertEquals(id, owners.get(0).getId());
    }

    @Test
    void findByLastName() {
        Owner owner = oms.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void checkEquals() {
        Owner o1 = Owner.builder().firstName("a").lastName("b").build();
        oms.save(o1);
        assertEquals(2L, oms.findAll().size()); // should be diffrent by id
    }

    @Test
    void deleteById() {
        oms.deleteById(ownerId);
        assertEquals(0, oms.findAll().size());
    }

    @Test
    void deleteByObj() {
        oms.delete(oms.findById(ownerId));
        assertEquals(0, oms.findAll().size());
    }
}