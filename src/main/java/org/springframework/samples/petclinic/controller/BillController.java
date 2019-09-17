/**
 * 
 */
package org.springframework.samples.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.services.BillService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 *
 */
@RestController
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping(value = "/createBill", method = RequestMethod.POST)
	public @ResponseBody Bill createBill(@RequestBody Bill newBill) {
		// System.out.println("## Createnew bill, id --> ##"+bill.getId());
		return billService.createBill(newBill);
		// System.out.println("## Createnew bill, id --> ##"+bill.getId());
	}


}

