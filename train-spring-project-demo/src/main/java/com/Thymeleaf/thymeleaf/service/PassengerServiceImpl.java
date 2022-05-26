package com.Thymeleaf.thymeleaf.service;

import java.util.List;
import java.util.Optional;
import com.Thymeleaf.thymeleaf.DAO.PassengerRepository;
import com.Thymeleaf.thymeleaf.Entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	/*@Autowired
	public PassengerServiceImpl(PassengerRepository thePassengereRepository) {
		passengerRepository = thePassengereRepository;
	}*/


	@Override
	public List<Passenger> findAll() {
		return passengerRepository.findAllByOrderByIdAsc();
	}

	@Override
	public Passenger findById(int theId) {
		Optional<Passenger> result = passengerRepository.findById(theId);
		
		Passenger thePassenger = null;
		
		if (result.isPresent()) {
			thePassenger= result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Not reserved - " + theId);
		}

		return thePassenger;
	}

	@Override
	public void save(Passenger thePassenger) {
		System.out.println(thePassenger);
		passengerRepository.save(thePassenger);
	}

	@Override
	public void deleteById(int theId) {
		passengerRepository.deleteById(theId);
	}

}





