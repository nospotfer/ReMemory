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
public class OHQSF extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public OHQSF(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "OHQSF";
        numPaginesTotal = this.getComponentCount();
        
        Utils.initTaula(OHQSFQPanel,OHQSFTotal);
    }

    @Override
    public void guardarResultats(Properties prop) {
        // OHQSF
        Utils.setProperty(prop,"OHQSFTotal",OHQSFTotal);
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

        ohqsfButtonGroup1 = new javax.swing.ButtonGroup();
        ohqsfButtonGroup2 = new javax.swing.ButtonGroup();
        ohqsfButtonGroup3 = new javax.swing.ButtonGroup();
        ohqsfButtonGroup4 = new javax.swing.ButtonGroup();
        ohqsfButtonGroup5 = new javax.swing.ButtonGroup();
        ohqsfButtonGroup6 = new javax.swing.ButtonGroup();
        ohqsfButtonGroup7 = new javax.swing.ButtonGroup();
        ohqsfButtonGroup8 = new javax.swing.ButtonGroup();
        ohqsfScroll = new javax.swing.JScrollPane();
        ohqsfPanel = new javax.swing.JPanel();
        jLabel30ohqs = new javax.swing.JLabel();
        OHQSFQPanel = new javax.swing.JPanel();
        orientacioBtn10ohqs = new javax.swing.JToggleButton();
        memoBtn10ohqs = new javax.swing.JToggleButton();
        orientacioBtn11ohqs = new javax.swing.JToggleButton();
        memoBtn11ohqs = new javax.swing.JToggleButton();
        orientacioBtn12ohqs = new javax.swing.JToggleButton();
        orientacioBtn13ohqs = new javax.swing.JToggleButton();
        raoBtn10ohqs = new javax.swing.JToggleButton();
        raoBtn11ohqs = new javax.swing.JToggleButton();
        raoBtn12ohqs = new javax.swing.JToggleButton();
        raoBtn13ohqs = new javax.swing.JToggleButton();
        activitatsFBtn10ohqs = new javax.swing.JToggleButton();
        activitatsFBtn11ohqs = new javax.swing.JToggleButton();
        activitatsFBtn12ohqs = new javax.swing.JToggleButton();
        activitatsFBtn13ohqs = new javax.swing.JToggleButton();
        activitatsDBtn10ohqs = new javax.swing.JToggleButton();
        activitatsDBtn11ohqs = new javax.swing.JToggleButton();
        activitatsDBtn12ohqs = new javax.swing.JToggleButton();
        activitatsDBtn13ohqs = new javax.swing.JToggleButton();
        cuidatBtn8ohqs = new javax.swing.JToggleButton();
        cuidatBtn10ohqs = new javax.swing.JToggleButton();
        jLabel105ohqs = new javax.swing.JLabel();
        jLabel108ohqs = new javax.swing.JLabel();
        jLabel141ohqs = new javax.swing.JLabel();
        jLabel142ohqs = new javax.swing.JLabel();
        jLabel143ohqs = new javax.swing.JLabel();
        jLabel144ohqs = new javax.swing.JLabel();
        jLabel145ohqs = new javax.swing.JLabel();
        jLabel146ohqs = new javax.swing.JLabel();
        jLabel147ohqs = new javax.swing.JLabel();
        jLabel148ohqs = new javax.swing.JLabel();
        jLabel110ohqs = new javax.swing.JLabel();
        jLabel34ohqs = new javax.swing.JLabel();
        jLabel35ohqs = new javax.swing.JLabel();
        jLabel36ohqs = new javax.swing.JLabel();
        jLabel37ohqs = new javax.swing.JLabel();
        jLabel38ohqs = new javax.swing.JLabel();
        jLabel39ohqs = new javax.swing.JLabel();
        jLabel40ohqs = new javax.swing.JLabel();
        jLabel43ohqs = new javax.swing.JLabel();
        jLabel44ohqs = new javax.swing.JLabel();
        jToggleButton3ohqs = new javax.swing.JToggleButton();
        jToggleButton4ohqs = new javax.swing.JToggleButton();
        jToggleButton6ohqs = new javax.swing.JToggleButton();
        jToggleButton7ohqs = new javax.swing.JToggleButton();
        jToggleButton8ohqs = new javax.swing.JToggleButton();
        jToggleButton9ohqs = new javax.swing.JToggleButton();
        jToggleButton10ohqs = new javax.swing.JToggleButton();
        jToggleButton11ohqs = new javax.swing.JToggleButton();
        jToggleButton12ohqs = new javax.swing.JToggleButton();
        jToggleButton13ohqs = new javax.swing.JToggleButton();
        jToggleButton14ohqs = new javax.swing.JToggleButton();
        jToggleButton16ohqs = new javax.swing.JToggleButton();
        jToggleButton18ohqs = new javax.swing.JToggleButton();
        jToggleButton20ohqs = new javax.swing.JToggleButton();
        jToggleButton22ohqs = new javax.swing.JToggleButton();
        jToggleButton24ohqs = new javax.swing.JToggleButton();
        jToggleButton26ohqs = new javax.swing.JToggleButton();
        jToggleButton28ohqs = new javax.swing.JToggleButton();
        jToggleButton30ohqs = new javax.swing.JToggleButton();
        memoBtn16ohqs = new javax.swing.JToggleButton();
        memoBtn17ohqs = new javax.swing.JToggleButton();
        jLabel149ohqs = new javax.swing.JLabel();
        jLabel150ohqs = new javax.swing.JLabel();
        jToggleButton31ohqs = new javax.swing.JToggleButton();
        jToggleButton32ohqs = new javax.swing.JToggleButton();
        jToggleButton33ohqs = new javax.swing.JToggleButton();
        jToggleButton34ohqs = new javax.swing.JToggleButton();
        jToggleButton35ohqs = new javax.swing.JToggleButton();
        ohqsjToggleButton36 = new javax.swing.JToggleButton();
        cuidatBtn11ohqs = new javax.swing.JToggleButton();
        jToggleButton37ohqs = new javax.swing.JToggleButton();
        jLabel14ohqs = new javax.swing.JLabel();
        jLabel213ohqs = new javax.swing.JLabel();
        OHQSFTotal = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel30ohqs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30ohqs.setText("Oxford Happiness Questionnaire-SF");

        OHQSFQPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qüestionari", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        OHQSFQPanel.setLayout(new java.awt.GridBagLayout());

        ohqsfButtonGroup2.add(orientacioBtn10ohqs);
        orientacioBtn10ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(orientacioBtn10ohqs, gridBagConstraints);

        ohqsfButtonGroup1.add(memoBtn10ohqs);
        memoBtn10ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(memoBtn10ohqs, gridBagConstraints);

        ohqsfButtonGroup2.add(orientacioBtn11ohqs);
        orientacioBtn11ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(orientacioBtn11ohqs, gridBagConstraints);

        ohqsfButtonGroup1.add(memoBtn11ohqs);
        memoBtn11ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(memoBtn11ohqs, gridBagConstraints);

        ohqsfButtonGroup2.add(orientacioBtn12ohqs);
        orientacioBtn12ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(orientacioBtn12ohqs, gridBagConstraints);

        ohqsfButtonGroup2.add(orientacioBtn13ohqs);
        orientacioBtn13ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(orientacioBtn13ohqs, gridBagConstraints);

        ohqsfButtonGroup3.add(raoBtn10ohqs);
        raoBtn10ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(raoBtn10ohqs, gridBagConstraints);

        ohqsfButtonGroup3.add(raoBtn11ohqs);
        raoBtn11ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(raoBtn11ohqs, gridBagConstraints);

        ohqsfButtonGroup5.add(raoBtn12ohqs);
        raoBtn12ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(raoBtn12ohqs, gridBagConstraints);

        ohqsfButtonGroup3.add(raoBtn13ohqs);
        raoBtn13ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(raoBtn13ohqs, gridBagConstraints);

        ohqsfButtonGroup4.add(activitatsFBtn10ohqs);
        activitatsFBtn10ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsFBtn10ohqs, gridBagConstraints);

        ohqsfButtonGroup4.add(activitatsFBtn11ohqs);
        activitatsFBtn11ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsFBtn11ohqs, gridBagConstraints);

        ohqsfButtonGroup5.add(activitatsFBtn12ohqs);
        activitatsFBtn12ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsFBtn12ohqs, gridBagConstraints);

        ohqsfButtonGroup5.add(activitatsFBtn13ohqs);
        activitatsFBtn13ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsFBtn13ohqs, gridBagConstraints);

        ohqsfButtonGroup6.add(activitatsDBtn10ohqs);
        activitatsDBtn10ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsDBtn10ohqs, gridBagConstraints);

        ohqsfButtonGroup6.add(activitatsDBtn11ohqs);
        activitatsDBtn11ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsDBtn11ohqs, gridBagConstraints);

        ohqsfButtonGroup5.add(activitatsDBtn12ohqs);
        activitatsDBtn12ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsDBtn12ohqs, gridBagConstraints);

        activitatsDBtn13ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(activitatsDBtn13ohqs, gridBagConstraints);

        ohqsfButtonGroup7.add(cuidatBtn8ohqs);
        cuidatBtn8ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(cuidatBtn8ohqs, gridBagConstraints);

        ohqsfButtonGroup7.add(cuidatBtn10ohqs);
        cuidatBtn10ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(cuidatBtn10ohqs, gridBagConstraints);

        jLabel105ohqs.setText("<html><center>Total<br>desacuerdo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        OHQSFQPanel.add(jLabel105ohqs, gridBagConstraints);

        jLabel108ohqs.setText("<html><center>Moderado<br>desacuerdo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        OHQSFQPanel.add(jLabel108ohqs, gridBagConstraints);

        jLabel141ohqs.setText("<html><center>Total<br>acuerdo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        OHQSFQPanel.add(jLabel141ohqs, gridBagConstraints);

        jLabel142ohqs.setText("<html><center>Moderado<br>acuerdo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        OHQSFQPanel.add(jLabel142ohqs, gridBagConstraints);

        jLabel143ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        OHQSFQPanel.add(jLabel143ohqs, gridBagConstraints);

        jLabel144ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        OHQSFQPanel.add(jLabel144ohqs, gridBagConstraints);

        jLabel145ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        OHQSFQPanel.add(jLabel145ohqs, gridBagConstraints);

        jLabel146ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        OHQSFQPanel.add(jLabel146ohqs, gridBagConstraints);

        jLabel147ohqs.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        OHQSFQPanel.add(jLabel147ohqs, gridBagConstraints);

        jLabel148ohqs.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        OHQSFQPanel.add(jLabel148ohqs, gridBagConstraints);

        jLabel110ohqs.setText("- No me encuentro atractivo/a .");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        OHQSFQPanel.add(jLabel110ohqs, gridBagConstraints);

        jLabel34ohqs.setText("- No me gusta mucho mi forma de ser.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        OHQSFQPanel.add(jLabel34ohqs, gridBagConstraints);

        jLabel35ohqs.setText("- Creo que la vida es muy gratificante.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        OHQSFQPanel.add(jLabel35ohqs, gridBagConstraints);

        jLabel36ohqs.setText("- Estoy muy satisfecho/a con mi vida.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        OHQSFQPanel.add(jLabel36ohqs, gridBagConstraints);

        jLabel37ohqs.setText("- Encuentro hermosas muchas cosas.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        OHQSFQPanel.add(jLabel37ohqs, gridBagConstraints);

        jLabel38ohqs.setText("- Tengo tiempo para hacer todo lo que quiero.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        OHQSFQPanel.add(jLabel38ohqs, gridBagConstraints);

        jLabel39ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        OHQSFQPanel.add(jLabel39ohqs, gridBagConstraints);

        jLabel40ohqs.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        OHQSFQPanel.add(jLabel40ohqs, gridBagConstraints);

        jLabel43ohqs.setText("- Me siento mentalmente despierto/a.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        OHQSFQPanel.add(jLabel43ohqs, gridBagConstraints);

        jLabel44ohqs.setText("- No tengo recuerdos muy felices del pasado .");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        OHQSFQPanel.add(jLabel44ohqs, gridBagConstraints);

        ohqsfButtonGroup7.add(jToggleButton3ohqs);
        jToggleButton3ohqs.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton3ohqs, gridBagConstraints);

        ohqsfButtonGroup8.add(jToggleButton4ohqs);
        jToggleButton4ohqs.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton4ohqs, gridBagConstraints);

        ohqsfButtonGroup6.add(jToggleButton6ohqs);
        jToggleButton6ohqs.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton6ohqs, gridBagConstraints);

        ohqsfButtonGroup3.add(jToggleButton7ohqs);
        jToggleButton7ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton7ohqs, gridBagConstraints);

        ohqsfButtonGroup4.add(jToggleButton8ohqs);
        jToggleButton8ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton8ohqs, gridBagConstraints);

        ohqsfButtonGroup4.add(jToggleButton9ohqs);
        jToggleButton9ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton9ohqs, gridBagConstraints);

        ohqsfButtonGroup6.add(jToggleButton10ohqs);
        jToggleButton10ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton10ohqs, gridBagConstraints);

        ohqsfButtonGroup6.add(jToggleButton11ohqs);
        jToggleButton11ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton11ohqs, gridBagConstraints);

        ohqsfButtonGroup7.add(jToggleButton12ohqs);
        jToggleButton12ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton12ohqs, gridBagConstraints);

        ohqsfButtonGroup8.add(jToggleButton13ohqs);
        jToggleButton13ohqs.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton13ohqs, gridBagConstraints);

        ohqsfButtonGroup8.add(jToggleButton14ohqs);
        jToggleButton14ohqs.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton14ohqs, gridBagConstraints);

        ohqsfButtonGroup8.add(jToggleButton16ohqs);
        jToggleButton16ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton16ohqs, gridBagConstraints);

        ohqsfButtonGroup1.add(jToggleButton18ohqs);
        jToggleButton18ohqs.setText("6");
        jToggleButton18ohqs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton18ohqsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton18ohqs, gridBagConstraints);

        ohqsfButtonGroup1.add(jToggleButton20ohqs);
        jToggleButton20ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton20ohqs, gridBagConstraints);

        ohqsfButtonGroup2.add(jToggleButton22ohqs);
        jToggleButton22ohqs.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton22ohqs, gridBagConstraints);

        ohqsfButtonGroup2.add(jToggleButton24ohqs);
        jToggleButton24ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton24ohqs, gridBagConstraints);

        ohqsfButtonGroup6.add(jToggleButton26ohqs);
        jToggleButton26ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton26ohqs, gridBagConstraints);

        ohqsfButtonGroup7.add(jToggleButton28ohqs);
        jToggleButton28ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton28ohqs, gridBagConstraints);

        ohqsfButtonGroup8.add(jToggleButton30ohqs);
        jToggleButton30ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton30ohqs, gridBagConstraints);

        ohqsfButtonGroup1.add(memoBtn16ohqs);
        memoBtn16ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(memoBtn16ohqs, gridBagConstraints);

        ohqsfButtonGroup1.add(memoBtn17ohqs);
        memoBtn17ohqs.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(memoBtn17ohqs, gridBagConstraints);

        jLabel149ohqs.setText("<html><center>Ligero<br>desacuerdo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        OHQSFQPanel.add(jLabel149ohqs, gridBagConstraints);

        jLabel150ohqs.setText("<html><center>Ligero<br>acuerdo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        OHQSFQPanel.add(jLabel150ohqs, gridBagConstraints);

        ohqsfButtonGroup3.add(jToggleButton31ohqs);
        jToggleButton31ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton31ohqs, gridBagConstraints);

        ohqsfButtonGroup3.add(jToggleButton32ohqs);
        jToggleButton32ohqs.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton32ohqs, gridBagConstraints);

        ohqsfButtonGroup4.add(jToggleButton33ohqs);
        jToggleButton33ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton33ohqs, gridBagConstraints);

        ohqsfButtonGroup4.add(jToggleButton34ohqs);
        jToggleButton34ohqs.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton34ohqs, gridBagConstraints);

        ohqsfButtonGroup5.add(jToggleButton35ohqs);
        jToggleButton35ohqs.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton35ohqs, gridBagConstraints);

        ohqsfButtonGroup5.add(ohqsjToggleButton36);
        ohqsjToggleButton36.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(ohqsjToggleButton36, gridBagConstraints);

        ohqsfButtonGroup7.add(cuidatBtn11ohqs);
        cuidatBtn11ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(cuidatBtn11ohqs, gridBagConstraints);

        ohqsfButtonGroup8.add(jToggleButton37ohqs);
        jToggleButton37ohqs.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        OHQSFQPanel.add(jToggleButton37ohqs, gridBagConstraints);

        jLabel14ohqs.setText("<html>A continuación hay una serie de afirmaciones sobre la felicidad.<br> Señala en cada una de ellas el grado de acuerdo o desacuerdo con el que mejor te identifiques<br>");

        jLabel213ohqs.setText("Puntuación total:");

        OHQSFTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OHQSFTotal.setText("0");

        javax.swing.GroupLayout ohqsfPanelLayout = new javax.swing.GroupLayout(ohqsfPanel);
        ohqsfPanel.setLayout(ohqsfPanelLayout);
        ohqsfPanelLayout.setHorizontalGroup(
            ohqsfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ohqsfPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ohqsfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30ohqs)
                    .addGroup(ohqsfPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(ohqsfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14ohqs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ohqsfPanelLayout.createSequentialGroup()
                                .addComponent(OHQSFQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel213ohqs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OHQSFTotal)))))
                .addGap(159, 159, 159))
        );
        ohqsfPanelLayout.setVerticalGroup(
            ohqsfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ohqsfPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30ohqs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14ohqs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ohqsfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ohqsfPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OHQSFQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ohqsfPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(ohqsfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel213ohqs)
                            .addComponent(OHQSFTotal))))
                .addGap(171, 171, 171))
        );

        ohqsfScroll.setViewportView(ohqsfPanel);

        add(ohqsfScroll, "card1");
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton18ohqsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton18ohqsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton18ohqsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OHQSFQPanel;
    private javax.swing.JLabel OHQSFTotal;
    private javax.swing.JToggleButton activitatsDBtn10ohqs;
    private javax.swing.JToggleButton activitatsDBtn11ohqs;
    private javax.swing.JToggleButton activitatsDBtn12ohqs;
    private javax.swing.JToggleButton activitatsDBtn13ohqs;
    private javax.swing.JToggleButton activitatsFBtn10ohqs;
    private javax.swing.JToggleButton activitatsFBtn11ohqs;
    private javax.swing.JToggleButton activitatsFBtn12ohqs;
    private javax.swing.JToggleButton activitatsFBtn13ohqs;
    private javax.swing.JToggleButton cuidatBtn10ohqs;
    private javax.swing.JToggleButton cuidatBtn11ohqs;
    private javax.swing.JToggleButton cuidatBtn8ohqs;
    private javax.swing.JLabel jLabel105ohqs;
    private javax.swing.JLabel jLabel108ohqs;
    private javax.swing.JLabel jLabel110ohqs;
    private javax.swing.JLabel jLabel141ohqs;
    private javax.swing.JLabel jLabel142ohqs;
    private javax.swing.JLabel jLabel143ohqs;
    private javax.swing.JLabel jLabel144ohqs;
    private javax.swing.JLabel jLabel145ohqs;
    private javax.swing.JLabel jLabel146ohqs;
    private javax.swing.JLabel jLabel147ohqs;
    private javax.swing.JLabel jLabel148ohqs;
    private javax.swing.JLabel jLabel149ohqs;
    private javax.swing.JLabel jLabel14ohqs;
    private javax.swing.JLabel jLabel150ohqs;
    private javax.swing.JLabel jLabel213ohqs;
    private javax.swing.JLabel jLabel30ohqs;
    private javax.swing.JLabel jLabel34ohqs;
    private javax.swing.JLabel jLabel35ohqs;
    private javax.swing.JLabel jLabel36ohqs;
    private javax.swing.JLabel jLabel37ohqs;
    private javax.swing.JLabel jLabel38ohqs;
    private javax.swing.JLabel jLabel39ohqs;
    private javax.swing.JLabel jLabel40ohqs;
    private javax.swing.JLabel jLabel43ohqs;
    private javax.swing.JLabel jLabel44ohqs;
    private javax.swing.JToggleButton jToggleButton10ohqs;
    private javax.swing.JToggleButton jToggleButton11ohqs;
    private javax.swing.JToggleButton jToggleButton12ohqs;
    private javax.swing.JToggleButton jToggleButton13ohqs;
    private javax.swing.JToggleButton jToggleButton14ohqs;
    private javax.swing.JToggleButton jToggleButton16ohqs;
    private javax.swing.JToggleButton jToggleButton18ohqs;
    private javax.swing.JToggleButton jToggleButton20ohqs;
    private javax.swing.JToggleButton jToggleButton22ohqs;
    private javax.swing.JToggleButton jToggleButton24ohqs;
    private javax.swing.JToggleButton jToggleButton26ohqs;
    private javax.swing.JToggleButton jToggleButton28ohqs;
    private javax.swing.JToggleButton jToggleButton30ohqs;
    private javax.swing.JToggleButton jToggleButton31ohqs;
    private javax.swing.JToggleButton jToggleButton32ohqs;
    private javax.swing.JToggleButton jToggleButton33ohqs;
    private javax.swing.JToggleButton jToggleButton34ohqs;
    private javax.swing.JToggleButton jToggleButton35ohqs;
    private javax.swing.JToggleButton jToggleButton37ohqs;
    private javax.swing.JToggleButton jToggleButton3ohqs;
    private javax.swing.JToggleButton jToggleButton4ohqs;
    private javax.swing.JToggleButton jToggleButton6ohqs;
    private javax.swing.JToggleButton jToggleButton7ohqs;
    private javax.swing.JToggleButton jToggleButton8ohqs;
    private javax.swing.JToggleButton jToggleButton9ohqs;
    private javax.swing.JToggleButton memoBtn10ohqs;
    private javax.swing.JToggleButton memoBtn11ohqs;
    private javax.swing.JToggleButton memoBtn16ohqs;
    private javax.swing.JToggleButton memoBtn17ohqs;
    private javax.swing.ButtonGroup ohqsfButtonGroup1;
    private javax.swing.ButtonGroup ohqsfButtonGroup2;
    private javax.swing.ButtonGroup ohqsfButtonGroup3;
    private javax.swing.ButtonGroup ohqsfButtonGroup4;
    private javax.swing.ButtonGroup ohqsfButtonGroup5;
    private javax.swing.ButtonGroup ohqsfButtonGroup6;
    private javax.swing.ButtonGroup ohqsfButtonGroup7;
    private javax.swing.ButtonGroup ohqsfButtonGroup8;
    private javax.swing.JPanel ohqsfPanel;
    private javax.swing.JScrollPane ohqsfScroll;
    private javax.swing.JToggleButton ohqsjToggleButton36;
    private javax.swing.JToggleButton orientacioBtn10ohqs;
    private javax.swing.JToggleButton orientacioBtn11ohqs;
    private javax.swing.JToggleButton orientacioBtn12ohqs;
    private javax.swing.JToggleButton orientacioBtn13ohqs;
    private javax.swing.JToggleButton raoBtn10ohqs;
    private javax.swing.JToggleButton raoBtn11ohqs;
    private javax.swing.JToggleButton raoBtn12ohqs;
    private javax.swing.JToggleButton raoBtn13ohqs;
    // End of variables declaration//GEN-END:variables
}
