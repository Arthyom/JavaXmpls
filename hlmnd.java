import java.util.*;
import java.io.*;
import java.lang.*;


class holaMundo{

  public static void main(String[] args) {
    System.out.println("hola mundo");

    // declaracion multilinea en java
    System.out.println("esta es una"
    +"declaracion "
    +"con mas"
    +"de una sola linea"

    );

    //mostrar la raiz de una numero entero
    int numero = 4;
    System.out.println("raiz de un numero -<" + Math.sqrt(numero));

    /* los tipos de vatiables en java van de orden gerarquico
      * bite
      * short

      tambien se puede indicar al java de qe tipo ha de ser un valor al
      momento de asignarse poniendo la inicial tras su valor F,D,L et

      */
      final float PI = 3.1416F;
      System.out.println(PI);

      // java posee soporte para cadenas
      String cadena = "esta es una cadena marica";
      System.out.println(cadena+" hola");

      String cadena2 = "esta tambien es una cadena marica" + cadena;
      System.out.println(cadena2);

      // trabajo con cadenas de caracter
      String cadena3 = "esta es una cadena";
      String cadena4 = "esta no es una cadena";
      System.out.println(cadena3.equals(cadena4));
      System.out.println(cadena4.toUpperCase());
      System.out.println(cadena4.indexOf('n'));
  }

}
