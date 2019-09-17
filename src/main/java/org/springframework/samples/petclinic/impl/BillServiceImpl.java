/**
 * 
 */
package org.springframework.samples.petclinic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.repository.BillRepository;
import org.springframework.samples.petclinic.services.BillService;
import org.springframework.stereotype.Service;

/**
 * @author admin
 *
 */
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill createBill(Bill newBill) {
		return billRepository.save(newBill);
	}

//	public List<Bill> findAll() {
//		return this.billRepository.findAll();
//	}
//
//	public Bill findById(Integer id) {
//		return this.billRepository.findOne(id);
//	}

}
