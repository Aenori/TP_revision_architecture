package org.formation.bean;

import java.util.List;
import java.util.stream.Collectors;

import org.formation.model.Formation;

public class FusionBean {
	public static List<Formation> selectFormationsFusionnees() {
		return Formation.getAll()
				.stream()
				.filter(s -> s.getStatut() == "Fusionnee").collect(Collectors.toList());
	}
}
