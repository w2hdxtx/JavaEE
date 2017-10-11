package com.lv.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lv.entity.Person;

public class Main {

	public static void main(String[] args) {

		String persistenceUnitName = "jpa-1";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Person person = new Person("lv", "1@qq.com", 18);
		
		manager.persist(person);
		
		transaction.commit();
		
		manager.close();
		factory.close();
		System.out.println("Ok");
	
	
	}

}
