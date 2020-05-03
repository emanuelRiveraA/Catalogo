
package Nastias;

import java.awt.Color;

import javax.swing.JFrame;
/**
*
* @author Evelyn Ortega Neri
*/

public class Nastia_JInternalFrame extends javax.swing.JPanel {

    public Nastia_JInternalFrame() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dkp = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jLabel5 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jLabel6 = new javax.swing.JLabel();

        dkp.setBackground(Color.black);
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel1.setText("Normal");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jInternalFrame1.setBounds(10, 10, 200, 125);
        dkp.add(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jInternalFrame2.setClosable(true);
        jInternalFrame2.setIconifiable(true);
        jInternalFrame2.setMaximizable(true);
        jInternalFrame2.setVisible(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame2.setResizable(true);
        jInternalFrame3.setResizable(true);
        jInternalFrame4.setResizable(true);
        jInternalFrame5.setResizable(true);
        jInternalFrame6.setResizable(true);
        

        jLabel2.setText("Minimizar,Cerrar y Maximizar");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jInternalFrame2.setBounds(220, 10, 200, 125);
        dkp.add(jInternalFrame2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jInternalFrame4.setTitle("Nastia de Ejemplo");
        jInternalFrame4.setToolTipText("Nastia de Ejemplo");
        jInternalFrame4.setVisible(true);

        jLabel4.setText("Con ToolTip Text y Titulo");

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jInternalFrame4.setBounds(220, 140, 200, 125);
        dkp.add(jInternalFrame4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jInternalFrame5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame5.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Mages/warevalid.png"))); // NOI18N
        jInternalFrame5.setOpaque(true);
        try {
            jInternalFrame5.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        jInternalFrame5.setVisible(true);

        jLabel5.setText("Icono,Cursor,opaco y seleccionado");

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jInternalFrame5.setBounds(10, 140, 200, 125);
        dkp.add(jInternalFrame5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jInternalFrame3.setResizable(true);
        jInternalFrame3.setVisible(true);

        jLabel3.setText("No dimensionar");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jInternalFrame3.setBounds(10, 270, 200, 125);
        dkp.add(jInternalFrame3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jInternalFrame6.setClosable(true);
        jInternalFrame6.setIconifiable(true);
        jInternalFrame6.setMaximizable(true);
        jInternalFrame6.setVisible(true);

        jLabel6.setText("Minimizar,Cerrar y Maximizar");

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jInternalFrame6.setBounds(220, 270, 200, 120);
        dkp.add(jInternalFrame6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkp, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkp, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        //pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	JFrame frm=new JFrame();
            	frm.add(new Nastia_JInternalFrame());
            	frm.setSize(600,400);
            	frm.setLocationRelativeTo(null);
            	frm.setVisible(true);
            	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              //  new Nastia_JInternalFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dkp;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
