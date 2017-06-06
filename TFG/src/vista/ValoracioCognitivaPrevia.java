/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Utils;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Pacient;
import vista.tests.*;

/**
 *
 * @author USER
 */
public class ValoracioCognitivaPrevia extends javax.swing.JFrame {

    private Pacient pacientActual;
    private Frame parent;

    private ValoracioCognitivaPrevia(){

    }

    /**
     * Creates new form testsTextuals
     */
    ValoracioCognitivaPrevia(Frame parent, Pacient pacientActual) {
        Utils.setIcon(this);

        this.parent = parent;

        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addTabs();

        initTabs();
        this.pacientActual = pacientActual;

        Utils.carregar(tabbedPanel,pacientActual.getId(), "Test0");

        this.toFront();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataPanel = new javax.swing.JPanel();
        tabbedPanel = new javax.swing.JTabbedPane();
        buttonPanel = new javax.swing.JPanel();
        acceptaBtn = new javax.swing.JButton();
        cancelaBtn = new javax.swing.JButton();
        anteriorBtn = new javax.swing.JButton();
        seguentBtn = new javax.swing.JButton();
        paginaLabel = new javax.swing.JLabel();
        paginaLabel2 = new javax.swing.JLabel();
        copyLabel = new javax.swing.JLabel();
        sepBottom = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Valoració cognitiva prèvia");

        mainPanel.setLayout(new java.awt.BorderLayout());

        dataPanel.setLayout(new java.awt.BorderLayout());

        tabbedPanel.setToolTipText("");
        tabbedPanel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataPanel.add(tabbedPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(dataPanel, java.awt.BorderLayout.CENTER);

        acceptaBtn.setText("Accepta");
        acceptaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptaBtnActionPerformed(evt);
            }
        });

        cancelaBtn.setText("Cancel·la");
        cancelaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaBtnActionPerformed(evt);
            }
        });

        anteriorBtn.setText("Anterior");
        anteriorBtn.setEnabled(false);
        anteriorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorBtnActionPerformed(evt);
            }
        });

        seguentBtn.setText("Següent");
        seguentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seguentBtnActionPerformed(evt);
            }
        });

        paginaLabel.setText("1");

        paginaLabel2.setText("/ 10");

        copyLabel.setText("CDR – Spain/Spanish. Final version. 24 May 06 – Mapi Research Institute.");

        sepBottom.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(anteriorBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(seguentBtn)
                                .addGap(18, 18, 18)
                                .addComponent(paginaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(paginaLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(sepBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(copyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 729, Short.MAX_VALUE)
                                .addComponent(acceptaBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelaBtn)
                                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(acceptaBtn)
                                                        .addComponent(cancelaBtn)
                                                        .addComponent(anteriorBtn)
                                                        .addComponent(seguentBtn)
                                                        .addComponent(paginaLabel)
                                                        .addComponent(paginaLabel2)
                                                        .addComponent(copyLabel))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(sepBottom))
                                .addContainerGap())
        );

        mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptaBtnActionPerformed
        Utils.guardar(tabbedPanel,pacientActual.getId(), "Test0");
        guardarResultats();
        Utils.generaResultatsCSV(pacientActual.getId());
        ((MenuAvaluador)parent).checkCsv();
        //((MenuAvaluador)parent).checkCsvTotal();
        this.dispose();
    }//GEN-LAST:event_acceptaBtnActionPerformed

    private void cancelaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelaBtnActionPerformed

    private void anteriorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorBtnActionPerformed
        Test currentTest = (Test) tabbedPanel.getSelectedComponent();

        currentTest.paginaAnterior();

        int pagina = currentTest.getPagina();

        paginaLabel.setText((pagina)+"");

        if (pagina == 1){
            anteriorBtn.setEnabled(false);
            seguentBtn.setEnabled(true);
        }
        else if (pagina == currentTest.getNumPaginesTotal()-1){
            seguentBtn.setEnabled(true);
        }
    }//GEN-LAST:event_anteriorBtnActionPerformed

    private void seguentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seguentBtnActionPerformed
        Test currentTest = (Test) tabbedPanel.getSelectedComponent();

        currentTest.paginaSeguent();

        int pagina = currentTest.getPagina();
        paginaLabel.setText((pagina)+"");

        if (pagina == currentTest.getNumPaginesTotal()){
            seguentBtn.setEnabled(false);
            anteriorBtn.setEnabled(true);
        }
        else if (pagina == 2){
            anteriorBtn.setEnabled(true);
        }
    }//GEN-LAST:event_seguentBtnActionPerformed

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
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValoracioCognitivaPrevia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValoracioCognitivaPrevia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptaBtn;
    private javax.swing.JButton anteriorBtn;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelaBtn;
    private javax.swing.JLabel copyLabel;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel paginaLabel;
    private javax.swing.JLabel paginaLabel2;
    private javax.swing.JButton seguentBtn;
    private javax.swing.JSeparator sepBottom;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables

    private void initTabs() {
        int numPaginesTotal = ((Test)tabbedPanel.getSelectedComponent()).getNumPaginesTotal();
        paginaLabel2.setText("/ "+(numPaginesTotal)+"");
        tabbedPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int numPaginesTotal = ((Test)tabbedPanel.getSelectedComponent()).getNumPaginesTotal();
                if (numPaginesTotal > 1){
                    anteriorBtn.setEnabled(false);
                    seguentBtn.setEnabled(true);
                }else {
                    anteriorBtn.setEnabled(false);
                    seguentBtn.setEnabled(false);
                }
                paginaLabel.setText("1");
                paginaLabel2.setText("/ "+(numPaginesTotal)+"");

            }
        });
    }

    private void guardarResultats(){
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            File f = new File(Utils.PACIENT_DATA_PATH+pacientActual.getId()+File.separator);
            if (!f.exists()){
                f.mkdir();
            }
            File file = new File(Utils.PACIENT_DATA_PATH+pacientActual.getId()+File.separator+"resultsValCogPrev"+".dat");

            output = new FileOutputStream(file);

            for (Component component : tabbedPanel.getComponents()) {
                ((Test)component).guardarResultats(prop);
            }

            prop.store(output, "Valoracio cognitiva previa");

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addTabs() {
        CDR cdr = new CDR(pacientActual);
        tabbedPanel.addTab(cdr.getLabel(), cdr);

        CRC crc = new CRC(pacientActual);
        tabbedPanel.addTab(crc.getLabel(), crc);

        MMSE mmse = new MMSE(pacientActual);
        tabbedPanel.addTab(mmse.getLabel(), mmse);

        TAP tap = new TAP(pacientActual);
        tabbedPanel.addTab(tap.getLabel(), tap);
    }

}
