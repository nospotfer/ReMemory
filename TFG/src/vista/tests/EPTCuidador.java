/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.Utils;
import model.Pacient;

import java.util.Properties;

/**
 *
 * @author a630703
 */
public class EPTCuidador extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public EPTCuidador(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "EPT";
        numPaginesTotal = this.getComponentCount();
        
        Utils.initTaula(EPTQPanel,EPTTotalCuidador);
    }


    @Override
    public void guardarResultats(Properties prop) {
        // EPT
        Utils.setProperty(prop,"EPTTotalCuidador",EPTTotalCuidador);
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

        eptBtnGroup1 = new javax.swing.ButtonGroup();
        eptBtnGroup2 = new javax.swing.ButtonGroup();
        eptBtnGroup3 = new javax.swing.ButtonGroup();
        eptBtnGroup4 = new javax.swing.ButtonGroup();
        eptBtnGroup5 = new javax.swing.ButtonGroup();
        eptBtnGroup6 = new javax.swing.ButtonGroup();
        eptScroll = new javax.swing.JScrollPane();
        eptPanel = new javax.swing.JPanel();
        eptLabel33 = new javax.swing.JLabel();
        eptLabel32 = new javax.swing.JLabel();
        EPTQPanel = new javax.swing.JPanel();
        eptBtn1411 = new javax.swing.JToggleButton();
        eptBtn14 = new javax.swing.JToggleButton();
        eptBtn151 = new javax.swing.JToggleButton();
        eptBtn15 = new javax.swing.JToggleButton();
        eptBtn161 = new javax.swing.JToggleButton();
        eptBtn16 = new javax.swing.JToggleButton();
        eptBtn17 = new javax.swing.JToggleButton();
        eptBtn171 = new javax.swing.JToggleButton();
        eptBtn141 = new javax.swing.JToggleButton();
        eptBtn1511 = new javax.swing.JToggleButton();
        eptBtn1611 = new javax.swing.JToggleButton();
        eptBtn1711 = new javax.swing.JToggleButton();
        eptFBtn14 = new javax.swing.JToggleButton();
        eptFBtn15 = new javax.swing.JToggleButton();
        eptFBtn16 = new javax.swing.JToggleButton();
        eptFBtn17 = new javax.swing.JToggleButton();
        eptDBtn14 = new javax.swing.JToggleButton();
        eptDBtn15 = new javax.swing.JToggleButton();
        eptDBtn16 = new javax.swing.JToggleButton();
        eptDBtn17 = new javax.swing.JToggleButton();
        eptLabel112 = new javax.swing.JLabel();
        eptLabel11 = new javax.swing.JLabel();
        eptLabel149 = new javax.swing.JLabel();
        eptLabel150 = new javax.swing.JLabel();
        eptLabel151 = new javax.swing.JLabel();
        eptLabel152 = new javax.swing.JLabel();
        eptLabel153 = new javax.swing.JLabel();
        eptLabel154 = new javax.swing.JLabel();
        eptLabel155 = new javax.swing.JLabel();
        eptLabel114 = new javax.swing.JLabel();
        eptLabel53 = new javax.swing.JLabel();
        eptLabel54 = new javax.swing.JLabel();
        eptLabel55 = new javax.swing.JLabel();
        eptLabel56 = new javax.swing.JLabel();
        eptLabel57 = new javax.swing.JLabel();
        eptLabel58 = new javax.swing.JLabel();
        eptToggleButton37 = new javax.swing.JToggleButton();
        eptToggleButton38 = new javax.swing.JToggleButton();
        eptToggleButton39 = new javax.swing.JToggleButton();
        eptToggleButton40 = new javax.swing.JToggleButton();
        eptToggleButton41 = new javax.swing.JToggleButton();
        eptLabel217 = new javax.swing.JLabel();
        EPTTotalCuidador = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        eptLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eptLabel33.setText("Evaluación Pre-Tratamiento - EPT");

        eptLabel32.setText("<html>Instrucciones: Las siguientes preguntas se refieren al tratamiento que está a punto de recibir.<br> Queremos saber cómo cree usted que va a responder a este tratamiento.<br> Por favor, indique su grado de acuerdo con cada frase marcando la respuesta correspondiente.<br> No hay respuestas correctas o incorrectas. ");

        EPTQPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EPT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        EPTQPanel.setLayout(new java.awt.GridBagLayout());

        eptBtnGroup2.add(eptBtn1411);
        eptBtn1411.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn1411, gridBagConstraints);

        eptBtnGroup1.add(eptBtn14);
        eptBtn14.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn14, gridBagConstraints);

        eptBtnGroup2.add(eptBtn151);
        eptBtn151.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn151, gridBagConstraints);

        eptBtnGroup1.add(eptBtn15);
        eptBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn15, gridBagConstraints);

        eptBtnGroup2.add(eptBtn161);
        eptBtn161.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn161, gridBagConstraints);

        eptBtnGroup1.add(eptBtn16);
        eptBtn16.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn16, gridBagConstraints);

        eptBtnGroup1.add(eptBtn17);
        eptBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn17, gridBagConstraints);

        eptBtnGroup2.add(eptBtn171);
        eptBtn171.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn171, gridBagConstraints);

        eptBtnGroup3.add(eptBtn141);
        eptBtn141.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn141, gridBagConstraints);

        eptBtnGroup3.add(eptBtn1511);
        eptBtn1511.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn1511, gridBagConstraints);

        eptBtnGroup5.add(eptBtn1611);
        eptBtn1611.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn1611, gridBagConstraints);

        eptBtnGroup3.add(eptBtn1711);
        eptBtn1711.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptBtn1711, gridBagConstraints);

        eptBtnGroup4.add(eptFBtn14);
        eptFBtn14.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptFBtn14, gridBagConstraints);

        eptBtnGroup4.add(eptFBtn15);
        eptFBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptFBtn15, gridBagConstraints);

        eptBtnGroup5.add(eptFBtn16);
        eptFBtn16.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptFBtn16, gridBagConstraints);

        eptBtnGroup5.add(eptFBtn17);
        eptFBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptFBtn17, gridBagConstraints);

        eptBtnGroup6.add(eptDBtn14);
        eptDBtn14.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptDBtn14, gridBagConstraints);

        eptBtnGroup6.add(eptDBtn15);
        eptDBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptDBtn15, gridBagConstraints);

        eptBtnGroup5.add(eptDBtn16);
        eptDBtn16.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptDBtn16, gridBagConstraints);

        eptDBtn17.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptDBtn17, gridBagConstraints);

        eptLabel112.setText("<html><center>Nada<br>(0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        EPTQPanel.add(eptLabel112, gridBagConstraints);

        eptLabel11.setText("<html><center>Algo<br>(1)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        EPTQPanel.add(eptLabel11, gridBagConstraints);

        eptLabel149.setText("<html><center>Mucho<br>(3)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        EPTQPanel.add(eptLabel149, gridBagConstraints);

        eptLabel150.setText("<html><center>Bastante<br>(2)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        EPTQPanel.add(eptLabel150, gridBagConstraints);

        eptLabel151.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        EPTQPanel.add(eptLabel151, gridBagConstraints);

        eptLabel152.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        EPTQPanel.add(eptLabel152, gridBagConstraints);

        eptLabel153.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        EPTQPanel.add(eptLabel153, gridBagConstraints);

        eptLabel154.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        EPTQPanel.add(eptLabel154, gridBagConstraints);

        eptLabel155.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        EPTQPanel.add(eptLabel155, gridBagConstraints);

        eptLabel114.setText("- Tengo miedo de este tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        EPTQPanel.add(eptLabel114, gridBagConstraints);

        eptLabel53.setText("- Este tratamiento será completamente efectivo.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        EPTQPanel.add(eptLabel53, gridBagConstraints);

        eptLabel54.setText("- Estoy preocupado con respecto al tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        EPTQPanel.add(eptLabel54, gridBagConstraints);

        eptLabel55.setText("- Mi problema se habrá resuelto completamente después del tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        EPTQPanel.add(eptLabel55, gridBagConstraints);

        eptLabel56.setText("- Tengo completa confianza en este tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        EPTQPanel.add(eptLabel56, gridBagConstraints);

        eptLabel57.setText("<html>- Estoy nervioso con respecto a los efectos negativos <br>&nbsp  que pueda tener este tratamiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        EPTQPanel.add(eptLabel57, gridBagConstraints);

        eptLabel58.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        EPTQPanel.add(eptLabel58, gridBagConstraints);

        eptBtnGroup3.add(eptToggleButton37);
        eptToggleButton37.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptToggleButton37, gridBagConstraints);

        eptBtnGroup4.add(eptToggleButton38);
        eptToggleButton38.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptToggleButton38, gridBagConstraints);

        eptBtnGroup4.add(eptToggleButton39);
        eptToggleButton39.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptToggleButton39, gridBagConstraints);

        eptBtnGroup6.add(eptToggleButton40);
        eptToggleButton40.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptToggleButton40, gridBagConstraints);

        eptBtnGroup6.add(eptToggleButton41);
        eptToggleButton41.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        EPTQPanel.add(eptToggleButton41, gridBagConstraints);

        eptLabel217.setText("Puntuació total:");

        EPTTotalCuidador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EPTTotalCuidador.setText("0");

        javax.swing.GroupLayout eptPanelLayout = new javax.swing.GroupLayout(eptPanel);
        eptPanel.setLayout(eptPanelLayout);
        eptPanelLayout.setHorizontalGroup(
            eptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eptLabel33)
                    .addGroup(eptPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(eptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eptLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(eptPanelLayout.createSequentialGroup()
                                .addComponent(EPTQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eptLabel217)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EPTTotalCuidador)))))
                .addGap(91, 91, 91))
        );
        eptPanelLayout.setVerticalGroup(
            eptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eptLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eptLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EPTQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(eptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eptLabel217)
                        .addComponent(EPTTotalCuidador)))
                .addContainerGap())
        );

        eptScroll.setViewportView(eptPanel);

        add(eptScroll, "card1");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EPTQPanel;
    private javax.swing.JLabel EPTTotalCuidador;
    private javax.swing.JToggleButton eptBtn14;
    private javax.swing.JToggleButton eptBtn141;
    private javax.swing.JToggleButton eptBtn1411;
    private javax.swing.JToggleButton eptBtn15;
    private javax.swing.JToggleButton eptBtn151;
    private javax.swing.JToggleButton eptBtn1511;
    private javax.swing.JToggleButton eptBtn16;
    private javax.swing.JToggleButton eptBtn161;
    private javax.swing.JToggleButton eptBtn1611;
    private javax.swing.JToggleButton eptBtn17;
    private javax.swing.JToggleButton eptBtn171;
    private javax.swing.JToggleButton eptBtn1711;
    private javax.swing.ButtonGroup eptBtnGroup1;
    private javax.swing.ButtonGroup eptBtnGroup2;
    private javax.swing.ButtonGroup eptBtnGroup3;
    private javax.swing.ButtonGroup eptBtnGroup4;
    private javax.swing.ButtonGroup eptBtnGroup5;
    private javax.swing.ButtonGroup eptBtnGroup6;
    private javax.swing.JToggleButton eptDBtn14;
    private javax.swing.JToggleButton eptDBtn15;
    private javax.swing.JToggleButton eptDBtn16;
    private javax.swing.JToggleButton eptDBtn17;
    private javax.swing.JToggleButton eptFBtn14;
    private javax.swing.JToggleButton eptFBtn15;
    private javax.swing.JToggleButton eptFBtn16;
    private javax.swing.JToggleButton eptFBtn17;
    private javax.swing.JLabel eptLabel11;
    private javax.swing.JLabel eptLabel112;
    private javax.swing.JLabel eptLabel114;
    private javax.swing.JLabel eptLabel149;
    private javax.swing.JLabel eptLabel150;
    private javax.swing.JLabel eptLabel151;
    private javax.swing.JLabel eptLabel152;
    private javax.swing.JLabel eptLabel153;
    private javax.swing.JLabel eptLabel154;
    private javax.swing.JLabel eptLabel155;
    private javax.swing.JLabel eptLabel217;
    private javax.swing.JLabel eptLabel32;
    private javax.swing.JLabel eptLabel33;
    private javax.swing.JLabel eptLabel53;
    private javax.swing.JLabel eptLabel54;
    private javax.swing.JLabel eptLabel55;
    private javax.swing.JLabel eptLabel56;
    private javax.swing.JLabel eptLabel57;
    private javax.swing.JLabel eptLabel58;
    private javax.swing.JPanel eptPanel;
    private javax.swing.JScrollPane eptScroll;
    private javax.swing.JToggleButton eptToggleButton37;
    private javax.swing.JToggleButton eptToggleButton38;
    private javax.swing.JToggleButton eptToggleButton39;
    private javax.swing.JToggleButton eptToggleButton40;
    private javax.swing.JToggleButton eptToggleButton41;
    // End of variables declaration//GEN-END:variables
}