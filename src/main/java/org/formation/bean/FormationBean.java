package org.formation.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.formation.model.Formateur;
import org.formation.model.Formation;
import org.formation.model.Sujet;

public class FormationBean {

	public static Formation addNewFormation(String date, String nomSujet, String nomFormateur, String paieFormateur)
	{
		return (new FormationBean()).addNewFormationImpl(date, nomSujet, nomFormateur, paieFormateur);
	}
	
	Formation addNewFormationImpl(String date, String nomSujet, String nomFormateur, String paieFormateur) {
		Sujet sujet = searchSujetByNom(nomSujet);
		Formateur formateur = searchOrCreateFormateurByNom(nomFormateur);

		Integer paie = 0;
		try {
			paie = Integer.parseInt(paieFormateur);
		}
		catch(Exception e) {}
		
		Formation formation = new Formation(date, sujet, formateur, paie);
		Formation.getAll().add(formation);
		
		return formation;
	}
	
	Formateur searchOrCreateFormateurByNom(String nomFormateur) {
		Formateur formateur = null;
		
		List<Formateur> formateurs = Formateur.getAll();
		
		for(Formateur f: formateurs) {
			if(f.getNom().equals(nomFormateur)) {
				formateur = f;
				break;
			}
		}
		
		if(formateur == null) { formateur = new Formateur(nomFormateur); }
		return formateur;
	}

	Sujet searchSujetByNom(String nomSujet) {
		Sujet sujet = null;
		List<Sujet> sujets = Sujet.getAll();
		for(Sujet s: sujets) {
			if(s.getNom().equals(nomSujet)) {
				sujet = s;
				break;
			}
		}
		
		if(sujet == null) { sujet = new Sujet(nomSujet); }
		
		return sujet;
	}

	public static List<Formation> getAllActiveFormations() {
		return Formation.getAll()
				// NRO : important !
				.stream()
				// NRO : Pour ceux qui voulaient voir les lambda fonctions
				.filter(s -> s.getStatut() == "Active")
				.collect(Collectors.toList());
	}
}
