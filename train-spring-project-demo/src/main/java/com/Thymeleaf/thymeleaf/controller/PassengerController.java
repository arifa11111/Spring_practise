package com.Thymeleaf.thymeleaf.controller;
import java.util.List;
import com.Thymeleaf.thymeleaf.Entity.Passenger;
import com.Thymeleaf.thymeleaf.service.PassengerService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/passengers")
public class PassengerController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	private PassengerService passengerService;

	public PassengerController(PassengerService thePassengerService) {
		passengerService = thePassengerService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listPassengers(Model theModel) {

		// get employees from db
		List<Passenger> thePassengers = passengerService.findAll();

		// add to the spring model
		theModel.addAttribute("passengers", thePassengers);

		return "passengers/list-passengers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Passenger thePassengers = new Passenger();

		theModel.addAttribute("passenger", thePassengers);

		return "passengers/passenger-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("passengerId") int theId,
									Model theModel) {

		// get the employee from the service
		Passenger thePassengers = passengerService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("passenger", thePassengers);

		// send over to our form
		return "passengers/passenger-form";
	}

	@PostMapping("/save")
	public String savePassenger(@ModelAttribute("passenger") Passenger thePassenger) {
		System.out.println(thePassenger);
		// save the employee
		passengerService.save(thePassenger);

		// use a redirect to prevent duplicate submissions
		return "redirect:/bookedSuccess";
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("passengerId") int theId) {

		// delete the employee
		passengerService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/passengers/list";

	}


}


















