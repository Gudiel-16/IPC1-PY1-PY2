
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ventana_201404278 extends javax.swing.JFrame {

    Stack jug = new Stack();
    String cap = "", cap2;

    //variables para archivo equipos
    int aa = 0, aa2 = 0;
    String le1 = "", le2 = "";

    //variables para archivo jugadores
    int idJ = 0;
    String nomJ = "", posJ = "";
    int anioJ = 0;
    double altJ = 0.00, pesJ = 0.00;
    int idEqJ = 0;

    //variables para archivo usuarios
    int idU = 0;
    String nombU = "", apellU = "", passU = "";

    //variables para archivo estampas
    int idEJ = 0, idEE = 0, rareza;
    String idE, ruta, rutaNum;

    //variables para archivo usuarios-estampa
    String estampaUE = "";
    int usuarioEU = 0, pegada = 0, cantidad = 0;

    //para buscar archivo
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;

    listaDobleUsuarios ldu = new listaDobleUsuarios();
    listaDobleEquipos lde = new listaDobleEquipos();
    listaEstampa les = new listaEstampa();
    listaSobreNoPegadas lsnp=new listaSobreNoPegadas();

    //variables para recorrer los usuarios
    int nombreUs = 0, apellidoUs = 0, passUs = 0;

    //variable para recorrer los equipos
    int nombreEq = 0, fechaEq = 0, mundiEq = 0;

    //variables para recorrer jugadores
    int nombreJug = 0, posicionJug = 0, nacimientoJug = 0, alturaJug = 0, equipoJug = 0;

    //variables para recorrer estampas
    int nombreEqEst = 0, rutaE = 0;

    boolean jugExiste = false;

    public ventana_201404278() {
        initComponents();
    }

    //metodo para abrir archivo (donde se ira leendo lo que contiene)
    public String abrirArchivo(File archivo) {
        String documento = "";

        try {
            entrada = new FileInputStream(archivo);
            int opcion;
            while (((opcion = entrada.read()) != -1)) {
                char caracter = (char) opcion;
                documento += caracter;
            }
        } catch (Exception e) {

        }
        return documento;
    }

    ////////////////////////////////////////////////////////////ARCHIVO USUARIOS///////////////////////////////////////////////////////////////////////////
    public void leerArchiUsuario(String lee, int r) {

        if (r < lee.length()) {//si el parametro que recibe es menor al tama;o del texto
            int posicion = lee.indexOf("\n", r);//empezara a buscar salto de linea a partir de la posicion 'r'
            String aaa = lee.substring(r, posicion);//se guardara en una variable tipo String una subcadena desde la posicion 'r' hasta donde encuentre '\n'
            //System.out.println(aa);
            leerLinea(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion);

            if (ldu.buscarUs(idU) == 0) {
                ldu.agregar(idU, nombU, apellU, passU);
                lsnp.agregar(idU, nombU, apellU, passU);
            }

            int c = posicion;

            leerArchivo2(lee, c + 1); //se le manda al metodo los parametros, la cadena del archivo que se lee y la posicion donde se quedo
        }

    }

    public void leerArchivo2(String lee, int a) {

        if (a < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion2 = lee.indexOf("\n", a);//empezara a buscar salto de linea a partir de la posicion 'a' (recibe parametros)
            String aaa = lee.substring(a, posicion2);//se guardara en una variable tipo String una subcadena desde la posicion 'a' hasta donde encuentre '\n'
            //System.out.println(aaa);
            leerLinea(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion2);

            if (ldu.buscarUs(idU) == 0) {
                ldu.agregar(idU, nombU, apellU, passU);
                lsnp.agregar(idU, nombU, apellU, passU);
            }

            int d = posicion2;

            leerArchiUsuario(lee, d + 1);//vuelvo a llamar al otro metedo de nuevo
        }
    }

    //metodo para ir leendo los bloques del la linea del metodo 'leerArchiUsuario'
    public int leerLinea(String lee, int b) {

        if (b < lee.length()) {

            try {//es paor si ya no encuentraa un "|" entonces me lee lo restante de la linea

                int posicion = lee.indexOf("|", b);
                String leendo = lee.substring(b, posicion);
                idU = Integer.parseInt(leendo);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion);
                //txtNombreUs.setText(leendo);
                int q = posicion;
                leerLinea2(lee, q + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(b, lee.length() - 1);
                idU = Integer.parseInt(leendo);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }
        return idU;
    }

    //metodo para ir leendo los bloques de la linea del metodo 'leerArchiUsuario' recibiendo parametros del metodo 'leerLinea'
    public String leerLinea2(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                nombU = lee.substring(w, posicion2);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLinea3(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                nombU = lee.substring(w, lee.length() - 1);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }

        return nombU;
    }

    //metodo para ir leendo los bloques de la linea del metodo 'leerArchiUsuario' recibiendo parametros del metodo 'leerLinea'
    public String leerLinea3(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                apellU = lee.substring(w, posicion2);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLinea4(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                apellU = lee.substring(w, lee.length() - 1);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }

        return apellU;
    }

    //metodo para ir leendo los bloques de la linea del metodo 'leerArchiUsuario' recibiendo parametros del metodo 'leerLinea'
    public String leerLinea4(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                passU = lee.substring(w, posicion2);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLinea3(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                passU = lee.substring(w, lee.length() - 1);
                //ldu.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }

        return passU;
    }

    /////////////////////////////////////////////////////////////////////ARCHIVO EQUIPOS////////////////////////////////////////////////////////////////////
    //se crea un metodo que recibe como parametros una cadena y un entero
    public void leerArchiEquipos(String lee, int r) {

        if (r < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion = lee.indexOf("\n", r);//empezara a buscar salto de linea a partir de la posicion 'r'
            String aaa = lee.substring(r, posicion);//se guardara en una variable tipo String una subcadena desde la posicion 'r' hasta donde encuentre '\n'
            //System.out.println(aa);
            leerLineaEq(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion);

            if (lde.buscarEq(aa) == 0) {
                lde.Agregar_Lista_Equipos(aa, le1, le2, aa2);
            }

            int c = posicion;
            leerArchivoEquipos2(lee, c + 1); //se le manda al metodo los parametros, la cadena del archivo que se lee y la posicion donde se quedo
        }

    }

    //metodo que recibe parametros del metodo anterior para leer la segunda linea y me retorna al metodo anterior para leer la tercera y asi sucesivamente
    public void leerArchivoEquipos2(String lee, int a) {

        if (a < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion2 = lee.indexOf("\n", a);//empezara a buscar salto de linea a partir de la posicion 'a' (recibe parametros)
            String aaa = lee.substring(a, posicion2);//se guardara en una variable tipo String una subcadena desde la posicion 'a' hasta donde encuentre '\n'
            //System.out.println(aaa);
            leerLineaEq(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion2);

            if (lde.buscarEq(aa) == 0) {
                lde.Agregar_Lista_Equipos(aa, le1, le2, aa2);
            }

            int d = posicion2;
            leerArchiEquipos(lee, d + 1);//vuelvo a llamar al otro metedo de nuevo
        }
    }

    //metodo para ir leendo los bloques del la linea del metodo 'leerArchiUsuario'
    public int leerLineaEq(String lee, int b) {

        if (b < lee.length()) {

            try {//es paor si ya no encuentraa un "|" entonces me lee lo restante de la linea

                int posicion = lee.indexOf("|", b);
                String leendo = lee.substring(b, posicion);
                aa = Integer.parseInt(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion);
                //lde.agregarAlFinal(leendo);
                int q = posicion;
                leerLineaEq2(lee, q + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(b, lee.length() - 1);
                //lde.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }
        return aa;
    }

    //metodo para ir leendo los bloques de la linea del metodo 'leerArchiUsuario' recibiendo parametros del metodo 'leerLinea'
    public String leerLineaEq2(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                le1 = lee.substring(w, posicion2);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                //lde.agregarAlFinal(leendo);
                int t = posicion2;
                leerLineaEq3(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                le1 = lee.substring(w, lee.length() - 1);
                //lde.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }
        return le1;
    }

    public String leerLineaEq3(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                le2 = lee.substring(w, posicion2);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                //lde.agregarAlFinal(leendo);
                int t = posicion2;
                leerLineaEq4(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                le2 = lee.substring(w, lee.length() - 1);
                //lde.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }
        return le2;
    }

    public int leerLineaEq4(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String leendo = lee.substring(w, posicion2);
                aa2 = Integer.parseInt(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                //lde.agregarAlFinal(leendo);
                int t = posicion2;
                leerLineaEq(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(w, lee.length() - 1);
                aa2 = Integer.parseInt(leendo);
                //lde.agregarAlFinal(leendo);
                //System.out.println(leendo);

            }
        }
        return aa2;
    }

    //////////////////////////////////////////////////////////////ARCHIVO JUGADORES//////////////////////////////////////////////////////////////////////////
//se crea un metodo que recibe como parametros una cadena y un entero
    public void leerArchiJugadores(String lee, int r) {

        if (r < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion = lee.indexOf("\n", r);//empezara a buscar salto de linea a partir de la posicion 'r'
            String aaa = lee.substring(r, posicion);//se guardara en una variable tipo String una subcadena desde la posicion 'r' hasta donde encuentre '\n'
            //System.out.println(aa);
            leerLineaJug(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion);

            if (lde.buscarJug(idJ) == 0) {
                lde.Agregar_Lista_Jugadores(idEqJ, idJ, nomJ, posJ, anioJ, altJ, pesJ, idEqJ);
            }

            int c = posicion;
            leerArchivoJugadores2(lee, c + 1); //se le manda al metodo los parametros, la cadena del archivo que se lee y la posicion donde se quedo
        }
    }

    //metodo que recibe parametros del metodo anterior para leer la segunda linea y me retorna al metodo anterior para leer la tercera y asi sucesivamente
    public void leerArchivoJugadores2(String lee, int a) {

        if (a < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion2 = lee.indexOf("\n", a);//empezara a buscar salto de linea a partir de la posicion 'a' (recibe parametros)
            String aaa = lee.substring(a, posicion2);//se guardara en una variable tipo String una subcadena desde la posicion 'a' hasta donde encuentre '\n'
            //System.out.println(aaa);
            leerLineaJug(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion2);

            if (lde.buscarJug(idJ) == 0) {
                lde.Agregar_Lista_Jugadores(idEqJ, idJ, nomJ, posJ, anioJ, altJ, pesJ, idEqJ);
            }

            int d = posicion2;
            leerArchiJugadores(lee, d + 1);//vuelvo a llamar al otro metedo de nuevo
        }
    }

    //metodo para ir leendo los bloques del la linea del metodo 'leerArchiUsuario'
    public int leerLineaJug(String lee, int b) {

        if (b < lee.length()) {

            try {//es paor si ya no encuentraa un "|" entonces me lee lo restante de la linea

                int posicion = lee.indexOf("|", b);
                String leendo = lee.substring(b, posicion);
                idJ = Integer.parseInt(leendo);
                //jug.add(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion);

                int q = posicion;
                leerLineaJug2(lee, q + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leend = lee.substring(b, lee.length() - 1);
                idJ = Integer.parseInt(leend);
                //jug.add(leend);
                //im();

            }
        }
        return idJ;
    }

    //metodo para ir leendo los bloques de la linea del metodo 'leerArchiUsuario' recibiendo parametros del metodo 'leerLinea'
    public String leerLineaJug2(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                nomJ = lee.substring(w, posicion2);

                //cap=leendo;
                //jug.add(cap);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaJug3(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                nomJ = lee.substring(w, lee.length() - 1);
                //jug.add(leendo);
                // im();

            }
        }
        return nomJ;
    }

    public String leerLineaJug3(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                posJ = lee.substring(w, posicion2);

                //cap=leendo;
                //jug.add(cap);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaJug4(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                posJ = lee.substring(w, lee.length() - 1);
                //jug.add(leendo);
                // im();

            }
        }
        return nomJ;
    }

    public int leerLineaJug4(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String aaa = lee.substring(w, posicion2);
                anioJ = Integer.parseInt(aaa);
                //cap=leendo;
                //jug.add(cap);
                //System.out.println(leendo);
                //System.out.println(posicion2);

                int t = posicion2;
                leerLineaJug5(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String aaa = lee.substring(w, lee.length() - 1);
                anioJ = Integer.parseInt(aaa);
                //jug.add(leendo);
                // im();

            }
        }
        return anioJ;
    }

    public double leerLineaJug5(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String aaa = lee.substring(w, posicion2);
                altJ = Double.parseDouble(aaa);
                //cap=leendo;
                //jug.add(cap);
                //System.out.println(leendo);
                //System.out.println(posicion2);

                int t = posicion2;
                leerLineaJug6(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String aaa = lee.substring(w, lee.length() - 1);
                altJ = Double.parseDouble(aaa);
                //jug.add(leendo);
                // im();

            }
        }
        return altJ;
    }

    public double leerLineaJug6(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String aaa = lee.substring(w, posicion2);
                pesJ = Double.parseDouble(aaa);
                //cap=leendo;
                //jug.add(cap);
                //System.out.println(leendo);
                //System.out.println(posicion2);

                int t = posicion2;
                leerLineaJug7(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String aaa = lee.substring(w, lee.length() - 1);
                pesJ = Double.parseDouble(aaa);
                //jug.add(leendo);
                // im();

            }
        }
        return pesJ;
    }

    public int leerLineaJug7(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String aaa = lee.substring(w, posicion2);
                idEqJ = Integer.parseInt(aaa);
            //cap=leendo;
                //jug.add(cap);
                //System.out.println(leendo);
                //System.out.println(posicion2);

                //int t=posicion2;
                //leerLineaJug6(lee,t+1);
            } catch (StringIndexOutOfBoundsException p) {

                String aaa = lee.substring(w, lee.length() - 1);
                idEqJ = Integer.parseInt(aaa);
                //jug.add(leendo);
                // im();

            }
        }
        return idEqJ;
    }

    ////////////////////////////////////////////////////////////////ARCHIVO ESTAMPAS///////////////////////////////////////////////////////////////////  
    //se crea un metodo que recibe como parametros una cadena y un entero
    public void leerArchiEstampas(String lee, int r) {

        if (r < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion = lee.indexOf("\n", r);//empezara a buscar salto de linea a partir de la posicion 'r'
            String aaa = lee.substring(r, posicion);//se guardara en una variable tipo String una subcadena desde la posicion 'r' hasta donde encuentre '\n'
            //System.out.println(aaa);
            leerLineaEst(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion);

            //para verificar si esta o no el id de equipo y de jugador
            if (lde.buscarEq(idEE) != 0 && lde.buscarJug(idEJ) != 0 && les.buscarEst(idE) == 0) {

                les.agregar(idE, idEJ, idEE, rareza, rutaNum);
            }

            int c = posicion;
            leerArchiEstampas2(lee, c + 1); //se le manda al metodo los parametros, la cadena del archivo que se lee y la posicion donde se quedo
        }
    }

    //metodo que recibe parametros del metodo anterior para leer la segunda linea y me retorna al metodo anterior para leer la tercera y asi sucesivamente
    public void leerArchiEstampas2(String lee, int a) {

        if (a < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion2 = lee.indexOf("\n", a);//empezara a buscar salto de linea a partir de la posicion 'a' (recibe parametros)
            String aaa = lee.substring(a, posicion2);//se guardara en una variable tipo String una subcadena desde la posicion 'a' hasta donde encuentre '\n'
            //System.out.println(aaa);
            leerLineaEst(aaa, 0);//se le manda al metodo la linea que se leo

            //para verificar si esta o no el id de equipo y de jugador
            if (lde.buscarEq(idEE) != 0 && lde.buscarJug(idEJ) != 0 && les.buscarEst(idE) == 0) {

                les.agregar(idE, idEJ, idEE, rareza, rutaNum);
            }

            //System.out.println(posicion2);
            int d = posicion2;
            leerArchiEstampas(lee, d + 1);//vuelvo a llamar al otro metedo de nuevo
        }
    }

    //metodo para ir leendo los bloques del la linea del metodo 'leerArchiUsuario'
    public String leerLineaEst(String lee, int b) {

        if (b < lee.length()) {

            try {//es paor si ya no encuentraa un "|" entonces me lee lo restante de la linea

                int posicion = lee.indexOf("|", b);
                idE = lee.substring(b, posicion);
                //System.out.println(leendo);
                //System.out.println(posicion);
                int q = posicion;
                leerLineaEst2(lee, q + 1);

            } catch (StringIndexOutOfBoundsException p) {

                idE = lee.substring(b, lee.length() - 1);
                //System.out.println(leendo);

            }
        }

        return idE;

    }

    //metodo para ir leendo los bloques de la linea del metodo 'leerArchiUsuario' recibiendo parametros del metodo 'leerLinea'
    public int leerLineaEst2(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String leendo = lee.substring(w, posicion2);
                idEJ = Integer.parseInt(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaEst3(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(w, lee.length() - 1);
                idEJ = Integer.parseInt(leendo);
                //System.out.println(leendo);

            }
        }
        return idEJ;

    }

    public int leerLineaEst3(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String leendo = lee.substring(w, posicion2);
                idEE = Integer.parseInt(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaEst4(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(w, lee.length() - 1);
                idEE = Integer.parseInt(leendo);
                //System.out.println(leendo);

            }
        }
        return idEE;

    }

    public int leerLineaEst4(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("|", w);
                String leendo = lee.substring(w, posicion2);
                rareza = Integer.parseInt(leendo);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaEst5(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(w, lee.length() - 1);
                rareza = Integer.parseInt(leendo);
                //System.out.println(leendo);

            }
        }
        return rareza;

    }

    public String leerLineaEst5(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("/", w);
                ruta = lee.substring(w, posicion2);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaEst6(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                ruta = lee.substring(w, lee.length() - 1);
                //System.out.println(leendo);

            }
        }

        return ruta;

    }

    public String leerLineaEst6(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf("/", w);
                rutaNum = lee.substring(w, posicion2);
                //System.out.println(leendo);
                //System.out.println(posicion2);
                //int t=posicion2;
                //leerLineaEst6(lee,t+1);

            } catch (StringIndexOutOfBoundsException p) {

                rutaNum = lee.substring(w, lee.length() - 1);
                //System.out.println(rutaNum);

            }
        }

        return rutaNum;

    }

    ///////////////////////////////////////////////////////////ARCHIVO ESTAMPAS-USUARIOS//////////////////////////////////////////////////////////////
    //se crea un metodo que recibe como parametros una cadena y un entero
    public void leerArchiEstUs(String lee, int r) {

        if (r < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion = lee.indexOf("\n", r);//empezara a buscar salto de linea a partir de la posicion 'r'
            String aaa = lee.substring(r, posicion);//se guardara en una variable tipo String una subcadena desde la posicion 'r' hasta donde encuentre '\n'
            //System.out.println(aaa);
            leerLineaEstUs(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion);

            if (pegada == 1) {
                ldu.agregarEstampasUsuarios(usuarioEU, estampaUE, pegada, cantidad);
            }else if(pegada==0){
                lsnp.agregarEstampasNoPegadasAsobre(usuarioEU, estampaUE, pegada, cantidad);
            }

            int c = posicion;
            leerArchivoEstUs2(lee, c + 1); //se le manda al metodo los parametros, la cadena del archivo que se lee y la posicion donde se quedo
        }
    }

    //metodo que recibe parametros del metodo anterior para leer la segunda linea y me retorna al metodo anterior para leer la tercera y asi sucesivamente
    public void leerArchivoEstUs2(String lee, int a) {

        if (a < lee.length()) {//si el parametro que recibe es menor al tama;o del texto

            int posicion2 = lee.indexOf("\n", a);//empezara a buscar salto de linea a partir de la posicion 'a' (recibe parametros)
            String aaa = lee.substring(a, posicion2);//se guardara en una variable tipo String una subcadena desde la posicion 'a' hasta donde encuentre '\n'
            //System.out.println(aaa);
            leerLineaEstUs(aaa, 0);//se le manda al metodo la linea que se leo
            //System.out.println(posicion2);

            if (pegada == 1) {
                ldu.agregarEstampasUsuarios(usuarioEU, estampaUE, pegada, cantidad);
            }

            int d = posicion2;
            leerArchiEstUs(lee, d + 1);//vuelvo a llamar al otro metedo de nuevo
        }
    }

    //metodo para ir leendo los bloques del la linea del metodo 'leerArchiUsuario'
    public int leerLineaEstUs(String lee, int b) {

        if (b < lee.length()) {

            try {//es paor si ya no encuentraa un "|" entonces me lee lo restante de la linea

                int posicion = lee.indexOf(",", b);
                String leendo = lee.substring(b, posicion);
                usuarioEU = Integer.parseInt(leendo);
            //System.out.println(leendo);
                //System.out.println(posicion);
                int q = posicion;
                leerLineaEstUs2(lee, q + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(b, lee.length() - 1);
                usuarioEU = Integer.parseInt(leendo);
            //System.out.println(leendo);

            }
        }
        return usuarioEU;

    }

    //metodo para ir leendo los bloques de la linea del metodo 'leerArchiUsuario' recibiendo parametros del metodo 'leerLinea'
    public String leerLineaEstUs2(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf(",", w);
                estampaUE = lee.substring(w, posicion2);
            //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaEstUs3(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                estampaUE = lee.substring(w, lee.length() - 1);
            //System.out.println(leendo);

            }
        }
        return estampaUE;

    }

    public int leerLineaEstUs3(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf(",", w);
                String leendo = lee.substring(w, posicion2);
                pegada = Integer.parseInt(leendo);
            //System.out.println(leendo);
                //System.out.println(posicion2);
                int t = posicion2;
                leerLineaEstUs4(lee, t + 1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(w, lee.length() - 1);
                pegada = Integer.parseInt(leendo);
            //System.out.println(leendo);

            }
        }
        return pegada;

    }

    public int leerLineaEstUs4(String lee, int w) {

        if (w < lee.length()) {

            try {

                int posicion2 = lee.indexOf(",", w);
                String leendo = lee.substring(w, posicion2);
                cantidad = Integer.parseInt(leendo);
            //System.out.println(leendo);
                //System.out.println(posicion2);
                //int t=posicion2;
                //leerLineaEstUs4(lee,t+1);

            } catch (StringIndexOutOfBoundsException p) {

                String leendo = lee.substring(w, lee.length() - 1);
                cantidad = Integer.parseInt(leendo);
            //System.out.println(leendo);

            }
        }
        return cantidad;

    }

    // PILA PARA IR GUARDANDO LOS DATOS DE JUGADORES PARA ENLAZARLOS CON LOS EQUIPOS
    /* public void im(){
        
        
     String idJug=jug.peek().toString();
     int posJug=lde.buscarEq(idJug);
     lde.insertarPos(2, "sjs");
     if (posJug!=0) {
            
     while(!jug.isEmpty()){
     jug.pop();
     }
     }else{
     System.out.println("NO");
     }
     System.out.println(jug);
     }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelAdminUsuarios = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtApellidoUs = new javax.swing.JTextField();
        bttSiguienteUs = new javax.swing.JButton();
        bttModiUs = new javax.swing.JButton();
        bttAnteriorUs = new javax.swing.JButton();
        txtPassUs = new javax.swing.JTextField();
        txtNombreUs = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        bttRegresarAdminUs = new javax.swing.JButton();
        bttElimUs = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bttUsuario = new javax.swing.JButton();
        bttAdmin = new javax.swing.JButton();
        panelAdminEstampas = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        bttSiguienteEst = new javax.swing.JButton();
        bttAnteriorEst = new javax.swing.JButton();
        txtNombreJugEst = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        bttRegresarAdminEst = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        panelOpcionesAdmin = new javax.swing.JPanel();
        bttJugEqEsIr = new javax.swing.JButton();
        bttCargaMasivaIr = new javax.swing.JButton();
        bttAdminUsuariosIr = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bttReporteAdmin = new javax.swing.JButton();
        panelCargaMasiva = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bttBuscarEquipos = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bttBuscarEstUs = new javax.swing.JButton();
        bttBuscarJugadores = new javax.swing.JButton();
        bttBuscarEstampas = new javax.swing.JButton();
        bttBuscarUsuarios = new javax.swing.JButton();
        regresarDeCargaMasiva = new javax.swing.JButton();
        panelJugEqEst = new javax.swing.JPanel();
        bttAdmJug = new javax.swing.JButton();
        bttAdmEst = new javax.swing.JButton();
        bttAdmEq = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        bttRegresarOpcVer = new javax.swing.JButton();
        panelAdminIngresar = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        bttIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelAdminJugadores = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtPosicionJug = new javax.swing.JTextField();
        bttSiguienteJug = new javax.swing.JButton();
        bttAnteriorJug = new javax.swing.JButton();
        txtNacimientoJug = new javax.swing.JTextField();
        txtNombreJug = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        bttRegresarAdminJug = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtEquipoJug = new javax.swing.JTextField();
        txtAlturaJug = new javax.swing.JTextField();
        panelAdminEquipos = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtFechaEq = new javax.swing.JTextField();
        bttSiguienteEq = new javax.swing.JButton();
        bttAnteriorEq = new javax.swing.JButton();
        txtMundiEq = new javax.swing.JTextField();
        txtNombreEq = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        bttRegresarAminEquipos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAdminUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        panelAdminUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Apellido:");
        panelAdminUsuarios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Password:");
        panelAdminUsuarios.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 40));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nombre:");
        panelAdminUsuarios.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 30));
        panelAdminUsuarios.add(txtApellidoUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 260, 30));

        bttSiguienteUs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttSiguienteUs.setText("Siguiente");
        bttSiguienteUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSiguienteUsActionPerformed(evt);
            }
        });
        panelAdminUsuarios.add(bttSiguienteUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 110, 40));

        bttModiUs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttModiUs.setText("Modificar");
        bttModiUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttModiUsActionPerformed(evt);
            }
        });
        panelAdminUsuarios.add(bttModiUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 110, 40));

        bttAnteriorUs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttAnteriorUs.setText("Anterior");
        bttAnteriorUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAnteriorUsActionPerformed(evt);
            }
        });
        panelAdminUsuarios.add(bttAnteriorUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 110, 40));
        panelAdminUsuarios.add(txtPassUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 260, 30));
        panelAdminUsuarios.add(txtNombreUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 260, 30));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("USUARIOS");
        panelAdminUsuarios.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 200, 40));

        bttRegresarAdminUs.setText("SALIR");
        bttRegresarAdminUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegresarAdminUsActionPerformed(evt);
            }
        });
        panelAdminUsuarios.add(bttRegresarAdminUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        bttElimUs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttElimUs.setText("ELIMINAR");
        bttElimUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttElimUsActionPerformed(evt);
            }
        });
        panelAdminUsuarios.add(bttElimUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 110, 40));

        getContentPane().add(panelAdminUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 510, 350));

        panelPrincipal.setBackground(new java.awt.Color(153, 153, 153));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("JMundial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 200, 0, 0);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        bttUsuario.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        bttUsuario.setText("USUARIO");
        bttUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttUsuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 88;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 40, 102, 0);
        panelPrincipal.add(bttUsuario, gridBagConstraints);

        bttAdmin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        bttAdmin.setText("ADMINISTRADOR");
        bttAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAdminActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 61, 102, 71);
        panelPrincipal.add(bttAdmin, gridBagConstraints);

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 630, 320));

        panelAdminEstampas.setBackground(new java.awt.Color(153, 153, 153));
        panelAdminEstampas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Equipo:");
        panelAdminEstampas.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 80, 30));

        bttSiguienteEst.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttSiguienteEst.setText("Siguiente");
        bttSiguienteEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSiguienteEstActionPerformed(evt);
            }
        });
        panelAdminEstampas.add(bttSiguienteEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 170, 50));

        bttAnteriorEst.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttAnteriorEst.setText("Anterior");
        bttAnteriorEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAnteriorEstActionPerformed(evt);
            }
        });
        panelAdminEstampas.add(bttAnteriorEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 170, 50));
        panelAdminEstampas.add(txtNombreJugEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 260, 30));

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("ESTAMPAS");
        panelAdminEstampas.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 10, 200, 40));

        bttRegresarAdminEst.setText("REGRESAR");
        bttRegresarAdminEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegresarAdminEstActionPerformed(evt);
            }
        });
        panelAdminEstampas.add(bttRegresarAdminEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 20, -1, -1));
        panelAdminEstampas.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 280, 190));

        getContentPane().add(panelAdminEstampas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 500, 410));

        panelOpcionesAdmin.setBackground(new java.awt.Color(153, 153, 153));
        panelOpcionesAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttJugEqEsIr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttJugEqEsIr.setText("INGRESAR");
        bttJugEqEsIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttJugEqEsIrActionPerformed(evt);
            }
        });
        panelOpcionesAdmin.add(bttJugEqEsIr, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 140, 172, 60));

        bttCargaMasivaIr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttCargaMasivaIr.setText("INGRESAR");
        bttCargaMasivaIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCargaMasivaIrActionPerformed(evt);
            }
        });
        panelOpcionesAdmin.add(bttCargaMasivaIr, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 140, 172, 60));

        bttAdminUsuariosIr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttAdminUsuariosIr.setText("INGRESAR");
        bttAdminUsuariosIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAdminUsuariosIrActionPerformed(evt);
            }
        });
        panelOpcionesAdmin.add(bttAdminUsuariosIr, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 240, 172, 60));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("JUGADORES/EQUIPOS/ESTAMPAS");
        panelOpcionesAdmin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ADMINISTRADOR DE USUARIOS");
        panelOpcionesAdmin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CARGA MASIVA:");
        panelOpcionesAdmin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("MENU");
        panelOpcionesAdmin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 30, 150, 50));

        bttReporteAdmin.setText("GENERAR REPORTE");
        bttReporteAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttReporteAdminActionPerformed(evt);
            }
        });
        panelOpcionesAdmin.add(bttReporteAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 280, 140, -1));

        getContentPane().add(panelOpcionesAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 320));

        panelCargaMasiva.setBackground(new java.awt.Color(153, 153, 153));
        panelCargaMasiva.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("CARGA MASIVA");
        panelCargaMasiva.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 40));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("ARCHIVO JUGADORES:");
        panelCargaMasiva.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, 30));

        bttBuscarEquipos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bttBuscarEquipos.setText("BUSCAR Y CAGAR");
        bttBuscarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarEquiposActionPerformed(evt);
            }
        });
        panelCargaMasiva.add(bttBuscarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 160, 50));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("ARCHIVO ESTAMPAS:");
        panelCargaMasiva.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 170, 30));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("ARCHIVO USUARIOS:");
        panelCargaMasiva.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 30));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("ARCHIVO EST-USU:");
        panelCargaMasiva.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, 30));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("ARCHIVO EQUIPOS:");
        panelCargaMasiva.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, 30));

        bttBuscarEstUs.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bttBuscarEstUs.setText("BUSCAR Y CAGAR");
        bttBuscarEstUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarEstUsActionPerformed(evt);
            }
        });
        panelCargaMasiva.add(bttBuscarEstUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 160, 50));

        bttBuscarJugadores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bttBuscarJugadores.setText("BUSCAR Y CAGAR");
        bttBuscarJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarJugadoresActionPerformed(evt);
            }
        });
        panelCargaMasiva.add(bttBuscarJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 50));

        bttBuscarEstampas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bttBuscarEstampas.setText("BUSCAR Y CAGAR");
        bttBuscarEstampas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarEstampasActionPerformed(evt);
            }
        });
        panelCargaMasiva.add(bttBuscarEstampas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 160, 50));

        bttBuscarUsuarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bttBuscarUsuarios.setText("BUSCAR Y CAGAR");
        bttBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarUsuariosActionPerformed(evt);
            }
        });
        panelCargaMasiva.add(bttBuscarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 160, 50));

        regresarDeCargaMasiva.setText("REGRESAR");
        regresarDeCargaMasiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarDeCargaMasivaActionPerformed(evt);
            }
        });
        panelCargaMasiva.add(regresarDeCargaMasiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        getContentPane().add(panelCargaMasiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 430, 410));

        panelJugEqEst.setBackground(new java.awt.Color(153, 153, 153));
        panelJugEqEst.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttAdmJug.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttAdmJug.setText("JUGADORES");
        bttAdmJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAdmJugActionPerformed(evt);
            }
        });
        panelJugEqEst.add(bttAdmJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 190, 60));

        bttAdmEst.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttAdmEst.setText("ESTAMPAS");
        bttAdmEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAdmEstActionPerformed(evt);
            }
        });
        panelJugEqEst.add(bttAdmEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 190, 60));

        bttAdmEq.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttAdmEq.setText("EQUIPOS");
        bttAdmEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAdmEqActionPerformed(evt);
            }
        });
        panelJugEqEst.add(bttAdmEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 190, 60));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("VISUALIZAR POR :");
        panelJugEqEst.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        bttRegresarOpcVer.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bttRegresarOpcVer.setText("<-----");
        bttRegresarOpcVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegresarOpcVerActionPerformed(evt);
            }
        });
        panelJugEqEst.add(bttRegresarOpcVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        getContentPane().add(panelJugEqEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 510, 350));

        panelAdminIngresar.setBackground(new java.awt.Color(153, 153, 153));
        panelAdminIngresar.setLayout(new java.awt.GridBagLayout());

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 162;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 60, 0, 0);
        panelAdminIngresar.add(txtUsuario, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 60, 0, 0);
        panelAdminIngresar.add(jLabel2, gridBagConstraints);

        txtPass.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 158;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 94, 0, 58);
        panelAdminIngresar.add(txtPass, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PASSWORD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 94, 0, 0);
        panelAdminIngresar.add(jLabel3, gridBagConstraints);

        bttIngresar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bttIngresar.setText("INGRESAR");
        bttIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttIngresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 11, 32, 0);
        panelAdminIngresar.add(bttIngresar, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ADMINISTRADOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = -17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 130, 0, 0);
        panelAdminIngresar.add(jLabel4, gridBagConstraints);

        getContentPane().add(panelAdminIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 540, 310));

        panelAdminJugadores.setBackground(new java.awt.Color(153, 153, 153));
        panelAdminJugadores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Posicion:");
        panelAdminJugadores.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Nacimiento:");
        panelAdminJugadores.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 40));

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Nombre:");
        panelAdminJugadores.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));
        panelAdminJugadores.add(txtPosicionJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 260, 30));

        bttSiguienteJug.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttSiguienteJug.setText("Siguiente");
        bttSiguienteJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSiguienteJugActionPerformed(evt);
            }
        });
        panelAdminJugadores.add(bttSiguienteJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 180, 50));

        bttAnteriorJug.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttAnteriorJug.setText("Anterior");
        bttAnteriorJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAnteriorJugActionPerformed(evt);
            }
        });
        panelAdminJugadores.add(bttAnteriorJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 170, 50));
        panelAdminJugadores.add(txtNacimientoJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 260, 30));
        panelAdminJugadores.add(txtNombreJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 260, 30));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("JUGADORES");
        panelAdminJugadores.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 240, 40));

        bttRegresarAdminJug.setText("REGRESAR");
        bttRegresarAdminJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegresarAdminJugActionPerformed(evt);
            }
        });
        panelAdminJugadores.add(bttRegresarAdminJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Equipo:");
        panelAdminJugadores.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, 30));

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Altura:");
        panelAdminJugadores.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 30));
        panelAdminJugadores.add(txtEquipoJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 260, 30));
        panelAdminJugadores.add(txtAlturaJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 260, 30));

        getContentPane().add(panelAdminJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 490, 450));

        panelAdminEquipos.setBackground(new java.awt.Color(153, 153, 153));
        panelAdminEquipos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Fecha:");
        panelAdminEquipos.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Mundiales:");
        panelAdminEquipos.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 40));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Nombre:");
        panelAdminEquipos.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));
        panelAdminEquipos.add(txtFechaEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 260, 30));

        bttSiguienteEq.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttSiguienteEq.setText("Siguiente");
        bttSiguienteEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSiguienteEqActionPerformed(evt);
            }
        });
        panelAdminEquipos.add(bttSiguienteEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 120, 50));

        bttAnteriorEq.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bttAnteriorEq.setText("Anterior");
        bttAnteriorEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAnteriorEqActionPerformed(evt);
            }
        });
        panelAdminEquipos.add(bttAnteriorEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, 50));
        panelAdminEquipos.add(txtMundiEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 260, 30));
        panelAdminEquipos.add(txtNombreEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 260, 30));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("EQUIPOS");
        panelAdminEquipos.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 10, 175, 40));

        bttRegresarAminEquipos.setText("REGRESAR");
        bttRegresarAminEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegresarAminEquiposActionPerformed(evt);
            }
        });
        panelAdminEquipos.add(bttRegresarAminEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 20, -1, -1));

        getContentPane().add(panelAdminEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 510, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void bttUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttUsuarioActionPerformed


    }//GEN-LAST:event_bttUsuarioActionPerformed

    private void bttAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAdminActionPerformed
        this.setSize(600, 390);
        this.setLocationRelativeTo(null);
        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(true);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);

    }//GEN-LAST:event_bttAdminActionPerformed

    private void bttIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttIngresarActionPerformed

        if (txtUsuario.getText().equals("IPC1D") && txtPass.getText().equals("201404278")) {
        this.setSize(705, 390);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(true);
        panelCargaMasiva.setVisible(false);

       } else {
        JOptionPane.showMessageDialog(null, "USUARIO O PASSWORD INCORRECTO!");
        txtPass.setText("");
         }

    }//GEN-LAST:event_bttIngresarActionPerformed

    private void bttCargaMasivaIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCargaMasivaIrActionPerformed

        this.setSize(480, 480);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(true);
    }//GEN-LAST:event_bttCargaMasivaIrActionPerformed

    //boton busacar archivo equipos
    private void bttBuscarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarEquiposActionPerformed

        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {//en el boton de 'abrir' es seleccionado...
            archivo = seleccionar.getSelectedFile();//se obtiene el archivo seleccionado
            if (archivo.canRead()) { //si el archivo seleccionado se puede leer
                if (archivo.getName().endsWith("eqp")) {//si el archivo en de extension 'eqp'
                    String documento = abrirArchivo(archivo);//la variable estring se va guardando todo lo que tiene el documento
                    //System.out.println(documento);
                    leerArchiEquipos(documento, 0);
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no es compartible");
                }
            }
        }
        System.out.println("");
        lde.Recorrer_Estructuras();
        System.out.println("");
    }//GEN-LAST:event_bttBuscarEquiposActionPerformed

    //boton buscar archivo estampas-usuarios
    private void bttBuscarEstUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarEstUsActionPerformed

        if (!ldu.estVacia()) {

            if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {//en el boton de 'abrir' es seleccionado...
                archivo = seleccionar.getSelectedFile();//se obtiene el archivo seleccionado
                if (archivo.canRead()) { //si el archivo seleccionado se puede leer
                    if (archivo.getName().endsWith("csv")) {//si el archivo en de extension 'csv'
                        String documento = abrirArchivo(archivo);//la variable estring se va guardando todo lo que tiene el documento
                        //System.out.println(documento);
                        leerArchiEstUs(documento, 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no es compartible");
                    }
                }
            }
            System.out.println("");
            ldu.mostrar();
            System.out.println("");

        } else {
            JOptionPane.showMessageDialog(null, "NO HA CARGADO ARCHIVO USUARIOS");
        }
    }//GEN-LAST:event_bttBuscarEstUsActionPerformed

    //boton buscar archivo jugadores
    private void bttBuscarJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarJugadoresActionPerformed

        if (!lde.estVacia()) {

            if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {//en el boton de 'abrir' es seleccionado...
                archivo = seleccionar.getSelectedFile();//se obtiene el archivo seleccionado
                if (archivo.canRead()) { //si el archivo seleccionado se puede leer
                    if (archivo.getName().endsWith("jug")) {//si el archivo en de extension 'jug'
                        String documento = abrirArchivo(archivo);//la variable estring se va guardando todo lo que tiene el documento
                        //System.out.println(documento);
                        leerArchiJugadores(documento, 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no es compartible");
                    }
                }
            }
            lde.Recorrer_Estructuras();

        } else {
            JOptionPane.showMessageDialog(null, "NO HA CARGADO ARCHIVO EQUIPOS");
        }
    }//GEN-LAST:event_bttBuscarJugadoresActionPerformed

    //boton buscar archivo estampas
    private void bttBuscarEstampasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarEstampasActionPerformed

        if (!lde.estVacia()) {

            if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {//en el boton de 'abrir' es seleccionado...
                archivo = seleccionar.getSelectedFile();//se obtiene el archivo seleccionado
                if (archivo.canRead()) { //si el archivo seleccionado se puede leer
                    if (archivo.getName().endsWith("stm")) {//si el archivo en de extension 'stm'
                        String documento = abrirArchivo(archivo);//la variable estring se va guardando todo lo que tiene el documento
                        //System.out.println(documento);
                        leerArchiEstampas(documento, 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no es compartible");
                    }
                }
            }
            System.out.println("");
            les.mostrar();
            System.out.println("");

        } else {
            JOptionPane.showMessageDialog(null, "NO HA CARGADO ARCHIVO EQUIPOS O ARCHIVO JUGADORES");
        }
    }//GEN-LAST:event_bttBuscarEstampasActionPerformed

    //boton buscar archivo usuarios
    private void bttBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarUsuariosActionPerformed

        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {//en el boton de 'abrir' es seleccionado...
            archivo = seleccionar.getSelectedFile();//se obtiene el archivo seleccionado
            if (archivo.canRead()) { //si el archivo seleccionado se puede leer
                if (archivo.getName().endsWith("usr")) {//si el archivo en de extension 'usr'
                    String documento = abrirArchivo(archivo);//la variable estring se va guardando todo lo que tiene el documento
                    //System.out.println(documento);
                    leerArchiUsuario(documento, 0);

                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no es compartible");
                }
            }
        }
        System.out.println("");
        lsnp.ordenarUsuarios();
        ldu.ordenarUsuarios();
        ldu.mostrar();
        System.out.println("");
    }//GEN-LAST:event_bttBuscarUsuariosActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void bttSiguienteUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSiguienteUsActionPerformed

//variables que van aumentando para que me vayan saliendo los datos correspondientes
        nombreUs++;
        apellidoUs++;
        passUs++;

        if (passUs > ldu.tamanio() - 1) {//passUs es el ultimo de cada fila entonces cuando sea >= al tamanio de la lista .....
            JOptionPane.showMessageDialog(null, "YA NO HAY MAS USUARIOS");
            nombreUs = ldu.tamanio() - 1;
            apellidoUs = ldu.tamanio() - 1;
            passUs = ldu.tamanio() - 1;

            txtNombreUs.setText(ldu.nodoPosicionNombre(nombreUs));
            txtApellidoUs.setText(ldu.nodoPosicionApellido(apellidoUs));
            txtPassUs.setText(ldu.nodoPosicionPassword(passUs));

        } else { //de lo contrario me va mostrando los datos en la posicion correspondiente
            txtNombreUs.setText(ldu.nodoPosicionNombre(nombreUs));
            txtApellidoUs.setText(ldu.nodoPosicionApellido(apellidoUs));
            txtPassUs.setText(ldu.nodoPosicionPassword(passUs));
        }
    }//GEN-LAST:event_bttSiguienteUsActionPerformed

    //boton para modificar un Usuario
    private void bttModiUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttModiUsActionPerformed

        //me guarda en una variable los actuales datos de los usuarios
        String a = ldu.nodoPosicionNombre(nombreUs);
        String b = ldu.nodoPosicionApellido(apellidoUs);
        String c = ldu.nodoPosicionPassword(passUs);

        //me manda como parametro (el dato que ya estaba , el dato por cual quiero modificar)
        ldu.modificarNodoNombre(a, txtNombreUs.getText());
        ldu.modificarNodoApellido(b, txtApellidoUs.getText());
        ldu.modificarNodoPassword(c, txtPassUs.getText());
        lsnp.modificarNodoNombre(a, txtNombreUs.getText());
        lsnp.modificarNodoApellido(b, txtApellidoUs.getText());
        lsnp.modificarNodoPassword(c, txtPassUs.getText());
        
        System.out.println("");
        lsnp.ordenarUsuarios();
        ldu.ordenarUsuarios();
        ldu.mostrar();
        System.out.println("");

    }//GEN-LAST:event_bttModiUsActionPerformed

    private void bttAnteriorUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAnteriorUsActionPerformed

        nombreUs--;
        apellidoUs--;
        passUs--;

        if (nombreUs < 0 && apellidoUs < 0 && passUs < 0) {//si nombre de usuario < 0, quiere decir que ya no hay mas usuarios mas atras
            //JOptionPane.showMessageDialog(null, "YA SE ENCUENTRA EN EL INICIO DE LA LISTA!");
            nombreUs = 0;
            apellidoUs = 0;
            passUs = 0;

            txtNombreUs.setText(ldu.nodoPosicionNombre(nombreUs));
            txtApellidoUs.setText(ldu.nodoPosicionApellido(apellidoUs));
            txtPassUs.setText(ldu.nodoPosicionPassword(passUs));

        } else {//de lo contrario me va mostrando los datos en su respectiva posicion
            txtNombreUs.setText(ldu.nodoPosicionNombre(nombreUs));
            txtApellidoUs.setText(ldu.nodoPosicionApellido(apellidoUs));
            txtPassUs.setText(ldu.nodoPosicionPassword(passUs));
        }
    }//GEN-LAST:event_bttAnteriorUsActionPerformed

    //boton para ir al panel administracion de usuarios
    private void bttAdminUsuariosIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAdminUsuariosIrActionPerformed

        if (!ldu.estVacia()) {
            this.setSize(565, 415);
            this.setLocationRelativeTo(null);

            txtNombreUs.setText(ldu.nodoPosicionNombre(0));
            txtApellidoUs.setText(ldu.nodoPosicionApellido(0));
            txtPassUs.setText(ldu.nodoPosicionPassword(0));

            panelPrincipal.setVisible(false);
            panelAdminIngresar.setVisible(false);
            panelOpcionesAdmin.setVisible(false);
            panelCargaMasiva.setVisible(false);
            panelAdminUsuarios.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY USUARIOS REGISTRADOS");
        }
    }//GEN-LAST:event_bttAdminUsuariosIrActionPerformed

    //boton regresar de carga masiva
    private void regresarDeCargaMasivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarDeCargaMasivaActionPerformed
        
        this.setSize(705, 390);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(true);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);


    }//GEN-LAST:event_regresarDeCargaMasivaActionPerformed

    private void bttRegresarAdminUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegresarAdminUsActionPerformed

        this.setSize(705, 390);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(true);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(false);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(false);


    }//GEN-LAST:event_bttRegresarAdminUsActionPerformed

    private void bttSiguienteEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSiguienteEqActionPerformed
        nombreEq++;
        fechaEq++;
        mundiEq++;
        if (fechaEq > lde.tamanioEq() - 1 || fechaEq > lde.tamanioEq() - 1 || mundiEq > lde.tamanioEq() - 1) {
            JOptionPane.showMessageDialog(null, "YA NO HAY MAS EQUIPOS!");
            nombreEq = lde.tamanioEq() - 1;
            fechaEq = lde.tamanioEq() - 1;
            mundiEq = lde.tamanioEq() - 1;
            txtNombreEq.setText(lde.nodoPosicionNombre(nombreEq));
            txtFechaEq.setText(lde.nodoPosicionFecha(fechaEq));
            txtMundiEq.setText(lde.nodoPosicionMundiales(mundiEq));
        } else {

            txtNombreEq.setText(lde.nodoPosicionNombre(nombreEq));
            txtFechaEq.setText(lde.nodoPosicionFecha(fechaEq));
            txtMundiEq.setText(lde.nodoPosicionMundiales(mundiEq));

        }
    }//GEN-LAST:event_bttSiguienteEqActionPerformed

    private void bttAnteriorEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAnteriorEqActionPerformed
        nombreEq--;
        fechaEq--;
        mundiEq--;
        if (fechaEq < 0 || fechaEq < 0 || mundiEq < 0) {
            JOptionPane.showMessageDialog(null, "ES EL INICIO DE LA LISTA!");
            nombreEq = 0;
            fechaEq = 0;
            mundiEq = 0;
        } else {

            txtNombreEq.setText(lde.nodoPosicionNombre(nombreEq));
            txtFechaEq.setText(lde.nodoPosicionFecha(fechaEq));
            txtMundiEq.setText(lde.nodoPosicionMundiales(mundiEq));

        }

    }//GEN-LAST:event_bttAnteriorEqActionPerformed

    private void bttRegresarAminEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegresarAminEquiposActionPerformed

        this.setSize(565, 420);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(true);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(false);
    }//GEN-LAST:event_bttRegresarAminEquiposActionPerformed

    private void bttSiguienteJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSiguienteJugActionPerformed

        nombreJug++;
        posicionJug++;
        nacimientoJug++;
        alturaJug++;
        if (equipoJug > lde.tamanioEq() - 1) {
            JOptionPane.showMessageDialog(null, "ES EL FINAL DE LA LISTA!");
            equipoJug = equipoJug - 1;
            nombreJug = nombreJug - 1;
            posicionJug = posicionJug - 1;
            nacimientoJug = nacimientoJug - 1;
            alturaJug = alturaJug - 1;

            txtNombreJug.setText(lde.nodoPosicionJugNombre(equipoJug, nombreJug));
            txtPosicionJug.setText(lde.nodoPosicionJugPosicion(equipoJug, posicionJug));
            txtNacimientoJug.setText(lde.nodoPosicionJugPosicion(equipoJug, nacimientoJug));
            txtAlturaJug.setText(lde.nodoPosicionJugPosicion(equipoJug, alturaJug));
            txtEquipoJug.setText(lde.nodoPosicionNombre(equipoJug));
        } else {

            if (lde.nodoPosicionJugNombre(equipoJug, nombreJug) != null && lde.nodoPosicionJugPosicion(equipoJug, posicionJug) != null
                    && lde.nodoPosicionJugNacimiento(equipoJug, nacimientoJug) != null && lde.nodoPosicionJugAltura(equipoJug, alturaJug) != null) {

                txtNombreJug.setText(lde.nodoPosicionJugNombre(equipoJug, nombreJug));
                txtPosicionJug.setText(lde.nodoPosicionJugPosicion(equipoJug, posicionJug));
                txtNacimientoJug.setText(lde.nodoPosicionJugNacimiento(equipoJug, nacimientoJug));
                txtAlturaJug.setText(lde.nodoPosicionJugAltura(equipoJug, alturaJug));
                txtEquipoJug.setText(lde.nodoPosicionNombre(equipoJug));

            } else {
                equipoJug++;
                nombreJug = 0;
                posicionJug = 0;
                nacimientoJug = 0;
                alturaJug = 0;
                txtNombreJug.setText(lde.nodoPosicionJugNombre(equipoJug, nombreJug));
                txtPosicionJug.setText(lde.nodoPosicionJugPosicion(equipoJug, posicionJug));
                txtNacimientoJug.setText(lde.nodoPosicionJugNacimiento(equipoJug, nacimientoJug));
                txtAlturaJug.setText(lde.nodoPosicionJugAltura(equipoJug, alturaJug));
                txtEquipoJug.setText(lde.nodoPosicionNombre(equipoJug));
            }

        }

    }//GEN-LAST:event_bttSiguienteJugActionPerformed

    private void bttAnteriorJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAnteriorJugActionPerformed

        nombreJug--;
        posicionJug--;
        nacimientoJug--;
        alturaJug--;

        if (nombreJug < 0) {

            equipoJug--;

            if (equipoJug < 0) {

                nombreJug = 0;
                posicionJug = 0;
                nacimientoJug = 0;
                alturaJug = 0;
                equipoJug = 0;

                txtNombreJug.setText(lde.nodoPosicionJugNombre(equipoJug, nombreJug));
                txtPosicionJug.setText(lde.nodoPosicionJugPosicion(equipoJug, posicionJug));
                txtNacimientoJug.setText(lde.nodoPosicionJugNacimiento(equipoJug, nacimientoJug));
                txtAlturaJug.setText(lde.nodoPosicionJugAltura(equipoJug, alturaJug));
                txtEquipoJug.setText(lde.nodoPosicionNombre(equipoJug));

            } else {

                nombreJug = 0;
                posicionJug = 0;
                nacimientoJug = 0;
                alturaJug = 0;

                txtNombreJug.setText(lde.nodoPosicionJugNombre(equipoJug, nombreJug));
                txtPosicionJug.setText(lde.nodoPosicionJugPosicion(equipoJug, posicionJug));
                txtNacimientoJug.setText(lde.nodoPosicionJugNacimiento(equipoJug, nacimientoJug));
                txtAlturaJug.setText(lde.nodoPosicionJugAltura(equipoJug, alturaJug));
                txtEquipoJug.setText(lde.nodoPosicionNombre(equipoJug));

            }

        } else {

            if (nombreJug >= 0 && posicionJug >= 0 && nacimientoJug >= 0 && alturaJug >= 0) {

                txtNombreJug.setText(lde.nodoPosicionJugNombre(equipoJug, nombreJug));
                txtPosicionJug.setText(lde.nodoPosicionJugPosicion(equipoJug, posicionJug));
                txtNacimientoJug.setText(lde.nodoPosicionJugNacimiento(equipoJug, nacimientoJug));
                txtAlturaJug.setText(lde.nodoPosicionJugAltura(equipoJug, alturaJug));
                txtEquipoJug.setText(lde.nodoPosicionNombre(equipoJug));

            } else {
                equipoJug--;
                nombreJug = 0;
                posicionJug = 0;
                nacimientoJug = 0;
                alturaJug = 0;
                txtNombreJug.setText(lde.nodoPosicionJugNombre(equipoJug, nombreJug));
                txtPosicionJug.setText(lde.nodoPosicionJugPosicion(equipoJug, posicionJug));
                txtNacimientoJug.setText(lde.nodoPosicionJugNacimiento(equipoJug, nacimientoJug));
                txtAlturaJug.setText(lde.nodoPosicionJugAltura(equipoJug, alturaJug));
                txtEquipoJug.setText(lde.nodoPosicionNombre(equipoJug));
            }

        }

    }//GEN-LAST:event_bttAnteriorJugActionPerformed

    //regresar de admin jugadores
    private void bttRegresarAdminJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegresarAdminJugActionPerformed

        this.setSize(565, 420);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(true);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(false);
    }//GEN-LAST:event_bttRegresarAdminJugActionPerformed

    //recorer estampas siguiente
    private void bttSiguienteEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSiguienteEstActionPerformed

        rutaE++;
        nombreEqEst++;
        if (rutaE>les.tamanio()-1) {
            JOptionPane.showMessageDialog(null, "YA NO HAY MAS ESTAMPAS!");
            rutaE=les.tamanio()-1;
            nombreEqEst=les.tamanio()-1;
        }else{
        try {
            ImageIcon usac = new ImageIcon(getClass().getResource("/imagenes/" + les.nodoPosicionRuta(rutaE)));
            ImageIcon icono = new ImageIcon(usac.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            txtNombreJugEst.setText(lde.nodoPosicionNombre(lde.buscarEq(les.nodoPosicionEquipo(nombreEqEst)-1)));
        } catch (NullPointerException e) {
            
            ImageIcon usac = new ImageIcon(getClass().getResource("/imagenes/barcelona.png"));
            ImageIcon icono = new ImageIcon(usac.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            txtNombreJugEst.setText(lde.nodoPosicionNombre(lde.buscarEq(les.nodoPosicionEquipo(nombreEqEst)-1)));
        }

        } 
    }//GEN-LAST:event_bttSiguienteEstActionPerformed

    //anterior para recorrer estampas
    private void bttAnteriorEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAnteriorEstActionPerformed
        
        rutaE--;
        nombreEqEst--;
        if (rutaE<0) {
            //JOptionPane.showMessageDialog(null, "YA NO HAY MAS ESTAMPAS!");
            rutaE=0;
            nombreEqEst=0;
            ImageIcon usac = new ImageIcon(getClass().getResource("/imagenes/" + les.nodoPosicionRuta(rutaE)));
            ImageIcon icono = new ImageIcon(usac.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            txtNombreJugEst.setText(lde.nodoPosicionNombre(lde.buscarEq(les.nodoPosicionEquipo(nombreEqEst)-1)));
        }else{
        try {
            ImageIcon usac = new ImageIcon(getClass().getResource("/imagenes/" + les.nodoPosicionRuta(rutaE)));
            ImageIcon icono = new ImageIcon(usac.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            txtNombreJugEst.setText(lde.nodoPosicionNombre(lde.buscarEq(les.nodoPosicionEquipo(nombreEqEst)-1)));
        } catch (NullPointerException e) {
            
            ImageIcon usac = new ImageIcon(getClass().getResource("/imagenes/barcelona.png"));
            ImageIcon icono = new ImageIcon(usac.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            txtNombreJugEst.setText(lde.nodoPosicionNombre(lde.buscarEq(les.nodoPosicionEquipo(nombreEqEst)-1)));
        }

        } 
        
    }//GEN-LAST:event_bttAnteriorEstActionPerformed

    //regresar de admin estampas
    private void bttRegresarAdminEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegresarAdminEstActionPerformed

        
        
        
        
        this.setSize(565, 420);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(true);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(false);
    }//GEN-LAST:event_bttRegresarAdminEstActionPerformed

    //ir al panel admin equipos
    private void bttAdmEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAdmEqActionPerformed
        
        if (!lde.estVacia()) {
            this.setSize(565, 420);
        this.setLocationRelativeTo(null);

        txtNombreEq.setText(lde.nodoPosicionNombre(0));
        txtFechaEq.setText(lde.nodoPosicionFecha(0));
        txtMundiEq.setText(lde.nodoPosicionMundiales(0));

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(false);
        panelAdminEquipos.setVisible(true);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "NO HAY EQUIPOS AUN!");
        }
        

    }//GEN-LAST:event_bttAdmEqActionPerformed

    //ir al panel admin jugadores
    private void bttAdmJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAdmJugActionPerformed

        if (lde.tamanio2!=0) {
            this.setSize(545, 520);
        this.setLocationRelativeTo(null);

        equipoJug = 0;
        nombreJug = 0;
        posicionJug = 0;
        nacimientoJug = 0;
        alturaJug = 0;

        txtNombreJug.setText(lde.nodoPosicionJugNombre(0, 0));
        txtPosicionJug.setText(lde.nodoPosicionJugPosicion(0, 0));
        txtNacimientoJug.setText(lde.nodoPosicionJugNacimiento(0, 0));
        txtAlturaJug.setText(lde.nodoPosicionJugAltura(0, 0));
        txtEquipoJug.setText(lde.nodoPosicionNombre(0));

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(false);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "NO HAY JUGADORES AUN!");
        }
        
    }//GEN-LAST:event_bttAdmJugActionPerformed

    //ir al panel admin estampas
    private void bttAdmEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAdmEstActionPerformed

        if (!les.estaVacia()) {
            rutaE=0;
        nombreEqEst=0;
        ImageIcon usac = new ImageIcon(getClass().getResource("/imagenes/" + les.nodoPosicionRuta(0)));
        ImageIcon icono = new ImageIcon(usac.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        lblImagen.setIcon(icono);
        
        txtNombreJugEst.setText(lde.nodoPosicionNombre(lde.buscarEq(les.nodoPosicionEquipo(0)-1)));
        
        this.setSize(555, 480);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(false);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(true);
        panelAdminJugadores.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "NO HAY ESTAMPAS AUN!");
        }
        
    }//GEN-LAST:event_bttAdmEstActionPerformed

    //ir al panel opaciones ver equipos jugadores estampas
    private void bttJugEqEsIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttJugEqEsIrActionPerformed

        this.setSize(565, 420);
        this.setLocationRelativeTo(null);

        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(false);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(true);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(false);
    }//GEN-LAST:event_bttJugEqEsIrActionPerformed

    //regresar de opcion para ver jugadores equipos estampas
    private void bttRegresarOpcVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegresarOpcVerActionPerformed
       
        this.setSize(705, 390);
        this.setLocationRelativeTo(null);
        
        panelPrincipal.setVisible(false);
        panelAdminIngresar.setVisible(false);
        panelOpcionesAdmin.setVisible(true);
        panelCargaMasiva.setVisible(false);
        panelAdminUsuarios.setVisible(false);
        panelJugEqEst.setVisible(false);
        panelAdminEquipos.setVisible(false);
        panelAdminEstampas.setVisible(false);
        panelAdminJugadores.setVisible(false);
    }//GEN-LAST:event_bttRegresarOpcVerActionPerformed

    private void bttElimUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttElimUsActionPerformed

        ldu.eliminarNodoEspecifico(txtNombreUs.getText());
        lsnp.eliminarNodoEspecifico(txtNombreUs.getText());
        
        System.out.println("");
        lsnp.ordenarUsuarios();
        ldu.ordenarUsuarios();
        ldu.mostrar();
        System.out.println("");
        
    }//GEN-LAST:event_bttElimUsActionPerformed

    
    //Reporte admin
    private void bttReporteAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttReporteAdminActionPerformed
        
        //crear nuevo documento PDF
      Document documento=new Document(); 
      FileOutputStream ficheroPdf; //para crear un fichero
      Calendar cal = Calendar.getInstance();
      Date fecha = new Date( cal.getTimeInMillis() );
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      
      //ruta de PDF
      try 
    {
    ficheroPdf = new FileOutputStream("ReporteAministrador.PDF"); //La direccion donde se guardara nuestro archivo PDF
    PdfWriter.getInstance(
                       documento, 
                       ficheroPdf
                       ).setInitialLeading(20);
    }
    catch (Exception ex) 
    {
    System.out.println(ex.toString());
    }
      
      try{
    documento.open();
    
    
    //Para la fecha
    Paragraph parrafoFech = new Paragraph(""+formato.format(fecha));
    parrafoFech.setAlignment(2);//fecha al lado derecho
    documento.add(parrafoFech);
    documento.add(new Paragraph(" "));
    
    //Textos para el documento
    
    Font fuenteTitulo=new Font();
    fuenteTitulo.setSize(25);
    fuenteTitulo.setStyle(1|4);
    //fuenteTitulo.setColor(BaseColor.RED);
    Paragraph parrafo1 = new Paragraph("Reporte Administrador",fuenteTitulo);
    parrafo1.setAlignment(1);//el 1 es para centrar
    documento.add(parrafo1);
    documento.add(new Paragraph(" "));
    
    Font fuenteCompras=new Font();
    fuenteCompras.setSize(15);
    fuenteCompras.setStyle(1);
    //fuenteCompras.setColor(BaseColor.BLUE);
    Paragraph parrafo2 = new Paragraph("USUARIOS CON ESTAMPAS PEGADAS",fuenteCompras);
    parrafo2.setAlignment(1);//el 1 es para centrar
    documento.add(parrafo2);
    documento.add(new Paragraph(" "));
    
    //aqui agregamos todo el contenido del PDF...
    
    //Para el Encabezado de la tabla compras
    PdfPTable tablaEC = new PdfPTable(2);
    //el numero indica la cantidad de Columnas
    for (int i = 0; i < 1; i++)
      {
	tablaEC.addCell("USUARIO");
        tablaEC.addCell("PEGADAS");
        
       }
        documento.add(tablaEC);
    
    //tabla para compras
    PdfPTable tabla = new PdfPTable(2); //se crea una "tabla" de (5) columnas donde se iran almacenando nuestrod datos
        
    int pegadas=0;
        nodoDobleUsuarios aux=ldu.inicio;
        while(aux!=null){
            
            nodoEstampa auxE=aux.primero;
            
            if (auxE!=null) {
                
                while(auxE!=null){
                    pegadas++;
                    auxE=auxE.siguiente;
                }
                tabla.addCell(aux.datos);
                tabla.addCell(""+pegadas);
                
            }
            
            aux=aux.siguiente;
            pegadas=0;
        }
     
        documento.add(tabla);
        
    documento.add(new Paragraph(" "));    
    Paragraph parrafo3 = new Paragraph("USUARIOS CON ESTAMPAS NO PEGADAS",fuenteCompras);
    parrafo3.setAlignment(1);//el 1 es para centrar
    documento.add(parrafo3);
    documento.add(new Paragraph(" "));
    
    //Para el Encabezado de la tabla compras
    PdfPTable tablaEC2 = new PdfPTable(2);
    //el numero indica la cantidad de Columnas
    for (int i = 0; i < 1; i++)
      {
	tablaEC2.addCell("USUARIO");
        tablaEC2.addCell("NO PEGADAS");
        
       }
        documento.add(tablaEC2);
    
    //tabla para no pegadas
    PdfPTable tabla2 = new PdfPTable(2); //se crea una "tabla" de (5) columnas donde se iran almacenando nuestrod datos
    
    int Nopegadas=0;
    nodoSobreNoPegadas aux2=lsnp.inicio;
        while(aux2!=null){
            
            nodoEstampa auxE2=aux2.primero;
            
            if (auxE2!=null) {
                
                while(auxE2!=null){
                    Nopegadas++;
                    auxE2=auxE2.siguiente;
                }
                tabla2.addCell(aux2.datos);
                tabla2.addCell(""+Nopegadas);
            }
            
            aux2=aux2.siguiente;
            Nopegadas=0;
        }
        
          
          documento.add(tabla2);
    
    documento.close();
    }catch(Exception ex){
    System.out.println(ex.toString());
    }
      
    }//GEN-LAST:event_bttReporteAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttAdmEq;
    private javax.swing.JButton bttAdmEst;
    private javax.swing.JButton bttAdmJug;
    private javax.swing.JButton bttAdmin;
    private javax.swing.JButton bttAdminUsuariosIr;
    private javax.swing.JButton bttAnteriorEq;
    private javax.swing.JButton bttAnteriorEst;
    private javax.swing.JButton bttAnteriorJug;
    private javax.swing.JButton bttAnteriorUs;
    private javax.swing.JButton bttBuscarEquipos;
    private javax.swing.JButton bttBuscarEstUs;
    private javax.swing.JButton bttBuscarEstampas;
    private javax.swing.JButton bttBuscarJugadores;
    private javax.swing.JButton bttBuscarUsuarios;
    private javax.swing.JButton bttCargaMasivaIr;
    private javax.swing.JButton bttElimUs;
    private javax.swing.JButton bttIngresar;
    private javax.swing.JButton bttJugEqEsIr;
    private javax.swing.JButton bttModiUs;
    private javax.swing.JButton bttRegresarAdminEst;
    private javax.swing.JButton bttRegresarAdminJug;
    private javax.swing.JButton bttRegresarAdminUs;
    private javax.swing.JButton bttRegresarAminEquipos;
    private javax.swing.JButton bttRegresarOpcVer;
    private javax.swing.JButton bttReporteAdmin;
    private javax.swing.JButton bttSiguienteEq;
    private javax.swing.JButton bttSiguienteEst;
    private javax.swing.JButton bttSiguienteJug;
    private javax.swing.JButton bttSiguienteUs;
    private javax.swing.JButton bttUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblImagen;
    public javax.swing.JPanel panelAdminEquipos;
    public javax.swing.JPanel panelAdminEstampas;
    public javax.swing.JPanel panelAdminIngresar;
    public javax.swing.JPanel panelAdminJugadores;
    public javax.swing.JPanel panelAdminUsuarios;
    public javax.swing.JPanel panelCargaMasiva;
    public javax.swing.JPanel panelJugEqEst;
    public javax.swing.JPanel panelOpcionesAdmin;
    public javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton regresarDeCargaMasiva;
    private javax.swing.JTextField txtAlturaJug;
    private javax.swing.JTextField txtApellidoUs;
    private javax.swing.JTextField txtEquipoJug;
    private javax.swing.JTextField txtFechaEq;
    private javax.swing.JTextField txtMundiEq;
    private javax.swing.JTextField txtNacimientoJug;
    private javax.swing.JTextField txtNombreEq;
    private javax.swing.JTextField txtNombreJug;
    private javax.swing.JTextField txtNombreJugEst;
    private javax.swing.JTextField txtNombreUs;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPassUs;
    private javax.swing.JTextField txtPosicionJug;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
