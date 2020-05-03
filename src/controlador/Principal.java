/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import UpperEssential.UpperEssentialLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Conexion;
import modelo.Logica;
import vista.VistaCatalogo;

/**
 *
 * @author elmen
 */
public class Principal {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
       // UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\elmen\\OneDrive\\Documentos\\NetBeansProjects\\Catalogo\\Lib UpperEssential\\Veronica.theme"));
        Coordinador miCoordinador = new Coordinador();
        Logica miLogica = new Logica();
        Conexion miConexion = new Conexion();  
        
        miLogica.setCoordinador(miCoordinador);
        miConexion.setCoordinador(miCoordinador);
        
        miCoordinador.setLogica(miLogica);
        miCoordinador.setConexion(miConexion);
        
        
        miCoordinador.iniciar();
        
    }
    
}
