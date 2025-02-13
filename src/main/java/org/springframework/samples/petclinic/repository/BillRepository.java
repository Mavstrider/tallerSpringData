package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

	List<Bill> findByMoneyGreaterThan(double money);

	List<Bill> findByMoneyLessThan(double money);

}
