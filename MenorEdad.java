import persona.java;

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
