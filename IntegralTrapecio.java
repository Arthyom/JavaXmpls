import java.util.*;

class IntegralTrapecio{

	String FuncionEntrada;


	public static void main(String[] args) {

		// usar el metodo trapezoide

		System.out.println( "Area bajo la curva = " + rapezoide() );

		//double a = EvaluarFunion( "+1/1x^+2/1>+1/1x^+2/1>", 2);

		//System.out.println(a);	
	}


	// contar > en la funcion de entrada
	static int ContarTerminos ( String funcionEntrada ){

		int numeroTerminos = 0;

		for ( char caracter : funcionEntrada.toCharArray() )
			if( caracter == '>' )
				numeroTerminos ++ ;

		return numeroTerminos;
	}

	// evaluar la funcion indicada en el punto a
	static double EvaluarFunion ( String funcionEntrada, int a ){

		// declar variables 
		char 		signoPrincipal =' ', signoExp0 = ' ';
		String		coefPrin = "0", cosPrin ="0", coefExpo ="0" ,  cosExpo = "0";
		double 	    sumaTerminos = 0;

		// definir bandera de estado 
		int 		divCoef = 0 , divExpo = 0, expo = 0;

		// convertir la cadena en vector 
		char [] 	vectorEntrada = funcionEntrada.toCharArray();

		// iterar hasta que se acabe la cadena
		int itereacion = 0;
		while ( itereacion < vectorEntrada.length ){

			// conseguir un caracter
			char caracterExtraido = vectorEntrada[itereacion];

			// decidir segun el caracter 
			switch ( caracterExtraido ){

				// en caso de hallar numeros 
				case '0' : case '1' : case '2' : case  '3' : case '4' : case '5' :  case '6':  case '7' : case '8': case  '9' :

					// verificar donde se ha de almacenar el resultado
					if ( divExpo == 0 && divCoef == 0 )
						coefPrin += caracterExtraido;
					else

						if( divCoef > 0 && divExpo == 0  && expo == 0)
							cosPrin += caracterExtraido;
					else
						if( expo > 0 && divExpo == 0 )
							coefExpo += caracterExtraido;
					else
						if( divExpo > 0  )
							cosExpo += caracterExtraido;

				break;

				// en caso de hallar diviciones 
				case '/':

					//ver que tipo de divicion es
					if( divCoef == 0 )
						divCoef ++ ;
					else
						divExpo ++;

				break;

				case '^':
					expo ++;
				break;

				// en caso de hallar signos 
				case '-' : case '+':

					if ( signoPrincipal != ' ' )
						signoExp0 = caracterExtraido;
					else
						signoPrincipal = caracterExtraido;

				break;

				case '>':
					// convertir cadenas a numeros enteros
				double coeficientePrin = Double.valueOf(coefPrin).doubleValue();
				double cocientePrin    = Double.valueOf(cosPrin).doubleValue();

				double coeficienteExpo = Double.valueOf(coefExpo).doubleValue();
				double cocienteExpo    = Double.valueOf(cosExpo).doubleValue();

				//System.out.println( signoPrincipal + "( " + coeficientePrin + "/" + cocientePrin  + " )" + a + signoExp0 + "( "+ coeficienteExpo +" / " + cocienteExpo +" )" );

				// verificar el valor del signo
				if ( signoPrincipal == '+' ){

					if ( signoExp0 == '+' )
						
						// sumar el termino
						sumaTerminos += ( (coeficientePrin / cocientePrin)  *  Math.pow ( a, (coeficienteExpo/ cocienteExpo) ) );
					else
						// sumar el termino
						sumaTerminos += ( (coeficientePrin / cocientePrin)  *  Math.pow ( a, -1 * (coeficienteExpo/ cocienteExpo) ) );	
				}
				else
				{
					if ( signoExp0 == '+' )
						
						// sumar el termino
						sumaTerminos += ( ( (coeficientePrin / cocientePrin)  *  Math.pow ( a, (coeficienteExpo/ cocienteExpo) ) ) * - 1 );
					else
						// sumar el termino
						sumaTerminos +=  ( ( (coeficientePrin / cocientePrin)  *  Math.pow ( a, (-1 * (coeficienteExpo/cocienteExpo) ) ) * -1 ));

				}

				// aumentar el iterador y vaciar las variables, repetir el ciclo

				//System.out.println( signoPrincipal + "( " + coeficientePrin + "/" + cocientePrin  + " )" + a + signoExp0 + "( "+ coeficienteExpo +" / " + cocienteExpo +" )" + "=" + sumaTerminos);

				divCoef = 0 ; divExpo = 0 ; expo = 0;
	    		signoPrincipal =' '; signoExp0 = ' ';
		        coefPrin = "0"; cosPrin ="0"; coefExpo ="0" ;  cosExpo = "0";

				break;
			}

			itereacion ++;				
		}

		return sumaTerminos;
	}

	static double Trapezoide ( ){
		
		// conseguir los limites a y b y otros datos 
		double limiteA = GetNumero (" Escriba el valor del limite A" );
		double limiteB = GetNumero (" Escriba el valor del limite B" );
		double n       = GetNumero (" Escriba la cantidad de rectangulos a usar ");
		String funcionEntrada = getFuncion ( "Escriba la funcion deseada. ejemplo :  +2/1x+2/1>+2/1x+3/1>");

		double deltaX = (limiteB - limiteA)/n ;

		/* utilizar la fomula 
		  Ax 
		----- . f(a) + f(b) ; Ax = b - a / n
		  2 
		}
		*/

		// evaluar la funcion desde 1 hasta n
		double area = 0;
	
			area +=  ( EvaluarFunion(funcionEntrada,(int)limiteA) + EvaluarFunion(funcionEntrada,(int)limiteB) ) ;
			//System.out.println(area);
		

		area = ((deltaX/2) * area);

		return area;

	}

	static double GetNumero ( String mensaje ){

		//crear un escaner
		Scanner lector = new Scanner(System.in);

		System.out.println(mensaje);
		double numero = lector.nextDouble();

		return numero;

	}

	static String getFuncion ( String mensaje ){

		//crear un escaner
		Scanner lector = new Scanner(System.in);

		System.out.println(mensaje);
		String funcion = lector.nextLine();
		

		return funcion;
	}

}	
