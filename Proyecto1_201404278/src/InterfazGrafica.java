

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InterfazGrafica {
    
    public InterfazGrafica(){
      
    }
    
    ////////////////////////////////////////////////////////INTERFAZ PRINCIPAL Y LOGIN///////////////////////////////////////////////////////////////////
    
    //para interfaz principal
    public static void PanelInterfazPrincipal(){
        
        Usuarios.bttLogin=new JButton("LOGIN");
        Usuarios.bttLogin.setBounds(550, 25, 130, 40);
        Usuarios.panelInterfazPrincipal.add(Usuarios.bttLogin);
        
        Usuarios.bttAbout=new JButton("ABOUT");
        Usuarios.bttAbout.setBounds(750, 25, 130, 40);
        Usuarios.panelInterfazPrincipal.add(Usuarios.bttAbout);
        
        Usuarios.imagenUsac=new JLabel("");
        Usuarios.imagenUsac.setBounds(75, 25, 350, 350);
        Usuarios.panelInterfazPrincipal.add(Usuarios.imagenUsac);
        
        
        Usuarios.imagenIngen=new JLabel("");
        Usuarios.imagenIngen.setBounds(575, 125, 250, 250);
        Usuarios.panelInterfazPrincipal.add(Usuarios.imagenIngen);
        
        Usuarios.titBib=new JLabel("BIBLIOTECA VIRTUAL");
        Usuarios.titBib.setBounds(5, 350, 950, 200);
        Usuarios.titBib.setFont(new java.awt.Font("Times New Roman", 0, 90)); 
        Usuarios.panelInterfazPrincipal.add(Usuarios.titBib);
        
        
        
        
    }
   
    //para interfaz Login
    public static void panelLogin(){
        
        
        Usuarios.titLogin=new JLabel("LOGIN");
        Usuarios.titLogin.setBounds(150, 25, 170, 25);
        Usuarios.panelLogin.add(Usuarios.titLogin);
        
        Usuarios.titIdUsuario=new JLabel("ID / USUARIO");
        Usuarios.titIdUsuario.setBounds(30, 75, 170, 25);
        Usuarios.panelLogin.add(Usuarios.titIdUsuario);
        
        Usuarios.IdUsuarioLogin=new JTextField();
        Usuarios.IdUsuarioLogin.setBounds(30, 110, 275, 25);
        Usuarios.panelLogin.add(Usuarios.IdUsuarioLogin);
        
        Usuarios.titPassdeLogin=new JLabel("PASSWORD");
        Usuarios.titPassdeLogin.setBounds(30, 150, 350, 25);
        Usuarios.panelLogin.add(Usuarios.titPassdeLogin);
        
        Usuarios.passLogin=new JPasswordField();
        Usuarios.passLogin.setBounds(30, 185, 275, 25);
        Usuarios.panelLogin.add(Usuarios.passLogin);
        
        Usuarios.login=new JButton("LOGIN");
        Usuarios.login.setBounds(30, 240, 275, 40);
        Usuarios.panelLogin.add(Usuarios.login);
        
        Usuarios.RegresarLogin=new JButton("CANCELAR Y REGRESAR");
        Usuarios.RegresarLogin.setBounds(30, 300, 275, 40);
        Usuarios.panelLogin.add(Usuarios.RegresarLogin);
        
    }
    
    ////////////////////////////////////////////////////////////////////USUARIOS/////////////////////////////////////////////////////////////////////////
    
    //metodo que contiene los componentes del panel administrador
    public static void cargarComponentesPanel1() {
        
        Usuarios.titAdmin= new JLabel("USUARIO ADMINISTRADOR");
        Usuarios.about=new JButton("ABOUT");
        
        Usuarios.titUsuarios= new JLabel("USUARIOS");
        Usuarios.crearUs=new JButton("CREAR USUARIOS");
        Usuarios.modiUs=new JButton("MODIFICAR USUARIOS");
        Usuarios.elimUs=new JButton("ELIMINAR USUARIOS");
        Usuarios.verUs=new JButton("VER USUARIOS");
        
        Usuarios.titBiblios= new JLabel("BIBLIOGRAFIAS");
        Usuarios.crearBib=new JButton("CREAR BIBLIOGRAFIA");
        Usuarios.modiBib=new JButton("MODIFICAR BIBLIOGRAFIA");
        Usuarios.elimBib=new JButton("ELIMINAR BIBLIOGRAFIA");
        Usuarios.verBib=new JButton("VER BIBLIOGRAFIA");
        
        Usuarios.titPrestamos= new JLabel("PRESTAMOS");
        Usuarios.crearPres=new JButton("CREAR PRESTAMO");
        Usuarios.modiPres=new JButton("MODIFICAR PRESTAMO");
        Usuarios.elimPres=new JButton("ELIMINAR PRESTAMO");
        Usuarios.verPres=new JButton("VER PRESTAMO");
        
         //titulo
        Usuarios.titAdmin.setBounds(400, 50, 170, 25);
        Usuarios.panel1.add(Usuarios.titAdmin);
        
        Usuarios.about.setBounds(690, 50, 170, 25);
        Usuarios.panel1.add(Usuarios.about);
        
        //titulo usuario
        Usuarios.titUsuarios.setBounds(30, 110, 170, 25);
        Usuarios.panel1.add(Usuarios.titUsuarios);
        //botonoes usuario
        Usuarios.crearUs.setBounds(30, 150, 170, 40);
        Usuarios.panel1.add(Usuarios.crearUs);
      
        Usuarios.modiUs.setBounds(250, 150, 170, 40);
        Usuarios.panel1.add(Usuarios.modiUs);
        
        Usuarios.elimUs.setBounds(470, 150, 170, 40);
        Usuarios.panel1.add(Usuarios.elimUs);
        
        Usuarios.verUs.setBounds(690, 150, 170, 40);
        Usuarios.panel1.add(Usuarios.verUs);
        
        //titulo bibliografia
        Usuarios.titBiblios.setBounds(30, 230, 170, 25);
        Usuarios.panel1.add(Usuarios.titBiblios);
        //botones bibliografia
        Usuarios.crearBib.setBounds(30, 270, 170, 40);
        Usuarios.panel1.add(Usuarios.crearBib);
       
        Usuarios.modiBib.setBounds(250, 270, 180, 40);
        Usuarios.panel1.add(Usuarios.modiBib);
        
        Usuarios.elimBib.setBounds(470, 270, 170, 40);
        Usuarios.panel1.add(Usuarios.elimBib);
        
        Usuarios.verBib.setBounds(690, 270, 170, 40);
        Usuarios.panel1.add(Usuarios.verBib);
        
        //titulo prestamo
        Usuarios.titPrestamos.setBounds(30, 360, 170, 25);
        Usuarios.panel1.add(Usuarios.titPrestamos);
        
        //botones prestamo
        Usuarios.crearPres.setBounds(30, 400, 170, 40);
        Usuarios.panel1.add(Usuarios.crearPres);
        
        Usuarios.modiPres.setBounds(250, 400, 170, 40);
        Usuarios.panel1.add(Usuarios.modiPres);
        
        Usuarios.elimPres.setBounds(470, 400, 170, 40);
        Usuarios.panel1.add(Usuarios.elimPres);
        
        Usuarios.verPres.setBounds(690, 400, 170, 40);
        Usuarios.panel1.add(Usuarios.verPres);
       
    }
    
    //metodo que contiene los componentes para crear un usuario
    public static void cargarComponentesPanel2() {
        
        Usuarios.titUS= new JLabel("CREAR USUARIOS");
        Usuarios.titID= new JLabel("ID");
        Usuarios.titNombre= new JLabel("NOMBRE");
        Usuarios.titApellido= new JLabel("APELLIDO");
        Usuarios.titUser= new JLabel("USER");
        Usuarios.titRol= new JLabel("ROL");
        Usuarios.titPassword= new JLabel("PASSWORD");
        Usuarios.titConfPass= new JLabel("CONFIRMAR PASSWORD");
        Usuarios.ID=new JTextField();
        Usuarios.nombre=new JTextField();
        Usuarios.apellido=new JTextField();
        Usuarios.user=new JTextField();
        Usuarios.password=new JTextField();
        Usuarios.confiPassword=new JTextField();
        Usuarios.rol = new JComboBox();
        Usuarios.crearUsuario=new JButton("CREAR USUARIO");
        Usuarios.regresarDeCrearUsuarioMenu=new JButton("REGRESAR");
        Usuarios.regresarDeTablaMenu=new JButton("REGRESAR");
        
        //titulo crear usuario
        Usuarios.titUS.setBounds(450, 25, 170, 25);
        Usuarios.panel2.add(Usuarios.titUS);
        
        //titulo ID
        Usuarios.titID.setBounds(30, 100, 350, 25);
        Usuarios.panel2.add(Usuarios.titID);
        
        Usuarios.ID.setBounds(30, 140, 350, 25);
        Usuarios.panel2.add(Usuarios.ID);
        
        //titulo nombre
        Usuarios.titNombre.setBounds(30, 180, 170, 25);
        Usuarios.panel2.add(Usuarios.titNombre);
        
        Usuarios.nombre.setBounds(30, 220, 350, 25);
        Usuarios.panel2.add(Usuarios.nombre);
        
        //titulo apellido
        Usuarios.titApellido.setBounds(30, 260, 170, 25);
        Usuarios.panel2.add(Usuarios.titApellido);
        
        Usuarios.apellido.setBounds(30, 300, 350, 25);
        Usuarios.panel2.add(Usuarios.apellido);
        
        //titulo user
        Usuarios.titUser.setBounds(30, 340, 170, 25);
        Usuarios.panel2.add(Usuarios.titUser);
        
        Usuarios.user.setBounds(30, 380, 350, 25);
        Usuarios.panel2.add(Usuarios.user);
        
        //titulo rol
        Usuarios.titRol.setBounds(500, 125, 350, 25);
        Usuarios.panel2.add(Usuarios.titRol);
        
        Usuarios.rol.setBounds(500, 165, 350, 25);
        Usuarios.rol.addItem("Catedratico");
        Usuarios.rol.addItem("Estudiante");
        Usuarios.panel2.add(Usuarios.rol);
        
        //titulo password
        Usuarios.titPassword.setBounds(500, 205, 350, 25);
        Usuarios.panel2.add(Usuarios.titPassword);
        
        Usuarios.password.setBounds(500, 245, 350, 25);
        Usuarios.panel2.add(Usuarios.password);        
        
        //titulo confirmar password
        
        Usuarios.titConfPass.setBounds(500, 285, 350, 25);
        Usuarios.panel2.add(Usuarios.titConfPass);
        
        Usuarios.confiPassword.setBounds(500, 325, 350, 25);
        Usuarios.panel2.add(Usuarios.confiPassword);
        
        //botton agregar
        Usuarios.crearUsuario.setBounds(375, 450, 170, 25);
        Usuarios.panel2.add(Usuarios.crearUsuario);
        
        
        //botton regresar
        
        Usuarios.regresarDeCrearUsuarioMenu.setBounds(700, 25, 170, 25);
        Usuarios.panel2.add(Usuarios.regresarDeCrearUsuarioMenu);
        
       
    }
    
     //metodo que contiene los componentes de la tabla de usuarios
        public static void cargarComponentesPanel3() {
       
       
        Usuarios.modelo.addRow(new Object[]{"73644758490101","Edna","Gudiel","edna16","Estudiante","Enda1616"});
        Usuarios.modelo.addRow(new Object[]{"83498594940101","Cristobal","Acajabon","cris11","Estudiante","Chris123"});
        Usuarios.modelo.addRow(new Object[]{"94499483940101","Clisman","Rocael","clis10","Catedratico","Clis456"});
        
        //tabla.setPreferredScrollableViewportSize(new Dimension(900,1000));
        JScrollPane sc = new JScrollPane(Usuarios.tabla);
        sc.setBounds(10, 10, 925, 300);
        Usuarios.panel3.add(sc);
        
        
        //boton regresar a menu
        Usuarios.regresarDeTablaMenu.setBounds(350, 350, 250, 25);
        Usuarios.panel3.add(Usuarios.regresarDeTablaMenu);
        
        }
        
        //metodo que contiene los componentes del panel para buscar usuario a modificar
        public static void cargarComponentespanelBuscarModificarUsuario() {
        
        Usuarios.titModificarUsuario= new JLabel("MODIFICAR USUARIO");
        Usuarios.titModificarUsuario.setBounds(120, 20, 170, 25);
        Usuarios.panelBuscarModificarUsuario.add(Usuarios.titModificarUsuario);
        
        Usuarios.titIDModificarUsuario=new JLabel("ID");
        Usuarios.titIDModificarUsuario.setBounds(20, 60, 170, 25);
        Usuarios.panelBuscarModificarUsuario.add(Usuarios.titIDModificarUsuario);
                
        Usuarios.txtbuscarModificarUsuario=new JTextField();
        Usuarios.txtbuscarModificarUsuario.setBounds(20, 100, 300, 25);
        Usuarios.panelBuscarModificarUsuario.add(Usuarios.txtbuscarModificarUsuario);
        
        Usuarios.bttbuscarModificarUsuario=new JButton("BUSCAR"); 
        Usuarios.bttbuscarModificarUsuario.setBounds(20, 155, 300, 40);
        Usuarios.panelBuscarModificarUsuario.add(Usuarios.bttbuscarModificarUsuario);
        
        Usuarios.bttregresarbuscarModificarusuario=new JButton("CANCELAR Y REGRESAR");
        Usuarios.bttregresarbuscarModificarusuario.setBounds(20, 225, 300, 40);
        Usuarios.panelBuscarModificarUsuario.add(Usuarios.bttregresarbuscarModificarusuario);
       
        
    }
        
        //metodo que contiene los componentes del panel modificar un usuario
        public static void cargarComponentespanelModificarUsuario() {
            
        Usuarios.tittModificarUsuario= new JLabel("MODIFICAR USUARIO");
        Usuarios.tittModificarUsuario.setBounds(450, 25, 170, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.tittModificarUsuario);
        
        Usuarios.titModificarUsuarioID= new JLabel("ID");
        Usuarios.titModificarUsuarioID.setBounds(30, 100, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.titModificarUsuarioID);
       
        Usuarios.ModificarUsuarioID=new JTextField();
        Usuarios.ModificarUsuarioID.setBounds(30, 140, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.ModificarUsuarioID);
        
        Usuarios.titModificarUsuarioNombre= new JLabel("NOMBRE");
        Usuarios.titModificarUsuarioNombre.setBounds(30, 180, 170, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.titModificarUsuarioNombre);
        
        Usuarios.ModificarUsuarionombre=new JTextField();
        Usuarios.ModificarUsuarionombre.setBounds(30, 220, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.ModificarUsuarionombre);
        
        Usuarios.titModificarUsuarioApellido= new JLabel("APELLIDO");
        Usuarios.titModificarUsuarioApellido.setBounds(30, 260, 170, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.titModificarUsuarioApellido);
        
        Usuarios.ModificarUsuarioapellido=new JTextField();
        Usuarios.ModificarUsuarioapellido.setBounds(30, 300, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.ModificarUsuarioapellido);
        
        Usuarios.titModificarUsuarioUser= new JLabel("USER");
        Usuarios.titModificarUsuarioUser.setBounds(30, 340, 170, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.titModificarUsuarioUser);
        
        Usuarios.ModificarUsuariouser=new JTextField();
        Usuarios.ModificarUsuariouser.setBounds(30, 380, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.ModificarUsuariouser);
        
        Usuarios.titModificarUsuarioRol= new JLabel("ROL");
        Usuarios.titModificarUsuarioRol.setBounds(500, 125, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.titModificarUsuarioRol);
        
        Usuarios.ModificarUsuariorol=new JComboBox();
        Usuarios.ModificarUsuariorol.addItem("Estudiante");
        Usuarios.ModificarUsuariorol.addItem("Catedratico");
        Usuarios.ModificarUsuariorol.setBounds(500, 165, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.ModificarUsuariorol);
        
        Usuarios.titModificarUsuarioPassword= new JLabel("PASSWORD");
        Usuarios.titModificarUsuarioPassword.setBounds(500, 205, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.titModificarUsuarioPassword);
        
        Usuarios.ModificarUsuariopassword=new JTextField();
        Usuarios.ModificarUsuariopassword.setBounds(500, 245, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.ModificarUsuariopassword); 
        
        Usuarios.titModificarUsuarioConfiPassword= new JLabel("CONFIRMAR PASSWORD");
        Usuarios.titModificarUsuarioConfiPassword.setBounds(500, 285, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.titModificarUsuarioConfiPassword);
        
        Usuarios.ModificarUsuarioConfipassword=new JTextField();
        Usuarios.ModificarUsuarioConfipassword.setBounds(500, 325, 350, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.ModificarUsuarioConfipassword);  
        
        Usuarios.bttModificarUsuario=new JButton("MODIFICAR USUARIO");
        Usuarios.bttModificarUsuario.setBounds(100, 450, 300, 40);
        Usuarios.panelModificarUsuario.add(Usuarios.bttModificarUsuario);
        
        Usuarios.bttModificarcancelar=new JButton("CANCELAR");
        Usuarios.bttModificarcancelar.setBounds(475, 450, 300, 40);
        Usuarios.panelModificarUsuario.add(Usuarios.bttModificarcancelar);
        
        Usuarios.bttModificarUsuarioAPrincipal=new JButton("REGRESAR");
        Usuarios.bttModificarUsuarioAPrincipal.setBounds(700, 25, 170, 25);
        Usuarios.panelModificarUsuario.add(Usuarios.bttModificarUsuarioAPrincipal);
        
       
    }
        
        //metodo que contiene los componentes del panel para buscar usuario a eliminar
        public static void cargarComponentespanelBuscarEliminarUsuario() {
            
        Usuarios.titEliminarUsuario= new JLabel("ELIMINAR USUARIO");
        Usuarios.titEliminarUsuario.setBounds(120, 20, 170, 25);
        Usuarios.panelBuscarEliminarUsuario.add(Usuarios.titEliminarUsuario);
        
        Usuarios.titIDeliminarUsuario=new JLabel("ID");
        Usuarios.titIDeliminarUsuario.setBounds(20, 60, 170, 25);
        Usuarios.panelBuscarEliminarUsuario.add(Usuarios.titIDeliminarUsuario);
                
        Usuarios.txtbuscarEliminarUsuario=new JTextField();
        Usuarios.txtbuscarEliminarUsuario.setBounds(20, 100, 300, 25);
        Usuarios.panelBuscarEliminarUsuario.add(Usuarios.txtbuscarEliminarUsuario);
        
        Usuarios.bttbuscarEliminarUsuario=new JButton("BUSCAR"); 
        Usuarios.bttbuscarEliminarUsuario.setBounds(20, 155, 300, 40);
        Usuarios.panelBuscarEliminarUsuario.add(Usuarios.bttbuscarEliminarUsuario);
        
        Usuarios.bttregresarbuscareliminarusuario=new JButton("CANCELAR Y REGRESAR");
        Usuarios.bttregresarbuscareliminarusuario.setBounds(20, 225, 300, 40);
        Usuarios.panelBuscarEliminarUsuario.add(Usuarios.bttregresarbuscareliminarusuario);
        
    }
        
        //metodo que contiene los componentes del panel eliminar un usuario
        public static void cargarComponentespanelEliminarUsuario() {
            
        Usuarios.tittEliminarUsuario= new JLabel("ELIMINAR USUARIO");
        Usuarios.tittEliminarUsuario.setBounds(450, 25, 170, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.tittEliminarUsuario);
        
        Usuarios.titEliminarUsuarioID= new JLabel("ID");
        Usuarios.titEliminarUsuarioID.setBounds(30, 100, 350, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.titEliminarUsuarioID);
       
        Usuarios.EliminarUsuarioID=new JTextField();
        Usuarios.EliminarUsuarioID.setBounds(30, 140, 350, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.EliminarUsuarioID);Usuarios.
        
        titEliminarUsuarioNombre= new JLabel("NOMBRE");
        Usuarios.titEliminarUsuarioNombre.setBounds(30, 180, 170, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.titEliminarUsuarioNombre);
        
        Usuarios.EliminarUsuarionombre=new JTextField();
        Usuarios.EliminarUsuarionombre.setBounds(30, 220, 350, 25);
        Usuarios.EliminarUsuarionombre.enable(false);
        Usuarios.panelEliminarUsuario.add(Usuarios.EliminarUsuarionombre);
        
        Usuarios.titEliminarUsuarioApellido= new JLabel("APELLIDO");
        Usuarios.titEliminarUsuarioApellido.setBounds(30, 260, 170, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.titEliminarUsuarioApellido);
        
        Usuarios.EliminarUsuarioapellido=new JTextField();
        Usuarios.EliminarUsuarioapellido.setBounds(30, 300, 350, 25);
        Usuarios.EliminarUsuarioapellido.enable(false);
        Usuarios.panelEliminarUsuario.add(Usuarios.EliminarUsuarioapellido);
        
        Usuarios.titEliminarUsuarioUser= new JLabel("USER");
        Usuarios.titEliminarUsuarioUser.setBounds(30, 340, 170, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.titEliminarUsuarioUser);
        
        Usuarios.EliminarUsuariouser=new JTextField();
        Usuarios.EliminarUsuariouser.setBounds(30, 380, 350, 25);
        Usuarios.EliminarUsuariouser.enable(false);
        Usuarios.panelEliminarUsuario.add(Usuarios.EliminarUsuariouser);
        
        Usuarios.titEliminarUsuarioRol= new JLabel("ROL");
        Usuarios.titEliminarUsuarioRol.setBounds(500, 125, 350, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.titEliminarUsuarioRol);
        
        Usuarios.EliminarUsuariorol=new JTextField();
        Usuarios.EliminarUsuariorol.setBounds(500, 165, 350, 25);
        Usuarios.EliminarUsuariorol.enable(false);
        Usuarios.panelEliminarUsuario.add(Usuarios.EliminarUsuariorol);
        
        Usuarios.titEliminarUsuarioPassword= new JLabel("PASSWORD");
        Usuarios.titEliminarUsuarioPassword.setBounds(500, 205, 350, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.titEliminarUsuarioPassword);
        
        Usuarios.EliminarUsuariopassword=new JTextField();
        Usuarios.EliminarUsuariopassword.setBounds(500, 245, 350, 25);
        Usuarios.EliminarUsuariopassword.enable(false);
        Usuarios.panelEliminarUsuario.add(Usuarios.EliminarUsuariopassword);  
        
        Usuarios.bttEliminarUsuario=new JButton("ELIMINAR USUARIO");
        Usuarios.bttEliminarUsuario.setBounds(100, 450, 300, 40);
        Usuarios.panelEliminarUsuario.add(Usuarios.bttEliminarUsuario);
        
        Usuarios.bttcancelar=new JButton("CANCELAR");
        Usuarios.bttcancelar.setBounds(475, 450, 300, 40);
        Usuarios.panelEliminarUsuario.add(Usuarios.bttcancelar);
        
        Usuarios.bttEliminarUsuarioAPrincipal=new JButton("REGRESAR");
        Usuarios.bttEliminarUsuarioAPrincipal.setBounds(700, 25, 170, 25);
        Usuarios.panelEliminarUsuario.add(Usuarios.bttEliminarUsuarioAPrincipal);
        
        
        
         
        
    }
    
    /////////////////////////////////////////////////////////////////////BIBLIOGRAFIAS////////////////////////////////////////////////////////////////////
    
    public static void panelCrearBibliografia(){
        
        
        
    Usuarios.titCargaBibliografia=new JLabel("CARGA BIBLIOGRAFICA");
    Usuarios.titCargaBibliografia.setBounds(225, 35, 170, 25);
    Usuarios.panelCrearBibliografia.add(Usuarios.titCargaBibliografia);
    
    Usuarios.bttCargaIndividual=new JButton("CARGA INDIVIDUAL");
    Usuarios.bttCargaIndividual.setBounds(60, 100, 170, 50);
    Usuarios.panelCrearBibliografia.add(Usuarios.bttCargaIndividual);
    
    Usuarios.bttCargaMasiva= new JButton("CARGA MASIVA");
    Usuarios.bttCargaMasiva.setBounds(300, 100, 170, 50);
    Usuarios.panelCrearBibliografia.add(Usuarios.bttCargaMasiva);

    Usuarios.bttRegresarDeCrearBibliografia=new JButton("CANCELAR Y REGRESAR");
    Usuarios.bttRegresarDeCrearBibliografia.setBounds(185, 190, 190, 25);
    Usuarios.panelCrearBibliografia.add(Usuarios.bttRegresarDeCrearBibliografia);
    
        
    }
    
    public static void panelCargaIndividual(){
        
        Usuarios.titCargaIndividual= new JLabel("CARGA INDIVIDUAL");
        Usuarios.titCargaIndividual.setBounds(450, 25, 170, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titCargaIndividual);
        
        //titulo autor
        Usuarios.titAutor= new JLabel("AUTOR");
        Usuarios.titAutor.setBounds(30, 115, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titAutor);
        
        Usuarios.autor=new JTextField();
        Usuarios.autor.setBounds(30, 155, 350, 25);
        Usuarios.autor.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.autor);
        
        //titulo titulo
        Usuarios.titTitulo= new JLabel("TITULO");
        Usuarios.titTitulo.setBounds(30, 195, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titTitulo);
        
        Usuarios.titulo=new JTextField();
        Usuarios.titulo.setBounds(30, 235, 350, 25);
        Usuarios.titulo.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.titulo);
        
        //titulo edicion
        Usuarios.titEdicion= new JLabel("EDICION");
        Usuarios.titEdicion.setBounds(30, 275, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titEdicion);
        
        Usuarios.edicion=new JTextField();
        Usuarios.edicion.setBounds(30, 315, 350, 25);
        Usuarios.edicion.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.edicion);
        
        //titulo descripcion
        Usuarios.titDescripcion= new JLabel("DESCRIPCION");
        Usuarios.titDescripcion.setBounds(30, 355, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titDescripcion);
        
        Usuarios.descripcion=new JTextField();
        Usuarios.descripcion.setBounds(30, 395, 350, 25);
        Usuarios.descripcion.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.descripcion);
        
        //titulo frecuencia
        Usuarios.titFrecuencia = new JLabel("FRECUENCIA");
        Usuarios.titFrecuencia.setBounds(30, 435, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titFrecuencia);
        
        Usuarios.frecuencia=new JTextField();
        Usuarios.frecuencia.setBounds(30, 475, 350, 25);
        Usuarios.frecuencia.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.frecuencia);
        
        //titulo ejemplares
        Usuarios.titEjemplares= new JLabel("EJEMPLARES");
        Usuarios.titEjemplares.setBounds(30, 515, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titEjemplares);
        
        Usuarios.ejemplares=new JTextField();
        Usuarios.ejemplares.setBounds(30, 555, 350, 25);
        Usuarios.ejemplares.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.ejemplares);
        
        //titulo temas
        Usuarios.titTemas= new JLabel("TEMAS");
        Usuarios.titTemas.setBounds(500, 115, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titTemas);
        
        
        Usuarios.temas=new JTextField();
        Usuarios.temas.setBounds(500, 155, 350, 25);
        Usuarios.temas.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.temas);
        
        //titulo palabras clave
        Usuarios.titPalabrasClave= new JLabel("PALABRAS CLAVA");
        Usuarios.titPalabrasClave.setBounds(500, 195, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titPalabrasClave);
        
        Usuarios.palabrasClave=new JTextField();
        Usuarios.palabrasClave.setBounds(500, 235, 350, 25);
        Usuarios.palabrasClave.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.palabrasClave);
        
        //titulo copias
        Usuarios.titCopias= new JLabel("COPIAS");
        Usuarios.titCopias.setBounds(500, 275, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titCopias);
        
        Usuarios.copias=new JTextField();
        Usuarios.copias.setBounds(500, 315, 350, 25);
        Usuarios.copias.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.copias);
        
        //titulo disponibles
        Usuarios.titDisponibles= new JLabel("DISPONIBLES");
        Usuarios.titDisponibles.setBounds(500, 355, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titDisponibles);
        
        Usuarios.disponibles=new JTextField();
        Usuarios.disponibles.setBounds(500, 395, 350, 25);
        Usuarios.disponibles.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.disponibles);
        
        //titulo area
        Usuarios.titArea= new JLabel("AREA");
        Usuarios.titArea.setBounds(500, 435, 350, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.titArea);
        
        Usuarios.area=new JTextField();
        Usuarios.area.setBounds(500, 475, 350, 25);
        Usuarios.area.enable(false);
        Usuarios.panelCargaIndividual.add(Usuarios.area);
        
        Usuarios.rolBibliografia=new JComboBox();
        Usuarios.rolBibliografia.setBounds(700, 75, 170, 25);
        Usuarios.rolBibliografia.addItem("Libro");
        Usuarios.rolBibliografia.addItem("Revista");
        Usuarios.rolBibliografia.addItem("Tesis");
        Usuarios.panelCargaIndividual.add(Usuarios.rolBibliografia);
        
        //botones
        Usuarios.bttcrearBibliografiaIndividual= new JButton("CREAR");
        Usuarios.bttcrearBibliografiaIndividual.setBounds(200, 620, 250, 40);
        Usuarios.panelCargaIndividual.add(Usuarios.bttcrearBibliografiaIndividual);
        
        Usuarios.bttcancelarBibliografiaIndividual= new JButton("CANCELAR");
        Usuarios.bttcancelarBibliografiaIndividual.setBounds(500, 620, 250, 40);
        Usuarios.panelCargaIndividual.add(Usuarios.bttcancelarBibliografiaIndividual);
        
        Usuarios.bttregresarDeCargaIndividual= new JButton("REGRESAR");
        Usuarios.bttregresarDeCargaIndividual.setBounds(700, 25, 170, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.bttregresarDeCargaIndividual);
        
        Usuarios.bttcargar=new JButton("C");
        Usuarios.bttcargar.setBounds(880, 75, 50, 25);
        Usuarios.panelCargaIndividual.add(Usuarios.bttcargar);
    }
    
        //panel para carga masiva
        public static void panelCargaMasiva(){
            
        Usuarios.titCargaMasiva= new JLabel("CARGA MASIVA");
        Usuarios.titCargaMasiva.setBounds(450, 25, 170, 25);
        Usuarios.panelCargaMasiva.add(Usuarios.titCargaMasiva);
        
        Usuarios.txtarea= new JTextArea();
        Usuarios.txtarea.setBounds(30, 100, 890, 300);
        Usuarios.panelCargaMasiva.add(Usuarios.txtarea);
        
        Usuarios.bttcrearBibliografiaMasiva=new JButton("CARGAR");
        Usuarios.bttcrearBibliografiaMasiva.setBounds(200, 440, 170, 40);
        Usuarios.panelCargaMasiva.add(Usuarios.bttcrearBibliografiaMasiva);
        
        Usuarios.bttcancelarBibliografiaMasiva=new JButton("CANCELAR Y LIMPIAR");
        Usuarios.bttcancelarBibliografiaMasiva.setBounds(550, 440, 170, 40);
        Usuarios.panelCargaMasiva.add(Usuarios.bttcancelarBibliografiaMasiva);
        
        Usuarios.bttregresarDeCargaMasiva=new JButton("REGRESAR");
        Usuarios.bttregresarDeCargaMasiva.setBounds(700, 25, 170, 25);
        Usuarios.panelCargaMasiva.add(Usuarios.bttregresarDeCargaMasiva);
            
            
        }
        
        //panel ver bibliografias
        public static void panelVerBibliografias(){
        
        Usuarios.modelo2.addRow(new Object[]{"0","Lisa","Algebra","3","Estudia la combinación de elementos de estructuras abstractas acorde a ciertas reglas","----","----","polinomios,ecuaciones,fracciones","inecuaciones,grado","----","8","4"});
        Usuarios.modelo2.addRow(new Object[]{"0","Cecelia","Programacion","2","es el proceso de diseñar, codificar, depurar y mantener el código fuente de programas de computadora","----","----","java,c++,visual","codigo,lenguaje","----","9","4"});
        Usuarios.modelo2.addRow(new Object[]{"0","Ayad","Quimica","5","estudia tanto la composición, como la estructura y las propiedades de la materia","----","----","experimentos,transformacion","composicion,descomposicion,clima","----","6","2"});
        Usuarios.modelo2.addRow(new Object[]{"0","Akhtar","Fisica","6","establece las leyes que explican los fenómenos naturales","----","----","conversiones,cinematica,electricidad","fuerzas,energia","----","5","2"});
        
        Usuarios.modelo2.addRow(new Object[]{"1","Adeline","electronica","4","estudia y emplea sistemas cuyo funcionamiento se basa en la conducción y el control del flujo","3 meses","6","circuitos,telecomunicaciones,ecuaciones","control,flujo,energia","----","7","3"});
        Usuarios.modelo2.addRow(new Object[]{"1","Abella","Economia","7","estudia los recursos, la creación de riqueza y la producción","2 meses","4","produccion,riqueza,creacion","comercio,bienes,sociedad,grado","----","9","4"});
        Usuarios.modelo2.addRow(new Object[]{"1","Aguilis","Historia","1","estudia y expone, de acuerdo con determinados principios y métodos","15 dias","15","arqueologia,arte,musica,visual","desarrollar,geografia,lenguaje","----","4","2"});
        Usuarios.modelo2.addRow(new Object[]{"1","Ahren","Nutricion","3","Conjunto de procesos, hábitos, etc.","1 mes","8","habitos,higiene,alimentacion","nutrir,alimentar","----","3","3"});
        
        Usuarios.modelo2.addRow(new Object[]{"2","Alguersuari","Ecologia","2","El discurso de los diarios La República y Correo sobre el cambio climático en el contexto","----","----","Ambiente,clima,habitos","calor,lluvia,estacion,descomposicion","Usac","4","3"});
        Usuarios.modelo2.addRow(new Object[]{"2","Almudena","Matematica","8","Estudia las propiedades y relaciones entre entidades abstractas como números, figuras geométricas","----","----","Geometria,fracciones,ecuaciones,visual","expresiones,inecuaciones,decimales","Usac","6","2"});
        Usuarios.modelo2.addRow(new Object[]{"2","Evangelyne","Tecnologia","7","Conjunto de los conocimientos propios de una técnica","----","----","musica,electricidad,java,materiales,polinomios","codigo,formato,mecanismo","Usac","5","3"});
        Usuarios.modelo2.addRow(new Object[]{"2","Amaya","Comunicaciones","2","Transmisión de señales mediante un código común al emisor y al receptor","----","----","Cultura,comercio,genero,nutrir,produccion","analisis,energia,composicion","Usac","6","5"});
        
        
        Usuarios.txtVerBibliografias=new JLabel("BIBLIOGRAFIAS");
        Usuarios.txtVerBibliografias.setBounds(400, 10, 170, 75);
        Usuarios.panelVerBibliografias.add(Usuarios.txtVerBibliografias);
        
        Usuarios.txtbuscar=new JLabel("Buscar por medio de: ");
        Usuarios.txtbuscar.setBounds(30, 90, 170, 25);
        Usuarios.panelVerBibliografias.add(Usuarios.txtbuscar);
        
        Usuarios.filtro=new JTextField();
        Usuarios.filtro.setBounds(375, 90, 170, 25);
        Usuarios.panelVerBibliografias.add(Usuarios.filtro);
            
        JScrollPane sc2 = new JScrollPane(Usuarios.tabla2);
        sc2.setBounds(10, 150, 925, 300);
        Usuarios.panelVerBibliografias.add(sc2);
        
        Usuarios.rolVerBibliografia=new JComboBox();
        Usuarios.rolVerBibliografia.setBounds(175, 90, 170, 25);
        Usuarios.rolVerBibliografia.addItem("Tipo");
        Usuarios.rolVerBibliografia.addItem("Autor");
        Usuarios.rolVerBibliografia.addItem("Palabras Clave");
        Usuarios.rolVerBibliografia.addItem("Tema");
        Usuarios.panelVerBibliografias.add(Usuarios.rolVerBibliografia);
        
        Usuarios.regresarDeVerBibliografia=new JButton("Regresar");
        Usuarios.regresarDeVerBibliografia.setBounds(700, 25, 170, 25);
        Usuarios.panelVerBibliografias.add(Usuarios.regresarDeVerBibliografia);
        
          
            
        }
        
        //panel para modificar bibliografias
        public static void panelModificarBibliografias(){
            
        Usuarios.titModifiarBibliografia=new JLabel("MODIFICAR BIBLIOGRAFIAS");
        Usuarios.titModifiarBibliografia.setBounds(400, 10, 170, 75);
        Usuarios.panelModificarBibliografias.add(Usuarios.titModifiarBibliografia);
        
        JScrollPane sc3 = new JScrollPane(Usuarios.tabla3);
        sc3.setBounds(10, 75, 925, 300);
        Usuarios.panelModificarBibliografias.add(sc3);
        
        //tipo
        Usuarios.txtModificarTipo=new JLabel("TIPO");
        Usuarios.txtModificarTipo.setBounds(75, 375, 170, 75);
        Usuarios.panelModificarBibliografias.add(Usuarios.txtModificarTipo);
        
        Usuarios.ModiTipo=new JTextField();
        Usuarios.ModiTipo.setBounds(10, 430, 170, 25);
        Usuarios.panelModificarBibliografias.add(Usuarios.ModiTipo);
        
        //palabras
        Usuarios.txtModificarPalablras=new JLabel("PALABRAS CLAVE");
        Usuarios.txtModificarPalablras.setBounds(420, 375, 170, 75);
        Usuarios.panelModificarBibliografias.add(Usuarios.txtModificarPalablras);
        
        Usuarios.ModiPalabras=new JTextField();
        Usuarios.ModiPalabras.setBounds(320, 430, 300, 25);
        Usuarios.panelModificarBibliografias.add(Usuarios.ModiPalabras);
        
        
        //copias
        Usuarios.txtModificarCopias=new JLabel("COPIAS");
        Usuarios.txtModificarCopias.setBounds(830, 375, 170, 75);
        Usuarios.panelModificarBibliografias.add(Usuarios.txtModificarCopias);
        
        Usuarios.ModiCopias=new JTextField();
        Usuarios.ModiCopias.setBounds(770, 430, 170, 25);
        Usuarios.panelModificarBibliografias.add(Usuarios.ModiCopias);
        
        //descripcion
        Usuarios.txtModificarDescripcion=new JLabel("DESCRIPCION");
        Usuarios.txtModificarDescripcion.setBounds(410, 450, 170, 75);
        Usuarios.panelModificarBibliografias.add(Usuarios.txtModificarDescripcion);
        
        Usuarios.ModiDescripcion=new JTextField();
        Usuarios.ModiDescripcion.setBounds(200, 500, 550, 25);
        Usuarios.panelModificarBibliografias.add(Usuarios.ModiDescripcion);
        
        //botones
        Usuarios.modificarBibliografia=new JButton("MODIFICAR");
        Usuarios.modificarBibliografia.setBounds(190, 575, 170, 40);
        Usuarios.panelModificarBibliografias.add(Usuarios.modificarBibliografia);
        
        Usuarios.aceptarModificarBibliografia=new JButton("ACEPTAR");
        Usuarios.aceptarModificarBibliografia.setBounds(390, 575, 170, 40);
        Usuarios.panelModificarBibliografias.add(Usuarios.aceptarModificarBibliografia);
        
        Usuarios.cancelarModificarBibliografia=new JButton("CANCELAR Y LIMPIAR");
        Usuarios.cancelarModificarBibliografia.setBounds(590, 575, 170, 40);
        Usuarios.panelModificarBibliografias.add(Usuarios.cancelarModificarBibliografia);
        
        Usuarios.regresarDeModificarBibliografia=new JButton("Regresar");
        Usuarios.regresarDeModificarBibliografia.setBounds(700, 25, 170, 25);
        Usuarios.panelModificarBibliografias.add(Usuarios.regresarDeModificarBibliografia);
            
        }
        
        //panel eliminar bibliografia
        public static void panelEliminarBibliografias(){
            
            Usuarios.titEliminarBibliografia=new JLabel("ELIMINAR BIBLIOGRAFIAS");
        Usuarios.titEliminarBibliografia.setBounds(400, 10, 170, 75);
        Usuarios.panelEliminarBibliografias.add(Usuarios.titEliminarBibliografia);
          
        JScrollPane sc4 = new JScrollPane(Usuarios.tabla4);
        sc4.setBounds(10, 75, 925, 300);
        Usuarios.panelEliminarBibliografias.add(sc4);
        
        Usuarios.eliminarBibliografia=new JButton("ELIMINAR");
        Usuarios.eliminarBibliografia.setBounds(390, 400, 170, 40);
        Usuarios.panelEliminarBibliografias.add(Usuarios.eliminarBibliografia);
        
        Usuarios.regresarDeEliminarBibliografia=new JButton("Regresar");
        Usuarios.regresarDeEliminarBibliografia.setBounds(700, 25, 170, 25);
        Usuarios.panelEliminarBibliografias.add(Usuarios.regresarDeEliminarBibliografia);
            
        }
    
        //////////////////////////////////////////////////////////////PRESTAMOS/////////////////////////////////////////////////////////////////////////////

        public static void panelCrearPrestamos(){
            
            Usuarios.titCrearPrestamos=new JLabel("CREAR PRESTAMOS - ADMINISTRADOR");
            Usuarios.titCrearPrestamos.setBounds(375, 10, 275, 75);
            Usuarios.panelCrearPrestamos.add(Usuarios.titCrearPrestamos);
            
            Usuarios.titBuscarCrearPrestamo=new JLabel("Buscar por: ");
            Usuarios.titBuscarCrearPrestamo.setBounds(20, 60, 175, 75);
            Usuarios.panelCrearPrestamos.add(Usuarios.titBuscarCrearPrestamo);
              
            Usuarios.rolCrearPrestamo=new JComboBox();
            Usuarios.rolCrearPrestamo.setBounds(100, 85, 175, 25);
            Usuarios.rolCrearPrestamo.addItem("Autor");
            Usuarios.rolCrearPrestamo.addItem("Titulo");
            Usuarios.rolCrearPrestamo.addItem("Palabras Clave");
            Usuarios.panelCrearPrestamos.add(Usuarios.rolCrearPrestamo);
            
            Usuarios.filtro2=new JTextField();
            Usuarios.filtro2.setBounds(300, 85, 175, 25);
            Usuarios.panelCrearPrestamos.add(Usuarios.filtro2);
            
            JScrollPane sc5 = new JScrollPane(Usuarios.tabla5);
            sc5.setBounds(10, 130, 925, 300);
            Usuarios.panelCrearPrestamos.add(sc5);
            
            Usuarios.hacerPrestamo=new JButton("HACER PRESTAMO");
            Usuarios.hacerPrestamo.setBounds(390, 450, 175, 40);
            Usuarios.panelCrearPrestamos.add(Usuarios.hacerPrestamo);
            
            Usuarios.regresarDeHacerPrestamo=new JButton("REGRESAR");
            Usuarios.regresarDeHacerPrestamo.setBounds(700, 25, 170, 25);
            Usuarios.panelCrearPrestamos.add(Usuarios.regresarDeHacerPrestamo);
            
            
            
        }
        
        public static void panelAsignarPrestamo(){
            
            Usuarios.titAsignarPrestamo=new JLabel("ASIGNAR PRESTAMO A USUARIO");
            Usuarios.titAsignarPrestamo.setBounds(75, 20, 275, 75);
            Usuarios.panelAsignarPrestamo.add(Usuarios.titAsignarPrestamo);
            
            Usuarios.rolAsignarPrestamo=new JComboBox();
            Usuarios.rolAsignarPrestamo.setBounds(20, 95, 290, 25);
            Usuarios.panelAsignarPrestamo.add(Usuarios.rolAsignarPrestamo);
            
            Usuarios.asignarPrestamoUsuario=new JButton("CREAR PRESTAMO");
            Usuarios.asignarPrestamoUsuario.setBounds(20, 145, 290, 40);
            Usuarios.panelAsignarPrestamo.add(Usuarios.asignarPrestamoUsuario);
            
            Usuarios.cancelarAsignarPrestamoUsuario=new JButton("CANCELAR");
            Usuarios.cancelarAsignarPrestamoUsuario.setBounds(20, 205, 290, 40);
            Usuarios.panelAsignarPrestamo.add(Usuarios.cancelarAsignarPrestamoUsuario);
            
        }
        
        public static void panelmodificarPrestamo2(){
            
            Usuarios.txtSelecBib=new JLabel("SELECCIONE BIBLIOGRAFIA");
            Usuarios.txtSelecBib.setBounds(75, 20, 275, 75);
            Usuarios.panelModificarPrestamos2.add(Usuarios.txtSelecBib);
            
            Usuarios.rolModiPrestamo=new JComboBox();
            Usuarios.rolModiPrestamo.setBounds(20, 95, 290, 25);
            Usuarios.panelModificarPrestamos2.add(Usuarios.rolModiPrestamo);
            
            Usuarios.ModiPrestamo2=new JButton("MODIFICAR PRESTAMO");
            Usuarios.ModiPrestamo2.setBounds(20, 145, 290, 40);
            Usuarios.panelModificarPrestamos2.add(Usuarios.ModiPrestamo2);
            
            Usuarios.regresarDeModiPrestamo2=new JButton("CANCELAR Y REGRESAR");
            Usuarios.regresarDeModiPrestamo2.setBounds(20, 205, 290, 40);
            Usuarios.panelModificarPrestamos2.add(Usuarios.regresarDeModiPrestamo2);
            
        }
        
        public static void panelVerPrestamos(){
            
        Usuarios.modelo3.addRow(new Object[]{"0","Cecelia","Programacion","Edna","9","4","25/03/2018","07:54:12","7"});
        Usuarios.modelo3.addRow(new Object[]{"1","Abella","Economia","Cristobal","9","4","24/03/2018","10:38:32","9"});
        Usuarios.modelo3.addRow(new Object[]{"2","Evangelyne","Tecnologia","Clisman","5","3","27/03/2018","09:24:37","8"});
        
        Usuarios.modelo3.addRow(new Object[]{"0","Ayad","Quimica","Cristobal","6","2","24/03/2018","13:57:43","12"});
        Usuarios.modelo3.addRow(new Object[]{"1","Aguilis","Historia","Clisman","4","2","29/03/2018","16:05:49","10"});
        Usuarios.modelo3.addRow(new Object[]{"2","Almudena","Matematica","Edna","6","2","20/03/2018","17:35:18","14"});
        
        Usuarios.modelo3.addRow(new Object[]{"0","Akhar","Fisica","Clisman","5","2","18/03/2018","08:32:46","15"});
        Usuarios.modelo3.addRow(new Object[]{"1","Adeline","electronica","Edna","7","3","22/03/2018","09:24:59","7"});
        Usuarios.modelo3.addRow(new Object[]{"2","Amaya","Comunicaciones","Cristobal","6","5","26/03/2018","11:18:47","12"});
        
        Usuarios.modelo3.addRow(new Object[]{"0","Akhar","Fisica","Edna","5","2","18/03/2018","08:32:46","Devolucion"});
        Usuarios.modelo3.addRow(new Object[]{"0","Akhar","Fisica","Cristobal","5","2","18/03/2018","08:32:46","Devolucion"});
        
        Usuarios.modelo3.addRow(new Object[]{"1","Adeline","electronica","Clisman","7","3","22/03/2018","09:24:59","Devolucion"});
        Usuarios.modelo3.addRow(new Object[]{"1","Adeline","electronica","Cristobal","7","3","22/03/2018","09:24:59","Devolucion"});
        
        Usuarios.modelo3.addRow(new Object[]{"2","Amaya","Comunicaciones","Edna","6","5","26/03/2018","11:18:47","Devolucion"});
        Usuarios.modelo3.addRow(new Object[]{"2","Amaya","Comunicaciones","Clisman","6","5","26/03/2018","11:18:47","Devolucion"});
            
        Usuarios.txtPrestamos=new JLabel("PRESTAMOS");
        Usuarios.txtPrestamos.setBounds(450, 25, 170, 25);
        Usuarios.panelVerPrestamos.add(Usuarios.txtPrestamos);
        
        Usuarios.regresarDeVerPrestamos=new JButton("REGRESAR");
        Usuarios.regresarDeVerPrestamos.setBounds(700, 25, 170, 25);
        Usuarios.panelVerPrestamos.add(Usuarios.regresarDeVerPrestamos);
            
        JScrollPane sc6 = new JScrollPane(Usuarios.tabla6);
        sc6.setBounds(10, 80, 925, 300);
        Usuarios.panelVerPrestamos.add(sc6);
            
        }
        
        public static void panelModificarPrestamos(){
            
        Usuarios.txtModificarPrestamos=new JLabel("MODIFICAR PRESTAMOS");
        Usuarios.txtModificarPrestamos.setBounds(450, 25, 170, 25);
        Usuarios.panelModificarPrestamos.add(Usuarios.txtModificarPrestamos); 
        
        JScrollPane sc7 = new JScrollPane(Usuarios.tabla7);
        sc7.setBounds(10, 80, 925, 300);
        Usuarios.panelModificarPrestamos.add(sc7);
        
        Usuarios.ModificarPrestamo=new JButton("MODIFICAR");
        Usuarios.ModificarPrestamo.setBounds(385, 425, 200, 40);
        Usuarios.panelModificarPrestamos.add(Usuarios.ModificarPrestamo);
        
        Usuarios.regresarDeModificarPrestamo=new JButton("REGRESAR");
        Usuarios.regresarDeModificarPrestamo.setBounds(700, 25, 170, 25);
        Usuarios.panelModificarPrestamos.add(Usuarios.regresarDeModificarPrestamo);
            
        }
        
        public static void panelEliminarPrestamos(){
         
        Usuarios.txtEliminarPrestamos=new JLabel("ELIMINAR PRESTAMOS");
        Usuarios.txtEliminarPrestamos.setBounds(450, 25, 170, 25);
        Usuarios.PanelEliminarPrestamos.add(Usuarios.txtEliminarPrestamos); 
        
        JScrollPane sc8 = new JScrollPane(Usuarios.tabla8);
        sc8.setBounds(10, 80, 925, 300);
        Usuarios.PanelEliminarPrestamos.add(sc8);
        
        Usuarios.EliminarPrestamo=new JButton("ELIMINAR");
        Usuarios.EliminarPrestamo.setBounds(385, 425, 200, 40);
        Usuarios.PanelEliminarPrestamos.add(Usuarios.EliminarPrestamo);
        
        Usuarios.regresarDeEliminarPrestamo=new JButton("REGRESAR");
        Usuarios.regresarDeEliminarPrestamo.setBounds(700, 25, 170, 25);
        Usuarios.PanelEliminarPrestamos.add(Usuarios.regresarDeEliminarPrestamo);
            
        }
        
    ////////////////////////////////////////////////////////////////INTEFAZ USUARIO/////////////////////////////////////////////////////////////////////
        
        public static void panelInterfazUsuario(){
        
        Usuarios.modelo4.addRow(new Object[]{"0","Lisa","Algebra","3","Estudia la combinación de elementos de estructuras abstractas acorde a ciertas reglas","----","----","polinomios,ecuaciones,fracciones","inecuaciones,grado","----","8","4",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"0","Cecelia","Programacion","2","es el proceso de diseñar, codificar, depurar y mantener el código fuente de programas de computadora","----","----","java,c++,visual","codigo,lenguaje","----","9","4",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"0","Ayad","Quimica","5","estudia tanto la composición, como la estructura y las propiedades de la materia","----","----","experimentos,transformacion","composicion,descomposicion,clima","----","6","2",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"0","Akhtar","Fisica","6","establece las leyes que explican los fenómenos naturales","----","----","conversiones,cinematica,electricidad","fuerzas,energia","----","5","2",Usuarios.btn1});
        
        Usuarios.modelo4.addRow(new Object[]{"1","Adeline","electronica","4","estudia y emplea sistemas cuyo funcionamiento se basa en la conducción y el control del flujo","3 meses","6","circuitos,telecomunicaciones,ecuaciones","control,flujo,energia","----","7","3",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"1","Abella","Economia","7","estudia los recursos, la creación de riqueza y la producción","2 meses","4","produccion,riqueza,creacion","comercio,bienes,sociedad,grado","----","9","4",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"1","Aguilis","Historia","1","estudia y expone, de acuerdo con determinados principios y métodos","15 dias","15","arqueologia,arte,musica,visual","desarrollar,geografia,lenguaje","----","4","2",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"1","Ahren","Nutricion","3","Conjunto de procesos, hábitos, etc.","1 mes","8","habitos,higiene,alimentacion","nutrir,alimentar","----","3","3",Usuarios.btn1});
        
        Usuarios.modelo4.addRow(new Object[]{"2","Alguersuari","Ecologia","2","El discurso de los diarios La República y Correo sobre el cambio climático en el contexto","----","----","Ambiente,clima,habitos","calor,lluvia,estacion,descomposicion","Usac","4","3",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"2","Almudena","Matematica","8","Estudia las propiedades y relaciones entre entidades abstractas como números, figuras geométricas","----","----","Geometria,fracciones,ecuaciones,visual","expresiones,inecuaciones,decimales","Usac","6","2",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"2","Evangelyne","Tecnologia","7","Conjunto de los conocimientos propios de una técnica","----","----","musica,electricidad,java,materiales,polinomios","codigo,formato,mecanismo","Usac","5","3",Usuarios.btn1});
        Usuarios.modelo4.addRow(new Object[]{"2","Amaya","Comunicaciones","2","Transmisión de señales mediante un código común al emisor y al receptor","----","----","Cultura,comercio,genero,nutrir,produccion","analisis,energia,composicion","Usac","6","5",Usuarios.btn1});
          
        JScrollPane sc9 = new JScrollPane(Usuarios.tabla9);
        sc9.setBounds(10, 250, 1200, 300);
        Usuarios.panelInterfazUsuario.add(sc9);
        
        Usuarios.titBuscarEnUsuario=new JLabel("BUSCAR POR MEDIO DE:");
        Usuarios.titBuscarEnUsuario.setBounds(30, 200, 170, 25);
        Usuarios.panelInterfazUsuario.add(Usuarios.titBuscarEnUsuario);
        
        Usuarios.rolUsuario=new JComboBox();
        Usuarios.rolUsuario.setBounds(175, 200, 170, 25);
        Usuarios.rolUsuario.addItem("Autor");
        Usuarios.rolUsuario.addItem("Titulo");
        Usuarios.rolUsuario.addItem("Palabras Clave");
        Usuarios.panelInterfazUsuario.add(Usuarios.rolUsuario);
        
        Usuarios.filtro3=new JTextField();
        Usuarios.filtro3.setBounds(375, 200, 170, 25);
        Usuarios.panelInterfazUsuario.add(Usuarios.filtro3);
        
        Usuarios.logoutUsuario=new JButton("LOGOUT");
        Usuarios.logoutUsuario.setBounds(1000, 25, 170, 40);
        Usuarios.panelInterfazUsuario.add(Usuarios.logoutUsuario);
        
        Usuarios.BibliotecaVirtual=new JButton("VER MI BIBLIOTECA VIRTUAL");
        Usuarios.BibliotecaVirtual.setBounds(970, 110, 225, 60);
        Usuarios.panelInterfazUsuario.add(Usuarios.BibliotecaVirtual);
            
        }
        
        //////////////////////////////////////////////////////////////USUARIO 1/////////////////////////////////////////////////////////////////////////////

        public static void panelUsuario1(){
        
        
        Usuarios.modelo5.addRow(new Object[]{"0","Cecelia","Programacion","2","es el proceso de diseñar, codificar, depurar y mantener el código fuente de programas de computadora","java,c++,visual","codigo,lenguaje","9","4","25/03/2018","07:54:12",false});
        Usuarios.modelo6.addRow(new Object[]{"1","Adeline","electronica","4","estudia y emplea sistemas cuyo funcionamiento se basa en la conducción y el control del flujo","3 meses","6","circuitos,telecomunicaciones,ecuaciones","control,flujo,energia","7","3","22/03/2018","09:24:59",false});
        Usuarios.modelo7.addRow(new Object[]{"2","Almudena","Matematica","8","Estudia las propiedades y relaciones entre entidades abstractas como números, figuras geométricas","Geometria,fracciones,ecuaciones,visual","expresiones,inecuaciones,decimales","Usac","6","2","20/03/2018","17:35:18",false});
        
        Usuarios.usuario1Libros=new JLabel("LIBROS");
        Usuarios.usuario1Libros.setBounds(20, 30, 170, 25);
        Usuarios.panelUsuario1.add(Usuarios.usuario1Libros);   
            
        JScrollPane sc10 = new JScrollPane(Usuarios.tabla10);
        sc10.setBounds(10, 60, 850, 200);
        Usuarios.panelUsuario1.add(sc10);
        
        Usuarios.usuario1Revistas=new JLabel("REVISTAS");
        Usuarios.usuario1Revistas.setBounds(20, 275, 170, 25);
        Usuarios.panelUsuario1.add(Usuarios.usuario1Revistas); 
        
        JScrollPane sc11 = new JScrollPane(Usuarios.tabla11);
        sc11.setBounds(10, 305, 850, 200);
        Usuarios.panelUsuario1.add(sc11);
        
        Usuarios.usuario1Tesis=new JLabel("TESIS");
        Usuarios.usuario1Tesis.setBounds(20, 520, 170, 25);
        Usuarios.panelUsuario1.add(Usuarios.usuario1Tesis); 
        
        JScrollPane sc12 = new JScrollPane(Usuarios.tabla12);
        sc12.setBounds(10, 550, 850, 200);
        Usuarios.panelUsuario1.add(sc12);
        
        Usuarios.buscar1=new JLabel("BUSCAR POR :");
        Usuarios.buscar1.setBounds(1000, 360, 170, 25);
        Usuarios.panelUsuario1.add(Usuarios.buscar1); 
        
        Usuarios.rolUsuario1=new JComboBox();
        Usuarios.rolUsuario1.addItem("Autor");
        Usuarios.rolUsuario1.addItem("Titulo");
        Usuarios.rolUsuario1.setBounds(940, 400, 200, 25);
        Usuarios.panelUsuario1.add(Usuarios.rolUsuario1);         
                
        Usuarios.filtro4=new JTextField();
        Usuarios.filtro4.setBounds(920, 440, 250, 25);
        Usuarios.panelUsuario1.add(Usuarios.filtro4); 
        
        Usuarios.reportePrestamos1=new JButton("REPORTE DE PRESTAMOS");
        Usuarios.reportePrestamos1.setBounds(940, 525, 200, 40);
        Usuarios.panelUsuario1.add(Usuarios.reportePrestamos1);
        
        Usuarios.devolucionLibros1=new JButton("DEVOLUCION DE BIBLIOGRAFIA");
        Usuarios.devolucionLibros1.setBounds(940, 585, 200, 40);
        Usuarios.panelUsuario1.add(Usuarios.devolucionLibros1);
        
        Usuarios.regresarDeUsuario1=new JButton("REGRESAR");
        Usuarios.regresarDeUsuario1.setBounds(975, 20, 200, 25);
        Usuarios.panelUsuario1.add(Usuarios.regresarDeUsuario1); 
            
        }
//////////////////////////////////////////////////////////////REPORTE USUARIO 1/////////////////////////////////////////////////////////////////////////////

        public static void panelReporteUsuario1(){
        
        Usuarios.modelo8.addRow(new Object[]{"0","Cecelia","Programacion","Edna Gudiel","25/03/2018","07:54:12"});
        Usuarios.modelo8.addRow(new Object[]{"1","Adeline","electronica","Edna Gudiel","22/03/2018","09:24:59"});
        Usuarios.modelo8.addRow(new Object[]{"2","Almudena","Matematica","Edna Gudiel","20/03/2018","17:35:18"});
            
        Usuarios.modelo9.addRow(new Object[]{"0","Akhar","Fisica","Edna Gudiel","18/03/2018","08:32:46"});
        Usuarios.modelo9.addRow(new Object[]{"2","Amaya","Comunicaciones","Edna Gudiel","26/03/2018","11:18:47"});
           
        Usuarios.txtprestamos1=new JLabel("Prestamos hechos:");
        Usuarios.txtprestamos1.setBounds(20, 50, 200, 25);
        Usuarios.panelReporteUsuario1.add(Usuarios.txtprestamos1);     
        
        JScrollPane sc13 = new JScrollPane(Usuarios.tabla13);
        sc13.setBounds(10, 80, 850, 100);
        Usuarios.panelReporteUsuario1.add(sc13);
        
        Usuarios.txtdevoluciones1=new JLabel("Devoluciones:");
        Usuarios.txtdevoluciones1.setBounds(20, 200, 200, 25);
        Usuarios.panelReporteUsuario1.add(Usuarios.txtdevoluciones1);
        
        JScrollPane sc14 = new JScrollPane(Usuarios.tabla14);
        sc14.setBounds(10, 230, 850, 100);
        Usuarios.panelReporteUsuario1.add(sc14);
        
        Usuarios.txtmodificaciones1=new JLabel("Modificaciones:");
        Usuarios.txtmodificaciones1.setBounds(20, 350, 200, 25);
        Usuarios.panelReporteUsuario1.add(Usuarios.txtmodificaciones1);
        
        JScrollPane sc15 = new JScrollPane(Usuarios.tabla15);
        sc15.setBounds(10, 380, 850, 100);
        Usuarios.panelReporteUsuario1.add(sc15);
        
        Usuarios.txteliminado1=new JLabel("Eliminadas:");
        Usuarios.txteliminado1.setBounds(20, 500, 200, 25);
        Usuarios.panelReporteUsuario1.add(Usuarios.txteliminado1);
        
        JScrollPane sc16 = new JScrollPane(Usuarios.tabla16);
        sc16.setBounds(10, 530, 850, 100);
        Usuarios.panelReporteUsuario1.add(sc16);
        
        Usuarios.regresarReporteUsuario1=new JButton("REGRESAR");
        Usuarios.regresarReporteUsuario1.setBounds(650, 20, 200, 25);
        Usuarios.panelReporteUsuario1.add(Usuarios.regresarReporteUsuario1);
            
        }
        
        //////////////////////////////////////////////////////////////USUARIO 2/////////////////////////////////////////////////////////////////////////////

        public static void panelUsuario2(){
        
        
        Usuarios.modelo12.addRow(new Object[]{"0","Ayad","Quimica","5","estudia tanto la composición, como la estructura y las propiedades de la materia","experimentos,transformacion","composicion,descomposicion,clima","6","2","24/03/2018","13:57:43",false});
        Usuarios.modelo13.addRow(new Object[]{"1","Abella","Economia","7","estudia los recursos, la creación de riqueza y la producción","2 meses","4","produccion,riqueza,creacion","comercio,bienes,sociedad,grado","9","4","24/03/2018","10:38:32",false});
        Usuarios.modelo14.addRow(new Object[]{"2","Amaya","Comunicaciones","2","Transmisión de señales mediante un código común al emisor y al receptor","Cultura,comercio,genero,nutrir,produccion","analisis,energia,composicion","Usac","6","2","26/03/2018","11:18:47",false});
        
        Usuarios.usuario2Libros=new JLabel("LIBROS");
        Usuarios.usuario2Libros.setBounds(20, 30, 170, 25);
        Usuarios.panelUsuario2.add(Usuarios.usuario2Libros);   
            
        JScrollPane sc17 = new JScrollPane(Usuarios.tabla17);
        sc17.setBounds(10, 60, 850, 200);
        Usuarios.panelUsuario2.add(sc17);
        
        Usuarios.usuario2Revistas=new JLabel("REVISTAS");
        Usuarios.usuario2Revistas.setBounds(20, 275, 170, 25);
        Usuarios.panelUsuario2.add(Usuarios.usuario2Revistas); 
        
        JScrollPane sc18 = new JScrollPane(Usuarios.tabla18);
        sc18.setBounds(10, 305, 850, 200);
        Usuarios.panelUsuario2.add(sc18);
        
        Usuarios.usuario2Tesis=new JLabel("TESIS");
        Usuarios.usuario2Tesis.setBounds(20, 520, 170, 25);
        Usuarios.panelUsuario2.add(Usuarios.usuario2Tesis); 
        
        JScrollPane sc19 = new JScrollPane(Usuarios.tabla19);
        sc19.setBounds(10, 550, 850, 200);
        Usuarios.panelUsuario2.add(sc19);
        
        Usuarios.buscar2=new JLabel("BUSCAR POR :");
        Usuarios.buscar2.setBounds(1000, 360, 170, 25);
        Usuarios.panelUsuario2.add(Usuarios.buscar2); 
        
        Usuarios.rolUsuario2=new JComboBox();
        Usuarios.rolUsuario2.addItem("Autor");
        Usuarios.rolUsuario2.addItem("Titulo");
        Usuarios.rolUsuario2.setBounds(940, 400, 200, 25);
        Usuarios.panelUsuario2.add(Usuarios.rolUsuario2);         
                
        Usuarios.filtro5=new JTextField();
        Usuarios.filtro5.setBounds(920, 440, 250, 25);
        Usuarios.panelUsuario2.add(Usuarios.filtro5); 
        
        Usuarios.reportePrestamos2=new JButton("REPORTE DE PRESTAMOS");
        Usuarios.reportePrestamos2.setBounds(940, 525, 200, 40);
        Usuarios.panelUsuario2.add(Usuarios.reportePrestamos2);
        
        Usuarios.devolucionLibros2=new JButton("DEVOLUCION DE BIBLIOGRAFIA");
        Usuarios.devolucionLibros2.setBounds(940, 585, 200, 40);
        Usuarios.panelUsuario2.add(Usuarios.devolucionLibros2);
        
        Usuarios.regresarDeUsuario2=new JButton("REGRESAR");
        Usuarios.regresarDeUsuario2.setBounds(975, 20, 200, 25);
        Usuarios.panelUsuario2.add(Usuarios.regresarDeUsuario2); 
            
        }
        
        //////////////////////////////////////////////////////////////REPORTE USUARIO 2/////////////////////////////////////////////////////////////////////////////

        public static void panelReporteUsuario2(){
        
        Usuarios.modelo15.addRow(new Object[]{"0","Ayad","Quimica","Cristobal Acajabon","24/03/2018","13:57:43"});
        Usuarios.modelo15.addRow(new Object[]{"1","Abella","Economia","Cristobal Acajabon","24/03/2018","10:38:32"});
        Usuarios.modelo15.addRow(new Object[]{"2","Amaya","Comunicaciones","Cristobal Acajabon","26/03/2018","11:18:47"});
        
        Usuarios.modelo16.addRow(new Object[]{"0","Akhar","Fisica","Cristobal Acajabon","18/03/2018","08:32:46"});
        Usuarios.modelo16.addRow(new Object[]{"1","Adeline","electronica","Cristobal Acajabon","22/03/2018","09:24:59"});
        
            
        Usuarios.txtprestamos2=new JLabel("Prestamos hechos:");
        Usuarios.txtprestamos2.setBounds(20, 50, 200, 25);
        Usuarios.panelReporteUsuario2.add(Usuarios.txtprestamos2);     
        
        JScrollPane sc20 = new JScrollPane(Usuarios.tabla20);
        sc20.setBounds(10, 80, 850, 100);
        Usuarios.panelReporteUsuario2.add(sc20);
        
        Usuarios.txtdevoluciones2=new JLabel("Devoluciones:");
        Usuarios.txtdevoluciones2.setBounds(20, 200, 200, 25);
        Usuarios.panelReporteUsuario2.add(Usuarios.txtdevoluciones2);
        
        JScrollPane sc21 = new JScrollPane(Usuarios.tabla21);
        sc21.setBounds(10, 230, 850, 100);
        Usuarios.panelReporteUsuario2.add(sc21);
        
        Usuarios.txtmodificaciones2=new JLabel("Modificaciones:");
        Usuarios.txtmodificaciones2.setBounds(20, 350, 200, 25);
        Usuarios.panelReporteUsuario2.add(Usuarios.txtmodificaciones2);
        
        JScrollPane sc22 = new JScrollPane(Usuarios.tabla22);
        sc22.setBounds(10, 380, 850, 100);
        Usuarios.panelReporteUsuario2.add(sc22);
        
        Usuarios.txteliminado2=new JLabel("Eliminadas:");
        Usuarios.txteliminado2.setBounds(20, 500, 200, 25);
        Usuarios.panelReporteUsuario2.add(Usuarios.txteliminado2);
        
        JScrollPane sc23 = new JScrollPane(Usuarios.tabla23);
        sc23.setBounds(10, 530, 850, 100);
        Usuarios.panelReporteUsuario2.add(sc23);
        
        Usuarios.regresarReporteUsuario2=new JButton("REGRESAR");
        Usuarios.regresarReporteUsuario2.setBounds(650, 20, 200, 25);
        Usuarios.panelReporteUsuario2.add(Usuarios.regresarReporteUsuario2);
            
        }
        
        //////////////////////////////////////////////////////////////USUARIO 3/////////////////////////////////////////////////////////////////////////////

        public static void panelUsuario3(){
        
        
        Usuarios.modelo19.addRow(new Object[]{"0","Akhar","Fisica","2","es el proceso de diseñar, codificar, depurar y mantener el código fuente de programas de computadora","java,c++,visual","codigo,lenguaje","9","4","18/03/2018","08:32:46",false});
        Usuarios.modelo20.addRow(new Object[]{"1","Aguilis","Historia","4","estudia y emplea sistemas cuyo funcionamiento se basa en la conducción y el control del flujo","3 meses","6","circuitos,telecomunicaciones","control,flujo","7","3","29/03/2018","16:05:49",false});
        Usuarios.modelo21.addRow(new Object[]{"2","Evangelyne","Tecnologia","8","Estudia las propiedades y relaciones entre entidades abstractas como números, figuras geométricas","Geometria,fracciones,ecuaciones,","expresiones,inecuaciones,decimales","Usac","6","2","27/03/2018","09:24:37",false});
        
        Usuarios.usuario3Libros=new JLabel("LIBROS");
        Usuarios.usuario3Libros.setBounds(20, 30, 170, 25);
        Usuarios.panelUsuario3.add(Usuarios.usuario3Libros);   
            
        JScrollPane sc24 = new JScrollPane(Usuarios.tabla24);
        sc24.setBounds(10, 60, 850, 200);
        Usuarios.panelUsuario3.add(sc24);
        
        Usuarios.usuario3Revistas=new JLabel("REVISTAS");
        Usuarios.usuario3Revistas.setBounds(20, 275, 170, 25);
        Usuarios.panelUsuario3.add(Usuarios.usuario3Revistas); 
        
        JScrollPane sc25 = new JScrollPane(Usuarios.tabla25);
        sc25.setBounds(10, 305, 850, 200);
        Usuarios.panelUsuario3.add(sc25);
        
        Usuarios.usuario3Tesis=new JLabel("TESIS");
        Usuarios.usuario3Tesis.setBounds(20, 520, 170, 25);
        Usuarios.panelUsuario3.add(Usuarios.usuario3Tesis); 
        
        JScrollPane sc26 = new JScrollPane(Usuarios.tabla26);
        sc26.setBounds(10, 550, 850, 200);
        Usuarios.panelUsuario3.add(sc26);
        
        Usuarios.buscar3=new JLabel("BUSCAR POR :");
        Usuarios.buscar3.setBounds(1000, 360, 170, 25);
        Usuarios.panelUsuario3.add(Usuarios.buscar3); 
        
        Usuarios.rolUsuario3=new JComboBox();
        Usuarios.rolUsuario3.addItem("Autor");
        Usuarios.rolUsuario3.addItem("Titulo");
        Usuarios.rolUsuario3.setBounds(940, 400, 200, 25);
        Usuarios.panelUsuario3.add(Usuarios.rolUsuario3);         
                
        Usuarios.filtro6=new JTextField();
        Usuarios.filtro6.setBounds(920, 440, 250, 25);
        Usuarios.panelUsuario3.add(Usuarios.filtro6); 
        
        Usuarios.reportePrestamos3=new JButton("REPORTE DE PRESTAMOS");
        Usuarios.reportePrestamos3.setBounds(940, 525, 200, 40);
        Usuarios.panelUsuario3.add(Usuarios.reportePrestamos3);
        
        Usuarios.devolucionLibros3=new JButton("DEVOLUCION DE BIBLIOGRAFIA");
        Usuarios.devolucionLibros3.setBounds(940, 585, 200, 40);
        Usuarios.panelUsuario3.add(Usuarios.devolucionLibros3);
        
        Usuarios.regresarDeUsuario3=new JButton("REGRESAR");
        Usuarios.regresarDeUsuario3.setBounds(975, 20, 200, 25);
        Usuarios.panelUsuario3.add(Usuarios.regresarDeUsuario3); 
            
        }
        
        //////////////////////////////////////////////////////////////REPORTE USUARIO 3/////////////////////////////////////////////////////////////////////////////

        public static void panelReporteUsuario3(){
        
        Usuarios.modelo22.addRow(new Object[]{"0","Akhar","Fisica","2","Clisman Rocael","18/03/2018","08:32:46"});
        Usuarios.modelo22.addRow(new Object[]{"1","Aguilis","Historia","Clisman Rocael","29/03/2018","16:05:49"});
        Usuarios.modelo22.addRow(new Object[]{"2","Evangelyne","Tecnologia","Clisman Rocael","27/03/2018","09:24:37"});
            
        Usuarios.modelo23.addRow(new Object[]{"1","Adeline","electronica","Clisman","22/03/2018","09:24:59"});
        Usuarios.modelo23.addRow(new Object[]{"2","Amaya","Comunicaciones","Clisman","26/03/2018","11:18:47"});
           
            
        Usuarios.txtprestamos3=new JLabel("Prestamos hechos:");
        Usuarios.txtprestamos3.setBounds(20, 50, 200, 25);
        Usuarios.panelReporteUsuario3.add(Usuarios.txtprestamos3);     
        
        JScrollPane sc27 = new JScrollPane(Usuarios.tabla27);
        sc27.setBounds(10, 80, 850, 100);
        Usuarios.panelReporteUsuario3.add(sc27);
        
        Usuarios.txtdevoluciones3=new JLabel("Devoluciones:");
        Usuarios.txtdevoluciones3.setBounds(20, 200, 200, 25);
        Usuarios.panelReporteUsuario3.add(Usuarios.txtdevoluciones3);
        
        JScrollPane sc28 = new JScrollPane(Usuarios.tabla28);
        sc28.setBounds(10, 230, 850, 100);
        Usuarios.panelReporteUsuario3.add(sc28);
        
        Usuarios.txtmodificaciones3=new JLabel("Modificaciones:");
        Usuarios.txtmodificaciones3.setBounds(20, 350, 200, 25);
        Usuarios.panelReporteUsuario3.add(Usuarios.txtmodificaciones3);
        
        JScrollPane sc29 = new JScrollPane(Usuarios.tabla29);
        sc29.setBounds(10, 380, 850, 100);
        Usuarios.panelReporteUsuario3.add(sc29);
        
        Usuarios.txteliminado3=new JLabel("Eliminadas:");
        Usuarios.txteliminado3.setBounds(20, 500, 200, 25);
        Usuarios.panelReporteUsuario3.add(Usuarios.txteliminado3);
        
        JScrollPane sc30 = new JScrollPane(Usuarios.tabla30);
        sc30.setBounds(10, 530, 850, 100);
        Usuarios.panelReporteUsuario3.add(sc30);
        
        Usuarios.regresarReporteUsuario3=new JButton("REGRESAR");
        Usuarios.regresarReporteUsuario3.setBounds(650, 20, 200, 25);
        Usuarios.panelReporteUsuario3.add(Usuarios.regresarReporteUsuario3);
            
        }
        
    
}
