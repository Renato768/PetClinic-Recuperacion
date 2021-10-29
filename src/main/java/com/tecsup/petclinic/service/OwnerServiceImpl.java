package com.tecsup.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.domain.OwnerRepository;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public class OwnerServiceImpl implements OwnerService{
	private static final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);

	@Autowired
	OwnerRepository ownerRepository;
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	@Override
	public void delete(Long id) throws OwnerNotFoundException {
		Owner own = findById(id);
		ownerRepository.delete(own);
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Owner findById(long id) throws OwnerNotFoundException {
		Optional<Owner> own=ownerRepository.findById(id);
		if(!own.isPresent())
			throw new OwnerNotFoundException("Record no found...");
		return own.get();
	}

	@Override
	public List<Owner> findByName(String name) {
		List<Owner> owns = ownerRepository.findByName(name);

		owns.stream().forEach(own -> logger.info("" + own));

		return owns;
	}

	@Override
	public List<Owner> findByAddress(String address) {
		List<Owner> owns = ownerRepository.findByAddress(address);

		owns.stream().forEach(own -> logger.info("" + own));

		return owns;
	}

	@Override
	public Iterable<Owner> findAll() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

}
