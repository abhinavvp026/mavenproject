package com.te.hibernatemodule.student.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private int studentAge;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		       name = "s_c_map", 
		       joinColumns = @JoinColumn(name = "s_id"), 
		       inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<Courses> studentCourse;
}
