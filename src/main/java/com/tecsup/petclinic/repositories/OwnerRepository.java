package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
		// Fetch pets by first_name
	List<Owner> findByFirstName(String firstname);

	
	List<Owner> findByLastName(String lastname);

	
	List<Owner> findByAddress(String address);
	
	
	List<Owner> findByCity(String city);
	
	
	List<Owner> findByTelephone(String telephone);

}
