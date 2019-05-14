package br.com.adrianopalomino.reflection.example;

import java.lang.reflect.Field;
import java.util.List;

public class ArrayFind {

	public static void main(String[] args) {
		
		
		boolean found = false;
		try {
			List array = (List) Class.forName("java.util.ArrayList").newInstance();
			Class<?> cls = array.getClass();
			Field[] flds = cls.getDeclaredFields();
			for (Field f : flds) {
				Class<?> c = f.getType();
				if (c.isArray()) {
					found = true;
					System.out.format(
							"%s%n" + "           Field: %s%n" + "            Type: %s%n" + "  Component Type: %s%n", f,
							f.getName(), c, c.getComponentType());
				}
			}
			if (!found) {
				System.out.format("No array fields%n");
			}

			// production code should handle this exception more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
