package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Vet;


@Repository
public interface VetRepository 
	extends CrudRepository<Vet, Long> {

	// Fetch vets by first_name
	List<Vet> findByFirstName(String first_name);

	// Fetch vets by last_name
	List<Vet> findByLastName(String last_name);



}
