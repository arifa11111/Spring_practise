package com.Thymeleaf.thymeleaf.DAO;

import com.Thymeleaf.thymeleaf.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	//add method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}