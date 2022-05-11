package com.Assignment.demo.controller;

import com.Assignment.demo.StudentConverter.StudentConverter;
import com.Assignment.demo.entity.Student;
import com.Assignment.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}


	@Autowired
	private StudentConverter converter;



	@RequestMapping("/loginpagestudent")
	public String loginpagestudent() {
		System.out.println("Im student");
		return "loginpagestudent";
	}



	@RequestMapping("/loginpageteacher")
	public String loginpageteacher() {
		System.out.println("Im teacher");
		return "loginpageteacher";
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/studentsList")
	public String listStudentslist(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "studentsList";
	}

	@GetMapping("/administration")
	public String administration() {
		return "administration";
	}


	@GetMapping("/teacherlogin")
	public String teacherlogin() {
		return "teacherlogin";
	}



	@GetMapping("/studentlogin")
	public String studentlogin() {
		return "studentlogin";
	}




	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle   get student by id request
	
	@GetMapping("/students/{id}")
	public String getStudent(@PathVariable Long id,Model model) {
		Student theStudent =studentService.getStudentById(id);
		model.addAttribute("students",theStudent);
		return "/students";
	}

	@GetMapping("students/delete/{id}")
	public String deleteStudent(@PathVariable Long id){
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
