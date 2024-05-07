package com.nidheeshnelson.datafromexceltomysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class StudentModel {
	@Id
	private int admissionNumber;
	private String studentName;
	private double physicsMark;
	private double chemistryMark;
	private double mathsMark;
	public int getAdmissionNumber() {
		return admissionNumber;
	}
	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getPhysicsMark() {
		return physicsMark;
	}
	public void setPhysicsMark(double physicsMark) {
		this.physicsMark = physicsMark;
	}
	public double getChemistryMark() {
		return chemistryMark;
	}
	public void setChemistryMark(double chemistryMark) {
		this.chemistryMark = chemistryMark;
	}
	public double getMathsMark() {
		return mathsMark;
	}
	public void setMathsMark(double mathsMark) {
		this.mathsMark = mathsMark;
	}
	@Override
	public String toString() {
		return "StudentModel [admissionNumber=" + admissionNumber + ", studentName=" + studentName + ", physicsMark="
				+ physicsMark + ", chemistryMark=" + chemistryMark + ", mathsMark=" + mathsMark + "]";
	}

}
