package Nastias;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
*
* @author Evelyn Ortega Neri
*/
public class Nastia_Tabla_Con_Componentes extends JPanel
{
	
	public Nastia_Tabla_Con_Componentes ()
	{
		 DefaultTableModel dtm = new DefaultTableModel( 10, 10) 
		 {
		      public Class getColumnClass( int c) 
		      {
		    	  
		        if ( c == 4) 
		        {
		          return Boolean.class;
		        }
		        else 
		        {
		          return String.class;
		        }
		      }
		    };
		    
		JTable tlb = new JTable( dtm) 
		{
			private static final long serialVersionUID = 1L;

      private String vDa[] = {"Option 1", "Option 2", "Option 3"};
      
      public javax.swing.table.TableCellEditor getCellEditor( int row, int column) 
      {
        if ( column == 1 ) 
        {
          return new DefaultCellEditor( new JComboBox( vDa));
        }
        else if ( column == 2 ) 
        {
          JComboBox cbb = new JComboBox( vDa);
          cbb.setEditable( true);
          return new DefaultCellEditor( cbb);
        }
        else if ( column == 3 ) 
        {
          return new DefaultCellEditor( new JTextField());
        }
        return super.getCellEditor( row, column);
      }
    };       
    JScrollPane scrPan = new JScrollPane(tlb);
    
    	add(scrPan);
    	
		
	}
	public static void main(String arg[])
	{
		JFrame frm=new JFrame();
    	frm.add(new Nastia_Tabla_Con_Componentes());
    	frm.setSize(800,400);
    	frm.setLocationRelativeTo(null);
    	frm.setVisible(true);
    	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
		//;
    	}

}
