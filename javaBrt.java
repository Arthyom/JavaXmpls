import java.util.*;
import java.io.*;
import java.lang.*;

class backFeet{

	public static void main(String[] args) {
		
		// vectores en java
		int vector [] = new int [3] ;
		int [] vector2 = new int [6];

		/*	la posicion de los corchetes es indiferentes */

		for (int i = 0 ; i < vector.length ; i ++ )
			System.out.println(vector[i]);
		// para recorrer un vecotr se acceder a suspropiedades publicas 

		// las matrices en java tambien estan definadas 
		int [][] matriz =  new int [3][3];
		for (int i = 0 ; i < matriz.length ; i ++ )
			for ( int j = 0 ; j < matriz[i].length ; j ++ )
				System.out.println(matriz[i][j]);
		
		// los arreglos multidimencionales tambien pueden ser iterados
		int cubo [][][] = new int [3][3][3];
		for (int i = 0 ; i < cubo.length ; i ++ )
			for ( int j = 0 ; j < cubo[i].length ; j ++ )
				for ( int k = 0 ; k < cubo[i][j].length ; k++)
					System.out.println(cubo[i][j][k]);

		// las cadenas tambien estan definidas en java 
		String cadena   = "esta es una cadea";
		String cadena2  = "esta tambien es una cadena ";

		if ( cadena.compareTo(cadena2) == 0)
			System.out.println("la cadena " + cadena + " es igual a la cadena "+ cadena2 );
		else
			System.out.println(" las cadenas son distintas");

		// los arreglos en java tambien permiten la incializacion en la declaracion 
		int [] arreglo = {1,2,3,5,6,7};

		for (int i = 0 ; i < arreglo.length ; i ++)
			System.out.println(arreglo[i]);

		String cadenas [] = {"nombre1", "nombre2", "nombre3", "nombre4", "nombre5"};
		for ( int i = 0 ; i < cadenas.length ; i++ )
			System.out.println(cadenas[i]);


		// las cademas tambien úeden cortarse y convertirse en char's
		char charCad [] = cadena.toCharArray();
		for ( int i = 0 ; i < charCad.length; i++ )
			System.out.println(charCad[i]);

		// las cadenas pueden ser ordenadas mediante el metodo de la case array
	    Arrays.sort(charCad);
	    for (int i= 0 ; i < charCad.length ; i ++ )
	    	System.out.println(charCad[i]);









	}

}