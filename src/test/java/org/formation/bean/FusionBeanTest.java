package org.formation.bean;

import java.util.ArrayList;
import java.util.List;

import org.formation.model.Formation;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class FusionBeanTest extends TestCase {
	public void testGetAllFusionneeFormations()
	{    
		// test avec MockedStatic
        try (MockedStatic<Formation> utilities = Mockito.mockStatic(Formation.class)) {
        	List<Formation> formation = new ArrayList<Formation>();
        	formation.add(new Formation("20210528",  null, null,300,"Fusionnee","Original",1));
        	formation.add(new Formation("20210527",  null, null,300,"Fusionnee","Original",1));
        	utilities.when(Formation::getAll).thenReturn(formation);
            assertEquals(2, FusionBean.selectFormationsFusionnees().size());
        }
        // test normale
        assertEquals(1, FusionBean.selectFormationsFusionnees().size());
	}
}
