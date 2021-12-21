package com.tecsup.petclinic.services;



import java.util.List;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

public interface VetService {

	/**
	 * 
	 * @param vet
	 * @return
	 */
	Vet create(Vet vet);

	/**
	 * 
	 * @param vet
	 * @return
	 */
	Vet update(Vet vet);

	/**
	 * 
	 * @param id
	 * @throws VetNotFoundException
	 */
	void delete(Long id) throws VetNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Vet findById(long id) throws VetNotFoundException;

	/**
	 * 
	 * @param first_name
	 * @return
	 */
	List<Vet> findByFirstName(String first_name);
	
	/**
	 * 
	 * @param last_name
	 * @return
	 */
	List<Vet> findByLastName(String last_name);
	
	/**
	 * 
	 * @return
	 */
	Iterable<Vet> findAll();

}