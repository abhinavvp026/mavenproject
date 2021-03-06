package com.te.hibernatemodule.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.hibernatemodule.student.bean.Address;
import com.te.hibernatemodule.student.bean.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate !!!!!!");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		Address address = new Address();
		address.setCity("kannur");
		address.setStreetName("muzhappilangad");
		
		Student student = new Student();
		student.setStudentAge(23);
		student.setStudentName("abhi");
		
		student.setStudentAddress(address);
		address.setStudent(student);

		transaction.begin();
		entityManager.persist(student);
		entityManager.persist(address);

		transaction.commit();
	}
}
