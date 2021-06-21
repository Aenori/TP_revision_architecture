package org.aenori.interfaces;

/* NRO 2021-06-18
 *
 * This interface is used in combination with IVisitorReservation
 * Please note that in the particular of this application, defining 
 * it is a little bit of overkill.
 *
 * This is provided as an example of Interface segregation
 * The main purpose being to state what the IVisitorReservation needs
 * as it doesn't need everything there is in a reservation  
 */
public interface IVisitableReservation {
	public void accept(IVisitorReservation vr);
}