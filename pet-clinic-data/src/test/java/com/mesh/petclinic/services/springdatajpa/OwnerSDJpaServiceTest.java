package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository repository;

    @InjectMocks
    private OwnerSDJpaService service;

    @Test
    void findByLastName() {
        when(repository.findByLastNameContainingIgnoreCase(any())).thenReturn(new HashSet<>(Collections.singletonList(new Owner("a", "b"))));
        Owner owner = service.findByLastName("xyz");
        assertNotNull(owner);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
        var owner = new Owner("a", "b");
        when(repository.save(owner)).thenReturn(null);
        Owner save = service.save(new Owner("a", "b"));
        assertNull(save);
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}