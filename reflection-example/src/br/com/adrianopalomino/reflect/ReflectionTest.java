package br.com.adrianopalomino.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class it's used to invoke a private method of another class using reflection
 * 
 * @author adrianopalomino
 *
 */
public class ReflectionTest {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		// here we instantiate an object of the class ReflectClass
		ReflectClass reflect = (ReflectClass) Class.forName("br.com.adrianopalomino.reflect.ReflectClass")
				.newInstance();

		// here we get object class
		Class pkClass = reflect.getClass();

		// here we o get first field of the class
		Field fld = pkClass.getDeclaredFields()[0];

		// here we get private method of class - this is private method
		Method privateMethod = pkClass.getDeclaredMethod("set" + fld.getName().replaceFirst("a", "A"), fld.getType());

		// here we have become the private method accessible for external use
		// the class
		if (!privateMethod.isAccessible())
			privateMethod.setAccessible(Boolean.TRUE);

		// here we invoke the method of object reflect
		privateMethod.invoke(reflect, 123);
		
		// print the reflect object
		System.out.println(reflect);

	}

}
