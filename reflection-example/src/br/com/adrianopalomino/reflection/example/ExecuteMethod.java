
package br.com.adrianopalomino.reflection.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecuteMethod {

	public static void main(String... args) {
		Person john = new Person("John", 35);
		
		//obtendo a classe
		Class johnClass = john.getClass();

		try {
			//obtendo o m�todo
			final Method setName = johnClass.getDeclaredMethod("setName", String.class);
			
			//instanciando a classe
			final Person johnChield = (Person) Class.forName("br.com.adrianopalomino.reflection.example.Person").newInstance();

			//invocando o m�todo
			setName.invoke(johnChield, john.getName().concat(" Son"));
			
			final Method getName = johnChield.getClass().getDeclaredMethod("getName");
			
			
			System.out.println("# What is the name of John's son? " + 	getName.invoke(johnChield, null));
			
			johnChield.setAge(0);
			System.out.println("# " + johnChield);
			
			//obtendo m�todo privado
			final Method hidden = johnChield.getClass().getDeclaredMethod("hidden");
			
			//alterando o modificador de acesso para acess�vel
			hidden.setAccessible(true);
			
			//invocando m�todo privado
			hidden.invoke(johnChield, null);

		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
