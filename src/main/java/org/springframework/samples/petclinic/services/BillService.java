/**
 * 
 */
package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.samples.petclinic.model.Bill;

// TODO: Auto-generated Javadoc
/**
 * The Interface BillService.
 *
 * @author admin
 */
public interface BillService {

	/**
	 * Creates the bill.
	 *
	 * @param newBill the new bill
	 * @return the bill
	 */
	void save(Bill bill);

	Bill createBill(Bill newBill);

	List<Bill> findAll();

	Bill findById(Integer id);

	void deleteBillbyId(Integer id);

	void updateBill(Bill updbill);

	List<Bill> findBillMoneyGreater(Double money);

	List<Bill> findBillLesserThan(Double money);

	Long countBillsBy();

}
