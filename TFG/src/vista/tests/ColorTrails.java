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
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.Timer;
import model.Pacient;
import vista.Sessio1;

/**
 *
 * @author a630703
 */
public class ColorTrails extends Test {

    
    private Timer timerColor;
    private Timer timerColor2;
    
    long secondsColor1 = 0;
    long secondsColor2 = 0;
    
    private long startTime;
    DecimalFormat timeFormatter;
    
    /**
     * Creates new form ColorTrails
     */
    public ColorTrails(Pacient pacientActual) {
        super(pacientActual);
        initComponents();
        
        label = "COLOR TRAILS";
        numPaginesTotal = this.getComponentCount();
        
        initColorTrails();
        
        initTimer();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // Color trails 1 time in seconds
        System.out.println((String)colorTrailsTable.getValueAt(0,1));
        prop.setProperty("color1timeRaw",getStringFromTable((String)colorTrailsTable.getValueAt(0,1)));
        prop.setProperty("color1timeStandard",getStringFromTable((String)colorTrailsTable.getValueAt(0,3)));
        prop.setProperty("color1timeTscore",getStringFromTable((String)colorTrailsTable.getValueAt(0,4)));
        prop.setProperty("color1timePercentile",getStringFromTable((String)colorTrailsTable.getValueAt(0,5)));
        // Color trails 1 errors
        prop.setProperty("color1errorRaw",getStringFromTable((String)colorTrailsTable.getValueAt(1,1)));
        prop.setProperty("color1errorPercentile",getStringFromTable((String)colorTrailsTable.getValueAt(1,2)));
        // Color trails 1 Near misses
        prop.setProperty("color1nearRaw",getStringFromTable((String)colorTrailsTable.getValueAt(2,1)));
        prop.setProperty("color1nearPercentile",getStringFromTable((String)colorTrailsTable.getValueAt(2,2)));
        // Color trails 1 prompts
        prop.setProperty("color1promptsRaw",getStringFromTable((String)colorTrailsTable.getValueAt(3,1)));
        prop.setProperty("color1promptsPercentile",getStringFromTable((String)colorTrailsTable.getValueAt(3,2)));
        // Color trails 2 time in seconds
        prop.setProperty("color2timeRaw",getStringFromTable((String)colorTrailsTable.getValueAt(4,1)));
        prop.setProperty("color2timeStandard",getStringFromTable((String)colorTrailsTable.getValueAt(4,3)));
        prop.setProperty("color2timeTscore",getStringFromTable((String)colorTrailsTable.getValueAt(4,4)));
        prop.setProperty("color2timePercentile",getStringFromTable((String)colorTrailsTable.getValueAt(4,5)));
        // Color trails 2 errors
        prop.setProperty("color2errorRaw",getStringFromTable((String)colorTrailsTable.getValueAt(5,1)));
        prop.setProperty("color2errorPercentile",getStringFromTable((String)colorTrailsTable.getValueAt(5,2)));
        // Color trails 2 Near misses
        prop.setProperty("color2nearRaw",getStringFromTable((String)colorTrailsTable.getValueAt(6,1)));
        prop.setProperty("color2nearPercentile",getStringFromTable((String)colorTrailsTable.getValueAt(6,2)));
        // Color trails 2 prompts
        prop.setProperty("color2promptsRaw",getStringFromTable((String)colorTrailsTable.getValueAt(7,1)));
        prop.setProperty("color2promptsPercentile",getStringFromTable((String)colorTrailsTable.getValueAt(7,2)));
        // Color trails interference index
        prop.setProperty("colorInterferenceRaw",getStringFromTable((String)colorTrailsTable.getValueAt(8,1)));
        prop.setProperty("colorInterferencePercentile",getStringFromTable((String)colorTrailsTable.getValueAt(8,2)));
    }

    private String getStringFromTable(String string) {
        if (string != null){
            return string;
        }
        else {
            return "";
        }
    }

    private void calculaIndexColor() {
        try {
            if (colorTrailsTable.getValueAt(4,1) != null && colorTrailsTable.getValueAt(0,1) != null) {
                int resultat1 = Integer.parseInt((String) colorTrailsTable.getValueAt(0, 1));
                int resultat2 = Integer.parseInt((String) colorTrailsTable.getValueAt(4, 1));
                colorTrailsTable.setValueAt(((float)(resultat2-resultat1)/resultat1)+"",8,1);
            }
//            int resultat = Integer.parseInt((String)colorTrailsTable.getValueAt(0,1)) + Integer.parseInt((String)colorTrailsTable.getValueAt(4,1));

        } catch (Exception ex){
            Logger.getLogger(Sessio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initColorTrails() {
        String header = "<html><center><font color=\"rgb(255,255,255)\">";
        CustomModel model = new CustomModel(
            new Object [][] {
                {"<html><b>Color Trails 1 - Time in seconds",null, "X", null, null, null},
                {"<html><b>Color Trails 1 - Errors",null, null, "X", "X", "X"},
                {"<html><b>Color Trails 1 - Near-Misses",null, null, "X", "X", "X"},
                {"<html><b>Color Trails 1 - Prompts",null, null, "X", "X", "X"},
                {"<html><b>Color Trails 2 - Time in seconds",null, "X", null, null, null},
                {"<html><b>Color Trails 2 - Errors",null, null, "X", "X", "X"},
                {"<html><b>Color Trails 2 - Near-Misses",null, null, "X", "X", "X"},
                {"<html><b>Color Trails 2 - Prompts",null, null, "X", "X", "X"},
                {"<html><b>Interference Index</b><br>(Color Trails 2 times raw score<br>minus Color Trails 1 time raw score)<br>/Color Trails 1 time raw score",null, null, "X", "X", "X"}
            },
            new String [] {
                "",header+"Raw<br>score", header+"Percentile<br>range", header+"Standard<br>score", header+"T<br>score", header+"Percentile<br>score"
            }
        );
        
        
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            false, true, true, false, false, false
        };
        
        System.out.println(model.getColumnCount());
        System.out.println(model.getRowCount());
        boolean edit[][] = new boolean[model.getColumnCount()][model.getRowCount()];
        for (boolean[] r: edit)
            Arrays.fill(r, false);
        
        Arrays.fill(edit[1],true);
        Arrays.fill(edit[2],true);
        
        model.setCanEditMatrix(edit);
        
        model.setCustom(true);
        model.setEditable(2, 0, false);
        model.setEditable(2, 4, false);
        model.setEditable(3, 0, true);
        model.setEditable(3, 4, true);
        model.setEditable(4, 0, true);
        model.setEditable(4, 4, true);
        model.setEditable(5, 0, true);
        model.setEditable(5, 4, true);
        
        model.setTypes(types);
        model.setCanEdit(canEdit);


        
        colorTrailsTable.setModel(model);
        
        //digitsDirecteTable.getColumnModel().getColumn(4).setCellRenderer( new customRenderer(true) );
        //digitsDirecteTable.getColumnModel().getColumn(0).setCellRenderer( new customRenderer(true) );
        
        
        for (int i=1; i<colorTrailsTable.getColumnModel().getColumnCount();i++){
            colorTrailsTable.getColumnModel().getColumn(i).setResizable(false);
            colorTrailsTable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
            colorTrailsTable.getColumnModel().getColumn(i).setPreferredWidth(120);
            colorTrailsTable.getColumnModel().getColumn(i).setCellRenderer( new CustomRenderer(true) );
        }
        
        colorTrailsTable.getColumnModel().getColumn(0).setResizable(false);
        
        //digitsDirecteTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        colorTrailsTable.getTableHeader().setReorderingAllowed(false);
        
        //colorTrailsTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        for (int i = 0; i<colorTrailsTable.getRowCount()-1; i++){
            colorTrailsTable.setRowHeight(i, 30);
        }
        colorTrailsTable.setRowHeight(8, 80);
        colorTrailsTable.getColumn(3).setPreferredWidth(120);
        colorTrailsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        colorTrailsTable.packAll();
        
    }
    
    private void initTimer() {
        
        timerColor = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long now = System.currentTimeMillis();
                long dif = now - startTime;
                
                secondsColor1 = dif / 1000;
                
                long minutes = dif / (60 * 1000);
                dif = Math.round(dif % (60 * 1000));
                long seconds = dif / 1000;
                dif = Math.round(dif % 1000);
                long centiseconds = dif / 10;
                colorTrailsCronoLabel.setText(timeFormatter.format(minutes) + ":"
                        + timeFormatter.format(seconds) + "."
                        + timeFormatter.format(centiseconds));
            }
            
        });
        
        timerColor2 = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long now = System.currentTimeMillis();
                long dif = now - startTime;
                
                secondsColor2 = dif / 1000;
                
                long minutes = dif / (60 * 1000);
                dif = Math.round(dif % (60 * 1000));
                long seconds = dif / 1000;
                dif = Math.round(dif % 1000);
                long centiseconds = dif / 10;
                colorTrailsCronoLabel1.setText(timeFormatter.format(minutes) + ":"
                        + timeFormatter.format(seconds) + "."
                        + timeFormatter.format(centiseconds));
            }
            
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        digitsDirecteScroll1 = new javax.swing.JScrollPane();
        digitsDirectePanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        colorTrailsTable = new org.jdesktop.swingx.JXTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        colorTrailsCronoBtn = new javax.swing.JButton();
        colorTrailsCronoLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        dataColor = new javax.swing.JLabel();
        colorTrailsCronoBtn1 = new javax.swing.JButton();
        colorTrailsCronoLabel1 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Color Trails");

        colorTrailsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        colorTrailsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        colorTrailsTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        colorTrailsTable.setRowSelectionAllowed(false);
        colorTrailsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        colorTrailsTable.setSortable(false);
        colorTrailsTable.setSortsOnUpdates(false);
        jScrollPane9.setViewportView(colorTrailsTable);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Normative table:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Notes:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        colorTrailsCronoBtn.setText("<html><center>Comença Crono Color Trails 1");
        colorTrailsCronoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorTrailsCronoBtnActionPerformed(evt);
            }
        });

        colorTrailsCronoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        colorTrailsCronoLabel.setText("00:00:00");

        jButton3.setText("Marcar data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        dataColor.setText("Data: \"encara no s'ha fet el test\"");

        colorTrailsCronoBtn1.setText("<html><center>Comença Crono Color Trails 2");
        colorTrailsCronoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorTrailsCronoBtn1ActionPerformed(evt);
            }
        });

        colorTrailsCronoLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        colorTrailsCronoLabel1.setText("00:00:00");

        jButton20.setText("Veure Taula");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout digitsDirectePanel1Layout = new javax.swing.GroupLayout(digitsDirectePanel1);
        digitsDirectePanel1.setLayout(digitsDirectePanel1Layout);
        digitsDirectePanel1Layout.setHorizontalGroup(
            digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel17)
                            .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                                        .addComponent(colorTrailsCronoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(colorTrailsCronoLabel))
                                    .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dataColor))
                                    .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                                        .addComponent(colorTrailsCronoBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(colorTrailsCronoLabel1))
                                    .addComponent(jButton20)))))
                    .addComponent(jLabel30))
                .addContainerGap())
        );
        digitsDirectePanel1Layout.setVerticalGroup(
            digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitsDirectePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addGroup(digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(digitsDirectePanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(colorTrailsCronoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(colorTrailsCronoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(colorTrailsCronoBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colorTrailsCronoLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(digitsDirectePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(dataColor))
                        .addGap(18, 18, 18)
                        .addComponent(jButton20))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        digitsDirecteScroll1.setViewportView(digitsDirectePanel1);

        add(digitsDirecteScroll1, "card1");
    }// </editor-fold>//GEN-END:initComponents

    private void colorTrailsCronoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorTrailsCronoBtnActionPerformed
        if (timerColor.isRunning()){
            timerColor.stop();
            colorTrailsCronoBtn.setText("Comença crono Color Trails 1");
            this.colorTrailsTable.setValueAt(secondsColor1+"", 0, 1);
            colorTrailsCronoLabel.setText("");
            calculaIndexColor();
        } else {
            this.secondsColor1 = 0;
            startTime = System.currentTimeMillis();
            this.timerColor.start();
            colorTrailsCronoBtn.setText("Marcar crono");
        }
    }//GEN-LAST:event_colorTrailsCronoBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataColor.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void colorTrailsCronoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorTrailsCronoBtn1ActionPerformed
        if (timerColor2.isRunning()){
            timerColor2.stop();
            colorTrailsCronoBtn1.setText("Comença crono Color Trails 2");
            this.colorTrailsTable.setValueAt(secondsColor2+"", 4, 1);
            colorTrailsCronoLabel1.setText("");
            calculaIndexColor();
        } else {
            this.secondsColor2 = 0;
            startTime = System.currentTimeMillis();
            this.timerColor2.start();
            colorTrailsCronoBtn1.setText("Marcar crono");
        }
    }//GEN-LAST:event_colorTrailsCronoBtn1ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        File file = new File(Utils.RES_PATH+"ColorTrails.pdf");
        if (file.exists()){
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Sessio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton20ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colorTrailsCronoBtn;
    private javax.swing.JButton colorTrailsCronoBtn1;
    private javax.swing.JLabel colorTrailsCronoLabel;
    private javax.swing.JLabel colorTrailsCronoLabel1;
    private org.jdesktop.swingx.JXTable colorTrailsTable;
    private javax.swing.JLabel dataColor;
    private javax.swing.JPanel digitsDirectePanel1;
    private javax.swing.JScrollPane digitsDirecteScroll1;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
