package com.te.hibernatemodule.student;

import java.util.ArrayList;

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

		Address address1 = new Address();
		address1.setCity("Banglore");
		address1.setStreetName("BTM");

		Student student = new Student();
		student.setStudentAge(23);
		student.setStudentName("abhi");

		ArrayList<Address> addresses = new ArrayList<Address>();
		addresses.add(address1);
		addresses.add(address);

		student.setStudentAddress(addresses);
		address.setStudent(student);
		address1.setStudent(student);

		transaction.begin();
		entityManager.persist(student);

		transaction.commit();
	}
}
