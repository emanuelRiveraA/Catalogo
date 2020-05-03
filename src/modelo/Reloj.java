/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author elmen
 */
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import vista.AgregarPrenda;
public class Reloj implements Runnable{

    int hr, min, seg,i;
    boolean estado = false;  
    Thread hilo; //un objeto tipo hilo que va a estar ejecutando constantemente
    private AgregarPrenda agregarprenda;
    
    @Override
    public void run() {
        
        i++;
        while(estado){
            
            Calendar horario = new GregorianCalendar();
            hr = horario.get(Calendar.HOUR_OF_DAY);
            min = horario.get(Calendar.MINUTE);
            seg = horario.get(Calendar.SECOND);            
            agregarprenda.getTxt_fecha().setText(hr+":"+min+":"+seg+"  intentos  "+i);
            
        }
        try {
            Thread.sleep(1000);
            
        } catch (Exception e) {
            System.out.println("Error en: "+e);
        }
    }
    public void iniciar(){
        
        estado = true;
        hilo = new Thread((Runnable) this);
        if (hilo.isAlive()) {
            
            JOptionPane.showMessageDialog(null, "Esta vivoooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        }else{
            JOptionPane.showMessageDialog(null, "Iniciado");
            hilo.start();
        }
    }
    public void detener(){
        
        estado = false;
        hilo.stop();
        if (hilo.isAlive()) {
            
            JOptionPane.showMessageDialog(null, "No se murio");
            hilo.stop();
        }else{
            JOptionPane.showMessageDialog(null, "ya esta muerto");
        }
    }
    
    public Date fecha()
    {
        java.util.Date dates=new java.util.Date();
        long fechaSis = dates.getTime();
        java.sql.Date d=new java.sql.Date(fechaSis);
        return d;
    }
    
}
