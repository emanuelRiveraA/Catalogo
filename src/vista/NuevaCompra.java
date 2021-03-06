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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Emanuel Rivera Aguilar Correo: elmenny_32@hotmail.com
 */
public class NuevaCompra extends javax.swing.JFrame {

    /**
     * Creates new form NuevaCompra
     */
    public NuevaCompra() {
        initComponents();
        solodigitos();
        txt_buscar.setText("Escribe para buscar");
        txt_fecha.setText("Fecha:  "+fecha());
        setOpaque(this, false);
        jTablerealizar_compra.getTableHeader().setReorderingAllowed(false);
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

    public JButton getBtncancelar() {
        return btncancelar;
    }

    public JTextField getTxt_cantidad() {
        return txt_cantidad;
    }

    public JTextField getTxt_costo_decimal() {
        return txt_costo_decimal;
    }

    public JTextField getTxt_costo_entero() {
        return txt_costo_entero;
    }

    public JTable getjTablerealizar_compra() {
        return jTablerealizar_compra;
    }

    public JLabel getLblmostrar_imagen() {
        return lblmostrar_imagen;
    }

    public JButton getBtn_realizar_compra() {
        return btn_realizar_compra;
    }

    public JButton getBtn_actualizar_valores() {
        return btn_actualizar_valores;
    }

    public JButton getBtn_editar_valores() {
        return btn_editar_valores;
    }

    public JButton getBtn_dar_alta_vestido() {
        return btn_dar_alta_vestido;
    }

    public JTextField getTxt_cant_max() {
        return txt_cant_max;
    }

    public JTextField getTxt_cant_min() {
        return txt_cant_min;
    }

    public JComboBox<String> getjComboBox_opciones() {
        return jComboBox_opciones;
    }

    public JTextField getTxt_buscar() {
        return txt_buscar;
    }

    public JTextField getTxt_fecha() {
        return txt_fecha;
    }

    public JButton getBtn_Limpiar() {
        return btn_Limpiar;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_buscar = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jComboBox_opciones = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablerealizar_compra = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        jLabel5 = new javax.swing.JLabel();
        lblmostrar_imagen = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        btn_editar_valores = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_costo_entero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_costo_decimal = new javax.swing.JTextField();
        txt_cant_max = new javax.swing.JTextField();
        txt_cant_min = new javax.swing.JTextField();
        btn_realizar_compra = new javax.swing.JButton();
        btn_actualizar_valores = new javax.swing.JButton();
        btn_dar_alta_vestido = new javax.swing.JButton();
        txt_fecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_buscarFocusLost(evt);
            }
        });
        txt_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_buscarMouseClicked(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 163, 200, 30));

        txt_cantidad.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txt_cantidad.setForeground(new java.awt.Color(51, 51, 51));
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 400, 200, 30));

        jComboBox_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATEGORIA", "DESCRIPCION", "TALLA", "COLOR" }));
        jComboBox_opciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 162, 150, 30));

        jTablerealizar_compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablerealizar_compra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 680, 230));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cant. Min:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 90, 30));

        lblmostrar_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage-lanczos3-lanczos3.png"))); // NOI18N
        lblmostrar_imagen.setText("foto");
        getContentPane().add(lblmostrar_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 220, 220));

        btncancelar.setBorder(null);
        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 560, 190, 40));

        btn_editar_valores.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_editar_valores.setText("Editar valores");
        btn_editar_valores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editar_valores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_valoresActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar_valores, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 190, -1));

        btn_Limpiar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 450, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio venta:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 110, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cant. Max:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 90, 30));

        txt_costo_entero.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txt_costo_entero.setForeground(new java.awt.Color(51, 51, 51));
        txt_costo_entero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costo_enteroActionPerformed(evt);
            }
        });
        getContentPane().add(txt_costo_entero, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 452, 190, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText(".");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 464, 20, 20));

        txt_costo_decimal.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txt_costo_decimal.setForeground(new java.awt.Color(51, 51, 51));
        txt_costo_decimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costo_decimalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_costo_decimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 452, 70, 30));
        getContentPane().add(txt_cant_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 120, 30));
        getContentPane().add(txt_cant_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 110, 30));

        btn_realizar_compra.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_realizar_compra.setText("Realizar compra");
        btn_realizar_compra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_realizar_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_realizar_compraActionPerformed(evt);
            }
        });
        getContentPane().add(btn_realizar_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, -1, -1));

        btn_actualizar_valores.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_actualizar_valores.setText("Actualizar Valores");
        btn_actualizar_valores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar_valores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_valoresActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar_valores, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 190, -1));

        btn_dar_alta_vestido.setBorder(null);
        btn_dar_alta_vestido.setBorderPainted(false);
        btn_dar_alta_vestido.setContentAreaFilled(false);
        btn_dar_alta_vestido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dar_alta_vestido.setDefaultCapable(false);
        btn_dar_alta_vestido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dar_alta_vestidoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dar_alta_vestido, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 553, 230, 50));

        txt_fecha.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txt_fecha.setText("FECHA");
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 230, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nueva_compra-lanczos3 (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        //txt_cantidad textField = new JTextField(10);
    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void btn_editar_valoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_valoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editar_valoresActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
       txt_cantidad.setText("");
       txt_costo_entero.setText("");
       txt_costo_decimal.setText("");
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void txt_costo_enteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costo_enteroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costo_enteroActionPerformed

    private void txt_costo_decimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costo_decimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costo_decimalActionPerformed

    private void btn_realizar_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_realizar_compraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_realizar_compraActionPerformed

    private void btn_actualizar_valoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_valoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizar_valoresActionPerformed

    private void txt_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarMouseClicked
            txt_buscar.setText("");
    }//GEN-LAST:event_txt_buscarMouseClicked

    private void txt_buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscarFocusLost
            //txt_buscar.setText("Escribe para buscar");
    }//GEN-LAST:event_txt_buscarFocusLost

    private void btn_dar_alta_vestidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dar_alta_vestidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dar_alta_vestidoActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaCompra().setVisible(true);
            }
        });
    }

    private void solodigitos() {
        
        txt_cantidad.addKeyListener(new KeyAdapter()
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
              // Verificar si la tecla pulsada no es un digito
              if(txt_costo_decimal.getText().length()==2)
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
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
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_actualizar_valores;
    private javax.swing.JButton btn_dar_alta_vestido;
    private javax.swing.JButton btn_editar_valores;
    private javax.swing.JButton btn_realizar_compra;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox<String> jComboBox_opciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablerealizar_compra;
    private javax.swing.JLabel lblmostrar_imagen;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cant_max;
    private javax.swing.JTextField txt_cant_min;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_costo_decimal;
    private javax.swing.JTextField txt_costo_entero;
    private javax.swing.JTextField txt_fecha;
    // End of variables declaration//GEN-END:variables
}
