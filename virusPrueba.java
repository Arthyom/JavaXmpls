// prueba de la clase virus
import java.io.*;
import java.lang.*;
import java.util.*;

class Virus{
  static int virusCreados = 0;

  public Virus () {
    virusCreados ++;
  }

  public void setVirus ( ){
    virusCreados++;
  }

  public void setVirus ( int numero ){
    virusCreados += numero ;
  }

   static void getVirus (){
    System.out.println(virusCreados);
  }
}


class main {
  public static void main(String[] args) {
    int numero = 4;
    Virus [] Vvector = new Virus[numero];

    for( int i = 0 ; i < Vvector.length ; i ++ )
      Vvector[i] = new Virus();

    Virus.getVirus();






  }


}
