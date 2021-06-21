package org.aenori.business.rules;

import java.util.*;

import org.aenori.business.factories.PlaneReservationFactory;
import org.aenori.business.factories.decorator.PlaneForbidCompanyDecorator;
import org.aenori.interfaces.IReservationFactory;

public class BusinessRules {
	private static BusinessRules instance = null;

	public static BusinessRules getInstance() {
		if(instance == null) instance = new BusinessRules();
		return instance;
	}
	
	private List<String> forbiddenCompany = new ArrayList<String>();
	
	public IReservationFactory getFactoryWithForbid() {
		return getFactoryWithForbid(new PlaneReservationFactory());
	}
	
	public IReservationFactory getFactoryWithForbid(IReservationFactory reservationFactory) {		
		for(String s: forbiddenCompany) {
			reservationFactory = new PlaneForbidCompanyDecorator(reservationFactory, s);
		}
		
		return reservationFactory;
	}
	
}
