
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class Usuarios extends JFrame implements ActionListener,KeyListener,MouseListener {
     
    //////////////////////////////////////////////////////////INTERFAZ PRINCIPAL Y LOGIN///////////////////////////////////////////////////////////////
    public static JPanel panelInterfazPrincipal, panelLogin;
    
    //para interfaz principal
    public static JButton bttLogin, bttAbout;
    
    //para interfaz Login
    public static JLabel titLogin, titIdUsuario,titPassdeLogin, imagenInge,imagenUsac, imagenIngen,titBib;
    public static JTextField IdUsuarioLogin;
    public static JPasswordField passLogin;
    public static JButton login, RegresarLogin;
    
    int contadorGlobal=0; 
    int posicionGlobal=0, filaGlobal=0,columnaGlobal=0;
    
    

    //////////////////////////////////////////////////////////////USUARIOS/////////////////////////////////////////////////////////////////////////////
    
    int contador=0; //contador para buscar usuario a eliminar
    int posicion=0, fila=0,columna=0; //variables para que me den la posicion y fila y columna del ID del usuario a eliminar
    
    int contador1=0; //contador para buscar usuario a modificar
    int posicion1=0, fila1=0,columna1=0; //variables para que me den la posicion y fila y columna del ID del usuario a modificar
    
    int contadorID=0; // contador para ver si existe usuario con ese ID
    int posicion2=0, fila2=0,columna2=0;// //variables para que me den la posicion y fila y columna del ID si existe
    
    //panel1 es interfaz de admin, panel2 es interfaz de crear usuario, panel3 es la interfaz de la tabla ver usuarios
    public static JPanel panel1, panel2, panel3, panelBuscarEliminarUsuario, panelEliminarUsuario, panelBuscarModificarUsuario, panelModificarUsuario;
    
    //para interfaz admin
     public static JLabel titAdmin, titUsuarios, titBiblios, titPrestamos;
     public static JButton about;
     public static JButton crearUs, modiUs, elimUs, verUs;
     public static JButton crearBib, modiBib, elimBib, verBib;
     public static JButton crearPres, modiPres, elimPres, verPres;
    
    //Para interfaz crear usuario
    public static JLabel titUS, titID, titNombre, titApellido, titUser, titRol, titPassword, titConfPass;
    public static JTextField ID, nombre, apellido, user, password, confiPassword;
    public static JComboBox rol;
    public static JButton crearUsuario, regresarDeCrearUsuarioMenu,regresarDeTablaMenu;
    
    //para interfaz Buscar modificar usuario
    public static JLabel titModificarUsuario, titIDModificarUsuario;
    public static JTextField txtbuscarModificarUsuario;
    public static JButton bttbuscarModificarUsuario, bttregresarbuscarModificarusuario;
    
    //Para interfaz modificar usuario
    public static JLabel tittModificarUsuario, titModificarUsuarioID, titModificarUsuarioNombre, titModificarUsuarioApellido, titModificarUsuarioUser, titModificarUsuarioRol, titModificarUsuarioPassword, titModificarUsuarioConfiPassword;
    public static JTextField ModificarUsuarioID, ModificarUsuarionombre, ModificarUsuarioapellido, ModificarUsuariouser, ModificarUsuariopassword,ModificarUsuarioConfipassword;
    public static JComboBox ModificarUsuariorol;
    public static JButton bttModificarUsuario, bttModificarcancelar, bttModificarUsuarioAPrincipal;
    
    int contadorMU=0; // contador para ver si existe usuario con ese ID
    int posicionMU=0, filaMU=0,columnaMU=0;
    
    //Para interfaz Buscar Eliminar Usuario
    public static JLabel titEliminarUsuario, titIDeliminarUsuario;
    public static JTextField txtbuscarEliminarUsuario;
    public static JButton bttbuscarEliminarUsuario, bttregresarbuscareliminarusuario;
    
    //Para interfaz eliminar usuario
    public static JLabel tittEliminarUsuario, titEliminarUsuarioID, titEliminarUsuarioNombre, titEliminarUsuarioApellido, titEliminarUsuarioUser, titEliminarUsuarioRol, titEliminarUsuarioPassword;
    public static JTextField EliminarUsuarioID, EliminarUsuarionombre, EliminarUsuarioapellido, EliminarUsuariouser, EliminarUsuariorol,EliminarUsuariopassword;
    public static JButton bttEliminarUsuario, bttcancelar, bttEliminarUsuarioAPrincipal;
    
    //Para la creacion de la tabla tipo Defatult de ver usuarios
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static JTable tabla = new JTable(modelo);
    
    //////////////////////////////////////////////////////////////BIBLIOGRAFIAS////////////////////////////////////////////////////////////////////////
    public static int posicionn, posicionn1,posicionn2, guardarPos1, guardarPos2, guardarPos3;
    public static String cadenaArea;
    
    public static JPanel panelCrearBibliografia, panelCargaIndividual, panelCargaMasiva, panelModificarBibliografias, panelEliminarBibliografias, panelVerBibliografias;
    
    String obtenerItem; //para que me guarde aca el item selecionado del rol(para mostrar campos disponibles) es de carga individual
    String obtenerItem2; //para que me gurde el item y asi mandar datos a tabla segun corresponda es de carga individual
    
    //para interfaz opcion de carga bibliografia
    public static JLabel titCargaBibliografia;
    public static JButton bttCargaIndividual, bttCargaMasiva, bttRegresarDeCrearBibliografia;
    
    //para interfaz carga individual
    public static JLabel titCargaIndividual,titAutor, titTitulo, titEdicion, titDescripcion, titFrecuencia, titEjemplares, titTemas, titPalabrasClave, titCopias, titDisponibles, titArea;
    public static JTextField autor, titulo, edicion, descripcion, frecuencia, ejemplares, temas, palabrasClave, copias, disponibles, area;
    public static JComboBox rolBibliografia;
    public static JButton bttcrearBibliografiaIndividual, bttcancelarBibliografiaIndividual, bttregresarDeCargaIndividual, bttcargar;
    
    //para interfaz carga masiva
    public static JLabel titCargaMasiva;
    public static JTextArea txtarea;
    public static JButton bttcrearBibliografiaMasiva, bttcancelarBibliografiaMasiva, bttregresarDeCargaMasiva;
    
    //para interfaz de modificar bibliografia
    public static JLabel titModifiarBibliografia, txtModificarTipo, txtModificarCopias, txtModificarPalablras, txtModificarDescripcion;
    public static JTextField ModiTipo, ModiCopias, ModiPalabras, ModiDescripcion;
    public static JButton modificarBibliografia, aceptarModificarBibliografia, cancelarModificarBibliografia,regresarDeModificarBibliografia;
    public static int filaSelect; //para seleccionar fila a modificar
    
    //para interfaz de eliminar bibliografia
    public static JLabel titEliminarBibliografia;
    public static JButton eliminarBibliografia, regresarDeEliminarBibliografia;
    
    //para interfaz ver bibliografias
    public static JLabel txtVerBibliografias, txtbuscar;
    public static JButton regresarDeVerBibliografia;
    public static JComboBox rolVerBibliografia;
    public static JTextField filtro;
    int segunItem; //se usa en el evento keyTyped
    TableRowSorter trs; // para el keyTyped
    
    //para la creacion de tabla de ver bibliografias
    public static DefaultTableModel modelo2 = new DefaultTableModel();
    public static JTable tabla2 = new JTable(modelo2);
    
    //para la creacion de tabla modificar bibliografias
    public static JTable tabla3 = new JTable(modelo2); //se creo solo la tabla y se pasa como parametro el modelo de la tabla ver bibliografias
                                                       //para que solo me haga la copia de los datos de tabla
    
    //para la creacion de tabla eliminar bibliografia
    public static JTable tabla4 =new JTable(modelo2); //se creo solo la tabla y se pasa como parametro el modelo de la tabla ver bibliografias
                                                       //para que solo me haga la copia de los datos de tabla
    
    
    //////////////////////////////////////////////////////////////PRESTAMOS/////////////////////////////////////////////////////////////////////////////
    
    public static JPanel panelCrearPrestamos, panelAsignarPrestamo, panelVerPrestamos, panelModificarPrestamos, PanelEliminarPrestamos, panelModificarPrestamos2;
    
    //para interfaz crear prestamo
     public static JLabel titCrearPrestamos, titBuscarCrearPrestamo;
    public static JTextField filtro2;
    public static JComboBox rolCrearPrestamo;
    public static JButton hacerPrestamo, regresarDeHacerPrestamo;
    int segunItem2; //se usa en el evento keyTyped
    TableRowSorter trs2; // para el keyTyped
    
    //para la creacion de tabla crear prestamos
    public static JTable tabla5 =new JTable(modelo2);
    
    //para interfaz asignar prestamo
    public static JLabel titAsignarPrestamo;
    public static JComboBox rolAsignarPrestamo;
    public static JButton asignarPrestamoUsuario, cancelarAsignarPrestamoUsuario;
    int filaSelectHacerPrestamo;
    String NombresParaPrestamo;
    
    //para buscar el usuario y nos de la fila en la que esta
    int contadorAu=0; 
    int posicionAu=0, filaAu=0,columnaAu=0;
    
    //para verificar si el usuario tiene un prestamo igual 
    int contadorVp=0; 
    int posicionVp=0, filaVp=0,columnaVp=0;
    
    //para interfaz de ver prestamos
    public static JLabel txtPrestamos;
    public static JButton regresarDeVerPrestamos;
    
    
    public static DefaultTableModel modelo3 = new DefaultTableModel();
    public static JTable tabla6 = new JTable(modelo3);
    
    //para interfaz de modificar prestamos
    public static JLabel txtModificarPrestamos;
    public static JButton ModificarPrestamo, regresarDeModificarPrestamo;
    int filaselectAsignarPrestamo;
    
    public static JTable tabla7 =new JTable(modelo3);
    
    //para interfaz de modificar prestamos 2 (el que tiene comboBox)
    public static JLabel txtSelecBib;
    public static JComboBox rolModiPrestamo;
    public static JButton ModiPrestamo2, regresarDeModiPrestamo2;
    String NombresBibParaPrestamo;
    
    //para verificar si ya existe una bibliografia (LIBROS)
    int contadorParaLibro0=0; 
    int posicionParaLibros0=0, filaParaLibros0=0,columnaParaLibros0=0;
    
    //para verificar si ya existe una bibliografia (REVISTA)
    int contadorParaRevista0=0; 
    int posicionParaRevista0=0, filaParaRevista0=0,columnaParaRevista0=0;
    
    //para buscar el usuario y nos de la fila en la que esta
    int contadorUs=0; 
    int posicionUs=0, filaUs=0,columnaUs=0;
    
    
    //para interfaz de eliminar prestamos
    public static JLabel txtEliminarPrestamos;
    public static JButton EliminarPrestamo, regresarDeEliminarPrestamo;
    
    public static JTable tabla8 =new JTable(modelo3);
    
    int contadorElimUs=0; 
    int posicionElimUs=0, filaElimUs=0,columnaElimUs=0;
    
    ////////////////////////////////////////////////////////////////INTEFAZ USUARIO/////////////////////////////////////////////////////////////////////
    public static JPanel panelInterfazUsuario;
    
    public static DefaultTableModel modelo4 = new DefaultTableModel(){
        public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla no sea editable
            return false;
        }
        
    };
    public static JTable tabla9= new JTable(modelo4);
    
    
    public static JLabel titBuscarEnUsuario;
    public static JTextField filtro3;
    public static JComboBox rolUsuario;
    public static JButton logoutUsuario, BibliotecaVirtual;
    
    int segunItem3; //para elkeyTyped
    TableRowSorter trs3; // para el keyTyped
    
    //botones en las celdas
    public static JButton btn1=new JButton("agregar");
    
    
    //////////////////////////////////////////////////////////////USUARIO 1/////////////////////////////////////////////////////////////////////////////
    public static JPanel panelUsuario1;
    
    public static boolean ParaModelo5[]={false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
     public static DefaultTableModel modelo5 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo5[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla10 =new JTable(modelo5);
    
    public static boolean ParaModelo6[]={false,false,false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
    public static DefaultTableModel modelo6 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo6[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla11 =new JTable(modelo6);
    
    public static boolean ParaModelo7[]={false,false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
    public static DefaultTableModel modelo7 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo7[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla12 =new JTable(modelo7);
    
    public static JLabel usuario1Libros, usuario1Revistas, usuario1Tesis, buscar1;
    
    public static JTextField filtro4;
    public static JComboBox rolUsuario1;
    
    public static JButton regresarDeUsuario1, reportePrestamos1, devolucionLibros1;
    
    public static JCheckBox check1 =new JCheckBox();    
    
    int segunItem4; //para elkeyTyped
    TableRowSorter trs4; // para el keyTyped
    TableRowSorter trs5; // para el keyTyped
    TableRowSorter trs6; // para el keyTyped
    
    //para verificar si ya existe una bibliografia (LIBROS)
    int contadorBib=0; 
    int posicion3=0, fila3=0,columna3=0;
    
    
    
   //////////////////////////////////////////////////////////////REPORTE USUARIO 1/////////////////////////////////////////////////////////////////////////////
    public static JPanel panelReporteUsuario1;
    
    public static JLabel txtprestamos1,txtdevoluciones1,txtmodificaciones1,txteliminado1;
    
    public static JButton regresarReporteUsuario1;
    
    public static DefaultTableModel modelo8 = new DefaultTableModel();
    public static JTable tabla13 =new JTable(modelo8);
    
    public static DefaultTableModel modelo9 = new DefaultTableModel();
    public static JTable tabla14 =new JTable(modelo9);
    
    public static DefaultTableModel modelo10 = new DefaultTableModel();
    public static JTable tabla15 =new JTable(modelo10);
    
    public static DefaultTableModel modelo11 = new DefaultTableModel();
    public static JTable tabla16 =new JTable(modelo11);
    
    //////////////////////////////////////////////////////////////USUARIO 2/////////////////////////////////////////////////////////////////////////////
    public static JPanel panelUsuario2;
    
    public static boolean ParaModelo12[]={false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
     public static DefaultTableModel modelo12 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo12[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla17 =new JTable(modelo12);
    
    public static boolean ParaModelo13[]={false,false,false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
    public static DefaultTableModel modelo13 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo13[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla18 =new JTable(modelo13);
    
    public static boolean ParaModelo14[]={false,false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
    public static DefaultTableModel modelo14 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo14[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla19 =new JTable(modelo14);
    
    public static JLabel usuario2Libros, usuario2Revistas, usuario2Tesis, buscar2;
    
    public static JTextField filtro5;
    public static JComboBox rolUsuario2;
    
    public static JButton regresarDeUsuario2, reportePrestamos2, devolucionLibros2;
    
    
    int segunItem5; //para elkeyTyped
    TableRowSorter trs7; // para el keyTyped
    TableRowSorter trs8; // para el keyTyped
    TableRowSorter trs9; // para el keyTyped
    
    //////////////////////////////////////////////////////////////REPORTE USUARIO 2/////////////////////////////////////////////////////////////////////////////
    public static JPanel panelReporteUsuario2;
    
    public static JLabel txtprestamos2,txtdevoluciones2,txtmodificaciones2,txteliminado2;
    
    public static JButton regresarReporteUsuario2;
    
    public static DefaultTableModel modelo15 = new DefaultTableModel();
    public static JTable tabla20 =new JTable(modelo15);
    
    public static DefaultTableModel modelo16 = new DefaultTableModel();
    public static JTable tabla21 =new JTable(modelo16);
    
    public static DefaultTableModel modelo17 = new DefaultTableModel();
    public static JTable tabla22 =new JTable(modelo17);
    
    public static DefaultTableModel modelo18 = new DefaultTableModel();
    public static JTable tabla23 =new JTable(modelo18);
    
    //////////////////////////////////////////////////////////////USUARIO 3/////////////////////////////////////////////////////////////////////////////
    public static JPanel panelUsuario3;
    
    public static boolean ParaModelo19[]={false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
     public static DefaultTableModel modelo19 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo19[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla24 =new JTable(modelo19);
    
    public static boolean ParaModelo20[]={false,false,false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
    public static DefaultTableModel modelo20 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo20[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla25 =new JTable(modelo20);
    
    public static boolean ParaModelo21[]={false,false,false,false,false,false,false,false,false,false,false,false,true}; //para que solo el check sea editable
    
    public static DefaultTableModel modelo21 = new DefaultTableModel(){
      public boolean isCellEditable(int row, int column){  //esto de aqui es para que nuestro modelo de tabla que sea editabla por el check
          return ParaModelo21[column];
        }
        
        Class[] types = new Class[]{ //esto es para que tipo de objeto llevara nuestra tabla (columna 10 es boolean) ahi va el check
            
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
        };
        
        public Class getColumnClass(int columnIndex){//aqui me retorna los tipos de columnas que son
            return types[columnIndex];
        }
        
    };
    public static JTable tabla26 =new JTable(modelo21);
    
    public static JLabel usuario3Libros, usuario3Revistas, usuario3Tesis, buscar3;
    
    public static JTextField filtro6;
    public static JComboBox rolUsuario3;
    
    public static JButton regresarDeUsuario3, reportePrestamos3, devolucionLibros3;
    
    
    int segunItem6; //para elkeyTyped
    TableRowSorter trs10; // para el keyTyped
    TableRowSorter trs11; // para el keyTyped
    TableRowSorter trs12; // para el keyTyped
    
    //////////////////////////////////////////////////////////////REPORTE USUARIO 3/////////////////////////////////////////////////////////////////////////////
    public static JPanel panelReporteUsuario3;
    
    public static JLabel txtprestamos3,txtdevoluciones3,txtmodificaciones3,txteliminado3;
    
    public static JButton regresarReporteUsuario3;
    
    public static DefaultTableModel modelo22 = new DefaultTableModel();
    public static JTable tabla27 =new JTable(modelo22);
    
    public static DefaultTableModel modelo23 = new DefaultTableModel();
    public static JTable tabla28 =new JTable(modelo23);
    
    public static DefaultTableModel modelo24 = new DefaultTableModel();
    public static JTable tabla29 =new JTable(modelo24);
    
    public static DefaultTableModel modelo25 = new DefaultTableModel();
    public static JTable tabla30 =new JTable(modelo25);
    
    public Usuarios(){
     
        
        //Todo lo de mi ventana (JFrame)
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(985, 560);
        this.setTitle("BIBLIOTECA VIRTUAL");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        
        //Columnas que tendra mi tabla ver usuarios
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("USER");
        modelo.addColumn("ROL");
        modelo.addColumn("PASSWORD");
        
        //columnas que tendra mi tabla ver bibliografias
        modelo2.addColumn("TIPO");
        modelo2.addColumn("AUTOR");
        modelo2.addColumn("TITULO");
        modelo2.addColumn("EDICION");
        modelo2.addColumn("DESCRIPCION");
        modelo2.addColumn("FRECUENCIA");
        modelo2.addColumn("EJEMPLARES");
        modelo2.addColumn("TEMAS");
        modelo2.addColumn("PALABRAS CLAVE");
        modelo2.addColumn("AREA");
        modelo2.addColumn("COPIAS");
        modelo2.addColumn("DISPONIBLES");
        
        //columnas que tendra mi tabla ver prestamos
        modelo3.addColumn("TIPO");
        modelo3.addColumn("AUTOR");
        modelo3.addColumn("TITULO");
        modelo3.addColumn("NOMBRE DE USUARIO");
        modelo3.addColumn("COPIAS");
        modelo3.addColumn("DISPONIBLES");
        modelo3.addColumn("FECHA");
        modelo3.addColumn("HORA");
        modelo3.addColumn("DIAS VIGENTE");
        
        modelo4.addColumn("TIPO");
        modelo4.addColumn("AUTOR");
        modelo4.addColumn("TITULO");
        modelo4.addColumn("EDICION");
        modelo4.addColumn("DESCRIPCION");
        modelo4.addColumn("FRECUENCIA");
        modelo4.addColumn("EJEMPLARES");
        modelo4.addColumn("TEMAS");
        modelo4.addColumn("PALABRAS CLAVE");
        modelo4.addColumn("AREA");
        modelo4.addColumn("COPIAS");
        modelo4.addColumn("DISPONIBLES");
        modelo4.addColumn("ACCION");
        
        //para usuario 1
        modelo5.addColumn("TIPO");
        modelo5.addColumn("AUTOR");
        modelo5.addColumn("TITULO");
        modelo5.addColumn("EDICION");
        modelo5.addColumn("DESCRIPCION");
        modelo5.addColumn("TEMAS");
        modelo5.addColumn("PALABRAS CLAVE");
        modelo5.addColumn("COPIAS");
        modelo5.addColumn("DISPONIBLEs");
        modelo5.addColumn("FECHA");
        modelo5.addColumn("HORA");
        modelo5.addColumn("ACCION");
        
        modelo6.addColumn("TIPO");
        modelo6.addColumn("AUTOR");
        modelo6.addColumn("TITULO");
        modelo6.addColumn("EDICION");
        modelo6.addColumn("DESCRIPCION");
        modelo6.addColumn("FRECUENCIA");
        modelo6.addColumn("EJEMPLARES");
        modelo6.addColumn("TEMAS");
        modelo6.addColumn("PALABRAS CLAVE");
        modelo6.addColumn("COPIAS");
        modelo6.addColumn("DISPONIBLEs");
        modelo6.addColumn("FECHA");
        modelo6.addColumn("HORA");
        modelo6.addColumn("ACCION");
        
        modelo7.addColumn("TIPO");
        modelo7.addColumn("AUTOR");
        modelo7.addColumn("TITULO");
        modelo7.addColumn("EDICION");
        modelo7.addColumn("DESCRIPCION");
        modelo7.addColumn("TEMAS");
        modelo7.addColumn("PALABRAS CLAVE");
        modelo7.addColumn("AREA");
        modelo7.addColumn("COPIAS");
        modelo7.addColumn("DISPONIBLEs");
        modelo7.addColumn("FECHA");
        modelo7.addColumn("HORA");
        modelo7.addColumn("ACCION");
        
        //para reporte usuario 1
        modelo8.addColumn("TIPO");
        modelo8.addColumn("AUTOR");
        modelo8.addColumn("TITULO");
        modelo8.addColumn("NOMBRE DE USUARIO");
        modelo8.addColumn("FECHA");
        modelo8.addColumn("HORA");
        
        modelo9.addColumn("TIPO");
        modelo9.addColumn("AUTOR");
        modelo9.addColumn("TITULO");
        modelo9.addColumn("NOMBRE DE USUARIO");
        modelo9.addColumn("FECHA");
        modelo9.addColumn("HORA");
        
        modelo10.addColumn("TIPO");
        modelo10.addColumn("AUTOR");
        modelo10.addColumn("TITULO");
        modelo10.addColumn("NOMBRE DE USUARIO");
        modelo10.addColumn("FECHA");
        modelo10.addColumn("HORA");
        
        modelo11.addColumn("TIPO");
        modelo11.addColumn("AUTOR");
        modelo11.addColumn("TITULO");
        modelo11.addColumn("NOMBRE DE USUARIO");
        modelo11.addColumn("FECHA");
        modelo11.addColumn("HORA");
        
        //para usuario 2
        modelo12.addColumn("TIPO");
        modelo12.addColumn("AUTOR");
        modelo12.addColumn("TITULO");
        modelo12.addColumn("EDICION");
        modelo12.addColumn("DESCRIPCION");
        modelo12.addColumn("TEMAS");
        modelo12.addColumn("PALABRAS CLAVE");
        modelo12.addColumn("COPIAS");
        modelo12.addColumn("DISPONIBLEs");
        modelo12.addColumn("FECHA");
        modelo12.addColumn("HORA");
        modelo12.addColumn("ACCION");
        
        modelo13.addColumn("TIPO");
        modelo13.addColumn("AUTOR");
        modelo13.addColumn("TITULO");
        modelo13.addColumn("EDICION");
        modelo13.addColumn("DESCRIPCION");
        modelo13.addColumn("FRECUENCIA");
        modelo13.addColumn("EJEMPLARES");
        modelo13.addColumn("TEMAS");
        modelo13.addColumn("PALABRAS CLAVE");
        modelo13.addColumn("COPIAS");
        modelo13.addColumn("DISPONIBLEs");
        modelo13.addColumn("FECHA");
        modelo13.addColumn("HORA");
        modelo13.addColumn("ACCION");
        
        modelo14.addColumn("TIPO");
        modelo14.addColumn("AUTOR");
        modelo14.addColumn("TITULO");
        modelo14.addColumn("EDICION");
        modelo14.addColumn("DESCRIPCION");
        modelo14.addColumn("TEMAS");
        modelo14.addColumn("PALABRAS CLAVE");
        modelo14.addColumn("AREA");
        modelo14.addColumn("COPIAS");
        modelo14.addColumn("DISPONIBLEs");
        modelo14.addColumn("FECHA");
        modelo14.addColumn("HORA");
        modelo14.addColumn("ACCION");
        
        //para reporte usuario 2
        modelo15.addColumn("TIPO");
        modelo15.addColumn("AUTOR");
        modelo15.addColumn("TITULO");
        modelo15.addColumn("NOMBRE DE USUARIO");
        modelo15.addColumn("FECHA");
        modelo15.addColumn("HORA");
        
        modelo16.addColumn("TIPO");
        modelo16.addColumn("AUTOR");
        modelo16.addColumn("TITULO");
        modelo16.addColumn("NOMBRE DE USUARIO");
        modelo16.addColumn("FECHA");
        modelo16.addColumn("HORA");
        
        modelo17.addColumn("TIPO");
        modelo17.addColumn("AUTOR");
        modelo17.addColumn("TITULO");
        modelo17.addColumn("NOMBRE DE USUARIO");
        modelo17.addColumn("FECHA");
        modelo17.addColumn("HORA");
        
        modelo18.addColumn("TIPO");
        modelo18.addColumn("AUTOR");
        modelo18.addColumn("TITULO");
        modelo18.addColumn("NOMBRE DE USUARIO");
        modelo18.addColumn("FECHA");
        modelo18.addColumn("HORA");
        
        //para usuario 3
        modelo19.addColumn("TIPO");
        modelo19.addColumn("AUTOR");
        modelo19.addColumn("TITULO");
        modelo19.addColumn("EDICION");
        modelo19.addColumn("DESCRIPCION");
        modelo19.addColumn("TEMAS");
        modelo19.addColumn("PALABRAS CLAVE");
        modelo19.addColumn("COPIAS");
        modelo19.addColumn("DISPONIBLEs");
        modelo19.addColumn("FECHA");
        modelo19.addColumn("HORA");
        modelo19.addColumn("ACCION");
        
        modelo20.addColumn("TIPO");
        modelo20.addColumn("AUTOR");
        modelo20.addColumn("TITULO");
        modelo20.addColumn("EDICION");
        modelo20.addColumn("DESCRIPCION");
        modelo20.addColumn("FRECUENCIA");
        modelo20.addColumn("EJEMPLARES");
        modelo20.addColumn("TEMAS");
        modelo20.addColumn("PALABRAS CLAVE");
        modelo20.addColumn("COPIAS");
        modelo20.addColumn("DISPONIBLEs");
        modelo20.addColumn("FECHA");
        modelo20.addColumn("HORA");
        modelo20.addColumn("ACCION");
        
        modelo21.addColumn("TIPO");
        modelo21.addColumn("AUTOR");
        modelo21.addColumn("TITULO");
        modelo21.addColumn("EDICION");
        modelo21.addColumn("DESCRIPCION");
        modelo21.addColumn("TEMAS");
        modelo21.addColumn("PALABRAS CLAVE");
        modelo21.addColumn("AREA");
        modelo21.addColumn("COPIAS");
        modelo21.addColumn("DISPONIBLEs");
        modelo21.addColumn("FECHA");
        modelo21.addColumn("HORA");
        modelo21.addColumn("ACCION");
        
        //para reporte usuario 3
        modelo22.addColumn("TIPO");
        modelo22.addColumn("AUTOR");
        modelo22.addColumn("TITULO");
        modelo22.addColumn("NOMBRE DE USUARIO");
        modelo22.addColumn("FECHA");
        modelo22.addColumn("HORA");
        
        modelo23.addColumn("TIPO");
        modelo23.addColumn("AUTOR");
        modelo23.addColumn("TITULO");
        modelo23.addColumn("NOMBRE DE USUARIO");
        modelo23.addColumn("FECHA");
        modelo23.addColumn("HORA");
        
        modelo24.addColumn("TIPO");
        modelo24.addColumn("AUTOR");
        modelo24.addColumn("TITULO");
        modelo24.addColumn("NOMBRE DE USUARIO");
        modelo24.addColumn("FECHA");
        modelo24.addColumn("HORA");
        
        modelo25.addColumn("TIPO");
        modelo25.addColumn("AUTOR");
        modelo25.addColumn("TITULO");
        modelo25.addColumn("NOMBRE DE USUARIO");
        modelo25.addColumn("FECHA");
        modelo25.addColumn("HORA");
        
        //llama al metodo, para mostrar los panel
        iniciarComponentes();
        
        //para la tabla interfaz usuarios, se le asigna el objeto .class y se le pasa la clase Render
        tabla9.setDefaultRenderer(Object.class, new Render());
        tabla9.setRowHeight(30); //tama;o de las filas
        
        tabla9.setRowSorter(new TableRowSorter(modelo4));
        
        //intefaz usuario1
        tabla10.setDefaultRenderer(Object.class, new Render());
        tabla11.setDefaultRenderer(Object.class, new Render());
        tabla12.setDefaultRenderer(Object.class, new Render());
        
        tabla10.addMouseListener(this); //para el doble ckick
        tabla11.addMouseListener(this); //para el doble ckick
        tabla12.addMouseListener(this); //para el doble ckick
        
        tabla17.addMouseListener(this); //para el doble ckick
        tabla18.addMouseListener(this); //para el doble ckick
        tabla19.addMouseListener(this); //para el doble ckick
        
        tabla24.addMouseListener(this); //para el doble ckick
        tabla25.addMouseListener(this); //para el doble ckick
        tabla26.addMouseListener(this); //para el doble ckick
        
        
        
    }

    private void iniciarComponentes() {
        
        //////////////////////////////////////////////////////////INTERFAZ PRINCIPAL Y LOGIN///////////////////////////////////////////////////////////
        
        //caracteristicas de interfaz principal
        panelInterfazPrincipal=new JPanel();
        panelInterfazPrincipal.setBackground(Color.LIGHT_GRAY);
        panelInterfazPrincipal.setBounds(10, 10, 950, 500);
        panelInterfazPrincipal.setLayout(null);
        
        //caracteristicas de interfaz login
        panelLogin=new JPanel();
        panelLogin.setBackground(Color.GREEN);
        panelLogin.setBounds(10, 10, 340, 360);
        panelLogin.setLayout(null);
        
        //carga los componentes que contiene cada panel
        InterfazGrafica.PanelInterfazPrincipal();
        InterfazGrafica.panelLogin();
        
         ImageIcon usac=new ImageIcon(getClass().getResource("/img/usac1.png"));
        ImageIcon icono=new ImageIcon(usac.getImage().getScaledInstance(imagenUsac.getWidth(), imagenUsac.getHeight(), Image.SCALE_DEFAULT));
        imagenUsac.setIcon(icono);
        
        ImageIcon ingen=new ImageIcon(getClass().getResource("/img/ingen.png"));
        ImageIcon icono3=new ImageIcon(ingen.getImage().getScaledInstance(imagenIngen.getWidth(),imagenIngen.getHeight(), Image.SCALE_DEFAULT));
        imagenIngen.setIcon(icono3);
        
         //se agrega los panel a mi ventana (JFrame)
        add(panelInterfazPrincipal);
        add(panelLogin);
        
        //acciones botones interfaz principal
        bttLogin.addActionListener(this);
        bttAbout.addActionListener(this);
        
        //acciones botones login
        login.addActionListener(this);
        RegresarLogin.addActionListener(this);
        
        
        /////////////////////////////////////////////////////////USUARIOS//////////////////////////////////////////////////////////////////////////
        
        //caracteristicas del panel1 (interfaz del administrador)
        panel1=new JPanel();
        panel1.setBackground(Color.GRAY);
        panel1.setBounds(10, 10, 950, 500);
        panel1.setLayout(null);
        
        //caracteristicas de la interfaz de crear usuario
        panel2=new JPanel();
        panel2.setBackground(Color.GRAY);
        panel2.setBounds(10, 10, 950, 500);
        panel2.setLayout(null);
        
        //caracteristicas de la interfaz de ver usuarios en la tabla
        panel3=new JPanel();
        panel3.setBackground(Color.GRAY);
        panel3.setBounds(10, 10, 950, 500);
        panel3.setLayout(null);
        
        //caracteristicas del panel para buscar usuario a modificar
        panelBuscarModificarUsuario=new JPanel();
        panelBuscarModificarUsuario.setBackground(Color.GRAY);
        panelBuscarModificarUsuario.setBounds(10, 10, 340, 310);
        panelBuscarModificarUsuario.setLayout(null);
        
        //caracteristicas del panell para modificar un usuario
        panelModificarUsuario=new JPanel();
        panelModificarUsuario.setBackground(Color.GRAY);
        panelModificarUsuario.setBounds(10, 10, 950, 500);
        panelModificarUsuario.setLayout(null);
        
        //caracteristicas del panel para buscar usuario a eliminar
        panelBuscarEliminarUsuario=new JPanel();
        panelBuscarEliminarUsuario.setBackground(Color.GRAY);
        panelBuscarEliminarUsuario.setBounds(10, 10, 340, 310);
        panelBuscarEliminarUsuario.setLayout(null);
        
        //caracteristicas del panell para eliminar un usuario
        panelEliminarUsuario=new JPanel();
        panelEliminarUsuario.setBackground(Color.GRAY);
        panelEliminarUsuario.setBounds(10, 10, 950, 500);
        panelEliminarUsuario.setLayout(null);
        
        //carga los componentes que contiene cada panel
        InterfazGrafica.cargarComponentesPanel1();
        InterfazGrafica.cargarComponentesPanel2();
        InterfazGrafica.cargarComponentesPanel3();
        InterfazGrafica.cargarComponentespanelBuscarModificarUsuario();
        InterfazGrafica.cargarComponentespanelBuscarEliminarUsuario();
        InterfazGrafica.cargarComponentespanelEliminarUsuario();
        InterfazGrafica.cargarComponentespanelModificarUsuario();
        
        
        //se agrega los panel a mi ventana (JFrame)
       add(panel1);
       add(panel2);
       add(panel3);
       add(panelBuscarModificarUsuario);
       add(panelBuscarEliminarUsuario);
       add(panelEliminarUsuario);
       add(panelModificarUsuario);
       
       //acciones de botones panel de administrdor//
       
       //accion de botones usuarios
        crearUs.addActionListener(this);
        modiUs.addActionListener(this);
        elimUs.addActionListener(this);
        verUs.addActionListener(this);
       //accion de botones bibliografias
        crearBib.addActionListener(this);
        modiBib.addActionListener(this);
        elimBib.addActionListener(this);
        verBib.addActionListener(this);
        //accion de botones prestamos
        crearPres.addActionListener(this);
        modiPres.addActionListener(this);
        elimPres.addActionListener(this);
        verPres.addActionListener(this);
        //accion de about
        about.addActionListener(this);
        
        //acciones de botones de panel crear usuario//
        crearUsuario.addActionListener(this);
        regresarDeCrearUsuarioMenu.addActionListener(this);
        regresarDeTablaMenu.addActionListener(this); //este es el boton que esta en la tabla
        
        //acciones de botones de panel para buscar usuario a modificar//
        bttbuscarModificarUsuario.addActionListener(this);
        bttregresarbuscarModificarusuario.addActionListener(this);
        
        //acciones de botones de panel modificar usuario
        bttModificarUsuario.addActionListener(this);
        bttModificarcancelar.addActionListener(this);
        bttModificarUsuarioAPrincipal.addActionListener(this);
        
        //acciones de botones de panel para buscar usuario a eliminar//
        bttbuscarEliminarUsuario.addActionListener(this);
        bttregresarbuscareliminarusuario.addActionListener(this);
        
        //acciones de botoens de panel eliminar usuario
        bttEliminarUsuario.addActionListener(this);
        bttcancelar.addActionListener(this);
        bttEliminarUsuarioAPrincipal.addActionListener(this);
       
       ///////////////////////////////////////////////////////BIBLIOGRAFIAS///////////////////////////////////////////////////////////////////////////
       
       //caracteristicas panel para crear bibliografia
       panelCrearBibliografia=new JPanel();
       panelCrearBibliografia.setBackground(Color.RED);
       panelCrearBibliografia.setBounds(10, 10, 550, 225);
       panelCrearBibliografia.setLayout(null);
       
       //caracteristicas panel para carga individual
       panelCargaIndividual=new JPanel();
       panelCargaIndividual.setBackground(Color.RED);
       panelCargaIndividual.setBounds(10, 10, 950, 675);
       panelCargaIndividual.setLayout(null);
       
       //caracteristicas de panel para carga masiva
       panelCargaMasiva=new JPanel();
       panelCargaMasiva.setBackground(Color.RED);
       panelCargaMasiva.setBounds(10, 10, 950, 500);
       panelCargaMasiva.setLayout(null);
       
       //caracteristicas de panel modificar bibliografias
       panelModificarBibliografias=new JPanel();
       panelModificarBibliografias.setBackground(Color.RED);
       panelModificarBibliografias.setBounds(10, 10, 950, 650);
       panelModificarBibliografias.setLayout(null);
       
       //caracteristicas de panel eliminar bibliografia
       panelEliminarBibliografias=new JPanel();
       panelEliminarBibliografias.setBackground(Color.RED);
       panelEliminarBibliografias.setBounds(10, 10, 950, 500);
       panelEliminarBibliografias.setLayout(null);
       
       //caracteristicas de panel ver bibliografias
       panelVerBibliografias=new JPanel();
       panelVerBibliografias.setBackground(Color.RED);
       panelVerBibliografias.setBounds(10, 10, 950, 500);
       panelVerBibliografias.setLayout(null);
       
       
       
       //componentes que contiene cada panel
       InterfazGrafica.panelCrearBibliografia();
       InterfazGrafica.panelCargaIndividual();
       InterfazGrafica.panelCargaMasiva();
       InterfazGrafica.panelVerBibliografias();
       InterfazGrafica.panelModificarBibliografias();
       InterfazGrafica.panelEliminarBibliografias();
       
       //se agregan los panales a mi ventana (JFrame)
       add(panelCrearBibliografia);
       add(panelCargaIndividual);
       add(panelCargaMasiva);
       add(panelVerBibliografias);
       add(panelModificarBibliografias);
       add(panelEliminarBibliografias);
       
       //acciones de botones opcion de carga//
       bttCargaIndividual.addActionListener(this);
       bttCargaMasiva.addActionListener(this);
       bttRegresarDeCrearBibliografia.addActionListener(this);
       
       //acciones de botones de carga individual//
       bttcrearBibliografiaIndividual.addActionListener(this);
       bttcancelarBibliografiaIndividual.addActionListener(this);
       bttregresarDeCargaIndividual.addActionListener(this);
       bttcargar.addActionListener(this);
       
       //acciones de botones de carga masiva//
       bttcrearBibliografiaMasiva.addActionListener(this);
       bttcancelarBibliografiaMasiva.addActionListener(this);
       bttregresarDeCargaMasiva.addActionListener(this);
       
       //acciones de botones eliminar bibliografia//
       eliminarBibliografia.addActionListener(this);
       regresarDeEliminarBibliografia.addActionListener(this);
       
       //acciones de botones modificar bibliografia//
       modificarBibliografia.addActionListener(this);
       aceptarModificarBibliografia.addActionListener(this);
       cancelarModificarBibliografia.addActionListener(this);
       regresarDeModificarBibliografia.addActionListener(this);
       
       //accion de botones ver bibliografia//
       regresarDeVerBibliografia.addActionListener(this);
       
       //accion del filtro para ver usuarios
       filtro.addKeyListener(this);
       
    
     //////////////////////////////////////////////////////////////PRESTAMOS/////////////////////////////////////////////////////////////////////////////

       //caracteristicas de panel crear prestamo
       panelCrearPrestamos=new JPanel();
       panelCrearPrestamos.setBackground(Color.ORANGE);
       panelCrearPrestamos.setBounds(10, 10, 950, 500);
       panelCrearPrestamos.setLayout(null);
       
       //caracteristicas del panel para asignar prestamo a usuario
        panelAsignarPrestamo=new JPanel();
        panelAsignarPrestamo.setBackground(Color.ORANGE);
        panelAsignarPrestamo.setBounds(10, 10, 340, 310);
        panelAsignarPrestamo.setLayout(null);
        
        //caracteristicas del panel ver prestamos
        panelVerPrestamos=new JPanel();
        panelVerPrestamos.setBackground(Color.ORANGE);
        panelVerPrestamos.setBounds(10, 10, 950, 500);
        panelVerPrestamos.setLayout(null);
        
        //caracteristicas del panel modificar prestamos
        panelModificarPrestamos=new JPanel();
        panelModificarPrestamos.setBackground(Color.ORANGE);
        panelModificarPrestamos.setBounds(10, 10, 950, 500);
        panelModificarPrestamos.setLayout(null);
        
        //caracteristicas de panel modificar prestamos 2
        panelModificarPrestamos2=new JPanel();
        panelModificarPrestamos2.setBackground(Color.ORANGE);
        panelModificarPrestamos2.setBounds(10, 10, 340, 310);
        panelModificarPrestamos2.setLayout(null);
        
        //caracteristicas del panel eliminar prestamos
        PanelEliminarPrestamos=new JPanel();
        PanelEliminarPrestamos.setBackground(Color.ORANGE);
        PanelEliminarPrestamos.setBounds(10, 10, 950, 500);
        PanelEliminarPrestamos.setLayout(null);
       
       //componentes que contiene cada panel
       InterfazGrafica.panelCrearPrestamos();
       InterfazGrafica.panelAsignarPrestamo();
       InterfazGrafica.panelVerPrestamos();
       InterfazGrafica.panelModificarPrestamos();
       InterfazGrafica.panelmodificarPrestamo2();
       InterfazGrafica.panelEliminarPrestamos();
       
       //se agregan los panales a mi ventana (JFrame)
       add(panelCrearPrestamos);
       add(panelAsignarPrestamo);
       add(panelVerPrestamos);
       add(panelModificarPrestamos);
       add(panelModificarPrestamos2);
       add(PanelEliminarPrestamos);
       
       //accion de botones de crear prestamo
       hacerPrestamo.addActionListener(this);
       regresarDeHacerPrestamo.addActionListener(this);
       filtro2.addKeyListener(this);
       
       //accion de botones de asignar prestamo
       asignarPrestamoUsuario.addActionListener(this);
       cancelarAsignarPrestamoUsuario.addActionListener(this);
       
       //accion de botones ver prestamos
       regresarDeVerPrestamos.addActionListener(this);
       
       //accion de botones modificar prestamos
       ModificarPrestamo.addActionListener(this);
       regresarDeModificarPrestamo.addActionListener(this);
       
       //accion de botones modificar prestamos 2;
       ModiPrestamo2.addActionListener(this);
       regresarDeModiPrestamo2.addActionListener(this);
               
       //accion de botones eliminar prestamos
       EliminarPrestamo.addActionListener(this);
       regresarDeEliminarPrestamo.addActionListener(this);
       
     ////////////////////////////////////////////////////////////////INTEFAZ USUARIO/////////////////////////////////////////////////////////////////////
       
        //caracteristicas del panel interfaz usuario
        panelInterfazUsuario=new JPanel();
        panelInterfazUsuario.setBackground(Color.LIGHT_GRAY);
        panelInterfazUsuario.setBounds(10, 10, 1220, 700);
        panelInterfazUsuario.setLayout(null);
        
        //componentes que contiene cada panel
       InterfazGrafica.panelInterfazUsuario();
       
       //se agregan los panales a mi ventana (JFrame)
       add(panelInterfazUsuario);
       
       //acciones
       logoutUsuario.addActionListener(this);
       BibliotecaVirtual.addActionListener(this);
       tabla9.addMouseListener(this);
       filtro3.addKeyListener(this);
       
        //////////////////////////////////////////////////////////////USUARIO 1/////////////////////////////////////////////////////////////////////////////

        panelUsuario1=new JPanel();
        panelUsuario1.setBackground(Color.LIGHT_GRAY);
        panelUsuario1.setBounds(10, 10, 1220, 775);
        panelUsuario1.setLayout(null);
        
        //componentes que contiene cada panel
       InterfazGrafica.panelUsuario1();
               
       //se agregan los panales a mi ventana (JFrame)
       add(panelUsuario1);
       
       //acciones
       reportePrestamos1.addActionListener(this);
       devolucionLibros1.addActionListener(this);        
       regresarDeUsuario1.addActionListener(this);
       filtro4.addKeyListener(this);
       
       
  //////////////////////////////////////////////////////////////REPORTE USUARIO 1/////////////////////////////////////////////////////////////////////////////
   
        panelReporteUsuario1=new JPanel();
        panelReporteUsuario1.setBackground(Color.LIGHT_GRAY);
        panelReporteUsuario1.setBounds(10, 10, 875, 650);
        panelReporteUsuario1.setLayout(null);
        
        //componentes que contiene el panel
        InterfazGrafica.panelReporteUsuario1();
       
        //se agregan los panales a mi ventana
        add(panelReporteUsuario1);
        
        //acciones
        regresarReporteUsuario1.addActionListener(this);
        
        //////////////////////////////////////////////////////////////USUARIO 2/////////////////////////////////////////////////////////////////////////////

        panelUsuario2=new JPanel();
        panelUsuario2.setBackground(Color.YELLOW);
        panelUsuario2.setBounds(10, 10, 1220, 775);
        panelUsuario2.setLayout(null);
        
        //componentes que contiene cada panel
       InterfazGrafica.panelUsuario2();
               
       //se agregan los panales a mi ventana (JFrame)
       add(panelUsuario2);
       
       //acciones
       reportePrestamos2.addActionListener(this);
       devolucionLibros2.addActionListener(this);        
       regresarDeUsuario2.addActionListener(this);
       filtro5.addKeyListener(this);
       
       //////////////////////////////////////////////////////////////REPORTE USUARIO 2/////////////////////////////////////////////////////////////////////////////
   
        panelReporteUsuario2=new JPanel();
        panelReporteUsuario2.setBackground(Color.YELLOW);
        panelReporteUsuario2.setBounds(10, 10, 875, 650);
        panelReporteUsuario2.setLayout(null);
        
        //componentes que contiene el panel
        InterfazGrafica.panelReporteUsuario2();
       
        //se agregan los panales a la ventana
        add(panelReporteUsuario2);
       
        //acciones
        regresarReporteUsuario2.addActionListener(this);
       
        
        //////////////////////////////////////////////////////////////USUARIO 3/////////////////////////////////////////////////////////////////////////////

        panelUsuario3=new JPanel();
        panelUsuario3.setBackground(Color.green);
        panelUsuario3.setBounds(10, 10, 1220, 775);
        panelUsuario3.setLayout(null);
        
        //componentes que contiene cada panel
       InterfazGrafica.panelUsuario3();
               
       //se agregan los panales a mi ventana (JFrame)
       add(panelUsuario3);
       
       //acciones
       reportePrestamos3.addActionListener(this);
       devolucionLibros3.addActionListener(this);        
       regresarDeUsuario3.addActionListener(this);
       filtro6.addKeyListener(this);
       
       //////////////////////////////////////////////////////////////REPORTE USUARIO 3/////////////////////////////////////////////////////////////////////////////
   
        panelReporteUsuario3=new JPanel();
        panelReporteUsuario3.setBackground(Color.green);
        panelReporteUsuario3.setBounds(10, 10, 875, 650);
        panelReporteUsuario3.setLayout(null);
        
        //componentes que contiene el panel
        InterfazGrafica.panelReporteUsuario3();
       
        //se agregan los panales a la ventana
        add(panelReporteUsuario3);
       
        //acciones
        regresarReporteUsuario3.addActionListener(this);
       
       
    }
    
    
    
        //evento de las acciones de los botones
        public void actionPerformed(ActionEvent evento){
        
        //////////////////////////////////////////////////////////INTERFAZ PRINCIPAL Y LOGIN///////////////////////////////////////////////////////////
        if(evento.getSource()==bttLogin){
    	 
            this.setSize(375,415); //Para que cambie tama;o de mi ventana
        this.setLocationRelativeTo(null);
            
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(true);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);

IdUsuarioLogin.setText("");
passLogin.setText("");

    	 }   
        
        //para cerrar cesion en interfaz principal
        if(evento.getSource()==bttAbout){
    	 
            System.exit(0);
        
    	 }  
        
        //para ya buscar el usuarios
        if(evento.getSource()==login){
    	 
           contadorGlobal=1; 
           filaGlobal=modelo.getRowCount(); //variable global es igual a las filas de nuestro modelo de tabla de usuarios
           columnaGlobal=modelo.getColumnCount(); //variable global es igual a las columndas de nuestro modelo de tabla de usuarios
             
             for (int k = 0; k < filaGlobal; k++) { //me recorre las filas del modelo de tabla
                 for (int u = 0; u < columnaGlobal; u++) { //me recorre las columnas del modelo de tabla
                     
                     if(modelo.getValueAt(k, u).equals(IdUsuarioLogin.getText())){ // si el elemento (k,u) es igual al texto que ingresamos(login)
                         posicionGlobal=contadorGlobal; //nos da la posicion del elemento
                         filaGlobal=k; //nos da la fila del elemento
                         columnaGlobal=u; //nos da la columna del elemento
                     }
                     contadorGlobal++;
                 }
              }
             
             
             if(posicionGlobal>=1&&tabla.getValueAt(filaGlobal, 5).equals(passLogin.getText())){//si encuentra el ID y la password son iguales ..
                
                
                 System.out.println(posicionGlobal);
                 System.out.println(filaGlobal);
                 System.out.println(columnaGlobal);
                 
                /* posicionGlobal=0;
                 filaGlobal=0;
                 columna2=0;*/
                 
                 this.setSize(1260, 700);
        this.setLocationRelativeTo(null);
            
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(true);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
                 
                    
             }else if (IdUsuarioLogin.getText().equals("admin")&&passLogin.getText().equals("admin")) {
     
             this.setSize(985, 560);
        this.setLocationRelativeTo(null);   
                
                panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
                
            }
             
             else{
                  JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO \nO PASSWORD INCORRECTA");
                 /* posicionGlobal=0;
                 filaGlobal=0;
                 columnaGlobal=0*/
                 
             } 
            
            
  
        
    	 } 
        
        //para regresar de cuando se busque usuarios
        if(evento.getSource()==RegresarLogin){
    	 
        this.setSize(985, 560);
        this.setLocationRelativeTo(null);
            
            panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(true);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 } 
        
            
            
        //////////////////////////////////////////////////////////ADMINISTRADOR Y USUARIOS///////////////////////////////////////////////////////////    
            
        
        //about que esta en panel administrador
            if(evento.getSource()==about){
    	
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(true);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 }
        
            //Para ir al panel de crear un usuario
            if(evento.getSource()==crearUs){
    	 
panel1.setVisible(false);
panel2.setVisible(true);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 }
         
            //para agregar un usuario (esta dentro del panel crear usuario)
         if(evento.getSource()==crearUsuario){
          
          boolean caracteres;// para detectar si tiene menos de 6 caracteres
          boolean iguales; // para detectar si password y confirmar password son iguales
          boolean mayuscula=false; // para detectar si la primera letra es mayuscula o no
          boolean comprobar=false; // detecta si carecteres y iguales son true
          boolean campoIDvacio=false;
          boolean campoNombrevacio=false;
          boolean campoApellidovacio=false;
          boolean campoUservacio=false;
          boolean campoPasswordvacio=false;
          boolean campoConfiPasswordvacio=false;
          boolean verificarSiestaID=false;
          
          
          String mayus=password.getText(); // para detectar si la primera letra es mayuscula
          
            // En este if se detecta si la password y confirmar password tiene menos de 6 caracteres
             if ((password.getText().length()<6)||(confiPassword.getText().length()<6)) { //si password o confirmar password es menor a 6 caracteres
                 JOptionPane.showMessageDialog(null, "PASSWORD CONTIENE MENOS DE 6 CARACTERES!"); //se ejecuta eso..
                 caracteres=false;
                }else{   //de lo contrario ..
                 caracteres=true;
             }
             
             // En este if se detecta si la password y confirmar password son iguales
            if (password.getText().equals(confiPassword.getText())) { //si password es igual a confirmar password
                 iguales=true; //se hace esto
             }else{ //de lo contrario..
                 JOptionPane.showMessageDialog(null, "LAS PASSWORD NO COINCIDEN!"); //pasa esto
                 iguales=false;
             }
            
            // if para password
           if (password.getText().length()==0) { //si password no contiene caracteres se hace:
                 
                 JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE PASSWORD");
                 campoPasswordvacio=false;
                 
              }else{ //un if dentro de un else, si el campo password no esta vacio(lo que se hizo arriba) se hace:
                 campoPasswordvacio=true;
                 
                    // en este if se detecta si lo ingresado en password tiene la primera letra mayuscula
                    if(Character.isUpperCase(mayus.charAt(0))){ // mayus es igual al JTextField de password
                     
                    mayuscula=true;
                             }else{
                    JOptionPane.showMessageDialog(null, "LA PRIMERA LETRA DE SU PASSWORD ESTA EN MINUSCULA");
                 }
             }
          
           // En este if, se creo una variable "comprobar" que sera true solo si "caracteres" y "igual" son true
           // eso quiere decir que si password y confirmar password tienen 6 caracteres como minimo y que si son iguales
             if ((caracteres==true)&&(iguales==true)) {
                 
                 comprobar=true;
              
             }
             
             //verificar si campo ID esta vacio
             if (ID.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO ID ESTA VACIO");
                 campoIDvacio=false;
              }else{
                 campoIDvacio=true;
             }
             
             //verificar si campo nombre esta vacio
             if (nombre.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO NOMBRE ESTA VACIO");
                 campoNombrevacio=false;
              }else{
                 campoNombrevacio=true;
             }
             
             //verificar si campo apellido esta vacio
             if (apellido.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO APELLIDO ESTA VACIO");
                 campoApellidovacio=false;
              }else{
                 campoApellidovacio=true;
             }
             
             //verificar si campo user esta vacio
             if (user.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO USER ESTA VACIO");
                 campoUservacio=false;
              }else{
                 campoUservacio=true;
             }
             
             //verificar si campo confirmar password esta vacio
             if (confiPassword.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO CONFIRMAR PASSWORD ESTA VACIO");
                 campoConfiPasswordvacio=false;
              }else{
                 campoConfiPasswordvacio=true;
             }
             
            //////////////////////////////////////////////////////////////////////////////////////////
           
             contadorID=1; 
             fila2=modelo.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
             columna2=modelo.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla
             
             for (int k = 0; k < fila2; k++) { //me recorre las filas del modelo de tabla
                 for (int u = 0; u < columna2; u++) { //me recorre las columnas del modelo de tabla
                     
                     if(modelo.getValueAt(k, u).equals(ID.getText())){ // si el elemento (k,u) es igual al texto que ingresamos(para buscar usuario a modificar)
                         posicion2=contadorID; //nos da la posicion del elemento
                         fila2=k; //nos da la fila del elemento
                         columna2=u; //nos da la columna del elemento
                     }
                     contadorID++;
                 }
              }
             
             if(posicion2>=1){  //>=1 porque el elemento puede estar en posicion 0
                 
                verificarSiestaID=true;
                 
                JOptionPane.showMessageDialog(null, "YA EXISTE UN USUARIO CON ESE ID!");
                
                 System.out.println(posicion2);
                 System.out.println(fila2);
                 System.out.println(columna2);
                 posicion2=0;
                 fila2=0;
                 columna2=0;
                 
                    
             }else{
                  verificarSiestaID=false;
                  posicion2=0;
                 fila2=0;
                 columna2=0;
                 
             }
              
             
           ////////////////////////////////////////////////////////////////////////////////////////// 
             

          // En este if, se agregara a la tabla si se cumple con todo lo anterior (minimo 6 caracteres, si son iguales, primera letra mayuscula, si no hay campos vacios)
             if ((comprobar==true)&&(mayuscula==true)&&(campoIDvacio==true)&&(campoNombrevacio==true)&&(campoApellidovacio==true)&&(campoUservacio==true)&&(campoPasswordvacio==true)&&(campoConfiPasswordvacio==true)&&(verificarSiestaID==false)) {
                 
                  String carga[]=new String[6];
        carga[0]=ID.getText();
        carga[1]=nombre.getText();
        carga[2]=apellido.getText();
        carga[3]=user.getText();
        carga[4]=rol.getSelectedItem().toString();
        carga[5]=password.getText();
        modelo.addRow(carga);  
        
        //para limpiar los campos de texto
        ID.setText("");
        nombre.setText("");
        apellido.setText("");
        user.setText("");
        password.setText("");
        confiPassword.setText("");
        
        JOptionPane.showMessageDialog(null, "USUARIO CREADO CON EXITO!");
      }
          
           
             
          
             
             
         }
         
         
         //regresar al menu (cuando se este creando un usuario)
         if(evento.getSource()==regresarDeCrearUsuarioMenu){
    	 
panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);

    	 }
         
         
         //ver la tabla de usuarios
         if(evento.getSource()==verUs){
    	
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(true);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
       
    	 }
         
         //regresar de la tabla de usuarios al menu
         if(evento.getSource()==regresarDeTablaMenu){
    	
panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 }
         
         //panel para buscar usuario a eliminar
         if(evento.getSource()==elimUs){
    	
        this.setSize(375,365); //Para que cambie tama;o de mi ventana
        this.setLocationRelativeTo(null); //para que me centre mi ventana
             
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(true);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 }
         
         //panel para buscar usuario a modificar 
         if(evento.getSource()==modiUs){
        
        this.setSize(375,365); //Para que cambie tama;o de mi ventana
        this.setLocationRelativeTo(null); //para que me centre mi ventana
        
        txtbuscarModificarUsuario.setText("");//para limpiar ese campo
        
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(true);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
             
             
        
    	 }
         
         //boton para buscar usuario a modificar
         if(evento.getSource()==bttbuscarModificarUsuario){
             
             //Ya hechas las veriables globales se le asigna lo siguiente:
             contador1=1; 
             fila1=modelo.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
             columna1=modelo.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla
             
             for (int k = 0; k < fila1; k++) { //me recorre las filas del modelo de tabla
                 for (int u = 0; u < columna1; u++) { //me recorre las columnas del modelo de tabla
                     
                     if(modelo.getValueAt(k, u).equals(txtbuscarModificarUsuario.getText())){ // si el elemento (k,u) es igual al texto que ingresamos(para buscar usuario a modificar)
                         posicion1=contador1; //nos da la posicion del elemento
                         fila1=k; //nos da la fila del elemento
                         columna1=u; //nos da la columna del elemento
                     }
                     contador1++;
                 }
              }
             
             
             
             if(posicion1>=1){  //>=1 porque el elemento puede estar en posicion 0
                 
                 //redimensionar el tama;o de la ventana
                 this.setSize(985, 560);
                 this.setLocationRelativeTo(null);
                 
                 System.out.println(posicion1);
                 System.out.println(fila1);
                 System.out.println(columna1);
                 
                 String ModiID=(String)tabla.getValueAt(fila1, columna1); //Se guarda el ID en una variable para luego mandarlo al JTextField
                 String ModiNomb=(String)tabla.getValueAt(fila1, columna1+1); //Se guarda el nombre en una variable para luego mandarlo al JTextField
                 String ModiApel=(String)tabla.getValueAt(fila1, columna1+2); //Se guarda el apellido en una variable para luego mandarlo al JTextField
                 String ModiUser=(String)tabla.getValueAt(fila1, columna1+3); //Se guarda el user en una variable para luego mandarlo al JTextField
                 String ModiRo=(String)tabla.getValueAt(fila1, columna1+4); //Se guarda el rol en una variable para luego mandarlo al JTextField
                 String ModiPas=(String)tabla.getValueAt(fila1, columna1+5); //Se guarda el password en una variable para luego mandarlo al JTextField
                 
                 ModificarUsuarioID.setText(ModiID); //envia el dato a JTextField(ID) en panel para modificar usuario
                 ModificarUsuarionombre.setText(ModiNomb); //envia el dato a JTextField(nombre) en panel para modificar usuario
                 ModificarUsuarioapellido.setText(ModiApel); //envia el dato a JTextField(apellido) en panel para modificar usuario
                 ModificarUsuariouser.setText(ModiUser); //envia el dato a JTextField(User) en panel para modificar usuario
                 ModificarUsuariorol.setSelectedItem(ModiRo); //envia el dato a JComboBox(rol) en panel para modificar usuario
                 ModificarUsuariopassword.setText(ModiPas); //envia el dato a JTextField(password) en panel para modificar usuario
                 ModificarUsuarioConfipassword.setText(ModiPas); //envia el dato a JTextField(confirmar password) en panel para modificar usuario

                 modelo.setValueAt("", fila1, columna1); //para que al momento de identificar me elimine el elemento 
                 
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(true);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
                  
                  
                    
             }else{
                 JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO!");
                 posicion1=0;
                 fila1=0;
                 columna1=0;
                         
             }
              
             txtbuscarModificarUsuario.setText(""); //para limpiar campo usuario a modificar
             
         }
           
         
         //boton para regresar al menu principal cuando se este buscando usuario a modificar
         if(evento.getSource()==bttregresarbuscarModificarusuario){
            
        this.setSize(985, 560);
        this.setLocationRelativeTo(null);
        
panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
         
        
    	 }
         
         //Boton para Modificar usuario (dentro de panel)
         if(evento.getSource()==bttModificarUsuario){
           
             boolean caracteres;// para detectar si tiene menos de 6 caracteres
          boolean iguales; // para detectar si password y confirmar password son iguales
          boolean mayuscula=false; // para detectar si la primera letra es mayuscula o no
          boolean comprobar=false; // detecta si carecteres y iguales son true
          boolean campoIDvacio=false;
          boolean campoNombrevacio=false;
          boolean campoApellidovacio=false;
          boolean campoUservacio=false;
          boolean campoPasswordvacio=false;
          boolean campoConfiPasswordvacio=false;
          boolean verificarSiestaID=false;
          
          int cont3=0;
          int pos3=0,fil3=0,col3=0;
          
          String mayus=ModificarUsuariopassword.getText(); // para detectar si la primera letra es mayuscula
          
            // En este if se detecta si la password y confirmar password tiene menos de 6 caracteres
             if ((ModificarUsuariopassword.getText().length()<6)||(ModificarUsuarioConfipassword.getText().length()<6)) { //si password o confirmar password es menor a 6 caracteres
                 JOptionPane.showMessageDialog(null, "PASSWORD CONTIENE MENOS DE 6 CARACTERES!"); //se ejecuta eso..
                 caracteres=false;
                }else{   //de lo contrario ..
                 caracteres=true;
             }
             
             // En este if se detecta si la password y confirmar password son iguales
            if (ModificarUsuariopassword.getText().equals(ModificarUsuarioConfipassword.getText())) { //si password es igual a confirmar password
                 iguales=true; //se hace esto
             }else{ //de lo contrario..
                 JOptionPane.showMessageDialog(null, "LAS PASSWORD NO COINCIDEN!"); //pasa esto
                 iguales=false;
             }
            
            // if para password
           if (ModificarUsuariopassword.getText().length()==0) { //si password no contiene caracteres se hace:
                 
                 JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE PASSWORD");
                 campoPasswordvacio=false;
                 
              }else{ //un if dentro de un else, si el campo password no esta vacio(lo que se hizo arriba) se hace:
                 campoPasswordvacio=true;
                 
                    // en este if se detecta si lo ingresado en password tiene la primera letra mayuscula
                    if(Character.isUpperCase(mayus.charAt(0))){ // mayus es igual al JTextField de password
                     
                    mayuscula=true;
                             }else{
                    JOptionPane.showMessageDialog(null, "LA PRIMERA LETRA DE SU PASSWORD ESTA EN MINUSCULA");
                 }
             }
          
           // En este if, se creo una variable "comprobar" que sera true solo si "caracteres" y "igual" son true
           // eso quiere decir que si password y confirmar password tienen 6 caracteres como minimo y que si son iguales
             if ((caracteres==true)&&(iguales==true)) {
                 
                 comprobar=true;
              
             }
             
             //verificar si campo ID esta vacio
             if (ModificarUsuarioID.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO ID ESTA VACIO");
                 campoIDvacio=false;
              }else{
                 campoIDvacio=true;
             }
             
             //verificar si campo nombre esta vacio
             if (ModificarUsuarionombre.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO NOMBRE ESTA VACIO");
                 campoNombrevacio=false;
              }else{
                 campoNombrevacio=true;
             }
             
             //verificar si campo apellido esta vacio
             if (ModificarUsuarioapellido.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO APELLIDO ESTA VACIO");
                 campoApellidovacio=false;
              }else{
                 campoApellidovacio=true;
             }
             
             //verificar si campo user esta vacio
             if (ModificarUsuariouser.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO USER ESTA VACIO");
                 campoUservacio=false;
              }else{
                 campoUservacio=true;
             }
             
             //verificar si campo confirmar password esta vacio
             if (ModificarUsuarioConfipassword.getText().length()==0) {
                 
                 JOptionPane.showMessageDialog(null, "EL CAMPO CONFIRMAR PASSWORD ESTA VACIO");
                 campoConfiPasswordvacio=false;
              }else{
                 campoConfiPasswordvacio=true;
             }
             
            //////////////////////////////////////////////////////////////////////////////////////////
           
             contadorMU=1; 
             filaMU=modelo.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
             columnaMU=modelo.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla
             
             for (int k = 0; k < filaMU; k++) { //me recorre las filas del modelo de tabla
                 for (int u = 0; u < columnaMU; u++) { //me recorre las columnas del modelo de tabla
                     
                     if(modelo.getValueAt(k, u).equals(ModificarUsuarioID.getText())){ // si el elemento (k,u) es igual al texto que ingresamos(para buscar usuario a modificar)
                         posicionMU=contadorMU; //nos da la posicion del elemento
                         filaMU=k; //nos da la fila del elemento
                         columnaMU=u; //nos da la columna del elemento
                     }
                     contadorMU++;
                 }
              }
             
             if(posicionMU>=1){  //>=1 porque el elemento puede estar en posicion 0
                 
                verificarSiestaID=true;
                 
                JOptionPane.showMessageDialog(null, "YA EXISTE UN USUARIO CON ESE ID!");
                
                 System.out.println(posicion2);
                 System.out.println(fila2);
                 System.out.println(columna2);
                 posicionMU=0;
                 filaMU=0;
                 columnaMU=0;
                 
                    
             }else{
                  verificarSiestaID=false;
                  posicionMU=0;
                 filaMU=0;
                 columnaMU=0;
                 
             }
              
             
           ////////////////////////////////////////////////////////////////////////////////////////// 
             

          // En este if, se agregara a la tabla si se cumple con todo lo anterior (minimo 6 caracteres, si son iguales, primera letra mayuscula, si no hay campos vacios)
         if ((comprobar==true)&&(mayuscula==true)&&(campoIDvacio==true)&&(campoNombrevacio==true)&&(campoApellidovacio==true)&&(campoUservacio==true)&&(campoPasswordvacio==true)&&(campoConfiPasswordvacio==true)&&(verificarSiestaID==false)) {
        
                         //ESTOS IF SON PARA QUE ME MODIFIQUE EL NOMBRE EN PRESTAMOS
             
                            //para el Usuario 1
                             if(fila1==0){
                                
                                cont3=1; 
                                fil3=tabla6.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                
                                 for (int k = 0; k < fil3; k++) { //me recorre las filas del modelo de tabla
                                   
                                if(tabla6.getValueAt(k, 3).equals(tabla.getValueAt(0, 1))){ // si el elemento (k,u) es igual al elemento de la tabla
                                           
                                         tabla6.setValueAt(ModificarUsuarionombre.getText(), k, 3);
                                            
                                        }
                                }
                          }//fin if ==1 (Usuario1)

                        //para el Usuario 2
                             if(fila1==1){
                                
                                cont3=1; 
                                fil3=tabla6.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                
                                 for (int k = 0; k < fil3; k++) { //me recorre las filas del modelo de tabla
                                   
                                if(tabla6.getValueAt(k, 3).equals(tabla.getValueAt(1, 1))){ // si el elemento (k,u) es igual al elemento de la tabla
                                           
                                         tabla6.setValueAt(ModificarUsuarionombre.getText(), k, 3);
                                            
                                        }
                                }
                          }//fin if ==1 (Usuario2)
                             
                             //para el Usuario 3
                             if(fila1==2){
                                
                                cont3=1; 
                                fil3=tabla6.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                
                                 for (int k = 0; k < fil3; k++) { //me recorre las filas del modelo de tabla
                                   
                                if(tabla6.getValueAt(k, 3).equals(tabla.getValueAt(2, 1))){ // si el elemento (k,u) es igual al elemento de la tabla
                                           
                                         tabla6.setValueAt(ModificarUsuarionombre.getText(), k, 3);
                                            
                                        }
                                }
                          }//fin if ==1 (Usuario3)
             
        tabla.setValueAt(ModificarUsuarioID.getText(), fila1, 0);
        tabla.setValueAt(ModificarUsuarionombre.getText(), fila1, 1);
        tabla.setValueAt(ModificarUsuarioapellido.getText(), fila1, 2);
        tabla.setValueAt(ModificarUsuariouser.getText(), fila1, 3);
        tabla.setValueAt(ModificarUsuariorol.getSelectedItem().toString(), fila1, 4);
        tabla.setValueAt(ModificarUsuariopassword.getText(), fila1, 5);
       
         
        ModificarUsuarionombre.setText("");
        ModificarUsuarioapellido.setText("");
        ModificarUsuariouser.setText("");
        ModificarUsuariopassword.setText("");
        ModificarUsuarioConfipassword.setText("");
        
        JOptionPane.showMessageDialog(null, "USUARIO MODIFICADO CON EXITO!");
      }
            
        
        
    	 }
         
         //Boton para cancelar modificar usuario
         if(evento.getSource()==bttModificarcancelar){
          
        modelo.setValueAt(ModificarUsuarioID.getText(), fila1, columna1); 
        
        ModificarUsuarionombre.setText("");
        ModificarUsuarioapellido.setText("");
        ModificarUsuariouser.setText("");
        ModificarUsuariopassword.setText("");
        ModificarUsuarioConfipassword.setText("");
         
        
    	 }
         
         //Boton para regresar a menu principal, cuando se modifique usuario
         if(evento.getSource()==bttModificarUsuarioAPrincipal){
        
         modelo.setValueAt(ModificarUsuarioID.getText(), fila1, columna1); 
        
        posicion1=0;
        fila1=0;
        columna1=0;
        
panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
         
        
    	 }
         
         //boton buscar, para eliminar usuarios
         if(evento.getSource()==bttbuscarEliminarUsuario){
             
             //Ya hechas las veriables globales se le asigna lo siguiente:
             contador=1; 
             fila=modelo.getRowCount(); //variable fila es igual a las filas de nuestro modelo de tabla
             columna=modelo.getColumnCount(); //variable columna es igual a las columndas de nuestro modelo de tabla
             
             for (int k = 0; k < fila; k++) { //me recorre las filas del modelo de tabla
                 for (int u = 0; u < columna; u++) { //me recorre las columnas del modelo de tabla
                     
                     if(modelo.getValueAt(k, u).equals(txtbuscarEliminarUsuario.getText())){ // si el elemento (k,u) es igual al texto que ingresamos(para buscar usuario a eliminar)
                         posicion=contador; //nos da la posicion del elemento
                         fila=k; //nos da la fila del elemento
                         columna=u; //nos da la columna del elemento
                     }
                     contador++;
                 }
              }
             
             
             
             if(posicion>=1){  //>=1 porque el elemento puede estar en posicion 0
                 
                 //redimensionar el tama;o de la ventana
                 this.setSize(985, 560);
                 this.setLocationRelativeTo(null);
                 
                 System.out.println(posicion);
                 System.out.println(fila);
                 System.out.println(columna);
                 
                 String ElimID=(String)tabla.getValueAt(fila, columna); //Se guarda el ID en una variable para luego mandarlo al JTextField
                 String ElimNomb=(String)tabla.getValueAt(fila, columna+1); //Se guarda el nombre en una variable para luego mandarlo al JTextField
                 String ElimApel=(String)tabla.getValueAt(fila, columna+2); //Se guarda el apellido en una variable para luego mandarlo al JTextField
                 String ElimUser=(String)tabla.getValueAt(fila, columna+3); //Se guarda el user en una variable para luego mandarlo al JTextField
                 String ElimRo=(String)tabla.getValueAt(fila, columna+4); //Se guarda el rol en una variable para luego mandarlo al JTextField
                 String ElimPas=(String)tabla.getValueAt(fila, columna+5); //Se guarda el password en una variable para luego mandarlo al JTextField
                 
                 EliminarUsuarioID.setText(ElimID); //envia el dato a JTextField(ID) en panel para eliminar usuario
                 EliminarUsuarionombre.setText(ElimNomb); //envia el dato a JTextField(nombre) en panel para eliminar usuario
                 EliminarUsuarioapellido.setText(ElimApel); //envia el dato a JTextField(apellido) en panel para eliminar usuario
                 EliminarUsuariouser.setText(ElimUser); //envia el dato a JTextField(User) en panel para eliminar usuario
                 EliminarUsuariorol.setText(ElimRo); //envia el dato a JTextField(rol) en panel para eliminar usuario
                 EliminarUsuariopassword.setText(ElimPas); //envia el dato a JTextField(password) en panel para eliminar usuario
                 
                panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(true);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
                  
                  posicion=0;
                  fila=0;
                  columna=0;
                    
             }else{
                 JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO!");
                 posicion=0;
                  fila=0;
                  columna=0;
             }
             
             txtbuscarEliminarUsuario.setText(""); //Para limpiar el campo para buscar usuario a eliminar
    	
         
    	 }
         
         //Para que me regrese al menu principal, cuando se este en el panel para buscar usuario a eliminar
         if(evento.getSource()==bttregresarbuscareliminarusuario){
    	
        this.setSize(985, 560);
        this.setLocationRelativeTo(null);
        
    panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
        txtbuscarEliminarUsuario.setText(""); //limpiar campo para buscar usuario a eliminar
        
    	 }
         
         //boton para eliminar un usuario
         if(evento.getSource()==bttEliminarUsuario){
    	
            
        modelo.removeRow(fila);//para remover la fila seleccionada
             
             
        EliminarUsuarioID.setText("");
        EliminarUsuarionombre.setText("");
        EliminarUsuarioapellido.setText("");
        EliminarUsuariouser.setText("");
        EliminarUsuariorol.setText("");
        EliminarUsuariopassword.setText("");
        
        JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE","ELIMINAR USUARIO",JOptionPane.WARNING_MESSAGE);
        
    	 }
         
         //boton para regresar a menu principal, cuando se elimine un usuario
         if(evento.getSource()==bttEliminarUsuarioAPrincipal){
    	
       panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
        
    	 }
       
         
         //boton para cancelar eliminar el usuario
         if(evento.getSource()==bttcancelar){
        
        EliminarUsuarioID.setText("");
        EliminarUsuarionombre.setText("");
        EliminarUsuarioapellido.setText("");
        EliminarUsuariouser.setText("");
        EliminarUsuariorol.setText("");
        EliminarUsuariopassword.setText("");
        
    	 }
         
     /////////////////////////////////////////////////////////////////BIBLIOGRAFIAS//////////////////////////////////////////////////////////////////     
         
         //opcion si es carga individual o masiva
         if(evento.getSource()==crearBib){
        
        this.setSize(590,285);
        this.setLocationRelativeTo(null);
        
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(true);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
             
    	 }
         
         // boton que muestra panel carga individual
         if(evento.getSource()==bttCargaIndividual){
        
        this.setSize(985, 735);
        this.setLocationRelativeTo(null);
        
   panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(true);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
          
    	 }
         
         //boton que muestra panel carga masiva
         if(evento.getSource()==bttCargaMasiva){
         
        this.setSize(985, 560);
        this.setLocationRelativeTo(null);      
             
   panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(true);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
          
    	 }
         
         //boton para regresar a menu (cuando se este en opcion de carga individual o masiva)
         if(evento.getSource()==bttRegresarDeCrearBibliografia){
            
        this.setSize(985, 560);
        this.setLocationRelativeTo(null); 
        
  panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
          
    	 }
         
         //boton para guardar la bibliografia de carga individual
         if(evento.getSource()==bttcrearBibliografiaIndividual){
          
           obtenerItem2=rolBibliografia.getSelectedItem().toString();
           
             if (obtenerItem2.equals("Libro")) {
                String libroo="0"; 
                String vacio="----";
                 String cargaLibro[]=new String[12];
        cargaLibro[0]=libroo;
        cargaLibro[1]=autor.getText();
        cargaLibro[2]=titulo.getText();
        cargaLibro[3]=edicion.getText();
        cargaLibro[4]=descripcion.getText();
        cargaLibro[5]=vacio;
        cargaLibro[6]=vacio;
        cargaLibro[7]=temas.getText();
        cargaLibro[8]=palabrasClave.getText();
        cargaLibro[9]=vacio;
        cargaLibro[10]=copias.getText();
        cargaLibro[11]=disponibles.getText();
        modelo2.addRow(cargaLibro);
        
        // para cargar datos en interfaz usuario (con boton)
        Usuarios.modelo4.addRow(new Object[]{libroo,autor.getText(),titulo.getText(),edicion.getText(),descripcion.getText(),vacio,vacio,temas.getText(),palabrasClave.getText(),vacio,copias.getText(),disponibles.getText(),btn1});
        
        JOptionPane.showMessageDialog(null, "Bibliografia tipo LIBRO creada con exito!");
        
        autor.setEnabled(false);
        titulo.setEnabled(false);
        edicion.setEnabled(false);
        descripcion.setEnabled(false);
        frecuencia.setEnabled(false);
        ejemplares.setEnabled(false);
        temas.setEnabled(false);
        palabrasClave.setEnabled(false);
        area.setEnabled(false);
        copias.setEnabled(false);
        disponibles.setEnabled(false);
        
        autor.setText("");
        titulo.setText("");
        edicion.setText("");
        descripcion.setText("");
        frecuencia.setText("");
        ejemplares.setText("");
        temas.setText("");
        palabrasClave.setText("");
        copias.setText("");
        disponibles.setText("");
        area.setText("");
        
                 
         }
             if (obtenerItem2.equals("Revista")) {
                String revista="1"; 
                String vacio="----";
                 String cargaRevista[]=new String[12];
        cargaRevista[0]=revista;
        cargaRevista[1]=autor.getText();
        cargaRevista[2]=titulo.getText();
        cargaRevista[3]=edicion.getText();
        cargaRevista[4]=descripcion.getText();
        cargaRevista[5]=frecuencia.getText();
        cargaRevista[6]=ejemplares.getText();
        cargaRevista[7]=temas.getText();
        cargaRevista[8]=palabrasClave.getText();
        cargaRevista[9]=vacio;
        cargaRevista[10]=copias.getText();
        cargaRevista[11]=disponibles.getText();
        modelo2.addRow(cargaRevista); 
        
        // para cargar datos en interfaz usuario (con boton)
        Usuarios.modelo4.addRow(new Object[]{revista,autor.getText(),titulo.getText(),edicion.getText(),descripcion.getText(),frecuencia.getText(),ejemplares.getText(),temas.getText(),palabrasClave.getText(),vacio,copias.getText(),disponibles.getText(),btn1});
         
        
        JOptionPane.showMessageDialog(null, "Bibliografia tipo REVISTA creada con exito!");
        
        autor.setEnabled(false);
        titulo.setEnabled(false);
        edicion.setEnabled(false);
        descripcion.setEnabled(false);
        frecuencia.setEnabled(false);
        ejemplares.setEnabled(false);
        temas.setEnabled(false);
        palabrasClave.setEnabled(false);
        area.setEnabled(false);
        copias.setEnabled(false);
        disponibles.setEnabled(false);
        
        autor.setText("");
        titulo.setText("");
        edicion.setText("");
        descripcion.setText("");
        frecuencia.setText("");
        ejemplares.setText("");
        temas.setText("");
        palabrasClave.setText("");
        copias.setText("");
        disponibles.setText("");
        area.setText("");
        
        
             }
             
             if (obtenerItem2.equals("Tesis")) {
                String tesis="2"; 
                String vacio="----";
                 String cargaRevista[]=new String[12];
        cargaRevista[0]=tesis;
        cargaRevista[1]=autor.getText();
        cargaRevista[2]=titulo.getText();
        cargaRevista[3]=edicion.getText();
        cargaRevista[4]=descripcion.getText();
        cargaRevista[5]=vacio;
        cargaRevista[6]=vacio;
        cargaRevista[7]=temas.getText();
        cargaRevista[8]=palabrasClave.getText();
        cargaRevista[9]=area.getText();
        cargaRevista[10]=copias.getText();
        cargaRevista[11]=disponibles.getText();
        modelo2.addRow(cargaRevista);  
        
        // para cargar datos en interfaz usuario (con boton)
        Usuarios.modelo4.addRow(new Object[]{tesis,autor.getText(),titulo.getText(),edicion.getText(),descripcion.getText(),vacio,vacio,temas.getText(),palabrasClave.getText(),area.getText(),copias.getText(),disponibles.getText(),btn1});
         
         
        JOptionPane.showMessageDialog(null, "Bibliografia tipo TESIS creada con exito!");
        
        autor.setEnabled(false);
        titulo.setEnabled(false);
        edicion.setEnabled(false);
        descripcion.setEnabled(false);
        frecuencia.setEnabled(false);
        ejemplares.setEnabled(false);
        temas.setEnabled(false);
        palabrasClave.setEnabled(false);
        area.setEnabled(false);
        copias.setEnabled(false);
        disponibles.setEnabled(false);
        
        autor.setText("");
        titulo.setText("");
        edicion.setText("");
        descripcion.setText("");
        frecuencia.setText("");
        ejemplares.setText("");
        temas.setText("");
        palabrasClave.setText("");
        copias.setText("");
        disponibles.setText("");
        area.setText("");
        
                 
             }
             
             
             
          
    	 }
         
         //boton para cancelar  carga individual
         if(evento.getSource()==bttcancelarBibliografiaIndividual){
          
             autor.setEnabled(false);
        titulo.setEnabled(false);
        edicion.setEnabled(false);
        descripcion.setEnabled(false);
        frecuencia.setEnabled(false);
        ejemplares.setEnabled(false);
        temas.setEnabled(false);
        palabrasClave.setEnabled(false);
        area.setEnabled(false);
        copias.setEnabled(false);
        disponibles.setEnabled(false);
        
             autor.setText("");
             titulo.setText("");
             edicion.setText("");
             descripcion.setText("");
             frecuencia.setText("");
             ejemplares.setText("");
             temas.setText("");
             palabrasClave.setText("");
             copias.setText("");
             disponibles.setText("");
             area.setText("");
             
    	 }
         
         //boton para regresar a menu cuando se este en carga individual
         if(evento.getSource()==bttregresarDeCargaIndividual){
          
        this.setSize(985, 560);
        this.setLocationRelativeTo(null); 
        
       panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);

    	 }
         
         //boton para actualizar el rol
         if(evento.getSource()==bttcargar){
          
             obtenerItem=rolBibliografia.getSelectedItem().toString();
             
             if (obtenerItem.equals("Libro")) {
                 
                 autor.enable(true);
                 titulo.enable(true);
                 edicion.enable(true);
                 palabrasClave.enable(true);
                 temas.enable(true);
                 copias.enable(true);
                 disponibles.enable(true);
                 descripcion.enable(true);
                 frecuencia.enable(false);
                 ejemplares.enable(false);
                 area.enable(false);
                 
                 autor.setText("");
             titulo.setText("");
             edicion.setText("");
             descripcion.setText("");
             frecuencia.setText("");
             ejemplares.setText("");
             temas.setText("");
             palabrasClave.setText("");
             copias.setText("");
             disponibles.setText("");
             area.setText("");
                 
                 
                 frecuencia.setText("campo no valido");
                 ejemplares.setText("campo no valido");
                 area.setText("campo no valido");
                         
             }
             
             if (obtenerItem.equals("Revista")) {
                 
                 autor.enable(true);
                 titulo.enable(true);
                 edicion.enable(true);
                descripcion.enable(true);
                frecuencia.enable(true);
                ejemplares.enable(true);
                 palabrasClave.enable(true);
                 temas.enable(true);
                 copias.enable(true);
                 disponibles.enable(true);
                 area.enable(false);
                 
                 autor.setText("");
             titulo.setText("");
             edicion.setText("");
             descripcion.setText("");
             frecuencia.setText("");
             ejemplares.setText("");
             temas.setText("");
             palabrasClave.setText("");
             copias.setText("");
             disponibles.setText("");
             area.setText("");
                 
                 area.setText("campo no valido");
             }
             
             if (obtenerItem.equals("Tesis")) {
                 
                 autor.enable(true);
                 titulo.enable(true);
                 edicion.enable(true);
                 descripcion.enable(true);
                 palabrasClave.enable(true);
                 area.enable(true);
                 temas.enable(true);
                 copias.enable(true);
                 disponibles.enable(true);
                 frecuencia.enable(false);
                 ejemplares.enable(false);
                 
             autor.setText("");
             titulo.setText("");
             edicion.setText("");
             descripcion.setText("");
             frecuencia.setText("");
             ejemplares.setText("");
             temas.setText("");
             palabrasClave.setText("");
             copias.setText("");
             disponibles.setText("");
             area.setText("");
                 
                 frecuencia.setText("campo no valido");
                 ejemplares.setText("campo no valido");
                 
             }
        
    	 }
         
         //para cargar los datos de carga masiva
         if(evento.getSource()==bttcrearBibliografiaMasiva){
          
            
            cadenaArea = txtarea.getText(); //captura el dato guardado en txtarea
            //int posicion;
            
            if(cadenaArea.charAt(0)=='0'){
                metCargaMasiva.LibrosPrincipal();
            }
            if(cadenaArea.charAt(0)=='1'){
                metCargaMasiva.RevistasPrincipal();
         } 
            if (cadenaArea.charAt(0)=='2') {
                metCargaMasiva.TesisPrincipal();
              }
            
         }
         
         //para cancelar carga de masiva y limpia TextArea
         if(evento.getSource()==bttcancelarBibliografiaMasiva){
          
             txtarea.setText("");
          
    	 }
         
         //ir al menu cuando se este en carga masiva
         if(evento.getSource()==bttregresarDeCargaMasiva){
             
             this.setSize(985, 560);
        this.setLocationRelativeTo(null); 
        
    panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
          
          
    	 }
         
         //para ir al panel modificar bibliografia
         if(evento.getSource()==modiBib){
             
             this.setSize(985, 710);
            this.setLocationRelativeTo(null);
        
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(true);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);     
            
        }
         
         //para seleccionar la fila de tabla a modificar bibliografia
         if(evento.getSource()==modificarBibliografia){
             
             filaSelect=tabla3.getSelectedRow(); //me selecciona la fila a modificar
             
             
              if (filaSelect>0) { //si se selecciona una fila ...
                  
                  ModiTipo.setText(tabla3.getValueAt(filaSelect, 0).toString());
                  ModiPalabras.setText(tabla3.getValueAt(filaSelect, 8).toString());
                  ModiCopias.setText(tabla3.getValueAt(filaSelect, 10).toString());
                  ModiDescripcion.setText(tabla3.getValueAt(filaSelect, 4).toString());
                 
             }else{ //de lo contrario si no se selecciona una fila ...
                  JOptionPane.showMessageDialog(null, "Seleccione fila a modificar!");
              }
        }
         
         //para aceptar la modificacion de modificar bibliografia
         if(evento.getSource()==aceptarModificarBibliografia){
             
             int filaSelect2=tabla3.getSelectedRow(); //selecciona la fila a modificar
            
             if(filaSelect2>0){
             
           //envia el nuevo valor,a la fila seleccionada, columna que corresponda
           tabla2.setValueAt(ModiTipo.getText(), filaSelect2, 0);
           tabla2.setValueAt(ModiDescripcion.getText(), filaSelect2, 4);
           tabla2.setValueAt(ModiPalabras.getText(), filaSelect2, 8);
           tabla2.setValueAt(ModiCopias.getText(), filaSelect2, 10);
           
           tabla3.setValueAt(ModiTipo.getText(), filaSelect2, 0);
           tabla3.setValueAt(ModiDescripcion.getText(), filaSelect2, 4);
           tabla3.setValueAt(ModiPalabras.getText(), filaSelect2, 8);
           tabla3.setValueAt(ModiCopias.getText(), filaSelect2, 10);
           
           tabla4.setValueAt(ModiTipo.getText(), filaSelect2, 0);
           tabla4.setValueAt(ModiDescripcion.getText(), filaSelect2, 4);
           tabla4.setValueAt(ModiPalabras.getText(), filaSelect2, 8);
           tabla4.setValueAt(ModiCopias.getText(), filaSelect2, 10);
           
           tabla9.setValueAt(ModiTipo.getText(), filaSelect2, 0);
           tabla9.setValueAt(ModiDescripcion.getText(), filaSelect2, 4);
           tabla9.setValueAt(ModiPalabras.getText(), filaSelect2, 8);
           tabla9.setValueAt(ModiCopias.getText(), filaSelect2, 10);
           
           //esto es para que me cambien los valores en las tablas de prestamos
           int filasTabla6=tabla6.getRowCount();
           String tipbii=(String)tabla3.getValueAt(filaSelect2, 2);
                for (int i = 0; i < filasTabla6; i++) { //me recorre la tabla
                     
                    if(tabla6.getValueAt(i, 2).equals(tipbii)){ // si el elemento (k,u) es igual al elemento de la tabla
                                           
                      tabla6.setValueAt(ModiTipo.getText(), i, 0);
                      tabla6.setValueAt(ModiCopias.getText(), i, 4);
                                            
                                        }
                }
           
           JOptionPane.showMessageDialog(null, "Bibliografia Modificada con exito!");
           
           
             }else{
                 JOptionPane.showMessageDialog(null, "No ha modificado ninguna bibliografia!");
             }
        }
         
         //para cancelar la modificacion de bibliografia
         if(evento.getSource()==cancelarModificarBibliografia){
             
            ModiTipo.setText("");
            ModiPalabras.setText("");
            ModiCopias.setText("");
            ModiDescripcion.setText("");
        }
         
         //para ir al menu cuando se este modificando una bibliografia
         if(evento.getSource()==regresarDeModificarBibliografia){
             
              this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
 panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
            
        }
         
         //para ir al panel eliminar bibliografia
         if(evento.getSource()==elimBib){
             
            this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
             
     panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(true);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
        }
         
         //para eliminar una bibliografia
         if(evento.getSource()==eliminarBibliografia){
             
             int filaSeleccionada=tabla4.getSelectedRow();
             
             int connt=0;
             int fill=0,coll=0,poss=0;
            
             if (filaSeleccionada>-1) {
                 
                                String nombi=(String)tabla4.getValueAt(filaSeleccionada, 2);
                                
                                connt=0; 
                                fill=modelo3.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                coll=modelo3.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla
                                String ss="";
                                for (int k = 0; k < fill; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < coll; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo3.getValueAt(k, u).equals(nombi)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            
                                            //esto es para que no cuente como copia las devoluciones
                                            ss=(String)modelo3.getValueAt(k, 8);
                                            //System.out.println(ss);
                                            
                                            if (ss.equals("Devolucion")) {
                                                connt=connt-1;
                                            }
                                            connt++; //nos da la posicion del elemento
                                            //nos da la columna del elemento
                                        }
                                        

                                    }

                                 }
                 //System.out.println(connt);
                 
                 if (connt>=1) {
                     
                     JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR EL ELEMENTO SELECCIONADO \nTIENE: "+connt+" COPIAS PRESTADAS!");
                     
                 }else{
                     
                 modelo2.removeRow(filaSeleccionada);
                 modelo4.removeRow(filaSeleccionada);
                 
                 JOptionPane.showMessageDialog(null, "BIBLIOGRAFIA ELIMINADA CON EXITO!");
                 
                 }
                 
                 
             }else{
                 JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA A ELIMINAR!");
             }
            
        }
         
         //para regresar a menu cuando se elimine una bibliografia
         if(evento.getSource()==regresarDeEliminarBibliografia){
             
             this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
             
    panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
            
        }
        
         
         //para ir al panel ver bibliografia
         if(evento.getSource()==verBib){
             
             this.setSize(985, 560);
            this.setLocationRelativeTo(null);
            
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(true);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        }
         
         //se regresa al menu cuando se este viendo las bibliografias
         if(evento.getSource()==regresarDeVerBibliografia){
             
             this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
    panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        }
         
         
     //////////////////////////////////////////////////////////////PRESTAMOS/////////////////////////////////////////////////////////////////////////////

         //para ir al panel crear prestamo
         if(evento.getSource()==crearPres){
             
            this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
      panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(true);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
         
        }
         
         if(evento.getSource()==regresarDeHacerPrestamo){
             
            this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
   panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
         
        }
         
         //para ir al panel modificar prestamo
         if(evento.getSource()==modiPres){
             
            this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(true);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
         
        }
         
         if(evento.getSource()==ModificarPrestamo){
           
             filaSelectHacerPrestamo=tabla7.getSelectedRow();
            
            if(filaSelectHacerPrestamo>-1){ //el menos uno porque con el filtro no me lee la fila 0
                
                this.setSize(375,365); 
            this.setLocationRelativeTo(null);
            
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(true);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
        //aqui se cargan los nombres de usuarios al comboBox
        filaselectAsignarPrestamo=tabla2.getRowCount();
             
             for (int i = 0; i < filaselectAsignarPrestamo; i++) {
                 
                 NombresBibParaPrestamo=(String)tabla2.getValueAt(i, 2);
                 rolModiPrestamo.addItem(NombresBibParaPrestamo);
             }
          
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione la fila para modificar el prestamo!");
            }
             
            
        }
         
         if(evento.getSource()==regresarDeModificarPrestamo){
           
             this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
     panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
            
        }
         
         //para modificar (donde esta el combobox)
         if(evento.getSource()==ModiPrestamo2){
             
             int ffilaselectAsignarPrestamo=tabla7.getSelectedRow();
             String valorTipo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);//capturamos el tipo de bibliografia
             Integer valorTipoConver=Integer.parseInt(valorTipo);
             String modiPrest=rolModiPrestamo.getSelectedItem().toString();
             
             String nombreUs=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 3); //aqui capturamos el nombre del usuario que tiene el prestamo
             
             //para que nos busque el nombre del usuario de la fila seleccionada
                                contadorUs=1; 
                                filaUs=modelo.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaUs=modelo.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaUs; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaUs; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo.getValueAt(k, u).equals(nombreUs)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionUs=contadorUs; //nos da la posicion del elemento
                                            filaUs=k; //nos da la fila del elemento
                                            columnaUs=u; //nos da la columna del elemento
                                        }
                                        contadorUs++;

                                    }

                                 }
                           if(posicionUs>=1){
                               System.out.println(posicionUs);
                               System.out.println(filaUs);
                               System.out.println(columnaUs);
                           }
             
          //si la filaUs == 0 sera el usuario 1, ==1 sera el usuario 2, ==2 sera el usuario 3                 
            
           //PARA EL USUARIO 1
           if (filaUs==0) {
          
           if (valorTipoConver==0) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo5.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo5.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo5.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);
                                
                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo10.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});
                                     
                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if ==0
           
           if (valorTipoConver==1) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo6.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo6.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo6.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);

                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo10.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});


                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if == 1
             
           if (valorTipoConver==2) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo7.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo7.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo7.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);

                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo10.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});

                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if == 2
             
         }//CIERRE IF ==0 (USUARIO 1)     
          
           
            //PARA EL USUARIO 2
           if (filaUs==1) {
          
           if (valorTipoConver==0) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo12.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo12.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo12.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);
                                
                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo17.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});
                                     
                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if ==0
           
           if (valorTipoConver==1) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo13.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo13.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo13.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);

                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo17.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});


                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if == 1
             
           if (valorTipoConver==2) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo14.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo14.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo14.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);

                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo17.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});

                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if == 2
             
         }//CIERRE IF ==1 (USUARIO 2)           
           
           
           //PARA EL USUARIO 3
           if (filaUs==2) {
          
           if (valorTipoConver==0) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo19.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo19.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo19.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);
                                
                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo24.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});
                                     
                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if ==0
           
           if (valorTipoConver==1) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo20.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo20.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo20.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);

                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo24.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});


                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if == 1
             
           if (valorTipoConver==2) {
                 
                                contadorParaLibro0=1; 
                                filaParaLibros0=modelo21.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaLibros0=modelo21.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaLibros0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaLibros0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo21.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaLibros0=contadorParaLibro0; //nos da la posicion del elemento
                                            filaParaLibros0=k; //nos da la fila del elemento
                                            columnaParaLibros0=u; //nos da la columna del elemento
                                        }
                                        contadorParaLibro0++;

                                    }

                                 }
                                
                                //para que busque la bibliografia si tiene copias disponibles
                                contadorParaRevista0=0; 
                                filaParaRevista0=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaParaRevista0=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaParaRevista0; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaParaRevista0; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(modiPrest)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionParaRevista0=contadorParaRevista0; //nos da la posicion del elemento
                                            filaParaRevista0=k; //nos da la fila del elemento
                                            columnaParaRevista0=u; //nos da la columna del elemento
                                        }
                                        contadorParaRevista0++;

                                    }

                                 }
                                String dispoCopi=(String)tabla2.getValueAt(filaParaRevista0, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                //System.out.println(posicionParaRevista0);
                                //System.out.println(filaParaRevista0);
                                //System.out.println(columnaParaRevista0);
                                //System.out.println(conver);

                                if(posicionParaLibros0>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! \nO NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;

                                }else{
                                    
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                                     
                                    modelo3.setValueAt(rolModiPrestamo.getSelectedItem().toString(),ffilaselectAsignarPrestamo, 2);
                                     String tipoo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 0);
                                     String autorr=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 1);
                                     String tituloo=(String)tabla7.getValueAt(ffilaselectAsignarPrestamo, 2);
                                     
                                     modelo24.addRow(new Object[]{tipoo,autorr,tituloo,tabla.getValueAt(0, 1).toString(),dateFormat.format(date),hourFormat.format(date)});

                                    //para que me reinicie la busqueda
                                     posicionParaLibros0=0; 
                                    filaParaLibros0=0; 
                                    columnaParaLibros0=0;
                                    
                                    JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
                                    }
                 
             }//termina if == 2
             
         }//CIERRE IF ==2 (USUARIO 3)          
           
           
           //este es para que si se crea un usuario y no tiene perfil igual salga msj
           if (filaUs!=0&&filaUs!=1&&filaUs!=2) {
               JOptionPane.showMessageDialog(null, "PRESTAMO MODIFICADO SATISFACTORIO");
           }
           
           
           
           
           
         }
         
         //para regresar de modificar prestamo 2
         if(evento.getSource()==regresarDeModiPrestamo2){
          
             this.setSize(985, 560);
            this.setLocationRelativeTo(null);
            
      panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
        rolModiPrestamo.removeAllItems(); //me elimina los item del combobox
            
        }
         
         
         //para ir al panel eliminar prestamo
         if(evento.getSource()==elimPres){
             
            this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(true);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
         
        }
         
         //boton eliminar prestamo
         if(evento.getSource()==EliminarPrestamo){
             
             int filaSelectt=tabla8.getSelectedRow();                   
             int cont=0;
             int fil=0,col=0,pos=0;
             
             int cont2=0;
             int fil22=0,col2=0,pos2=0;
             
             if (filaSelectt>-1) {
                 
                              //esto es para que me busque el nombre de usuario de la fila seleccionada
                              String nombreUss=(String)tabla8.getValueAt(filaSelectt, 3);
             
                                contadorElimUs=1; 
                                filaElimUs=modelo.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaElimUs=modelo.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaElimUs; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaElimUs; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo.getValueAt(k, u).equals(nombreUss)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionElimUs=contadorElimUs; //nos da la posicion del elemento
                                            filaElimUs=k; //nos da la fila del elemento
                                            columnaElimUs=u; //nos da la columna del elemento
                                        }
                                        contadorElimUs++;

                                    }

                                 }
                         
             
            // si filaElimUs ==0 es usuario 1, ==1 es usuario 2, ==2 es usuario 2
                 
                       //PARA USUARIO 1         
                      if (filaElimUs==0) {
                          
               //buscamos el nombre de bibliografia en modelo 2 (bibliografias)
               String nomb=(String)tabla8.getValueAt(filaSelectt, 2);
                               
                                //esto es para actualizar contador de copias y disponibles
                                cont=1; 
                                fil=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(nomb)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos=contadorElimUs; //nos da la posicion del elemento
                                            fil=k; //nos da la fila del elemento
                                            col=u; //nos da la columna del elemento
                                        }
                                        cont++;

                                    }

                                 }


           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(fil, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt+1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, fil, 10); //enviamos el nuevo valor a la tabla
           tabla9.setValueAt(asignarCambio, fil, 10);
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(fil, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt+1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, fil, 11); //enviamos el nuevo valor a la tabla
           tabla9.setValueAt(asignarCambio2, fil, 11);
           
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                                    String tipoo=(String)tabla8.getValueAt(filaSelectt, 0);
                                    String autorr=(String)tabla8.getValueAt(filaSelectt, 1);
                                    String tituloo=(String)tabla8.getValueAt(filaSelectt, 2);
                                    String nombree=(String)tabla8.getValueAt(filaSelectt, 3);

                                    modelo11.addRow(new Object[]{tipoo,autorr,tituloo,nombree,dateFormat.format(date),hourFormat.format(date)});
                                    
                                    //Esto es para eliminar el prestamo de biblioteca virtual
                                    String tippo=(String)tabla8.getValueAt(filaSelectt, 0);
                                    Integer ctippo=Integer.parseInt(tippo);
                                    String nomb2=(String)tabla8.getValueAt(filaSelectt, 2);
                                    
                                    if (ctippo==0) {
                              
                                         cont2=1; 
                                fil22=modelo5.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo5.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo5.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo5.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==0
                                    
                                    if (ctippo==1) {
                              
                                         cont2=1; 
                                fil22=modelo6.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo6.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo6.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo6.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==1
                                    
                                    if (ctippo==2) {
                              
                                         cont2=1; 
                                fil22=modelo7.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo7.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo7.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo7.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==2
                                    
                                    modelo3.removeRow(filaSelectt);
                                    JOptionPane.showMessageDialog(null, "PRESTAMO ELIMINADO CON EXITO!");
                 }
                      //PARA USUARIO 2
                      if (filaElimUs==1) {
                          
                          //buscamos el nombre de bibliografia en modelo 2 (bibliografias)
               String nomb=(String)tabla8.getValueAt(filaSelectt, 2);
                               
                                cont=1; 
                                fil=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(nomb)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos=contadorElimUs; //nos da la posicion del elemento
                                            fil=k; //nos da la fila del elemento
                                            col=u; //nos da la columna del elemento
                                        }
                                        cont++;

                                    }

                                 }


           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(fil, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt+1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, fil, 10); //enviamos el nuevo valor a la tabla
           tabla9.setValueAt(asignarCambio, fil, 10);
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(fil, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt+1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, fil, 11); //enviamos el nuevo valor a la tabla
           tabla9.setValueAt(asignarCambio2, fil, 11);
                          
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                                    String tipoo=(String)tabla8.getValueAt(filaSelectt, 0);
                                    String autorr=(String)tabla8.getValueAt(filaSelectt, 1);
                                    String tituloo=(String)tabla8.getValueAt(filaSelectt, 2);
                                    String nombree=(String)tabla8.getValueAt(filaSelectt, 3);

                                    modelo18.addRow(new Object[]{tipoo,autorr,tituloo,nombree,dateFormat.format(date),hourFormat.format(date)});
                                    
                                    //Esto es para eliminar el prestamo de biblioteca virtual
                                    String tippo=(String)tabla8.getValueAt(filaSelectt, 0);
                                    Integer ctippo=Integer.parseInt(tippo);
                                    String nomb2=(String)tabla8.getValueAt(filaSelectt, 2);
                                    
                                    if (ctippo==0) {
                              
                                         cont2=1; 
                                fil22=modelo12.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo12.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo12.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo12.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==0
                                    
                                    if (ctippo==1) {
                              
                                         cont2=1; 
                                fil22=modelo13.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo13.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo13.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo13.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==1
                                    
                                    if (ctippo==2) {
                              
                                         cont2=1; 
                                fil22=modelo14.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo14.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo14.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo14.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==2
                                    
                                    
                                    modelo3.removeRow(filaSelectt);
                                    JOptionPane.showMessageDialog(null, "PRESTAMO ELIMINADO CON EXITO!");
                     
                 }
                      //PARA USUARIO 3
                      if (filaElimUs==2) {
                          
                          //buscamos el nombre de bibliografia en modelo 2 (bibliografias)
               String nomb=(String)tabla8.getValueAt(filaSelectt, 2);
                               
                                cont=1; 
                                fil=modelo2.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col=modelo2.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo2.getValueAt(k, u).equals(nomb)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos=contadorElimUs; //nos da la posicion del elemento
                                            fil=k; //nos da la fila del elemento
                                            col=u; //nos da la columna del elemento
                                        }
                                        cont++;

                                    }

                                 }


           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(fil, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt+1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, fil, 10); //enviamos el nuevo valor a la tabla
           tabla9.setValueAt(asignarCambio, fil, 10);
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(fil, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt+1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, fil, 11); //enviamos el nuevo valor a la tabla
           tabla9.setValueAt(asignarCambio2, fil, 11);
                          
                                    Date date = new Date();
                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                                    String tipoo=(String)tabla8.getValueAt(filaSelectt, 0);
                                    String autorr=(String)tabla8.getValueAt(filaSelectt, 1);
                                    String tituloo=(String)tabla8.getValueAt(filaSelectt, 2);
                                    String nombree=(String)tabla8.getValueAt(filaSelectt, 3);

                                    modelo25.addRow(new Object[]{tipoo,autorr,tituloo,nombree,dateFormat.format(date),hourFormat.format(date)});
                                    
                                    //Esto es para eliminar el prestamo de biblioteca virtual
                                    String tippo=(String)tabla8.getValueAt(filaSelectt, 0);
                                    Integer ctippo=Integer.parseInt(tippo);
                                    String nomb2=(String)tabla8.getValueAt(filaSelectt, 2);
                                    
                                    if (ctippo==0) {
                              
                                         cont2=1; 
                                fil22=modelo19.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo19.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo19.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo19.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==0
                                    
                                    if (ctippo==1) {
                              
                                         cont2=1; 
                                fil22=modelo20.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo20.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo20.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo20.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==1
                                    
                                    if (ctippo==2) {
                              
                                         cont2=1; 
                                fil22=modelo21.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                col2=modelo21.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < fil22; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < col2; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo21.getValueAt(k, u).equals(nomb2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            pos2=cont2; //nos da la posicion del elemento
                                            fil22=k; //nos da la fila del elemento
                                            col2=u; //nos da la columna del elemento
                                            
                                        }
                                        cont2++;

                                    }

                                 }
                                        if (pos2>=1) {
                                           modelo21.removeRow(fil22);
                                        }
                          }//cierre if si es tipo ==2
                                    
                                    modelo3.removeRow(filaSelectt);
                                    JOptionPane.showMessageDialog(null, "PRESTAMO ELIMINADO CON EXITO!");
                     
                 }
            
                 
             }else{
                 JOptionPane.showMessageDialog(null, "SELECCIONE FILA A ELIMINAR PRESTAMO!");
             }
             
        }
         
         if(evento.getSource()==regresarDeEliminarPrestamo){
          
             this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
    panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
            
        }
         
         ///para ir al panel ver prestamos
         if(evento.getSource()==verPres){
             
            this.setSize(985, 560);
            this.setLocationRelativeTo(null); 
            
           panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(true);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
         
        }
         
         //para hacer prestamo (me tira al otro panel con los usuarios)
         if(evento.getSource()==hacerPrestamo){
          
             filaSelectHacerPrestamo=tabla5.getSelectedRow();
            
            if(filaSelectHacerPrestamo>-1){ //el menos uno porque con el filtro no me lee la fila 0
                
                this.setSize(375,365); 
            this.setLocationRelativeTo(null);
            
              panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(true);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
        //aqui se cargan los nombres de usuarios al comboBox
        int filaselectAsignar=tabla.getRowCount();
             
             for (int i = 0; i < filaselectAsignar; i++) {
                 
                 NombresParaPrestamo=(String)tabla.getValueAt(i, 1);
                 rolAsignarPrestamo.addItem(NombresParaPrestamo);
             }
          
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione la fila para hacer el prestamo!");
            }
         
          
        }

         //Para asignar prestamo y mandarlo a la tabla
         if(evento.getSource()==asignarPrestamoUsuario){
            String nombreBibl="";
            String nombreUs="";
            
             int filaselectAsignarPrestamoo=tabla5.getSelectedRow();
             String valorTipo=(String)tabla5.getValueAt(filaselectAsignarPrestamoo, 0);//capturamos el tipo de bibliografia
             Integer valorTipoConver=Integer.parseInt(valorTipo); //convertimos el tipo de bibliografia a int
             
             nombreUs=rolAsignarPrestamo.getSelectedItem().toString(); //aqui capturamos el nombre del usuario que tiene el prestamo
             
             nombreBibl=(String)tabla5.getValueAt(filaselectAsignarPrestamoo, 2); //nombre del titulo de la biblio de la fila seleccionada
             
             //para que nos busque el nombre del usuario de la fila seleccionada
                                contadorAu=1; 
                                filaAu=modelo.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaAu=modelo.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaAu; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaAu; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo.getValueAt(k, u).equals(nombreUs)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionAu=contadorAu; //nos da la posicion del elemento
                                            filaAu=k; //nos da la fila del elemento
                                            columnaAu=u; //nos da la columna del elemento
                                        }
                                        contadorAu++;

                                    }

                                 }
                          
             
             //USUARIO 1
             if (filaAu==0) {
                 
                 if (valorTipoConver==0) {
                     
                                contadorVp=1; 
                                filaVp=modelo5.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo5.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo5.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                               
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           
           modelo5.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,temasPrestamo,palabrasPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo8.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                                    posicionAu=0; 
                                    filaAu=0; 
                                    columnaAu=0;
                                    
                                }
                 
                  
                 }//termina if ==0
                 
                 if (valorTipoConver==1) {
                     
                                contadorVp=1; 
                                filaVp=modelo6.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo6.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo6.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES!");

                                   //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String frecPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 5);
           String ejempPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 6);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           
           modelo6.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,frecPrestamo,ejempPrestamo,temasPrestamo,palabrasPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo8.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                     
                 }
    }
                 if (valorTipoConver==2) {
                     
                                contadorVp=1; 
                                filaVp=modelo7.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo7.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo7.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           String areaPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 6);
           
           modelo7.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,temasPrestamo,palabrasPrestamo,areaPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo8.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                     
                 }
                     
                     
                 }
                 
             }
             
             //USUARIO 2
             if (filaAu==1) {
                 
                if (valorTipoConver==0) {
                     
                                contadorVp=1; 
                                filaVp=modelo12.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo12.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo12.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                               
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                   // posicionVp=0; 
                                    //filaVp=0; 
                                    //columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           
           modelo12.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,temasPrestamo,palabrasPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo15.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                                    posicionAu=0; 
                                    filaAu=0; 
                                    columnaAu=0;
                                    
                                }
                 
                  
                 }//termina if ==0
                 
                 if (valorTipoConver==1) {
                     
                                contadorVp=1; 
                                filaVp=modelo13.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo13.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo13.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String frecPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 5);
           String ejempPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 6);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           
           modelo13.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,frecPrestamo,ejempPrestamo,temasPrestamo,palabrasPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo15.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                     
                 }
    }
                 if (valorTipoConver==2) {
                     
                                contadorVp=1; 
                                filaVp=modelo14.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo14.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo14.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           String areaPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 6);
           
           modelo14.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,temasPrestamo,palabrasPrestamo,areaPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo15.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                     
                 }
                     
                     
                 }
                 
             }
             
             //USUARIO 3
             if (filaAu==2) {
                 
                 if (valorTipoConver==0) {
                     
                                contadorVp=1; 
                                filaVp=modelo19.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo19.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo19.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                               
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                   // posicionVp=0; 
                                    //filaVp=0; 
                                    //columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           
           modelo19.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,temasPrestamo,palabrasPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo22.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                                    posicionAu=0; 
                                    filaAu=0; 
                                    columnaAu=0;
                                    
                                }
                 
                  
                 }//termina if ==0
                 
                 if (valorTipoConver==1) {
                     
                                contadorVp=1; 
                                filaVp=modelo20.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo20.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo20.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String frecPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 5);
           String ejempPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 6);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           
           modelo20.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,frecPrestamo,ejempPrestamo,temasPrestamo,palabrasPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo22.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                     
                 }
    }
                 if (valorTipoConver==2) {
                     
                                contadorVp=1; 
                                filaVp=modelo21.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columnaVp=modelo21.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                for (int k = 0; k < filaVp; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columnaVp; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo21.getValueAt(k, u).equals(nombreBibl)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicionVp=contadorVp; //nos da la posicion del elemento
                                            filaVp=k; //nos da la fila del elemento
                                            columnaVp=u; //nos da la columna del elemento
                                        }
                                        contadorVp++;

                                    }

                                 }
                                
                                String dispoCopi=(String)tabla2.getValueAt(filaSelectHacerPrestamo, 11);
                                Integer conver=Integer.parseInt(dispoCopi);
                                
                                if(posicionVp>=1||conver==0){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA! O NO HAY COPIAS DISPONIBLES");

                                   //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;

                                }else{
                                    
                                    Date date = new Date();
            //obtener la hora
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

            //obtener la fecha
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //se obtienen los valores segunla fila seleccionada para hacer el prestamo
            String tipoPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 0);
            String autorPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 1);
            String tituloPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 2);
            String copiasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 10);
            String disponiblesPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 11);
            
           String cargaPrestamo[]=new String[9];
           cargaPrestamo[0]=tipoPrestamo;
           cargaPrestamo[1]=autorPrestamo;
           cargaPrestamo[2]=tituloPrestamo;
           cargaPrestamo[3]=rolAsignarPrestamo.getSelectedItem().toString();
           cargaPrestamo[4]=copiasPrestamo;
           cargaPrestamo[5]=disponiblesPrestamo;
           cargaPrestamo[6]=dateFormat.format(date);
           cargaPrestamo[7]=hourFormat.format(date);
           cargaPrestamo[8]="1";
           modelo3.addRow(cargaPrestamo);
           
           //para biblioteca virtual del usuario 1
           String edicionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 3);
           String descripcionPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 4);
           String temasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 7);
           String palabrasPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 8);
           String areaPrestamo=(String)tabla5.getValueAt(filaSelectHacerPrestamo, 6);
           
           modelo21.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,edicionPrestamo,descripcionPrestamo,temasPrestamo,palabrasPrestamo,areaPrestamo,copiasPrestamo,disponiblesPrestamo,dateFormat.format(date),hourFormat.format(date),false});
           
           //para reporte
           modelo22.addRow(new Object[]{tipoPrestamo,autorPrestamo,tituloPrestamo,rolAsignarPrestamo.getSelectedItem().toString(),dateFormat.format(date),hourFormat.format(date)});
           
           //para actualizar el contador de copias
           String CambioCopias = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 10); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioCopiasInt= Integer.parseInt(CambioCopias); //el valor obtenido lo convertimos a Integer
           int OperacionCopias=CambioCopiasInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio=String.valueOf(OperacionCopias); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio, filaSelectHacerPrestamo, 10); //enviamos el nuevo valor a la tabla
           
           //para actualizar el contador de disponibles
           String CambioDisponibless = (String)tabla5.getValueAt(filaSelectHacerPrestamo, 11); //aqui se obtiene de copias de la fila seleccionada en String
           Integer CambioDisponiblesInt= Integer.parseInt(CambioDisponibless); //el valor obtenido lo convertimos a Integer
           int OperacionDisponibles=CambioDisponiblesInt-1; //hacemos la operacion le restamos 1 a copias
           String asignarCambio2=String.valueOf(OperacionDisponibles); //ya hecha la operacion lo convertimos a string para mandarlo a la tabla
           tabla5.setValueAt(asignarCambio2, filaSelectHacerPrestamo, 11); //enviamos el nuevo valor a la tabla
                                    
           JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
           
           //para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                     
                 }
                     
                     
                 }
                 
             }
             
             //Por si es un usuario nuevo
             if (filaAu!=0&&filaAu!=1&&filaAu!=2) {
                 
                 JOptionPane.showMessageDialog(null, "PRESTAMO CREADO CON EXITO!");
                 
             }
 
             
            
             
        }
         
         if(evento.getSource()==cancelarAsignarPrestamoUsuario){
             
             this.setSize(985, 560);
            this.setLocationRelativeTo(null);
            
           panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);

//para que me reinicie la busqueda
                                    posicionVp=0; 
                                    filaVp=0; 
                                    columnaVp=0;
                                    
                                    
        
             rolAsignarPrestamo.removeAllItems(); //me borra los items del rol para despues me salgan ya actualizados
             
           }
         
         //para ir a menu despues de ver prestamos
         if(evento.getSource()==regresarDeVerPrestamos){
             
             this.setSize(985, 560);
            this.setLocationRelativeTo(null);
            
         panel1.setVisible(true);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
           }
         
         
         
      ////////////////////////////////////////////////////////////////INTEFAZ USUARIO/////////////////////////////////////////////////////////////////////

         //boton logout de interfaz usuario
        if(evento.getSource()==logoutUsuario){
    	 
            this.setSize(375,415); //Para que cambie tama;o de mi ventana
        this.setLocationRelativeTo(null);
            
        panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(true);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);

IdUsuarioLogin.setText("");
passLogin.setText("");

                //para que me reinicie la busqueda desde 0 (asi no me tira error)
                posicionGlobal=0;
                 filaGlobal=0;
                 columna2=0;

    	 } 
        
        //va a la biblioteca virtual
        if(evento.getSource()==BibliotecaVirtual){
            System.out.println(filaGlobal);
            
            if (filaGlobal==0) {
                
                this.setSize(1260, 830);
        this.setLocationRelativeTo(null);
    	 
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(true);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
                
            }
            
            else if (filaGlobal==1) {
                
                this.setSize(1260, 830);
        this.setLocationRelativeTo(null);
    	 
        panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(true);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
                
            }else if (filaGlobal==2) {
                
                this.setSize(1260, 830);
        this.setLocationRelativeTo(null);
    	 
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(true);
panelReporteUsuario3.setVisible(false);
                
            }
            
        
    	 } 
   //////////////////////////////////////////////////////////////USUARIO 1/////////////////////////////////////////////////////////////////////////////
        
        //boton reporte prestamo usuario 1
        if(evento.getSource()==reportePrestamos1){
    	
        this.setSize(920, 710);
        this.setLocationRelativeTo(null);
        
        panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(true);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 } 
        
        //boton devolucion bibliografia Usuario 1
        if(evento.getSource()==devolucionLibros1){
    	 
            
            if (filaGlobal==0) {
                
                String confiPassw=JOptionPane.showInputDialog("INGRESE SU PASSWORD: ");
                
                if (confiPassw.equals(tabla.getValueAt(0, 5))) {
                    
                    int filasTabla10=tabla10.getRowCount(); // las filas de la tabla
                int filasTabla11=tabla11.getRowCount();
                int filasTabla12=tabla12.getRowCount();
                        
                for (int i = 0; i < filasTabla10; i++) { //me recorre la tabla
                 
                   boolean trueFalse=(boolean)tabla10.getValueAt(i, 11);
                  
                    if (trueFalse==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla10.getValueAt(i, 0);
                              String bb=""+tabla10.getValueAt(i, 1);
                              String cc=""+tabla10.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo9.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
                
                for (int i = 0; i < filasTabla11; i++) { //me recorre la tabla
                 
                   boolean trueFalse2=(boolean)tabla11.getValueAt(i, 13);
                  
                    if (trueFalse2==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla11.getValueAt(i, 0);
                              String bb=""+tabla11.getValueAt(i, 1);
                              String cc=""+tabla11.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo9.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
                
                for (int i = 0; i < filasTabla12; i++) { //me recorre la tabla
                 
                   boolean trueFalse3=(boolean)tabla12.getValueAt(i, 12);
                  
                    if (trueFalse3==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla12.getValueAt(i, 0);
                              String bb=""+tabla12.getValueAt(i, 1);
                              String cc=""+tabla12.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo9.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
             
                JOptionPane.showMessageDialog(null, "SE HAN HECHO LAS DEVOLUCIONES CON EXITO!");
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "ERROR EN LA PASSWORD");
                    
                }
                
                
             }//cierre filaGlobal==0
             
    	 } 
        
        //boton regresar de interfaz usuario 1
        if(evento.getSource()==regresarDeUsuario1){
        
        this.setSize(1260, 700);
        this.setLocationRelativeTo(null);
       
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(true);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 } 
        
        //regresar de reporte usuario 1
        if(evento.getSource()==regresarReporteUsuario1){
           
            this.setSize(1260, 830);
        this.setLocationRelativeTo(null);
    	 
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(true);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);

        }
        
        
        //////////////////////////////////////////////////////////////USUARIO 2/////////////////////////////////////////////////////////////////////////////
        
        //boton reporte prestamo usuario 2
        if(evento.getSource()==reportePrestamos2){
    	
        this.setSize(920, 710);
        this.setLocationRelativeTo(null);
        
        panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(true);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
        
    	 } 
      
        //devolucion de bibliografia usuario 2
        if(evento.getSource()==devolucionLibros2){
            
            if (filaGlobal==1) {
                
                String confiPassw=JOptionPane.showInputDialog("INGRESE SU PASSWORD: ");
                
                if (confiPassw.equals(tabla.getValueAt(1, 5))) {
                    
                int filasTabla17=tabla17.getRowCount(); // las filas de la tabla
                int filasTabla18=tabla18.getRowCount();
                int filasTabla19=tabla19.getRowCount();
                        
                for (int i = 0; i < filasTabla17; i++) { //me recorre la tabla
                 
                   boolean trueFalse=(boolean)tabla17.getValueAt(i, 11);
                  
                    if (trueFalse==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla17.getValueAt(i, 0);
                              String bb=""+tabla17.getValueAt(i, 1);
                              String cc=""+tabla17.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo16.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
                
                for (int i = 0; i < filasTabla18; i++) { //me recorre la tabla
                 
                   boolean trueFalse2=(boolean)tabla18.getValueAt(i, 13);
                  
                    if (trueFalse2==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla18.getValueAt(i, 0);
                              String bb=""+tabla18.getValueAt(i, 1);
                              String cc=""+tabla18.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo16.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
                
                for (int i = 0; i < filasTabla19; i++) { //me recorre la tabla
                 
                   boolean trueFalse3=(boolean)tabla19.getValueAt(i, 12);
                  
                    if (trueFalse3==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla19.getValueAt(i, 0);
                              String bb=""+tabla19.getValueAt(i, 1);
                              String cc=""+tabla19.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo16.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
             
                JOptionPane.showMessageDialog(null, "SE HAN HECHO LAS DEVOLUCIONES CON EXITO!");
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "ERROR EN LA PASSWORD");
                    
                }
                
                
             }//cierre filaGlobal==1
            
        } 
        
        //regresar de usuario 2
        if(evento.getSource()==regresarDeUsuario2){
        
            this.setSize(1260, 700);
        this.setLocationRelativeTo(null);
       
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(true);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
            
        }   
              
         //regresar de reporte usuario 2
        if(evento.getSource()==regresarReporteUsuario2){
           
            this.setSize(1260, 830);
        this.setLocationRelativeTo(null);
    	 
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(true);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);

        }
        
        
         //////////////////////////////////////////////////////////////USUARIO 3/////////////////////////////////////////////////////////////////////////////
        
        //boton reporte prestamo usuario 3
        if(evento.getSource()==reportePrestamos3){
    	
        this.setSize(920, 710);
        this.setLocationRelativeTo(null);
        
        panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(true);
        
    	 } 
      
         //regresar de reporte usuario 3
        if(evento.getSource()==regresarReporteUsuario3){
           
            this.setSize(1260, 830);
        this.setLocationRelativeTo(null);
    	 
       panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(false);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(true);
panelReporteUsuario3.setVisible(false);

        }
        
        //devolucion de bibliografia usuario 3
        if(evento.getSource()==devolucionLibros3){
            
            if (filaGlobal==2) {
                
                String confiPassw=JOptionPane.showInputDialog("INGRESE SU PASSWORD: ");
                
                if (confiPassw.equals(tabla.getValueAt(2, 5))) {
                    
                int filasTabla24=tabla24.getRowCount(); // las filas de la tabla
                int filasTabla25=tabla25.getRowCount();
                int filasTabla26=tabla26.getRowCount();
                        
                for (int i = 0; i < filasTabla24; i++) { //me recorre la tabla
                 
                   boolean trueFalse=(boolean)tabla24.getValueAt(i, 11);
                  
                    if (trueFalse==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla24.getValueAt(i, 0);
                              String bb=""+tabla24.getValueAt(i, 1);
                              String cc=""+tabla24.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo23.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
                
                for (int i = 0; i < filasTabla25; i++) { //me recorre la tabla
                 
                   boolean trueFalse2=(boolean)tabla25.getValueAt(i, 13);
                  
                    if (trueFalse2==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla25.getValueAt(i, 0);
                              String bb=""+tabla25.getValueAt(i, 1);
                              String cc=""+tabla25.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo23.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
                
                for (int i = 0; i < filasTabla26; i++) { //me recorre la tabla
                 
                   boolean trueFalse3=(boolean)tabla26.getValueAt(i, 12);
                  
                    if (trueFalse3==true) { //si el check es true ara lo siguiente ...
                               
                        Date date = new Date();
                                //obtener la hora
                                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                //obtener la fecha
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        
                              String aa=""+tabla26.getValueAt(i, 0);
                              String bb=""+tabla26.getValueAt(i, 1);
                              String cc=""+tabla26.getValueAt(i, 2);
                              String dd=""+tabla.getValueAt(2, 1)+" "+tabla.getValueAt(1, 2);
                              String ee=dateFormat.format(date);
                              String ff=hourFormat.format(date);
                              modelo23.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
                              
                           }
                 }
             
                JOptionPane.showMessageDialog(null, "SE HAN HECHO LAS DEVOLUCIONES CON EXITO!");
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "ERROR EN LA PASSWORD");
                    
                }
                
                
             }//cierre filaGlobal==2
            
        } 
        
        //regresar de usuario 3
        if(evento.getSource()==regresarDeUsuario3){
        
            this.setSize(1260, 700);
        this.setLocationRelativeTo(null);
       
panel1.setVisible(false);
panel2.setVisible(false);
panel3.setVisible(false);
panelBuscarEliminarUsuario.setVisible(false);
panelEliminarUsuario.setVisible(false);
panelBuscarModificarUsuario.setVisible(false);
panelModificarUsuario.setVisible(false);
panelCrearBibliografia.setVisible(false);
panelCargaIndividual.setVisible(false);
panelCargaMasiva.setVisible(false);
panelVerBibliografias.setVisible(false);
panelModificarBibliografias.setVisible(false);
panelEliminarBibliografias.setVisible(false);
panelCrearPrestamos.setVisible(false);
panelAsignarPrestamo.setVisible(false);
panelVerPrestamos.setVisible(false);
panelModificarPrestamos.setVisible(false);
panelModificarPrestamos2.setVisible(false);
PanelEliminarPrestamos.setVisible(false);
panelInterfazPrincipal.setVisible(false);
panelLogin.setVisible(false);
panelInterfazUsuario.setVisible(true);
panelUsuario1.setVisible(false);
panelReporteUsuario1.setVisible(false);
panelUsuario2.setVisible(false);
panelReporteUsuario2.setVisible(false);
panelUsuario3.setVisible(false);
panelReporteUsuario3.setVisible(false);
            
        }   
      
     }//cierre metodo ActionPerformed

        
    //evento keyTyped para que me filtren datos en la tabla ver bibliografias
    public void keyTyped(KeyEvent e) { // se crea el evento keyTyped
        
        filtro.addKeyListener(new KeyAdapter(){ //se le asigna el evento a nuestro textField (filtro)
                                                // ya se agrego la accion a filtro 
        public void keyReleased(final KeyEvent evt)  {
            
            //aca se crea un if para que me identifica el item por cual ser buscado
            //la variable "segunItem" es global
            if (rolVerBibliografia.getSelectedItem().toString().equals("Tipo")) {
                segunItem=0;
            }
            if (rolVerBibliografia.getSelectedItem().toString().equals("Autor")) {
                segunItem=1;
            }
            if (rolVerBibliografia.getSelectedItem().toString().equals("Palabras Clave")) {
                segunItem=8;
            }
            if (rolVerBibliografia.getSelectedItem().toString().equals("Tema")) {
                segunItem=7;
            }
            
            trs.setRowFilter(RowFilter.regexFilter("(?i)"+filtro.getText(), segunItem)); //trs es de TableRowSorter (arriba se creo global)
                                                                                         //el "(?i)" es para que no me detecte mayusculas
        }
            
        });
        
        trs=new TableRowSorter(modelo2); //se le asigna el objeto a nuestro modelo
        tabla2.setRowSorter(trs); //a nuestra tabla se le asigna el objeto trs
        
        //PARA CREAR PRESTAMOS//
        filtro2.addKeyListener(new KeyAdapter(){ //se le asigna el evento a nuestro textField (filtro2)
                                                // ya se agrego la accion a filtro2 
        public void keyReleased(final KeyEvent evt)  {
            
            //aca se crea un if para que me identifica el item por cual ser buscado
            //la variable "segunItem" es global
            if (rolCrearPrestamo.getSelectedItem().toString().equals("Autor")) {
                segunItem2=1;
            }
            if (rolCrearPrestamo.getSelectedItem().toString().equals("Titulo")) {
                segunItem2=2;
            }
            if (rolCrearPrestamo.getSelectedItem().toString().equals("Palabras Clave")) {
                segunItem2=8;
            }
            
            
            trs2.setRowFilter(RowFilter.regexFilter("(?i)"+filtro2.getText(), segunItem2)); //trs es de TableRowSorter (arriba se creo global)
                                                                                         //el "(?i)" es para que no me detecte mayusculas
        }
            
        });
        
        trs2=new TableRowSorter(modelo2); //se le asigna el objeto a nuestro modelo
        tabla5.setRowSorter(trs2); //a nuestra tabla se le asigna el objeto trs
        
        //PARA interfaz usuario//
        filtro3.addKeyListener(new KeyAdapter(){ //se le asigna el evento a nuestro textField (filtro2)
                                                // ya se agrego la accion a filtro2 
        public void keyReleased(final KeyEvent evt)  {
            
            //aca se crea un if para que me identifica el item por cual ser buscado
            //la variable "segunItem" es global
            if (rolUsuario.getSelectedItem().toString().equals("Autor")) {
                segunItem3=1;
            }
            if (rolUsuario.getSelectedItem().toString().equals("Titulo")) {
                segunItem3=2;
            }
            if (rolUsuario.getSelectedItem().toString().equals("Palabras Clave")) {
                segunItem3=8;
            }
            
            
            trs3.setRowFilter(RowFilter.regexFilter("(?i)"+filtro3.getText(), segunItem3)); //trs es de TableRowSorter (arriba se creo global)
                                                                                         //el "(?i)" es para que no me detecte mayusculas
        }
            
        });
        
        trs3=new TableRowSorter(modelo4); //se le asigna el objeto a nuestro modelo
        tabla9.setRowSorter(trs3); //a nuestra tabla se le asigna el objeto trs
        
        //PARA interfaz usuario1
        filtro4.addKeyListener(new KeyAdapter(){ //se le asigna el evento a nuestro textField (filtro2)
                                                // ya se agrego la accion a filtro2 
        public void keyReleased(final KeyEvent evt)  {
            
            //aca se crea un if para que me identifica el item por cual ser buscado
            //la variable "segunItem" es global
            if (rolUsuario1.getSelectedItem().toString().equals("Autor")) {
                segunItem4=1;
            }
            if (rolUsuario1.getSelectedItem().toString().equals("Titulo")) {
                segunItem4=2;
            }
            
            trs4.setRowFilter(RowFilter.regexFilter("(?i)"+filtro4.getText(), segunItem4)); //trs es de TableRowSorter (arriba se creo global)
                                                                                         //el "(?i)" es para que no me detecte mayusculas
            trs5.setRowFilter(RowFilter.regexFilter("(?i)"+filtro4.getText(), segunItem4));
            trs6.setRowFilter(RowFilter.regexFilter("(?i)"+filtro4.getText(), segunItem4));
        }
            
        });
        
        trs4=new TableRowSorter(modelo5); //se le asigna el objeto a nuestro modelo
        tabla10.setRowSorter(trs4); //a nuestra tabla se le asigna el objeto trs
        //lo mismo de antes se hace para las otras dos tablas
        trs5=new TableRowSorter(modelo6);
        tabla11.setRowSorter(trs5);
        trs6=new TableRowSorter(modelo6);
        tabla12.setRowSorter(trs6);
        
        //PARA interfaz usuario2
        filtro5.addKeyListener(new KeyAdapter(){ //se le asigna el evento a nuestro textField (filtro2)
                                                // ya se agrego la accion a filtro2 
        public void keyReleased(final KeyEvent evt)  {
            
            //aca se crea un if para que me identifica el item por cual ser buscado
            //la variable "segunItem" es global
            if (rolUsuario2.getSelectedItem().toString().equals("Autor")) {
                segunItem5=1;
            }
            if (rolUsuario2.getSelectedItem().toString().equals("Titulo")) {
                segunItem5=2;
            }
            
            trs7.setRowFilter(RowFilter.regexFilter("(?i)"+filtro5.getText(), segunItem5)); //trs es de TableRowSorter (arriba se creo global)
                                                                                         //el "(?i)" es para que no me detecte mayusculas
            trs8.setRowFilter(RowFilter.regexFilter("(?i)"+filtro5.getText(), segunItem5));
            trs9.setRowFilter(RowFilter.regexFilter("(?i)"+filtro5.getText(), segunItem5));
        }
            
        });
        
        trs7=new TableRowSorter(modelo12); //se le asigna el objeto a nuestro modelo
        tabla17.setRowSorter(trs7); //a nuestra tabla se le asigna el objeto trs
        //lo mismo de antes se hace para las otras dos tablas
        trs8=new TableRowSorter(modelo13);
        tabla18.setRowSorter(trs8);
        trs9=new TableRowSorter(modelo14);
        tabla19.setRowSorter(trs9);
        
        //PARA interfaz usuario3
        filtro6.addKeyListener(new KeyAdapter(){ //se le asigna el evento a nuestro textField (filtro2)
                                                // ya se agrego la accion a filtro2 
        public void keyReleased(final KeyEvent evt)  {
            
            //aca se crea un if para que me identifica el item por cual ser buscado
            //la variable "segunItem" es global
            if (rolUsuario3.getSelectedItem().toString().equals("Autor")) {
                segunItem6=1;
            }
            if (rolUsuario3.getSelectedItem().toString().equals("Titulo")) {
                segunItem6=2;
            }
            
            trs10.setRowFilter(RowFilter.regexFilter("(?i)"+filtro6.getText(), segunItem6)); //trs es de TableRowSorter (arriba se creo global)
                                                                                         //el "(?i)" es para que no me detecte mayusculas
            trs11.setRowFilter(RowFilter.regexFilter("(?i)"+filtro6.getText(), segunItem6));
            trs12.setRowFilter(RowFilter.regexFilter("(?i)"+filtro6.getText(), segunItem6));
        }
            
        });
        
        trs10=new TableRowSorter(modelo19); //se le asigna el objeto a nuestro modelo
        tabla24.setRowSorter(trs10); //a nuestra tabla se le asigna el objeto trs
        //lo mismo de antes se hace para las otras dos tablas
        trs11=new TableRowSorter(modelo20);
        tabla25.setRowSorter(trs11);
        trs12=new TableRowSorter(modelo21);
        tabla26.setRowSorter(trs12);
        
    }
    
    

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    //evento mouseClicked
    @Override
     public  void mouseClicked(MouseEvent e){
            
         int row = tabla9.rowAtPoint(e.getPoint()); //me selecciona la fila de la tabla
         int column = tabla9.columnAtPoint(e.getPoint()); //me selecciona la columna de la tabla
                
        if (row<tabla9.getRowCount() && row>=0 && column<tabla9.getColumnCount() && column>=0) { //la fila menor al numero de filas total y mayor que 0
                                                                                                 //la columna mayor al numero de columnas total y mayor que 0
             Object value= tabla9.getValueAt(row, column);//valua la fila y columna
             
                if (value instanceof JButton) { // si es un boton se hace lo siguiente ...
                    ((JButton)value).doClick(); // si se da click en el boton se hace lo siguiente ...
                    JButton boton =(JButton) value; //se devuelve lo que hace el boton 
                    
            
             //AQUI EMPIEZA EL IF PRINCIPAL
            String valorTipooo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
            Integer valorTipoConver2= Integer.parseInt(valorTipooo); //convertimos el tipo a Integer
             
 if (filaGlobal==0) {
                        
                    
             if (valorTipoConver2==0) {
             
                                contadorBib=1; 
                                fila3=modelo5.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columna3=modelo5.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo5.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicion3=contadorBib; //nos da la posicion del elemento
                                            fila3=k; //nos da la fila del elemento
                                            columna3=u; //nos da la columna del elemento
                                        }
                                        contadorBib++;

                                    }

                                 }

                                if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                   //para que me reinicie la busqueda
                                    posicion3=0; 
                                    fila3=0; 
                                    columna3=0;

                                }else{


                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                     //para mandar datos a las tablas
                                                   if (row>-1) { 
                                                   String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                   Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                   Date date = new Date();
                                                   //obtener la hora
                                                   DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                   //obtener la fecha
                                                   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                       //por si es LIBRO
                                                                       if (valorTipoConver==0) {
                                                                           String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                           String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                           String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                           String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                           String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                           String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                           String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                           modelo5.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo8.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es REVISTA
                                                                       if (valorTipoConver==1) {
                                                                           String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                           String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                           String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                           String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                           String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                           String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                           String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                           String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                           String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                           modelo6.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo8.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es TESIS
                                                                       if (valorTipoConver==2) {
                                                                           String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                           String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                           String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                           String descTes=tabla9.getValueAt(row, 4).toString();
                                                                           String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                           String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                           String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                           String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                           String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                           modelo7.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo8.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }

                                                              }

                                }
                }//AQUI TERMINA EL IF ==0
             
             else if(valorTipoConver2==1){
                 
                                contadorBib=1; 
                                fila3=modelo6.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columna3=modelo6.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo6.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicion3=contadorBib; //nos da la posicion del elemento
                                            fila3=k; //nos da la fila del elemento
                                            columna3=u; //nos da la columna del elemento
                                        }
                                        contadorBib++;

                                    }

                                 }

                                if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                   //para que me reinicie la busqueda
                                    posicion3=0; 
                                    fila3=0; 
                                    columna3=0;

                                }else{


                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                     //para mandar datos a las tablas
                                                   if (row>-1) { 
                                                   String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                   Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                   Date date = new Date();
                                                   //obtener la hora
                                                   DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                   //obtener la fecha
                                                   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                       //por si es LIBRO
                                                                       if (valorTipoConver==0) {
                                                                           String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                           String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                           String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                           String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                           String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                           String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                           String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                           modelo5.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});

                                                                           modelo8.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es REVISTA
                                                                       if (valorTipoConver==1) {
                                                                           String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                           String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                           String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                           String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                           String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                           String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                           String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                           String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                           String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                           modelo6.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo8.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es TESIS
                                                                       if (valorTipoConver==2) {
                                                                           String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                           String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                           String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                           String descTes=tabla9.getValueAt(row, 4).toString();
                                                                           String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                           String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                           String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                           String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                           String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                           modelo7.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
 
                                                                           modelo8.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }

                                                              }

                                }
                                                        
                  }//AQUI TERMINA EL IF ==1
             
                else if(valorTipoConver2==2){
                    
                                 contadorBib=1; 
                                 fila3=modelo7.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                 columna3=modelo7.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                 String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                 for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                     for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                         if(modelo7.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                             posicion3=contadorBib; //nos da la posicion del elemento
                                             fila3=k; //nos da la fila del elemento
                                             columna3=u; //nos da la columna del elemento
                                         }
                                         contadorBib++;

                                     }

                                  }

                                 if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                    JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                 }else{


                                     //para que me reinicie la busqueda
                                      posicion3=0; 
                                      fila3=0; 
                                      columna3=0;

                                      //para mandar datos a las tablas
                                                    if (row>-1) { 
                                                    String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                    Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                    Date date = new Date();
                                                    //obtener la hora
                                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                    //obtener la fecha
                                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                        //por si es LIBRO
                                                                        if (valorTipoConver==0) {
                                                                            String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                            String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                            String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                            String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                            String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                            String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                            String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                            String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                            modelo5.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo8.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }
                                                                        //por si es REVISTA
                                                                        if (valorTipoConver==1) {
                                                                            String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                            String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                            String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                            String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                            String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                            String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                            String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                            String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                            String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                            String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                            modelo6.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo8.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }
                                                                        //por si es TESIS
                                                                        if (valorTipoConver==2) {
                                                                            String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                            String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                            String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                            String descTes=tabla9.getValueAt(row, 4).toString();
                                                                            String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                            String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                            String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                            String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                            String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                            modelo7.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo8.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1)+" "+tabla.getValueAt(0, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }

                                                               }

                                 }
                                                        
                } //AQUI TERMINA EL IF ==2
           
                      
               
             
                }//termina el IF GLOBAL ==0
             
if (filaGlobal==1) {
    
    if (valorTipoConver2==0) {
             
                                contadorBib=1; 
                                fila3=modelo12.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columna3=modelo12.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo12.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicion3=contadorBib; //nos da la posicion del elemento
                                            fila3=k; //nos da la fila del elemento
                                            columna3=u; //nos da la columna del elemento
                                        }
                                        contadorBib++;

                                    }

                                 }

                                if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                   //para que me reinicie la busqueda
                                    posicion3=0; 
                                    fila3=0; 
                                    columna3=0;

                                }else{


                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                     //para mandar datos a las tablas
                                                   if (row>-1) { 
                                                   String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                   Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                   Date date = new Date();
                                                   //obtener la hora
                                                   DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                   //obtener la fecha
                                                   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                       //por si es LIBRO
                                                                       if (valorTipoConver==0) {
                                                                           String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                           String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                           String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                           String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                           String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                           String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                           String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                           modelo12.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo15.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es REVISTA
                                                                       if (valorTipoConver==1) {
                                                                           String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                           String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                           String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                           String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                           String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                           String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                           String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                           String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                           String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                           modelo13.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo15.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es TESIS
                                                                       if (valorTipoConver==2) {
                                                                           String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                           String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                           String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                           String descTes=tabla9.getValueAt(row, 4).toString();
                                                                           String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                           String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                           String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                           String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                           String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                           modelo14.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo15.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }

                                                              }

                                }
                }//AQUI TERMINA EL IF ==0
             
             else if(valorTipoConver2==1){
                 
                                contadorBib=1; 
                                fila3=modelo13.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columna3=modelo13.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo13.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicion3=contadorBib; //nos da la posicion del elemento
                                            fila3=k; //nos da la fila del elemento
                                            columna3=u; //nos da la columna del elemento
                                        }
                                        contadorBib++;

                                    }

                                 }

                                if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                   //para que me reinicie la busqueda
                                    posicion3=0; 
                                    fila3=0; 
                                    columna3=0;

                                }else{


                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                     //para mandar datos a las tablas
                                                   if (row>-1) { 
                                                   String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                   Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                   Date date = new Date();
                                                   //obtener la hora
                                                   DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                   //obtener la fecha
                                                   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                       //por si es LIBRO
                                                                       if (valorTipoConver==0) {
                                                                           String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                           String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                           String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                           String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                           String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                           String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                           String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                           modelo12.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo15.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es REVISTA
                                                                       if (valorTipoConver==1) {
                                                                           String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                           String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                           String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                           String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                           String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                           String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                           String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                           String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                           String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                           modelo13.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo15.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es TESIS
                                                                       if (valorTipoConver==2) {
                                                                           String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                           String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                           String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                           String descTes=tabla9.getValueAt(row, 4).toString();
                                                                           String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                           String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                           String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                           String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                           String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                           modelo14.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                          modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo15.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }

                                                              }

                                }
                                                        
                  }//AQUI TERMINA EL IF ==1
             
                else if(valorTipoConver2==2){
                    
                                 contadorBib=1; 
                                 fila3=modelo14.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                 columna3=modelo14.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                 String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                 for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                     for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                         if(modelo14.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                             posicion3=contadorBib; //nos da la posicion del elemento
                                             fila3=k; //nos da la fila del elemento
                                             columna3=u; //nos da la columna del elemento
                                         }
                                         contadorBib++;

                                     }

                                  }

                                 if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                    JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                 }else{


                                     //para que me reinicie la busqueda
                                      posicion3=0; 
                                      fila3=0; 
                                      columna3=0;

                                      //para mandar datos a las tablas
                                                    if (row>-1) { 
                                                    String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                    Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                    Date date = new Date();
                                                    //obtener la hora
                                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                    //obtener la fecha
                                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                        //por si es LIBRO
                                                                        if (valorTipoConver==0) {
                                                                            String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                            String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                            String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                            String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                            String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                            String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                            String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                            String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                            modelo12.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo15.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }
                                                                        //por si es REVISTA
                                                                        if (valorTipoConver==1) {
                                                                            String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                            String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                            String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                            String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                            String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                            String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                            String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                            String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                            String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                            String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                            modelo13.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo15.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }
                                                                        //por si es TESIS
                                                                        if (valorTipoConver==2) {
                                                                            String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                            String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                            String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                            String descTes=tabla9.getValueAt(row, 4).toString();
                                                                            String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                            String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                            String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                            String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                            String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                            modelo14.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo15.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(1, 1)+" "+tabla.getValueAt(1, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }

                                                               }

                                 }
                                                        
                }
                        
    
    
}//termina FILA GLOBAL ==1
             
if (filaGlobal==2) {
    
    if (valorTipoConver2==0) {
             
                                contadorBib=1; 
                                fila3=modelo19.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columna3=modelo19.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo19.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicion3=contadorBib; //nos da la posicion del elemento
                                            fila3=k; //nos da la fila del elemento
                                            columna3=u; //nos da la columna del elemento
                                        }
                                        contadorBib++;

                                    }

                                 }

                                if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                   //para que me reinicie la busqueda
                                    posicion3=0; 
                                    fila3=0; 
                                    columna3=0;

                                }else{


                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                     //para mandar datos a las tablas
                                                   if (row>-1) { 
                                                   String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                   Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                   Date date = new Date();
                                                   //obtener la hora
                                                   DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                   //obtener la fecha
                                                   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                       //por si es LIBRO
                                                                       if (valorTipoConver==0) {
                                                                           String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                           String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                           String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                           String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                           String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                           String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                           String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                           modelo19.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo22.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es REVISTA
                                                                       if (valorTipoConver==1) {
                                                                           String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                           String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                           String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                           String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                           String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                           String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                           String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                           String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                           String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                           modelo20.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                          modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo22.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es TESIS
                                                                       if (valorTipoConver==2) {
                                                                           String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                           String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                           String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                           String descTes=tabla9.getValueAt(row, 4).toString();
                                                                           String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                           String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                           String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                           String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                           String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                           modelo21.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                          modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo22.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }

                                                              }

                                }
                }//AQUI TERMINA EL IF ==0
             
             else if(valorTipoConver2==1){
                 
                                contadorBib=1; 
                                fila3=modelo20.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                columna3=modelo20.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                    for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                        if(modelo20.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                            posicion3=contadorBib; //nos da la posicion del elemento
                                            fila3=k; //nos da la fila del elemento
                                            columna3=u; //nos da la columna del elemento
                                        }
                                        contadorBib++;

                                    }

                                 }

                                if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                   JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                   //para que me reinicie la busqueda
                                    posicion3=0; 
                                    fila3=0; 
                                    columna3=0;

                                }else{


                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                     //para mandar datos a las tablas
                                                   if (row>-1) { 
                                                   String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                   Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                   Date date = new Date();
                                                   //obtener la hora
                                                   DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                   //obtener la fecha
                                                   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                       //por si es LIBRO
                                                                       if (valorTipoConver==0) {
                                                                           String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                           String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                           String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                           String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                           String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                           String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                           String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                           modelo19.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo22.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es REVISTA
                                                                       if (valorTipoConver==1) {
                                                                           String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                           String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                           String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                           String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                           String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                           String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                           String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                           String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                           String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                           String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                           modelo20.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo22.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }
                                                                       //por si es TESIS
                                                                       if (valorTipoConver==2) {
                                                                           String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                           String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                           String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                           String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                           String descTes=tabla9.getValueAt(row, 4).toString();
                                                                           String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                           String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                           String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                           String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                           String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                           modelo21.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                           modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                           modelo22.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                }

                                                              }

                                }
                                                        
                  }//AQUI TERMINA EL IF ==1
             
                else if(valorTipoConver2==2){
                    
                                 contadorBib=1; 
                                 fila3=modelo21.getRowCount(); //variable fila1 es igual a las filas de nuestro modelo de tabla
                                 columna3=modelo21.getColumnCount(); //variable columna1 es igual a las columndas de nuestro modelo de tabla

                                 String valorTipo2=tabla9.getValueAt(row, 2).toString();//aqui capturamos el tipo de bibliografia

                                 for (int k = 0; k < fila3; k++) { //me recorre las filas del modelo de tabla
                                     for (int u = 0; u < columna3; u++) { //me recorre las columnas del modelo de tabla

                                         if(modelo21.getValueAt(k, u).equals(valorTipo2)){ // si el elemento (k,u) es igual al elemento de la tabla
                                             posicion3=contadorBib; //nos da la posicion del elemento
                                             fila3=k; //nos da la fila del elemento
                                             columna3=u; //nos da la columna del elemento
                                         }
                                         contadorBib++;

                                     }

                                  }

                                 if(posicion3>=1){  //>=1 porque el elemento puede estar en posicion 0



                                    JOptionPane.showMessageDialog(null, "YA TIENE LA MISMA BIBLIOGRAFIA CARGADA EN SU CUENTA!");

                                    //para que me reinicie la busqueda
                                     posicion3=0; 
                                     fila3=0; 
                                     columna3=0;

                                 }else{


                                     //para que me reinicie la busqueda
                                      posicion3=0; 
                                      fila3=0; 
                                      columna3=0;

                                      //para mandar datos a las tablas
                                                    if (row>-1) { 
                                                    String valorTipo=tabla9.getValueAt(row, 0).toString();//aqui capturamos el tipo de bibliografia
                                                    Integer valorTipoConver= Integer.parseInt(valorTipo); //convertimos el tipo a Integer

                                                    Date date = new Date();
                                                    //obtener la hora
                                                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                                                    //obtener la fecha
                                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   

                                                                        //por si es LIBRO
                                                                        if (valorTipoConver==0) {
                                                                            String tipoLibro=tabla9.getValueAt(row, 0).toString();
                                                                            String autorLibro=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloLibro=tabla9.getValueAt(row, 2).toString();
                                                                            String edicLibro=tabla9.getValueAt(row, 3).toString();
                                                                            String descLibro=tabla9.getValueAt(row, 4).toString();
                                                                            String temasLibro=tabla9.getValueAt(row, 7).toString();
                                                                            String palabLibro=tabla9.getValueAt(row, 8).toString();
                                                                            String copiasLibro=tabla9.getValueAt(row, 10).toString();
                                                                            String dispLibro=tabla9.getValueAt(row, 11).toString();
                                                                            modelo19.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,edicLibro,descLibro,temasLibro,palabLibro,copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(0, 1),copiasLibro,dispLibro,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo22.addRow(new Object[]{tipoLibro,autorLibro,tituloLibro,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }
                                                                        //por si es REVISTA
                                                                        if (valorTipoConver==1) {
                                                                            String tipoRevis=tabla9.getValueAt(row, 0).toString();
                                                                            String autorRevis=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloRevis=tabla9.getValueAt(row, 2).toString();
                                                                            String edicRevis=tabla9.getValueAt(row, 3).toString();
                                                                            String descRevis=tabla9.getValueAt(row, 4).toString();
                                                                            String frecRevis=tabla9.getValueAt(row, 5).toString();
                                                                            String ejempRevis=tabla9.getValueAt(row, 6).toString();
                                                                            String temasRevis=tabla9.getValueAt(row, 7).toString();
                                                                            String palabRevis=tabla9.getValueAt(row, 8).toString();
                                                                            String copiasRevis=tabla9.getValueAt(row, 10).toString();
                                                                            String dispRevis=tabla9.getValueAt(row, 11).toString();
                                                                            modelo20.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,edicRevis,descRevis,frecRevis,ejempRevis,temasRevis,palabRevis,copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(0, 1),copiasRevis,dispRevis,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo22.addRow(new Object[]{tipoRevis,autorRevis,tituloRevis,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }
                                                                        //por si es TESIS
                                                                        if (valorTipoConver==2) {
                                                                            String tipoTes=tabla9.getValueAt(row, 0).toString();
                                                                            String autorTes=tabla9.getValueAt(row, 1).toString();
                                                                            String tituloTes=tabla9.getValueAt(row, 2).toString();
                                                                            String edicTes=tabla9.getValueAt(row, 3).toString();
                                                                            String descTes=tabla9.getValueAt(row, 4).toString();
                                                                            String temasTes=tabla9.getValueAt(row, 7).toString();
                                                                            String palabTes=tabla9.getValueAt(row, 8).toString();
                                                                            String areaTes=tabla9.getValueAt(row, 9).toString();
                                                                            String copiasTes=tabla9.getValueAt(row, 10).toString();
                                                                            String dispTes=tabla9.getValueAt(row, 11).toString();
                                                                            modelo21.addRow(new Object[]{tipoTes,autorTes,tituloTes,edicTes,descTes,temasTes,palabTes,areaTes,copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),false});
                                                                            modelo3.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(0, 1),copiasTes,dispTes,dateFormat.format(date),hourFormat.format(date),"1"});
                                                                            modelo22.addRow(new Object[]{tipoTes,autorTes,tituloTes,tabla.getValueAt(2, 1)+" "+tabla.getValueAt(2, 2),dateFormat.format(date),hourFormat.format(date)});
                                                                                                 }

                                                               }

                                 }
                                                        
                }
                        
                    }//termina FILA GLOBAL ==2
             
            }
         }
        
        if (e.getClickCount()==2) {
            
            if (e.getComponent().equals(tabla10)) { //si se hace doble click en la tabla 10 entonces ....
               //PARA TABLA 10 (LIBROS)(USUARIO 1)
            String tipo=tabla10.getValueAt(tabla10.getSelectedRow(), 0).toString();
            String aautor =tabla10.getValueAt(tabla10.getSelectedRow(), 1).toString();
            String ttitulo=tabla10.getValueAt(tabla10.getSelectedRow(), 2).toString();
            String eedicion =tabla10.getValueAt(tabla10.getSelectedRow(), 3).toString();
            String ddescripcion=tabla10.getValueAt(tabla10.getSelectedRow(), 4).toString();
            String ttemas =tabla10.getValueAt(tabla10.getSelectedRow(), 5).toString();
            String palabras=tabla10.getValueAt(tabla10.getSelectedRow(), 6).toString();
            String ccopias =tabla10.getValueAt(tabla10.getSelectedRow(), 7).toString();
            String ddisponibles=tabla10.getValueAt(tabla10.getSelectedRow(), 8).toString();
            String fecha =tabla10.getValueAt(tabla10.getSelectedRow(), 9).toString();
            String hora=tabla10.getValueAt(tabla10.getSelectedRow(), 10).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo
                                                        +"\nAutor: "+aautor
                                                        +"\nTITULO: "+ttitulo
                                                        +"\nEDICION: "+eedicion
                                                        +"\nDESCRIPCION: "+ddescripcion
                                                        +"\nTEMAS: "+ttemas
                                                        +"\nPALABRAS CLAVE : "+palabras
                                                        +"\nCOPIAS : "+ccopias
                                                        +"\nDISPONIBLES : "+ddisponibles
                                                        +"\nFECHA : "+fecha
                                                        +"\nHORA : "+hora); 
            }
            
            if (e.getComponent().equals(tabla11)) { //si se hace doble click en la tabla 11 entonces ....
                
                //PARA TABLA 11 (REVISTA)(USUARIO 1)
            String tipo2=tabla11.getValueAt(tabla11.getSelectedRow(), 0).toString();
            String autor2 =tabla11.getValueAt(tabla11.getSelectedRow(), 1).toString();
            String titulo2=tabla11.getValueAt(tabla11.getSelectedRow(), 2).toString();
            String edicion2 =tabla11.getValueAt(tabla11.getSelectedRow(), 3).toString();
            String descripcion2=tabla11.getValueAt(tabla11.getSelectedRow(), 4).toString();
            String frecuencia2 =tabla11.getValueAt(tabla11.getSelectedRow(), 5).toString();
            String ejemplares2=tabla11.getValueAt(tabla11.getSelectedRow(), 6).toString();
            String temas2 =tabla11.getValueAt(tabla11.getSelectedRow(), 7).toString();
            String palabras2=tabla11.getValueAt(tabla11.getSelectedRow(), 8).toString();
            String copias2 =tabla11.getValueAt(tabla11.getSelectedRow(), 9).toString();
            String disponibles2=tabla11.getValueAt(tabla11.getSelectedRow(), 10).toString();
            String fecha2 =tabla11.getValueAt(tabla11.getSelectedRow(), 11).toString();
            String hora2=tabla11.getValueAt(tabla11.getSelectedRow(), 12).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo2
                                                        +"\nAutor: "+autor2
                                                        +"\nTITULO: "+titulo2
                                                        +"\nEDICION: "+edicion2
                                                        +"\nDESCRIPCION: "+descripcion2
                                                        +"\nFRECUENCIA : "+frecuencia2
                                                        +"\nEJEMPLARES : "+ejemplares2
                                                        +"\nTEMAS: "+temas2
                                                        +"\nPALABRAS CLAVE : "+palabras2
                                                        +"\nCOPIAS : "+copias2
                                                        +"\nDISPONIBLES : "+disponibles2
                                                        +"\nFECHA : "+fecha2
                                                        +"\nHORA : "+hora2);
                
            }
            
          if (e.getComponent().equals(tabla12)) {//si se hace doble click en la tabla 12 entonces ....
              
              //PARA TABLA 12 (TESIS)(USUARIO 1)
            String tipo3=tabla12.getValueAt(tabla12.getSelectedRow(), 0).toString();
            String autor3 =tabla12.getValueAt(tabla12.getSelectedRow(), 1).toString();
            String titulo3=tabla12.getValueAt(tabla12.getSelectedRow(), 2).toString();
            String edicion3 =tabla12.getValueAt(tabla12.getSelectedRow(), 3).toString();
            String descripcion3=tabla12.getValueAt(tabla12.getSelectedRow(), 4).toString();
            String temas3 =tabla12.getValueAt(tabla12.getSelectedRow(), 5).toString();
            String palabras3=tabla12.getValueAt(tabla12.getSelectedRow(), 6).toString();
            String area3 =tabla12.getValueAt(tabla12.getSelectedRow(), 7).toString();
            String copias3 =tabla12.getValueAt(tabla12.getSelectedRow(), 8).toString();
            String disponibles3=tabla12.getValueAt(tabla12.getSelectedRow(), 9).toString();
            String fecha3 =tabla12.getValueAt(tabla12.getSelectedRow(), 10).toString();
            String hora3=tabla12.getValueAt(tabla12.getSelectedRow(), 11).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo3
                                                        +"\nAutor: "+autor3
                                                        +"\nTITULO: "+titulo3
                                                        +"\nEDICION: "+edicion3
                                                        +"\nEJEMPLARES : "+descripcion3
                                                        +"\nTEMAS: "+temas3
                                                        +"\nPALABRAS CLAVE : "+palabras3
                                                        +"\nAREA : "+area3
                                                        +"\nCOPIAS : "+copias3
                                                        +"\nDISPONIBLES : "+disponibles3
                                                        +"\nFECHA : "+fecha3
                                                        +"\nHORA : "+hora3);
              
          }
          
          if (e.getComponent().equals(tabla17)) { //si se hace doble click en la tabla 10 entonces ....
               //PARA TABLA 10 (LIBROS)(USUARIO 1)
            String tipo=tabla17.getValueAt(tabla17.getSelectedRow(), 0).toString();
            String aautor =tabla17.getValueAt(tabla17.getSelectedRow(), 1).toString();
            String ttitulo=tabla17.getValueAt(tabla17.getSelectedRow(), 2).toString();
            String eedicion =tabla17.getValueAt(tabla17.getSelectedRow(), 3).toString();
            String ddescripcion=tabla17.getValueAt(tabla17.getSelectedRow(), 4).toString();
            String ttemas =tabla17.getValueAt(tabla17.getSelectedRow(), 5).toString();
            String palabras=tabla17.getValueAt(tabla17.getSelectedRow(), 6).toString();
            String ccopias =tabla17.getValueAt(tabla17.getSelectedRow(), 7).toString();
            String ddisponibles=tabla17.getValueAt(tabla17.getSelectedRow(), 8).toString();
            String fecha =tabla17.getValueAt(tabla17.getSelectedRow(), 9).toString();
            String hora=tabla17.getValueAt(tabla17.getSelectedRow(), 10).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo
                                                        +"\nAutor: "+aautor
                                                        +"\nTITULO: "+ttitulo
                                                        +"\nEDICION: "+eedicion
                                                        +"\nDESCRIPCION: "+ddescripcion
                                                        +"\nTEMAS: "+ttemas
                                                        +"\nPALABRAS CLAVE : "+palabras
                                                        +"\nCOPIAS : "+ccopias
                                                        +"\nDISPONIBLES : "+ddisponibles
                                                        +"\nFECHA : "+fecha
                                                        +"\nHORA : "+hora); 
            }
            
            if (e.getComponent().equals(tabla18)) { //si se hace doble click en la tabla 11 entonces ....
                
                //PARA TABLA 11 (REVISTA)(USUARIO 1)
            String tipo2=tabla18.getValueAt(tabla18.getSelectedRow(), 0).toString();
            String autor2 =tabla18.getValueAt(tabla18.getSelectedRow(), 1).toString();
            String titulo2=tabla18.getValueAt(tabla18.getSelectedRow(), 2).toString();
            String edicion2 =tabla18.getValueAt(tabla18.getSelectedRow(), 3).toString();
            String descripcion2=tabla18.getValueAt(tabla18.getSelectedRow(), 4).toString();
            String frecuencia2 =tabla18.getValueAt(tabla18.getSelectedRow(), 5).toString();
            String ejemplares2=tabla18.getValueAt(tabla18.getSelectedRow(), 6).toString();
            String temas2 =tabla18.getValueAt(tabla18.getSelectedRow(), 7).toString();
            String palabras2=tabla18.getValueAt(tabla18.getSelectedRow(), 8).toString();
            String copias2 =tabla18.getValueAt(tabla18.getSelectedRow(), 9).toString();
            String disponibles2=tabla18.getValueAt(tabla18.getSelectedRow(), 10).toString();
            String fecha2 =tabla18.getValueAt(tabla18.getSelectedRow(), 11).toString();
            String hora2=tabla18.getValueAt(tabla18.getSelectedRow(), 12).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo2
                                                        +"\nAutor: "+autor2
                                                        +"\nTITULO: "+titulo2
                                                        +"\nEDICION: "+edicion2
                                                        +"\nDESCRIPCION: "+descripcion2
                                                        +"\nFRECUENCIA : "+frecuencia2
                                                        +"\nEJEMPLARES : "+ejemplares2
                                                        +"\nTEMAS: "+temas2
                                                        +"\nPALABRAS CLAVE : "+palabras2
                                                        +"\nCOPIAS : "+copias2
                                                        +"\nDISPONIBLES : "+disponibles2
                                                        +"\nFECHA : "+fecha2
                                                        +"\nHORA : "+hora2);
                
            }
            
          if (e.getComponent().equals(tabla19)) {//si se hace doble click en la tabla 12 entonces ....
              
              //PARA TABLA 12 (TESIS)(USUARIO 1)
            String tipo3=tabla19.getValueAt(tabla19.getSelectedRow(), 0).toString();
            String autor3 =tabla19.getValueAt(tabla19.getSelectedRow(), 1).toString();
            String titulo3=tabla19.getValueAt(tabla19.getSelectedRow(), 2).toString();
            String edicion3 =tabla19.getValueAt(tabla19.getSelectedRow(), 3).toString();
            String descripcion3=tabla19.getValueAt(tabla19.getSelectedRow(), 4).toString();
            String temas3 =tabla19.getValueAt(tabla19.getSelectedRow(), 5).toString();
            String palabras3=tabla19.getValueAt(tabla19.getSelectedRow(), 6).toString();
            String area3 =tabla19.getValueAt(tabla19.getSelectedRow(), 7).toString();
            String copias3 =tabla19.getValueAt(tabla19.getSelectedRow(), 8).toString();
            String disponibles3=tabla19.getValueAt(tabla19.getSelectedRow(), 9).toString();
            String fecha3 =tabla19.getValueAt(tabla19.getSelectedRow(), 10).toString();
            String hora3=tabla19.getValueAt(tabla19.getSelectedRow(), 11).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo3
                                                        +"\nAutor: "+autor3
                                                        +"\nTITULO: "+titulo3
                                                        +"\nEDICION: "+edicion3
                                                        +"\nEJEMPLARES : "+descripcion3
                                                        +"\nTEMAS: "+temas3
                                                        +"\nPALABRAS CLAVE : "+palabras3
                                                        +"\nAREA : "+area3
                                                        +"\nCOPIAS : "+copias3
                                                        +"\nDISPONIBLES : "+disponibles3
                                                        +"\nFECHA : "+fecha3
                                                        +"\nHORA : "+hora3);
              
          }
          
        if (e.getComponent().equals(tabla24)) { //si se hace doble click en la tabla 10 entonces ....
               //PARA TABLA 10 (LIBROS)(USUARIO 1)
            String tipo=tabla24.getValueAt(tabla24.getSelectedRow(), 0).toString();
            String aautor =tabla24.getValueAt(tabla24.getSelectedRow(), 1).toString();
            String ttitulo=tabla24.getValueAt(tabla24.getSelectedRow(), 2).toString();
            String eedicion =tabla24.getValueAt(tabla24.getSelectedRow(), 3).toString();
            String ddescripcion=tabla24.getValueAt(tabla24.getSelectedRow(), 4).toString();
            String ttemas =tabla24.getValueAt(tabla24.getSelectedRow(), 5).toString();
            String palabras=tabla24.getValueAt(tabla24.getSelectedRow(), 6).toString();
            String ccopias =tabla24.getValueAt(tabla24.getSelectedRow(), 7).toString();
            String ddisponibles=tabla24.getValueAt(tabla24.getSelectedRow(), 8).toString();
            String fecha =tabla24.getValueAt(tabla24.getSelectedRow(), 9).toString();
            String hora=tabla24.getValueAt(tabla24.getSelectedRow(), 10).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo
                                                        +"\nAutor: "+aautor
                                                        +"\nTITULO: "+ttitulo
                                                        +"\nEDICION: "+eedicion
                                                        +"\nDESCRIPCION: "+ddescripcion
                                                        +"\nTEMAS: "+ttemas
                                                        +"\nPALABRAS CLAVE : "+palabras
                                                        +"\nCOPIAS : "+ccopias
                                                        +"\nDISPONIBLES : "+ddisponibles
                                                        +"\nFECHA : "+fecha
                                                        +"\nHORA : "+hora); 
            }
            
            if (e.getComponent().equals(tabla25)) { //si se hace doble click en la tabla 11 entonces ....
                
                //PARA TABLA 11 (REVISTA)(USUARIO 1)
            String tipo2=tabla25.getValueAt(tabla25.getSelectedRow(), 0).toString();
            String autor2 =tabla25.getValueAt(tabla25.getSelectedRow(), 1).toString();
            String titulo2=tabla25.getValueAt(tabla25.getSelectedRow(), 2).toString();
            String edicion2 =tabla25.getValueAt(tabla25.getSelectedRow(), 3).toString();
            String descripcion2=tabla25.getValueAt(tabla25.getSelectedRow(), 4).toString();
            String frecuencia2 =tabla25.getValueAt(tabla25.getSelectedRow(), 5).toString();
            String ejemplares2=tabla25.getValueAt(tabla25.getSelectedRow(), 6).toString();
            String temas2 =tabla25.getValueAt(tabla25.getSelectedRow(), 7).toString();
            String palabras2=tabla25.getValueAt(tabla25.getSelectedRow(), 8).toString();
            String copias2 =tabla25.getValueAt(tabla25.getSelectedRow(), 9).toString();
            String disponibles2=tabla25.getValueAt(tabla25.getSelectedRow(), 10).toString();
            String fecha2 =tabla25.getValueAt(tabla25.getSelectedRow(), 11).toString();
            String hora2=tabla25.getValueAt(tabla25.getSelectedRow(), 12).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo2
                                                        +"\nAutor: "+autor2
                                                        +"\nTITULO: "+titulo2
                                                        +"\nEDICION: "+edicion2
                                                        +"\nDESCRIPCION: "+descripcion2
                                                        +"\nFRECUENCIA : "+frecuencia2
                                                        +"\nEJEMPLARES : "+ejemplares2
                                                        +"\nTEMAS: "+temas2
                                                        +"\nPALABRAS CLAVE : "+palabras2
                                                        +"\nCOPIAS : "+copias2
                                                        +"\nDISPONIBLES : "+disponibles2
                                                        +"\nFECHA : "+fecha2
                                                        +"\nHORA : "+hora2);
                
            }
            
          if (e.getComponent().equals(tabla26)) {//si se hace doble click en la tabla 12 entonces ....
              
              //PARA TABLA 12 (TESIS)(USUARIO 1)
            String tipo3=tabla26.getValueAt(tabla26.getSelectedRow(), 0).toString();
            String autor3 =tabla26.getValueAt(tabla26.getSelectedRow(), 1).toString();
            String titulo3=tabla26.getValueAt(tabla26.getSelectedRow(), 2).toString();
            String edicion3 =tabla26.getValueAt(tabla26.getSelectedRow(), 3).toString();
            String descripcion3=tabla26.getValueAt(tabla26.getSelectedRow(), 4).toString();
            String temas3 =tabla26.getValueAt(tabla26.getSelectedRow(), 5).toString();
            String palabras3=tabla26.getValueAt(tabla26.getSelectedRow(), 6).toString();
            String area3 =tabla26.getValueAt(tabla26.getSelectedRow(), 7).toString();
            String copias3 =tabla26.getValueAt(tabla26.getSelectedRow(), 8).toString();
            String disponibles3=tabla26.getValueAt(tabla26.getSelectedRow(), 9).toString();
            String fecha3 =tabla26.getValueAt(tabla26.getSelectedRow(), 10).toString();
            String hora3=tabla26.getValueAt(tabla26.getSelectedRow(), 11).toString();
            
            JOptionPane.showMessageDialog(null, "TIPO: "+tipo3
                                                        +"\nAutor: "+autor3
                                                        +"\nTITULO: "+titulo3
                                                        +"\nEDICION: "+edicion3
                                                        +"\nEJEMPLARES : "+descripcion3
                                                        +"\nTEMAS: "+temas3
                                                        +"\nPALABRAS CLAVE : "+palabras3
                                                        +"\nAREA : "+area3
                                                        +"\nCOPIAS : "+copias3
                                                        +"\nDISPONIBLES : "+disponibles3
                                                        +"\nFECHA : "+fecha3
                                                        +"\nHORA : "+hora3);
              
          }  
            
        }
        
       
     }//cierre metodo

     
     
    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
        
        

       
    
                                
                                    
        
        
    }
    
    
     
    



