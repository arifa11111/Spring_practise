package com.Thymeleaf.thymeleaf.controller;
import com.Thymeleaf.thymeleaf.Entity.User;
import com.Thymeleaf.thymeleaf.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}


	private UserService userService;

	public UserController(UserService theUserService) {
		userService = theUserService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listUsers(Model theModel) {
		// get employees from db
		List<User> theusers = userService.findAll();

		// add to the spring model
		theModel.addAttribute("user", theusers);

		return "user-list";
	}

/*	@GetMapping("/list/{userId}")
	public User getUsers(@PathVariable int userId) {

		User theUser = UserService.findById(userId);

		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		return theUser;
	}*/

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		User theUsers = new User();

		theModel.addAttribute("user", theUsers);

		return "passengers/passenger-form";
	}

	@GetMapping("/registerForm")
	public String register(Model theModel) {
		User theUsers = new User();

		theModel.addAttribute("user", theUsers);

		return "register";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId,
									Model theModel) {

		// get the user from the service
		User theUsers = UserService.findById(theId);

		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUsers);

		// send over to our form
		return "register";
	}


	@PostMapping("/save")
	public String saveUsers(@ModelAttribute("user") @Valid User theUsers) {
		System.out.println(theUsers);
		// save the employee
		userService.save(theUsers);
		// use a redirect to prevent duplicate submissions
		return "register-success";
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("userId") int theId) {

		// delete the employee
		userService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/";

	}
}


















