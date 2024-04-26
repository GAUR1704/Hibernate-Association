package com.prowings.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		
		Question q1 = new Question();
		
		q1.setQuestion("What is your name ? ");
		
		Answer ans1 = new Answer();
		
		ans1.setAnswerId(10);
		ans1.setAnswer("My name is Gaurav.");
		ans1.setQuestion(q1);
		q1.setAnswer(ans1);
		
		
		Question q2 = new Question();
		
		q2.setQuestion("Where are you from ? ");
		
		Answer ans2 = new Answer();
		
		ans2.setAnswerId(20);
		
		ans2.setAnswer("I am from Bhandara.");
		
		ans2.setQuestion(q2);
		q2.setAnswer(ans2);
		
		Session s = session.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
		s.save(q2);
		s.save(ans1);
		s.save(ans2);
		
		tx.commit();
		
//		fetching the data
		
		Question newQ = s.get(Question.class, 2);
		
		System.out.println(newQ.getQuestion());
		
		System.out.println(newQ.getAnswer().getAnswer());
		
		
 
		s.close();
		

	}

}
