package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static Owner OWNER;
    @Mock
    private OwnerRepository repository;

    @InjectMocks
    private OwnerSDJpaService service;

    Long ownerId = 1L;
    String lastName = "Kowalski";

    @BeforeEach
    void setUp() {
        OWNER = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(OWNER);

        Owner savedOwner = service.save(OWNER);

        assertEquals(OWNER, savedOwner);
    }

    @Test
    void findByLastName() {
        when(repository.findByLastNameContainingIgnoreCase(any())).thenReturn(Set.of(OWNER));

        Owner owner = service.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }

}