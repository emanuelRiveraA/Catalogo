package Nastias;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.*;
import UpperEssential.UpperEssentialLookAndFeel;
import UpperEssential.UpperResource;
import UpperEssential.UpperTheme;
import UpperEssential.*;

public class IndexAplication extends JFrame implements ActionListener
{
	private String s[]={"Nastia 1","Nastia 6","Simulador de paleta","Simular Editor Texto","Simular Explorador de Archivos","Simular Mosaicos","Simular Movil",
			"Escritorio","Botones","Cuadro Combinado","Dialogos","Seleccionador de Archivos y Color","Lista",
			"Menu,Punto de  Menu,Barra de herramientas,Barra de Menu",
			"Menu, Punto de Menu","Panel","Barra de Progreso","Botones de Radio, Caja de Verificacion,Separador",
			"Barra de Desplazamiento,Desplazamiento en Panel",
			"Panel de Divicion","Panel de Pestanias","Tabla","Area de Texto","Caja de Texto,Etiqueta,Texto Formateado, Contrasenia",
			"Boton de 2 posiciones","Barra de Herramientas","Tabla con componentes","Arbol,Jirador","Barra deslizante","Inestable..."};


	private JPanel pnlNastias[]=
		{
				new Nastia1(),
				new Nastia_6(),
				new Nastia_0(),
				new Nastia_1(),
				new JPanel(),
				new Nastia_4(),
				new Nastia_5(),
				new Nastia_JInternalFrame(),
				new Nastia_JButton(),
				new Nastia_JComboBox(),
				new Nastia_JDialog(),
				new Nastia_JFileChoser_JColorChoser(),
				new Nastia_JList(),
				new JPanel(),
				new JPanel(),
				new Nastia_JPanel(),
				new Nastia_JProgressBar(),
				new Nastia_JRadioButton_JCheckBox_JSeparator2(),
				new Nastia_JScrollBar_JScrollPane(),
				new Nastia_JSplitPane(),
				new Nastia_JTabbedPane(),
				new Nastia_JTable(),
				new Nastia_JTextArea(),
				new Nastia_JTextFiel_JLabel_JTextFormatted_JPasswordField(),
				new Nastia_JToogleButton(),
				new Nastia_JToolBar(),
				new Nastia_Tabla_Con_Componentes(),
				new Nastias_JTree_JSpinner(),
				new Nastias_Slider()
				
				
		};
	private JPanel pnl=new JPanel();
	private JPanel pnlLook=new JPanel();
	private JPanel pnlControles=new JPanel();
	private JPanel pnlAux1=new JPanel();
	private JPanel pnlAux2=new JPanel();
	private JPanel pnlAux3=new JPanel();
	private FlowLayout fl1=new FlowLayout();
	private FlowLayout fl2=new FlowLayout();
	private JScrollPane scp=new JScrollPane(pnl,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	private  static UpperTheme nt; 
	private  static UpperEssentialLookAndFeel nf;
	private JButton btnNastia=new JButton(" Probar ");
	private JButton btnGuardar=new JButton(" Guardar ");
	private JButton btnAbrir=new JButton(" Abrir ");
	private JButton btn[]=new JButton[s.length];
	private JButton btnPrimary=new JButton(" Esperando... ");
	private JButton btnPrimary1=new JButton(" Esperando... ");
	private JButton btnPrimary2=new JButton(" Esperando... ");
	private JButton btnPrimary3=new JButton(" Esperando... ");
	private JButton btnSecondary=new JButton(" Esperando... ");
	private JButton btnSecondary1=new JButton(" Esperando... ");
	private JButton btnSecondary2=new JButton(" Esperando... ");
	private JButton btnSecondary3=new JButton(" Esperando... ");
	private JButton btnBlanco=new JButton(" Esperando... ");
	private JButton btnNegro=new JButton(" Esperando... ");
	private JTextField txtRuta=new JTextField("UpperEssentialThemeFile.theme");
	private JLabel lblIcono=new JLabel();
	private ImageIcon mageIcono=new ImageIcon(getClass().getResource("ver.png"));
	
	public IndexAplication()
	{
		
		lblIcono.setIcon(mageIcono);
		fl1.setAlignment(SwingConstants.LEFT);
		fl2.setAlignment(SwingConstants.WEST);
		pnlAux1.setLayout(fl1);
		pnlLook.setLayout(fl2);
		pnlAux3.setLayout(fl1);
		pnlAux1.setPreferredSize(new Dimension(210,250));
		pnlAux2.setPreferredSize(new Dimension(250,200));
		
		btnPrimary.addActionListener(this);
		btnPrimary1.addActionListener(this);
		btnPrimary2.addActionListener(this);
		btnPrimary3.addActionListener(this);
		btnSecondary.addActionListener(this);
		btnSecondary1.addActionListener(this);
		btnSecondary2.addActionListener(this);
		btnSecondary3.addActionListener(this);
		btnBlanco.addActionListener(this);
		btnNegro.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnNastia.addActionListener(this);
		btnAbrir.addActionListener(this);
		
		for(int i=0;i<btn.length;i++)
		{
			btn[i]=new JButton(s[i]);
			btn[i].addActionListener(this);
			btn[i].setPreferredSize(new Dimension(s[i].length()*15,100));
			pnl.add(btn[i]);
		}
		
		pnlAux1.add(new JLabel("Primary: "));
		pnlAux1.add(btnPrimary);
		pnlAux1.add(new JLabel("Primary1: "));
		pnlAux1.add(btnPrimary1);
		pnlAux1.add(new JLabel("Primary2: "));
		pnlAux1.add(btnPrimary2);
		pnlAux1.add(new JLabel("Primary3: "));
		pnlAux1.add(btnPrimary3);
		pnlAux1.add(new JLabel("Blanco: "));
		pnlAux1.add(btnBlanco);
		pnlAux1.add(new JLabel("Negro: "));
		pnlAux1.add(btnNegro);
		pnlAux2.add(new JLabel("Secondary: "));
		pnlAux2.add(btnSecondary);
		pnlAux2.add(new JLabel("Secondary1: "));
		pnlAux2.add(btnSecondary1);
		pnlAux2.add(new JLabel("Secondary2: "));
		pnlAux2.add(btnSecondary2);
		pnlAux2.add(new JLabel("Secondary3: "));
		pnlAux2.add(btnSecondary3);
		pnlControles.add(pnlAux1);
		pnlControles.add(pnlAux2);
		pnlLook.add(new JLabel("Nombre: "));
		pnlLook.add(txtRuta);
		pnlLook.add(btnGuardar);
		pnlLook.add(btnAbrir);
		pnlLook.add(new JLabel("NOTA: Si selecciona Primary o Secondary, desplazara colores."));
		add(scp,BorderLayout.SOUTH);
		add(lblIcono,BorderLayout.WEST);
		add(pnlLook,BorderLayout.NORTH);
		add(btnNastia,BorderLayout.EAST);
		add(pnlControles,BorderLayout.CENTER);
		
		setTitle("UppereEssentialLookAndFeel");
		setSize(850,450);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		useCargarPaleta() ;
	    
	}
	public static void main(String ar[])
	{
		try 
		{
			  nf = new UpperEssentialLookAndFeel("");
		      nt = new UpperTheme();
		      UpperEssentialLookAndFeel.setCurrentTheme( nt);
		      UIManager.setLookAndFeel( nf);
		} catch (UnsupportedLookAndFeelException e) {JOptionPane.showMessageDialog(null,"Error en el LookAndFeel");}
		new IndexAplication();
	}
	public void usePintar(JButton btn){Color c=JColorChooser.showDialog(this,"Color", null);btn.setBackground(c);}
	public void useVentana(JPanel pnl)
	{
		JFrame frm=new JFrame();
    	frm.add(pnl);
    	frm.setSize(600,400);
    	frm.setLocationRelativeTo(null);
    	frm.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) 
	{	
		if(ae.getSource()==btnPrimary){this.usePintar(btnPrimary);useCompletarColores();}
		if(ae.getSource()==btnPrimary1){this.usePintar(btnPrimary1);}
		if(ae.getSource()==btnPrimary2){this.usePintar(btnPrimary2);}
		if(ae.getSource()==btnPrimary3){this.usePintar(btnPrimary3);}
		if(ae.getSource()==btnSecondary){this.usePintar(btnSecondary);useCompletarColores();}
		if(ae.getSource()==btnSecondary1){this.usePintar(btnSecondary1);}
		if(ae.getSource()==btnSecondary2){this.usePintar(btnSecondary2);}
		if(ae.getSource()==btnSecondary3){this.usePintar(btnSecondary3);}	
		if(ae.getSource()==btnBlanco){this.usePintar(btnBlanco);}
		if(ae.getSource()==btnNegro){this.usePintar(btnNegro);}	
		if(ae.getSource()==btnGuardar){this.useGuardar();}	
		if(ae.getSource()==btnAbrir){this.useAbrir();}	
		if(ae.getSource()==btnNastia){useCargarColores();}	
		for(int i=0;i<s.length;i++){if(ae.getSource()==btn[i])
		{
			if(i==4){new Nastia_2().setVisible(true);}
			else if(i==13){new Nastia_JMenu_JMenuItem_JToolBar_JMenuBar().setVisible(true);}
			else if(i==14){new Nastia_JMenu_JMenuItem().setVisible(true);}
			else if(i==29){new AplicacionForUpperEssential().setVisible(true);}
			else{this.useVentana(pnlNastias[i]);}}}
	}
	public void useCompletarColores()
	{
		nt = new UpperTheme();  
		nt.setPrimary(btnPrimary.getBackground());
		nt.setSecondary(btnSecondary.getBackground());
		useCargarPaleta() ;
	}
	public void useCargarColores()
	{
		nt = new UpperTheme();        
        nt.setBlack(btnNegro.getBackground());
        nt.setWhite(btnBlanco.getBackground());
        nt.setPrimary1(btnPrimary1.getBackground());
        nt.setPrimary2(btnPrimary2.getBackground());
        nt.setPrimary3( btnPrimary3.getBackground());
        nt.setSecondary1( btnSecondary1.getBackground());
        nt.setSecondary2( btnSecondary2.getBackground());
        nt.setSecondary3( btnSecondary3.getBackground());
        nt.setMenuOpacity(UpperResource.getOpacidad());
        nt.setFrameOpacity(UpperResource.getOpacidad());
        useCambiarTema();
	}
	protected void useCambiarTema() 
    { 
      UpperEssentialLookAndFeel.setCurrentTheme( nt);
      try 
      {
        UIManager.setLookAndFeel( nf);
      }
      catch ( Exception ex) {JOptionPane.showMessageDialog(this,ex);}
      
      SwingUtilities.updateComponentTreeUI( IndexAplication.this);
      useCargarPaleta();
    }
	private void useCargarPaleta() 
	{
		btnPrimary.setBackground( nt.getPrimary3());
	    btnPrimary1.setBackground( nt.getPrimary1());
	    btnPrimary2.setBackground( nt.getPrimary2());
	    btnPrimary3.setBackground( nt.getPrimary3());
	    btnSecondary.setBackground( nt.getSecondary3());
	    btnSecondary1.setBackground( nt.getSecondary1());
	    btnSecondary2.setBackground( nt.getSecondary2());
	    btnSecondary3.setBackground( nt.getSecondary3());    
	    btnNegro.setBackground( nt.getBlack());
	    btnBlanco.setBackground( nt.getWhite());
	}
	public void useGuardar()
	{
		 JFileChooser fc = new JFileChooser();
	        
	        String nomFich =txtRuta.getText();
	        if ( nomFich.equals( "") ) 
	        {
	          fc.setCurrentDirectory( new File ( "."));
	          fc.setSelectedFile( new File( "UpperEssentialThemeFile.theme"));
	        }
	        else 
	        {
	          File fich = new File( nomFich);
	          fc.setSelectedFile( fich);
	        }

	        if ( fc.showSaveDialog( IndexAplication.this) != JFileChooser.APPROVE_OPTION ) { return; }
	        nomFich = fc.getSelectedFile().getPath();
	        txtRuta.setText( nomFich);
	        
	        try 
	        {
	          FileOutputStream f = new FileOutputStream( nomFich);
	          f.write( nt.toString().getBytes());
	          f.close();
	        }
	        catch ( IOException ex) { JOptionPane.showMessageDialog( IndexAplication.this, "No se puede guardar el fichero");}
	}
	public void useAbrir()
	{
		  	JFileChooser fc = new JFileChooser();
	        fc.setCurrentDirectory( new File( "."));
	        if ( fc.showOpenDialog( IndexAplication.this) != JFileChooser.APPROVE_OPTION ) {return; }
	        String nomFich = fc.getSelectedFile().getPath();
	        txtRuta.setText( nomFich);
	        
	        Properties props = new Properties();
	        try 
	        {
	          props.load( new FileInputStream( nomFich));
	        }
	        catch ( Exception ex) {JOptionPane.showMessageDialog(this,ex); return; }
	        
	        nt =UpperUtils.iniCustomColors( nt, 
	        							 props.getProperty( "upper.selection"), 
	                                     props.getProperty( "upper.background"),
	                                     props.getProperty( "upper.p1"),
	                                     props.getProperty( "upper.p2"),
	                                     props.getProperty( "upper.p3"),                                  
	                                     props.getProperty( "upper.s1"),
	                                     props.getProperty( "upper.s2"),
	                                     props.getProperty( "upper.s3"),
	                                     props.getProperty( "upper.w"),
	                                     props.getProperty( "upper.b"),
	                                     props.getProperty( "upper.menuOpacity"),
	                                     props.getProperty( "upper.frameOpacity"));
	        useCambiarTema();
	}
}
