package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;


@Service
public class VetServiceImpl implements VetService {

	private static final Logger logger = LoggerFactory.getLogger(VetServiceImpl.class);

	@Autowired
	VetRepository vetRepository;

	/**
	 * 
	 * @param vet
	 * @return
	 */
	@Override
	public Vet create(Vet vet) {
		return vetRepository.save(vet);
	}

	/**
	 * 
	 * @param vet
	 * @return
	 */
	@Override
	public Vet update(Vet vet) {
		return vetRepository.save(vet);
	}


	/**
	 * 
	 * @param id
	 * @throws vetNotFoundException
	 */
	@Override
	public void delete(Long id) throws VetNotFoundException{

		Vet vet = findById(id);
		vetRepository.delete(vet);

	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Vet findById(long id) throws VetNotFoundException {

		Optional<Vet> vet = vetRepository.findById(id);

		if ( !vet.isPresent())
			throw new VetNotFoundException("Record not found...!");
			
		return vet.get();
	}

	/**
	 * 
	 * @param fist_name
	 * @return
	 */
	@Override
	public List<Vet> findByFirstName(String first_name) {

		List<Vet> vets = vetRepository.findByFirstName(first_name);

		vets.stream().forEach(pet -> logger.info("" + pet));

		return vets;
	}
	/**
	 * 
	 * @param last_name
	 * @return
	 */
	@Override
	public List<Vet> findByLastName(String last_name) {

		List<Vet> vets = vetRepository.findByLastName(last_name);

		vets.stream().forEach(pet -> logger.info("" + pet));

		return vets;
	}

	

	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Vet> findAll() {
		
		// TODO Auto-generated 
		return vetRepository.findAll();
	
	}

}
