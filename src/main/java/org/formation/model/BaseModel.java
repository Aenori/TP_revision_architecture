package org.formation.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* Teacher note : for those who want an example of reflection
 * 
 * */
public abstract class BaseModel {
	private class MethodComparator implements Comparator<Method> {
		@Override
		public int compare(Method m0, Method m1) {
			return m0.getName().compareTo(m1.getName());
		}	
	}
	
	// NRO-example : reflection
	public String toString() {
		java.lang.reflect.Method[] fs = this.getClass().getMethods();
		ArrayList<Method> methodList = new ArrayList<Method>(
				Arrays.asList(fs)
		);
		
		methodList.sort(new MethodComparator());
		String result = this.getClass().getSimpleName();
		
		for(Method m: methodList) {
			
			if(m.getName().startsWith("get") 
					&& m.getName() != "getClass"
					&& ((m.getModifiers() & Modifier.STATIC) == 0)
				) {

				try {
					result += ";" + m.invoke(this).toString(); 
				} catch (NullPointerException e) {
					result += ";NULL";
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
					result += ";ERROR";
				}
			}
		}
		
		return result;
	}
}
