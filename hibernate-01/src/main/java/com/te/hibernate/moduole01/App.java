package com.te.hibernate.moduole01;

import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.te.hibernate.moduole01.bean.Person;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate !!!!!!" );
        
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Persistance_one");
        EntityManager  entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        
        Person  person=new Person();
        person.setPersonId(10);
        person.setPersonName("abhi");
        person.setPersonAge(25);
        
        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
    }
}
