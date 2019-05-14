
package br.com.adrianopalomino.reflection.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecuteMethod {

	public static void main(String... args) {
		Person john = new Person("John", 35);
		
		//obtendo a classe
		Class johnClass = john.getClass();

		try {
			//obtendo o método
			final Method setName = johnClass.getDeclaredMethod("setName", String.class);
			
			//instanciando a classe
			final Person johnChield = (Person) Class.forName("br.com.adrianopalomino.reflection.example.Person").newInstance();

			//invocando o método
			setName.invoke(johnChield, john.getName().concat(" Son"));
			
			final Method getName = johnChield.getClass().getDeclaredMethod("getName");
			
			
			System.out.println("# What is the name of John's son? " + 	getName.invoke(johnChield, null));
			
			johnChield.setAge(0);
			System.out.println("# " + johnChield);
			
			//obtendo método privado
			final Method hidden = johnChield.getClass().getDeclaredMethod("hidden");
			
			//alterando o modificador de acesso para acessível
			hidden.setAccessible(true);
			
			//invocando método privado
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
