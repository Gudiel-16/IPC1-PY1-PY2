

public class nodoSobreNoPegadas {
    
    public String datos, apellido, password;
    int id;
    nodoSobreNoPegadas anterior, siguiente;
    nodoEstampa primero,ultimo;
    
        public nodoSobreNoPegadas() {
            anterior=siguiente=null;
        }

    
    public nodoSobreNoPegadas(int id, String datos, String apellido, String password){
        
        this.id=id;
        this.datos=datos;
        this.apellido=apellido;
        this.password=password;
        this.anterior=null;
        this.siguiente=null;
        this.primero=null;
        this.ultimo=null;
        
    }
    
    
}
