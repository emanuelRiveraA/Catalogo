/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Coordinador;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Emanuel Rivera Aguilar Correo: elmenny_32@hotmail.com
 */
public class Conexion {

    private Coordinador miCoordinador;

    public Conexion() {
    }
      
    public Connection conectar(){
        
        Connection con = null;
        String url = ("jdbc:mysql://localhost:3306/catalogo");
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"user","pass");
            System.out.println("En linea");
          
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
        return con;
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
}
