package br.com.adrianopalomino.reflection.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassProperties {
	
    public static void main(String... params) {                 
        
        /*
         * Carregamos a classe Arquivo através do Class.forName que nos possibilita
         * carregar uma classe através de uma dada string que deve corresponder ao local
         * onde a classe está, além disso, por padrão a classe é carregada no ClassLoader
         * que está sendo utilizado pela classe que está executando o comando.
         * */
        Object arquivoFromReflection = null;
        try {
            arquivoFromReflection = Class.forName("br.com.adrianopalomino.reflection.example.Arquivo").newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        //Recupera o nome da classe
        System.out.println("Nome da Classe: "+arquivoFromReflection.getClass().getName());
         
        /*
         * A Classe Method do Reflection nos da a possibilidade de manusear
         * todos os métodos dentro do objeto carregado 
         * */
        System.out.println("");
        System.out.println("Métodos: ");
        for(Method m : arquivoFromReflection.getClass().getMethods()){
            System.out.print(m.getName()+", ");
        }
         
        /*
         * Vamos agora capturar os atributos da classe. Temos agora outra classe 
         * muito importante para uso do Reflection, a classe Field. Esta nos permite
         * manusear os campos/fields da nossa classe carregada.
         * */
        System.out.println("");
        System.out.println("Atributos: ");
        for(Field f : arquivoFromReflection.getClass().getDeclaredFields()){
            System.out.print(f.getName()+", ");
        }
         
        /*
         * Perceba que nossa abordagem é bem simples, ou seja, estamos capturando apenas
         * os nomes dos métodos e atributos, mas você pode ir muito além, capturando os modificadores, 
         * tipos, retorno e etc.
         * */
         
    }
 
}

