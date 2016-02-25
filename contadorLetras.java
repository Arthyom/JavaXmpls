import java.io.*;
import java.lang.*;
import java.util.*;

class contName{

	public static void main(String[] args) {
		char 		caracter = 'a';
		String		cadEmtrada = "esta es una cadena de entrada";
		char		charEntrada [] = cadEmtrada.toCharArray();
		int 		suma 		= 0 ;

		for ( int i = 0 ; i < charEntrada.length ; i++ ){
			if ( charEntrada[i] == caracter )
				suma++;
		}

		System.out.println("la occurrencia para la letra -> "+ caracter + " dentro de la palabra "+ cadEmtrada +" es "+ suma );

		String conjunto []= {"nombre","nombre2","nombre2", "nombre"};

		int conjunt = contarName( "nombre2", conjunto);
		System.out.println(conjunt);


	
	}

	public static int 	contarName ( String cadEntrada, String [] conjuntoPalabra){
		int suma = 0 ;
		// contar cuantas palabras identicas a una palabra de entrada existen en una cadena de entrarada
		for ( int i = 0 ; i < conjuntoPalabra.length ; i ++ ){ 
			String cadCmp = conjuntoPalabra[i];
			System.out.println( cadCmp + "   " + cadEntrada );

			if ( cadCmp.compareTo(cadEntrada) == 0 )
				suma++;

				
	

				
		
		}

			return suma;
	}
}