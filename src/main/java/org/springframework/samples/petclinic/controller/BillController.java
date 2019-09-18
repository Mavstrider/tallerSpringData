/**
 * 
 */
package org.springframework.samples.petclinic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.services.BillService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@RequestMapping(value = "/findbills", method = RequestMethod.GET)
	public List<Bill> findAll() {
		return billService.findAll();
	}

	@RequestMapping(value = "/bills/{idBill}", method = RequestMethod.GET)
	public Bill findById1(@PathVariable("idBill") Integer id) {
		Bill b = billService.findById(id);
		return b;

	}

	@RequestMapping(value = "/billupd", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateBill(@RequestBody Bill updBill) {
		billService.updateBill(updBill);
	}
	
	@RequestMapping(value = "/deleteBill/{idBill}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBillbyId(@PathVariable("idBill") Integer id) {
		billService.deleteBillbyId(id);

	}

	@RequestMapping(value = "/findbillsgreater20/{money}", method = RequestMethod.GET)
	public List<Bill> getBillGreater20(@PathVariable("money") Double money) {
		return billService.findBillMoneyGreater(money);
	}

	@RequestMapping(value = "/findbillsless20/{money}", method = RequestMethod.GET)
	public List<Bill> getBillLesser20(@PathVariable("money") Double money) {
		return billService.findBillLesserThan(money);
	}

	@RequestMapping(value = "/countbill", method = RequestMethod.GET)
	public Long counterBills() {
		return billService.countBillsBy();
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, HttpServletRequest request) {
		return "Exception customized -->" + ex.getMessage();

	}
}



