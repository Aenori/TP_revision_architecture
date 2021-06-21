package org.aenori.business.factories.decorator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aenori.interfaces.IReservationFactory;
import org.aenori.model.reservations.Reservation;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import jakarta.servlet.http.HttpServletRequest;
import junit.framework.TestCase;

public class PlaneForbidCompanyDecoratorTest extends TestCase {	
	public void testDecoratorDesignPattern() throws Exception
	{    
		HttpServletRequest hsrMockAF = mock(HttpServletRequest.class);
		HttpServletRequest hsrMockU2 = mock(HttpServletRequest.class); 
		IReservationFactory irfMock = mock(IReservationFactory.class);
		
		Reservation fakeReservation = mock(Reservation.class);
		
		when(hsrMockAF.getParameter("company")).thenReturn("AF");
		when(hsrMockU2.getParameter("company")).thenReturn("U2");
		
		when(irfMock.createReservationFromRequest(ArgumentMatchers.any())).thenReturn(fakeReservation);
		
		IReservationFactory decorator = new PlaneForbidCompanyDecorator(irfMock, "AF");
		
		assertEquals(decorator.createReservationFromRequest(hsrMockU2), fakeReservation);
		
		try {
			decorator.createReservationFromRequest(hsrMockAF);
			fail();
		}
		catch(Exception exception) {
			// Ok !
		}
	}
}