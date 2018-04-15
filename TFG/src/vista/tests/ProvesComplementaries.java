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
public class ProvesComplementaries extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public ProvesComplementaries(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "Proves Complementàries";
        numPaginesTotal = this.getComponentCount();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // Guarda les proves complementaries
        Utils.setProperty(prop,"ecgCodi",ecgCombo);
        Utils.setProperty(prop,"ecgDescripcio",ecgText);
        Utils.setProperty(prop,"ecgData",ecgData);

        Utils.setProperty(prop,"analiticaSangCodi",analiticaSangCombo);
        Utils.setProperty(prop,"analiticaSangDescripcio",analiticaSangText);
        Utils.setProperty(prop,"analiticaSangData",analiticaSangData);

        Utils.setProperty(prop,"analiticaOrina",analiticaOrinaCombo);
        Utils.setProperty(prop,"analiticaOrinaDescripcio",analiticaOrinaText);
        Utils.setProperty(prop,"analiticaOrinaData",analiticaOrinaData);

        Utils.setProperty(prop,"analiticaLcrCodi",analiticaLcrCombo);
        Utils.setProperty(prop,"analiticaLcrDescripcio",analiticaLcrText);
        Utils.setProperty(prop,"analiticaLcrData",analiticaLcrData);

        Utils.setProperty(prop,"geneticaCodi",geneticaCombo);
        Utils.setProperty(prop,"geneticaDescripcio",geneticaText);
        Utils.setProperty(prop,"geneticaData",geneticaData);

        Utils.setProperty(prop,"toraxCodi",toraxCombo);
        Utils.setProperty(prop,"toraxDescripcio",toraxText);
        Utils.setProperty(prop,"toraxData",toraxData);

        Utils.setProperty(prop,"eegCodi",eegCombo);
        Utils.setProperty(prop,"eegDescripcio",eegText);
        Utils.setProperty(prop,"eegData",eegData);

        Utils.setProperty(prop,"potencialsCodi",potencialsCombo);
        Utils.setProperty(prop,"potencialsDescripcio",potencialsText);
        Utils.setProperty(prop,"potencialsData",potencialsData);

        Utils.setProperty(prop,"emgCodi",emgCombo);
        Utils.setProperty(prop,"emgDescripcio",emgText);
        Utils.setProperty(prop,"emgData",emgData);

        Utils.setProperty(prop,"ntmsCodi",ntmsCombo);
        Utils.setProperty(prop,"ntmsDescripcio",ntmsText);
        Utils.setProperty(prop,"ntmsData",ntmsData);

        Utils.setProperty(prop,"anatomiaCodi",anatomiaCombo);
        Utils.setProperty(prop,"anatomiaDescripcio",anatomiaText);
        Utils.setProperty(prop,"anatomiaData",anatomiaData);
    }

    @Override
    public void carregar(Properties prop) {
        // Carrega les proves complementaries
        Utils.getProperty(prop,"ecgCodi",ecgCombo);
        Utils.getProperty(prop,"ecgDescripcio",ecgText);
        Utils.getProperty(prop,"ecgData",ecgData);

        Utils.getProperty(prop,"analiticaSangCodi",analiticaSangCombo);
        Utils.getProperty(prop,"analiticaSangDescripcio",analiticaSangText);
        Utils.getProperty(prop,"analiticaSangData",analiticaSangData);

        Utils.getProperty(prop,"analiticaOrina",analiticaOrinaCombo);
        Utils.getProperty(prop,"analiticaOrinaDescripcio",analiticaOrinaText);
        Utils.getProperty(prop,"analiticaOrinaData",analiticaOrinaData);

        Utils.getProperty(prop,"analiticaLcrCodi",analiticaLcrCombo);
        Utils.getProperty(prop,"analiticaLcrDescripcio",analiticaLcrText);
        Utils.getProperty(prop,"analiticaLcrData",analiticaLcrData);

        Utils.getProperty(prop,"geneticaCodi",geneticaCombo);
        Utils.getProperty(prop,"geneticaDescripcio",geneticaText);
        Utils.getProperty(prop,"geneticaData",geneticaData);

        Utils.getProperty(prop,"toraxCodi",toraxCombo);
        Utils.getProperty(prop,"toraxDescripcio",toraxText);
        Utils.getProperty(prop,"toraxData",toraxData);

        Utils.getProperty(prop,"eegCodi",eegCombo);
        Utils.getProperty(prop,"eegDescripcio",eegText);
        Utils.getProperty(prop,"eegData",eegData);

        Utils.getProperty(prop,"potencialsCodi",potencialsCombo);
        Utils.getProperty(prop,"potencialsDescripcio",potencialsText);
        Utils.getProperty(prop,"potencialsData",potencialsData);

        Utils.getProperty(prop,"emgCodi",emgCombo);
        Utils.getProperty(prop,"emgDescripcio",emgText);
        Utils.getProperty(prop,"emgData",emgData);

        Utils.getProperty(prop,"ntmsCodi",ntmsCombo);
        Utils.getProperty(prop,"ntmsDescripcio",ntmsText);
        Utils.getProperty(prop,"ntmsData",ntmsData);

        Utils.getProperty(prop,"anatomiaCodi",anatomiaCombo);
        Utils.getProperty(prop,"anatomiaDescripcio",anatomiaText);
        Utils.getProperty(prop,"anatomiaData",anatomiaData);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        provesComplementariesScroll = new javax.swing.JScrollPane();
        provesComplementariesPanel = new javax.swing.JPanel();
        codisLabel = new javax.swing.JLabel();
        ecgPanel = new javax.swing.JPanel();
        codiResultatLabel = new javax.swing.JLabel();
        descripcioLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        ecgCombo = new javax.swing.JComboBox<>();
        ecgText = new javax.swing.JTextField();
        ecgData = new com.toedter.calendar.JDateChooser();
        analiticaSangPanel = new javax.swing.JPanel();
        codiResultatLabel1 = new javax.swing.JLabel();
        descripcioLabel1 = new javax.swing.JLabel();
        dataLabel1 = new javax.swing.JLabel();
        analiticaSangCombo = new javax.swing.JComboBox<>();
        analiticaSangText = new javax.swing.JTextField();
        analiticaSangData = new com.toedter.calendar.JDateChooser();
        analiticaOrinaPanel = new javax.swing.JPanel();
        codiResultatLabel2 = new javax.swing.JLabel();
        descripcioLabel2 = new javax.swing.JLabel();
        dataLabel2 = new javax.swing.JLabel();
        analiticaOrinaCombo = new javax.swing.JComboBox<>();
        analiticaOrinaText = new javax.swing.JTextField();
        analiticaOrinaData = new com.toedter.calendar.JDateChooser();
        analiticaLcrPanel = new javax.swing.JPanel();
        codiResultatLabel3 = new javax.swing.JLabel();
        descripcioLabel3 = new javax.swing.JLabel();
        dataLabel3 = new javax.swing.JLabel();
        analiticaLcrCombo = new javax.swing.JComboBox<>();
        analiticaLcrText = new javax.swing.JTextField();
        analiticaLcrData = new com.toedter.calendar.JDateChooser();
        geneticaPanel = new javax.swing.JPanel();
        codiResultatLabel4 = new javax.swing.JLabel();
        descripcioLabel4 = new javax.swing.JLabel();
        dataLabel4 = new javax.swing.JLabel();
        geneticaCombo = new javax.swing.JComboBox<>();
        geneticaText = new javax.swing.JTextField();
        geneticaData = new com.toedter.calendar.JDateChooser();
        toraxPanel = new javax.swing.JPanel();
        codiResultatLabel5 = new javax.swing.JLabel();
        descripcioLabel5 = new javax.swing.JLabel();
        dataLabel5 = new javax.swing.JLabel();
        toraxCombo = new javax.swing.JComboBox<>();
        toraxText = new javax.swing.JTextField();
        toraxData = new com.toedter.calendar.JDateChooser();
        eegPanel = new javax.swing.JPanel();
        codiResultatLabel6 = new javax.swing.JLabel();
        descripcioLabel6 = new javax.swing.JLabel();
        dataLabel6 = new javax.swing.JLabel();
        eegCombo = new javax.swing.JComboBox<>();
        eegText = new javax.swing.JTextField();
        eegData = new com.toedter.calendar.JDateChooser();
        potencialsPanel = new javax.swing.JPanel();
        codiResultatLabel7 = new javax.swing.JLabel();
        descripcioLabel7 = new javax.swing.JLabel();
        dataLabel7 = new javax.swing.JLabel();
        potencialsCombo = new javax.swing.JComboBox<>();
        potencialsText = new javax.swing.JTextField();
        potencialsData = new com.toedter.calendar.JDateChooser();
        emgPanel = new javax.swing.JPanel();
        codiResultatLabel9 = new javax.swing.JLabel();
        descripcioLabel9 = new javax.swing.JLabel();
        dataLabel9 = new javax.swing.JLabel();
        emgCombo = new javax.swing.JComboBox<>();
        emgText = new javax.swing.JTextField();
        emgData = new com.toedter.calendar.JDateChooser();
        ntmsPanel = new javax.swing.JPanel();
        codiResultatLabel10 = new javax.swing.JLabel();
        descripcioLabel10 = new javax.swing.JLabel();
        dataLabel10 = new javax.swing.JLabel();
        ntmsCombo = new javax.swing.JComboBox<>();
        ntmsText = new javax.swing.JTextField();
        ntmsData = new com.toedter.calendar.JDateChooser();
        anatomiaPanel = new javax.swing.JPanel();
        codiResultatLabel12 = new javax.swing.JLabel();
        descripcioLabel12 = new javax.swing.JLabel();
        dataLabel12 = new javax.swing.JLabel();
        anatomiaCombo = new javax.swing.JComboBox<>();
        anatomiaText = new javax.swing.JTextField();
        anatomiaData = new com.toedter.calendar.JDateChooser();

        codisLabel.setText("Codis: CS, clínicament significatiu; NCS, no clínicament significatiu");

        ecgPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("ECG"));
        ecgPanel.setPreferredSize(new java.awt.Dimension(560, 117));

        codiResultatLabel.setText("Codi del resultat:");

        descripcioLabel.setText("Descripció:");

        dataLabel.setText("Data:");

        ecgCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        ecgCombo.setSelectedIndex(-1);

        ecgData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout ecgPanelLayout = new javax.swing.GroupLayout(ecgPanel);
        ecgPanel.setLayout(ecgPanelLayout);
        ecgPanelLayout.setHorizontalGroup(
            ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ecgText))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ecgPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ecgCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ecgPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ecgData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ecgPanelLayout.setVerticalGroup(
            ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel)
                    .addComponent(ecgCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel)
                    .addComponent(ecgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel)
                    .addComponent(ecgData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        analiticaSangPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Analítica de sang"));

        codiResultatLabel1.setText("Codi del resultat:");

        descripcioLabel1.setText("Descripció:");

        dataLabel1.setText("Data:");

        analiticaSangCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        analiticaSangCombo.setSelectedIndex(-1);

        analiticaSangData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout analiticaSangPanelLayout = new javax.swing.GroupLayout(analiticaSangPanel);
        analiticaSangPanel.setLayout(analiticaSangPanelLayout);
        analiticaSangPanelLayout.setHorizontalGroup(
            analiticaSangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analiticaSangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analiticaSangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(analiticaSangPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(analiticaSangText))
                    .addGroup(analiticaSangPanelLayout.createSequentialGroup()
                        .addGroup(analiticaSangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(analiticaSangPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analiticaSangCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(analiticaSangPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analiticaSangData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 349, Short.MAX_VALUE)))
                .addContainerGap())
        );
        analiticaSangPanelLayout.setVerticalGroup(
            analiticaSangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analiticaSangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analiticaSangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel1)
                    .addComponent(analiticaSangCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analiticaSangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel1)
                    .addComponent(analiticaSangText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analiticaSangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel1)
                    .addComponent(analiticaSangData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        analiticaOrinaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Analítica d'orina"));

        codiResultatLabel2.setText("Codi del resultat:");

        descripcioLabel2.setText("Descripció:");

        dataLabel2.setText("Data:");

        analiticaOrinaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        analiticaOrinaCombo.setSelectedIndex(-1);

        analiticaOrinaData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout analiticaOrinaPanelLayout = new javax.swing.GroupLayout(analiticaOrinaPanel);
        analiticaOrinaPanel.setLayout(analiticaOrinaPanelLayout);
        analiticaOrinaPanelLayout.setHorizontalGroup(
            analiticaOrinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analiticaOrinaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analiticaOrinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(analiticaOrinaPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(analiticaOrinaText))
                    .addGroup(analiticaOrinaPanelLayout.createSequentialGroup()
                        .addGroup(analiticaOrinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(analiticaOrinaPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analiticaOrinaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(analiticaOrinaPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analiticaOrinaData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        analiticaOrinaPanelLayout.setVerticalGroup(
            analiticaOrinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analiticaOrinaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analiticaOrinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel2)
                    .addComponent(analiticaOrinaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analiticaOrinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel2)
                    .addComponent(analiticaOrinaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analiticaOrinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel2)
                    .addComponent(analiticaOrinaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        analiticaLcrPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Analítica de LCR"));

        codiResultatLabel3.setText("Codi del resultat:");

        descripcioLabel3.setText("Descripció:");

        dataLabel3.setText("Data:");

        analiticaLcrCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        analiticaLcrCombo.setSelectedIndex(-1);

        analiticaLcrData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout analiticaLcrPanelLayout = new javax.swing.GroupLayout(analiticaLcrPanel);
        analiticaLcrPanel.setLayout(analiticaLcrPanelLayout);
        analiticaLcrPanelLayout.setHorizontalGroup(
            analiticaLcrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analiticaLcrPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analiticaLcrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(analiticaLcrPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(analiticaLcrText))
                    .addGroup(analiticaLcrPanelLayout.createSequentialGroup()
                        .addGroup(analiticaLcrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(analiticaLcrPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analiticaLcrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(analiticaLcrPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analiticaLcrData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        analiticaLcrPanelLayout.setVerticalGroup(
            analiticaLcrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analiticaLcrPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analiticaLcrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel3)
                    .addComponent(analiticaLcrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analiticaLcrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel3)
                    .addComponent(analiticaLcrText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analiticaLcrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel3)
                    .addComponent(analiticaLcrData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        geneticaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Genètica"));

        codiResultatLabel4.setText("Codi del resultat:");

        descripcioLabel4.setText("Descripció:");

        dataLabel4.setText("Data:");

        geneticaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        geneticaCombo.setSelectedIndex(-1);

        geneticaData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout geneticaPanelLayout = new javax.swing.GroupLayout(geneticaPanel);
        geneticaPanel.setLayout(geneticaPanelLayout);
        geneticaPanelLayout.setHorizontalGroup(
            geneticaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geneticaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(geneticaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(geneticaPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(geneticaText))
                    .addGroup(geneticaPanelLayout.createSequentialGroup()
                        .addGroup(geneticaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(geneticaPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(geneticaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(geneticaPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(geneticaData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        geneticaPanelLayout.setVerticalGroup(
            geneticaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geneticaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(geneticaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel4)
                    .addComponent(geneticaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(geneticaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel4)
                    .addComponent(geneticaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(geneticaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel4)
                    .addComponent(geneticaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        toraxPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("RX de tòrax"));

        codiResultatLabel5.setText("Codi del resultat:");

        descripcioLabel5.setText("Descripció:");

        dataLabel5.setText("Data:");

        toraxCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        toraxCombo.setSelectedIndex(-1);

        toraxData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout toraxPanelLayout = new javax.swing.GroupLayout(toraxPanel);
        toraxPanel.setLayout(toraxPanelLayout);
        toraxPanelLayout.setHorizontalGroup(
            toraxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toraxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toraxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toraxPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toraxText))
                    .addGroup(toraxPanelLayout.createSequentialGroup()
                        .addGroup(toraxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(toraxPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(toraxCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(toraxPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(toraxData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        toraxPanelLayout.setVerticalGroup(
            toraxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toraxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toraxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel5)
                    .addComponent(toraxCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(toraxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel5)
                    .addComponent(toraxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(toraxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel5)
                    .addComponent(toraxData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        eegPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("EEG"));

        codiResultatLabel6.setText("Codi del resultat:");

        descripcioLabel6.setText("Descripció:");

        dataLabel6.setText("Data:");

        eegCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        eegCombo.setSelectedIndex(-1);

        eegData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout eegPanelLayout = new javax.swing.GroupLayout(eegPanel);
        eegPanel.setLayout(eegPanelLayout);
        eegPanelLayout.setHorizontalGroup(
            eegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eegPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eegPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eegText))
                    .addGroup(eegPanelLayout.createSequentialGroup()
                        .addGroup(eegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eegPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eegCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(eegPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eegData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        eegPanelLayout.setVerticalGroup(
            eegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eegPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel6)
                    .addComponent(eegCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel6)
                    .addComponent(eegText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel6)
                    .addComponent(eegData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        potencialsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Potencials evocats"));

        codiResultatLabel7.setText("Codi del resultat:");

        descripcioLabel7.setText("Descripció:");

        dataLabel7.setText("Data:");

        potencialsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        potencialsCombo.setSelectedIndex(-1);

        potencialsData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout potencialsPanelLayout = new javax.swing.GroupLayout(potencialsPanel);
        potencialsPanel.setLayout(potencialsPanelLayout);
        potencialsPanelLayout.setHorizontalGroup(
            potencialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(potencialsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(potencialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(potencialsPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(potencialsText))
                    .addGroup(potencialsPanelLayout.createSequentialGroup()
                        .addGroup(potencialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(potencialsPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(potencialsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(potencialsPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(potencialsData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        potencialsPanelLayout.setVerticalGroup(
            potencialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(potencialsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(potencialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel7)
                    .addComponent(potencialsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(potencialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel7)
                    .addComponent(potencialsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(potencialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel7)
                    .addComponent(potencialsData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        emgPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("EMG"));

        codiResultatLabel9.setText("Codi del resultat:");

        descripcioLabel9.setText("Descripció:");

        dataLabel9.setText("Data:");

        emgCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        emgCombo.setSelectedIndex(-1);

        emgData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout emgPanelLayout = new javax.swing.GroupLayout(emgPanel);
        emgPanel.setLayout(emgPanelLayout);
        emgPanelLayout.setHorizontalGroup(
            emgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emgPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emgText))
                    .addGroup(emgPanelLayout.createSequentialGroup()
                        .addGroup(emgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(emgPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emgCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(emgPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emgData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        emgPanelLayout.setVerticalGroup(
            emgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel9)
                    .addComponent(emgCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel9)
                    .addComponent(emgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel9)
                    .addComponent(emgData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ntmsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("N-TMS (Navigated Transcranial Magnetic Stimulation "));

        codiResultatLabel10.setText("Codi del resultat:");

        descripcioLabel10.setText("Descripció:");

        dataLabel10.setText("Data:");

        ntmsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        ntmsCombo.setSelectedIndex(-1);

        ntmsData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout ntmsPanelLayout = new javax.swing.GroupLayout(ntmsPanel);
        ntmsPanel.setLayout(ntmsPanelLayout);
        ntmsPanelLayout.setHorizontalGroup(
            ntmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ntmsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ntmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ntmsPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ntmsText))
                    .addGroup(ntmsPanelLayout.createSequentialGroup()
                        .addGroup(ntmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ntmsPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ntmsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ntmsPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ntmsData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ntmsPanelLayout.setVerticalGroup(
            ntmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ntmsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ntmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel10)
                    .addComponent(ntmsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ntmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel10)
                    .addComponent(ntmsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ntmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel10)
                    .addComponent(ntmsData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        anatomiaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Anatomia Patològica"));

        codiResultatLabel12.setText("Codi del resultat:");

        descripcioLabel12.setText("Descripció:");

        dataLabel12.setText("Data:");

        anatomiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No realitzat", "Normal", "Anormal NCS", "Anormal CS" }));
        anatomiaCombo.setSelectedIndex(-1);

        anatomiaData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout anatomiaPanelLayout = new javax.swing.GroupLayout(anatomiaPanel);
        anatomiaPanel.setLayout(anatomiaPanelLayout);
        anatomiaPanelLayout.setHorizontalGroup(
            anatomiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anatomiaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(anatomiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anatomiaPanelLayout.createSequentialGroup()
                        .addComponent(descripcioLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anatomiaText))
                    .addGroup(anatomiaPanelLayout.createSequentialGroup()
                        .addGroup(anatomiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(anatomiaPanelLayout.createSequentialGroup()
                                .addComponent(codiResultatLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(anatomiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(anatomiaPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(anatomiaData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        anatomiaPanelLayout.setVerticalGroup(
            anatomiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anatomiaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(anatomiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codiResultatLabel12)
                    .addComponent(anatomiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(anatomiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcioLabel12)
                    .addComponent(anatomiaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(anatomiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLabel12)
                    .addComponent(anatomiaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout provesComplementariesPanelLayout = new javax.swing.GroupLayout(provesComplementariesPanel);
        provesComplementariesPanel.setLayout(provesComplementariesPanelLayout);
        provesComplementariesPanelLayout.setHorizontalGroup(
            provesComplementariesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(provesComplementariesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(provesComplementariesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codisLabel)
                    .addComponent(analiticaSangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analiticaLcrPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(geneticaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toraxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eegPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(potencialsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ntmsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anatomiaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ecgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analiticaOrinaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        provesComplementariesPanelLayout.setVerticalGroup(
            provesComplementariesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(provesComplementariesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ecgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analiticaSangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analiticaOrinaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analiticaLcrPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(geneticaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toraxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eegPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(potencialsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ntmsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(anatomiaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        provesComplementariesScroll.setViewportView(provesComplementariesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(provesComplementariesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(provesComplementariesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> analiticaLcrCombo;
    private com.toedter.calendar.JDateChooser analiticaLcrData;
    private javax.swing.JPanel analiticaLcrPanel;
    private javax.swing.JTextField analiticaLcrText;
    private javax.swing.JComboBox<String> analiticaOrinaCombo;
    private com.toedter.calendar.JDateChooser analiticaOrinaData;
    private javax.swing.JPanel analiticaOrinaPanel;
    private javax.swing.JTextField analiticaOrinaText;
    private javax.swing.JComboBox<String> analiticaSangCombo;
    private com.toedter.calendar.JDateChooser analiticaSangData;
    private javax.swing.JPanel analiticaSangPanel;
    private javax.swing.JTextField analiticaSangText;
    private javax.swing.JComboBox<String> anatomiaCombo;
    private com.toedter.calendar.JDateChooser anatomiaData;
    private javax.swing.JPanel anatomiaPanel;
    private javax.swing.JTextField anatomiaText;
    private javax.swing.JLabel codiResultatLabel;
    private javax.swing.JLabel codiResultatLabel1;
    private javax.swing.JLabel codiResultatLabel10;
    private javax.swing.JLabel codiResultatLabel12;
    private javax.swing.JLabel codiResultatLabel2;
    private javax.swing.JLabel codiResultatLabel3;
    private javax.swing.JLabel codiResultatLabel4;
    private javax.swing.JLabel codiResultatLabel5;
    private javax.swing.JLabel codiResultatLabel6;
    private javax.swing.JLabel codiResultatLabel7;
    private javax.swing.JLabel codiResultatLabel9;
    private javax.swing.JLabel codisLabel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JLabel dataLabel1;
    private javax.swing.JLabel dataLabel10;
    private javax.swing.JLabel dataLabel12;
    private javax.swing.JLabel dataLabel2;
    private javax.swing.JLabel dataLabel3;
    private javax.swing.JLabel dataLabel4;
    private javax.swing.JLabel dataLabel5;
    private javax.swing.JLabel dataLabel6;
    private javax.swing.JLabel dataLabel7;
    private javax.swing.JLabel dataLabel9;
    private javax.swing.JLabel descripcioLabel;
    private javax.swing.JLabel descripcioLabel1;
    private javax.swing.JLabel descripcioLabel10;
    private javax.swing.JLabel descripcioLabel12;
    private javax.swing.JLabel descripcioLabel2;
    private javax.swing.JLabel descripcioLabel3;
    private javax.swing.JLabel descripcioLabel4;
    private javax.swing.JLabel descripcioLabel5;
    private javax.swing.JLabel descripcioLabel6;
    private javax.swing.JLabel descripcioLabel7;
    private javax.swing.JLabel descripcioLabel9;
    private javax.swing.JComboBox<String> ecgCombo;
    private com.toedter.calendar.JDateChooser ecgData;
    private javax.swing.JPanel ecgPanel;
    private javax.swing.JTextField ecgText;
    private javax.swing.JComboBox<String> eegCombo;
    private com.toedter.calendar.JDateChooser eegData;
    private javax.swing.JPanel eegPanel;
    private javax.swing.JTextField eegText;
    private javax.swing.JComboBox<String> emgCombo;
    private com.toedter.calendar.JDateChooser emgData;
    private javax.swing.JPanel emgPanel;
    private javax.swing.JTextField emgText;
    private javax.swing.JComboBox<String> geneticaCombo;
    private com.toedter.calendar.JDateChooser geneticaData;
    private javax.swing.JPanel geneticaPanel;
    private javax.swing.JTextField geneticaText;
    private javax.swing.JComboBox<String> ntmsCombo;
    private com.toedter.calendar.JDateChooser ntmsData;
    private javax.swing.JPanel ntmsPanel;
    private javax.swing.JTextField ntmsText;
    private javax.swing.JComboBox<String> potencialsCombo;
    private com.toedter.calendar.JDateChooser potencialsData;
    private javax.swing.JPanel potencialsPanel;
    private javax.swing.JTextField potencialsText;
    private javax.swing.JPanel provesComplementariesPanel;
    private javax.swing.JScrollPane provesComplementariesScroll;
    private javax.swing.JComboBox<String> toraxCombo;
    private com.toedter.calendar.JDateChooser toraxData;
    private javax.swing.JPanel toraxPanel;
    private javax.swing.JTextField toraxText;
    // End of variables declaration//GEN-END:variables
}
