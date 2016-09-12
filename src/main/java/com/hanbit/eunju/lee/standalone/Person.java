package com.hanbit.eunju.lee.standalone;

public class Person {
	public static final String HOSPITAL = "����";
	public static final String HOME = "��";
	public static final String SCHOOL = "�б�";

	private int age;
	private String name;
	private String location;

	public Person() {
		age = 1;
		location = "����";
	}

	public void liveYear() {
		age++;
	}

	public int getAge(){
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	private void go(String location) {
		this.location = location;
	}

	public void goHome() {
		go(HOME);
	}

	public void goSchool() {
		go(SCHOOL);
	}

	public void goHospital() {
		go(HOSPITAL);
	}
}
