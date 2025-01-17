/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorHibernate;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import static vista.Transcripcio.frame;

/**
 *
 * @author Sergi
 */
public class Questionari extends javax.swing.JFrame {

    /**
     * Creates new form Questionari
     */
    JPanel buttons;
    JPanel question;
    JPanel title;
    JPanel button;
    ControladorHibernate controlador;
    
    ArrayList<String> preguntes = new ArrayList<String>();
    ArrayList<RespostesTest> respostes = new ArrayList<RespostesTest>();
    int idPacient;
    int numSessio;
    
    public Questionari(int idPacient, int numSessio) {
        initComponents();
        this.setTitle("Cuestionario");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        controlador = new ControladorHibernate();
        this.idPacient = idPacient;
        this.numSessio = numSessio;
        
        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        fillQuestions();
        createTitle();
         c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 30;
        jPanel1.add(title,c);
        for(int i=0;i<10;i++){
            RespostesTest test = new RespostesTest();
            respostes.add(test);
        }
       
        for(int i=0;i<20;i=i+2){          
            generateButtons(i/2);
            createQuestion(i/2);
            c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i+2;
            jPanel1.add(question,c);


            c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i+1+2;
            c.insets = new Insets(5,0,15,0);
            jPanel1.add(buttons,c);
        }
        createButton();
         c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 24;
            jPanel1.add(button,c);
        
        
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
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void createButton(){
        button = new JPanel();
        JButton acceptButton = new JButton("Aceptar");
        acceptButton.addActionListener((ActionEvent e) -> {
            for(int i=0;i<10;i++){
                controlador.crearResposta(String.valueOf(respostes.get(i).param), preguntes.get(i), idPacient, numSessio);
            }
            this.dispose();
        });
        button.add(acceptButton);
    }
    
    public void createTitle(){
        title = new JPanel();
        Font font = new Font("Tahoma", Font.BOLD,12);
        JLabel pregunta = new JLabel("Por favor, señale la opción que más se aproxime a cómo se siente usted ahora mismo");
        pregunta.setFont(font);
        title.add(pregunta);
    }
    
    public void createQuestion(int i) {
        question = new JPanel();
        JLabel pregunta = new JLabel(preguntes.get(i));
        //Font font = new Font("Tahoma", Font.BOLD,12);
        //pregunta.setFont(font);
        question.add(pregunta);
    }
    public void generateButtons(int i){
        buttons = new JPanel();
        FlowLayout experimentLayout = new FlowLayout();
        buttons.setLayout(experimentLayout);
         
        ButtonGroup group = new ButtonGroup();
        for(int j=0;j<10;j++){
            int temp= j+1;
            JRadioButton num1 = new JRadioButton(String.valueOf(temp));
            num1.setActionCommand(String.valueOf(temp));
            num1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {                 
                    respostes.get(i).setParam(temp);
                    System.out.println(temp);
                }
            });
            group.add(num1);
            buttons.add(num1);
        }
 
    }
    
    public void fillQuestions(){
        preguntes.add("Me siento mentalmente despierto");
        preguntes.add("Me siento capaz de recordar cosas importantes para mi");
        preguntes.add("Me siento capaz de recordar cosas que hago durante el día");
        preguntes.add("Me siento capaz de esforzarme para superar les dificultades");
        preguntes.add("Me siento capaz de hacer las tareas que me propongo");
        preguntes.add("Me siento capaz de encontrar soluciones a un problema");
        preguntes.add("Me siento optimista sobre el futuro");
        preguntes.add("Me siento satisfecho con mi vida");
        preguntes.add("Siento que tengo control sobre mi vida");
        preguntes.add("Me siento contento");   
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
            java.util.logging.Logger.getLogger(Questionari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Questionari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Questionari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Questionari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Questionari(0,0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}


class RespostesTest{
  int param;
  
  public void setParam(int i){
      param=i;
  }
  
  public int getParam(){
      return param;
  }
  
}
