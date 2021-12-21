package com.tecsup.petclinic.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tecsup.petclinic.dto.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.services.VetService;


@RestController
public class VetController {

	@Autowired
	private VetService service;
	 
	/**
	 * 
	 * @return
	 */
	// @JsonIgnore
	@GetMapping("/vets")
	public Iterable<Vet> getVets() {
		//
		return service.findAll();
	}

	
	/**
	 * Create Pet
	 * 
	 * @param newPet
	 * @return
	 */
	/*
	@PostMapping("/vets")
	@ResponseStatus(HttpStatus.CREATED)
	Pet create(@RequestBody Pet newVet) {
		return service.create(newVet);
	}*/
	
	/**
	 *  Create Vet
	 * @param newVet
	 * @return
	 */
	@PostMapping("/vets")
	@ResponseStatus(HttpStatus.CREATED)
	Vet create(@RequestBody VetDTO newVet) {
		Vet vet = new Vet();
		vet.setFirstName(newVet.getFirstName());
		vet.setLastName(newVet.getLastName());

		return service.create(vet);
	}
	
	



	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/vets/{id}")
	ResponseEntity<String> delete(@PathVariable Long id) {

		try {
			service.delete(id);
			return new ResponseEntity<>("" + id, HttpStatus.OK);
		} catch (VetNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}

