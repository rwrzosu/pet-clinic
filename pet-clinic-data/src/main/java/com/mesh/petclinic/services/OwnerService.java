package com.mesh.petclinic.services;

import com.mesh.petclinic.model.Owner;

public interface OwnerService extends GenericService<Owner> {
    Owner findByLastName(String lastName);
}
