/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Nastia_JMenu_JMenuItem.java
 *
 * Created on 06-ene-2013, 10:31:07
 */
package Nastias;

/**
*
* @author Evelyn Ortega Neri
*/
public class Nastia_JMenu_JMenuItem extends javax.swing.JFrame {

    /** Creates new form Nastia_JMenu_JMenuItem */
    public Nastia_JMenu_JMenuItem() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Nastia");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");
        jMenu3.add(jRadioButtonMenuItem1);
        jMenu3.add(jSeparator1);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");
        jMenu3.add(jCheckBoxMenuItem1);

        jMenu4.setText("jMenu4");

        jMenuItem4.setText("jMenuItem4");
        jMenu4.add(jMenuItem4);

        jMenu3.add(jMenu4);

        jMenuItem3.setText("jMenuItem3");
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() 
            {
            	
            	
            	 Nastia_JMenu_JMenuItem f=new Nastia_JMenu_JMenuItem();//Nastia_JMenu_JMenuItem().setVisible(true);
            	 f.setVisible(true);
            	// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
