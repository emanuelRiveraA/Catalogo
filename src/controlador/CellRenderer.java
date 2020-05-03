package controlador;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * 
 * 
 */
public class CellRenderer extends DefaultTableCellRenderer {
 
    private String tipo="text";
    private Font courier = new Font( "Courier New",Font.PLAIN ,12 );
    private Font normal = new Font( "Arial",Font.PLAIN ,12 );
    private Font bold = new Font( "Arial",Font.BOLD ,12 );
    private JLabel label = new JLabel();
    private ImageIcon salida = new ImageIcon(getClass().getResource("/Imagenes/salida.jpg"));
    private ImageIcon entrada = new ImageIcon(getClass().getResource("/Imagenes/entrada.jpg"));
    private ImageIcon nada = new ImageIcon(getClass().getResource("/Imagenes/sign in.png"));
    
    /** Constructor de clase
     * @param tipo String
     * Ej.: "text", "text center", "hour" , "num" , "icon"
     */
    public CellRenderer( String tipo )
    {
        this.tipo = tipo;
    }
    
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {   
        if (selected) {                
            this.setBackground( new Color( 50, 153 , 254) );                        
        }
        else
        {
            this.setBackground(Color.white);
        }
        
        if( tipo.equals("cantidades"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) ""+value );
//            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
//            this.setFont(courier);            
           return this;
        }
        
        if( tipo.equals("costos"))
        {
            this.setHorizontalAlignment( JLabel.RIGHT );
            this.setText( (String) ""+value );
//            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
//            this.setFont(courier);            
           return this;
        }
//                
//        if( tipo.equals("coste ponderado"))
//        {
//            this.setBackground(Color.red);
//            this.setHorizontalAlignment( JLabel.CENTER );
//            this.setText( (String) ""+value );
//            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
//            this.setFont(normal);            
//            return this;
//        }
//        
//        if( tipo.equals("text center"))
//        {
//            this.setHorizontalAlignment( JLabel.CENTER );
//            this.setText( (String) value );
//            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
//            this.setFont(normal);            
//            return this;
//        }
//                
//        if( tipo.equals("num"))
//        {           
//            this.setHorizontalAlignment( JLabel.CENTER );
//            this.setText( (String) value );            
//            this.setForeground( (selected)?new Color(255,255,255):new Color(32,117,32) );            
//            this.setFont(bold);            
//            return this;   
//        }        
        
        if( tipo.equals("icono"))
        {
            if( String.valueOf(value).equals("COMPRA") )
            {
                label.setIcon(entrada);
            }
            else if( String.valueOf(value).equals("SALIDA") )
            {
                label.setIcon(salida);
                
            }else if(String.valueOf(value).equals("")){
                //label.setIcon(nada);
            }
            
            return label;
        }
        
        
        
        return this;
    }
}
