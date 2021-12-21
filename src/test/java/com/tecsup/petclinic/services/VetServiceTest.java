package com.tecsup.petclinic.services;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;



import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

@SpringBootTest
public class VetServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(VetServiceTest.class);

	
	@Autowired
	private VetService vetService;
	
	
	

	/**
	 * 
	 */


	@Test
	public void testCreateVet() {

		String VET_FIRST_NAME = "Renato";
		String VET_LAST_NAME = "Pongo";

		Vet vet = new Vet(VET_FIRST_NAME, VET_LAST_NAME);
		
		Vet vetCreated = vetService.create(vet);
		
		logger.info("VET CREATED :" + vetCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(vetCreated.getId()      , notNullValue());
		assertThat(vetCreated.getFirstName()    , is(VET_FIRST_NAME));
		assertThat(vetCreated.getLastName() , is( VET_LAST_NAME));
		

	}

	
	/**
	 * 
	 */
	@Test
	public void testUpdateVet() {

		String VET_FIRST_NAME = "Renato";
		String VET_LAST_NAME = "Pongo";
		long create_id = -1;
		
		String UP_VET_FIRST_NAME = "Renato2";
		String UP_VET_LAST_NAME = "Pongo2";
		
		Vet vet = new Vet(VET_FIRST_NAME, VET_LAST_NAME);

		// Create record
		logger.info(">" + vet);
		Vet vetCreated = vetService.create(vet);
		logger.info(">>" + vetCreated);

		create_id = vetCreated.getId();

		// Prepare data for update
		vetCreated.setFirstName(UP_VET_FIRST_NAME);
		vetCreated.setLastName(UP_VET_LAST_NAME);
		

		// Execute update
		Vet upgradeVet = vetService.update(vetCreated);
		logger.info(">>>>" + upgradeVet);

		//        ACTUAL       EXPECTED
		assertThat(create_id ,notNullValue());
		assertThat(upgradeVet.getId(), is(create_id));
		assertThat(upgradeVet.getFirstName(), is(UP_VET_FIRST_NAME));
		assertThat(upgradeVet.getLastName(), is(UP_VET_LAST_NAME));
		
	}

	/**
	 * 
	 */
	@Test
	public void testDeleteVet() {

		String VET_FIRST_NAME = "Renato";
		String VET_LAST_NAME = "Pongo";

		Vet vet = new Vet(VET_FIRST_NAME, VET_LAST_NAME);
		vet = vetService.create(vet);
		logger.info("" + vet);

		try {
			vetService.delete(vet.getId());
		} catch (VetNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
			
		try {
			vetService.findById(vet.getId());
			assertThat(true, is(false));
		} catch (VetNotFoundException e) {
			assertThat(true, is(true));
		} 				

	}

	
	
}


