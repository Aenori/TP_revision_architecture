package org.formation.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.formation.bean.FormationBean;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import org.junit.Assert;

import junit.framework.TestCase;

public class FormationTest extends TestCase {
	public void testToString()
	{     
		Formation formation = new Formation(
        		"20210528", null      , null, 300,
        		"Active"  , "Original", 1);
		
        assertEquals(
        	"Formation;20210528;NULL;1;300;Active;Original;NULL",
        	formation.toString()
        );
        
        // NRO-example : mocking instance method spy
        Formation formationSpied = spy(formation);
        when(formationSpied.getDate()).thenReturn("ma date");
        
        assertEquals(
            "Formation;ma date;NULL;1;300;Active;Original;NULL",
            formationSpied.toString()
        );
    }
	
	public void testGetAll() {
		// What we are mainly testing here is that the method call doesn't raise
		// an error
		assertTrue(Formation.getAll() instanceof List<?>);
	}
	
	public void testGetFusionnee() {
		assertEquals(1,Formation.getAll().stream().filter(p -> p.isFusionnee()).collect(Collectors.toList()).size());
	}
	
	public void testGetAllIncludeOneRembourse() {
		// What we are mainly testing here is that the method call doesn't raise
		// an error
		assertTrue(Formation.getAll() instanceof List<?>);
		assertEquals(1,Formation.getAll().stream().filter(p -> p.isRemboursee()).collect(Collectors.toList()).size());
	}
	
	public void testIsFusionnee() {
		assertFalse(new Formation("20210528",  null, null,300,"Active","Original",1).isFusionnee());
		assertTrue(new Formation("20210528",  null, null,300,"Fusionnee","Original",1).isFusionnee());
	}

	public void testIsAnnulee() {
		assertFalse(new Formation("20210528",  null, null,300,"Active","Original",1).isAnnulee());
		assertTrue(new Formation("20210528",  null, null,300,"Annulee","Original",1).isAnnulee());
	}

	public void testOneOfAllAnnulee() {
		assertEquals(Formation.getAll().stream().filter((s) -> s.isAnnulee()).count(),1);
	}
	
	public void testIsRemboursee() {
		assertTrue(new Formation("20210601",null, null, 250, "Remboursee","Original", 666).isRemboursee());
		assertFalse(new Formation("20210602",null, null, 700, "Annulee","Original", 333).isRemboursee());
	}
}
