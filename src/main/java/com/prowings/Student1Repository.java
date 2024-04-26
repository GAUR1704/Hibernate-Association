package com.prowings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Student1Repository {

	public static void main(String[] args) {

		Student1 s1 = new Student1("Sham", "Mumbai", 99);
		Student1 s2 = new Student1("Ram", "Pune", 85);
		Student1 s3 = new Student1("Gaurav", "Nagpur", 69);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction txn = session.beginTransaction();

		session.save(s1);
		session.save(s2);
		session.save(s3);

		txn.commit();

		session.close();

	}

}
