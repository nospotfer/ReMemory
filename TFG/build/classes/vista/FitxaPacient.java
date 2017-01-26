/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import controlador.Utils;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Pacient;
import vista.tests.*;

/**
 *
 * @author USER
 */
public class FitxaPacient extends JFrame {

    Pacient pacientActual;
    Map<JComboBox, JDateChooser> dateMap;

    Frame parent;

    /**
     * Creates new form newFitxaPacient
     */
    public FitxaPacient(java.awt.Frame parent, Pacient pacientActual) {
        //super(parent);
        this.parent = parent;
        initComponents();
        Utils.setIcon(this);
        this.setLocationRelativeTo(null);
        this.pacientActual = pacientActual;
        
        addTabs();
        
//        numCigarretsText.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                change();
//            }
//            private void change(){
//                if (numCigarretsText.getText().matches("([0-9])+")) {
//                    String tabac = ""+(Integer.parseInt(numCigarretsText.getText())*365/20);
//                    tabacText.setText(tabac);
//                }
//            }
//        });
//        tabacText.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                change();
//            }
//            private void change(){
//                if (tabacText.getText().equals("") || tabacText.getText().equals("0")) {
//                    tabacCheck.setText("No");
//                }else {
//                    tabacCheck.setText("Sí");
//                }
//            }
//        });
//        cafeText.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                change();
//            }
//            private void change(){
//                if (cafeText.getText().equals("") || cafeText.getText().equals("0")) {
//                    cafeCheck.setText("No");
//                }else {
//                    cafeCheck.setText("Sí");
//                }
//            }
//        });
//        alcoholText.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                change();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                change();
//            }
//            private void change(){
//                if (alcoholText.getText().equals("") || alcoholText.getText().equals("0")) {
//                    alcoholCheck.setText("No");
//                }else {
//                    alcoholCheck.setText("Sí");
//                }
//            }
//        });
        carregarFitxa();
    }
    
    private void addTabs(){
        DadesBasiques dadesBasiques = new DadesBasiques(pacientActual);
        tabbedPanel.addTab(dadesBasiques.getLabel(), dadesBasiques);
        
        DadesMediques dadesMediques = new DadesMediques(pacientActual);
        tabbedPanel.addTab(dadesMediques.getLabel(), dadesMediques);
        
        ProvesComplementaries provesComplementaries = new ProvesComplementaries(pacientActual);
        tabbedPanel.addTab(provesComplementaries.getLabel(), provesComplementaries);
        
        Neuroimatge neuroimatge = new Neuroimatge(pacientActual);
        tabbedPanel.addTab(neuroimatge.getLabel(), neuroimatge);

        IndexClasseSocial indexClasseSocial = new IndexClasseSocial(pacientActual);
        tabbedPanel.addTab(indexClasseSocial.getLabel(), indexClasseSocial);

        IndexSocioeconomic indexSocioeconomic = new IndexSocioeconomic(pacientActual);
        tabbedPanel.addTab(indexSocioeconomic.getLabel(), indexSocioeconomic);

        UBE ube = new UBE(pacientActual);
        tabbedPanel.addTab(ube.getLabel(), ube);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fitxa pacient");

        mainPanel.setLayout(new java.awt.BorderLayout());

        dataPanel.setLayout(new java.awt.BorderLayout());

        tabbedPanel.setToolTipText("");
        dataPanel.add(tabbedPanel, java.awt.BorderLayout.CENTER);
        tabbedPanel.getAccessibleContext().setAccessibleParent(this);

        mainPanel.add(dataPanel, java.awt.BorderLayout.CENTER);

        acceptaBtn.setText("Aceptar");
        acceptaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptaBtnActionPerformed(evt);
            }
        });

        cancelaBtn.setText("Cancelar");
        cancelaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(acceptaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelaBtn)
                .addContainerGap(612, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptaBtn)
                    .addComponent(cancelaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptaBtnActionPerformed
        guardarFitxa();
        Utils.generaResultatsCSV(pacientActual.getId());
        ((MenuAvaluador)parent).checkCsv();
        ((MenuAvaluador)parent).checkCsvTotal();
        this.dispose();
    }//GEN-LAST:event_acceptaBtnActionPerformed

    private void cancelaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelaBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FitxaPacient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FitxaPacient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FitxaPacient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FitxaPacient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FitxaPacient dialog = new FitxaPacient(new javax.swing.JFrame(), null);
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
    private javax.swing.JButton acceptaBtn;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelaBtn;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables

    private void carregarFitxa(){
        Properties prop = new Properties();
        InputStream input = null;

        try {
            String str = Utils.PACIENT_DATA_PATH+pacientActual.getId()+File.separator+pacientActual.getId()+"Fitxa.dat";
            System.out.println(str);
            File file = new File(Utils.PACIENT_DATA_PATH+pacientActual.getId()+File.separator+pacientActual.getId()+"Fitxa.dat");
            if(!file.exists()) {
                file.createNewFile();
                Iterator it = dateMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    dateMap.get((JComboBox)pair.getKey()).setVisible(false);
                }
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);
                for (Component component : tabbedPanel.getComponents()) {
                ((Test)component).carregar(prop);
                }
                
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    private void guardarFitxa() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            File f = new File(Utils.PACIENT_DATA_PATH+pacientActual.getId()+File.separator);
            if (!f.exists()){
                f.mkdir();
            }
            File file = new File(Utils.PACIENT_DATA_PATH+pacientActual.getId()+File.separator+pacientActual.getId()+"Fitxa.dat");

            output = new FileOutputStream(file);

            for (Component component : tabbedPanel.getComponents()) {
                ((Test)component).guardarResultats(prop);
            }

            prop.store(output, "");

            // save properties to project root folder


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

}
