/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Sergi
 */
public class Sessio1Part3TestVisual extends javax.swing.JFrame {

    /**
     * Creates new form Sessio1Part1TestVisual
     */
    
    private int questionPosition=210;
    private String idPacient;
    private JLabel label1;
    private JTextField question;
    private JButton button;
    private int rowCounter=6;
    private GridBagConstraints c;
    private JButton acceptButton;
    private JLabel dummyText;
    private GridBagLayout gbl;
    
    public Sessio1Part3TestVisual(String idPacient) {
        this.idPacient=idPacient;
        this.setTitle("Sessió 1 - part 3");
        initComponents();
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        initComponentsWithBagGrid();
        
    }
      
    public void modificarPreguunta(int posx, int posy){
       
    }
    
    public void afegirPregunta(){
        jPanel1.remove(dummyText);
        JTextField askedQuestion = new JTextField(question.getText());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 25;      //make this component tall
	c.weightx = 0.0;
	c.gridwidth = 10;
	c.gridx = 1;
	c.gridy = rowCounter;
        Color color = new Color(240,240,240);
        askedQuestion.setBackground(color);
        askedQuestion.setEnabled(false);
        askedQuestion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font font = new Font("Tahoma", Font.BOLD,12);
        askedQuestion.setFont(font);
        jPanel1.add(askedQuestion, c);
        question.setText("");
        
        JTextField answer = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;      //make this component tall
	c.weightx = 0.0;
	c.gridwidth = 6;
	c.gridx = 1;
        c.insets = new Insets(10,20,10,20);
	c.gridy = rowCounter+1;
        jPanel1.add(answer, c);                      
        
        acceptButton.setEnabled(true);
        c.gridx = 7;
	c.gridy = rowCounter+3;
         c.insets = new Insets(10,20,10,20);
        c.gridwidth=1;
        jPanel1.add(acceptButton,c);
        
        JButton modifyButton = new JButton("Eliminar");
        c.gridx = 7;
        c.gridwidth=1;
        c.gridy=rowCounter+1;
        modifyButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            
                jPanel1.remove(askedQuestion);
                jPanel1.remove(answer);
                jPanel1.remove(modifyButton);
                
                jPanel1.invalidate();
                jPanel1.validate();
                jPanel1.repaint();

                jScrollPane2.invalidate();
                jScrollPane2.validate();
                jScrollPane2.repaint();

            
          }
        }); 
        jPanel1.add(modifyButton, c);
        
        rowCounter+=4;
        
        jPanel1.invalidate();
        jPanel1.validate();
        jPanel1.repaint();
        
        jScrollPane2.invalidate();
        jScrollPane2.validate();
        jScrollPane2.repaint();

        this.invalidate();
        this.validate();
        this.repaint();
    }
    
    private void initComponentsWithBagGrid(){
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);      
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                

        gbl = new GridBagLayout();
        jPanel1.setLayout(gbl);
        c = new GridBagConstraints();
        
        label1 = new JLabel("Introdueix aqui les noves preguntes");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.insets = new Insets(15,10,0,0);  //top padding
	c.gridx = 1;       //aligned with button 2
	c.gridwidth = 2;   //2 columns wide
	c.gridy = 0;       //third row
        Font font = new Font("Tahoma", Font.BOLD,12);
        label1.setFont(font);
        c.anchor = GridBagConstraints.PAGE_START;
	jPanel1.add(label1, c);
        
        question = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20,20,10,20); 
        c.ipady = 30;      //make this component tall
	c.weightx = 0.0;
	c.gridwidth = 10;
	c.gridx = 1;
	c.gridy = 1;
        jPanel1.add(question, c);
        
        button = new JButton("Afegir nova pregunta");
	c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 8; 
	c.weightx = 0.0;
	c.gridwidth = 3;
	c.gridx = 4;
	c.gridy = 2;
        
        button.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            if(!question.getText().equalsIgnoreCase("")){
                afegirPregunta();
            }
          }
        }); 
	jPanel1.add(button, c);
        
        label1 = new JLabel();
	c.fill = GridBagConstraints.HORIZONTAL;
	c.insets = new Insets(10,10,0,0);  //top padding
	c.gridx = 1;       //aligned with button 2
	c.gridwidth = 2;   //2 columns wide
	c.gridy = 3;       //third row
        font = new Font("Tahoma", font.BOLD, 14);
        label1.setFont(font);
        label1.setText("Preguntes");
	jPanel1.add(label1, c);
        
        
        acceptButton = new JButton("Acceptar");
        c.fill = GridBagConstraints.HORIZONTAL;      
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 4;       //aligned with button 2
        c.gridy = 7;
        c.gridheight=1;
        c.insets = new Insets(0,0,0,20);
        acceptButton.setEnabled(false);
        jPanel1.add(acceptButton, c);
        
        dummyText = new JLabel("No hi ha preguntes.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;       //aligned with button 2
        c.gridy = 7;
        font = new Font("Tahoma", Font.PLAIN,14);
        c.insets = new Insets(10,10,0,20);
        label1.setFont(font);
        jPanel1.add(dummyText, c);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Sessio1Part3TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sessio1Part3TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sessio1Part3TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sessio1Part3TestVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sessio1Part3TestVisual("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
