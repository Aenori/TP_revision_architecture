package org.formation.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

public class Formateur extends BaseModel {
	private String nom;
	private Integer Solde;
	private Integer id;
	Set<Sujet> sujets = new HashSet();
	
	// Region static members
	private static List<Formateur> formateurList = null;
	
	public static List<Formateur> getAll() {
		if(formateurList == null) formateurList = Fixture.getFormateurList();
		return formateurList;
	}
	// End of static members region
	
	public Formateur() {}
	public Formateur(String nom) {
		this(nom, getAll().size() + 1);
	}
	public Formateur(String nom, Integer id) {
		this(nom, 0, id);
	}
	public Formateur(String nom, Integer solde, Integer id) {
		super();
		this.nom = nom;
		Solde = solde;
		this.id = id;
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

	public Integer getSolde() {
		return Solde;
	}

	public void setSolde(Integer solde) {
		Solde = solde;
	}

	public Set<Sujet> getSujets() {
		return sujets;
	}
}
