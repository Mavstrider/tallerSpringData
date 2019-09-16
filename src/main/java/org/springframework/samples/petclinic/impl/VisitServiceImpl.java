/**
 * 
 */
package org.springframework.samples.petclinic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

/**
 * @author admin
 *
 */
@Service
public class VisitServiceImpl implements VisitService{

	@Autowired
	VisitRepository visitRepository;

	public void save(Visit visit) {
		visitRepository.save(visit);
	}

	@Override
	public List<Visit> findbyPetId(Integer petId) {
		// TODO Auto-generated method stub
		return visitRepository.findByPetId(petId);
	}

	@Override
	public List<Visit> findTop4ByOrderByDateDesc() {
		// TODO Auto-generated method stub
		return visitRepository.findTop4ByOrderByDateDesc();
	}

}
