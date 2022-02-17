package java8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DataAPI {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		
		System.out.println(hoje);
		
		
		LocalDate aniversario = LocalDate.of(2022,Month.AUGUST,27);
		//diferen�a entre meses
		int meses = aniversario.getMonthValue() - hoje.getMonthValue();

		System.out.println(meses);
		
	    //diferen�a entre dias 
		Period periodo = Period.between(hoje, aniversario);
		System.out.println(periodo.getDays());
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatter.format(hoje);
		System.out.println(dataFormatada);
	}

}
