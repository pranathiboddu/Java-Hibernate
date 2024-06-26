package com.javacourse.DemoHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student 
{
	@Id
	private int rollno;
	private String name;
	private int marks;
	
//	@OneToOne
//	private Laptop laptop;

//	@OneToMany(mappedBy = "student" )
//	private List<Laptop> laptop1 = new ArrayList<>(); //generate getters and setters

	@ManyToMany(mappedBy = "student")
	private List<Laptop> laptop1 = new ArrayList<>(); //generate getters and setters	
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
//	public Laptop getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}
	
	public List<Laptop> getLaptop1() {
		return laptop1;
	}
	public void setLaptop1(List<Laptop> laptop1) {
		this.laptop1 = laptop1;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
}
