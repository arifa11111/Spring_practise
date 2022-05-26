package com.Thymeleaf.thymeleaf.DAO;

import com.Thymeleaf.thymeleaf.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	// that's it ... no need to write any code LOL!
	//add method to sort by last name
    public List<Passenger> findAllByOrderByIdAsc();
}