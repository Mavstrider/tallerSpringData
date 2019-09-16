/**
 * 
 */
package org.springframework.samples.petclinic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.services.PetService;

/**
 * @author admin
 *
 */
public class PetServiceImpl implements PetService {

	@Autowired
	PetRepository petRepository;

	public void save(Pet pet) {
		petRepository.save(pet);
	}

	public Pet findbyId(Integer id) {
		// TODO Auto-generated method stub
		return petRepository.findOne(id);
	}

	public List<Pet> findByBirthDateBetweenOrderByBirthDateAsc(Date d1, Date d2) {
		return petRepository.findByBirthDateBetweenOrderByBirthDateAsc(d1, d2);
	}
}
