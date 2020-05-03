/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import com.sun.istack.internal.logging.Logger;
import controlador.Coordinador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.portable.InputStream;
import vista.VistaCatalogo;
import static vista.VistaCatalogo.tabla_inventario;

/**
 *
 * @author elmen
 */
public class Logica {

    private Coordinador miCoordinador;

    public Logica() {
        
    }
    
       
//    public ResultSet visualizar(){
//        
//        Connection con = conectar();
//        ResultSet rs = null;
//        
//        try {
//            
//            PreparedStatement ps = con.prepareStatement("select * from ropa");
//            rs = ps.executeQuery();
//            
//        } catch (Exception e) {
//            System.out.println("Error de consulta");
//        }
//        
//        return rs;
//    }
    
    public boolean guardar_imagen(Date fecha_actual,String cod_producto, String categoria,String descripcion,String talla, String color, String ruta, int cant_max, int cant_min, float costo_publico_real ){
        
        boolean res;
        Conexion con = new Conexion();
        String insert = "insert into altas_de_vestidos (Fecha, CodProducto, Categoria, Descripcion,Talla,Color, Imagen, CantidadMax, CantidadMin,PrecioVenta) values (?,?,?,?,?,?,?,?,?,?)";
        FileInputStream fi = null;
        PreparedStatement ps = null;
        try {
            File file = new File(ruta);//lee la ruta de la imgen
            fi = new FileInputStream(file);//lee la imagen en bytes(en binario)
            
            ps = con.conectar().prepareStatement(insert);
            ps.setDate(1, fecha_actual);
            ps.setString(2, cod_producto);
            ps.setString(3, categoria);
            ps.setString(4, descripcion);
            ps.setString(5, talla);
            ps.setString(6, color);
            ps.setBinaryStream(7, fi);
            ps.setInt(8, cant_max);
            ps.setInt(9, cant_min);
            ps.setFloat(10, costo_publico_real);
            
            ps.executeUpdate();
            
            res = true;
            
        } catch (Exception e) {
            System.out.println("Error al guardar"+e);
            res=false;
        }
        
        return res;
    }
    
    public void registrar_Tabla_Movimientos_Entradas(Date fecha, String cod_prod,int entradas, int actualizar_stock, float costo_publico_real,double EntradaImporte_exacto,double totalImporte_exacto){
        
        int salidas=0;
        String tipo = "COMPRA";
        float salidas_importe=0;
        Conexion con = new Conexion();                                   //entradas = cantidad
        String insert = "insert into historial_mov (fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte) values (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = null;
        try {
            
            ps = con.conectar().prepareStatement(insert);
            ps.setDate(1, fecha);
            ps.setString(2, tipo);
            ps.setString(3, cod_prod);
            ps.setInt(4, entradas);
            ps.setInt(5, salidas);
            ps.setInt(6, actualizar_stock);
            ps.setFloat(7, costo_publico_real);
            ps.setDouble(8 , EntradaImporte_exacto);
            ps.setDouble(9, salidas_importe);
            ps.setDouble(10, totalImporte_exacto);
            
            ps.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "NUEVA PRENDA GUARDADA");
            
        } catch (Exception e) {
            System.out.println("Error al guardar"+e);
        }
    
    }
    
    public double saber_totalImporte(String CodProducto ){
            
        double total_importe=0;
        try{
                    Conexion conn = new Conexion();

                    Statement instruccionSQL = conn.conectar().createStatement();
             
                    ResultSet result =  instruccionSQL.executeQuery ("select totalImporte from historial_mov where CodProducto='"+CodProducto+"' order by id desc limit 1");
               
                    if (result.next()) {
                        
                      total_importe = result.getDouble("totalImporte");
                      
                    }else {
                         System.out.println("error");
                    }
                    
              } catch(SQLException ex){
                    ex.printStackTrace();
              }
        
        return total_importe;        
    } 
    
    public void registrar_Tabla_Movimientos_Salidas(Date fecha, String cod_prod,int salidas, int actualizar_stock, double costePonderado, double salidasImporte_exacto, double totalImporte_exacto){
        
        int entradas=0;
        String tipo = "SALIDA";
        float entradas_importe=0,salidas_importe=0,total_importe=0;
        Conexion con = new Conexion();                                   //entradas = cantidad
        String insert = "insert into historial_mov (fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte) values (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = null;
        try {
            
            ps = con.conectar().prepareStatement(insert);
            ps.setDate(1, fecha);
            ps.setString(2, tipo);
            ps.setString(3, cod_prod);
            ps.setInt(4, entradas);
            ps.setInt(5, salidas);
            ps.setInt(6, actualizar_stock);
            ps.setDouble(7, costePonderado);
            ps.setFloat(8 , entradas_importe);
            ps.setDouble(9, salidasImporte_exacto);
            ps.setDouble(10, totalImporte_exacto);
            
            ps.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "NUEVA PRENDA GUARDADA");
            
        } catch (Exception e) {
            System.out.println("Error al guardar"+e);
        }
    
    }
    
//    public void guardar_en_historial(Date fecha_actual,String categoria,int cantidad, float costo_proveedor_real ){
//        
//        float total_importe_anterior = calc_total_importe();
//        //float costo_proveedor_real = Integer.parseInt(costo_proveedor);
//        int salidas=0,existencias=calc_existencias()+cantidad;
//        float costo_unit=0,entradas_importe=costo_proveedor_real*existencias, salidas_importe=0;
//        float  total_importe= total_importe_anterior+entradas_importe;
//        String tipo="COMPRA";
//        
//        
//        Conexion con = new Conexion();                                   //entradas = cantidad
//        String insert = "insert into historial (fecha, tipo, categoria, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte) values (?,?,?,?,?,?,?,?,?,?)";
//
//        PreparedStatement ps = null;
//        try {
//            
//            ps = con.conectar().prepareStatement(insert);
//            ps.setDate(1, fecha_actual);
//            ps.setString(2, tipo);
//            ps.setString(3, categoria);
//            ps.setInt(4, cantidad);
//            ps.setInt(5, salidas);
//            ps.setInt(6, existencias);
//            ps.setFloat(7, costo_proveedor_real);
//            ps.setFloat(8 , entradas_importe);
//            ps.setFloat(9, salidas_importe);
//            ps.setFloat(10, total_importe);
//            
//            ps.executeUpdate();
//            
//            JOptionPane.showMessageDialog(null, "NUEVA PRENDA GUARDADA");
//            
//        } catch (Exception e) {
//            System.out.println("Error al guardar"+e);
//        }
//    }
// /**************************************           operaciones de la tabla historial                    *******************************************/   
//    private float calc_cost_unit(){
//            
//        float cost_unit=0,total_importe=0, existencias=0;
//        try{
//                    Conexion conn = new Conexion();
//
//                    Statement instruccionSQL = conn.conectar().createStatement();
//             
//                    ResultSet result =  instruccionSQL.executeQuery ("select totalImporte, existencias from historial where tipo='COMPRA' order by id desc limit 1");
//               
//                    if (result.next()) {
//                        
//                      total_importe = result.getFloat("totalImporte");
//                      existencias = result.getInt("existencias");
//                   
//                    }else {
//                         System.out.println("error");
//                    }
//                    
//              } catch(SQLException ex){
//                    ex.printStackTrace();
//              }
//        cost_unit=total_importe/existencias;
//        JOptionPane.showMessageDialog(null, cost_unit);
//        return cost_unit;        
//    } 
//    
//    private int calc_existencias(){
//        
//        int existencias=0;
//        try{
//                    Conexion conn = new Conexion();
//
//                    Statement instruccionSQL = conn.conectar().createStatement();
//             
//                    ResultSet result =  instruccionSQL.executeQuery ("select existencias from historial where tipo='COMPRA' order by id desc limit 1");
//               
//                    if (result.next()) {
//                        
//                      existencias = result.getInt("existencias");
//                      
//                   
//                    }else {
//                         System.out.println("error");
//                    }
//                    
//              } catch(SQLException ex){
//                    ex.printStackTrace();
//              }
//        
//        
//        return existencias;        
//    }
//    
//    private float calc_total_importe(){
//        float total_importe = 0;
//        try{
//                    Conexion conn = new Conexion();
//
//                    Statement instruccionSQL = conn.conectar().createStatement();
//             
//                    ResultSet result =  instruccionSQL.executeQuery ("select totalImporte from historial where tipo='COMPRA' order by id desc limit 1");
//               
//                    if (result.next()) {
//                        
//                      total_importe=result.getFloat("totalImporte");
//                   
//                    }else {
//                         System.out.println("error");
//                    }
//                    
//              } catch(SQLException ex){
//                    ex.printStackTrace();
//              }
//        return total_importe;
//    }
//    
// /*******************************************************************************************************************/   
    
    public void rellenartabla(JTable tabla, String sql ){
        
        try {
            //Para establecer el modelo al JTable
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            Conexion con = new Conexion();
            
            //Para ejecutar la consulta
            Statement s = con.conectar().createStatement();
            //Ejecutamos la consulta que escribimos en la caja de texto
            //y los datos lo almacenamos en un ResultSet
            ResultSet rs = s.executeQuery(sql);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
             modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
             Object[] fila = new Object[cantidadColumnas];
             for (int i = 0; i < cantidadColumnas; i++) {
               fila[i]=rs.getObject(i+1);
             }
             modelo.addRow(fila);
            }
//            rs.close();
//            conexion.getConnection().close();
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "NO TIENES PRIVIEGIOS PARA VISUALIZAR LA TABLA"+ex.getMessage());
           }
        

    }
    
    public void rellenartabla_Movimientos(JTable tabla, String sql, DefaultTableModel modelo ){
        
        try {
            //Para establecer el modelo al JTable
           // DefaultTableModel modelo = new DefaultTableModel();
           
            tabla.setModel(modelo);
            Conexion con = new Conexion();
            
            //Para ejecutar la consulta
            Statement s = con.conectar().createStatement();
            //Ejecutamos la consulta que escribimos en la caja de texto
            //y los datos lo almacenamos en un ResultSet
            ResultSet rs = s.executeQuery(sql);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
//            for (int i = 1; i <= cantidadColumnas; i++) {
//             modelo.addColumn(rsMd.getColumnLabel(i));
//            }
            //Creando las filas para el JTable
            while (rs.next()) {
             Object[] fila = new Object[cantidadColumnas];
             for (int i = 0; i < cantidadColumnas; i++) {
               fila[i]=rs.getObject(i+1);
             }
             modelo.addRow(fila);
            }
//            rs.close();
//            conexion.getConnection().close();
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "NO TIENES PRIVIEGIOS PARA VISUALIZAR LA TABLA"+ex.getMessage());
           }
        

    }
    
    public ImageIcon mandar_imagen(String cod_prod) {
        
         String sql = "select Imagen FROM altas_de_vestidos WHERE CodProducto="+cod_prod;
         ImageIcon ii = null;         
         Statement st = null;
         ResultSet rs = null;
         
         try {
                
            Conexion conexion = new Conexion();
            
            st = conexion.conectar().createStatement();
            rs = st.executeQuery(sql);         
              while(rs.next()){
                   
                    Blob blob = rs.getBlob(1);
                    byte[] data = blob.getBytes(1, (int)blob.length());
                    BufferedImage img = null;
                    try {
                      img = ImageIO.read(new ByteArrayInputStream(data));
                      ii = new ImageIcon(img);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    
               }
            }catch(SQLException ex){
                System.out.println(ex);
            }
               
           return ii;
    }       
    
    public ImageIcon mandar_imagen_nuevaCompra(String cod_prod) {
        
         String sql = "select Imagen FROM altas_de_vestidos WHERE CodProducto="+cod_prod;
         ImageIcon ii = null;         
         Statement st = null;
         ResultSet rs = null;
         
         try {
                
            Conexion conexion = new Conexion();
            
            st = conexion.conectar().createStatement();
            rs = st.executeQuery(sql);         
              while(rs.next()){
                   
                    Blob blob = rs.getBlob(1);
                    byte[] data = blob.getBytes(1, (int)blob.length());
                    BufferedImage img = null;
                    try {
                      img = ImageIO.read(new ByteArrayInputStream(data));
                      ii = new ImageIcon(img);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    
               }
            }catch(SQLException ex){
                System.out.println(ex);
            }
               
           return ii;
    } 
    
    public  boolean administrador(String usuario, String contra) {//metodo para encontrar el usuario administrador 
                                                                      //si lo encuentra (manda true, si no manda false)
            PreparedStatement sentencia = null;                                                          
            try
            {
                Conexion conexion = new Conexion();
                 ResultSet rs = null;
                
               //Statement instruccionSQL = conexion.getConnection().createStatement();
               //ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM usuarios WHERE tipo_usuario='administrador' and nombre='"+usuario+"' AND contraseña='"+ contra+"'");
               String consulta = "SELECT * FROM empleados WHERE tipo_usu='administrador' and nombre=? AND contraseña=?";
               sentencia = conexion.conectar().prepareStatement(consulta);
               sentencia.setString(1, usuario);
               sentencia.setString(2, contra);
               rs = sentencia.executeQuery();
               
               if( rs.first() ){        // si es valido el primer reg. hay una fila, entonses el usuario y su pw existen
                  return true;        //usuario validado correctamente
                  
               }else{
                  return false;        //usuario validado incorrectamente
               }
            }
                catch (Exception e)
               {
                  e.printStackTrace();
                  return false;
               }
 
        }
    
    public  boolean empleado_ventas(String usuario, String contra) {//metodo para encontrar el usuario DE VENTAS 
                                                                      //si lo encuentra (manda true, si no manda false)
            PreparedStatement sentencia = null;                                                          
            try
            {
                Conexion conexion = new Conexion();
                 ResultSet rs = null;
                
               //Statement instruccionSQL = conexion.getConnection().createStatement();
               //ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM usuarios WHERE tipo_usuario='administrador' and nombre='"+usuario+"' AND contraseña='"+ contra+"'");
               String consulta = "SELECT * FROM empleados WHERE puesto='ventas' and nombre=? AND contraseña=?";
               sentencia = conexion.conectar().prepareStatement(consulta);
               sentencia.setString(1, usuario);
               sentencia.setString(2, contra);
               rs = sentencia.executeQuery();
               
               if( rs.first() ){        // si es valido el primer reg. hay una fila, entonses el usuario y su pw existen
                  return true;        //usuario validado correctamente
                  
               }else{
                  return false;        //usuario validado incorrectamente
               }
            }
                catch (Exception e)
               {
                  e.printStackTrace();
                  return false;
               }
 
        }
    public  boolean empleado_almacen(String usuario, String contra) {//metodo para encontrar el usuario administrador 
                                                                      //si lo encuentra (manda true, si no manda false)
            PreparedStatement sentencia = null;                                                          
            try
            {
                Conexion conexion = new Conexion();
                 ResultSet rs = null;
                
               //Statement instruccionSQL = conexion.getConnection().createStatement();
               //ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM usuarios WHERE tipo_usuario='administrador' and nombre='"+usuario+"' AND contraseña='"+ contra+"'");
               String consulta = "SELECT * FROM empleados WHERE puesto='ALMACÉN' and nombre=? AND contraseña=?";
               sentencia = conexion.conectar().prepareStatement(consulta);
               sentencia.setString(1, usuario);
               sentencia.setString(2, contra);
               rs = sentencia.executeQuery();
               
               if( rs.first() ){        // si es valido el primer reg. hay una fila, entonses el usuario y su pw existen
                  return true;        //usuario validado correctamente
                  
               }else{
                  return false;        //usuario validado incorrectamente
               }
            }
                catch (Exception e)
               {
                  e.printStackTrace();
                  return false;
               }
 
        }

    public boolean insert_empleado(String nombre, String contra, String tipo_usu ,String puesto){
        
        boolean var;
        Conexion conexion = new Conexion();    
        PreparedStatement ps=null;
        String sql = "insert into empleados (nombre , contraseña, tipo_usu , puesto) values(?,?,?,?)";
        try {
                    ps = conexion.conectar().prepareStatement(sql);
                    ps.setString(1, nombre);
                    ps.setString(2, contra);
                    ps.setString(3, tipo_usu);
                    ps.setString(4, puesto);
                    ps.execute();

                   //JOptionPane.showMessageDialog(null, "Sus datos han sido guardados Exitosamente","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                   var = true;
                  
            } catch(SQLException e){
                //JOptionPane.showMessageDialog(null, "NO TIENE PRIVILEGIOS PARA AGREGAR INFORMACION");
                System.out.println(e);
                var = false;
            }
        return  var;                
    }
    
//    public boolean existencia_vestido(String cod_producto, String categoria, String talla){
//        
//        PreparedStatement sentencia = null;                                                          
//            try
//            {
//                Conexion conexion = new Conexion();
//                 ResultSet rs = null;
//                
//               //Statement instruccionSQL = conexion.getConnection().createStatement();
//               //ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM usuarios WHERE tipo_usuario='administrador' and nombre='"+usuario+"' AND contraseña='"+ contra+"'");
//               String consulta = "SELECT * from ropa_entrada where cod_producto=? and categoria=? and talla=?";
//               sentencia = conexion.conectar().prepareStatement(consulta);
//               sentencia.setString(1, cod_producto);
//               sentencia.setString(2, categoria);
//               sentencia.setString(3, talla);
//               rs = sentencia.executeQuery();
//               
//               if( rs.first() ){        // si es valido el primer reg. hay una fila, entonses el usuario y su pw existen
//                  return true;        //usuario validado correctamente
//                  
//               }else{
//                  return false;        //usuario validado incorrectamente
//               }
//            }
//                catch (Exception e)
//               {
//                  e.printStackTrace();
//                  return false;
//               }
//        
//    }
 
    public int saber_campos_columnas(String columna, String cod_prod){
        int stock=0;
        try{
                    Conexion conn = new Conexion();

                    Statement instruccionSQL = conn.conectar().createStatement();
             
                    ResultSet result =  instruccionSQL.executeQuery ("select "+columna+" from altas_de_vestidos where CodProducto='"+cod_prod+"'");
               
                    if (result.next()) {
                        
                      stock=result.getInt(columna);
                   
                    }else {
                         System.out.println("error");
                    }
                    
              } catch(SQLException ex){
                    ex.printStackTrace();
              }
        return stock;
    }
    
    public String saber_campos_columnas2(String columna, String cod_prod){
        String var="";
        try{
                    Conexion conn = new Conexion();

                    Statement instruccionSQL = conn.conectar().createStatement();
             
                    ResultSet result =  instruccionSQL.executeQuery ("select "+columna+" from altas_de_vestidos where CodProducto='"+cod_prod+"'");
               
                    if (result.next()) {
                        
                      var=result.getString(columna);
                   
                    }else {
                         System.out.println("error");
                    }
                    
              } catch(SQLException ex){
                    ex.printStackTrace();
              }
        return var;
    }
    
    public float saber_precio(String cod_prod){
        float precio=0;
        try{
                    Conexion conn = new Conexion();

                    Statement instruccionSQL = conn.conectar().createStatement();
             
                    ResultSet result =  instruccionSQL.executeQuery ("select PrecioVenta from altas_de_vestidos where CodProducto='"+cod_prod+"'");
               
                    if (result.next()) {
                        
                      precio=result.getFloat("PrecioVenta");
                   
                    }else {
                         System.out.println("error");
                    }
                    
              } catch(SQLException ex){
                    ex.printStackTrace();
              }
        return precio;
    }
    
    public boolean update_tabla_altas(String SQL){
        boolean res; 
        try {             
                Statement st;   
                Conexion conexion = new Conexion();                     
                 
                 String sql = SQL;
                   
                    st = conexion.conectar().createStatement();
                    st.execute(sql);

                   //JOptionPane.showMessageDialog(null, "Sus datos han sido guardados Exitosamente","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                   System.out.println(sql);
                  res=true;
                   
            } catch(SQLException e){
               JOptionPane.showMessageDialog(null, e+"error");
                res=false;
            }
        return res;
    }
    
      
    
    
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
}
