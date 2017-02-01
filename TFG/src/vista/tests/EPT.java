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
public class EPT extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public EPT(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "DUKE";
        numPaginesTotal = this.getComponentCount();
        
        Utils.initTaula(dukeQPanel,dukeTotal);
    }


    @Override
    public void guardarResultats(Properties prop) {
        // DUKE
        Utils.setProperty(prop,"dukeTotal",dukeTotal);
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

        dukeBtnGroup1 = new javax.swing.ButtonGroup();
        dukeBtnGroup2 = new javax.swing.ButtonGroup();
        dukeBtnGroup3 = new javax.swing.ButtonGroup();
        dukeBtnGroup4 = new javax.swing.ButtonGroup();
        dukeBtnGroup5 = new javax.swing.ButtonGroup();
        dukeBtnGroup6 = new javax.swing.ButtonGroup();
        dukeBtnGroup7 = new javax.swing.ButtonGroup();
        dukeBtnGroup8 = new javax.swing.ButtonGroup();
        dukeBtnGroup9 = new javax.swing.ButtonGroup();
        dukeBtnGroup10 = new javax.swing.ButtonGroup();
        dukeBtnGroup11 = new javax.swing.ButtonGroup();
        dukeScroll = new javax.swing.JScrollPane();
        dukePanel = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        dukeQPanel = new javax.swing.JPanel();
        orientacioBtn14 = new javax.swing.JToggleButton();
        memoBtn14 = new javax.swing.JToggleButton();
        orientacioBtn15 = new javax.swing.JToggleButton();
        memoBtn15 = new javax.swing.JToggleButton();
        orientacioBtn16 = new javax.swing.JToggleButton();
        memoBtn16 = new javax.swing.JToggleButton();
        memoBtn17 = new javax.swing.JToggleButton();
        orientacioBtn17 = new javax.swing.JToggleButton();
        raoBtn14 = new javax.swing.JToggleButton();
        raoBtn15 = new javax.swing.JToggleButton();
        raoBtn16 = new javax.swing.JToggleButton();
        raoBtn17 = new javax.swing.JToggleButton();
        activitatsFBtn14 = new javax.swing.JToggleButton();
        activitatsFBtn15 = new javax.swing.JToggleButton();
        activitatsFBtn16 = new javax.swing.JToggleButton();
        activitatsFBtn17 = new javax.swing.JToggleButton();
        activitatsDBtn14 = new javax.swing.JToggleButton();
        activitatsDBtn15 = new javax.swing.JToggleButton();
        activitatsDBtn16 = new javax.swing.JToggleButton();
        activitatsDBtn17 = new javax.swing.JToggleButton();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jToggleButton37 = new javax.swing.JToggleButton();
        jToggleButton38 = new javax.swing.JToggleButton();
        jToggleButton39 = new javax.swing.JToggleButton();
        jToggleButton40 = new javax.swing.JToggleButton();
        jToggleButton41 = new javax.swing.JToggleButton();
        jLabel217 = new javax.swing.JLabel();
        dukeTotal = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Evaluación Pre-Tratamiento - EPT");

        jLabel32.setText("<html>Instrucciones: Las siguientes preguntas se refieren al tratamiento que está a punto de recibir.<br> Queremos saber cómo cree usted que va a responder a este tratamiento.<br> Por favor, indique su grado de acuerdo con cada frase marcando la respuesta correspondiente.<br> No hay respuestas correctas o incorrectas. ");

        dukeQPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EPT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        dukeQPanel.setLayout(new java.awt.GridBagLayout());

        dukeBtnGroup2.add(orientacioBtn14);
        orientacioBtn14.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn14, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn14);
        memoBtn14.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn14, gridBagConstraints);

        dukeBtnGroup2.add(orientacioBtn15);
        orientacioBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn15, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn15);
        memoBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn15, gridBagConstraints);

        dukeBtnGroup2.add(orientacioBtn16);
        orientacioBtn16.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn16, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn16);
        memoBtn16.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn16, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn17);
        memoBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn17, gridBagConstraints);

        dukeBtnGroup2.add(orientacioBtn17);
        orientacioBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn17, gridBagConstraints);

        dukeBtnGroup3.add(raoBtn14);
        raoBtn14.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn14, gridBagConstraints);

        dukeBtnGroup3.add(raoBtn15);
        raoBtn15.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn15, gridBagConstraints);

        dukeBtnGroup5.add(raoBtn16);
        raoBtn16.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn16, gridBagConstraints);

        dukeBtnGroup3.add(raoBtn17);
        raoBtn17.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn17, gridBagConstraints);

        dukeBtnGroup4.add(activitatsFBtn14);
        activitatsFBtn14.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn14, gridBagConstraints);

        dukeBtnGroup4.add(activitatsFBtn15);
        activitatsFBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn15, gridBagConstraints);

        dukeBtnGroup5.add(activitatsFBtn16);
        activitatsFBtn16.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn16, gridBagConstraints);

        dukeBtnGroup5.add(activitatsFBtn17);
        activitatsFBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn17, gridBagConstraints);

        dukeBtnGroup6.add(activitatsDBtn14);
        activitatsDBtn14.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsDBtn14, gridBagConstraints);

        dukeBtnGroup6.add(activitatsDBtn15);
        activitatsDBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsDBtn15, gridBagConstraints);

        dukeBtnGroup5.add(activitatsDBtn16);
        activitatsDBtn16.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsDBtn16, gridBagConstraints);

        activitatsDBtn17.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsDBtn17, gridBagConstraints);

        jLabel112.setText("<html><center>Nada<br>(0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        dukeQPanel.add(jLabel112, gridBagConstraints);

        jLabel113.setText("<html><center>Algo<br>(1)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        dukeQPanel.add(jLabel113, gridBagConstraints);

        jLabel149.setText("<html><center>Mucho<br>(3)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        dukeQPanel.add(jLabel149, gridBagConstraints);

        jLabel150.setText("<html><center>Bastante<br>(2)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        dukeQPanel.add(jLabel150, gridBagConstraints);

        jLabel151.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        dukeQPanel.add(jLabel151, gridBagConstraints);

        jLabel152.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        dukeQPanel.add(jLabel152, gridBagConstraints);

        jLabel153.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        dukeQPanel.add(jLabel153, gridBagConstraints);

        jLabel154.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        dukeQPanel.add(jLabel154, gridBagConstraints);

        jLabel155.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        dukeQPanel.add(jLabel155, gridBagConstraints);

        jLabel114.setText("- Tengo miedo de este tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        dukeQPanel.add(jLabel114, gridBagConstraints);

        jLabel53.setText("- Este tratamiento será completamente efectivo.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel53, gridBagConstraints);

        jLabel54.setText("- Estoy preocupado con respecto al tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        dukeQPanel.add(jLabel54, gridBagConstraints);

        jLabel55.setText("- Mi problema se habrá resuelto completamente después del tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel55, gridBagConstraints);

        jLabel56.setText("- Tengo completa confianza en este tratamiento.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel56, gridBagConstraints);

        jLabel57.setText("<html>- Estoy nervioso con respecto a los efectos negativos <br>&nbsp  que pueda tener este tratamiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel57, gridBagConstraints);

        jLabel58.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        dukeQPanel.add(jLabel58, gridBagConstraints);

        dukeBtnGroup3.add(jToggleButton37);
        jToggleButton37.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton37, gridBagConstraints);

        dukeBtnGroup4.add(jToggleButton38);
        jToggleButton38.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton38, gridBagConstraints);

        dukeBtnGroup4.add(jToggleButton39);
        jToggleButton39.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton39, gridBagConstraints);

        dukeBtnGroup6.add(jToggleButton40);
        jToggleButton40.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton40, gridBagConstraints);

        dukeBtnGroup6.add(jToggleButton41);
        jToggleButton41.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton41, gridBagConstraints);

        jLabel217.setText("Puntuació total:");

        dukeTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dukeTotal.setText("0");

        javax.swing.GroupLayout dukePanelLayout = new javax.swing.GroupLayout(dukePanel);
        dukePanel.setLayout(dukePanelLayout);
        dukePanelLayout.setHorizontalGroup(
            dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dukePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(dukePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dukePanelLayout.createSequentialGroup()
                                .addComponent(dukeQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel217)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dukeTotal)))))
                .addGap(91, 91, 91))
        );
        dukePanelLayout.setVerticalGroup(
            dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dukePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dukeQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel217)
                        .addComponent(dukeTotal)))
                .addContainerGap())
        );

        dukeScroll.setViewportView(dukePanel);

        add(dukeScroll, "card1");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton activitatsDBtn14;
    private javax.swing.JToggleButton activitatsDBtn15;
    private javax.swing.JToggleButton activitatsDBtn16;
    private javax.swing.JToggleButton activitatsDBtn17;
    private javax.swing.JToggleButton activitatsFBtn14;
    private javax.swing.JToggleButton activitatsFBtn15;
    private javax.swing.JToggleButton activitatsFBtn16;
    private javax.swing.JToggleButton activitatsFBtn17;
    private javax.swing.ButtonGroup dukeBtnGroup1;
    private javax.swing.ButtonGroup dukeBtnGroup10;
    private javax.swing.ButtonGroup dukeBtnGroup11;
    private javax.swing.ButtonGroup dukeBtnGroup2;
    private javax.swing.ButtonGroup dukeBtnGroup3;
    private javax.swing.ButtonGroup dukeBtnGroup4;
    private javax.swing.ButtonGroup dukeBtnGroup5;
    private javax.swing.ButtonGroup dukeBtnGroup6;
    private javax.swing.ButtonGroup dukeBtnGroup7;
    private javax.swing.ButtonGroup dukeBtnGroup8;
    private javax.swing.ButtonGroup dukeBtnGroup9;
    private javax.swing.JPanel dukePanel;
    private javax.swing.JPanel dukeQPanel;
    private javax.swing.JScrollPane dukeScroll;
    private javax.swing.JLabel dukeTotal;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JToggleButton jToggleButton37;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton41;
    private javax.swing.JToggleButton memoBtn14;
    private javax.swing.JToggleButton memoBtn15;
    private javax.swing.JToggleButton memoBtn16;
    private javax.swing.JToggleButton memoBtn17;
    private javax.swing.JToggleButton orientacioBtn14;
    private javax.swing.JToggleButton orientacioBtn15;
    private javax.swing.JToggleButton orientacioBtn16;
    private javax.swing.JToggleButton orientacioBtn17;
    private javax.swing.JToggleButton raoBtn14;
    private javax.swing.JToggleButton raoBtn15;
    private javax.swing.JToggleButton raoBtn16;
    private javax.swing.JToggleButton raoBtn17;
    // End of variables declaration//GEN-END:variables
}
