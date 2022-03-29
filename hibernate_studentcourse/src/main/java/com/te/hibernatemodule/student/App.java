package com.te.hibernatemodule.student;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.te.hibernatemodule.student.bean.Courses;
import com.te.hibernatemodule.student.bean.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate !!!!!!");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		Courses course1 = new Courses();
		course1.setCourseName("malayalam");

		Courses course2 = new Courses();
		course2.setCourseName("English");

		Courses course3 = new Courses();
		course3.setCourseName("Tamil");

		Student student1 = new Student();
		student1.setStudentAge(23);
		student1.setStudentName("abhi");

		Student student2 = new Student();
		student2.setStudentAge(24);
		student2.setStudentName("arun");

		ArrayList<Courses> courselist = new ArrayList<Courses>();
		courselist.add(course1);
		courselist.add(course2);
		courselist.add(course3);
		ArrayList<Student> studentlist = new ArrayList<Student>();
		studentlist.add(student1);
		studentlist.add(student1);
		student1.setStudentCourse(courselist);
		student2.setStudentCourse(courselist);
		course1.setStudent(studentlist);
		course2.setStudent(studentlist);
		course3.setStudent(studentlist);
		transaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		transaction.commit();
	}
}
