package com.te.hibernate.moduole01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.hibernate.moduole01.bean.Person;

public class App1 {

	public static void main(String[] args) {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Persistance_one");
	        EntityManager  entityManager=entityManagerFactory.createEntityManager();
	        EntityTransaction transaction=entityManager.getTransaction();
	        Person person = entityManager.find(Person.class, 10);
	        transaction.begin();
	        entityManager.remove(person);
	        transaction.commit();

	}

}
