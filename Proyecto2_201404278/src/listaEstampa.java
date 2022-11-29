
public class listaEstampa {
    
    nodoEstampa inicio, fin;
    int tamanio;
    
    public listaEstampa(){
        inicio=fin=null;
    }
    
    //metodo para saber si la lista esta vacia
    public boolean estaVacia(){
        if (inicio==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public void agregar(String id, int idJug, int idEq, int rareza, String ruta){
        
        if (!estaVacia()) {
            
            fin.siguiente=new nodoEstampa(id, idJug, idEq, rareza,ruta);
            fin=fin.siguiente;
            tamanio++;
        }else{
            
            inicio=fin=new nodoEstampa(id,idJug,idEq,rareza,ruta);
            tamanio++;
        }
    }
    
    public void mostrar(){
        
        nodoEstampa a=inicio;
        
        while(a!=null){
            System.out.println(" ID: "+a.id+" Rareza: "+a.rareza+" ruta: "+a.ruta);
            a=a.siguiente;
        }
        
    }
    
    //para buscar posicion de un nodo en lista equipos
   public int buscarEst(String cadena) {
        if (inicio != null) {
            nodoEstampa aux = inicio;

            int cont = 0;
            while (aux != null) {
                cont++;
                if (aux.id.equals(cadena)) {
                    return cont;

                }
                aux = aux.siguiente;
            }
        }
        return 0;
    }
   
   public String nodoPosicionRuta(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoEstampa aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                String qq=aux.ruta;
                return qq;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return null;
    }
   
   //me retorna el idEquipo en cierta posicion de nodoEstampa
   public int nodoPosicionEquipo(int elemento) {

        try { //el try es por si se ingrese un valor mas grande que 'tamanio' osea el tamanio de la lista

            if (elemento < 0) {//si se ingresa un valor menor que 0
                //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
            } else {
                nodoEstampa aux = inicio;//se crea una copia de la lista
                for (int i = 0; i < elemento; i++) {// y se va recorriendo la lista hasta la posicion del elemento
                    aux = aux.siguiente;
                }
                //JOptionPane.showMessageDialog(null, "El valor que esta en la posicion: " + elemento + " Es: " + aux.datos);
                int qq=aux.idEq;
                return qq;
            }
        } catch (NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "La posicion ingresada no existe en la Lista!");
        }
        return 0;
    }
   
    public int tamanio(){
        return tamanio;
    }
   
   
    
}
