package org.formation.bean;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.formation.model.Formation;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;
import org.mockito.ArgumentMatchers.*;

import junit.framework.TestCase;

public class FormationBeanTest extends TestCase {
	public void testGetAllActiveFormations()
	{     
		assertEquals(2, FormationBean.getAllActiveFormations().size());

		// NRO-example : mocking static method
		try (MockedStatic<Formation> utilities = Mockito.mockStatic(Formation.class)) {
			utilities.when(Formation::getAll).thenReturn(new ArrayList());

			assertEquals(0, FormationBean.getAllActiveFormations().size());
		}
	}

	public void testAddNewFormation()
	{
		try (MockedStatic<Formation> utilities = Mockito.mockStatic(Formation.class)) {
			ArrayList<Formation> formationList = new ArrayList();
			utilities.when(Formation::getAll).thenReturn(formationList);

			assertEquals(0, Formation.getAll().size());

			FormationBean fbMock = spy(FormationBean.class); 

			when(fbMock.searchOrCreateFormateurByNom(ArgumentMatchers.anyString())).thenReturn(null);
			when(fbMock.searchSujetByNom(ArgumentMatchers.anyString())).thenReturn(null);

			Formation f = fbMock.addNewFormationImpl("2020", "formateur", "sujet", "200");
			assertTrue(f.getFormateur() == null);
			assertEquals(1, Formation.getAll().size());
		}
	}
}
