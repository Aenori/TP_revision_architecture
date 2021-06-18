package org.formation.model;

import java.util.List;

public class Sujet extends BaseModel {	
	private Integer id;
	private String nom;
	
	// Region static members
	private static List<Sujet> sujetList = null;
	
	public static List<Sujet> getAll() {
		if(sujetList == null) sujetList = Fixture.getSujetList();
		return sujetList;
	}
	// End of static members region
	public Sujet(String nom) {
		this(nom, getAll().size() + 1);
	}
	
	public Sujet(String nom, int i) {
		super();
		this.nom = nom;
		this.id = i;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
