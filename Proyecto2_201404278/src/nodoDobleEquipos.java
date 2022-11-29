
public class nodoDobleEquipos {

    int id;
    String datos;
    String fecha;
    int mGanados;
    nodoDobleEquipos anterior, siguiente;
    nodoDobleJugador primero, ultimo;
    
    public nodoDobleEquipos(int id, String datos, String fecha, int mGanados){
        
        this.id=id;
        this.datos=datos;
        this.fecha=fecha;
        this.mGanados=mGanados;
        this.anterior=null;
        this.siguiente=null;
        this.primero=null;
        this.ultimo=null;
        
    }
    
    public nodoDobleEquipos(){
        
        anterior=null;
        siguiente=null;
        
        
        
    }
    
    //para cuando no hay nodos
    public nodoDobleEquipos(String cadena){
        
        this(cadena,null,null);
        
    }
    
    //para cuando ya hay nodos
    public nodoDobleEquipos(String cadena, nodoDobleEquipos s, nodoDobleEquipos a){
        
        datos=cadena;
        siguiente=s;
        anterior=a;
        
        
    }
    
}
