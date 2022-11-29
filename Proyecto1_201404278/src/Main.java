

public class Main {

    
    public static void main(String[] args) {
        
        
       
       Usuarios lg=new Usuarios();
        lg.setVisible(true);
        lg.panel1.setVisible(false);
        lg.panel2.setVisible(false);
        lg.panel3.setVisible(false);
        lg.panelBuscarEliminarUsuario.setVisible(false);
        lg.panelEliminarUsuario.setVisible(false);
        lg.panelBuscarModificarUsuario.setVisible(false);
        lg.panelModificarUsuario.setVisible(false);
        lg.panelCrearBibliografia.setVisible(false);
        lg.panelCargaIndividual.setVisible(false);
        lg.panelCargaMasiva.setVisible(false);
        lg.panelVerBibliografias.setVisible(false);
        lg.panelModificarBibliografias.setVisible(false);
        lg.panelEliminarBibliografias.setVisible(false);
       
        //interfaz principal y login
        lg.panelInterfazPrincipal.setVisible(true);
        lg.panelLogin.setVisible(false);
        
        //interfaz prestamos
        lg.panelCrearPrestamos.setVisible(false);
        lg.panelAsignarPrestamo.setVisible(false);
        lg.panelVerPrestamos.setVisible(false);
        lg.panelModificarPrestamos.setVisible(false);
        lg.panelModificarPrestamos2.setVisible(false);
        lg.PanelEliminarPrestamos.setVisible(false);
        
        lg.panelInterfazUsuario.setVisible(false);
        
        lg.panelUsuario1.setVisible(false);
        lg.panelReporteUsuario1.setVisible(false);
        
        lg.panelUsuario2.setVisible(false);
        lg.panelReporteUsuario2.setVisible(false);
      
        lg.panelUsuario3.setVisible(false);
        lg.panelReporteUsuario3.setVisible(false);
    }
    
}
