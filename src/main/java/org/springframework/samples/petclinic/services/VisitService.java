package org.springframework.samples.petclinic.services;


import java.util.List;

import org.springframework.samples.petclinic.model.Visit;

public interface VisitService {

	void save(Visit visit);

	public List<Visit> findbyPetId(Integer petId);

	public List<Visit> findTop4ByOrderByDateDesc();

}
