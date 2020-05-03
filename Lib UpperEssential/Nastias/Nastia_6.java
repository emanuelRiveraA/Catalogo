package Nastias;
							
import java.awt.Dimension;								//Para poder redefinir un tamanio
import java.awt.FlowLayout;								//Un diseniador tipo Flujo 
import javax.swing.*;									//Multiples opciones....

/**
*
* @author Evelyn Ortega Neri
*/
public class Nastia_6 extends JPanel
{
														//Zona de Inicializacion.....
	JButton btn=new JButton("JButton");					//Un boton
	JSlider sld=new JSlider(50,100);					//Un deslizador con escala de 100 y lleno hasta 50
	JProgressBar pgb=new JProgressBar();				//una barra de progreso
	JTextField txt=new JTextField("JTextField");		//una caja de texto
	JTextArea txa=new JTextArea("JTextArea");			//un area de texto
	
	public Nastia_6()
	{
														//Zona de configuracion.....
		setLayout(new FlowLayout());					//Por defecto los frames traen un "BorderLayout", lo cambiamos!
		pgb.setValue(60);								//La barra de progreso lleno hasta 60
		txa.setPreferredSize(new Dimension(300,150));	//Tamanio preferente
		
		add(btn);										//Zona de Agregado.....
		add(sld);
		add(pgb);
		add(txt);
		add(txa);
														//Zona de configuracion de ventana.....
		//setTitle("Nastia 6");							//Un titulo
		setSize(400,300);								//Un tamanio 
		//setLocationRelativeTo(null);					//Colocar al centro  (es reciente el metodo)
		setVisible(true);								//Mostrar la ventana
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Para poder finalizar correctamente la aplicacion
	}
	public static void main(String s[])					//Metodo Principal para poder comenzar la aplicacion 
	{
		JFrame frm=new JFrame();
    	frm.add(new Nastia_6());
    	frm.setSize(400,300);
    	frm.setLocationRelativeTo(null);
    	frm.setVisible(true);	
    	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}




























