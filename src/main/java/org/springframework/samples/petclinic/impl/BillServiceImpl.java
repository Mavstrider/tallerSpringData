/**
 * 
 */
package org.springframework.samples.petclinic.impl;

import java.util.List;

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

	public List<Bill> findAll() {
		return billRepository.findAll();
	}

	public Bill findById(Integer id) {
		return billRepository.findOne(id);
	}

	@Override
	public void updateBill(Bill updBill) {
		Bill bill = billRepository.findOne(updBill.getId());
		bill.setPaymentDate(updBill.getPaymentDate());
		billRepository.save(bill);

		// TODO Auto-generated method stub

	}

	@Override
	public void save(Bill bill) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void deleteBillbyId(Integer id) {
		billRepository.delete(id);
		// return billRepository;
	}



	@Override
	public List<Bill> findBillMoneyGreater(Double money) {
		List<Bill> lb = billRepository.findByMoneyGreaterThan(money);
		return lb;
	}

	@Override
	public List<Bill> findBillLesserThan(Double money) {
		// TODO Auto-generated method stub
		List<Bill> lb = billRepository.findByMoneyLessThan(money);
		return lb;
	}

	@Override
	public Long countBillsBy() {
		return billRepository.count();

	}
	
}
