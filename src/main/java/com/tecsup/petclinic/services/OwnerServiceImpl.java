package com.tecsup.petclinic.services;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService{
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

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
	/**
	 * 
	 * @param first_name
	 * @return
	 */
	@Override
	public List<Owner> findByfirst_name(String first_name) {
		List<Owner> owns = ownerRepository.findByfirstName(first_name);

		owns.stream().forEach(own -> logger.info("" + own));

		return owns;
	}
	/**
	 * 
	 * @param address
	 * @return
	 */
	@Override
	public List<Owner> findByAddress(String address) {
		List<Owner> owns = ownerRepository.findByAddress(address);

		owns.stream().forEach(own -> logger.info("" + own));

		return owns;
	}
	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Owner> findAll() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

}
