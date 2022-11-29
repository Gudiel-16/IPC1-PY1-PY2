

public class nodoEstampa {
    
    String id;
    int rareza, idJug, idEq;
    String ruta;
    int pegada;
    int cantidad;
    
    nodoEstampa siguiente;
    
    public nodoEstampa(String id, int idJug, int idEq, int rareza, String ruta){
        
        this.id=id;
        this.idJug=idJug;
        this.idEq=idEq;
        this.rareza=rareza;
        this.ruta=ruta;
        siguiente=null;
        
    }
    
    public nodoEstampa(String id, int pegada, int cantidad ){
        this.id=id;
        this.pegada=pegada;
        this.cantidad=cantidad;
        this.siguiente=null;
    }
    
}
