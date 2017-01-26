/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author Sergi
 */


public final class Sessio1Nivell3TestVisual extends javax.swing.JFrame {

    private String nomPacient,dia;
    private int datePosition=10;
    private int imagePositionY=50;

    /**
     * Creates new form Sessio1TestVisual
     * @param idPacient
     */
    public Sessio1Nivell3TestVisual(String nomPacient,String dia) {
        this.nomPacient = nomPacient;
        this.dia=dia;
        this.setTitle("Sessió 1 - Part 2");
        
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);;
        readAndShowImages();
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void readAndShowImages(){
        try (BufferedReader br = new BufferedReader(new FileReader("src"+ File.separator+"resources"+ File.separator+"fragments.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                final String[] data = line.split(",");
                JLabel date = new JLabel();
                date.setLocation(10, datePosition);
                if(!"ERROR".equals(data[1])){
                    if(data[1].length()>6){
                        String anyMesDia[] = data[1].split("_");
                        date.setText(anyMesDia[0].substring(0, 4)+" de "+anyMesDia[0].substring(4,6)+" del "+anyMesDia[0].substring(6,8));                   
                    }
                    else{
                        date.setText(data[1].substring(0, 4)+" de "+data[1].substring(4,6)+" del "+data[1].substring(6,8));
                    }

                    date.setSize(200, 50);
                    Font font = new Font("Tahoma", Font.BOLD,11);
                    date.setFont(font);
                    jPanel1.add(date);
                   
                    JLabel textContainer = new JLabel();
                    textContainer.setSize(602,77);
                    textContainer.setLocation(15, imagePositionY);
                    textContainer.setBackground(Color.black);
                    textContainer.setOpaque(true);

                    JTextArea textArea= new JTextArea();
                    textArea.setSize(600, 75);
                    textArea.setLocation(1, 1);
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    textArea.setText("Que recordes?");
                    textContainer.add(textArea);

                    jPanel1.add(textContainer);
                    //imagePositionX=15;
                    datePosition+=125;
                    imagePositionY+=125;
                }
            }   
        }       
        catch (IOException ex) {
            System.out.println("No s'ha pogut llegir el fitxer dels fragments");
        }
        
        jPanel1.invalidate();
        jPanel1.validate();
        jPanel1.repaint();
           
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
            java.util.logging.Logger.getLogger(Sessio1Nivell1TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sessio1Nivell1TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sessio1Nivell1TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sessio1Nivell1TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Sessio1Nivell1TestVisual(null,null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
