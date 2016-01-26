import java.util.*;
import java.lang.*;
import java.io.*;

class reloj {

  public static void main(String[] args) {
    // conseguir la hora del sistema
    Calendar ahora = Calendar.getInstance();

    // imprimir el reloj en la pantalla
    int hora = ahora.get(Calendar.HOUR_OF_DAY);
    int minu = ahora.get(Calendar.MINUTE);
    int day  = ahora.get(Calendar.DAY_OF_MONTH);

    // imprimir los datos
    System.out.println( "dia " + day + " hora "+ hora + " minuto " + minu );

  }
}
