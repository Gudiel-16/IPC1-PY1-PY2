
public class nodoDobleUsuarios {

    public String datos, apellido, password;
    int id;
    nodoDobleUsuarios anterior, siguiente;
    nodoEstampa primero,ultimo;

    public nodoDobleUsuarios() {

        anterior = null;
        siguiente = null;
    }

    public nodoDobleUsuarios(int id, String datos, String apellido, String password){
        
        this.id=id;
        this.datos=datos;
        this.apellido=apellido;
        this.password=password;
        this.anterior=null;
        this.siguiente=null;
        this.primero=null;
        this.ultimo=null;
        
    }
    
    //para cuando aun no hay nodos
    public nodoDobleUsuarios(String cadena) {
        this(cadena, null, null);
    }

    //para cuando ya hay nodos
    public nodoDobleUsuarios(String cadena, nodoDobleUsuarios s, nodoDobleUsuarios a) {

        datos = cadena;
        siguiente = s;
        anterior = a;
    }
}
