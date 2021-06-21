package org.aenori.business.factories.decorator;

import java.net.http.HttpRequest;

import org.aenori.interfaces.IReservationFactory;
import org.aenori.model.reservations.PlaneReservation;
import org.aenori.model.reservations.Reservation;
import org.aenori.model.reservations.bonus.Bonus;

import jakarta.servlet.http.HttpServletRequest;

// Cette classe implemente le design pattern decorator.
// Elle prend en entree un autre objet de type IReservationAbstractFactory
// et rajoute une fonctionnalité
public class PlaneForbidCompanyDecorator implements IReservationFactory {
	private IReservationFactory decorated;
	private String forbiddenCompany;
	
	public PlaneForbidCompanyDecorator(IReservationFactory decorated, String forbiddenCompany) {
		this.decorated = decorated;
		this.forbiddenCompany = forbiddenCompany;
	}
	
	@Override
	public Reservation createReservationFromRequest(HttpServletRequest request) throws Exception {
		if(request.getParameter("company").equals(forbiddenCompany)) {
			throw new Exception("Company " + forbiddenCompany + " is currently " +
					"forbidden, please contact the manager");
		}
		return decorated.createReservationFromRequest(request);
	}

	@Override
	public Bonus createBonusFromRequest(HttpServletRequest request, Reservation reservation) throws Exception {
		// TODO Auto-generated method stub
		return decorated.createBonusFromRequest(request, reservation);
	}
}
