package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	// Fetch pets by name
		List<Owner> findByName(String name);

		// Fetch pets by typeId
		List<Owner> findByAddress(String address);

}
