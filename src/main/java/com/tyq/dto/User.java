package com.tyq.dto;

/**
 * 实体类，暂时不进行级联属性，忽略Address
 * @author tyq
 *
 */
public class User {
	
	private Integer id;
	private String  name;
	private String lastName;
	private int age;
	private Address address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User() {
		super();
	}
	public User(Integer id, String name, String lastName, int age, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}
	public User(Integer id, String name, String lastName, int age) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	@Override
	public String toString() {
		return "GodMan [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", address="
				+ address + "]";
	}
	
	

}
