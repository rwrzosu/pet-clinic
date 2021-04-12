package com.mesh.petclinic.services;

import com.mesh.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastName(String lastName);
}
