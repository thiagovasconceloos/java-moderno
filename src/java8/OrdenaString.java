package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaString {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("Alura Online");
		palavras.add("Casa do Codigo");
		palavras.add("Caelum");
		
		
		//Comparator <String> comparador = new ComparadorPorTamanho();
		//Collections.sort(palavras,comparador);
		
		palavras.forEach(palavra -> System.out.println(palavra));
       
		//Mudando o criterio de ordenação ja no metodo sort 
		//conhecimento adquerido nos cursos anteriores
		
		// palavras.sort((s1,s2)-> Integer.compare(s1.length(),s2.length()));
		

		 
		 palavras.sort((Comparator.comparing(s -> s.length())));
		 // equivalente a linha acima
		 palavras.sort(Comparator.comparing(String::length));		 
		 //metodo sort usand ocriterio Case_Insensitive_Order;
		 palavras.sort(String.CASE_INSENSITIVE_ORDER);
		 
		 palavras.sort(Comparator.comparing(String::length));		 
	   
		palavras.forEach(palavra -> System.out.println(palavra));
		palavras.forEach(System.out::println);
	
	} }




class ComparadorPorTamanho implements Comparator <String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()) {
			return -1;
		} 
		if(s1.length() > s2.length()) {
			return 1;
		}
			
			
			
		return 0;
	} }
	
	

