/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Reloj;

        
 /**
 *
 * @author Emanuel Rivera Aguilar Correo: elmenny_32@hotmail.com
 */
public class AgregarPrenda extends javax.swing.JFrame {

    /**
     * Creates new form AgregarPrenda
     */
    
 
    public AgregarPrenda() {
        initComponents();
        setOpaque(this, false);
        txt_fecha.setEditable(false);
        txt_fecha.setText("Fecha:  "+fecha());
        solo_digitos();
       
    }
    
    public static void setOpaque(Window window, boolean opaque) {

        try {

            Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
            if (awtUtilsClass != null) {

                Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class, boolean.class);
                method.invoke(null, window, opaque);

            }

        } catch (Exception exp) {
        }

    }

     public Date fecha()
    {
        java.util.Date dates=new java.util.Date();
        long fechaSis = dates.getTime();
        java.sql.Date d=new java.sql.Date(fechaSis);
        return d;
    }
    
    public JTextField getTxt_fecha() {
        return txt_fecha;
    }

    public static JButton getBtnagregar() {
        return btnagregar;
    }
        
    public JLabel getLblimagenpreview() {
        return lblimagenpreview;
    }

    public JComboBox<String> getCombo_talla() {
        return combo_talla;
    }

    public JComboBox<String> getjComboBox_categoria() {
        return jComboBox_categoria;
    }

    public JTextField getTxt_cod_prod() {
        return txt_cod_prod;
    }

    public JTextField getTxt_color() {
        return txt_color;
    }

    public JTextArea getTxt_descripcion() {
        return txt_descripcion;
    }

    public JTextField getTxt_costo_decimal() {
        return txt_costo_decimal;
    }

    public JTextField getTxt_costo_entero() {
        return txt_costo_entero;
    }

    public JTextField getTxt_cant_max() {
        return txt_cant_max;
    }

    public JTextField getTxt_cant_min() {
        return txt_cant_min;
    }
  
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_fecha = new javax.swing.JTextField();
        txt_cod_prod = new javax.swing.JTextField();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        btnagregar = new javax.swing.JButton();
        btnsubirimagen = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txt_color = new javax.swing.JTextField();
        combo_talla = new javax.swing.JComboBox<>();
        txt_costo_entero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_costo_decimal = new javax.swing.JTextField();
        lblimagenpreview = new javax.swing.JLabel();
        txt_cant_max = new javax.swing.JTextField();
        txt_cant_min = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(240, 180, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_fecha.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txt_fecha.setText("FECHA");
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 230, 30));

        txt_cod_prod.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txt_cod_prod.setForeground(new java.awt.Color(51, 51, 51));
        txt_cod_prod.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_cod_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_prodActionPerformed(evt);
            }
        });
        getContentPane().add(txt_cod_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 211, 290, 30));

        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- seleccione --", "Vestido de noche", "Vestido casual", "Cortos", "Midi", "Fiesta", "Lisos", "Estampados" }));
        jComboBox_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 290, 30));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        txt_descripcion.setOpaque(false);
        jScrollPane1.setViewportView(txt_descripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 290, 90));

        btnagregar.setBorderPainted(false);
        btnagregar.setContentAreaFilled(false);
        btnagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnagregar.setFocusPainted(false);
        btnagregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/equis-bicubic (1).png"))); // NOI18N
        btnagregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sign in.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 210, 50));

        btnsubirimagen.setBorderPainted(false);
        btnsubirimagen.setContentAreaFilled(false);
        getContentPane().add(btnsubirimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 190, 70));

        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 230, 50));

        txt_color.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txt_color.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(txt_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 290, 30));

        combo_talla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- seleccione --", "CHICA", "MEDIANA", "GRANDE", "EX GRANDE" }));
        combo_talla.setOpaque(false);
        combo_talla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tallaActionPerformed(evt);
            }
        });
        getContentPane().add(combo_talla, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 290, 30));

        txt_costo_entero.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txt_costo_entero.setForeground(new java.awt.Color(51, 51, 51));
        txt_costo_entero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costo_enteroActionPerformed(evt);
            }
        });
        getContentPane().add(txt_costo_entero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 190, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText(".");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 20, 20));

        txt_costo_decimal.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txt_costo_decimal.setForeground(new java.awt.Color(51, 51, 51));
        txt_costo_decimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costo_decimalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_costo_decimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, 70, 30));
        getContentPane().add(lblimagenpreview, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 270, 220));
        getContentPane().add(txt_cant_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 542, 120, 30));
        getContentPane().add(txt_cant_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 542, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dar_de_alta-lanczos3 (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 700));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText(".");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 20, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregarActionPerformed

    private void combo_tallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tallaActionPerformed

    private void txt_cod_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_prodActionPerformed

    private void jComboBox_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_categoriaActionPerformed

    private void txt_costo_enteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costo_enteroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costo_enteroActionPerformed

    private void txt_costo_decimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costo_decimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costo_decimalActionPerformed

    private void solo_digitos(){
        
        txt_cant_max.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              // Verificar si la tecla pulsada no es un digito
              if(((caracter < '0') ||
                 (caracter > '9')) &&
                 (caracter != '\b' /*corresponde a BACK_SPACE*/))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
        txt_cant_min.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              // Verificar si la tecla pulsada no es un digito
              if(((caracter < '0') ||
                 (caracter > '9')) &&
                 (caracter != '\b' /*corresponde a BACK_SPACE*/))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
        txt_costo_decimal.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              // Verificar si la tecla pulsada no es un digito
              if(txt_costo_decimal.getText().length()==2)
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
        
        
       txt_costo_entero.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              // Verificar si la tecla pulsada no es un digito
              if(((caracter < '0') ||
                 (caracter > '9')) &&
                 (caracter != '\b' /*corresponde a BACK_SPACE*/))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
       
       txt_costo_decimal.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              // Verificar si la tecla pulsada no es un digito
              if(((caracter < '0') ||
                 (caracter > '9')) &&
                 (caracter != '\b' /*corresponde a BACK_SPACE*/))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
   
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarPrenda().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnagregar;
    public static javax.swing.JButton btncancelar;
    public static javax.swing.JButton btnsubirimagen;
    private javax.swing.JComboBox<String> combo_talla;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblimagenpreview;
    private javax.swing.JTextField txt_cant_max;
    private javax.swing.JTextField txt_cant_min;
    private javax.swing.JTextField txt_cod_prod;
    private javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_costo_decimal;
    private javax.swing.JTextField txt_costo_entero;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_fecha;
    // End of variables declaration//GEN-END:variables

    
    
    
    
}