
import javax.swing.JOptionPane;


public class listaDobleEquipos {
    
    private nodoDobleEquipos inicio, fin;
     int tamanio=0, tamanio2=0;
    
    listaDobleEquipos(){
        
        inicio=fin=null;
        
    }
    
    public void Agregar_Lista_Equipos(int id, String nombre, String fecha, int mGanados){
    
        nodoDobleEquipos nuevo = new nodoDobleEquipos(id, nombre, fecha, mGanados);
        
        if(inicio==null){
            nuevo.anterior=null;
            nuevo.siguiente=null;
            inicio=nuevo;
            fin=nuevo;
            tamanio++;
        }else{
            nuevo.siguiente=null;
            nuevo.anterior=fin;
            fin.siguiente=nuevo;
            fin=nuevo;
            tamanio++;
        }
    }
    
    public void Recorrer_Estructuras(){
        nodoDobleEquipos aux=inicio;
        if(aux!=null){
            while(aux!=null){
                System.out.println("Equipo--> ID: "+aux.id+" Nombre: "+aux.datos+" fecha: "+aux.fecha+" "+" Ganados: "+aux.mGanados);
                
                    nodoDobleJugador auxJ=aux.primero;
                    if(auxJ!=null){
                        while(auxJ!=null){
                                System.out.println("       Jugador--> ID: "+auxJ.id+" Nombre: "+auxJ.datos+" Posicion: "+auxJ.posicion+" Nacimiento: "+auxJ.anio+" Altura: "+auxJ.altura+" Peso: "+auxJ.peso);
                         auxJ=auxJ.siguiente;    
                        }
                    }
                    
             aux=aux.siguiente;   
            }
        }
    }
    
    public void Agregar_Lista_Jugadores(int equipo, int id, String nombre, String posicion, int anio, double altura, double peso, int idEquipo){
        /*Primero voy a recorrer la lista de los Equipos para buscar si el equipo existe
         Si el equipo existe entonces se agregaran los Jugadores a ese equipo... */
        
        nodoDobleEquipos aux=inicio;
        if(aux!=null){
            while(aux!=null){
                if(equipo==(aux.id)){
                    
                    nodoDobleJugador nuevo=new nodoDobleJugador(id, nombre, posicion, anio, altura, peso, idEquipo); // creamos un nodo de tipo Jugadores 
                    
                    if(aux.primero==null){
                        nuevo.anterior=null;
                        nuevo.siguiente=null;
                        aux.primero=nuevo;
                        aux.ultimo=nuevo;
                        tamanio2++;
                    }else{
                        nuevo.siguiente=null;
                        nuevo.anterior=aux.ultimo;   /// aqui utilizamos el "aux.Ultimo" para crear el enlace de la primero lista con las otras...
                        aux.ultimo.siguiente=nuevo;      
                        aux.ultimo=nuevo; 
                        tamanio2++;
                    }
                    
                 break; //El Break terminar tel ciclo while;  
                }
             aux=aux.siguiente;   
            }
        }
    }
    
    //metodo para saber cuando la lista esta vacia
    public boolean estVacia() {
        return inicio == null;
    }
    
    
    //metodo para mostrar la lista de inicio a fin
    public void mostrarListaInicioFin() {
        String datos = "";
        
        if (!estVacia()) {
            
            nodoDobleEquipos auxiliar = inicio;
            while (auxiliar != null) {
                //datos = datos + "[" + auxiliar.datos + "]<=>";
                datos=datos+"<=>"+" ID: "+auxiliar.id+" Nombre: "+auxiliar.datos+" fecha: "+auxiliar.fecha+" "+" Ganados: "+auxiliar.mGanados;
                System.out.println(datos);
                
                nodoDobleJugador auxJ=auxiliar.primero;
                
                if (auxJ!=null) {
                    while(auxJ!=null){
                        System.out.println("       Jugador--> ID: "+auxJ.id+" Nombre: "+auxJ.datos+" Posicion: "+auxJ.posicion+" Nacimiento: "+auxJ.anio+" Altura: "+auxJ.altura+" Peso: "+auxJ.peso);
                        auxJ=auxJ.siguiente;
                    }
                    System.out.println("-----------------------------------------------------------------");
                        
                }
                
                auxiliar = auxiliar.siguiente;
                
            }
            
            //JOptionPane.showMessageDialog(null, datos, "Mostrando Lista de inicio a fin", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
    
    /////////////////////////////////////////////////////////////buscar Nodo por posicion EQUIPOS////////////////////////////////////////////////////////
    
    public int nodoPosicionID(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                int qq=aux.id;
                return qq;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return 0;
    }
    
    public String nodoPosicionNombre(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                String qq=aux.datos;
                return qq;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    public String nodoPosicionFecha(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                String qq=aux.fecha;
                return qq;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    public String nodoPosicionMundiales(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                int qq=aux.mGanados;
                String conver=String.valueOf(qq);
                return conver;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    
    
    ///////////////////////////////////////////////////////////////buscar Nodo por posicion JUGADORES//////////////////////////////////////////////////
    
    
    public String nodoPosicionJugNombre(int elemento,int elemento2) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                
                nodoDobleJugador aux2=aux.primero;
                for (int i = 0; i < elemento2; i++) {
                    aux2=aux2.siguiente;
                }
                
                String ee=aux2.datos;
                return ee;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    public String nodoPosicionJugPosicion(int elemento,int elemento2) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                
                nodoDobleJugador aux2=aux.primero;
                for (int i = 0; i < elemento2; i++) {
                    aux2=aux2.siguiente;
                }
                
                String ee=aux2.posicion;
                return ee;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    public String nodoPosicionJugNacimiento(int elemento,int elemento2) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                
                nodoDobleJugador aux2=aux.primero;
                for (int i = 0; i < elemento2; i++) {
                    aux2=aux2.siguiente;
                }
                
                int ee=aux2.anio;
                String qq=String.valueOf(ee);
                return qq;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    public String nodoPosicionJugAltura(int elemento,int elemento2) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoDobleEquipos aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                
                nodoDobleJugador aux2=aux.primero;
                for (int i = 0; i < elemento2; i++) {
                    aux2=aux2.siguiente;
                }
                
                Double ee=aux2.altura;
                String qq=String.valueOf(ee);
                return qq;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
    
    //tamanio de la lista
    public int tamanioEq(){
        return tamanio;
    }
    
    public int tamanioJug(){
        return tamanio2;
    }
    
    //metodo para modificar un nodo
    public void modificarNodo(String cadena, String aa) {
        nodoDobleEquipos auxiliar = new nodoDobleEquipos();
        auxiliar = fin;
        while (auxiliar != null) {
            if (auxiliar.datos == cadena) {
                //aa = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato para el nodo: ", "Modificando Nodo", JOptionPane.INFORMATION_MESSAGE);
                auxiliar.datos = aa;
                JOptionPane.showMessageDialog(null, "El nodo " + cadena + " ha sido modificado por: " + aa);
            }
            auxiliar = auxiliar.anterior;
        }
    }
    
    //para buscar posicion de un nodo en lista equipos
   public int buscarEq(int cadena) {
        if (inicio != null) {
            nodoDobleEquipos aux = inicio;

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
   
    //para buscar posicion de un nodo
   public int buscarJug(int cadena) {
        //if (inicio != null) {
            nodoDobleEquipos aux = inicio;

            int cont = 0;
            while (aux != null) {
                cont++;
                nodoDobleJugador auxJ=aux.primero;
                
                if (auxJ!=null) {
                    
                    while(auxJ!=null){
                        cont++;
                        if (cadena==auxJ.id) {
                            return cont;
                        }
                        auxJ=auxJ.siguiente;
                    }

                }
                aux = aux.siguiente;
            }
        //}
        return 0;
    }
   
   //insertar despues de un cierto nodo
    public void insertarPos(int pos, String x) {
        if (pos <= tamanioEq() + 1) {
            nodoDobleEquipos nuevo = new nodoDobleEquipos();
            nuevo.datos = x;
            if (pos == 1) {
                nuevo.siguiente = inicio;
                if (inicio != null) {
                    inicio.anterior = nuevo;
                }
                inicio = nuevo;
            } else if (pos == tamanioEq() + 1) {
                nodoDobleEquipos reco = inicio;
                while (reco.siguiente != null) {
                    reco = reco.siguiente;
                }
                reco.siguiente = nuevo;
                nuevo.anterior = reco;
                nuevo.siguiente = null;
            } else {
                nodoDobleEquipos reco = inicio;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.siguiente;
                }
                nodoDobleEquipos siguiente = reco.siguiente;
                reco.siguiente = nuevo;
                nuevo.anterior = reco;
                nuevo.siguiente = siguiente;
                siguiente.anterior = nuevo;
                
            }
        }
        
    }
    
    
    
}
