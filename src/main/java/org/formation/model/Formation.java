package org.formation.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.annotation.ManagedBean;

@ManagedBean
public class Formation extends BaseModel {
	private String date;
	private Sujet sujet;
	private Formateur formateur;
	private Integer paieFormateur;

	private String statut;
	private static final String[] allowedStatus = new String[] {
			"Active", "Annulee", "Remboursee", "Fusionnee"
	};

	private String statutFormateur;
	private static final String[] allowedTrainerStatus = new String[] {
			"Original", "Remplace"
	};

	private Integer id;
	private Set<Formation> formationsFusionnees = new HashSet<Formation>();

	// Region static members
	private static List<Formation> formationList = null;

	public static List<Formation> getAll() {
		if(formationList == null) formationList = Fixture.getFormationList();
		return formationList;
	}
	// End of static members region

	public Formation() {}
	public Formation(String date, Sujet sujet, Formateur formateur, Integer paieFormateur, String statut,
			String statutFormateur, Integer id) {
		super();
		this.date = date;
		this.sujet = sujet;
		this.formateur = formateur;
		this.paieFormateur = paieFormateur;
		this.setStatut(statut);
		this.setStatutFormateur(statutFormateur);
		this.id = id;
	}

	public Formation(String date, Sujet sujet, Formateur formateur, Integer paieFormateur) {
		this(date, sujet, formateur, paieFormateur, "Active", "Original", Formation.getAll().size() + 1);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		if(statut != null) {
			if(!Arrays.asList(allowedStatus).contains(statut)) {
				throw new IllegalArgumentException("Invalid statut " + statut);
			}
		}
		this.statut = statut;
	}

	public String getStatutFormateur() {
		return statutFormateur;
	}

	public void setStatutFormateur(String statutFormateur) {
		if(statutFormateur != null) {
			if(!Arrays.asList(allowedTrainerStatus).contains(statutFormateur)) {
				throw new IllegalArgumentException("Invalid statut formateur " + statutFormateur);
			}
		}
		this.statutFormateur = statutFormateur;
	}

	public Integer getPaieFormateur() {
		return paieFormateur;
	}

	public void setPaieFormateur(Integer paieFormateur) {
		this.paieFormateur = paieFormateur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isRemboursee () {
		return getStatut().equals("Remboursee");
	}
	
	public boolean isFusionnee() {
		return this.statut.equals("Fusionnee");
	}

	public boolean isAnnulee(){
		return this.statut.equals("Annulee");
	}
}

