/**
 * 
 */
package org.springframework.samples.petclinic.services;

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
	Bill createBill(Bill newBill);

	/*
	 * List<Bill> findAll();
	 * 
	 * Bill findById(Integer id);
	 */

}
