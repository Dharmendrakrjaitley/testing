package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public String getAllStudent(Model model)
	{
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	@GetMapping("/students/new")
	public String createAddStudentForm(Model model)
	{
		Student student=new Student();
		model.addAttribute(student);
		return "new_student";
	}
	
	@PostMapping("/students")
	public String addStudent(@ModelAttribute("student") Student student)
	{
		studentService.addStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String createEditForm(@PathVariable int id, Model model)
	{
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@ModelAttribute("student") Student student,@PathVariable int id)
	{
//		Student tempStudent=studentService.getStudentById(id);
//		tempStudent.setId(id);
//		tempStudent.setName(student.getName());
//		tempStudent.setEmail(student.getEmail());
		studentService.addStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/email")
	@ResponseBody
	public Student findByEmail(@RequestParam String email)
	{
		return studentService.findByEmail(email);
	}
	
}
