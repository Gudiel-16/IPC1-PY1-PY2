
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



public class Render extends DefaultTableCellRenderer{

    //es una metodo normal de java, lo unico que se le agrega son los if, para boton, y checkBox.
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){ //para el boton en tabla
            JButton btn =(JButton)value;
            return btn;
        }
        
        if(value instanceof JCheckBox){ //para el checkBox en la tabla
            JCheckBox che= (JCheckBox)value;
            return che;
        }
        
        
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); 
    }
    
    
}
