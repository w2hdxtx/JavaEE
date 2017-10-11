package com.lv.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.ejb.QueryHints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lv.entity.Category;
import com.lv.entity.Customer;
import com.lv.entity.Husband;
import com.lv.entity.Order;
import com.lv.entity.Person;
import com.lv.entity.Productor;
import com.lv.entity.Wife;

public class JPATest {
	
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	
	@Before
	public void init() {
		
		factory = Persistence.createEntityManagerFactory("jpa-1");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		
	}
	
	@After
	public void destory() {
		
		transaction.commit();
		manager.close();
		factory.close();
	}
	

//	// 保存多对一时, 建议先保存 1 的一端, 后保存 n 的一端, 这样不会多出额外的 UPDATE 语句.
//	@Test
//	public void testMany2OnePersist() {
//		
//		Customer customer = new Customer();
//		customer.setName("lvlv");
//		
//		Order order1 = new Order();
//		order1.setName("lvlv_order_1");
//		order1.setCustomer(customer);
//		
//		Order order2 = new Order();
//		order2.setName("lvlv_order_2");
//		order2.setCustomer(customer);
//		
//		manager.persist(customer);
//		manager.persist(order1);
//		manager.persist(order2);
//	}
//	
	
	@Test
	public void  testMany2OneFind() {
		
		Order order = manager.find(Order.class, 1);
		System.out.println(order.getName());
		System.out.println("-----------------");
		System.out.println(order.getCustomer().getName());
		
		
	}
//	
//	
//	@Test
//	public void  testMany2OneUpdate() {
//		
//		Order order = manager.find(Order.class, 1);
//		order.getCustomer().setName("mike");
//		
//	}
//	
//	
//	
//	@Test
//	public void  testMany2OneRomove() {
//		
////		Customer customer = manager.find(Customer.class, 1);
////		manager.remove(customer);
//		
//		Order order = manager.find(Order.class, 2);
//		manager.remove(order);
//	}
//	
	
	
	
	
	
//	@Test
//	public void testOnt2ManyPersist() {
//		
//		Customer customer = new Customer();
//		customer.setName("lvlv");
//		
//		Order order1 = new Order();
//		order1.setName("order1");
//		
//		Order order2 = new Order();
//		order2.setName("order2");
//		
//		customer.getOrders().add(order1);
//		customer.getOrders().add(order2);
//		
//		order1.setCustomer(customer);
//		order2.setCustomer(customer);
//		
//		manager.persist(customer);
//		manager.persist(order1);
//		manager.persist(order2);
//		
//		
//	}
	
	
	
//	@Test
//	public void testOnt2ManyFind() {
//		
//		Customer customer = manager.find(Customer.class, 1);
//		
//		System.out.println(customer.getName());
//		System.out.println("------");
//		System.out.println(customer.getOrders().size());
//		
//		
//	}
//	
	
//	@Test
//	public void testOnt2ManyRemove() {
//		
//		Customer customer = manager.find(Customer.class, 1);
//		manager.remove(customer);
//	}
	
	
	
//	@Test
//	public void testOne2One1() {
//		
//		Husband husband = new Husband();
//		husband.setName("hus1");
//		
//		Wife wife = new Wife();
//		wife.setName("wife1");
//		
//		husband.setWife(wife);
//		wife.setHusband(husband);
//		
//		manager.persist(husband);
//		manager.persist(wife);
//		
//		
//	}
	
	
//	@Test
//	public void testOne2One2() {
//		
//		Wife wife = manager.find(Wife.class, 1);
//		System.out.println(wife.getName());
//		System.out.println("------------------");
//		System.out.println(wife.getHusband().getName());
//		
//	}
//	
////	
//	@Test
//	public void testOne2One3() {
//		
//		Husband husband = manager.find(Husband.class, 1);
//		System.out.println(husband.getName());
//		System.out.println("------------------");
//		System.out.println(husband.getWife().getName());
//		
//	}
//	
	
	
//	@Test
//	public void testMany2Many() {
//		
//		Productor p1 = new Productor();
//		p1.setName("p1");
//		Productor p2 = new Productor();
//		p2.setName("p2");
//		
//		Category c1 = new Category();
//		c1.setName("c1");
//		Category c2 = new Category();
//		c2.setName("c2");
//		
//		p1.getCategories().add(c1);
//		p1.getCategories().add(c2);
//		p2.getCategories().add(c1);
//		p2.getCategories().add(c2);
//		
//		
//		c1.getProductors().add(p1);
//		c1.getProductors().add(p2);
//		c2.getProductors().add(p1);
//		c2.getProductors().add(p2);
//		
//		
//		manager.persist(c1);
//		manager.persist(c2);
//		manager.persist(p1);
//		manager.persist(p2);
//		
//		
//	}
	
//	@Test
//	public void testMnay2Many2() {
//		
//		Productor productor = manager.find(Productor.class, 1);
//		System.out.println(productor.getName());
//		System.out.println("-----------");
//		System.out.println(productor.getCategories().size());
//		
//	}
	
	
//	@Test
//	public void testEhcache() {
//		
//		Customer customer1 = manager.find(Customer.class, 1);
//		manager.close();
//		transaction.commit();
//		manager = factory.createEntityManager();
//		transaction = manager.getTransaction();
//		transaction.begin();
//		Customer customer2 = manager.find(Customer.class, 1);
//		
//		
//	}
	
	
//	@Test
//	public void testHello() {
//		
//		String jpql = "from Person p where p.id > ?";
//		Query query = manager.createQuery(jpql).setParameter(1, 2);
//		List<Person> persons = query.getResultList();
//		System.out.println(persons.size());
//	}
	
	
//	@Test
//	public void testHello2() {
//		
//		String jpql = "FROM Person p WHERE p.id > ?";
//		Query query = manager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);
//		
//		//占位符的索引是从 1 开始
//		query.setParameter(1, 1);
//		List<Customer> customers = query.getResultList();
//		System.out.println(customers.size());
//		
//		query = manager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);
//		
//		//占位符的索引是从 1 开始
//		query.setParameter(1, 1);
//		customers = query.getResultList();
//		System.out.println(customers.size());
//	}
//	
//	@Test
//	public void testNamedQuery() {
//		
//		Query query = manager.createNamedQuery("namedQuery").setParameter(1, 1);
//		Person person = (Person) query.getSingleResult();
//		System.out.println(person);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}








