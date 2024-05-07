package com.nidheeshnelson.datafromexceltomysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nidheeshnelson.datafromexceltomysql.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> 
{
	StudentModel findByAdmissionNumber(int admissionNumber);
	List<StudentModel> findByStudentNameContaining(String studentName);
}
