package org.formation.model;

import junit.framework.TestCase;

public class BaseModelTest extends TestCase {
	private class ModelWithName extends BaseModel {
		private String name;
		public ModelWithName(String name) { this.name = name; }
		public String getName() { return name; }
	}
	
    public void testModelWithNameToString()
    {     
        assertEquals(
        		"ModelWithName;nom",
        		(new ModelWithName("nom")).toString()
        );
    }
}
