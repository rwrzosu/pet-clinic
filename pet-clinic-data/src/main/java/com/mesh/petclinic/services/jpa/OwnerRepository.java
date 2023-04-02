package com.mesh.petclinic.services.jpa;

import com.mesh.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);
}
