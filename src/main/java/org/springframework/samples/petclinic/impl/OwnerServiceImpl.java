/**
 * 
 */
package org.springframework.samples.petclinic.impl;

import java.util.List;

import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.services.OwnerService;

/**
 * @author admin
 *
 */
public class OwnerServiceImpl implements OwnerService {


	private OwnerRepository ownerRepository;

	@Override
	public Owner findById(Integer id) {
		// TODO Auto-generated method stub
		return ownerRepository.findById(id);
	}

	@Override
	public List<Owner> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
	}

	@Override
	public List<Owner> searchOwner(String query) {
		// TODO Auto-generated method stub
		return ownerRepository.searchOwner(query);
	}

	@Override
	public List<Owner> findByOrderByLastName() {
		// TODO Auto-generated method stub
		return ownerRepository.findByOrderByLastName();
	}

}
