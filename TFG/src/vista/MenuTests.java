/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import model.Pacient;
import controlador.Utils;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;

/**
 *
 * @author USER
 */
public class MenuTests extends javax.swing.JDialog {

    String idPacient = "";
    Pacient pacientActual = null;
    String valoracio = "";
    Frame parent;
    
    /**
     * Creates new form menuTests
     */
    public MenuTests(Frame parent, boolean modal, Pacient pacientActual, String valoracio) {
        super(parent, modal);
        this.parent = parent;
        Utils.setIcon((JFrame)this.getOwner());
        initComponents();
        this.setTitle(this.getTitle()+" | T"+valoracio);
        this.setLocationRelativeTo(null);
        this.idPacient = pacientActual.getId();
        this.pacientActual = pacientActual;
        this.valoracio = valoracio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel2 = new javax.swing.JPanel();
        sessio1Btn = new javax.swing.JButton();
        sessio2Btn = new javax.swing.JButton();
        panel3 = new javax.swing.JPanel();
        valoracioCuidadorBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú tests");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Protocol neuropsicològic", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        panel2.setPreferredSize(new java.awt.Dimension(158, 102));
        panel2.setLayout(new java.awt.GridBagLayout());

        sessio1Btn.setText("Primera sessió");
        sessio1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessio1BtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel2.add(sessio1Btn, gridBagConstraints);

        sessio2Btn.setText("Segona sessió");
        sessio2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessio2BtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel2.add(sessio2Btn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        getContentPane().add(panel2, gridBagConstraints);

        panel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valoració cuidador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        panel3.setLayout(new java.awt.GridBagLayout());

        valoracioCuidadorBtn.setText("Valoració cuidador");
        valoracioCuidadorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valoracioCuidadorBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel3.add(valoracioCuidadorBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        getContentPane().add(panel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sessio1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessio1BtnActionPerformed
        if (pacientActual.getEdat() == -1){
            JOptionPane.showMessageDialog(this,
            "Falta l'edat del pacient. Per favor introdueixi-la a la fitxa. Comprovi també que el camp de \"Escolaritat (anys total)\" no estigui buit.",
            "Falten dades",
            JOptionPane.WARNING_MESSAGE);
        }else if (pacientActual.getAnysEscola() == -1){
            JOptionPane.showMessageDialog(this,
            "Falten els anys d'escolaritat del pacient. Per favor introdueixi'ls a la fitxa.",
            "Falten dades",
            JOptionPane.WARNING_MESSAGE);
        }else{
            Sessio1 tT = new Sessio1(parent, this.pacientActual, valoracio);
            tT.pack();
            tT.setExtendedState(JFrame.MAXIMIZED_BOTH);
            tT.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_sessio1BtnActionPerformed

    private void sessio2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessio2BtnActionPerformed
        if (pacientActual.getEdat() == -1){
            JOptionPane.showMessageDialog(this,
            "Falta l'edat del pacient. Per favor introdueixi-la a la fitxa. Comprovi també que el camp de \"Escolaritat (anys total)\" no estigui buit.",
            "Falten dades",
            JOptionPane.WARNING_MESSAGE);
        }else if (pacientActual.getAnysEscola() == -1){
            JOptionPane.showMessageDialog(this,
            "Falten els anys d'escolaritat del pacient. Per favor introdueixi'ls a la fitxa.",
            "Falten dades",
            JOptionPane.WARNING_MESSAGE);
        }else{
            Sessio2 tT = new Sessio2(this.pacientActual, valoracio);
            tT.pack();
            tT.setExtendedState(JFrame.MAXIMIZED_BOTH);
            tT.setVisible(true);
            tT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispose();
        }
    }//GEN-LAST:event_sessio2BtnActionPerformed

    private void valoracioCuidadorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valoracioCuidadorBtnActionPerformed
        ValoracioCuidador vC = new ValoracioCuidador(pacientActual, valoracio);
        vC.pack();
        vC.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vC.setVisible(true);
        vC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_valoracioCuidadorBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MenuTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuTests dialog = new MenuTests(new javax.swing.JFrame(), true,null, "");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JButton sessio1Btn;
    private javax.swing.JButton sessio2Btn;
    private javax.swing.JButton valoracioCuidadorBtn;
    // End of variables declaration//GEN-END:variables
}
