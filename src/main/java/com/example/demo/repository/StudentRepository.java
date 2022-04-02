package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("Select s from Student s where s.email= ?1")
	Student findByEmail(String email);
}
