package com.prowings.OneToManyMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String brand;
	private String processer;

	@ManyToOne
	private Student student;

	public Laptop() {
		super();
	}

	public Laptop(String brand, String processer) {
		super();
//		this.id = id;
		this.brand = brand;
		this.processer = processer;
	}

	public Laptop(int id, String brand, String processer, Student student) {
		super();
		this.id = id;
		this.brand = brand;
		this.processer = processer;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProcesser() {
		return processer;
	}

	public void setProcesser(String processer) {
		this.processer = processer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", processer=" + processer + ", student=" + student + "]";
	}

	
}
