package com.te.hibernatemodule.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.hibernatemodule.student.bean.Courses;
import com.te.hibernatemodule.student.bean.Student;

public class App1 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		Courses courses = entityManager.find(Courses.class,1);
		List<Student> student = courses.getStudent();
		Student student2 = student.get(0);
		student2.setStudentName("hababbaahahha");
		transaction.begin();
		entityManager.persist(student2);
		transaction.commit();

	}

}
