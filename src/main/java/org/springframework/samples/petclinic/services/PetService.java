package org.springframework.samples.petclinic.services;

import java.util.Date;
import java.util.List;

import org.springframework.samples.petclinic.model.Pet;

public interface PetService {

	void save(Pet pet);

	Pet findbyId(Integer id);

	List<Pet> findByBirthDateBetweenOrderByBirthDateAsc(Date d1, Date d2);

//List<PetType> findPetTypes();

}
