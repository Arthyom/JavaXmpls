
import java.io.*;
import java.lang.*;
import java.util.*;


class Persona{
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
}
