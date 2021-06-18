package org.formation.model;

import junit.framework.TestCase;

public class FormateurTest extends TestCase {
	public void testToString()
	{     
        assertEquals(
        	"Formateur;1;Dumbledore;500;[]",
        	(new Formateur("Dumbledore", 500, 1)).toString()
        );
    }
}
