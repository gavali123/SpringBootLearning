package com.learning.springboot.data.query.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@NamedQueries(@NamedQuery(name = "Student.findByEnrollNo", query = "SELECT s FROM Student s WHERE s.enrollNo = :enrollNo"))
public class Student {

	private Long enrollNo;
	private String firstName;
	private String lastName;
	private String address;
	private String division;

	public Student(String first_name, String last_name, String address, String division) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
		this.address = address;
		this.division = division;
	}

	public Student() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getEnrollNo() {
		return enrollNo;
	}

	public void setEnrollNo(Long enrollNo) {
		this.enrollNo = enrollNo;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "division")
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "Student [enrollNo=" + enrollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", division=" + division + "]";
	}

}
