package com.prowings.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		Transaction txn = s.beginTransaction();
		
		Student std = new Student();
		std.setName("Gaurav");
		
		Student s1 = new Student();
		s1.setId(1212);
		s1.setName("one student have many laptop");
		
		Laptop laptop1 = new Laptop();
		laptop1.setBrand("Dell");
		laptop1.setProcesser("intel i5");
		
		Laptop laptop2 = new Laptop();
		laptop2.setBrand("HP");
		laptop2.setProcesser("Ryzen 5");
		
		Laptop laptop3 = new Laptop();
		laptop3.setBrand("Lenovo");
		laptop3.setProcesser("intel i3");
		
		Laptop laptop4 = new Laptop();
		laptop4.setBrand("Asus");
		laptop4.setProcesser("Ryzen 3");
		
		List<Laptop> listOfLaptop = new ArrayList<Laptop>();
		listOfLaptop.add(laptop1);
		listOfLaptop.add(laptop2);
		listOfLaptop.add(laptop3);
		listOfLaptop.add(laptop4);
		std.setLaptop(listOfLaptop);
		
		
		
		s.save(std);
		s.save(laptop1);
		s.save(laptop2);
		s.save(laptop3);
		s.save(laptop4);
		
		Student s2 = s.get(Student.class,1);
		
		System.out.println(s2.getName());
		
		for(Laptop l : s2.getLaptop()) {
			
			System.out.println(l.getBrand());
			System.out.println(l.getProcesser());
		}
		
			
		txn.commit();

		sessionFactory.close();
		
		
		
		

	
	}
	

}
