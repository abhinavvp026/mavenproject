package com.te.hibernatemodule.student.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address_table")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	private String streetName;
	private String city;
	@OneToOne
	@JoinColumn(name="student_fk")
	private Student student;
}
