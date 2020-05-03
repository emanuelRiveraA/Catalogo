/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import javax.print.PrintService;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import modelo.Conexion;
import modelo.Logica;
import modelo.Pdf;
import modelo.Reloj;
import vista.AgregarPrenda;
import vista.NuevaCompra;
import vista.PantallaLogin;
import vista.PantallaMenu;
import vista.PantallaMovimientosInventario;
import vista.PantallaVenta;
import vista.RegistroEmpleados;
import vista.VistaCatalogo;

/**
 *
 * @author elmen
 */
public class Coordinador {

    private String tipo_usuario;
    private PantallaLogin pantallalogin;
    private VistaCatalogo vistacatalogo;
    private AgregarPrenda agregarprenda;
    private RegistroEmpleados registroempleados;
    private PantallaVenta pantallaventa;
    private PantallaMovimientosInventario pantallamovimientosinventario;
    private PantallaMenu pantallamenu;
    private NuevaCompra nuevacompra;
    private Reloj reloj;
    private Logica miLogica;
    private Conexion miConexion;
    private String ruta = null;
    private int row_variable=-1, row_variable_lista_productos=0;
    Object[] venta = new Object[4]; 
    Object[] compra = new Object[5]; 
    private DefaultTableModel modelo_tabla_lista_productos; 
    protected double Total_realizar_venta=0;
    
    public Coordinador() {
        
    }
    
    public void iniciar(){
        
//        pantallainicial = new PantallaInicial();
//        pantallainicial.setVisible(true);
//        pantallainicial.setBounds(250, 70, 310, 560);

        pantallalogin = new PantallaLogin();
        pantallalogin.setVisible(true);
        pantallalogin.setLocationRelativeTo(null);
//        pantallalogin.setBounds(250, 70, 310, 560);
        pantallalogin.setSize(310,560);

        escuchadoresventanalogin();
    }
    
    void setLogica(Logica miLogica) {
        this.miLogica = miLogica;
    }

    void setConexion(Conexion miConexion) {
        this.miConexion = miConexion;
    }      
        
    public void escuchadoresventanalogin(){
        
          pantallalogin.getBtnsignin().addActionListener((e) ->{
            
                String nombre = pantallalogin.getTextnombre().getText();
                String contra = new String(pantallalogin.getTextcontra().getPassword());
                
                boolean entrar = miLogica.administrador(nombre, contra);
                
                if (entrar == true) {
                    
                   pantallamenu = new PantallaMenu();
                   pantallamenu.setVisible(true);
                   pantallamenu.setSize(480,550);
                   pantallamenu.setLocationRelativeTo(null);
                   escuchadoresmenu();
                   pantallalogin.dispose();
                    
                }else{
                    
                    boolean ventas = miLogica.empleado_ventas(nombre, contra);
                    boolean almacen = miLogica.empleado_almacen(nombre, contra);
                    
                    if (ventas == true) {
                                    
                        pantallalogin.dispose();
                        vistacatalogo = new VistaCatalogo();
                        vistacatalogo.setVisible(true);
                        vistacatalogo.setLocationRelativeTo(null);
                        vistacatalogo.setLayout(null);
                        vistacatalogo.setSize(1150, 749);

                        escuchadoresvistacatalogo();

                        setEventoMouseClicked(vistacatalogo.tabla_inventario);
                        setEventoMouseClicked3(vistacatalogo.getjTable_lista_productos());
                        miLogica.rellenartabla(vistacatalogo.tabla_inventario, "select CodProducto, Categoria, Descripcion, Color,stock, PrecioVenta from altas_de_vestidos");
                        
                        vistacatalogo.getTxt_cantidad().setEnabled(false);
                        vistacatalogo.getBtn_añadir_lista().setEnabled(false);
                        vistacatalogo.getBtn_remover_vestido().setEnabled(false);
                        
                        //Inicializamos
                        modelo_tabla_lista_productos = new DefaultTableModel();
                        //Vinculamos nuestro modelo a la tabla
                        vistacatalogo.getjTable_lista_productos().setModel(modelo_tabla_lista_productos);
                        //Listo, ahora es solo cuestión de hacer operaciones sobre nuestros datos usando nuestro modelo, empezamos por agregar las columnas que necesitaremos durante la ejecución de nuestro programa.
                        modelo_tabla_lista_productos.addColumn("Cod. Producto");
                        modelo_tabla_lista_productos.addColumn("Categoria");
                        modelo_tabla_lista_productos.addColumn("Talla");
                        modelo_tabla_lista_productos.addColumn("Cantidad");
                        modelo_tabla_lista_productos.addColumn("Precio Unitaio");
                        modelo_tabla_lista_productos.addColumn("Total");
                        vistacatalogo.getjTable_lista_productos().setModel(modelo_tabla_lista_productos);
                        
                        pantallalogin=null;
                        
                    }else if(almacen==true){
                        
                        nuevacompra = new NuevaCompra();
                        nuevacompra.setVisible(true);
                        nuevacompra.setSize(1340, 670);
                        nuevacompra.setLocationRelativeTo(null);
                        escuchadoresnuevacompra();

                        setEventoMouseClicked2(nuevacompra.getjTablerealizar_compra());
                        miLogica.rellenartabla(nuevacompra.getjTablerealizar_compra(), "select CodProducto, Categoria, Descripcion, Talla, Color, stock from altas_de_vestidos");

                        nuevacompra.getTxt_cantidad().setEnabled(false);
                        nuevacompra.getTxt_costo_entero().setEnabled(false);
                        nuevacompra.getTxt_costo_decimal().setEnabled(false);
                        nuevacompra.getTxt_cant_max().setEnabled(false);
                        nuevacompra.getTxt_cant_min().setEnabled(false);
                        nuevacompra.getBtn_actualizar_valores().setEnabled(false);
                        nuevacompra.getBtn_editar_valores().setEnabled(false); 
                        nuevacompra.getBtn_realizar_compra().setEnabled(false);
                        nuevacompra.getBtn_Limpiar().setEnabled(false);
                        nuevacompra.getTxt_fecha().setEditable(false);
                        pantallalogin.dispose();
                                                
                    }else{
                        JOptionPane.showMessageDialog(null , "USUARIO INEXISTENTE EN EL SISTEMA");
                    }
                    
                }   
                          
//             if (tipo_usuario.equals("administrador")) {
//                
//                String nombre = pantallalogin.getTextnombre().getText();
//                String contra = new String(pantallalogin.getTextcontra().getPassword());
//                
//                boolean entrar = miLogica.administrador(nombre, contra);
//                
//                if (entrar == true) {
//                    
//                    registroempleados = new RegistroEmpleados();
//                    registroempleados.setVisible(true);
//                    //registroempleados.setLocationRelativeTo(null);
//                    //registroempleados.setSize(570, 580);
//                    registroempleados.setBounds(600, 25, 612, 650);
//                    pantallalogin.dispose();
//                    escuchadoresregistrarempleado();
//                }else{
//                    JOptionPane.showMessageDialog(null, "USTED NO ES ADMINISTRADOR");
//                }                    
//                
//            }else if(tipo_usuario.equals("empleado")){
//                
//                String sql = "select cod_producto, categoria, descripcion, cantidad, talla, color from ropa_entrada";
//            
//                pantallainicial.dispose();
//                pantallalogin.dispose();
//                vistacatalogo = new VistaCatalogo();
//                vistacatalogo.setVisible(true);
//                vistacatalogo.setLocationRelativeTo(null);
//                vistacatalogo.setLayout(null);
//                vistacatalogo.setSize(1150, 749);
//
//                 miLogica.rellenartabla(vistacatalogo.tabla_inventario, sql);
//                //escucharcatalogo();
//                escuchadoresvistacatalogo();
//
//                setEventoMouseClicked(vistacatalogo.tabla_inventario);
//                
//                pantallalogin=null;
//            
//            }   
        });
//          
        pantallalogin.getBtnsalir2().addActionListener((e) ->{
            pantallalogin.dispose();
            pantallalogin=null;
        });
     
    }
    
    public void escuchadoresmenu(){
                
        pantallamenu.getBtnhistorial_movimientos().addActionListener(((e) -> {
             pantallamovimientosinventario = new PantallaMovimientosInventario();
             pantallamovimientosinventario.setVisible(true);
             pantallamovimientosinventario.setSize(1340, 630);
             pantallamovimientosinventario.setLocationRelativeTo(null);
             escuchadoresmoviientosinventario();    
             pantallamenu.dispose();
             miLogica.rellenartabla(pantallamovimientosinventario.getjTable_movimiento_inventario(), "select fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte from historial_mov");
             diseño_Tabla_Movimientos();
         }));
        
        pantallamenu.getBtn_cerrar_sesion().addActionListener((e) -> {
            
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea cerrar sesión?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                pantallamenu.dispose();
                pantallalogin = new PantallaLogin();
                pantallalogin.setVisible(true);
                pantallalogin.setLocationRelativeTo(null);
                pantallalogin.setSize(310,560);
                escuchadoresventanalogin();
                
            }else if(opcion == JOptionPane.NO_OPTION){
                
            }
        });
        pantallamenu.getBtn_registrar().addActionListener((e) -> {
              
             pantallamenu.dispose();
             registroempleados = new RegistroEmpleados();
             registroempleados.setVisible(true);
             registroempleados.setLocationRelativeTo(null);
             registroempleados.setSize(612, 650);
             //registroempleados.setBounds(600, 25, 612, 650);
             pantallalogin.dispose();
             escuchadoresregistrarempleado();



//            nuevacompra = new NuevaCompra();
//            nuevacompra.setVisible(true);
//            nuevacompra.setSize(1340, 670);
//            nuevacompra.setLocationRelativeTo(null);
//            pantallamenu.dispose();
//            escuchadoresnuevacompra();
//            
//           setEventoMouseClicked2(nuevacompra.getjTablerealizar_compra());
//           miLogica.rellenartabla(nuevacompra.getjTablerealizar_compra(), "select CodProducto, Categoria, Descripcion, Talla, Color, stock from altas_de_vestidos");
//           
//            nuevacompra.getTxt_cantidad().setEnabled(false);
//            nuevacompra.getTxt_costo_entero().setEnabled(false);
//            nuevacompra.getTxt_costo_decimal().setEnabled(false);
//            nuevacompra.getTxt_cant_max().setEnabled(false);
//            nuevacompra.getTxt_cant_min().setEnabled(false);
//            nuevacompra.getBtn_actualizar_valores().setEnabled(false);
//            nuevacompra.getBtn_editar_valores().setEnabled(false);
//        
        });

        
    }
    
    public void escuchadoresregistrarempleado(){
        
        registroempleados.getBtn_registrar().addActionListener((e) -> {
            int contador = 0;
            String nombre = registroempleados.getTxtnombre().getText();
            String contra = new String(registroempleados.getTxtcontra().getPassword());
            String repite_contra = new String(registroempleados.getTxtrepit_contra().getPassword());
            int puesto = registroempleados.getjComboBoxPuesto().getSelectedIndex();

            if (nombre.equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE UN NOMBRE");
                contador+=1;
            }else if (contra.equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA CONTRASEÑA");
                contador+=1;
            }else if (repite_contra.equals("")) {
                JOptionPane.showMessageDialog(null, "REPITA LA CONTRASEÑA");
                contador+=1;
            }else if (puesto==0) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN PUESTO");
            }else if(contador==0){

                if (contra.equals(repite_contra)) {
                    String tipo_usu="empleado";
                    String selec_puesto = (String) registroempleados.getjComboBoxPuesto().getSelectedItem();
                    Boolean var = miLogica.insert_empleado(nombre, contra,tipo_usu,selec_puesto);
                    if (var==true) {
                        JOptionPane.showMessageDialog(null, "ENHORABUENA EL EMPLEADO HA SIDO REGISTRADO");
                    }else{
                        JOptionPane.showMessageDialog(null, "ERROR EN REGISTRAR");
                        System.out.println(nombre+contra+tipo_usu+selec_puesto);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
                }
            }
        });   
        
        registroempleados.getBtncancelar().addActionListener((e) -> {
            registroempleados.dispose();
            pantallamenu = new PantallaMenu();
            pantallamenu.setVisible(true);
            pantallamenu.setSize(480,550);
            pantallamenu.setLocationRelativeTo(null);
            escuchadoresmenu();
        });
    }
    
    public void escuchadoresvistacatalogo(){
       
        vistacatalogo.getTxt_buscar().getDocument().addDocumentListener(new DocumentListener(){ 
                @Override
                public void insertUpdate(DocumentEvent e) {
                    actualizar_Tabla_Inventario(e);
                    vistacatalogo.getLblverimagen().setIcon(null);
                    vistacatalogo.getLbl_talla().setText("");
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    actualizar_Tabla_Inventario(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    actualizar_Tabla_Inventario(e);
                }
                
                private void actualizar_Tabla_Inventario(DocumentEvent e) {
                    try {
                        String text = e.getDocument().getText(0, e.getDocument().getLength());
                        
                        String opcion = (String) vistacatalogo.getjComboBox_opciones().getSelectedItem();

                        miLogica.rellenartabla(vistacatalogo.tabla_inventario, "select CodProducto, Categoria, Descripcion, Color,stock, PrecioVenta from altas_de_vestidos where "+opcion+" like '%"+text+"%'");

                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                }
        });
        
          vistacatalogo.tabla_inventario.addMouseListener(new MouseAdapter() {
                  public void mousePressed(MouseEvent Mouse_evt) {
                  JTable table =(JTable) Mouse_evt.getSource();
                  Point point = Mouse_evt.getPoint();
                  row_variable = table.rowAtPoint(point);
                  if (Mouse_evt.getClickCount() == 1) {
                  //System.out.println(""+vistacatalogo.tabla_inventario.getValueAt(vistacatalogo.tabla_inventario.getSelectedRow(), 1));
                 }
          }
          });  
                
          vistacatalogo.getBtn_añadir_lista().addActionListener((ActionEvent e) -> {
              
                setEventoMouseClicked3(vistacatalogo.getjTable_lista_productos());
                
                String cod_prod = venta[0].toString();
                String categoria = venta[1].toString();
                String precio = venta[2].toString();//se guarda el precio en un string
                Float precio_venta = Float.parseFloat(precio);//aqui se convierte a un float
                int stock = (int) venta[3];
                    
                String cantidad = vistacatalogo.getTxt_cantidad().getText();
                String talla = vistacatalogo.getLbl_talla().getText();
                
                if (cantidad.equals("")) {//EVALUA SI EL CAMPO ESTA VACIO
                  JOptionPane.showMessageDialog(null, "PRIMERO INGRESE UNA CANTIDAD");
                }else{
                    int cantidad_int = Integer.parseInt(cantidad);
                    if (cantidad_int > stock  || cantidad_int == 0) {
                        JOptionPane.showMessageDialog(null, "CANTIDAD NO VALIDA \n Razon1: cant. es 0 \n Razon2: no hay en almacen");
                    }else{                       
                    
                        int tbl_vacia = vistacatalogo.getjTable_lista_productos().getRowCount();

                        if (tbl_vacia == 0) {
                            //int cantidad_int = Integer.parseInt(cantidad);
                            double total = precio_venta*cantidad_int;
                            DecimalFormat df=new DecimalFormat("0.00");
                            String formate = df.format(total); 
                            double total_format = Double.parseDouble(formate);
                            Total_realizar_venta += total_format;

                            String formate2 = df.format(Total_realizar_venta); 
                            double total_realizar_venta_format = Double.parseDouble(formate2);
                            Total_realizar_venta=total_realizar_venta_format;


                            //Para agregar filas, primero crearemos un arreglo del tipo Object para ir almacenando nuestros datos que posteriormente adjuntaremos a nuestro modelo.
                            Object []object = new Object[8];
                            object[0] = cod_prod;
                            object[1] = categoria;
                            object[2] = talla;
                            object[3] = cantidad_int;
                            object[4] = precio_venta;
                            object[5] = total_format;

                            modelo_tabla_lista_productos.addRow(object); 
                            vistacatalogo.getLbl_total_realizar_venta().setText(""+Total_realizar_venta);

                            vistacatalogo.getTxt_cantidad().setText("");
                            //JOptionPane.showMessageDialog(null, cod_prod+" "+categoria+" "+precio_venta+" "+total);
                        }else{

                            int i, existente=0; 
                            String a = null;
                            for (i=0;i < vistacatalogo.getjTable_lista_productos().getRowCount(); i++) {
                               a= (String)vistacatalogo.getjTable_lista_productos().getValueAt(i,0);
                               if (cod_prod.equals(a)) {
                                    existente=1;
                               }
                            }
                            if (existente!=1) {
                                    //int cantidad_int = Integer.parseInt(cantidad);
                                    double total = precio_venta*cantidad_int;
                                    DecimalFormat df=new DecimalFormat("0.00");
                                    String formate = df.format(total); 
                                    double total_format = Double.parseDouble(formate);
                                    Total_realizar_venta += total_format;

                                    String formate2 = df.format(Total_realizar_venta); //OPERACIONES PARA FORMATEAR EL TOTAL
                                    double total_realizar_venta_format = Double.parseDouble(formate2);
                                    Total_realizar_venta=total_realizar_venta_format;

                                    //Para agregar filas, primero crearemos un arreglo del tipo Object para ir almacenando nuestros datos que posteriormente adjuntaremos a nuestro modelo.
                                    Object []object = new Object[8];
                                    object[0] = cod_prod;
                                    object[1] = categoria;
                                    object[2] = talla;
                                    object[3] = cantidad_int;
                                    object[4] = precio_venta;
                                    object[5] = total_format;

                                    modelo_tabla_lista_productos.addRow(object); 
                                    vistacatalogo.getLbl_total_realizar_venta().setText(""+Total_realizar_venta);

                                    vistacatalogo.getTxt_cantidad().setText("");
                                    //JOptionPane.showMessageDialog(null, cod_prod+" "+categoria+" "+precio_venta+" "+total);  
                            }else{
                                    JOptionPane.showMessageDialog(null, "EL PRODUCTO YA ESTA EN LA LISTA,\n ELIMINELO Y VUELVA A INGRESARLO");
                            }
                        }
                    }
                }          
          });
          
          vistacatalogo.getBtn_remover_vestido().addActionListener((e) -> {
            // modelo_tabla_lista_productos = (DefaultTableModel) vistacatalogo.getjTable_lista_productos().getModel();        
              Object[]lista_prod = new Object[1];
              Object valor = vistacatalogo.getjTable_lista_productos().getValueAt(row_variable_lista_productos, 5);
              lista_prod[0] = valor;
              String precio_menos_string = lista_prod[0].toString();
              double precio_menos = Double.parseDouble(precio_menos_string);
              DecimalFormat df=new DecimalFormat("0.00");
              String formate = df.format(precio_menos); 
              double total_format = Double.parseDouble(formate);
              Total_realizar_venta-=total_format;
              
              String formate2 = df.format(Total_realizar_venta); 
              double total_realizar_venta_format = Double.parseDouble(formate2);
              Total_realizar_venta=total_realizar_venta_format;
              
              vistacatalogo.getLbl_total_realizar_venta().setText(""+Total_realizar_venta);  
              modelo_tabla_lista_productos.removeRow(row_variable_lista_productos);
              
          });
          
          vistacatalogo.getjTable_lista_productos().addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent Mouse_evt) {
                        JTable table =(JTable) Mouse_evt.getSource();
                        Point point = Mouse_evt.getPoint();
                        row_variable_lista_productos = table.rowAtPoint(point);
                        if (Mouse_evt.getClickCount() == 1) {
                        //System.out.println(""+nuevacompra.getjTablerealizar_compra().getValueAt(nuevacompra.getjTablerealizar_compra().getSelectedRow(), 1));
                       
                        }
            }
        });
          
         vistacatalogo.getBtn_realizar_venta().addActionListener((e) -> {
             
             for (int i=0;i < vistacatalogo.getjTable_lista_productos().getRowCount(); i++) {
                 String cod_prod = (String)vistacatalogo.getjTable_lista_productos().getValueAt(i,0);
                 int cantidad = (int) vistacatalogo.getjTable_lista_productos().getValueAt(i, 3);
                // boolean costo_venta = (boolean) vistacatalogo.getjTable_lista_productos().getValueAt(i, 4);
                 int stock = miLogica.saber_campos_columnas("stock", cod_prod);
                 int cantidad_menos = stock-cantidad;
                 
                 
                 DecimalFormat df=new DecimalFormat("0.00");
                 double sabertotalImporte= miLogica.saber_totalImporte(cod_prod);
                 double coste_ponde = sabertotalImporte/stock;  
                 String formate = df.format(coste_ponde);
                 double costePonderado = Double.parseDouble(formate); 
                 
                 double salidasImporte = cantidad*costePonderado;
                 String formate2 = df.format(salidasImporte);
                 double salidasImporte_exacto = Double.parseDouble(formate2);
                 
                 double totalImporte = sabertotalImporte-salidasImporte_exacto;
                 String formate3 = df.format(totalImporte);
                 double totalImporte_exacto = Double.parseDouble(formate3);
                 
                 String SQL = "UPDATE altas_de_vestidos SET stock='"+stock+"', stock='"+cantidad_menos+"'  WHERE CodProducto="+cod_prod+"";
                 miLogica.registrar_Tabla_Movimientos_Salidas(fecha(), cod_prod, cantidad, cantidad_menos, costePonderado, salidasImporte_exacto, totalImporte_exacto);
                 miLogica.update_tabla_altas(SQL);
              }
             
             Object [][] lista = new Object[20][20];
             int filas = vistacatalogo.getjTable_lista_productos().getRowCount();
             String total = vistacatalogo.getLbl_total_realizar_venta().getText();
             int columna = 0;
             for (int i = 0; i < vistacatalogo.getjTable_lista_productos().getRowCount(); i++) {
                 lista[i][columna] = vistacatalogo.getjTable_lista_productos().getValueAt(i, columna);
                 columna=1;
                 lista[i][columna] = vistacatalogo.getjTable_lista_productos().getValueAt(i, columna);
                 columna=3;
                 lista[i][columna] = vistacatalogo.getjTable_lista_productos().getValueAt(i, columna);
                 columna=4;
                 lista[i][columna] = vistacatalogo.getjTable_lista_productos().getValueAt(i, columna);
                 columna=0;
             }
                          
             while(modelo_tabla_lista_productos.getRowCount()>0) {
                    modelo_tabla_lista_productos.removeRow(0);
             }
             vistacatalogo.getLbl_total_realizar_venta().setText("");
             Total_realizar_venta=0;
             
             Pdf pdf = new Pdf();
             //pdf.generarPdf();
             pdf.createPDF(lista, filas,total);
     
             miLogica.rellenartabla(vistacatalogo.tabla_inventario, "select CodProducto, Categoria, Descripcion, Color,stock, PrecioVenta from altas_de_vestidos");

         });

         vistacatalogo.getBtncerrar_sesion().addActionListener((e) -> {
             
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea cerrar sesión?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                vistacatalogo.dispose();
                pantallalogin = new PantallaLogin();
                pantallalogin.setVisible(true);
                pantallalogin.setLocationRelativeTo(null);
                pantallalogin.setSize(310,560);
                escuchadoresventanalogin(); 
                
            }else if(opcion == JOptionPane.NO_OPTION){
                
            }
                    
         });
         
    }
    
    public void escuchadoresagregarprenda(){
        
        agregarprenda.btncancelar.addActionListener((e) -> {
            
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea Salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                agregarprenda.dispose();
                nuevacompra = new NuevaCompra();
                nuevacompra.setVisible(true);
                nuevacompra.setSize(1340, 670);
                nuevacompra.setLocationRelativeTo(null);
                escuchadoresnuevacompra();

               setEventoMouseClicked2(nuevacompra.getjTablerealizar_compra());
               miLogica.rellenartabla(nuevacompra.getjTablerealizar_compra(), "select CodProducto, Categoria, Descripcion, Talla, Color, stock from altas_de_vestidos");

                nuevacompra.getTxt_cantidad().setEnabled(false);
                nuevacompra.getTxt_costo_entero().setEnabled(false);
                nuevacompra.getTxt_costo_decimal().setEnabled(false);
                nuevacompra.getTxt_cant_max().setEnabled(false);
                nuevacompra.getTxt_cant_min().setEnabled(false);
                nuevacompra.getBtn_actualizar_valores().setEnabled(false);
                nuevacompra.getBtn_editar_valores().setEnabled(false);
                nuevacompra.getBtn_realizar_compra().setEnabled(false);
                nuevacompra.getBtn_Limpiar().setEnabled(false);
                nuevacompra.getTxt_fecha().setEditable(false);
                
            }else if(opcion == JOptionPane.NO_OPTION){
                
            }
        });
        agregarprenda.btnsubirimagen.addActionListener((e) -> {
           
            JFileChooser jf = new JFileChooser();
            
            int ap = jf.showOpenDialog(jf);
            
            if (ap == JFileChooser.APPROVE_OPTION) {
                ruta = jf.getSelectedFile().getAbsolutePath();
//                ImageIcon imagen = new ImageIcon(ruta);
//                agregarprenda.lblimagenpreview.setIcon(new ImageIcon(ruta));
                ImageIcon foto = new ImageIcon(ruta);//se guarda la foto
                ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(agregarprenda.lblimagenpreview.getWidth(), agregarprenda.lblimagenpreview.getHeight(), Image.SCALE_DEFAULT));
                agregarprenda.lblimagenpreview.setIcon(icono);//se obtiene el tamaño del jlabel y se redimensiona la imagen
            }
        });
        
        agregarprenda.getBtnagregar().addActionListener((ActionEvent e) -> {
            int contador = 0;
            int cantidad = 0;
            String talla_real = "", categoria_real="";
//            String fecha = agregarprenda.getTxt_fecha().getText();
//            SimpleDateFormat fecha_actual = new SimpleDateFormat(fecha);
            String cod_prod = agregarprenda.getTxt_cod_prod().getText();
            int categoria = agregarprenda.getjComboBox_categoria().getSelectedIndex();
            String descripcion = agregarprenda.getTxt_descripcion().getText();           
            String costo_entero_1 = agregarprenda.getTxt_costo_entero().getText();   
            String costo_decimal_1 = agregarprenda.getTxt_costo_decimal().getText();
            int talla = agregarprenda.getCombo_talla().getSelectedIndex();
            String color = agregarprenda.getTxt_color().getText();
            String cantidad_max = agregarprenda.getTxt_cant_max().getText();
            String cantidad_min = agregarprenda.getTxt_cant_min().getText();
                    
            if (cod_prod.equals("")){  
                JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO DE PRODUCTO");
                contador += 1;
            }else if(categoria == 0){
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA CATEGORIA");    
                contador += 1;
            }else if (descripcion.equals("")){
                JOptionPane.showMessageDialog(null, "INGRESE UNA DESCRIPCIÓN");
                contador += 1;
            }else if(talla == 0){
                  JOptionPane.showMessageDialog(null, "SELECCIONE UNA TALLA");
                  
                  contador += 1;
            }else if(color.equals("")){
                  JOptionPane.showMessageDialog(null, "INGRESE UN COLOR");
                  contador += 1;
            }else if (ruta == null){
                  JOptionPane.showMessageDialog(null, "PRIMERO SUBA UNA IMAGEN");
                  contador += 1;
            }else if(costo_entero_1.equals("") || costo_decimal_1.equals("")){
                  JOptionPane.showMessageDialog(null, "INGRESE UN PRECIO DE VENTA VALIDO");
                  contador +=1;
            }else if (cantidad_max.equals("")){
                    JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD MAXIMA");
                    contador +=1;
            }else if(cantidad_min.equals("")){
                    JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD MINIMA");
                    contador +=1;
            }
             

            if (contador == 0) {
                
                        int cant_max = Integer.parseInt(cantidad_max);
                        int cant_min = Integer.parseInt(cantidad_min);
                        talla_real = (String) agregarprenda.getCombo_talla().getSelectedItem();
                        categoria_real = (String) agregarprenda.getjComboBox_categoria().getSelectedItem();
                        String costo_publico = costo_entero_1+"."+costo_decimal_1;
                        float costo_publico_real = Float.parseFloat(costo_publico);
                        Date fecha_actual = fecha();
                    //    boolean vestido_existencia = miLogica.existencia_vestido(cod_prod, categoria_real, talla_real);

                     boolean res = miLogica.guardar_imagen(fecha_actual, cod_prod, categoria_real, descripcion, talla_real, color, ruta,cant_max, cant_min,costo_publico_real);
                      if ( res == true) {
                           JOptionPane.showMessageDialog(null, "NUEVA PRENDA GUARDADA");
                           
                           agregarprenda.getTxt_cod_prod().setText("");
                           agregarprenda.getjComboBox_categoria().setSelectedIndex(0);
                           agregarprenda.getTxt_descripcion().setText("");
                           agregarprenda.getCombo_talla().setSelectedIndex(0);
                           agregarprenda.getTxt_color().setText("");
                           agregarprenda.getLblimagenpreview().setIcon(null);
                           agregarprenda.getTxt_cant_max().setText("");
                           agregarprenda.getTxt_cant_min().setText("");
                           agregarprenda.getTxt_costo_entero().setText("");
                           agregarprenda.getTxt_costo_decimal().setText("");
                       }else{
                          
                      }
             }
                                
        });

        
    }
    
    private void escuchadoresmoviientosinventario() {
        
       pantallamovimientosinventario.getTxt_cod_prod().getDocument().addDocumentListener(new DocumentListener() {
           @Override
           public void insertUpdate(DocumentEvent e) {
               actualizar_Tabla_Movimientos(e);
               
           }

           @Override
           public void removeUpdate(DocumentEvent e) {
               actualizar_Tabla_Movimientos(e);
               original(e);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
               actualizar_Tabla_Movimientos(e);
           }
           
           private void actualizar_Tabla_Movimientos(DocumentEvent e) {
                    try {
                        String text = e.getDocument().getText(0, e.getDocument().getLength());
                        
                        String opcion = (String) pantallamovimientosinventario.getjComboBox_Tipo().getSelectedItem();
                        
                        if (opcion.equals("TODO")) {
                            
                            //Para establecer el modelo al JTable
                            DefaultTableModel modelo = new DefaultTableModel();
                            pantallamovimientosinventario.getjTable_movimiento_inventario().setModel(modelo);
                            //
                            modelo.addColumn("fecha");
                            modelo.addColumn("tipo");
                            modelo.addColumn("CodProducto");
                            modelo.addColumn("Entradas");
                            modelo.addColumn("Salidas");
                            modelo.addColumn("Existencias");
                            modelo.addColumn("costoUnit");
                            modelo.addColumn("entradasImporte");
                            modelo.addColumn("salidasImporte");
                            modelo.addColumn("entradasImporte");
                            
                            //Para agregar filas, primero crearemos un arreglo del tipo Object para ir almacenando nuestros datos que posteriormente adjuntaremos a nuestro modelo.
                            Object []object = new Object[10];
                            object[0] = "";
                            object[1] = "";
                            object[2] = "";
                            object[3] = "";
                            object[4] = "";
                            object[5] = "";
                            object[6] = "";
                            object[7] = "";
                            object[8] = "";
                            object[9] = "total_format";

                            modelo.addRow(object);
                            DefaultTableModel modelo1 = (DefaultTableModel)pantallamovimientosinventario.getjTable_movimiento_inventario().getModel();
                            //miLogica.rellenartabla(pantallamovimientosinventario.getjTable_movimiento_inventario(), "select fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte from historial_mov CodProducto where CodProducto like '%"+text+"%'");
                            miLogica.rellenartabla_Movimientos(pantallamovimientosinventario.getjTable_movimiento_inventario(), "select fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte from historial_mov CodProducto where CodProducto like '%"+text+"%'",modelo1);
                                          
                            String tipo = (String) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 1);
                            diseño_Tabla_Movimientos();
                                                        
                            int[] var =calcular_Total_Entradas_Salidas();
                            pantallamovimientosinventario.getLbl_Total_Entradas().setText(""+var[0]);
                            pantallamovimientosinventario.getLbl_Total_Salidas().setText(""+var[1]);
                           double[] var2 = calcular_Total_EntradasImporte_SalidasImporte_TotalImporte();
                            pantallamovimientosinventario.getLbl_Total_Entradas_Importe().setText(""+var2[0]);
                            pantallamovimientosinventario.getLbl_Total_Salidas_Importe().setText(""+var2[1]);
                            pantallamovimientosinventario.getLbl_Total_Importe().setText(""+var2[2]);
                                                        
                            pantallamovimientosinventario.getjTable_movimiento_inventario().setValueAt(calc_existencia_ini(tipo), 0, 5);
                            pantallamovimientosinventario.getjTable_movimiento_inventario().setValueAt(calc_importe_ini(tipo), 0, 9);
                            
                        }else{
                            miLogica.rellenartabla(pantallamovimientosinventario.getjTable_movimiento_inventario(), "select fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte from historial_mov where tipo='"+opcion+"' and CodProducto like '%"+text+"%'");
                            
                            diseño_Tabla_Movimientos();
                            
                            int[] var =calcular_Total_Entradas_Salidas_Individual();
                            pantallamovimientosinventario.getLbl_Total_Entradas().setText(""+var[0]);
                            pantallamovimientosinventario.getLbl_Total_Salidas().setText(""+var[1]);
                            if (opcion.equals("COMPRA")) {
                                pantallamovimientosinventario.getLbl_Total_Salidas().setText("");
                            }else if(opcion.equals("SALIDA")){
                                pantallamovimientosinventario.getLbl_Total_Entradas().setText("");
                            }
                        }

                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                }
            
            private void original(DocumentEvent e){
                miLogica.rellenartabla(pantallamovimientosinventario.getjTable_movimiento_inventario(), "select fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte from historial_mov");
                diseño_Tabla_Movimientos();
            }
       });
        
        pantallamovimientosinventario.getBtncancelar().addActionListener((e) -> {
            pantallamovimientosinventario.dispose();
            pantallamenu = new PantallaMenu();
            pantallamenu.setVisible(true);
            pantallamenu.setSize(480,550);
            pantallamenu.setLocationRelativeTo(null);
            escuchadoresmenu();
            
        });
        
        pantallamovimientosinventario.getBtn_Fecha().addActionListener((e) -> {
                         
                String text = pantallamovimientosinventario.getTxt_cod_prod().getText();
                String fechaInicial, fechaFinal;       
                
                if(text.equals("")){
                        JOptionPane.showMessageDialog(null, "INFRESE UN COD. DE PRODUCTO");
                }else{                
            
                        String str = pantallamovimientosinventario.getTxt_Fecha_Inicio().getText();
                        String delimiter = "-";
                        String[] temp;
                        temp = str.split(delimiter);
                        for(int i =0; i < temp.length ; i++){
                        }
                        String año = temp[2].toString();
                        String mes = temp[1].toString();
                        String dia = temp[0].toString();
                        fechaInicial = año+"-"+mes+"-"+dia;

                        String str2 = pantallamovimientosinventario.getTxt_Fecha_Final().getText();
                        String[] temp2;
                        temp2 = str2.split(delimiter);
                        for(int i =0; i < temp2.length ; i++){
                        }
                        String año2 = temp2[2].toString();
                        String mes2 = temp2[1].toString();
                        String dia2 = temp2[0].toString();
                        fechaFinal = año2+"-"+mes2+"-"+dia2;
                        System.out.println(fechaInicial+" a "+fechaFinal);                     
                        
                        //Para establecer el modelo al JTable
                        DefaultTableModel modelo = new DefaultTableModel();
                        pantallamovimientosinventario.getjTable_movimiento_inventario().setModel(modelo);
                        //
                        modelo.addColumn("fecha");
                        modelo.addColumn("tipo");
                        modelo.addColumn("CodProducto");
                        modelo.addColumn("Entradas");
                        modelo.addColumn("Salidas");
                        modelo.addColumn("Existencias");
                        modelo.addColumn("costoUnit");
                        modelo.addColumn("entradasImporte");
                        modelo.addColumn("salidasImporte");
                        modelo.addColumn("entradasImporte");

                        //Para agregar filas, primero crearemos un arreglo del tipo Object para ir almacenando nuestros datos que posteriormente adjuntaremos a nuestro modelo.
                        Object []object = new Object[10];
                        object[0] = "";
                        object[1] = "";
                        object[2] = "";
                        object[3] = "";
                        object[4] = "";
                        object[5] = "";
                        object[6] = "";
                        object[7] = "";
                        object[8] = "";
                        object[9] = "";

                        modelo.addRow(object);
                        DefaultTableModel modelo1 = (DefaultTableModel)pantallamovimientosinventario.getjTable_movimiento_inventario().getModel();
                        //miLogica.rellenartabla(pantallamovimientosinventario.getjTable_movimiento_inventario(), "select fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte from historial_mov CodProducto where CodProducto like '%"+text+"%'");
                        miLogica.rellenartabla_Movimientos(pantallamovimientosinventario.getjTable_movimiento_inventario(), "select fecha, tipo, CodProducto, entradas, salidas, existencias, costoUnit, entradasImporte, salidasImporte, totalImporte from historial_mov where CodProducto like '%"+text+"%' having fecha >= '"+fechaInicial+"' and fecha <= '"+fechaFinal+"'" ,modelo1);

                        String tipo = (String) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 1);
                        diseño_Tabla_Movimientos();

                        int[] var =calcular_Total_Entradas_Salidas();
                        pantallamovimientosinventario.getLbl_Total_Entradas().setText(""+var[0]);
                        pantallamovimientosinventario.getLbl_Total_Salidas().setText(""+var[1]);
                       double[] var2 = calcular_Total_EntradasImporte_SalidasImporte_TotalImporte();
                        pantallamovimientosinventario.getLbl_Total_Entradas_Importe().setText(""+var2[0]);
                        pantallamovimientosinventario.getLbl_Total_Salidas_Importe().setText(""+var2[1]);
                        pantallamovimientosinventario.getLbl_Total_Importe().setText(""+var2[2]);

                        pantallamovimientosinventario.getjTable_movimiento_inventario().setValueAt(calc_existencia_ini(tipo), 0, 5);
                        pantallamovimientosinventario.getjTable_movimiento_inventario().setValueAt(calc_importe_ini(tipo), 0, 9);
 
                }    
        });

    }
    
    private void escuchadoresnuevacompra(){
        
       nuevacompra.getTxt_buscar().getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    actualizar_Tabla_Inventario(e); 
                    borrar_Campos(e);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    actualizar_Tabla_Inventario(e);
                    borrar_Campos(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    actualizar_Tabla_Inventario(e);
                    borrar_Campos(e);
                }
                
                private void actualizar_Tabla_Inventario(DocumentEvent e) {
                    try {
                        String text = e.getDocument().getText(0, e.getDocument().getLength());
                        
                        String opcion = (String) nuevacompra.getjComboBox_opciones().getSelectedItem();

                        miLogica.rellenartabla(nuevacompra.getjTablerealizar_compra(), "select CodProducto, Categoria, Descripcion, Color,stock, PrecioVenta from altas_de_vestidos where "+opcion+" like '%"+text+"%'");

                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                }
                
                private void borrar_Campos(DocumentEvent e){
                    String path = "/Imagenes/noimage-lanczos3-lanczos3.png";  
                    URL url = this.getClass().getResource(path);  
                    ImageIcon icon = new ImageIcon(url); 
                    ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(nuevacompra.getLblmostrar_imagen().getWidth(), nuevacompra.getLblmostrar_imagen().getHeight(), Image.SCALE_DEFAULT));
                    nuevacompra.getLblmostrar_imagen().setIcon(icono); 
                    
                    nuevacompra.getTxt_costo_entero().setText("");
                    nuevacompra.getTxt_costo_decimal().setText("");
                    nuevacompra.getTxt_cant_max().setText("");
                    nuevacompra.getTxt_cant_min().setText("");
                    nuevacompra.getBtn_actualizar_valores().setEnabled(false);
                }
        });
       
        nuevacompra.getjTablerealizar_compra().addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent Mouse_evt) {
                        JTable table =(JTable) Mouse_evt.getSource();
                        Point point = Mouse_evt.getPoint();
                        row_variable = table.rowAtPoint(point);
                        if (Mouse_evt.getClickCount() == 1) {
                        //System.out.println(""+nuevacompra.getjTablerealizar_compra().getValueAt(nuevacompra.getjTablerealizar_compra().getSelectedRow(), 1));
                       
                        }
            }
        });
        
        nuevacompra.getBtn_realizar_compra().addActionListener((e) -> {
            
            String costo_entero_1 = nuevacompra.getTxt_costo_entero().getText();   
            String costo_decimal_1 = nuevacompra.getTxt_costo_decimal().getText();
            String costo_publico = costo_entero_1+"."+costo_decimal_1;
            float costo_publico_real = Float.parseFloat(costo_publico); 
            
            String columna = "stock";
            int fila = row_variable+1;
            venta[0]= nuevacompra.getjTablerealizar_compra().getValueAt(row_variable, 0);
            String cod_prod = venta[0].toString();
            int stock_tabla_nueva_compra = miLogica.saber_campos_columnas(columna,cod_prod);//saber el stock
           
             String cantidad_1 = nuevacompra.getTxt_cantidad().getText(); 
             
             if (cantidad_1.equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD");
            }else{
                 
                int cantidad = Integer.parseInt(cantidad_1);  
                int CantidadMax = miLogica.saber_campos_columnas("CantidadMax", cod_prod);
                int statusAlmacen = stock_tabla_nueva_compra+cantidad;//suma para saber si la nueva entrada supera la capacidad del almacen
               
                 if (  cantidad > 0) {
                     
                        if (statusAlmacen > CantidadMax) {
                            JOptionPane.showMessageDialog(null, "LA CANTIDAD SUPERA LA CAPACIDAD EN ALMACÉN"); 
                         
                        }else{                         
                          
                           int actualizar_stock = stock_tabla_nueva_compra+cantidad;                    
                          DecimalFormat df=new DecimalFormat("0.00");

                          double EntradaImporte = cantidad*costo_publico_real;   
                          String formate = df.format(EntradaImporte);
                          double EntradaImporte_exacto = Double.parseDouble(formate);                   

                          double sabertotalImporte= miLogica.saber_totalImporte(cod_prod);
                          double totalImporte = EntradaImporte+sabertotalImporte;
                          String formate2 = df.format(totalImporte);
                          double totalImporte_exacto = Double.parseDouble(formate2);                    

                          String SQL = "UPDATE altas_de_vestidos SET "+columna+"='"+stock_tabla_nueva_compra+"', "+columna+"='"+actualizar_stock+"'  WHERE id="+fila+"";
                          miLogica.registrar_Tabla_Movimientos_Entradas(fecha(),cod_prod,cantidad,actualizar_stock,costo_publico_real,EntradaImporte_exacto,totalImporte_exacto);

                           boolean res = miLogica.update_tabla_altas(SQL);
                           if (res==true) {
                               JOptionPane.showMessageDialog(null, "La compra se ha realizado Exitosamente","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                               nuevacompra.getTxt_cantidad().setText("");
                               nuevacompra.getTxt_cantidad().setEnabled(false);
                               miLogica.rellenartabla(nuevacompra.getjTablerealizar_compra(), "select CodProducto, Categoria, Descripcion, Talla, Color, stock from altas_de_vestidos");
                            }else{
                               JOptionPane.showMessageDialog(null, "NO SE COMPLETO LA COMPRA, INTENTELO DE NUEVO");
                           }
                        }
                    }else{                         
                      JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD MAYOR A '0'");
                    }
                 }             
        });
        
        nuevacompra.getBtn_editar_valores().addActionListener((e) -> {
            nuevacompra.getTxt_costo_entero().setEnabled(true);
            nuevacompra.getTxt_costo_decimal().setEnabled(true);
            nuevacompra.getTxt_cant_max().setEnabled(true);
            nuevacompra.getTxt_cant_min().setEnabled(true);
            nuevacompra.getBtn_actualizar_valores().setEnabled(true);
        });
        
        nuevacompra.getBtn_actualizar_valores().addActionListener((e) -> {
            
            String SQL="";
            int contador =0;
            
            
            venta[0]= nuevacompra.getjTablerealizar_compra().getValueAt(row_variable, 0);
            String cod_prod = venta[0].toString();
  /*********************************************************************************/          
            String columna = "PrecioVenta";
            float precio_actual = miLogica.saber_precio(cod_prod);
            
            String costo_entero_1 = nuevacompra.getTxt_costo_entero().getText();   
            String costo_decimal_1 = nuevacompra.getTxt_costo_decimal().getText();
            String costo_publico = costo_entero_1+"."+costo_decimal_1;
                        
            if (costo_entero_1.equals("") || costo_decimal_1.equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA PRECIO VALIDO CON ENTEROS Y DECIMALES");
                contador=+1;
            }
  /*********************************************************************************/
            String columna2= "CantidadMax";
            int cant_max_actual = miLogica.saber_campos_columnas(columna2, cod_prod);//funciona con el mismo metodo porque es int
            
            String cant_max = nuevacompra.getTxt_cant_max().getText();
            if (costo_entero_1.equals("") || costo_decimal_1.equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD MAXIMA");
                contador=+1;
            }
  /*********************************************************************************/
            String columna3 = "CantidadMin";
            int cant_min_actual = miLogica.saber_campos_columnas(columna2, cod_prod);//funciona con el mismo metodo porque es int
            
            String cant_min = nuevacompra.getTxt_cant_min().getText();
            if (costo_entero_1.equals("") || costo_decimal_1.equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD MINIMA");
                contador=+1;
            }
  /*********************************************************************************/
            
             if (contador == 0) {
                 
                int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea Actualizar los valores?", "Confirmar Actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    float costo_publico_real = Float.parseFloat(costo_publico);             
                    int cant_max_int = Integer.parseInt(cant_max);
                    int cant_min_int = Integer.parseInt(cant_min);

                     SQL = "UPDATE altas_de_vestidos SET "+columna+"='"+precio_actual+"', "+columna+"='"+costo_publico_real+"'  WHERE CodProducto="+cod_prod+"";
                     miLogica.update_tabla_altas(SQL);
                     SQL = "UPDATE altas_de_vestidos SET "+columna2+"='"+cant_max_actual+"', "+columna2+"='"+cant_max_int+"'  WHERE CodProducto="+cod_prod+"";
                     miLogica.update_tabla_altas(SQL);
                     SQL = "UPDATE altas_de_vestidos SET "+columna3+"='"+cant_min_actual+"', "+columna3+"='"+cant_min_int+"'  WHERE CodProducto="+cod_prod+"";
                     boolean res = miLogica.update_tabla_altas(SQL);
                     if (res==true) {
                         JOptionPane.showMessageDialog(null, "Sus datos han sido Actulizados Exitosamente","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                         nuevacompra.getTxt_costo_entero().setEnabled(false);
                         nuevacompra.getTxt_costo_decimal().setEnabled(false);
                         nuevacompra.getTxt_cant_max().setEnabled(false);
                         nuevacompra.getTxt_cant_min().setEnabled(false);
                         nuevacompra.getBtn_actualizar_valores().setEnabled(false);
                    }else{
                          JOptionPane.showMessageDialog(null, "ERROR EN EL SISTEMA","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                     }
                     
                }else if(opcion == JOptionPane.NO_OPTION){
                     nuevacompra.getTxt_costo_entero().setEnabled(false);
                     nuevacompra.getTxt_costo_decimal().setEnabled(false);
                     nuevacompra.getTxt_cant_max().setEnabled(false);
                     nuevacompra.getTxt_cant_min().setEnabled(false);
                     nuevacompra.getBtn_actualizar_valores().setEnabled(false);
                     
                }
            }
        });
                
        nuevacompra.getBtn_dar_alta_vestido().addActionListener((e) ->{
             agregarprenda = new AgregarPrenda();
            agregarprenda.setVisible(true);
            agregarprenda.setLocationRelativeTo(null);
            agregarprenda.setLayout(null);
            agregarprenda.setSize(990, 700);
            escuchadoresagregarprenda();
            agregarprenda.getTxt_descripcion().setLineWrap(true);
            nuevacompra.dispose();
                   
        
        });
        
        nuevacompra.getBtncancelar().addActionListener((e) -> {
        
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea cerrar sesión?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                nuevacompra.dispose();
                pantallalogin = new PantallaLogin();
                pantallalogin.setVisible(true);
                pantallalogin.setLocationRelativeTo(null);
                pantallalogin.setSize(310,560);
                escuchadoresventanalogin(); 
                
            }else if(opcion == JOptionPane.NO_OPTION){
                
            }
        });
    }
    
/**************************  listeners para escuchar la tabla de inventario  *************************/    
    public void setEventoMouseClicked(JTable tabla_inventario){
        
        tabla_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
 
        @Override
        public void mouseClicked(MouseEvent e) {
        tblEjemploMouseClicked(e);
        }
        });
    }
 
    private void tblEjemploMouseClicked(java.awt.event.MouseEvent evt) {
 
             if(evt.getButton()==MouseEvent.BUTTON1){
                 
                //Object[] venta = new Object[3];
                 
                row_variable = vistacatalogo.tabla_inventario.rowAtPoint(new Point(evt.getX(),evt.getY())); //Obtienes el número de la fila
                //vistacatalogo.tabla_inventario.setRowSelectionInterval(row,row); //Seleccionas la fila

                //Haces lo que quieras
                venta[0]= vistacatalogo.tabla_inventario.getValueAt(row_variable, 0);
                String cod_prod = venta[0].toString();
                venta[1]= vistacatalogo.tabla_inventario.getValueAt(row_variable, 1);
                venta[2]= vistacatalogo.tabla_inventario.getValueAt(row_variable, 5);
                venta[3]=vistacatalogo.tabla_inventario.getValueAt(row_variable, 4);
                
                //int fila = row_variable+1;
                 //System.out.println(fila);
                ImageIcon imagen = miLogica.mandar_imagen(cod_prod/*fila*/);
                ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(vistacatalogo.getLblverimagen().getWidth(), vistacatalogo.getLblverimagen().getHeight(), Image.SCALE_DEFAULT));
                vistacatalogo.getLblverimagen().setIcon(icono);
                
                String columna2= "Talla";
                String talla = miLogica.saber_campos_columnas2(columna2, cod_prod);//funciona con el mismo metodo porque
                
                vistacatalogo.getLbl_talla().setText(talla);
                vistacatalogo.getTxt_cantidad().setEnabled(true);
                vistacatalogo.getBtn_añadir_lista().setEnabled(true);
                
                
               // int columna = vistacatalogo.tabla_inventario.columnAtPoint(evt.getPoint());
                 //System.out.println("fila"+row_variable+"clumna"+columna);
                 
//                 System.out.println(venta[0]); //NO BORRAR
//                 System.out.println(venta[1]);
//                 System.out.println(venta[2]);
            
//                if ((row > -1) && (columna > -1))
//                   System.out.println(modelo.getValueAt(row,columna));
//               
              }
    } 

 /**************************  listeners para escuchar la tabla de compra de stock  *************************/  
    
    private void setEventoMouseClicked2(JTable jTablerealizar_compra) {
        jTablerealizar_compra.addMouseListener(new java.awt.event.MouseAdapter() {
 
        @Override
        public void mouseClicked(MouseEvent e) {
        ComprarVestidoMouseClicked(e);
        }
        });
    }
 
    private void ComprarVestidoMouseClicked(java.awt.event.MouseEvent evt) {
 
             if(evt.getButton()==MouseEvent.BUTTON1){
               
                row_variable = nuevacompra.getjTablerealizar_compra().rowAtPoint(new Point(evt.getX(),evt.getY())); //Obtienes el número de la fila
                //vistacatalogo.tabla_inventario.setRowSelectionInterval(row,row); //Seleccionas la fila

                //Haces lo que quieras
                int fila = row_variable+1;
                
                compra[0]= nuevacompra.getjTablerealizar_compra().getValueAt(row_variable, 0);
                String cod_prod = compra[0].toString();
                
                
                ImageIcon imagen = miLogica.mandar_imagen_nuevaCompra(cod_prod);
                ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(nuevacompra.getLblmostrar_imagen().getWidth(), nuevacompra.getLblmostrar_imagen().getHeight(), Image.SCALE_DEFAULT));
                nuevacompra.getLblmostrar_imagen().setIcon(icono);
               
                nuevacompra.getTxt_cantidad().setEnabled(true);
                nuevacompra.getBtn_editar_valores().setEnabled(true);
                nuevacompra.getBtn_realizar_compra().setEnabled(true);
                nuevacompra.getBtn_Limpiar().setEnabled(true);
                
                
                float precio_actual = miLogica.saber_precio(cod_prod);
                String precio_actual_string = Float.toString(precio_actual);
                System.out.println(precio_actual);
                String[] parts = precio_actual_string.split("\\."); 
                nuevacompra.getTxt_costo_entero().setText(parts[0]);
                nuevacompra.getTxt_costo_decimal().setText(parts[1]);
                
                String columna2= "CantidadMax";
                int cant_max_actual = miLogica.saber_campos_columnas(columna2, cod_prod);//funciona con el mismo metodo porque es int
                String cant_max = Integer.toString(cant_max_actual);
                nuevacompra.getTxt_cant_max().setText(cant_max);
                String columna3= "CantidadMin";
                int cant_min_actual = miLogica.saber_campos_columnas(columna3, cod_prod);//funciona con el mismo metodo porque es int
                String cant_min = Integer.toString(cant_min_actual);
                nuevacompra.getTxt_cant_min().setText(cant_min);       
                
                nuevacompra.getTxt_costo_entero().setEnabled(false);
                nuevacompra.getTxt_costo_decimal().setEnabled(false);
                nuevacompra.getTxt_cant_max().setEnabled(false);
                nuevacompra.getTxt_cant_min().setEnabled(false);
                nuevacompra.getBtn_actualizar_valores().setEnabled(false);
              }
    } 
    
    /**************************  listeners para escuchar la tabla de lista de productos  *************************/    
    public void setEventoMouseClicked3(JTable jTable_lista_productos){
        
        jTable_lista_productos.addMouseListener(new java.awt.event.MouseAdapter() {
 
        @Override
        public void mouseClicked(MouseEvent e) {
        tbllista_productosClicked(e);
        }
        });
    }
 
    private void tbllista_productosClicked(java.awt.event.MouseEvent evt) {
 
             if(evt.getButton()==MouseEvent.BUTTON1){
                 
                //Object[] venta = new Object[3];
                 
                row_variable_lista_productos = vistacatalogo.getjTable_lista_productos().rowAtPoint(new Point(evt.getX(),evt.getY())); //Obtienes el número de la fila
                //vistacatalogo.tabla_inventario.setRowSelectionInterval(row,row); //Seleccionas la fila

                   vistacatalogo.getBtn_remover_vestido().setEnabled(true);
              }
    } 
    
 
    
    public Date fecha(){
        
        java.util.Date dates=new java.util.Date();
        long fechaSis = dates.getTime();
        java.sql.Date d=new java.sql.Date(fechaSis);
        return d;
    }
    
    private int[] calcular_Total_Entradas_Salidas(){
        
        int[] result = new int[2];
        
        for (int i=1; i < pantallamovimientosinventario.getjTable_movimiento_inventario().getRowCount();i++) {          
            result[0] += (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 3);//totalEntradas
            result[1] += (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 4);//totalSalidas
        }
        return result;        
    }
    
    private int[] calcular_Total_Entradas_Salidas_Individual(){
        
        int[] result = new int[2];
        
        for (int i=0; i < pantallamovimientosinventario.getjTable_movimiento_inventario().getRowCount();i++) {          
            result[0] += (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 3);//totalEntradas
            result[1] += (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 4);//totalSalidas
        }
        return result;        
    }
    
    private double [] calcular_Total_EntradasImporte_SalidasImporte_TotalImporte(){
        
        double [] result = new double[3];
        double EntradasImporte=0,SalidasImporte=0,TotalImporte=0;
        
        for (int i=1; i < pantallamovimientosinventario.getjTable_movimiento_inventario().getRowCount();i++) {  
            
            EntradasImporte += (double) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 7);//EntradasImporte
            
            SalidasImporte += (double) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 8);//SalidasImporte
                        
            TotalImporte += (double) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 9);//TotalImporte
        }
        
        DecimalFormat df=new DecimalFormat("0.00");
        
        String formate = df.format(EntradasImporte);
        double EntradasImporte1 = Double.parseDouble(formate);
        result[0] = EntradasImporte1;
        
        String formate2 = df.format(SalidasImporte);
        double SalidasImporte1 = Double.parseDouble(formate2);
        result[1] =SalidasImporte1;
        
         String formate3 = df.format(TotalImporte);
         double TotalImporte1 = Double.parseDouble(formate3);
         result[2] = TotalImporte1;
            
        return result;         
    }
    
    private void diseño_Tabla_Movimientos() {
        
//        for (int i = 0; i < pantallamovimientosinventario.getjTable_movimiento_inventario().getRowCount(); i++) {
//            String var = (String) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(i, 1);
//            if (var.equals("SALIDA")) {
//                pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 6 ).setCellRenderer( new CellRenderer("coste ponderado") );
//            }
//        }
        //tamaño de columnas
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn(0).setPreferredWidth(40);
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn(1).setPreferredWidth(75);
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn(1).setMaxWidth(75);
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn(2).setPreferredWidth(50);
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn(3).setPreferredWidth(30);
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn(4).setPreferredWidth(30);
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn(5).setPreferredWidth(30);
        //altura de filas
        pantallamovimientosinventario.getjTable_movimiento_inventario().setRowHeight(30);
        //se asigna el nuevo CellRenderer a cada columna segun su contenido  
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 0 ).setCellRenderer( new CellRenderer("cantidades") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 1 ).setCellRenderer( new CellRenderer("icono") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 2 ).setCellRenderer( new CellRenderer("cantidades") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 3 ).setCellRenderer( new CellRenderer("cantidades") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 4 ).setCellRenderer( new CellRenderer("cantidades") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 5 ).setCellRenderer( new CellRenderer("cantidades") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 6 ).setCellRenderer( new CellRenderer("cantidades") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 7 ).setCellRenderer( new CellRenderer("costos") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 8 ).setCellRenderer( new CellRenderer("costos") );
        pantallamovimientosinventario.getjTable_movimiento_inventario().getColumnModel().getColumn( 9 ).setCellRenderer( new CellRenderer("costos") );

    }
    
    private int calc_existencia_ini(String tipo){
        
        int result=0;
        if (tipo.equals("COMPRA")) {
            int cantidad = (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 3);
            int existencias = (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 5);
            result =existencias-cantidad;
        }else{
            int cantidad = (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 4);
            int existencias = (int) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 5);
            result =existencias+cantidad;
        }
        
        return result;
    }
    
    private double calc_importe_ini(String tipo){
        
        double resultado=0;
        if (tipo.equals("COMPRA")) {
            
            double totalImporte = (double) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 9);
            double entradasImporte = (double) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 7);
            resultado =totalImporte-entradasImporte;
            
        }else if(tipo.equals("SALIDA")){
            double totalImporte = (double) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 9);
            double salidasImporte = (double) pantallamovimientosinventario.getjTable_movimiento_inventario().getValueAt(1, 8);
            resultado =totalImporte+salidasImporte;
        }
        DecimalFormat df=new DecimalFormat("0.00");
        
        String formate = df.format(resultado);
        double importe_ini = Double.parseDouble(formate);
        resultado = importe_ini;        
        
        return resultado;
    }
} 
