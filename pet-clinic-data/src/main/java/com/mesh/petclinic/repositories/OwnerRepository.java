package com.mesh.petclinic.repositories;

import com.mesh.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Set<Owner> findByLastNameContainingIgnoreCase(String lastName);
}
