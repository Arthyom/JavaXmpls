/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegralTrapecio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frodo
 */
@WebServlet(name = "IntegralTrapecio", urlPatterns = {"/It"})
public class IntegralTrapecio extends HttpServlet {
    
    
       // metodos para el calculo del area trapezoidal
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
    
    static double Trapezoide ( double limiteA, double  limiteB, double n, String funcionEntrada){
		
		/*conseguir los limites a y b y otros datos 
		double limiteA = GetNumero (" Escriba el valor del limite A" );
		double limiteB = GetNumero (" Escriba el valor del limite B" );
		double n       = GetNumero (" Escriba la cantidad de rectangulos a usar ");
		String funcionEntrada = getFuncion ( "Escriba la funcion deseada. ejemplo :  +2/1x+2/1>+2/1x+3/1>");
                */
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

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        / try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. *
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IntegralTrapecio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IntegralTrapecio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             processRequest(request, response);
            response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {

            //TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IntegralTrapecio</title>");            
            out.println("</head>");
            out.println("<body>");
            
            // conseguir los valores de las cajas de texo        
        double NumeroRectangulos = Double.parseDouble( request.getParameter("Texto1") );
        double LimiteA = Double.parseDouble(request.getParameter("Texto2") );
        double LimiteB = Double.parseDouble( request.getParameter("Texto3") );

        String FuncionEntrada = "+3/1x^+2/1>+6/1x^+1/1>";
        
        // realizar la evaluacion de la funcion
        double AreaTotal = Trapezoide(LimiteA, LimiteB, NumeroRectangulos , FuncionEntrada);
        
        // imprimir resultado
        out.println( "<h2> El Area de la funcion <i> 3x<sup>2</sup> + 6x </i> para <u>" + NumeroRectangulos + "</u> Rectangulos de [ " + LimiteA + " , "+LimiteB + " ] es igual a = " + AreaTotal + "</h2>");

            out.println("</body>");
            out.println("</html>");
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
