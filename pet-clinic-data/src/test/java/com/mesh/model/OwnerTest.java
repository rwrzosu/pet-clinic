package com.mesh.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OwnerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void hashAndEquals() {
        Owner owner1 = Owner.builder().id(1L).firstName("John").lastName("Doe").build();
        Owner owner2 = Owner.builder().id(2L).firstName("John").lastName("Doe").build();
        Owner owner2bis = Owner.builder().id(2L).firstName("JohnBis").lastName("DoeBis").build();

        assertNotEquals(owner1, owner2);
        assertEquals(owner2, owner2bis);
    }
}