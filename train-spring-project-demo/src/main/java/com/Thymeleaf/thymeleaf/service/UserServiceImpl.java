package com.Thymeleaf.thymeleaf.service;

import com.Thymeleaf.thymeleaf.DAO.UserRepository;
import com.Thymeleaf.thymeleaf.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}


	@Override
	public List<User> findAll() {
		return userRepository.findAllByOrderByIdAsc();
	}

	/*@Override
	public User findById(int theId) {
		Optional<User> result = userRepository.findById(theId);
		User theUser = null;
		if (result.isPresent()) {
			theUser= result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Not reserved - " + theId);
		}
		
		return theUser;
	}
*/
	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById((long) theId);
	}

}





