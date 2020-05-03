/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.awt.Window;
import java.lang.reflect.Method;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Emanuel Rivera Aguilar Correo: elmenny_32@hotmail.com
 */
public class PantallaMovimientosInventario extends javax.swing.JFrame {

    /**
     * Creates new form PantallaMovimientosInventario
     */
    public PantallaMovimientosInventario() {
        initComponents();
//        txt_cod_prod.setText("Ingrese Cod. Producto");
        setOpaque(this, false);
        jTable_movimiento_inventario.getTableHeader().setReorderingAllowed(false);
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

    public JTable getjTable_movimiento_inventario() {
        return jTable_movimiento_inventario;
    }
    
    public JButton getBtncancelar() {
        return btncancelar;
    }

    public JTextField getTxt_Fecha_Final() {
        return txt_Fecha_Final;
    }

    public JTextField getTxt_Fecha_Inicio() {
        return txt_Fecha_Inicio;
    }

    public JTextField getTxt_cod_prod() {
        return txt_cod_prod;
    }

    public JComboBox<String> getjComboBox_Tipo() {
        return jComboBox_Tipo;
    }

    public JLabel getLbl_Total_Entradas() {
        return lbl_Total_Entradas;
    }

    public JLabel getLbl_Total_Salidas() {
        return lbl_Total_Salidas;
    }

    public JLabel getLbl_Total_Entradas_Importe() {
        return lbl_Total_Entradas_Importe;
    }

    public JLabel getLbl_Total_Salidas_Importe() {
        return lbl_Total_Salidas_Importe;
    }

    public JLabel getLbl_Total_Importe() {
        return lbl_Total_Importe;
    }

    public JButton getBtn_Fecha_Final() {
        return btn_Fecha_Final;
    }

    public JButton getBtn_Fecha_Inicio() {
        return btn_Fecha_Inicio;
    }

    public JButton getBtn_Fecha() {
        return btn_Fecha;
    }
      
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new cambodia.raven.DateChooser();
        dateChooser2 = new cambodia.raven.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_movimiento_inventario = new javax.swing.JTable();
        txt_Fecha_Final = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        txt_Fecha_Inicio = new javax.swing.JTextField();
        btn_Fecha_Inicio = new javax.swing.JButton();
        btn_Fecha_Final = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_Tipo = new javax.swing.JComboBox<>();
        txt_cod_prod = new javax.swing.JTextField();
        lbl_Total_Entradas = new javax.swing.JLabel();
        lbl_Total_Salidas = new javax.swing.JLabel();
        lbl_Total_Entradas_Importe = new javax.swing.JLabel();
        lbl_Total_Salidas_Importe = new javax.swing.JLabel();
        lbl_Total_Importe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_Fecha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        dateChooser1.setButton(btn_Fecha_Final);
        dateChooser1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        dateChooser1.setTextRefernce(txt_Fecha_Final);

        dateChooser2.setButton(btn_Fecha_Inicio);
        dateChooser2.setTextRefernce(txt_Fecha_Inicio);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_movimiento_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Tipo", "CodProducto", "entradas", "salidas", "existencias", "costo_unit", "entradasImporte", "salidasImporte", "totalImporte"
            }
        ));
        jTable_movimiento_inventario.setEnabled(false);
        jScrollPane1.setViewportView(jTable_movimiento_inventario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 1070, 280));

        txt_Fecha_Final.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        getContentPane().add(txt_Fecha_Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 170, 100, 30));

        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.setDefaultCapable(false);
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 553, 190, 40));

        txt_Fecha_Inicio.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        getContentPane().add(txt_Fecha_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 100, 30));

        btn_Fecha_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendario-2_318-11644-lanczos3.png"))); // NOI18N
        getContentPane().add(btn_Fecha_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 30, 30));

        btn_Fecha_Final.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendario-2_318-11644-lanczos3.png"))); // NOI18N
        getContentPane().add(btn_Fecha_Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 30, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("A");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 170, 20, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 90, 30));

        jComboBox_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "COMPRA", "SALIDA" }));
        getContentPane().add(jComboBox_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 140, 30));

        txt_cod_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cod_prodMouseClicked(evt);
            }
        });
        getContentPane().add(txt_cod_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 160, 30));

        lbl_Total_Entradas.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        lbl_Total_Entradas.setForeground(new java.awt.Color(255, 102, 102));
        lbl_Total_Entradas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_Total_Entradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 495, 85, 30));

        lbl_Total_Salidas.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        lbl_Total_Salidas.setForeground(new java.awt.Color(255, 102, 102));
        lbl_Total_Salidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_Total_Salidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 495, 80, 30));

        lbl_Total_Entradas_Importe.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lbl_Total_Entradas_Importe.setForeground(new java.awt.Color(255, 102, 102));
        lbl_Total_Entradas_Importe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_Total_Entradas_Importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 495, 130, 30));

        lbl_Total_Salidas_Importe.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lbl_Total_Salidas_Importe.setForeground(new java.awt.Color(255, 102, 102));
        lbl_Total_Salidas_Importe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_Total_Salidas_Importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 495, 120, 30));

        lbl_Total_Importe.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lbl_Total_Importe.setForeground(new java.awt.Color(255, 102, 102));
        lbl_Total_Importe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_Total_Importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 495, 120, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DE:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 50, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("COD. Prod:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 160, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fonditos-lanczos3 (1).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 490, 85, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fonditos-lanczos3 (1).png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 490, 90, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fonditos-lanczos3 (2).png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 490, 140, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fonditos-lanczos3 (2).png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 140, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 90, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fonditos-lanczos3 (2).png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 490, 140, 40));

        btn_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        btn_Fecha.setText("BUSCAR");
        getContentPane().add(btn_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 170, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/movimientos_444-lanczos3.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cod_prodMouseClicked
        //txt_cod_prod.setText("");
           
    }//GEN-LAST:event_txt_cod_prodMouseClicked

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
            java.util.logging.Logger.getLogger(PantallaMovimientosInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaMovimientosInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaMovimientosInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaMovimientosInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaMovimientosInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Fecha;
    private javax.swing.JButton btn_Fecha_Final;
    private javax.swing.JButton btn_Fecha_Inicio;
    private javax.swing.JButton btncancelar;
    private cambodia.raven.DateChooser dateChooser1;
    private cambodia.raven.DateChooser dateChooser2;
    private javax.swing.JComboBox<String> jComboBox_Tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_movimiento_inventario;
    private javax.swing.JLabel lbl_Total_Entradas;
    private javax.swing.JLabel lbl_Total_Entradas_Importe;
    private javax.swing.JLabel lbl_Total_Importe;
    private javax.swing.JLabel lbl_Total_Salidas;
    private javax.swing.JLabel lbl_Total_Salidas_Importe;
    private javax.swing.JTextField txt_Fecha_Final;
    private javax.swing.JTextField txt_Fecha_Inicio;
    private javax.swing.JTextField txt_cod_prod;
    // End of variables declaration//GEN-END:variables
}
