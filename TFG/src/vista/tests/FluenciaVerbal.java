/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.Utils;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import model.Pacient;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import vista.Sessio1;

/**
 *
 * @author a630703
 */
public class FluenciaVerbal extends Test {

    /**
     * Creates new form FluenciaVerbal
     */
    
    private Timer timer;
    private long startTime;
    DecimalFormat timeFormatter;
    JButton[] llistaBtnFV;
    public FluenciaVerbal(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "FLUÈNCIA VERBAL";

        numPaginesTotal = this.getComponentCount();

        initFluenciaVerbalTable();
        
        initTimer();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // Fluencia verbal
        prop.setProperty("fluenciaP",getStringFromTable((String)fluenciaVerbalTable.getValueAt(25,1)));
        prop.setProperty("fluenciaM",getStringFromTable((String)fluenciaVerbalTable.getValueAt(25,3)));
        prop.setProperty("fluenciaR",getStringFromTable((String)fluenciaVerbalTable.getValueAt(25,5)));
        prop.setProperty("fluenciaAnimals",getStringFromTable((String)fluenciaVerbalTable.getValueAt(25,7)));
    }

    private void initTimer() {
        this.llistaBtnFV = new JButton[1];
        llistaBtnFV[0] = FVStart1;
       
        timeFormatter = new DecimalFormat("00");
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                long now = System.currentTimeMillis();
                long dif = now - startTime;

                long minutes = dif / (60 * 1000);
                dif = Math.round(dif % (60 * 1000));
                long seconds = dif / 1000;
                dif = Math.round(dif % 1000);
                long centiseconds = dif / 10;

                llistaBtnFV[0].setText(timeFormatter.format(minutes) + ":"
                        + timeFormatter.format(seconds) + "."
                        + timeFormatter.format(centiseconds));
            }
        });
    }
    private String getStringFromTable(String string) {
        if (string != null){
            return string;
        }
        else {
            return "";
        }
    }

    private void initFluenciaVerbalTable() {
        String header = "<html><font color=\"rgb(255,255,255)\">";
        CustomModel model = new CustomModel(
                new Object [][] {
                        {"1.", null,"1.",null,"1.",null,"1.",null},
                        {"2.", null,"2.",null,"2.",null,"2.",null},
                        {"3.", null,"3.",null,"3.",null,"3.",null},
                        {"4.", null,"4.",null,"4.",null,"4.",null},
                        {"5.", null,"5.",null,"5.",null,"5.",null},
                        {"6.", null,"6.",null,"6.",null,"6.",null},
                        {"7.", null,"7.",null,"7.",null,"7.",null},
                        {"8.", null,"8.",null,"8.",null,"8.",null},
                        {"9.", null,"9.",null,"9.",null,"9.",null},
                        {"10.", null,"10.",null,"10.",null,"10.",null},
                        {"11.", null,"11.",null,"11.",null,"11.",null},
                        {"12.", null,"12.",null,"12.",null,"12.",null},
                        {"13.", null,"13.",null,"13.",null,"13.",null},
                        {"14.", null,"14.",null,"14.",null,"14.",null},
                        {"15.", null,"15.",null,"15.",null,"15.",null},
                        {"16.", null,"16.",null,"16.",null,"16.",null},
                        {"17.", null,"17.",null,"17.",null,"17.",null},
                        {"18.", null,"18.",null,"18.",null,"18.",null},
                        {"19.", null,"19.",null,"19.",null,"19.",null},
                        {"20.", null,"20.",null,"20.",null,"20.",null},
                        {"21.", null,"21.",null,"21.",null,"21.",null},
                        {"22.", null,"22.",null,"22.",null,"22.",null},
                        {"23.", null,"23.",null,"23.",null,"23.",null},
                        {"24.", null,"24.",null,"24.",null,"24.",null},
                        {"25.", null,"25.",null,"25.",null,"25.",null},
                        {"<html><b>Total", null,"<html><b>Total",null,"<html><b>Total",null,"<html><b>Total",null},
                        //{"<html><b>Percentil", null,"<html><b>Percentil",null,"<html><b>Percentil",null,"<html><b>Percentil",null}, // DESCOMENTAR SI SE QUIERE VOLVER A TENER PERCENTILES
                        {"<html><b>NSSA", null,"<html><b>NSSA",null,"<html><b>NSSA",null,"<html><b>NSSA",null}
                },
                new String [] {
                        "", header+"P", "", header+"M","", header+"R","", header+"ANIMALS"
                }
        );

        Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
                false, true, false, true,false, true,false, true
        };

        model.setTypes(types);
        model.setCanEdit(canEdit);

        fluenciaVerbalTable.setModel(model);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        fluenciaVerbalTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        fluenciaVerbalTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        fluenciaVerbalTable.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        fluenciaVerbalTable.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );

        for (int i=0; i<fluenciaVerbalTable.getColumnModel().getColumnCount();i++){
            fluenciaVerbalTable.getColumnModel().getColumn(i).setResizable(false);
            fluenciaVerbalTable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }


        fluenciaVerbalTable.getTableHeader().setReorderingAllowed(false);
        fluenciaVerbalTable.setHighlighters(HighlighterFactory.createSimpleStriping());

        for (int i = 0; i<fluenciaVerbalTable.getRowCount(); i++){
            fluenciaVerbalTable.setRowHeight(i, 20);
        }

        
        fluenciaVerbalTable.setRowHeight(25, 35);
        fluenciaVerbalTable.setRowHeight(26, 35);
        //fluenciaVerbalTable.setRowHeight(27, 35); //DESCOMENTAR SI SE QUIERE VOLVER A TENER PERCENTILES!


        fluenciaVerbalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        fluenciaVerbalTable.packAll();
        fluenciaVerbalTable.getColumn(1).setPreferredWidth(150);
        fluenciaVerbalTable.getColumn(3).setPreferredWidth(150);
        fluenciaVerbalTable.getColumn(5).setPreferredWidth(150);
        fluenciaVerbalTable.getColumn(7).setPreferredWidth(150);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fluenciaVerbalScroll2 = new javax.swing.JScrollPane();
        fluenciaVerbalPanel2 = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        fluenciaVerbalTable = new org.jdesktop.swingx.JXTable();
        jButton17 = new javax.swing.JButton();
        dataFluencia = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        FVStart1 = new javax.swing.JButton();
        FVStart1Button5 = new javax.swing.JButton();
        fiveDigitsFVStart1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        temps1 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        temps2 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel164.setText("Fluència verbal");

        fluenciaVerbalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "9 - 7			 ", null, "0", null},
                {null, "6 - 3", null, "0", null},
                {"2", "5 - 8 - 2			 ", null, "0", null},
                {null, "6 - 9 - 4			 ", null, "0", null},
                {"3", "7 - 2 - 8 - 6			 ", null, "0", null},
                {null, "6 - 4 - 3 - 9			 ", null, "0", null},
                {"4", "4 - 2 - 7 - 3 - 1			 ", null, "0", null},
                {null, "7 - 5 - 8 - 3 - 6			 ", null, "0", null},
                {"5", "3 - 9 - 2 - 4 - 8 - 7			 ", null, "0", null},
                {null, "6 - 1 - 9 - 7 - 4 - 2			 ", null, "0", null},
                {"6", "4 - 1 - 7 - 9 - 3 - 8 - 6			 ", null, "0", null},
                {null, "6 - 9 - 1 - 7 - 4 - 2 - 8			 ", null, "0", null},
                {"7", "3 - 8 - 2 - 9 - 6 - 1 - 7 - 4			 ", null, "0", null},
                {null, "5 - 8 - 1 - 3 - 2 - 6 - 4 - 7			 ", null, "0", null},
                {"8", "2 - 7 - 5 - 8 - 6 - 3 - 1 - 9 - 4			 ", null, "0", null},
                {null, "7 - 1 - 3 - 9 - 4 - 2 - 5 - 6 - 8			 ", null, "0", null}
            },
            new String [] {
                "Ítem", "Intent", "Resposta", "<html><center>Puntuació intent<br>(0-1)", "Puntuació ítem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fluenciaVerbalTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        fluenciaVerbalTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fluenciaVerbalTable.setRowSelectionAllowed(false);
        fluenciaVerbalTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        fluenciaVerbalTable.setSortable(false);
        fluenciaVerbalTable.setSortsOnUpdates(false);
        jScrollPane19.setViewportView(fluenciaVerbalTable);

        jButton17.setText("Marcar data");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        dataFluencia.setText("Data: Encara no s'ha realitzat el test");

        jButton21.setText("Veure Taula");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        FVStart1.setText("Començar Crono");
        FVStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FVStart1ActionPerformed(evt);
            }
        });

        FVStart1Button5.setText("Marcar Temps");
        FVStart1Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FVStart1Button5ActionPerformed(evt);
            }
        });

        fiveDigitsFVStart1.setText("Parar i Reiniciar");
        fiveDigitsFVStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsFVStart1ActionPerformed(evt);
            }
        });

        jLabel20.setText("Temps:");

        temps1.setText("00:00:00");

        jLabel78.setText("Temps:");

        temps2.setText("00:00:00");

        javax.swing.GroupLayout fluenciaVerbalPanel2Layout = new javax.swing.GroupLayout(fluenciaVerbalPanel2);
        fluenciaVerbalPanel2.setLayout(fluenciaVerbalPanel2Layout);
        fluenciaVerbalPanel2Layout.setHorizontalGroup(
            fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fluenciaVerbalPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel164)
                    .addGroup(fluenciaVerbalPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17)
                            .addComponent(dataFluencia)
                            .addComponent(jButton21)
                            .addGroup(fluenciaVerbalPanel2Layout.createSequentialGroup()
                                .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(FVStart1Button5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FVStart1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fiveDigitsFVStart1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fluenciaVerbalPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(temps1))
                                    .addGroup(fluenciaVerbalPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel78)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(temps2)))))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        fluenciaVerbalPanel2Layout.setVerticalGroup(
            fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fluenciaVerbalPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel164)
                .addGap(18, 18, 18)
                .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fluenciaVerbalPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                        .addGap(930, 930, 930))
                    .addGroup(fluenciaVerbalPanel2Layout.createSequentialGroup()
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataFluencia)
                        .addGap(18, 18, 18)
                        .addComponent(jButton21)
                        .addGap(38, 38, 38)
                        .addComponent(FVStart1)
                        .addGap(18, 18, 18)
                        .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FVStart1Button5)
                            .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(temps1)))
                        .addGap(18, 18, 18)
                        .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fiveDigitsFVStart1)
                            .addGroup(fluenciaVerbalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel78)
                                .addComponent(temps2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        fluenciaVerbalScroll2.setViewportView(fluenciaVerbalPanel2);

        add(fluenciaVerbalScroll2, "card1");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataFluencia.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        File file = new File(Utils.RES_PATH+"FluenciaVerbal.pdf");
        if (file.exists()){
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Sessio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void FVStart1Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FVStart1Button5ActionPerformed
        if (timer.isRunning()){
            temps1.setText(this.FVStart1.getText());
        }
    }//GEN-LAST:event_FVStart1Button5ActionPerformed

    private void fiveDigitsFVStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsFVStart1ActionPerformed
        if (timer.isRunning()){
            temps2.setText(this.FVStart1.getText());
            timer.stop();
            FVStart1.setText("<html><center>Comença Crono<br>Lectura");
            //lecturaTemps.setText(this.temps2.getText());
            FVStart1.setEnabled(true);
        }else {
            FVStart1.setText("<html><center>Comença Crono<br>Lectura");
            FVStart1.setEnabled(true);
        }
    }//GEN-LAST:event_fiveDigitsFVStart1ActionPerformed

    private void FVStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FVStart1ActionPerformed
        temps1.setText("00:00.00");
        temps2.setText("00:00.00");
        startTime = System.currentTimeMillis();
        timer.start();
        FVStart1.setEnabled(false);
    }//GEN-LAST:event_FVStart1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FVStart1;
    private javax.swing.JButton FVStart1Button5;
    private javax.swing.JLabel dataFluencia;
    private javax.swing.JButton fiveDigitsFVStart1;
    private javax.swing.JPanel fluenciaVerbalPanel2;
    private javax.swing.JScrollPane fluenciaVerbalScroll2;
    private org.jdesktop.swingx.JXTable fluenciaVerbalTable;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JLabel temps1;
    private javax.swing.JLabel temps2;
    // End of variables declaration//GEN-END:variables
}
