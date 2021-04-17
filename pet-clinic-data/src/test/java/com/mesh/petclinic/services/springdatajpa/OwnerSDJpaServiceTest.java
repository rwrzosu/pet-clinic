package com.mesh.petclinic.services.springdatajpa;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository repository;

    @InjectMocks
    private OwnerSDJpaService service;

    @Test
    void findByLastName() {
        String lastName = "xyz";
        Owner owner = Owner.builder().firstName("a").lastName(lastName).build();
        when(repository.findByLastNameContainingIgnoreCase(any())).thenReturn(Set.of(owner));

        Owner recivedOwner = service.findByLastName(lastName);

        assertNotNull(recivedOwner);
        assertEquals(lastName, recivedOwner.getLastName());
    }

    @Test
    void findById() {
        Long id = 111L;
        Owner owner = Owner.builder().id(id).build();
        when(repository.findById(any())).thenReturn(Optional.of(owner));

        Owner recivedOwner = service.findById(id);

        verify(repository, times(1)).findById(id);
        assertEquals(id, recivedOwner.getId());
    }

    @Test
    void findAll() {
        Owner owner1 = Owner.builder().id(1L).build();
        Owner owner2 = Owner.builder().id(2L).build();
        when(repository.findAll()).thenReturn(Set.of(owner1, owner2));

        Set<Owner> owners = service.findAll();

        assertEquals(2, owners.size());
    }

    @Test
    void save() {
        var owner = Owner.builder().id(1L).build();
        when(repository.save(any())).thenReturn(owner);

        Owner saved = service.save(owner);

        assertEquals(1L, saved.getId());
    }

}