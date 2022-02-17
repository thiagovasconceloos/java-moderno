package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream {

	public static void main(String[] args) {
		
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
	 
		//Metodos referece
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		//Lambdas
		cursos.forEach(curso -> System.out.println(curso.getAlunos()));
		//tudo que for feito no metodo stream não afeta a coleção original
		
		// Usando a interface stream para buscar cursos com mais de 100 alunos, e também mostrando quais são esses cursos.
		cursos.stream()
		  .filter(c-> c.getAlunos() >= 100)
		  .forEach(c-> System.out.println(c.getNome()));              
		
		
		//filtrando cursos com mais de 100 alunos e usando o metodo reference para mostrar a quantidade 
		cursos.stream()
		  .filter(c-> c.getAlunos() >= 100)
		  .map(Curso::getAlunos)
		  .forEach(System.out::println);
		
		//usando o maptoint para somar a quantidade total de alunos 
		int sum = cursos.stream()
		  .filter(c-> c.getAlunos() >= 100)
		  .mapToInt(Curso::getAlunos)
		  .sum();
		
		
		System.out.println(sum);
		
		//Exercicio 
		cursos.stream()
		  .filter(c-> c.getAlunos() > 50)
		  .forEach(c-> System.out.println(c.getNome())); 
		
		//Exercicio 2
		cursos.stream()
		  .filter(c-> c.getAlunos() > 50)
		  .map(Curso::getAlunos)
		  .forEach(System.out::println);
		
	}

}
