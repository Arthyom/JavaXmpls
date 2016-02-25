// basuras de repaso en java 0 - matrices

import java.io.*;
import java.lang.*;
import java.util.*;


public class Persona{
  public String   nombre;
  public Integer  edad;

// ejemplo de creacion de una clase
  public Persona( ){
    edad = 0 ;
    nombre = "S/N";
  }

  public void GetNombre (){
    System.out.println( this.nombre);
  }
  public void GetEdad () {
    System.out.println( this.edad );
  }

  class MenorEdad extends Persona{
    // constructor por defecto heredado
    // constructor por defecto propio
    public void MenorEdad ( ){
      super( );
      this.colorFavorito = "rojo";
    }


    // miembros eredados

    // miembros propios
    public String colorFavorito ;




    // metodos heredados
    // funciones propias
    public void GetColor ( ){
      System.out.println( this.colorFavorito );
    }
  }


}




class ProgramaRepaso{

  public static void main(String[] args) {
    System.out.println("esta es una linea de nuevo en java");

    // variables y arrelgos
    int   a = 2;
    double d = 2.12;
    char  c = '2';

    System.out.println(" int "+a+ " double "+ d+ "char "+c);


    // manejo de matrices y vectores
    int [] vector = new int [2];
    for( int i = 0 ; i < 2 ; i ++ )
    System.out.println( vector[i] );

    int [][] mat = new int [2][2];

    //System.out.println(" numero superior"+ mat.limit);

    for ( int i = 0 ; i < mat.length ; i ++ )
      for ( int j = 0 ; j < mat[i].length ; j ++ )
          System.out.println(" matrices" + mat[i][j] );


    // se pueve convertir variables en en objetos usando el operador correspondiente
    String n1 = "234";
    Integer objt1 = new Integer(2);
    System.out.println(objt1.intValue());
    System.out.println ( objt1.parseInt(n1) );


    // se pueden usar unboxin y autoboxin convierten tipos en objetos y al revez, segun sea necesario para el contexto
    Float f1Objt = new Float(125.56f);
    System.out.println( f1Objt.floatValue() );

    float num = f1Objt + 5;
    System.out.println(num);


    // gemerar objetos de la clase persona
    Persona p1 = new Persona ();

    p1.GetNombre();
    p1.GetEdad();

    // menor de edad
    MenorEdad m1 = new MenorEdad ( );

    m1.GetEdad();
    m1.GetNombre();
    m1.GetColor();

  }





}
