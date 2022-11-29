
import javax.swing.JOptionPane;



public class listaDobleUsuarios {
    
    nodoDobleUsuarios inicio, fin;
    int tamanio;
    String nuevaCadena;
    int pegadas=0;
    
    listaDobleUsuarios(){
        inicio=fin=null;
    }
    
    //metodo para saber cuando la lista esta vacia
    public boolean estVacia() {
        return inicio == null;
    }
    
    //metodo para agregar el inicio
    public void agregarAlInicio(String cadena) {
        if (!estVacia()) {
            inicio = new nodoDobleUsuarios(cadena, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new nodoDobleUsuarios(cadena);
        }
        tamanio++;
    }
    
    //metodo para agregar nodos al final
    public void agregarAlFinal(String cadena) {
        if (!estVacia()) {
            fin = new nodoDobleUsuarios(cadena, null, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new nodoDobleUsuarios(cadena);
        }
        tamanio++;
    }
    
    public void agregar(int id, String cadena, String apellido, String password){
        
        if (!estVacia()) {
            
            nodoDobleUsuarios nuevo=new nodoDobleUsuarios(id,cadena,apellido,password);
            nuevo.siguiente=null;
            nuevo.anterior=fin;
            fin.siguiente=nuevo;
            fin=nuevo;
            tamanio++;
        }else{
            
            nodoDobleUsuarios nuevo=new nodoDobleUsuarios(id,cadena,apellido,password);
            nuevo.siguiente=null;
            nuevo.anterior=null;
            inicio=fin=nuevo;
            tamanio++;
        }
        
    }
    
    public void agregarEstampasUsuarios(int idUsuario, String idEstampa, int pegada, int cantidad ){
        
        nodoDobleUsuarios aux=inicio;
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
    
   
    //metodo para mostrar la lista de inicio a fin
    public void mostrarListaInicioFin() {
        
        if (!estVacia()) {
            String datos = "<=>";
            nodoDobleUsuarios auxiliar = inicio;
            while (auxiliar != null) {
                datos = datos + "[" +" ID: "+auxiliar.id+ " Nombre: "+auxiliar.datos + " Apellido: "+auxiliar.apellido+ " Password: "+auxiliar.password+"]<=>";
                System.out.println(datos);
                auxiliar = auxiliar.siguiente;
            }
            
            //JOptionPane.showMessageDialog(null, datos, "Mostrando Lista de inicio a fin", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    public void mostrar(){
        
        nodoDobleUsuarios aux=inicio;
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
    
    //metodo para ver cuanas estampas tiene pegadas el usuario
    public void pegadas(){
        
        nodoDobleUsuarios aux=inicio;
        while(aux!=null){
            
            nodoEstampa auxE=aux.primero;
            
            if (auxE!=null) {
                
                while(auxE!=null){
                    pegadas++;
                    auxE=auxE.siguiente;
                }
                System.out.println(" Nombre: "+aux.datos+" Pegadas: "+pegadas);
            }
            
            aux=aux.siguiente;
            pegadas=0;
        }
        
    }
    
    //buscar Nodo por posicion
    public String nodoPosicionNombre(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleUsuarios aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                return aux.datos;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    public String nodoPosicionApellido(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleUsuarios aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                return aux.apellido;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    public String nodoPosicionPassword(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleUsuarios aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                return aux.password;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    //tamanio de la lista
    public int tamanio(){
        return tamanio;
    }
    
    //metodo para modificar un nodo
    public void modificarNodoNombre(String cadena, String aa) {
        nodoDobleUsuarios auxiliar = new nodoDobleUsuarios();
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
        nodoDobleUsuarios auxiliar = new nodoDobleUsuarios();
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
        nodoDobleUsuarios auxiliar = new nodoDobleUsuarios();
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
        
        nodoDobleUsuarios auxiliar = new nodoDobleUsuarios();
        nodoDobleUsuarios auxiliar2 = new nodoDobleUsuarios();
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
    
    //para buscar posicion de un nodo en lista usuarios
   public int buscarUs(int cadena) {
        if (inicio != null) {
            nodoDobleUsuarios aux = inicio;

            int cont = 0;
            while (aux != null) {
                cont++;
                if (aux.id==(cadena)) {
                    return cont;

                }
                aux = aux.siguiente;
            }
        }
        return 0;
    }
   
   //ordenar usuarios
   public void ordenarUsuarios(){
       
       int id;
       String nombre="";
       String apellido="";
       String password="";
       
       nodoDobleUsuarios aux=inicio;
       nodoDobleUsuarios aux2=new nodoDobleUsuarios();
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
}
