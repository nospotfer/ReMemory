/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorHibernate;
import model.Avaluador;
import controlador.Utils;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import model.Usuari;

/**
 *
 * @author USER
 */
public class MenuAdmin extends javax.swing.JFrame {

    private String pacient;
    private ArrayList<Avaluador> llistaEvaluadors = new ArrayList<>();
    private GridBagConstraints constraint;
    WindowListener winListe;
    private ArrayList<JButton> llistaButtons = new ArrayList<>();
    private ControladorHibernate controlador;
    /**
     * Creates new form pacientMenu
     */
    public MenuAdmin(String pacient){
        initComponents();
        Utils.setIcon(this);
        controlador = new ControladorHibernate();
        this.pacient = pacient;
        pacientLabel.setText(pacient.toUpperCase());
        this.setLocationRelativeTo(null);
        
        constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.NORTHWEST;
        constraint.fill = GridBagConstraints.NONE;
        //constraint.gridx = 0;
        //constraint.gridy = GridBagConstraints.RELATIVE;
        constraint.weightx = 1.0f;
        constraint.weighty = 1.0f;



       
        initUsers();
        //initListener();
        initButtons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        pacientLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú administració");

        backBtn.setText("Volver al menú principal");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        pacientLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pacientLabel.setText("jLabel1");

        jButton1.setText("Crear evaluador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pacientLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backBtn)))
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pacientLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(jButton1))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Login l = new Login();
        l.pack();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NewUser nU = new NewUser(this,true);
        nU.addWindowListener(winListe);
        nU.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pacientLabel;
    // End of variables declaration//GEN-END:variables

    private void initUsers(){
        llistaEvaluadors.clear();
        
        List usuaris = controlador.getUsuaris();
        for(int i=0; i<usuaris.size();i++){
            Usuari usuari = (Usuari)usuaris.get(i);
            if(usuari.getRol()==2){
                Avaluador eva = new Avaluador(usuari.getNom(), String.valueOf(usuari.getId()), usuari.getContrasenya());
                llistaEvaluadors.add(eva);
            }
        }
    }

    private void editaUsuari(Avaluador eva){
        NewUser nU = new NewUser(this,true,llistaEvaluadors,eva);
        nU.addWindowListener(winListe);
        nU.setVisible(true);
    }
    
    private void initButtons() {
        jPanel1.repaint();
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();
        llistaButtons.clear();
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton) e.getSource();
                Avaluador eva = null;
                String comp = "";
                if (!"EVALUADOR SENSE NOM".equals(jb.getText())){
                    comp = jb.getText();
                }
                for (Avaluador ev : llistaEvaluadors){
                    if (ev.getNom().equals(comp)){
                        eva = ev;
                    }
                }
                editaUsuari(eva);
            }
         };
        int i = 0;
        for (Avaluador e : llistaEvaluadors){
            JButton button = new JButton();
            String nom = "AVALUADOR SENSE NOM";
            if (!"".equals(e.getNom())){
                nom = e.getNom();
            }
            button.setText(nom);
            button.addActionListener(action);
            button.setPreferredSize(new Dimension(200, 100));
            if (i%2 == 0){
                constraint.gridy++;
            }
            llistaButtons.add(button);
            jPanel1.add(button, constraint);
            i++;
        }
        jPanel1.invalidate();
        jPanel1.validate();
        jPanel1.repaint();
    }

    /*private void initListener() {
        winListe = new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                
                    initUsers();
                
                initButtons();
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
            
        };
    }*/
}