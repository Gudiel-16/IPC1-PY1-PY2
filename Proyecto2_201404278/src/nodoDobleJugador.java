
public class nodoDobleJugador {
    
    int id;
    String datos;
    String posicion;
    int anio;
    double altura;
    double peso;
    int idEquipo;
    
    nodoDobleJugador anterior, siguiente;
    
    public nodoDobleJugador(int id, String datos, String posicion, int anio, double altura, double peso, int idEquipo){
        
        this.id=id;
        this.datos=datos;
        this.posicion=posicion;
        this.anio=anio;
        this.altura=altura;
        this.peso=peso;
        this.idEquipo=idEquipo;
        this.anterior=null;
        this.siguiente=null;
        
    }
    
    public nodoDobleJugador(){
        
        anterior=null;
        siguiente=null;
        
    }
    
    public nodoDobleJugador(String cadena){
        this(cadena,null,null);
    }
    
    public nodoDobleJugador(String cadena, nodoDobleJugador a, nodoDobleJugador s){
        
        datos=cadena;
        anterior=a;
        siguiente=s;
        
    }
    
}
