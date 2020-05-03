package Nastias;
//package Monica;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AplicacionForUpperEssential extends JFrame implements ActionListener,ChangeListener
{
	Container c;
	JSplitPane spp,spp2;
	JPanel pnl1,pnl2,pnl3;
	JMenuBar mnb;
	JToolBar tlb;
	JMenu mnu,mnu2,mnuEnable;
	JMenuItem mni1,mni2,mni3,mni4,mni5,mniTol;//Para Menu
	JMenuItem mni6,mni7,mni8,mni9,mni10;//Para PopPup
	JMenuItem mni11,mni12,mni13,mni14,mni15;//Para PopPup
	JMenuItem mniVentana,mniMini,mniMaxi,mniEnable;
	JPopupMenu ppm;
	
	JTextArea txa;
	JScrollPane scp,scp2;
	JButton btn,btn2,btnEnable;
	JRadioButton rdb1,rdb2,rdb3,rdbEnable,rdb;
	JCheckBox ckb,ckbEnable;
	ButtonGroup grupo;
	JLabel lbl;
	JComboBox ccb,ccb2,ccbEnable;
	JList lista;
	JScrollBar scb,scbEnable,scb2;
	JFormattedTextField ftx;
	JSpinner spn,spn2,spnEnable;
	JSlider sld,sld2,sldEnable;
	JProgressBar pgb,pgb2,pgbEnable;
	JTextField txt,txtEnable;
	JToggleButton tgb,tgbEnable;
	
	String LookCambiar="UpperEssential.UpperEssentialLookAndFeel",Look="Metal",Cadena[]={"Opcion1","Opcion2","Opcion3","Opcion4","Opcion5","Opcion6","Opcion7","Opcion8","Opcion9","Opcion10","Opcion11","Opcion12","Opcion13","Opcion14","Opcion15"};
	
	
	public AplicacionForUpperEssential()
	{
		Diseño();
		Eventos();
	}
	public void  Diseño()
	{
		c=getContentPane();
		c.setLayout(new BorderLayout());
		
		
		//Zona de inicializacion
		spp=new JSplitPane();
		spp2=new JSplitPane();	
		pnl1=new JPanel();
		pnl2=new JPanel();
		pnl3=new JPanel();	
		mnb=new JMenuBar();
		tlb=new JToolBar();
		mnu=new JMenu("Menu");
		mnu2=new JMenu("Menu 2");
		mnuEnable=new JMenu("Menu 3[Enable]");
		
		mni1=new JMenuItem("Menu Item 1");
		mni2=new JMenuItem("Menu Item 2");
		mni3=new JMenuItem(new ImageIcon(getClass().getResource("/Mages/DialogDirCerrado.png")));
		mni4=new JMenuItem("Menu Item 4");
		mni5=new JMenuItem("Menu Item 5");	
		mniTol=new JMenuItem("MostrarToolBar");	
		mni6=new JMenuItem("Menu Item PoPup 6");
		mni7=new JMenuItem("Menu Item PoPup 7");
		mni8=new JMenuItem("Menu Item PoPup 8");
		mni9=new JMenuItem("Menu Item PoPup 9");
		mni10=new JMenuItem("Menu Item PoPup 10");	
		mni11=new JMenuItem("Menu Item PoPup 11");
		mni12=new JMenuItem("Menu Item PoPup 12");
		mni13=new JMenuItem("Menu Item PoPup 13");
		mni14=new JMenuItem("Menu Item PoPup 14");
		mni15=new JMenuItem("Menu Item PoPup 15");	
		mniVentana=new JMenuItem("Crear Ventana");
		mniMini=new JMenuItem("Minimizar Split");
		mniMaxi=new JMenuItem("Restaurar Split");
		mniEnable=new JMenuItem("Menu Item[Enable]");
		
		
		mni1.setOpaque(true);
		mni2.setOpaque(false);
		mni3.setOpaque(true);
		mni4.setOpaque(false);
		
		mniVentana.addActionListener(this);
		mniMini.addActionListener(this);
		mniMaxi.addActionListener(this);
		mniTol.addActionListener(this);
		
		ppm=new JPopupMenu();
		
		
		txa=new JTextArea();
		scp=new JScrollPane(txa,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		btnEnable=new JButton("Boton[Enable]");
		rdbEnable=new JRadioButton("Radio [Enable]");
		ckbEnable=new JCheckBox("Check[Enable]");
		ccbEnable=new JComboBox(Cadena);	
		scbEnable=new JScrollBar();
		spnEnable=new JSpinner();
		sldEnable=new JSlider();
		pgbEnable=new JProgressBar();
		txtEnable=new JTextField("Caja de Texto [Enable]");
		tgbEnable=new JToggleButton("Toggle Button[Enable]");
		
		
		lbl=new JLabel("Este es una label");
		ccb=new JComboBox(Cadena);
		ccb2=new JComboBox(Cadena);
		lista=new JList(Cadena);
		scp2=new JScrollPane(lista,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scb=new JScrollBar();
		ftx=new JFormattedTextField(10);
		spn=new JSpinner();
		sld=new JSlider(0,100);
		pgb=new JProgressBar();
		spn2=new JSpinner();
		sld2=new JSlider(0,100);
		pgb2=new JProgressBar();
		tgb=new JToggleButton("Este es un Boton Toggle");
		txt=new JTextField(10);
		ckb=new JCheckBox("Check");
		rdb=new JRadioButton("Radio");
		scb2=new JScrollBar();
			
		btn=new JButton(" UpperEssentialLookAndFeel  ");
		btn2=new JButton(" UpperEssentialLookAndFeel ");
		rdb1=new JRadioButton("Metal",true);
		rdb2=new JRadioButton("Upper",false);
		rdb3=new JRadioButton("NimROD",false);
		grupo=new ButtonGroup();

		rdb1.addActionListener(this);
		rdb2.addActionListener(this);
		rdb3.addActionListener(this);
		rdb1.addChangeListener(this);
        rdb2.addChangeListener(this);
        rdb3.addChangeListener(this);
		
        
        scb2.setOrientation(JScrollBar.HORIZONTAL);
        btnEnable.setEnabled(false);
        rdbEnable.setEnabled(false);
        ckbEnable.setEnabled(false);
        ccbEnable.setEnabled(false);
        scbEnable.setEnabled(false);
        spnEnable.setEnabled(false);
        sldEnable.setEnabled(false);
        pgbEnable.setEnabled(false);
        txtEnable.setEnabled(false);
        tgbEnable.setEnabled(false);
        mniEnable.setEnabled(false);
        mnuEnable.setEnabled(false);
        
        
        /*
        pnl1.setBackground(Color.white);
        pnl2.setBackground(Color.orange);
        pnl3.setBackground(Color.LIGHT_GRAY);
        */
        
        Ventanita ven=new Ventanita();
        
        btn.setToolTipText("UpperEssentialLookAndFeel [Boton]");
		sld.setToolTipText("UpperEssentialLookAndFeel [Deslisante]");
		pgb.setToolTipText("UpperEssentialLookAndFeel [Barra de Progreso]");
		tgb.setToolTipText("UpperEssentialLookAndFeel [Toggle Button]");
		ccb.setToolTipText("UpperEssentialLookAndFeel  [Caja de Verificacion]");
		rdb1.setToolTipText("UpperEssentialLookAndFeel [Radio Boton]");
        
        pnl2.add(ven);
      
        
        pnl2.setLayout(null);
        
        ccb2.setSize(180,30);
        ccb2.setLocation(10,160);
        
        scp2.setSize(180,200);
        scp2.setLocation(10,350);
        lista.setVisibleRowCount(10);
        
        
        pgb.setValue(50);
      //  pgb.setIndeterminate(true);
        
        pgb2.setValue(50);
        
        pnl3.setLayout(null);
        
       //
        scp.setSize(180,150);
        scp.setLocation(10,1);
        pnl3.add(scp);
        pnl3.add(ccb2);
        pnl3.add(scp2);
        
        
        
        spp2.setLeftComponent(pnl2);
        spp2.setRightComponent(pnl1);
        spp2.setDividerLocation(500);
        spp2.setDividerSize(20);
        spp2.setOneTouchExpandable(true);
        spp2.setOrientation(JSplitPane.VERTICAL_SPLIT);
	
        spp.setLeftComponent(pnl3);//spp2+pnl3
        spp.setRightComponent(spp2);
        spp.setDividerLocation(200);
        spp.setDividerSize(20);
        spp.setOneTouchExpandable(true);   
        spp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        
        //Zona de Agragado
        
		grupo.add(rdb1); //Para el grupo
		grupo.add(rdb2);
		grupo.add(rdb3);
		
		tlb.add(rdb1); //Para toolBar
		tlb.add(rdb2);
		tlb.add(rdb3);
		tlb.add(new JSeparator(JSeparator.VERTICAL));
		tlb.add(btn2);
		tlb.add(spn2);
		tlb.add(sld2);
		tlb.add(new JSeparator(JSeparator.VERTICAL));
		tlb.add(pgb2);
		tlb.add(new JSeparator(JSeparator.HORIZONTAL));
		
		
		ppm.add(mni6); //para PopPup
		ppm.add(mni7);
		ppm.add(mni8);
		ppm.add(mni9);
		ppm.add(mni10);
		
		pnl1.setComponentPopupMenu(ppm);
		pnl2.setComponentPopupMenu(ppm);
		pnl3.setComponentPopupMenu(ppm);
		
		pnl1.add(btn);
		
		pnl1.add(lbl);
		pnl1.add(txt);
		pnl1.add(ccb);
		pnl1.add(scb);
		pnl1.add(ftx);
		pnl1.add(spn);
		pnl1.add(sld);
		pnl1.add(pgb);
		pnl1.add(tgb);
		pnl1.add(ckb);
		pnl1.add(rdb);
		
		pnl1.add(scb2);
		pnl1.add(btnEnable);
		pnl1.add(rdbEnable);
		pnl1.add(ckbEnable);
		pnl1.add(ccbEnable);
		pnl1.add(scbEnable);
		pnl1.add(spnEnable);
		pnl1.add(sldEnable);
		pnl1.add(pgbEnable);
		pnl1.add(txtEnable);
		pnl1.add(tgbEnable);
		    

		mnu2.add(mni11);
		mnu2.add(mni12);
		mnu2.add(mni13);
		mnu2.add(mni14);
		mnu2.addSeparator();
		mnu2.add(mni15);
		
		
		mnu.add(mni1);
		mnu.add(mni2);
		mnu.add(mni3);
		mnu.add(mni4);
		mnu.add(mni5);
		mnu.addSeparator();
		mnu.add(mniTol);
		mnu.addSeparator();
		mnu.add(mniEnable);
		mnu.addSeparator();
		mnu.add(mniVentana);
		mnu.add(mniMini);
		mnu.add(mniMaxi);
		mnu.addSeparator();
		mnu.add(mnuEnable);
		mnu.addSeparator();
		mnu.add(mnu2);
		mnb.add(mnu);
	
		c.add(tlb,BorderLayout.NORTH);
		c.add(spp,BorderLayout.CENTER);
	
		setTitle(" Upper Essential con EWE OU ");
		setJMenuBar(mnb);
		setLocation(100,100);
		setSize(900,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
	}
	
	public static void main(String arg[])
	{
		/*
		try 
		{
			
			//NimRODTheme nt = new NimRODTheme( new URL( "http://personales.ya.com/nimrod/data/Burdeos.theme"));
			
			//KunststoffTheme nt = new KunststoffTheme();
			
			NimRODLookAndFeel nf = new NimRODLookAndFeel();
			//nf.setCurrentTheme( nt);
			UIManager.setLookAndFeel( nf);
			
			//UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try	
		{
			UpperEssentialLookAndFeel uelaf=new UpperEssentialLookAndFeel();//Nuevo Objeto
			/*UpperTheme ut= new UpperTheme();	      	//Nuevo Objeto de Tema
			ut.setPrimary1(new Color(84,102,131));	
			ut.setPrimary2(new Color(220,225,120));		//Amarillo-Verde: Seleccion, llenado de Slider y ProgressBar,etc
			ut.setPrimary3(new Color(17,156,148));		//Jade: Un jade mas bajo,etc
			ut.setSecondary1(new Color(161,178,27));	//Verde-Amarillo: Bordes de algunos objetos,etc
			ut.setSecondary3(new Color(0,0,0));			//Negro: para Paneles,etc
		    uelaf.setCurrentTheme( ut);
			UIManager.setLookAndFeel(uelaf); 			//Cargamos el LookAndFeel 
		} 												//Aviso de cualquier error
		catch (UnsupportedLookAndFeelException ulafe) {System.out.print("Error: "+ulafe); }//No soportado */
		new AplicacionForUpperEssential();
	}
	
	public void Eventos()
	{
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==rdb1)
		{
			Look="Metal";
		}
		if(ae.getSource()==rdb2)
		{
			Look="Upper";
		}
		if(ae.getSource()==rdb3)
		{
			Look="NimROD";
		}
		if(ae.getSource()==mniVentana)
		{
			Ventanita ven2=new Ventanita();
			pnl2.add(ven2);
		}
		if(ae.getSource()==mniTol)
		{
			tlb.setVisible(true);
			c.add(tlb,BorderLayout.NORTH);
		}
		if(ae.getSource()==mniMini)
		{
			spp2.setDividerLocation(550);
			spp.setDividerLocation(800);
			
		}
		if(ae.getSource()==mniMaxi)
		{
	        spp2.setDividerLocation(350);
	        spp.setDividerLocation(590);
			
		}
		
	}
	public void stateChanged(ChangeEvent cha)
	{
		if(Look=="Metal")
		{
			LookCambiar= "javax.swing.plaf.metal.MetalLookAndFeel";
		}
		else
		{
			if(Look.equals("Upper"))
			{
				LookCambiar="UpperEssential.UpperEssentialLookAndFeel";
			}
			else
			{
				if(Look=="NimROD")
				{
					LookCambiar="com.nilo.plaf.nimrod.NimRODLookAndFeel";
				}
			}
		}
		
		try 
        {
			
			UIManager.setLookAndFeel(LookCambiar);
			SwingUtilities.updateComponentTreeUI(AplicacionForUpperEssential.this);
			AplicacionForUpperEssential.this.validate();
        }catch( Exception e ){System.err.println( "No se puede");}
	}
}



class Ventanita extends JInternalFrame implements ActionListener
{
	JButton btn,btn2;
	JFormattedTextField ftx;
	JTextField txt;
	JPasswordField pwf;
	JCheckBox ckb;
	JRadioButton rdb;
	JSpinner spn;
	JSlider sld,sldHori,sldVerti;
	JProgressBar pgb,pgbHori,pgbVerti;
	JScrollBar scbHori,scbVerti;
	JTree Arbol;
	DefaultMutableTreeNode     Primario;
	DefaultMutableTreeNode     SecundarioTema;
	DefaultMutableTreeNode  TerciarioSubtema;
	JTable Tabla;
	Object Fila[][]={
						{"Celda [1]","Celda [2]","Celda [3]","Celda [4]",},
						{"Celda [5]","Celda [6]","Celda [7]","Celda [8]",},
						{"Celda [9]","Celda [10]","Celda [11]","Celda [12]",},
						{"Celda [13]","Celda [13]","Celda [14]","Celda [15]",},
						{"Celda [17]","Celda [16]","Celda [16]","Celda [18]",},
						{"Celda [19]","Celda [20]","Celda [21]","Celda [22]",},
						{"Celda [23]","Celda [24]","Celda [25]","Celda [26]",},
						{"Celda [27]","Celda [28]","Celda [29]","Celda [30]",},
						{"Celda [31]","Celda [32]","Celda [33]","Celda [34]",},
						{"Celda [35]","Celda [36]","Celda [37]","Celda [38]",}
						
					};
	
	String Columna[]={"Columna1","Columna2","Columna3","Columna4"};
	
	JTabbedPane tabed;
	JPanel pnl1,pnl2,pnl3,pnlArbol,pnlTabla,pnlDialogos,pnl4,p1,p2,p3,p4,p5,pnlOtros;
	int num=50;
	
	JButton Dialogo1,Dialogo2,Dialogo3,Dialogo4,Dialogo5,btnFileChooser,btnColorChooser;
	JButton btnAmplio,btnIzquierda,btnDerecha,btnArriba,btnAbajo;
	
	public Ventanita()
	{
		super(" UpperEssential Look And Feel ",true,true,true,true);
		Diseño();
	}
	public void Diseño()
	{
		tabed=new JTabbedPane();
		pnl1=new JPanel();
		pnl2=new JPanel();
		pnl3=new JPanel();
		pnl4=new JPanel();
		pnlTabla=new JPanel();
		pnlArbol=new JPanel();
		pnlDialogos=new JPanel();
		pnlOtros=new JPanel();
		
		
		pnl1.setLayout(new GridLayout(10,10));	
		pnl3.setLayout(new GridLayout(3,1));	
		pnl4.setLayout(new GridLayout(1,3));	
		pnlArbol.setLayout(new BorderLayout());	
		pnlTabla.setLayout(new BorderLayout());	
		
		pnl2.setLayout(null);	
		pnlOtros.setLayout(new GridLayout());	
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		
		btnAmplio=new JButton("Boton Ampio");
		btnIzquierda=new JButton("Izquierda");
		btnDerecha=new JButton("Derecha");
		btnArriba=new JButton("Arriba");
		btnAbajo=new JButton("Abajo");
		
		
		btn=new JButton("UpperEssentialLookAndFeel ");
		btn2=new JButton("Restar Value");
		ftx=new JFormattedTextField("Monica 12/25 /258");
		txt=new JTextField("100");
		pwf=new JPasswordField("Y es toy monica");
		ckb=new JCheckBox("CheckBox");
		rdb=new JRadioButton("RadioButton");
		spn=new JSpinner();
		sld=new JSlider();
		pgb=new JProgressBar();
		btn.addActionListener(this);
		btn2.addActionListener(this);
		
		btnIzquierda.addActionListener(this);
		btnDerecha.addActionListener(this);
		btnAbajo.addActionListener(this);
		btnArriba.addActionListener(this);
		
		sldHori=new JSlider();
		sldVerti=new JSlider();
		scbHori=new JScrollBar();
		scbVerti=new JScrollBar();
		pgbHori=new JProgressBar();
		pgbVerti=new JProgressBar();
		
		//Dialogos
		
		Dialogo1=new JButton("Dialogo[Normal]");
		Dialogo2=new JButton("Dialogo[Error]");
		Dialogo3=new JButton("Dialogo[Informativo]");
		Dialogo4=new JButton("Dialogo[Cuestionador]");
		Dialogo5=new JButton("Dialogo[Peligro]");
		btnColorChooser=new JButton("ColorChooser");
		btnFileChooser=new JButton("FileChooser");
		
		Dialogo1.addActionListener(this);
		Dialogo2.addActionListener(this);
		Dialogo3.addActionListener(this);
		Dialogo4.addActionListener(this);
		Dialogo5.addActionListener(this);
		btnFileChooser.addActionListener(this);
		btnColorChooser.addActionListener(this);
		
		
		pnlDialogos.add(Dialogo1);
		pnlDialogos.add(Dialogo2);
		pnlDialogos.add(Dialogo3);
		pnlDialogos.add(Dialogo4);
		pnlDialogos.add(Dialogo5);
		pnlDialogos.add(btnFileChooser);
		pnlDialogos.add(btnColorChooser);
		
		//Fin de Dailogos
		
		sldVerti.setOrientation(JSlider.VERTICAL);
		scbVerti.setOrientation(JScrollBar.VERTICAL);
		scbHori.setOrientation(JScrollBar.HORIZONTAL);
		pgbVerti.setOrientation(JProgressBar.VERTICAL);
		
		btnAmplio.setSize(200,100);
		btnAmplio.setLocation(5,5);
		
		pnlOtros.add(btnAmplio);
		pnlOtros.add(btnIzquierda);
		pnlOtros.add(btnDerecha);
		pnlOtros.add(btnArriba);
		pnlOtros.add(btnAbajo);
		
		
		pgb.setValue(50);
		pgbVerti.setValue(50);
		pgbHori.setValue(50);
		
		
		btn.setToolTipText("UpperEssentialLookAndFeel [Boton]");
		btn2.setToolTipText("UpperEssentialLookAndFeel [Boton]");
		sld.setToolTipText("UpperEssentialLookAndFeel [Deslisante]");
		pgb.setToolTipText("UpperEssentialLookAndFeel [Barra de Progreso]");
		ckb.setToolTipText("UpperEssentialLookAndFeel [Caja de Verificacion]");
		rdb.setToolTipText("UpperEssentialLookAndFeel [Radio Boton]");
		
		pgb.setStringPainted(true);
		pgbHori.setStringPainted(true);
		pgbVerti.setStringPainted(true);
		
		/*
		sld.setSnapToTicks(true);
		sld.setPaintLabels(true);
		sld.setPaintTrack(true);
		sld.setPaintTicks(true);
		*/
		p1.setSize(100,100);
		p2.setSize(100,100);
		p3.setSize(100,100);
		p4.setSize(100,100);
		p5.setSize(100,100);
		
		p1.setOpaque(true);
		p2.setOpaque(false);
		p3.setOpaque(true);
		p4.setOpaque(false);
		p5.setOpaque(true);
		
		
		p1.setBackground(Color.white);
		p2.setBackground(Color.LIGHT_GRAY);
		p3.setBackground(Color.green);
		p4.setBackground(Color.orange);
		p5.setBackground(Color.black);
		
		p1.setLocation(10,10);
		p2.setLocation(50,50);
		p3.setLocation(100,100);
		p4.setLocation(150,150);
		p5.setLocation(200,200);
		
		//Crear Tabla
		Tabla=new JTable(Fila,Columna);
		pnlTabla.add(new JScrollPane(Tabla),BorderLayout.CENTER);
		
		//Fin de Crear Tabla
		
		//Crear arbol
		SecundarioTema=null;
	    TerciarioSubtema=null;
		Primario=new DefaultMutableTreeNode("Nodo Primario");
		
		SecundarioTema=new DefaultMutableTreeNode("Nodo Secundario[Tema1]");
		Primario.add(SecundarioTema);
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema1]");
		SecundarioTema.add(TerciarioSubtema);
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema2]");
		SecundarioTema.add(TerciarioSubtema);
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema3]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema4]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema5]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema6]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema7]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema8]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema9]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema10]");
		SecundarioTema.add(TerciarioSubtema);	
		
		SecundarioTema=new DefaultMutableTreeNode("Nodo Secundario[Tema2]");
		Primario.add(SecundarioTema);
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema11]");
		SecundarioTema.add(TerciarioSubtema);
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema12]");
		SecundarioTema.add(TerciarioSubtema);
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema13]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema14]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema15]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema16]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema17]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema18]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema19]");
		SecundarioTema.add(TerciarioSubtema);	
		TerciarioSubtema=new DefaultMutableTreeNode("Nodo Terciario[Subtema20]");
		SecundarioTema.add(TerciarioSubtema);
		
		Arbol=new JTree(Primario);
		pnlArbol.add(new JScrollPane(Arbol),BorderLayout.CENTER);
	
		//Fin de Crear Arbol
		
		pnl1.add(btn);
		pnl1.add(btn2);
		
		pnl1.add(ftx);
		pnl1.add(txt);
		pnl1.add(pwf);
		pnl1.add(ckb);
		pnl1.add(rdb);
		pnl1.add(spn);
		pnl1.add(sld);
		pnl1.add(pgb);
		
		pnl2.add(p5);
		pnl2.add(p4);
		pnl2.add(p3);
		pnl2.add(p2);
		pnl2.add(p1);
		
		pnl3.add(sldHori);
		pnl3.add(pgbHori);
		pnl3.add(scbHori);
		pnl4.add(sldVerti);
		pnl4.add(pgbVerti);
		pnl4.add(scbVerti);
		
		
		tabed.addTab("Objetos",pnl1);
		tabed.addTab("Paneles Transparentes",pnl2);
		tabed.addTab("Objetos Horizontal",pnl3);
		tabed.addTab("Objetos Vertical",pnl4);
		tabed.addTab("Dialogos",pnlDialogos);
		tabed.addTab("Arbol",pnlArbol);
		tabed.addTab("Tabla",pnlTabla);
		tabed.addTab("Otros",pnlOtros);
		
		
		add(tabed);
		setSize(580,330);
		setLocation(1,10);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==btn)
		{
			num=num+5;			
			pgb.setValue(num);	
			pgbVerti.setValue(num);
			pgbHori.setValue(num);
		}	
		if(ae.getSource()==btn2)
		{
			num=num-5;			
			pgb.setValue(num);	
			pgbVerti.setValue(num);
			pgbHori.setValue(num);
		}	
		if(ae.getSource()==btnArriba)
		{
			tabed.setTabPlacement(JTabbedPane.TOP);
		}	
		if(ae.getSource()==btnAbajo)
		{
			tabed.setTabPlacement(JTabbedPane.BOTTOM);
		}	
		if(ae.getSource()==btnDerecha)
		{
			tabed.setTabPlacement(JTabbedPane.RIGHT);
		}	
		if(ae.getSource()==btnIzquierda)
		{
			tabed.setTabPlacement(JTabbedPane.LEFT);
		}	
		
		if(ae.getSource()==Dialogo1)
		{
			JOptionPane.showMessageDialog(this,"MOnica LOok And Feel","Normal", JOptionPane.PLAIN_MESSAGE);
			
		}	
		if(ae.getSource()==Dialogo2)
		{
			JOptionPane.showMessageDialog(this," MOnica ¡no es una Persona!","Error", JOptionPane.ERROR_MESSAGE);
			
		}	
		if(ae.getSource()==Dialogo3)
		{
			JOptionPane.showMessageDialog(this," MOnica: es un LOok and feel ","Informacion", JOptionPane.INFORMATION_MESSAGE);
			
		}	
		if(ae.getSource()==Dialogo4)
		{
			JOptionPane.showMessageDialog(this," ¿Quien es MOnica? ","Pregunta", JOptionPane.QUESTION_MESSAGE);
			
		}	
		if(ae.getSource()==Dialogo5)
		{
			JOptionPane.showMessageDialog(this," ¡Monica esta Suelta¡  ","Peligro", JOptionPane.WARNING_MESSAGE);
			
		}	
		if(ae.getSource()==btnFileChooser)
		{
			JFileChooser ChooserFile=new JFileChooser(System.getProperty("user.dir"));
			
			Chooser cho=new Chooser();
			cho.Diseño("Archivo");
			cho.add(ChooserFile);
			
		}
		if(ae.getSource()==btnColorChooser)
		{
			JColorChooser ChooserColor=new JColorChooser();
			
			pnlDialogos.add(ChooserColor);
			Chooser choo=new Chooser();
			choo.Diseño("Color");
			choo.add(ChooserColor);
		}
	}
}
class Chooser extends JDialog
{
	public Chooser()
	{
		Diseño(null);
	}
	public void Diseño(String nom)
	{		
		setSize(400,300);
		setLocation(200,100);
		setVisible(true);
		setTitle(nom);
	}
}






