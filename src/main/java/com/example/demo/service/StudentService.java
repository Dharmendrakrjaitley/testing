package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
//	List<Student> studentList=new ArrayList<Student>();
//			Student student1=new Student(1,"Sonu","sonu@gmail.com");
//			studentList.
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	public Student addStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public void deleteStudent(int id)
	{
		studentRepository.deleteById(id);
	}
	public Student getStudentById(int id)
	{
		return studentRepository.getById(id);
	}
	
	public void updateStudent(Student student)
	{
		studentRepository.save(student);
	}
}
