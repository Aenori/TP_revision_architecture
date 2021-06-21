package org.aenori.model;

public class Person {
	private Integer id;
	private Integer role;
	
	public Person(Integer id, Integer role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
}