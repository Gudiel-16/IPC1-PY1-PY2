
public class listaSobreNoPegadas {
    
    nodoSobreNoPegadas inicio, fin;
    int tamanio;
    int Nopegadas=0;
    
    //metodo para saber cuando la lista esta vacia
    public boolean estVacia() {
        return inicio == null;
    }
    
    public void agregar(int id, String cadena, String apellido, String password){
        
        if (!estVacia()) {
            
            nodoSobreNoPegadas nuevo=new nodoSobreNoPegadas(id,cadena,apellido,password);
            nuevo.siguiente=null;
            nuevo.anterior=fin;
            fin.siguiente=nuevo;
            fin=nuevo;
            tamanio++;
        }else{
            
            nodoSobreNoPegadas nuevo=new nodoSobreNoPegadas(id,cadena,apellido,password);
            nuevo.siguiente=null;
            nuevo.anterior=null;
            inicio=fin=nuevo;
            tamanio++;
        }
        
    }
    
    public void agregarEstampasNoPegadasAsobre(int idUsuario, String idEstampa, int pegada, int cantidad ){
        
        nodoSobreNoPegadas aux=inicio;
        if (!estVacia()) {
            
            while(aux!=null){
                if (idUsuario==aux.id) {
                    
                    nodoEstampa nuevo=new nodoEstampa(idEstampa,pegada,cantidad);
                    if (aux.primero==null) {
                        nuevo.siguiente=null;
                        aux.primero=nuevo;
                        aux.ultimo=nuevo;
                    }else{
                        nuevo.siguiente=null;
                        aux.ultimo.siguiente=nuevo;
                        aux.ultimo=nuevo;
                    }
                  break;  
                }
               aux=aux.siguiente; 
            }
            
        }
    }
    
    //metodo para ver cuanas estampas tiene pegadas el usuario
    public void NOpegadas(){
        
        nodoSobreNoPegadas aux=inicio;
        while(aux!=null){
            
            nodoEstampa auxE=aux.primero;
            
            if (auxE!=null) {
                
                while(auxE!=null){
                    Nopegadas++;
                    auxE=auxE.siguiente;
                }
                System.out.println(" Nombre: "+aux.datos+" No Pegadas: "+Nopegadas);
            }
            
            aux=aux.siguiente;
            Nopegadas=0;
        }
        
    }
    
    public void mostrar(){
        
        nodoSobreNoPegadas aux=inicio;
        while(aux!=null){
            System.out.println("ID: "+aux.id+" Nombre: "+aux.datos+" Apellido: "+aux.apellido+" Password: "+aux.password);
            
            nodoEstampa auxE=aux.primero;
            
            if (auxE!=null) {
                
                while(auxE!=null){
                    System.out.println("         Estampa--> ID: "+auxE.id+" Pegada: "+auxE.pegada+" Cantidad: "+auxE.cantidad);
                    auxE=auxE.siguiente;
                }
               
            }
            
            aux=aux.siguiente;
        }
        
    }
    
    //ordenar usuarios
   public void ordenarUsuarios(){
       
       int id;
       String nombre="";
       String apellido="";
       String password="";
       
       nodoSobreNoPegadas aux=inicio;
       nodoSobreNoPegadas aux2=new nodoSobreNoPegadas();
       while(aux.siguiente!=null){
           
           aux2=aux.siguiente;
           while(aux2!=null){
               
               if (aux.datos.compareToIgnoreCase(aux2.datos)>0) {
                   
                   id=aux.id;
                   nombre=aux.datos;
                   apellido=aux.apellido;
                   password=aux.password;
                   
                   aux.id=aux2.id;
                   aux.datos=aux2.datos;
                   aux.apellido=aux2.apellido;
                   aux.password=aux2.password;
                   
                   aux2.id=id;
                   aux2.datos=nombre;
                   aux2.apellido=apellido;
                   aux2.password=password;
                   
               }
               aux2=aux2.siguiente;
           }
           aux=aux.siguiente;
       }
       
   }
   
   //metodo para modificar un nodo
    public void modificarNodoNombre(String cadena, String aa) {
        nodoSobreNoPegadas auxiliar = new nodoSobreNoPegadas();
        auxiliar = fin;
        while (auxiliar != null) {
            if (auxiliar.datos.equals(cadena)) {
                //aa = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato para el nodo: ", "Modificando Nodo", JOptionPane.INFORMATION_MESSAGE);
                auxiliar.datos = aa;
                //JOptionPane.showMessageDialog(null, "El nodo " + cadena + " ha sido modificado por: " + aa);
            }
            auxiliar = auxiliar.anterior;
        }
    }
    
    //metodo para modificar un nodo
    public void modificarNodoApellido(String cadena, String aa) {
        nodoSobreNoPegadas auxiliar = new nodoSobreNoPegadas();
        auxiliar = fin;
        while (auxiliar != null) {
            if (auxiliar.apellido .equals(cadena)) {
                //aa = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato para el nodo: ", "Modificando Nodo", JOptionPane.INFORMATION_MESSAGE);
                auxiliar.apellido = aa;
                //JOptionPane.showMessageDialog(null, "El nodo " + cadena + " ha sido modificado por: " + aa);
            }
            auxiliar = auxiliar.anterior;
        }
    }
    
    //metodo para modificar un nodo
    public void modificarNodoPassword(String cadena, String aa) {
        nodoSobreNoPegadas auxiliar = new nodoSobreNoPegadas();
        auxiliar = fin;
        while (auxiliar != null) {
            if (auxiliar.password.equals(cadena)) {
                //aa = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato para el nodo: ", "Modificando Nodo", JOptionPane.INFORMATION_MESSAGE);
                auxiliar.password = aa;
                //JOptionPane.showMessageDialog(null, "El nodo " + cadena + " ha sido modificado por: " + aa);
            }
            auxiliar = auxiliar.anterior;
        }
    }
    
    //metodo eliminar nodo en especifico
    public void eliminarNodoEspecifico(String elemento) {
        
        nodoSobreNoPegadas auxiliar = new nodoSobreNoPegadas();
        nodoSobreNoPegadas auxiliar2 = new nodoSobreNoPegadas();
        auxiliar = inicio;
        auxiliar2 = null;

        while (auxiliar != null) {
            if (auxiliar.datos.equals(elemento)) {
                
                if (auxiliar == inicio) {
                    inicio = inicio.siguiente;
                    inicio.anterior = null;
                } else if (auxiliar==fin) {
                    fin.anterior.siguiente=null;
                    fin=fin.anterior;
                } else {
                    auxiliar2.siguiente = auxiliar.siguiente;
                    auxiliar.siguiente.anterior = auxiliar.anterior;
                }
            }
            auxiliar2 = auxiliar;
            auxiliar = auxiliar.siguiente;
        }
        tamanio--;
    }
    
}
