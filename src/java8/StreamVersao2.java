package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamVersao2 {

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
		  .findAny()          
	      .ifPresent(c-> System.out.println(c.getNome()));
		
		 
		//usando o maptoint calcular a media
		 OptionalDouble media = cursos.stream()
	    .filter(c-> c.getAlunos() >= 100)
		.mapToInt(Curso::getAlunos)
	    .average();
			
		System.out.println(media.getAsDouble());
		
		
		//tomap converte em um conjnto de chave e valor
		cursos.stream()
		.filter(c->c.getAlunos() >= 100)
		.collect(Collectors.toMap(
				c -> c.getNome(),
				c -> c.getAlunos()))
		.forEach((nome,alunos) -> System.out.println( nome + " tem "+ alunos +" alunos" ));
		
		//media de todos 
		 OptionalDouble mediatotal = cursos.stream()
					.mapToInt(Curso::getAlunos)
				    .average();
		
		 System.out.println(mediatotal.getAsDouble());
		 
		 // colocando o resultado do stream em  uma lista 
		 List<Curso> cursosFiltrados = cursos.stream()
				   .filter(c -> c.getAlunos() > 50)
				   .collect(Collectors.toList());
		 cursosFiltrados.forEach(curso -> System.out.println(curso.getNome()));
} }
