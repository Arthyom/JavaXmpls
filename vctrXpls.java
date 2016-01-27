import java.util.*;
import java.lang.*;
import java.io.*;

class vectores{

  public static void main(String[] args) {

    // declarar vectores
    int vectorInt [] = new int [3];
    int matrizInt [][] = new int [3][3];

    // arreglos dinamicos
    int n = 3;
    int m = 4;
    int matriz [][] = new int [n][m];

    // se puede iterar para cada caracter de una cadena de chars "toCharArray"
    String cad = "esta es una cadena";

    char array[] = cad.toCharArray();
    for (int i = 0 ; i < array.length ; i ++ ){
      System.out.print(array[i]);
    }


  }

}
