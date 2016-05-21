/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Pacient;
import controlador.Utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author USER
 */
public class ValoracioCuidador extends javax.swing.JFrame {
    
    int pagina = 0;
    int numPaginesTotal = 1;
    Pacient pacientActual;

    public ValoracioCuidador(){
        initComponents();
    }

    /**
     * Creates new form ValoracioCuidador
     */
    public ValoracioCuidador(Pacient pacient) {
        initComponents();

        pacientActual = pacient;

        initNPI();
        initSF12();
        initHAD();
        initDUKE();
        iniZARIT();
        initFAQ();

        Utils.carregar(tabbedPanel,pacientActual.getId(), "ValCuid");

        Utils.setActionCommands(dataPanel);
    }

    private void initFAQ() {
        Utils.initTaula(faqQPanel,faqTotal);
    }

    private void iniZARIT() {
        Utils.initTaula(zaritQPanel,zaritTotal);
    }

    private void initDUKE() {
        Utils.initTaula(dukeQPanel,dukeTotal);
    }

    private void initSF12() {
        for (Component com : sf12Panel.getComponents()){
            if (com instanceof JRadioButton){
                ((JRadioButton)com).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actualitzaPuntuacioSf12();
                    }
                });
            }
        }
    }

    private void actualitzaPuntuacioSf12() {
        int count = 0;
        for (Component com : sf12Panel.getComponents()){
            if (com instanceof JRadioButton){
                if (((JRadioButton)com).isSelected()){
                    count += Integer.parseInt(((JRadioButton)com).getActionCommand());
                }
            }
        }
        sf12Total.setText(count+"");
    }

    private void initNPI() {

        for (Component com : npiPanel.getComponents()){
            if (com instanceof JCheckBox || com instanceof JToggleButton){
                ((AbstractButton)com).addActionListener(npiActionListener);
            }
        }
    }

    private ActionListener npiActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            actualitzaPuntuacioNpi();
        }
    };

    private void actualitzaPuntuacioNpi() {
        int count = 0;

        int tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup1)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup1);
        npiTotal1.setText(tempPunt+"");
        if (!npiCheck1.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup2)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup2);
        npiTotal2.setText(tempPunt+"");
        if (!npiCheck2.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup3)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup3);
        npiTotal3.setText(tempPunt+"");
        if (!npiCheck3.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup4)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup4);
        npiTotal4.setText(tempPunt+"");
        if (!npiCheck4.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup5)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup5);
        npiTotal5.setText(tempPunt+"");
        if (!npiCheck5.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup6)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup6);
        npiTotal6.setText(tempPunt+"");
        if (!npiCheck6.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup7)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup7);
        npiTotal7.setText(tempPunt+"");
        if (!npiCheck7.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup8)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup8);
        npiTotal8.setText(tempPunt+"");
        if (!npiCheck8.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup9)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup9);
        npiTotal9.setText(tempPunt+"");
        if (!npiCheck9.isSelected()) count+=tempPunt;

        tempPunt = Utils.getPunctuationFromButtonGroup(npiFreqBtnGroup10)*Utils.getPunctuationFromButtonGroup(npiGravBtnGroup10);
        npiTotal10.setText(tempPunt+"");
        if (!npiCheck10.isSelected()) count+=tempPunt;

        npiTotal.setText(count+"");
    }

    private void initHAD() {

        setHadListeners(hadPanel);

    }

    private void setHadListeners(Container c){
        Component[] components = c.getComponents();
        for (Component com : components){
            if (com instanceof JRadioButton){
                if ( ((JRadioButton) com).getParent().getName().equals("A")){
                    ((JRadioButton) com).addChangeListener(changeListenerHadA);
                } else if (((JRadioButton) com).getParent().getName().equals("D")){
                    ((JRadioButton) com).addChangeListener(changeListenerHadD);
                }
            }
            else if (com instanceof Container){
                setHadListeners((Container) com);
            }
        }
    }

    private ChangeListener changeListenerHadA = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            int puntsA = sumaPuntsHadA();
            hadTotalA.setText(puntsA+"");
            hadInterpretacioA.setText(getInterpretacioHad(puntsA));
        }
    };

    private String getInterpretacioHad(int punts) {
        String interpretacio;
        if (punts <= 7){
            interpretacio = "No cas";
        } else if (punts > 7 && punts <= 10){
            interpretacio = "Cas duptós";
        }else{
            interpretacio = "Cas";
        }
        return interpretacio;
    }

    private int sumaPuntsHadA(){
        int count = 0;

        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup1);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup3);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup5);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup7);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup9);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup11);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup13);

        return count;
    }

    private ChangeListener changeListenerHadD = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            int puntsD = sumaPuntsHadD();
            hadTotalD.setText(puntsD+"");
            hadInterpretacioD.setText(getInterpretacioHad(puntsD));
        }
    };

    private int sumaPuntsHadD(){
        int count = 0;

        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup2);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup4);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup6);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup8);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup10);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup12);
        count += Utils.getPunctuationFromButtonGroup(hadButtonGroup14);

        return count;
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

        npiFreqBtnGroup1 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup2 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup3 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup4 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup5 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup6 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup7 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup8 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup9 = new javax.swing.ButtonGroup();
        npiFreqBtnGroup10 = new javax.swing.ButtonGroup();
        npiGravBtnGroup1 = new javax.swing.ButtonGroup();
        npiGravBtnGroup2 = new javax.swing.ButtonGroup();
        npiGravBtnGroup3 = new javax.swing.ButtonGroup();
        npiGravBtnGroup4 = new javax.swing.ButtonGroup();
        npiGravBtnGroup5 = new javax.swing.ButtonGroup();
        npiGravBtnGroup6 = new javax.swing.ButtonGroup();
        npiGravBtnGroup7 = new javax.swing.ButtonGroup();
        npiGravBtnGroup8 = new javax.swing.ButtonGroup();
        npiGravBtnGroup9 = new javax.swing.ButtonGroup();
        npiGravBtnGroup10 = new javax.swing.ButtonGroup();
        sf12BtnGroup1 = new javax.swing.ButtonGroup();
        sf12BtnGroup2 = new javax.swing.ButtonGroup();
        sf12BtnGroup3 = new javax.swing.ButtonGroup();
        sf12BtnGroup4 = new javax.swing.ButtonGroup();
        sf12BtnGroup5 = new javax.swing.ButtonGroup();
        sf12BtnGroup6 = new javax.swing.ButtonGroup();
        sf12BtnGroup7 = new javax.swing.ButtonGroup();
        sf12BtnGroup8 = new javax.swing.ButtonGroup();
        sf12BtnGroup9 = new javax.swing.ButtonGroup();
        sf12BtnGroup10 = new javax.swing.ButtonGroup();
        sf12BtnGroup11 = new javax.swing.ButtonGroup();
        sf12BtnGroup12 = new javax.swing.ButtonGroup();
        hadButtonGroup1 = new javax.swing.ButtonGroup();
        hadButtonGroup2 = new javax.swing.ButtonGroup();
        hadButtonGroup3 = new javax.swing.ButtonGroup();
        hadButtonGroup4 = new javax.swing.ButtonGroup();
        hadButtonGroup5 = new javax.swing.ButtonGroup();
        hadButtonGroup6 = new javax.swing.ButtonGroup();
        hadButtonGroup7 = new javax.swing.ButtonGroup();
        hadButtonGroup8 = new javax.swing.ButtonGroup();
        hadButtonGroup9 = new javax.swing.ButtonGroup();
        hadButtonGroup10 = new javax.swing.ButtonGroup();
        hadButtonGroup11 = new javax.swing.ButtonGroup();
        hadButtonGroup12 = new javax.swing.ButtonGroup();
        hadButtonGroup13 = new javax.swing.ButtonGroup();
        hadButtonGroup14 = new javax.swing.ButtonGroup();
        zaritBtnGroup1 = new javax.swing.ButtonGroup();
        zaritBtnGroup2 = new javax.swing.ButtonGroup();
        zaritBtnGroup3 = new javax.swing.ButtonGroup();
        zaritBtnGroup4 = new javax.swing.ButtonGroup();
        zaritBtnGroup5 = new javax.swing.ButtonGroup();
        zaritBtnGroup6 = new javax.swing.ButtonGroup();
        zaritBtnGroup7 = new javax.swing.ButtonGroup();
        zaritBtnGroup8 = new javax.swing.ButtonGroup();
        zaritBtnGroup9 = new javax.swing.ButtonGroup();
        zaritBtnGroup10 = new javax.swing.ButtonGroup();
        zaritBtnGroup11 = new javax.swing.ButtonGroup();
        zaritBtnGroup12 = new javax.swing.ButtonGroup();
        zaritBtnGroup13 = new javax.swing.ButtonGroup();
        zaritBtnGroup14 = new javax.swing.ButtonGroup();
        zaritBtnGroup15 = new javax.swing.ButtonGroup();
        zaritBtnGroup16 = new javax.swing.ButtonGroup();
        zaritBtnGroup17 = new javax.swing.ButtonGroup();
        zaritBtnGroup18 = new javax.swing.ButtonGroup();
        zaritBtnGroup19 = new javax.swing.ButtonGroup();
        zaritBtnGroup20 = new javax.swing.ButtonGroup();
        zaritBtnGroup21 = new javax.swing.ButtonGroup();
        zaritBtnGroup22 = new javax.swing.ButtonGroup();
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
        faqBtnGroup1 = new javax.swing.ButtonGroup();
        faqBtnGroup2 = new javax.swing.ButtonGroup();
        faqBtnGroup3 = new javax.swing.ButtonGroup();
        faqBtnGroup4 = new javax.swing.ButtonGroup();
        faqBtnGroup5 = new javax.swing.ButtonGroup();
        faqBtnGroup6 = new javax.swing.ButtonGroup();
        faqBtnGroup7 = new javax.swing.ButtonGroup();
        faqBtnGroup8 = new javax.swing.ButtonGroup();
        faqBtnGroup9 = new javax.swing.ButtonGroup();
        faqBtnGroup10 = new javax.swing.ButtonGroup();
        faqBtnGroup11 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        dataPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        acceptaBtn = new javax.swing.JButton();
        cancelaBtn = new javax.swing.JButton();
        tabbedPanel = new javax.swing.JTabbedPane();
        npiTab = new javax.swing.JPanel();
        npiScroll = new javax.swing.JScrollPane();
        npi2Panel = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        npiPanel = new javax.swing.JPanel();
        orientacioBtn20 = new javax.swing.JToggleButton();
        memoBtn20 = new javax.swing.JToggleButton();
        raoBtn19 = new javax.swing.JToggleButton();
        raoBtn21 = new javax.swing.JToggleButton();
        activitatsDBtn22 = new javax.swing.JToggleButton();
        cuidatBtn15 = new javax.swing.JToggleButton();
        jLabel166 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jToggleButton118 = new javax.swing.JToggleButton();
        jToggleButton122 = new javax.swing.JToggleButton();
        jToggleButton134 = new javax.swing.JToggleButton();
        jToggleButton138 = new javax.swing.JToggleButton();
        jToggleButton142 = new javax.swing.JToggleButton();
        jToggleButton146 = new javax.swing.JToggleButton();
        jToggleButton147 = new javax.swing.JToggleButton();
        jLabel206 = new javax.swing.JLabel();
        activitatsDBtn25 = new javax.swing.JToggleButton();
        jToggleButton150 = new javax.swing.JToggleButton();
        jToggleButton151 = new javax.swing.JToggleButton();
        jToggleButton152 = new javax.swing.JToggleButton();
        jToggleButton153 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        npiCheck9 = new javax.swing.JCheckBox();
        npiCheck1 = new javax.swing.JCheckBox();
        npiCheck2 = new javax.swing.JCheckBox();
        npiCheck3 = new javax.swing.JCheckBox();
        npiCheck4 = new javax.swing.JCheckBox();
        npiCheck5 = new javax.swing.JCheckBox();
        npiCheck6 = new javax.swing.JCheckBox();
        npiCheck7 = new javax.swing.JCheckBox();
        npiCheck8 = new javax.swing.JCheckBox();
        raoBtn27 = new javax.swing.JToggleButton();
        jToggleButton158 = new javax.swing.JToggleButton();
        jToggleButton159 = new javax.swing.JToggleButton();
        cuidatBtn20 = new javax.swing.JToggleButton();
        jToggleButton160 = new javax.swing.JToggleButton();
        raoBtn28 = new javax.swing.JToggleButton();
        jToggleButton161 = new javax.swing.JToggleButton();
        jToggleButton162 = new javax.swing.JToggleButton();
        cuidatBtn21 = new javax.swing.JToggleButton();
        jToggleButton163 = new javax.swing.JToggleButton();
        jToggleButton164 = new javax.swing.JToggleButton();
        jToggleButton165 = new javax.swing.JToggleButton();
        jToggleButton166 = new javax.swing.JToggleButton();
        jToggleButton167 = new javax.swing.JToggleButton();
        jToggleButton168 = new javax.swing.JToggleButton();
        jToggleButton169 = new javax.swing.JToggleButton();
        jToggleButton170 = new javax.swing.JToggleButton();
        jToggleButton171 = new javax.swing.JToggleButton();
        activitatsDBtn26 = new javax.swing.JToggleButton();
        jToggleButton172 = new javax.swing.JToggleButton();
        jToggleButton173 = new javax.swing.JToggleButton();
        jToggleButton174 = new javax.swing.JToggleButton();
        activitatsDBtn27 = new javax.swing.JToggleButton();
        jToggleButton175 = new javax.swing.JToggleButton();
        jToggleButton176 = new javax.swing.JToggleButton();
        jToggleButton177 = new javax.swing.JToggleButton();
        jToggleButton178 = new javax.swing.JToggleButton();
        activitatsDBtn28 = new javax.swing.JToggleButton();
        jToggleButton179 = new javax.swing.JToggleButton();
        jToggleButton180 = new javax.swing.JToggleButton();
        jToggleButton181 = new javax.swing.JToggleButton();
        jToggleButton182 = new javax.swing.JToggleButton();
        activitatsDBtn29 = new javax.swing.JToggleButton();
        jToggleButton183 = new javax.swing.JToggleButton();
        jToggleButton184 = new javax.swing.JToggleButton();
        jToggleButton185 = new javax.swing.JToggleButton();
        jToggleButton186 = new javax.swing.JToggleButton();
        activitatsDBtn30 = new javax.swing.JToggleButton();
        jToggleButton187 = new javax.swing.JToggleButton();
        jToggleButton188 = new javax.swing.JToggleButton();
        jToggleButton189 = new javax.swing.JToggleButton();
        jToggleButton190 = new javax.swing.JToggleButton();
        activitatsDBtn31 = new javax.swing.JToggleButton();
        jToggleButton191 = new javax.swing.JToggleButton();
        jToggleButton192 = new javax.swing.JToggleButton();
        jToggleButton193 = new javax.swing.JToggleButton();
        jToggleButton194 = new javax.swing.JToggleButton();
        activitatsDBtn32 = new javax.swing.JToggleButton();
        jToggleButton195 = new javax.swing.JToggleButton();
        jToggleButton196 = new javax.swing.JToggleButton();
        jToggleButton197 = new javax.swing.JToggleButton();
        jToggleButton198 = new javax.swing.JToggleButton();
        activitatsDBtn33 = new javax.swing.JToggleButton();
        jToggleButton199 = new javax.swing.JToggleButton();
        jToggleButton200 = new javax.swing.JToggleButton();
        jToggleButton201 = new javax.swing.JToggleButton();
        jToggleButton202 = new javax.swing.JToggleButton();
        activitatsDBtn34 = new javax.swing.JToggleButton();
        jToggleButton203 = new javax.swing.JToggleButton();
        jToggleButton204 = new javax.swing.JToggleButton();
        jToggleButton205 = new javax.swing.JToggleButton();
        jToggleButton206 = new javax.swing.JToggleButton();
        npiCheck10 = new javax.swing.JCheckBox();
        npiTotal1 = new javax.swing.JLabel();
        npiTotal = new javax.swing.JLabel();
        npiTotal3 = new javax.swing.JLabel();
        npiTotal2 = new javax.swing.JLabel();
        npiTotal4 = new javax.swing.JLabel();
        npiTotal5 = new javax.swing.JLabel();
        npiTotal6 = new javax.swing.JLabel();
        npiTotal8 = new javax.swing.JLabel();
        npiTotal9 = new javax.swing.JLabel();
        npiTotal10 = new javax.swing.JLabel();
        npiTotal7 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        hadTab = new javax.swing.JPanel();
        hadScroll = new javax.swing.JScrollPane();
        hadPanel = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jRadioButton28 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton25 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jRadioButton33 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton36 = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jRadioButton39 = new javax.swing.JRadioButton();
        jRadioButton40 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jRadioButton41 = new javax.swing.JRadioButton();
        jRadioButton42 = new javax.swing.JRadioButton();
        jRadioButton43 = new javax.swing.JRadioButton();
        jRadioButton44 = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jRadioButton45 = new javax.swing.JRadioButton();
        jRadioButton46 = new javax.swing.JRadioButton();
        jRadioButton47 = new javax.swing.JRadioButton();
        jRadioButton48 = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jRadioButton49 = new javax.swing.JRadioButton();
        jRadioButton50 = new javax.swing.JRadioButton();
        jRadioButton51 = new javax.swing.JRadioButton();
        jRadioButton52 = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jRadioButton61 = new javax.swing.JRadioButton();
        jRadioButton62 = new javax.swing.JRadioButton();
        jRadioButton63 = new javax.swing.JRadioButton();
        jRadioButton64 = new javax.swing.JRadioButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        hadTotalA = new javax.swing.JLabel();
        hadTotalD = new javax.swing.JLabel();
        hadInterpretacioA = new javax.swing.JLabel();
        hadInterpretacioD = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        zaritTab = new javax.swing.JPanel();
        zaritScroll1 = new javax.swing.JScrollPane();
        zaritPanel2 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        zaritQPanel = new javax.swing.JPanel();
        orientacioBtn22 = new javax.swing.JToggleButton();
        memoBtn22 = new javax.swing.JToggleButton();
        orientacioBtn23 = new javax.swing.JToggleButton();
        memoBtn23 = new javax.swing.JToggleButton();
        orientacioBtn24 = new javax.swing.JToggleButton();
        memoBtn24 = new javax.swing.JToggleButton();
        raoBtn22 = new javax.swing.JToggleButton();
        raoBtn24 = new javax.swing.JToggleButton();
        raoBtn25 = new javax.swing.JToggleButton();
        activitatsFBtn22 = new javax.swing.JToggleButton();
        activitatsFBtn23 = new javax.swing.JToggleButton();
        activitatsFBtn24 = new javax.swing.JToggleButton();
        activitatsDBtn23 = new javax.swing.JToggleButton();
        activitatsDBtn24 = new javax.swing.JToggleButton();
        cuidatBtn17 = new javax.swing.JToggleButton();
        cuidatBtn18 = new javax.swing.JToggleButton();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jToggleButton83 = new javax.swing.JToggleButton();
        jToggleButton84 = new javax.swing.JToggleButton();
        jToggleButton85 = new javax.swing.JToggleButton();
        jToggleButton86 = new javax.swing.JToggleButton();
        jToggleButton87 = new javax.swing.JToggleButton();
        jToggleButton88 = new javax.swing.JToggleButton();
        jToggleButton89 = new javax.swing.JToggleButton();
        jToggleButton90 = new javax.swing.JToggleButton();
        jToggleButton92 = new javax.swing.JToggleButton();
        jToggleButton93 = new javax.swing.JToggleButton();
        jToggleButton94 = new javax.swing.JToggleButton();
        jToggleButton95 = new javax.swing.JToggleButton();
        jToggleButton96 = new javax.swing.JToggleButton();
        jToggleButton97 = new javax.swing.JToggleButton();
        jToggleButton99 = new javax.swing.JToggleButton();
        jToggleButton100 = new javax.swing.JToggleButton();
        jToggleButton101 = new javax.swing.JToggleButton();
        jToggleButton103 = new javax.swing.JToggleButton();
        jToggleButton104 = new javax.swing.JToggleButton();
        jToggleButton105 = new javax.swing.JToggleButton();
        jToggleButton107 = new javax.swing.JToggleButton();
        jToggleButton109 = new javax.swing.JToggleButton();
        jToggleButton111 = new javax.swing.JToggleButton();
        jLabel117 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jToggleButton57 = new javax.swing.JToggleButton();
        jToggleButton58 = new javax.swing.JToggleButton();
        jToggleButton59 = new javax.swing.JToggleButton();
        jLabel137 = new javax.swing.JLabel();
        jToggleButton61 = new javax.swing.JToggleButton();
        jToggleButton62 = new javax.swing.JToggleButton();
        jToggleButton63 = new javax.swing.JToggleButton();
        jLabel138 = new javax.swing.JLabel();
        jToggleButton65 = new javax.swing.JToggleButton();
        jToggleButton66 = new javax.swing.JToggleButton();
        jToggleButton67 = new javax.swing.JToggleButton();
        jLabel139 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jToggleButton69 = new javax.swing.JToggleButton();
        jToggleButton70 = new javax.swing.JToggleButton();
        jToggleButton71 = new javax.swing.JToggleButton();
        jToggleButton73 = new javax.swing.JToggleButton();
        jToggleButton74 = new javax.swing.JToggleButton();
        jToggleButton75 = new javax.swing.JToggleButton();
        jToggleButton77 = new javax.swing.JToggleButton();
        jToggleButton78 = new javax.swing.JToggleButton();
        jToggleButton79 = new javax.swing.JToggleButton();
        jToggleButton81 = new javax.swing.JToggleButton();
        jToggleButton82 = new javax.swing.JToggleButton();
        jToggleButton113 = new javax.swing.JToggleButton();
        jToggleButton115 = new javax.swing.JToggleButton();
        jToggleButton116 = new javax.swing.JToggleButton();
        jToggleButton117 = new javax.swing.JToggleButton();
        jToggleButton119 = new javax.swing.JToggleButton();
        jToggleButton120 = new javax.swing.JToggleButton();
        jToggleButton121 = new javax.swing.JToggleButton();
        jToggleButton207 = new javax.swing.JToggleButton();
        jToggleButton208 = new javax.swing.JToggleButton();
        jToggleButton209 = new javax.swing.JToggleButton();
        jToggleButton210 = new javax.swing.JToggleButton();
        jToggleButton211 = new javax.swing.JToggleButton();
        jToggleButton212 = new javax.swing.JToggleButton();
        jToggleButton213 = new javax.swing.JToggleButton();
        jToggleButton214 = new javax.swing.JToggleButton();
        jToggleButton215 = new javax.swing.JToggleButton();
        jToggleButton216 = new javax.swing.JToggleButton();
        jToggleButton217 = new javax.swing.JToggleButton();
        jToggleButton218 = new javax.swing.JToggleButton();
        jToggleButton219 = new javax.swing.JToggleButton();
        jToggleButton220 = new javax.swing.JToggleButton();
        jToggleButton221 = new javax.swing.JToggleButton();
        cuidatBtn22 = new javax.swing.JToggleButton();
        jToggleButton222 = new javax.swing.JToggleButton();
        raoBtn29 = new javax.swing.JToggleButton();
        activitatsFBtn25 = new javax.swing.JToggleButton();
        jToggleButton223 = new javax.swing.JToggleButton();
        orientacioBtn26 = new javax.swing.JToggleButton();
        memoBtn26 = new javax.swing.JToggleButton();
        jToggleButton224 = new javax.swing.JToggleButton();
        jToggleButton225 = new javax.swing.JToggleButton();
        jToggleButton226 = new javax.swing.JToggleButton();
        jToggleButton227 = new javax.swing.JToggleButton();
        jToggleButton228 = new javax.swing.JToggleButton();
        jToggleButton229 = new javax.swing.JToggleButton();
        jToggleButton230 = new javax.swing.JToggleButton();
        jToggleButton231 = new javax.swing.JToggleButton();
        jToggleButton232 = new javax.swing.JToggleButton();
        jToggleButton233 = new javax.swing.JToggleButton();
        jToggleButton234 = new javax.swing.JToggleButton();
        jToggleButton235 = new javax.swing.JToggleButton();
        jToggleButton236 = new javax.swing.JToggleButton();
        jToggleButton237 = new javax.swing.JToggleButton();
        jToggleButton238 = new javax.swing.JToggleButton();
        cuidatBtn23 = new javax.swing.JToggleButton();
        jToggleButton239 = new javax.swing.JToggleButton();
        raoBtn30 = new javax.swing.JToggleButton();
        activitatsFBtn26 = new javax.swing.JToggleButton();
        jToggleButton240 = new javax.swing.JToggleButton();
        orientacioBtn27 = new javax.swing.JToggleButton();
        memoBtn27 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        zaritTotal = new javax.swing.JLabel();
        sf12Tab = new javax.swing.JPanel();
        sf12Scroll = new javax.swing.JScrollPane();
        sf12Panel = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        sf12Total = new javax.swing.JLabel();
        jRadioButton53 = new javax.swing.JRadioButton();
        jRadioButton54 = new javax.swing.JRadioButton();
        jRadioButton55 = new javax.swing.JRadioButton();
        jRadioButton56 = new javax.swing.JRadioButton();
        jRadioButton57 = new javax.swing.JRadioButton();
        jRadioButton58 = new javax.swing.JRadioButton();
        jRadioButton59 = new javax.swing.JRadioButton();
        jRadioButton60 = new javax.swing.JRadioButton();
        jRadioButton65 = new javax.swing.JRadioButton();
        jRadioButton66 = new javax.swing.JRadioButton();
        jRadioButton67 = new javax.swing.JRadioButton();
        jRadioButton68 = new javax.swing.JRadioButton();
        jRadioButton69 = new javax.swing.JRadioButton();
        jRadioButton70 = new javax.swing.JRadioButton();
        jRadioButton71 = new javax.swing.JRadioButton();
        jRadioButton72 = new javax.swing.JRadioButton();
        jRadioButton73 = new javax.swing.JRadioButton();
        jRadioButton74 = new javax.swing.JRadioButton();
        jRadioButton75 = new javax.swing.JRadioButton();
        jRadioButton76 = new javax.swing.JRadioButton();
        jRadioButton77 = new javax.swing.JRadioButton();
        jRadioButton78 = new javax.swing.JRadioButton();
        jRadioButton79 = new javax.swing.JRadioButton();
        jRadioButton80 = new javax.swing.JRadioButton();
        jRadioButton81 = new javax.swing.JRadioButton();
        jRadioButton82 = new javax.swing.JRadioButton();
        jRadioButton83 = new javax.swing.JRadioButton();
        jRadioButton84 = new javax.swing.JRadioButton();
        jRadioButton85 = new javax.swing.JRadioButton();
        jRadioButton86 = new javax.swing.JRadioButton();
        jRadioButton87 = new javax.swing.JRadioButton();
        jRadioButton88 = new javax.swing.JRadioButton();
        jRadioButton89 = new javax.swing.JRadioButton();
        jRadioButton90 = new javax.swing.JRadioButton();
        jRadioButton91 = new javax.swing.JRadioButton();
        jRadioButton92 = new javax.swing.JRadioButton();
        jRadioButton93 = new javax.swing.JRadioButton();
        jRadioButton94 = new javax.swing.JRadioButton();
        jRadioButton95 = new javax.swing.JRadioButton();
        jRadioButton96 = new javax.swing.JRadioButton();
        jRadioButton97 = new javax.swing.JRadioButton();
        jRadioButton98 = new javax.swing.JRadioButton();
        jRadioButton99 = new javax.swing.JRadioButton();
        jRadioButton100 = new javax.swing.JRadioButton();
        jRadioButton101 = new javax.swing.JRadioButton();
        jRadioButton102 = new javax.swing.JRadioButton();
        jRadioButton103 = new javax.swing.JRadioButton();
        jRadioButton104 = new javax.swing.JRadioButton();
        dukeTab = new javax.swing.JPanel();
        dukeScroll = new javax.swing.JScrollPane();
        dukePanel = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
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
        cuidatBtn11 = new javax.swing.JToggleButton();
        cuidatBtn12 = new javax.swing.JToggleButton();
        cuidatBtn13 = new javax.swing.JToggleButton();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jToggleButton35 = new javax.swing.JToggleButton();
        jToggleButton36 = new javax.swing.JToggleButton();
        jToggleButton37 = new javax.swing.JToggleButton();
        jToggleButton38 = new javax.swing.JToggleButton();
        jToggleButton39 = new javax.swing.JToggleButton();
        jToggleButton40 = new javax.swing.JToggleButton();
        jToggleButton41 = new javax.swing.JToggleButton();
        jToggleButton42 = new javax.swing.JToggleButton();
        jToggleButton43 = new javax.swing.JToggleButton();
        jToggleButton44 = new javax.swing.JToggleButton();
        jToggleButton45 = new javax.swing.JToggleButton();
        jToggleButton46 = new javax.swing.JToggleButton();
        jToggleButton47 = new javax.swing.JToggleButton();
        jToggleButton48 = new javax.swing.JToggleButton();
        jToggleButton49 = new javax.swing.JToggleButton();
        jToggleButton50 = new javax.swing.JToggleButton();
        jToggleButton51 = new javax.swing.JToggleButton();
        jToggleButton52 = new javax.swing.JToggleButton();
        jToggleButton53 = new javax.swing.JToggleButton();
        jToggleButton54 = new javax.swing.JToggleButton();
        jToggleButton55 = new javax.swing.JToggleButton();
        jToggleButton56 = new javax.swing.JToggleButton();
        jLabel141 = new javax.swing.JLabel();
        dukeTotal = new javax.swing.JLabel();
        faqTab = new javax.swing.JPanel();
        faqScroll = new javax.swing.JScrollPane();
        faqPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        faqQPanel = new javax.swing.JPanel();
        orientacioBtn18 = new javax.swing.JToggleButton();
        memoBtn18 = new javax.swing.JToggleButton();
        orientacioBtn19 = new javax.swing.JToggleButton();
        memoBtn19 = new javax.swing.JToggleButton();
        orientacioBtn21 = new javax.swing.JToggleButton();
        memoBtn21 = new javax.swing.JToggleButton();
        memoBtn25 = new javax.swing.JToggleButton();
        orientacioBtn25 = new javax.swing.JToggleButton();
        raoBtn18 = new javax.swing.JToggleButton();
        raoBtn20 = new javax.swing.JToggleButton();
        raoBtn23 = new javax.swing.JToggleButton();
        raoBtn26 = new javax.swing.JToggleButton();
        activitatsFBtn18 = new javax.swing.JToggleButton();
        activitatsFBtn19 = new javax.swing.JToggleButton();
        activitatsFBtn20 = new javax.swing.JToggleButton();
        activitatsFBtn21 = new javax.swing.JToggleButton();
        activitatsDBtn18 = new javax.swing.JToggleButton();
        activitatsDBtn19 = new javax.swing.JToggleButton();
        activitatsDBtn20 = new javax.swing.JToggleButton();
        activitatsDBtn21 = new javax.swing.JToggleButton();
        cuidatBtn14 = new javax.swing.JToggleButton();
        cuidatBtn16 = new javax.swing.JToggleButton();
        cuidatBtn19 = new javax.swing.JToggleButton();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jToggleButton60 = new javax.swing.JToggleButton();
        jToggleButton64 = new javax.swing.JToggleButton();
        jToggleButton68 = new javax.swing.JToggleButton();
        jToggleButton72 = new javax.swing.JToggleButton();
        jToggleButton76 = new javax.swing.JToggleButton();
        jToggleButton80 = new javax.swing.JToggleButton();
        jToggleButton91 = new javax.swing.JToggleButton();
        jToggleButton98 = new javax.swing.JToggleButton();
        jToggleButton102 = new javax.swing.JToggleButton();
        jToggleButton106 = new javax.swing.JToggleButton();
        jToggleButton108 = new javax.swing.JToggleButton();
        jToggleButton110 = new javax.swing.JToggleButton();
        jToggleButton112 = new javax.swing.JToggleButton();
        jToggleButton114 = new javax.swing.JToggleButton();
        jToggleButton126 = new javax.swing.JToggleButton();
        jToggleButton130 = new javax.swing.JToggleButton();
        jToggleButton148 = new javax.swing.JToggleButton();
        jToggleButton149 = new javax.swing.JToggleButton();
        jToggleButton154 = new javax.swing.JToggleButton();
        jToggleButton155 = new javax.swing.JToggleButton();
        jToggleButton156 = new javax.swing.JToggleButton();
        jToggleButton157 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        faqTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.BorderLayout());

        dataPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(dataPanel, java.awt.BorderLayout.LINE_START);

        acceptaBtn.setText("Accepta");
        acceptaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptaBtnActionPerformed(evt);
            }
        });

        cancelaBtn.setText("Cancel·la");
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
                .addContainerGap(1132, Short.MAX_VALUE)
                .addComponent(acceptaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelaBtn)
                .addContainerGap())
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

        mainPanel.add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        tabbedPanel.setToolTipText("");
        tabbedPanel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        npiTab.setLayout(new java.awt.CardLayout());

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("<html><center><b>HABILITATS DE COMUNICACIÓ: Telèfon i carta</b>");

        npiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trastorns neuropsiquiàtrics (màxima puntuació: 120)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        npiPanel.setLayout(new java.awt.GridBagLayout());

        npiFreqBtnGroup2.add(orientacioBtn20);
        orientacioBtn20.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(orientacioBtn20, gridBagConstraints);

        npiFreqBtnGroup1.add(memoBtn20);
        memoBtn20.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(memoBtn20, gridBagConstraints);

        npiFreqBtnGroup3.add(raoBtn19);
        raoBtn19.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(raoBtn19, gridBagConstraints);

        npiFreqBtnGroup7.add(raoBtn21);
        raoBtn21.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(raoBtn21, gridBagConstraints);

        npiFreqBtnGroup4.add(activitatsDBtn22);
        activitatsDBtn22.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn22, gridBagConstraints);

        npiFreqBtnGroup6.add(cuidatBtn15);
        cuidatBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(cuidatBtn15, gridBagConstraints);

        jLabel166.setText("Depressió/disfòria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel166, gridBagConstraints);

        jLabel191.setText("<html><center><b>Total (Freqüència x<br>Gravetat)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 3, 1);
        npiPanel.add(jLabel191, gridBagConstraints);

        jLabel83.setText("Puntuació total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel83, gridBagConstraints);

        jLabel84.setText("Deliris");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        npiPanel.add(jLabel84, gridBagConstraints);

        jLabel85.setText("Agitació");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        npiPanel.add(jLabel85, gridBagConstraints);

        jLabel86.setText("Ansietat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        npiPanel.add(jLabel86, gridBagConstraints);

        jLabel192.setText("Eufòr/alegria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel192, gridBagConstraints);

        jLabel193.setText("Apatía/indiferència");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel193, gridBagConstraints);

        jLabel194.setText("Desinhibició");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel194, gridBagConstraints);

        jLabel202.setText("Irritabilitat/labilitat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel202, gridBagConstraints);

        npiGravBtnGroup8.add(jToggleButton118);
        jToggleButton118.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(jToggleButton118, gridBagConstraints);

        npiFreqBtnGroup5.add(jToggleButton122);
        jToggleButton122.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton122, gridBagConstraints);

        npiFreqBtnGroup6.add(jToggleButton134);
        jToggleButton134.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton134, gridBagConstraints);

        npiFreqBtnGroup7.add(jToggleButton138);
        jToggleButton138.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton138, gridBagConstraints);

        npiFreqBtnGroup5.add(jToggleButton142);
        jToggleButton142.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton142, gridBagConstraints);

        npiFreqBtnGroup10.add(jToggleButton146);
        jToggleButton146.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton146, gridBagConstraints);

        npiGravBtnGroup10.add(jToggleButton147);
        jToggleButton147.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(jToggleButton147, gridBagConstraints);

        jLabel206.setText("<html><b>No valorable<br>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 3, 3);
        npiPanel.add(jLabel206, gridBagConstraints);

        npiGravBtnGroup6.add(activitatsDBtn25);
        activitatsDBtn25.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn25, gridBagConstraints);

        npiGravBtnGroup7.add(jToggleButton150);
        jToggleButton150.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton150, gridBagConstraints);

        npiGravBtnGroup8.add(jToggleButton151);
        jToggleButton151.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton151, gridBagConstraints);

        npiGravBtnGroup9.add(jToggleButton152);
        jToggleButton152.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton152, gridBagConstraints);

        npiGravBtnGroup10.add(jToggleButton153);
        jToggleButton153.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton153, gridBagConstraints);

        jLabel4.setText("<html><b>Transtorn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel4, gridBagConstraints);

        jLabel5.setText("<html><b>Freqüència");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Conducta motora sense finalitat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel6, gridBagConstraints);

        jLabel7.setText("<html><b>Gravetat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Al·lucinacions");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck8, gridBagConstraints);

        npiGravBtnGroup7.add(raoBtn27);
        raoBtn27.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(raoBtn27, gridBagConstraints);

        npiGravBtnGroup5.add(jToggleButton158);
        jToggleButton158.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(jToggleButton158, gridBagConstraints);

        npiGravBtnGroup4.add(jToggleButton159);
        jToggleButton159.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(jToggleButton159, gridBagConstraints);

        npiGravBtnGroup2.add(cuidatBtn20);
        cuidatBtn20.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(cuidatBtn20, gridBagConstraints);

        npiGravBtnGroup3.add(jToggleButton160);
        jToggleButton160.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(jToggleButton160, gridBagConstraints);

        npiGravBtnGroup1.add(raoBtn28);
        raoBtn28.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(raoBtn28, gridBagConstraints);

        npiFreqBtnGroup3.add(jToggleButton161);
        jToggleButton161.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton161, gridBagConstraints);

        npiFreqBtnGroup2.add(jToggleButton162);
        jToggleButton162.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton162, gridBagConstraints);

        npiFreqBtnGroup1.add(cuidatBtn21);
        cuidatBtn21.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(cuidatBtn21, gridBagConstraints);

        npiGravBtnGroup6.add(jToggleButton163);
        jToggleButton163.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(jToggleButton163, gridBagConstraints);

        npiFreqBtnGroup4.add(jToggleButton164);
        jToggleButton164.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton164, gridBagConstraints);

        npiFreqBtnGroup8.add(jToggleButton165);
        jToggleButton165.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton165, gridBagConstraints);

        npiFreqBtnGroup10.add(jToggleButton166);
        jToggleButton166.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton166, gridBagConstraints);

        npiFreqBtnGroup8.add(jToggleButton167);
        jToggleButton167.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton167, gridBagConstraints);

        npiGravBtnGroup5.add(jToggleButton168);
        jToggleButton168.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton168, gridBagConstraints);

        npiGravBtnGroup4.add(jToggleButton169);
        jToggleButton169.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton169, gridBagConstraints);

        npiGravBtnGroup3.add(jToggleButton170);
        jToggleButton170.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton170, gridBagConstraints);

        npiGravBtnGroup2.add(jToggleButton171);
        jToggleButton171.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton171, gridBagConstraints);

        npiGravBtnGroup1.add(activitatsDBtn26);
        activitatsDBtn26.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn26, gridBagConstraints);

        npiFreqBtnGroup9.add(jToggleButton172);
        jToggleButton172.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton172, gridBagConstraints);

        npiFreqBtnGroup9.add(jToggleButton173);
        jToggleButton173.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton173, gridBagConstraints);

        npiGravBtnGroup9.add(jToggleButton174);
        jToggleButton174.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 1, 0);
        npiPanel.add(jToggleButton174, gridBagConstraints);

        npiFreqBtnGroup1.add(activitatsDBtn27);
        activitatsDBtn27.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn27, gridBagConstraints);

        npiFreqBtnGroup2.add(jToggleButton175);
        jToggleButton175.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton175, gridBagConstraints);

        npiFreqBtnGroup3.add(jToggleButton176);
        jToggleButton176.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton176, gridBagConstraints);

        npiFreqBtnGroup4.add(jToggleButton177);
        jToggleButton177.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton177, gridBagConstraints);

        npiFreqBtnGroup5.add(jToggleButton178);
        jToggleButton178.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton178, gridBagConstraints);

        npiFreqBtnGroup6.add(activitatsDBtn28);
        activitatsDBtn28.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn28, gridBagConstraints);

        npiFreqBtnGroup7.add(jToggleButton179);
        jToggleButton179.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton179, gridBagConstraints);

        npiFreqBtnGroup8.add(jToggleButton180);
        jToggleButton180.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton180, gridBagConstraints);

        npiFreqBtnGroup9.add(jToggleButton181);
        jToggleButton181.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton181, gridBagConstraints);

        npiFreqBtnGroup10.add(jToggleButton182);
        jToggleButton182.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton182, gridBagConstraints);

        npiGravBtnGroup1.add(activitatsDBtn29);
        activitatsDBtn29.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn29, gridBagConstraints);

        npiGravBtnGroup2.add(jToggleButton183);
        jToggleButton183.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton183, gridBagConstraints);

        npiGravBtnGroup3.add(jToggleButton184);
        jToggleButton184.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton184, gridBagConstraints);

        npiGravBtnGroup4.add(jToggleButton185);
        jToggleButton185.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton185, gridBagConstraints);

        npiGravBtnGroup5.add(jToggleButton186);
        jToggleButton186.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton186, gridBagConstraints);

        npiGravBtnGroup6.add(activitatsDBtn30);
        activitatsDBtn30.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn30, gridBagConstraints);

        npiGravBtnGroup7.add(jToggleButton187);
        jToggleButton187.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton187, gridBagConstraints);

        npiGravBtnGroup8.add(jToggleButton188);
        jToggleButton188.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton188, gridBagConstraints);

        npiGravBtnGroup9.add(jToggleButton189);
        jToggleButton189.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton189, gridBagConstraints);

        npiGravBtnGroup10.add(jToggleButton190);
        jToggleButton190.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton190, gridBagConstraints);

        npiFreqBtnGroup1.add(activitatsDBtn31);
        activitatsDBtn31.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn31, gridBagConstraints);

        npiFreqBtnGroup2.add(jToggleButton191);
        jToggleButton191.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton191, gridBagConstraints);

        npiFreqBtnGroup3.add(jToggleButton192);
        jToggleButton192.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton192, gridBagConstraints);

        npiFreqBtnGroup4.add(jToggleButton193);
        jToggleButton193.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton193, gridBagConstraints);

        npiFreqBtnGroup5.add(jToggleButton194);
        jToggleButton194.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton194, gridBagConstraints);

        npiFreqBtnGroup6.add(activitatsDBtn32);
        activitatsDBtn32.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn32, gridBagConstraints);

        npiFreqBtnGroup7.add(jToggleButton195);
        jToggleButton195.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton195, gridBagConstraints);

        npiFreqBtnGroup8.add(jToggleButton196);
        jToggleButton196.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton196, gridBagConstraints);

        npiFreqBtnGroup9.add(jToggleButton197);
        jToggleButton197.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton197, gridBagConstraints);

        npiFreqBtnGroup10.add(jToggleButton198);
        jToggleButton198.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton198, gridBagConstraints);

        npiFreqBtnGroup1.add(activitatsDBtn33);
        activitatsDBtn33.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn33, gridBagConstraints);

        npiFreqBtnGroup2.add(jToggleButton199);
        jToggleButton199.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton199, gridBagConstraints);

        npiFreqBtnGroup3.add(jToggleButton200);
        jToggleButton200.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton200, gridBagConstraints);

        npiFreqBtnGroup4.add(jToggleButton201);
        jToggleButton201.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton201, gridBagConstraints);

        npiFreqBtnGroup5.add(jToggleButton202);
        jToggleButton202.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton202, gridBagConstraints);

        npiFreqBtnGroup6.add(activitatsDBtn34);
        activitatsDBtn34.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(activitatsDBtn34, gridBagConstraints);

        npiFreqBtnGroup7.add(jToggleButton203);
        jToggleButton203.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton203, gridBagConstraints);

        npiFreqBtnGroup8.add(jToggleButton204);
        jToggleButton204.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton204, gridBagConstraints);

        npiFreqBtnGroup9.add(jToggleButton205);
        jToggleButton205.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton205, gridBagConstraints);

        npiFreqBtnGroup10.add(jToggleButton206);
        jToggleButton206.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        npiPanel.add(jToggleButton206, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        npiPanel.add(npiCheck10, gridBagConstraints);

        npiTotal1.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 4;
        npiPanel.add(npiTotal1, gridBagConstraints);

        npiTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        npiTotal.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 3;
        npiPanel.add(npiTotal, gridBagConstraints);

        npiTotal3.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        npiPanel.add(npiTotal3, gridBagConstraints);

        npiTotal2.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 5;
        npiPanel.add(npiTotal2, gridBagConstraints);

        npiTotal4.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 7;
        npiPanel.add(npiTotal4, gridBagConstraints);

        npiTotal5.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        npiPanel.add(npiTotal5, gridBagConstraints);

        npiTotal6.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 9;
        npiPanel.add(npiTotal6, gridBagConstraints);

        npiTotal8.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 11;
        npiPanel.add(npiTotal8, gridBagConstraints);

        npiTotal9.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 12;
        npiPanel.add(npiTotal9, gridBagConstraints);

        npiTotal10.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 13;
        npiPanel.add(npiTotal10, gridBagConstraints);

        npiTotal7.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 10;
        npiPanel.add(npiTotal7, gridBagConstraints);

        jLabel144.setText("<html><u><b>Freqüència:</b></u> 0 = Absent; 1 = Ocasionalment (menys d'una vegada per setmana); 2 = Sovint (al voltant d'una vegada per setmana); 3 = Freqüentment (diverses vegades per setmana, però no diàriament); 4 = Molt freqüentment (diàriament o contínuament)");

        jLabel145.setText("<html><b><u>Gravetat:</b></u> 1 = Lleu (provoca poca molèsties al pacient); 2 = Moderada (més molest per al pacient, però pot es redirigit pel cuidador); 3 = Greu (molt molest per al pacient i difícil de redirigir)");

        javax.swing.GroupLayout npi2PanelLayout = new javax.swing.GroupLayout(npi2Panel);
        npi2Panel.setLayout(npi2PanelLayout);
        npi2PanelLayout.setHorizontalGroup(
            npi2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(npi2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(npi2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(npiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(npi2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel145, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                        .addComponent(jLabel144, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(5707, Short.MAX_VALUE))
        );
        npi2PanelLayout.setVerticalGroup(
            npi2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(npi2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(npiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(796, 796, 796))
        );

        npiScroll.setViewportView(npi2Panel);

        npiTab.add(npiScroll, "card1");

        tabbedPanel.addTab("NPI", npiTab);

        hadTab.setLayout(new java.awt.CardLayout());

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel111.setText("<html><center><b>Escala Hospitalària d'Ansietat i Depressió</b>");

        jPanel3.setName("A"); // NOI18N

        hadButtonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Tots els dies");
        jRadioButton4.setActionCommand("3");

        hadButtonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Moltes vegades");
        jRadioButton3.setActionCommand("2");

        hadButtonGroup1.add(jRadioButton2);
        jRadioButton2.setText("De vegades");
        jRadioButton2.setActionCommand("1");

        hadButtonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Mai");
        jRadioButton1.setActionCommand("0");

        jLabel17.setText("1. Em sento tens o nerviós (A)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setName("D"); // NOI18N

        hadButtonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Gens");
        jRadioButton5.setActionCommand("3");

        hadButtonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Només una mica");
        jRadioButton6.setActionCommand("2");

        hadButtonGroup2.add(jRadioButton7);
        jRadioButton7.setText("No prou");
        jRadioButton7.setActionCommand("1");

        hadButtonGroup2.add(jRadioButton8);
        jRadioButton8.setText("Com sempre");
        jRadioButton8.setActionCommand("0");

        jLabel18.setText("2. Encara gaudeixo amb el que abans m'agradava (D)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setName("D"); // NOI18N

        jLabel20.setText("<html>4. Puc riure i veure el costat divertit de les coses (D)");

        hadButtonGroup4.add(jRadioButton13);
        jRadioButton13.setText("Igual que sempre ho vaig fer");
        jRadioButton13.setActionCommand("0");

        hadButtonGroup4.add(jRadioButton14);
        jRadioButton14.setText("No tant ara");
        jRadioButton14.setActionCommand("1");

        hadButtonGroup4.add(jRadioButton15);
        jRadioButton15.setText("Quasi mai");
        jRadioButton15.setActionCommand("2");

        hadButtonGroup4.add(jRadioButton16);
        jRadioButton16.setText("Mai");
        jRadioButton16.setActionCommand("3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton14)
                            .addComponent(jRadioButton13)
                            .addComponent(jRadioButton15)
                            .addComponent(jRadioButton16))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setName("A"); // NOI18N

        jLabel21.setText("5. Tinc la meva ment plena de preocupacions (A)");

        hadButtonGroup5.add(jRadioButton17);
        jRadioButton17.setText("Només en ocasions");
        jRadioButton17.setActionCommand("0");

        hadButtonGroup5.add(jRadioButton18);
        jRadioButton18.setText("De vegades, encara que no molt sovint");
        jRadioButton18.setActionCommand("1");

        hadButtonGroup5.add(jRadioButton19);
        jRadioButton19.setText("Amb bastanta freqüència");
        jRadioButton19.setActionCommand("2");

        hadButtonGroup5.add(jRadioButton20);
        jRadioButton20.setText("La majoria de vegades");
        jRadioButton20.setActionCommand("3");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton18)
                            .addComponent(jRadioButton17)
                            .addComponent(jRadioButton19)
                            .addComponent(jRadioButton20))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setName("D"); // NOI18N

        jLabel22.setText("6. Em sento alegre (D)");

        hadButtonGroup6.add(jRadioButton21);
        jRadioButton21.setText("Quasi sempre");
        jRadioButton21.setActionCommand("0");

        hadButtonGroup6.add(jRadioButton22);
        jRadioButton22.setText("De vegades");
        jRadioButton22.setActionCommand("1");

        hadButtonGroup6.add(jRadioButton23);
        jRadioButton23.setText("No molt sovint");
        jRadioButton23.setActionCommand("2");

        hadButtonGroup6.add(jRadioButton24);
        jRadioButton24.setText("Mai");
        jRadioButton24.setActionCommand("3");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton22)
                            .addComponent(jRadioButton21)
                            .addComponent(jRadioButton23)
                            .addComponent(jRadioButton24))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setName("A"); // NOI18N

        jLabel23.setText("<html>7. Puc estar assegut tranquil·lament<br>i sentir-se relaxat (A)");

        hadButtonGroup7.add(jRadioButton28);
        jRadioButton28.setText("Sempre");
        jRadioButton28.setActionCommand("0");

        hadButtonGroup7.add(jRadioButton27);
        jRadioButton27.setText("Generalment");
        jRadioButton27.setActionCommand("1");

        hadButtonGroup7.add(jRadioButton26);
        jRadioButton26.setText("No molt sovint");
        jRadioButton26.setActionCommand("2");

        hadButtonGroup7.add(jRadioButton25);
        jRadioButton25.setText("Mai");
        jRadioButton25.setActionCommand("3");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton27)
                            .addComponent(jRadioButton28)
                            .addComponent(jRadioButton26)
                            .addComponent(jRadioButton25))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setName("D"); // NOI18N

        jLabel24.setText("8. Em sento com si cada dia estés més lent (D)");

        hadButtonGroup8.add(jRadioButton29);
        jRadioButton29.setText("Mai");
        jRadioButton29.setActionCommand("0");

        hadButtonGroup8.add(jRadioButton30);
        jRadioButton30.setText("De vegades");
        jRadioButton30.setActionCommand("1");

        hadButtonGroup8.add(jRadioButton31);
        jRadioButton31.setText("Molt sovint");
        jRadioButton31.setActionCommand("2");

        hadButtonGroup8.add(jRadioButton32);
        jRadioButton32.setText("Generalment en tot moment");
        jRadioButton32.setActionCommand("3");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton30)
                            .addComponent(jRadioButton29)
                            .addComponent(jRadioButton31)
                            .addComponent(jRadioButton32))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setName("A"); // NOI18N

        jLabel25.setText("<html>9. Tinc una sensació estranya, com de <br>\"aleteig\" a l'estómac (A)");

        hadButtonGroup9.add(jRadioButton33);
        jRadioButton33.setText("Mai");
        jRadioButton33.setActionCommand("0");

        hadButtonGroup9.add(jRadioButton34);
        jRadioButton34.setText("En certes ocasions");
        jRadioButton34.setActionCommand("1");

        hadButtonGroup9.add(jRadioButton35);
        jRadioButton35.setText("Amb bastanta freqüència");
        jRadioButton35.setActionCommand("2");

        hadButtonGroup9.add(jRadioButton36);
        jRadioButton36.setText("Molt sovint");
        jRadioButton36.setActionCommand("3");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton34)
                            .addComponent(jRadioButton33)
                            .addComponent(jRadioButton35)
                            .addComponent(jRadioButton36))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setName("D"); // NOI18N

        jLabel26.setText("10. He perdut interès pel meu aspecte personal (D)");

        hadButtonGroup10.add(jRadioButton37);
        jRadioButton37.setText("Em preocupo igual que sempre");
        jRadioButton37.setActionCommand("0");

        hadButtonGroup10.add(jRadioButton38);
        jRadioButton38.setText("Podria tenir una mica més de cura");
        jRadioButton38.setActionCommand("1");

        hadButtonGroup10.add(jRadioButton39);
        jRadioButton39.setText("No em preocupo tant com hauria");
        jRadioButton39.setActionCommand("2");

        hadButtonGroup10.add(jRadioButton40);
        jRadioButton40.setText("Totalment");
        jRadioButton40.setActionCommand("3");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton38)
                            .addComponent(jRadioButton37)
                            .addComponent(jRadioButton39)
                            .addComponent(jRadioButton40))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setName("A"); // NOI18N

        jLabel19.setText("<html>3. Tinc una sensació de por, com si alguna<br>cosa horrible m'hagués de passar (A)");

        hadButtonGroup3.add(jRadioButton12);
        jRadioButton12.setText("Mai");
        jRadioButton12.setActionCommand("0");

        hadButtonGroup3.add(jRadioButton11);
        jRadioButton11.setText("De vegades");
        jRadioButton11.setActionCommand("1");

        hadButtonGroup3.add(jRadioButton10);
        jRadioButton10.setText("Moltes vegades");
        jRadioButton10.setActionCommand("2");

        hadButtonGroup3.add(jRadioButton9);
        jRadioButton9.setText("Tots els dies");
        jRadioButton9.setActionCommand("3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton11)
                            .addComponent(jRadioButton12)
                            .addComponent(jRadioButton10)
                            .addComponent(jRadioButton9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setName("A"); // NOI18N

        jLabel27.setText("<html>11. Em sento inquiet, com si no em <br>pogués parar de moure (A)");

        hadButtonGroup11.add(jRadioButton41);
        jRadioButton41.setText("Gens");
        jRadioButton41.setActionCommand("0");

        hadButtonGroup11.add(jRadioButton42);
        jRadioButton42.setText("No molt");
        jRadioButton42.setActionCommand("1");

        hadButtonGroup11.add(jRadioButton43);
        jRadioButton43.setText("Bastant");
        jRadioButton43.setActionCommand("2");

        hadButtonGroup11.add(jRadioButton44);
        jRadioButton44.setText("Molt");
        jRadioButton44.setActionCommand("3");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton42)
                            .addComponent(jRadioButton41)
                            .addComponent(jRadioButton43)
                            .addComponent(jRadioButton44))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton44)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setName("D"); // NOI18N

        jLabel28.setText("12. Em sento optimista respecte al futur (D)");

        hadButtonGroup12.add(jRadioButton45);
        jRadioButton45.setText("Igual que sempre");
        jRadioButton45.setActionCommand("0");

        hadButtonGroup12.add(jRadioButton46);
        jRadioButton46.setText("Menys del que acostumava");
        jRadioButton46.setActionCommand("1");

        hadButtonGroup12.add(jRadioButton47);
        jRadioButton47.setText("Molt menys del que acostumava");
        jRadioButton47.setActionCommand("2");

        hadButtonGroup12.add(jRadioButton48);
        jRadioButton48.setText("Gens");
        jRadioButton48.setActionCommand("3");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton46)
                            .addComponent(jRadioButton45)
                            .addComponent(jRadioButton47)
                            .addComponent(jRadioButton48))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton48)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setName("A"); // NOI18N

        jLabel68.setText("13. M'assalten sentiments sobtats de pànic (A)");

        hadButtonGroup13.add(jRadioButton49);
        jRadioButton49.setText("Gens");
        jRadioButton49.setActionCommand("0");

        hadButtonGroup13.add(jRadioButton50);
        jRadioButton50.setText("No molt sovint");
        jRadioButton50.setActionCommand("1");

        hadButtonGroup13.add(jRadioButton51);
        jRadioButton51.setText("Bastant sovint");
        jRadioButton51.setActionCommand("2");

        hadButtonGroup13.add(jRadioButton52);
        jRadioButton52.setText("Molt freqüentment");
        jRadioButton52.setActionCommand("3");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton50)
                            .addComponent(jRadioButton49)
                            .addComponent(jRadioButton51)
                            .addComponent(jRadioButton52))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton52)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setName("D"); // NOI18N

        jLabel71.setText("<html>14. Em diverteixo amb un bon llibre, <br>la ràdio o un programa de television (D)");

        hadButtonGroup14.add(jRadioButton61);
        jRadioButton61.setText("Sovint");
        jRadioButton61.setActionCommand("0");

        hadButtonGroup14.add(jRadioButton62);
        jRadioButton62.setText("A vegades");
        jRadioButton62.setActionCommand("1");

        hadButtonGroup14.add(jRadioButton63);
        jRadioButton63.setText("No gaire sovint");
        jRadioButton63.setActionCommand("2");

        hadButtonGroup14.add(jRadioButton64);
        jRadioButton64.setText("Poques vegades");
        jRadioButton64.setActionCommand("3");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton62)
                            .addComponent(jRadioButton61)
                            .addComponent(jRadioButton63)
                            .addComponent(jRadioButton64))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton64)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel72.setText("TOTAL A:");

        jLabel73.setText("TOTAL D:");

        hadTotalA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hadTotalA.setText("0");

        hadTotalD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hadTotalD.setText("0");

        hadInterpretacioA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hadInterpretacioA.setText("Cas dubtós");

        hadInterpretacioD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hadInterpretacioD.setText("Cas dubtós");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hadTotalA))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hadTotalD))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hadInterpretacioD)
                            .addComponent(hadInterpretacioA))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(hadTotalA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hadInterpretacioA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(hadTotalD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hadInterpretacioD)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel69.setText("<html>Aquesta prova està dirigida a determinar com t'has sentit en l'última setmana tot i que les preguntes estan formulades en present.<br>Has de triar entre una de quatre possibilitats pel que fa a la pregunta realitzada, envoltant amb un cercle la resposta triada.");

        javax.swing.GroupLayout hadPanelLayout = new javax.swing.GroupLayout(hadPanel);
        hadPanel.setLayout(hadPanelLayout);
        hadPanelLayout.setHorizontalGroup(
            hadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(hadPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(hadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        hadPanelLayout.setVerticalGroup(
            hadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        hadScroll.setViewportView(hadPanel);

        hadTab.add(hadScroll, "card1");

        tabbedPanel.addTab("HAD", hadTab);

        zaritTab.setLayout(new java.awt.CardLayout());

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel109.setText("<html><center><b>QÜESTIONARI -ZARIT-</b>");

        zaritQPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qüestionari", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        zaritQPanel.setLayout(new java.awt.GridBagLayout());

        zaritBtnGroup2.add(orientacioBtn22);
        orientacioBtn22.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(orientacioBtn22, gridBagConstraints);

        zaritBtnGroup1.add(memoBtn22);
        memoBtn22.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(memoBtn22, gridBagConstraints);

        zaritBtnGroup2.add(orientacioBtn23);
        orientacioBtn23.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(orientacioBtn23, gridBagConstraints);

        zaritBtnGroup1.add(memoBtn23);
        memoBtn23.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(memoBtn23, gridBagConstraints);

        zaritBtnGroup2.add(orientacioBtn24);
        orientacioBtn24.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(orientacioBtn24, gridBagConstraints);

        zaritBtnGroup1.add(memoBtn24);
        memoBtn24.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(memoBtn24, gridBagConstraints);

        zaritBtnGroup3.add(raoBtn22);
        raoBtn22.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(raoBtn22, gridBagConstraints);

        zaritBtnGroup5.add(raoBtn24);
        raoBtn24.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(raoBtn24, gridBagConstraints);

        zaritBtnGroup3.add(raoBtn25);
        raoBtn25.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(raoBtn25, gridBagConstraints);

        zaritBtnGroup4.add(activitatsFBtn22);
        activitatsFBtn22.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(activitatsFBtn22, gridBagConstraints);

        zaritBtnGroup4.add(activitatsFBtn23);
        activitatsFBtn23.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(activitatsFBtn23, gridBagConstraints);

        zaritBtnGroup5.add(activitatsFBtn24);
        activitatsFBtn24.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(activitatsFBtn24, gridBagConstraints);

        zaritBtnGroup6.add(activitatsDBtn23);
        activitatsDBtn23.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(activitatsDBtn23, gridBagConstraints);

        zaritBtnGroup5.add(activitatsDBtn24);
        activitatsDBtn24.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(activitatsDBtn24, gridBagConstraints);

        zaritBtnGroup7.add(cuidatBtn17);
        cuidatBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(cuidatBtn17, gridBagConstraints);

        zaritBtnGroup7.add(cuidatBtn18);
        cuidatBtn18.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(cuidatBtn18, gridBagConstraints);

        jLabel118.setText("Mai");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        zaritQPanel.add(jLabel118, gridBagConstraints);

        jLabel119.setText("Rarament");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        zaritQPanel.add(jLabel119, gridBagConstraints);

        jLabel167.setText("<html><center>Algunes<br>vegades<br>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        zaritQPanel.add(jLabel167, gridBagConstraints);

        jLabel168.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        zaritQPanel.add(jLabel168, gridBagConstraints);

        jLabel169.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        zaritQPanel.add(jLabel169, gridBagConstraints);

        jLabel170.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        zaritQPanel.add(jLabel170, gridBagConstraints);

        jLabel171.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        zaritQPanel.add(jLabel171, gridBagConstraints);

        jLabel172.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        zaritQPanel.add(jLabel172, gridBagConstraints);

        jLabel173.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        zaritQPanel.add(jLabel173, gridBagConstraints);

        jLabel120.setText("Sent vergonya per la conducta del seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        zaritQPanel.add(jLabel120, gridBagConstraints);

        jLabel87.setText("Pensa que el seu familiar li demana més ajuda de la que realment necessita?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel87, gridBagConstraints);

        jLabel88.setText("Pensa que a causa del temps que dedica al seu familiar no té prou temps per a vostè?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        zaritQPanel.add(jLabel88, gridBagConstraints);

        jLabel89.setText("<Html> ¿Se sent aclaparat per intentar compatibilitzar la cura del seu familiar amb altres <br> responsabilitats (treball, família)?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel89, gridBagConstraints);

        jLabel90.setText("Se sent enfadat quan és a punt de familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel90, gridBagConstraints);

        jLabel91.setText("<html>Pensa que el tenir cura del seu familiar afecta negativament la relació que vostè té<br>amb altres membres de la seva família?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel91, gridBagConstraints);

        jLabel92.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        zaritQPanel.add(jLabel92, gridBagConstraints);

        jLabel93.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        zaritQPanel.add(jLabel93, gridBagConstraints);

        jLabel95.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel95, gridBagConstraints);

        jLabel96.setText("Pensa que el seu familiar li considera a vostè l'única persona que li pot tenir cura?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel96, gridBagConstraints);

        jLabel97.setText("<html>Pensa que no té prou ingressos econòmics per a les despeses de cuidar al seu familiar,<br>a més de les seves altres despeses?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel97, gridBagConstraints);

        jLabel98.setText(" Pensa que no serà capaç de tenir cura del seu familiar per molt més temps?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel98, gridBagConstraints);

        jLabel102.setText("<html>¿Sent que ha perdut el control de la seva vida des que va començar la malaltia del <br>seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel102, gridBagConstraints);

        jLabel104.setText("11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel104, gridBagConstraints);

        jLabel121.setText("<html> Pensa que la seva vida social s'ha vist afectada negativament per haver de cuidar<br>el seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel121, gridBagConstraints);

        jLabel122.setText("<html>Se sent incòmode per distanciar-se de les seves amistats a causa d'haver de tenir<br>cura del seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel122, gridBagConstraints);

        jLabel123.setText("12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel123, gridBagConstraints);

        jLabel124.setText("13");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel124, gridBagConstraints);

        zaritBtnGroup13.add(jToggleButton83);
        jToggleButton83.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton83, gridBagConstraints);

        zaritBtnGroup12.add(jToggleButton84);
        jToggleButton84.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton84, gridBagConstraints);

        zaritBtnGroup12.add(jToggleButton85);
        jToggleButton85.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton85, gridBagConstraints);

        zaritBtnGroup13.add(jToggleButton86);
        jToggleButton86.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton86, gridBagConstraints);

        zaritBtnGroup11.add(jToggleButton87);
        jToggleButton87.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton87, gridBagConstraints);

        zaritBtnGroup11.add(jToggleButton88);
        jToggleButton88.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton88, gridBagConstraints);

        zaritBtnGroup3.add(jToggleButton89);
        jToggleButton89.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton89, gridBagConstraints);

        zaritBtnGroup4.add(jToggleButton90);
        jToggleButton90.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton90, gridBagConstraints);

        zaritBtnGroup6.add(jToggleButton92);
        jToggleButton92.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton92, gridBagConstraints);

        zaritBtnGroup6.add(jToggleButton93);
        jToggleButton93.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton93, gridBagConstraints);

        zaritBtnGroup7.add(jToggleButton94);
        jToggleButton94.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton94, gridBagConstraints);

        zaritBtnGroup8.add(jToggleButton95);
        jToggleButton95.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton95, gridBagConstraints);

        zaritBtnGroup8.add(jToggleButton96);
        jToggleButton96.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton96, gridBagConstraints);

        zaritBtnGroup8.add(jToggleButton97);
        jToggleButton97.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton97, gridBagConstraints);

        zaritBtnGroup9.add(jToggleButton99);
        jToggleButton99.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton99, gridBagConstraints);

        zaritBtnGroup9.add(jToggleButton100);
        jToggleButton100.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton100, gridBagConstraints);

        zaritBtnGroup9.add(jToggleButton101);
        jToggleButton101.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton101, gridBagConstraints);

        zaritBtnGroup10.add(jToggleButton103);
        jToggleButton103.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton103, gridBagConstraints);

        zaritBtnGroup10.add(jToggleButton104);
        jToggleButton104.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton104, gridBagConstraints);

        zaritBtnGroup10.add(jToggleButton105);
        jToggleButton105.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton105, gridBagConstraints);

        zaritBtnGroup11.add(jToggleButton107);
        jToggleButton107.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton107, gridBagConstraints);

        zaritBtnGroup12.add(jToggleButton109);
        jToggleButton109.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton109, gridBagConstraints);

        zaritBtnGroup13.add(jToggleButton111);
        jToggleButton111.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton111, gridBagConstraints);

        jLabel117.setText("Té por pel futur del seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel117, gridBagConstraints);

        jLabel133.setText("Pensa que el seu familiar depèn de vostè?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel133, gridBagConstraints);

        jLabel136.setText("<Html> Pensa que no té tanta intimitat com li agradaria a causa de tenir qual tenir cura del <br>seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel136, gridBagConstraints);

        jLabel115.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        zaritQPanel.add(jLabel115, gridBagConstraints);

        jLabel134.setText("Se sent tens quan és a punt de familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel134, gridBagConstraints);

        jLabel135.setText("Pensa que la seva salut ha empitjorat a causa d'haver de tenir cura del seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel135, gridBagConstraints);

        zaritBtnGroup14.add(jToggleButton57);
        jToggleButton57.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton57, gridBagConstraints);

        zaritBtnGroup14.add(jToggleButton58);
        jToggleButton58.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton58, gridBagConstraints);

        zaritBtnGroup14.add(jToggleButton59);
        jToggleButton59.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton59, gridBagConstraints);

        jLabel137.setText("<html>Oblidar dir a algú alguna cosa important; per exemple, donar un avís o recordar<br>a algú alguna cosa.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel137, gridBagConstraints);

        zaritBtnGroup15.add(jToggleButton61);
        jToggleButton61.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton61, gridBagConstraints);

        zaritBtnGroup15.add(jToggleButton62);
        jToggleButton62.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton62, gridBagConstraints);

        zaritBtnGroup15.add(jToggleButton63);
        jToggleButton63.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton63, gridBagConstraints);

        jLabel138.setText("Pensa que hauria de fer més per la seva familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel138, gridBagConstraints);

        zaritBtnGroup16.add(jToggleButton65);
        jToggleButton65.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton65, gridBagConstraints);

        zaritBtnGroup16.add(jToggleButton66);
        jToggleButton66.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton66, gridBagConstraints);

        zaritBtnGroup16.add(jToggleButton67);
        jToggleButton67.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton67, gridBagConstraints);

        jLabel139.setText("Desitjaria poder deixar la cura del seu familiar a una altra persona?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel139, gridBagConstraints);

        jLabel157.setText("14");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel157, gridBagConstraints);

        jLabel158.setText("16");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel158, gridBagConstraints);

        jLabel159.setText("15");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel159, gridBagConstraints);

        jLabel160.setText("17");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel160, gridBagConstraints);

        jLabel161.setText("19");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel161, gridBagConstraints);

        jLabel162.setText("18");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel162, gridBagConstraints);

        jLabel163.setText("20");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel163, gridBagConstraints);

        jLabel164.setText("21");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel164, gridBagConstraints);

        jLabel174.setText("22");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        zaritQPanel.add(jLabel174, gridBagConstraints);

        jLabel181.setText("Pensa que podria cuidar millor al seu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel181, gridBagConstraints);

        jLabel182.setText("Globalment, quin grau de \"càrrega\" experimenta pel fet de tenir cura al teu familiar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        zaritQPanel.add(jLabel182, gridBagConstraints);

        zaritBtnGroup17.add(jToggleButton69);
        jToggleButton69.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton69, gridBagConstraints);

        zaritBtnGroup17.add(jToggleButton70);
        jToggleButton70.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton70, gridBagConstraints);

        zaritBtnGroup17.add(jToggleButton71);
        jToggleButton71.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton71, gridBagConstraints);

        zaritBtnGroup18.add(jToggleButton73);
        jToggleButton73.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton73, gridBagConstraints);

        zaritBtnGroup18.add(jToggleButton74);
        jToggleButton74.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton74, gridBagConstraints);

        zaritBtnGroup18.add(jToggleButton75);
        jToggleButton75.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton75, gridBagConstraints);

        zaritBtnGroup19.add(jToggleButton77);
        jToggleButton77.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton77, gridBagConstraints);

        zaritBtnGroup19.add(jToggleButton78);
        jToggleButton78.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton78, gridBagConstraints);

        zaritBtnGroup19.add(jToggleButton79);
        jToggleButton79.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton79, gridBagConstraints);

        zaritBtnGroup20.add(jToggleButton81);
        jToggleButton81.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton81, gridBagConstraints);

        zaritBtnGroup20.add(jToggleButton82);
        jToggleButton82.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton82, gridBagConstraints);

        zaritBtnGroup20.add(jToggleButton113);
        jToggleButton113.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton113, gridBagConstraints);

        zaritBtnGroup21.add(jToggleButton115);
        jToggleButton115.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton115, gridBagConstraints);

        zaritBtnGroup21.add(jToggleButton116);
        jToggleButton116.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton116, gridBagConstraints);

        zaritBtnGroup21.add(jToggleButton117);
        jToggleButton117.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton117, gridBagConstraints);

        zaritBtnGroup22.add(jToggleButton119);
        jToggleButton119.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton119, gridBagConstraints);

        zaritBtnGroup22.add(jToggleButton120);
        jToggleButton120.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton120, gridBagConstraints);

        zaritBtnGroup22.add(jToggleButton121);
        jToggleButton121.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton121, gridBagConstraints);

        zaritBtnGroup22.add(jToggleButton207);
        jToggleButton207.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton207, gridBagConstraints);

        zaritBtnGroup21.add(jToggleButton208);
        jToggleButton208.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton208, gridBagConstraints);

        zaritBtnGroup20.add(jToggleButton209);
        jToggleButton209.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton209, gridBagConstraints);

        zaritBtnGroup19.add(jToggleButton210);
        jToggleButton210.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton210, gridBagConstraints);

        zaritBtnGroup17.add(jToggleButton211);
        jToggleButton211.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton211, gridBagConstraints);

        zaritBtnGroup18.add(jToggleButton212);
        jToggleButton212.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton212, gridBagConstraints);

        zaritBtnGroup16.add(jToggleButton213);
        jToggleButton213.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton213, gridBagConstraints);

        zaritBtnGroup15.add(jToggleButton214);
        jToggleButton214.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton214, gridBagConstraints);

        zaritBtnGroup14.add(jToggleButton215);
        jToggleButton215.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton215, gridBagConstraints);

        zaritBtnGroup13.add(jToggleButton216);
        jToggleButton216.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton216, gridBagConstraints);

        zaritBtnGroup12.add(jToggleButton217);
        jToggleButton217.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton217, gridBagConstraints);

        zaritBtnGroup11.add(jToggleButton218);
        jToggleButton218.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton218, gridBagConstraints);

        zaritBtnGroup10.add(jToggleButton219);
        jToggleButton219.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton219, gridBagConstraints);

        zaritBtnGroup8.add(jToggleButton220);
        jToggleButton220.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton220, gridBagConstraints);

        zaritBtnGroup9.add(jToggleButton221);
        jToggleButton221.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton221, gridBagConstraints);

        zaritBtnGroup7.add(cuidatBtn22);
        cuidatBtn22.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(cuidatBtn22, gridBagConstraints);

        zaritBtnGroup6.add(jToggleButton222);
        jToggleButton222.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton222, gridBagConstraints);

        zaritBtnGroup5.add(raoBtn29);
        raoBtn29.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(raoBtn29, gridBagConstraints);

        zaritBtnGroup4.add(activitatsFBtn25);
        activitatsFBtn25.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(activitatsFBtn25, gridBagConstraints);

        zaritBtnGroup3.add(jToggleButton223);
        jToggleButton223.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton223, gridBagConstraints);

        zaritBtnGroup2.add(orientacioBtn26);
        orientacioBtn26.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(orientacioBtn26, gridBagConstraints);

        zaritBtnGroup1.add(memoBtn26);
        memoBtn26.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(memoBtn26, gridBagConstraints);

        zaritBtnGroup22.add(jToggleButton224);
        jToggleButton224.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton224, gridBagConstraints);

        zaritBtnGroup21.add(jToggleButton225);
        jToggleButton225.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton225, gridBagConstraints);

        zaritBtnGroup20.add(jToggleButton226);
        jToggleButton226.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton226, gridBagConstraints);

        zaritBtnGroup19.add(jToggleButton227);
        jToggleButton227.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton227, gridBagConstraints);

        zaritBtnGroup17.add(jToggleButton228);
        jToggleButton228.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton228, gridBagConstraints);

        zaritBtnGroup18.add(jToggleButton229);
        jToggleButton229.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton229, gridBagConstraints);

        zaritBtnGroup16.add(jToggleButton230);
        jToggleButton230.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton230, gridBagConstraints);

        zaritBtnGroup15.add(jToggleButton231);
        jToggleButton231.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton231, gridBagConstraints);

        zaritBtnGroup14.add(jToggleButton232);
        jToggleButton232.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton232, gridBagConstraints);

        zaritBtnGroup13.add(jToggleButton233);
        jToggleButton233.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton233, gridBagConstraints);

        zaritBtnGroup12.add(jToggleButton234);
        jToggleButton234.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton234, gridBagConstraints);

        zaritBtnGroup11.add(jToggleButton235);
        jToggleButton235.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton235, gridBagConstraints);

        zaritBtnGroup10.add(jToggleButton236);
        jToggleButton236.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton236, gridBagConstraints);

        zaritBtnGroup8.add(jToggleButton237);
        jToggleButton237.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton237, gridBagConstraints);

        zaritBtnGroup9.add(jToggleButton238);
        jToggleButton238.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton238, gridBagConstraints);

        zaritBtnGroup7.add(cuidatBtn23);
        cuidatBtn23.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(cuidatBtn23, gridBagConstraints);

        zaritBtnGroup6.add(jToggleButton239);
        jToggleButton239.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton239, gridBagConstraints);

        zaritBtnGroup5.add(raoBtn30);
        raoBtn30.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(raoBtn30, gridBagConstraints);

        zaritBtnGroup4.add(activitatsFBtn26);
        activitatsFBtn26.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(activitatsFBtn26, gridBagConstraints);

        zaritBtnGroup3.add(jToggleButton240);
        jToggleButton240.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(jToggleButton240, gridBagConstraints);

        zaritBtnGroup2.add(orientacioBtn27);
        orientacioBtn27.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(orientacioBtn27, gridBagConstraints);

        zaritBtnGroup1.add(memoBtn27);
        memoBtn27.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        zaritQPanel.add(memoBtn27, gridBagConstraints);

        jLabel9.setText("<html><center>Força<br>sovint");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        zaritQPanel.add(jLabel9, gridBagConstraints);

        jLabel10.setText("<html><center>Gairebé<br>sempre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        zaritQPanel.add(jLabel10, gridBagConstraints);

        jLabel16.setText("<Html> <u> Instruccions per a la persona cuidadora: </u> <br> A continuació es presenta una llista d'afirmacions, en les quals es reflecteix com es senten, de vegades, les persones que tenen cura a una altra persona. <Br > Després de llegir cada afirmació, ha d'indicar amb quina freqüència se sent vostè així: mai, rarament, algunes vegades, força sovint i gairebé sempre. <br> a l'hora de respondre pensi que no hi ha respostes encertades o equivocades, sinó tan només la seva experiència.");

        jLabel11.setText("<html>Població cuidadora de persones dependents. És un qüestionari<b> autoadministrat.");

        jLabel143.setText("Puntuació total:");

        zaritTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zaritTotal.setText("0");

        javax.swing.GroupLayout zaritPanel2Layout = new javax.swing.GroupLayout(zaritPanel2);
        zaritPanel2.setLayout(zaritPanel2Layout);
        zaritPanel2Layout.setHorizontalGroup(
            zaritPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zaritPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zaritPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(zaritPanel2Layout.createSequentialGroup()
                        .addComponent(zaritQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel143)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zaritTotal))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        zaritPanel2Layout.setVerticalGroup(
            zaritPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zaritPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(zaritPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zaritQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(zaritPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel143)
                        .addComponent(zaritTotal)))
                .addContainerGap())
        );

        zaritScroll1.setViewportView(zaritPanel2);

        zaritTab.add(zaritScroll1, "card1");

        tabbedPanel.addTab("ZARIT", zaritTab);

        sf12Tab.setLayout(new java.awt.CardLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Qüestionari SF-12 sobre l'Estat de Salut");

        jLabel14.setText("<html><b>INSTRUCCIONS:</b> Les preguntes que segueixen es refereixen al que vostè pensa sobre la seva salut. <br> Les seves respostes permetran saber com es troba vostè i fins a quin punt és capaç de fer les seves activitats habituals. <br> Si us plau, contesti cada pregunta marcant una casella. Si no està segur/a  de com respondre una pregunta, si us plau, contesti el que li sembli més cert.");

        jLabel15.setText("<html><b>1.</b> En general, vostè diria que la seva salut és:");

        jLabel34.setText("<html><b>Les següents preguntes es refereixen a activitats o coses que vostè podria fer en un dia normal.<br>La seva salut, el limita per fer aquestes activitats o coses? Si és així, quant?");

        jLabel35.setText("<html><b>2.</b> Esforços moderats, com moure una taula, passar<br>l'aspiradora, jugar a bitlles o caminar més d'una hora");

        jLabel12.setText("<html><center>Sí, em limita<br>molt");

        jLabel13.setText("<html><center>Sí, em limita<br>una mica");

        jLabel36.setText("<html><center>no, no em<br>limita gens");

        jLabel37.setText("<html><b>3.</b> Pujar diversos pisos per l'escala");

        jLabel38.setText("<html><b>Durant les 4 últimes setmanes, ha tingut algun dels següents problemes a la seva feina o en les seves activitats<br>quotidianes, a causa de la seva salut física?");

        jLabel39.setText("<html><b>4.</b> Va fer menys del que hauria volgut fer?");

        jLabel40.setText("Sí");

        jLabel41.setText("No");

        jLabel42.setText("<html><b>5.</b> Va haver de deixar de fer algunes tasques a la feina<br>o en les seves activitat quotidianes?");

        jLabel43.setText("<html><b>Durant les 4 últimes setmanes, ha tingut algun dels següents problemes a la seva feina o en les seves activitats<br>quotidianes a causa d'algun problema emocional (com estar trist, deprimit o nerviós)?");

        jLabel44.setText("<html><b>6.</b> Va fer menys del que hauria volgut fer per algun problema emocional?");

        jLabel45.setText("<html><b>7.</b> No va fer la seva feina o les seves activitats quotidianes tan cuidadosament<br>que de costum per algun problema emocional?");

        jLabel46.setText("<html><b>8.</b> Durant les 4 últimes setmanes, fina a quin punt el mal li ha dificultat<br>la seva feina (inclòs la feina fora de casa i tasques quotidianes)?");

        jLabel47.setText("Sí");

        jLabel48.setText("No");

        jLabel49.setText("Res");

        jLabel50.setText("Una mica");

        jLabel51.setText("Regular");

        jLabel52.setText("Bastant");

        jLabel78.setText("Molt");

        jLabel79.setText("<html><b>Les preguntes que segueixen es refereixen a com s'ha sentit i com li han anat les coses durant les últimes 4 setmanes.<br>En cada pregunta respongui el que se sembli més a com s'ha sentit vosté. Durant les últimes 4 setmanes, quant temps...");

        jLabel80.setText("<html><b>9.</b> ... es va sentir calmat i tranquil?");

        jLabel81.setText("<html><b>10.</b> ... va tenir molta energia?");

        jLabel82.setText("<html><b>11.</b> ... es va sentir desanimat i trist?");

        jLabel94.setText("<html><b>12.</b> Amb quina freqüència la salut física<br>o els problemes emocionals li han<br>dificultat les seves activitats socials<br>(com visitar els amics o familiars)?");

        jLabel103.setText("Sempre");

        jLabel105.setText("<html><center>Gairebé<br>sempre");

        jLabel108.setText("<html><center>Moltes<br>vegades");

        jLabel110.setText("<html><center>Algunes<br>vegades");

        jLabel116.setText("<html><center>Només<br>alguna vegada");

        jLabel125.setText("Mai");

        jLabel126.setText("<html><b>NOTA:</b> Transcriure en full de seguiment les 12 puntuacions corresponents a les respostes a cada ítem.");

        jLabel142.setText("Puntuació total:");

        jLabel146.setText("Excel·lent");

        jLabel147.setText("Molt bona");

        jLabel148.setText("Bona");

        jLabel175.setText("Regular");

        jLabel176.setText("Dolenta");

        sf12Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sf12Total.setText("0");

        sf12BtnGroup6.add(jRadioButton53);
        jRadioButton53.setText("1");

        sf12BtnGroup6.add(jRadioButton54);
        jRadioButton54.setText("2");

        sf12BtnGroup1.add(jRadioButton55);
        jRadioButton55.setText("1");

        sf12BtnGroup1.add(jRadioButton56);
        jRadioButton56.setText("2");

        sf12BtnGroup1.add(jRadioButton57);
        jRadioButton57.setText("3");

        sf12BtnGroup1.add(jRadioButton58);
        jRadioButton58.setText("4");

        sf12BtnGroup1.add(jRadioButton59);
        jRadioButton59.setText("5");

        sf12BtnGroup2.add(jRadioButton60);
        jRadioButton60.setText("1");

        sf12BtnGroup3.add(jRadioButton65);
        jRadioButton65.setText("1");

        sf12BtnGroup3.add(jRadioButton66);
        jRadioButton66.setText("2");

        sf12BtnGroup2.add(jRadioButton67);
        jRadioButton67.setText("2");

        sf12BtnGroup2.add(jRadioButton68);
        jRadioButton68.setText("3");

        sf12BtnGroup3.add(jRadioButton69);
        jRadioButton69.setText("3");

        sf12BtnGroup4.add(jRadioButton70);
        jRadioButton70.setText("1");

        sf12BtnGroup4.add(jRadioButton71);
        jRadioButton71.setText("2");

        sf12BtnGroup5.add(jRadioButton72);
        jRadioButton72.setText("1");

        sf12BtnGroup5.add(jRadioButton73);
        jRadioButton73.setText("2");

        sf12BtnGroup7.add(jRadioButton74);
        jRadioButton74.setText("1");

        sf12BtnGroup7.add(jRadioButton75);
        jRadioButton75.setText("2");

        sf12BtnGroup8.add(jRadioButton76);
        jRadioButton76.setText("1");

        sf12BtnGroup8.add(jRadioButton77);
        jRadioButton77.setText("2");

        sf12BtnGroup8.add(jRadioButton78);
        jRadioButton78.setText("3");

        sf12BtnGroup8.add(jRadioButton79);
        jRadioButton79.setText("4");

        sf12BtnGroup8.add(jRadioButton80);
        jRadioButton80.setText("5");

        sf12BtnGroup9.add(jRadioButton81);
        jRadioButton81.setText("1");

        sf12BtnGroup10.add(jRadioButton82);
        jRadioButton82.setText("1");

        sf12BtnGroup11.add(jRadioButton83);
        jRadioButton83.setText("1");

        sf12BtnGroup11.add(jRadioButton84);
        jRadioButton84.setText("2");

        sf12BtnGroup10.add(jRadioButton85);
        jRadioButton85.setText("2");

        sf12BtnGroup9.add(jRadioButton86);
        jRadioButton86.setText("2");

        sf12BtnGroup9.add(jRadioButton87);
        jRadioButton87.setText("3");

        sf12BtnGroup10.add(jRadioButton88);
        jRadioButton88.setText("3");

        sf12BtnGroup11.add(jRadioButton89);
        jRadioButton89.setText("3");

        sf12BtnGroup9.add(jRadioButton90);
        jRadioButton90.setText("4");

        sf12BtnGroup10.add(jRadioButton91);
        jRadioButton91.setText("4");

        sf12BtnGroup11.add(jRadioButton92);
        jRadioButton92.setText("4");

        sf12BtnGroup9.add(jRadioButton93);
        jRadioButton93.setText("5");

        sf12BtnGroup10.add(jRadioButton94);
        jRadioButton94.setText("5");

        sf12BtnGroup11.add(jRadioButton95);
        jRadioButton95.setText("5");

        sf12BtnGroup9.add(jRadioButton96);
        jRadioButton96.setText("6");

        sf12BtnGroup10.add(jRadioButton97);
        jRadioButton97.setText("6");

        sf12BtnGroup11.add(jRadioButton98);
        jRadioButton98.setText("6");

        sf12BtnGroup12.add(jRadioButton99);
        jRadioButton99.setText("1");

        sf12BtnGroup12.add(jRadioButton100);
        jRadioButton100.setText("2");

        sf12BtnGroup12.add(jRadioButton101);
        jRadioButton101.setText("3");

        sf12BtnGroup12.add(jRadioButton102);
        jRadioButton102.setText("4");

        sf12BtnGroup12.add(jRadioButton103);
        jRadioButton103.setText("5");

        sf12BtnGroup12.add(jRadioButton104);
        jRadioButton104.setText("6");

        javax.swing.GroupLayout sf12PanelLayout = new javax.swing.GroupLayout(sf12Panel);
        sf12Panel.setLayout(sf12PanelLayout);
        sf12PanelLayout.setHorizontalGroup(
            sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf12PanelLayout.createSequentialGroup()
                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sf12PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jRadioButton65)
                                                    .addComponent(jRadioButton60))))
                                        .addGap(18, 18, 18)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jRadioButton67)
                                                    .addComponent(jRadioButton66))))
                                        .addGap(18, 18, 18)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jRadioButton69)
                                                    .addComponent(jRadioButton68)))))
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(sf12PanelLayout.createSequentialGroup()
                                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sf12PanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel40)
                                                    .addGap(14, 14, 14))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sf12PanelLayout.createSequentialGroup()
                                                    .addComponent(jRadioButton70)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jRadioButton71)
                                                .addGroup(sf12PanelLayout.createSequentialGroup()
                                                    .addGap(8, 8, 8)
                                                    .addComponent(jLabel41))))
                                        .addGroup(sf12PanelLayout.createSequentialGroup()
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jRadioButton72)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRadioButton73)))
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel142)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sf12Total))
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jRadioButton99)
                                                        .addGap(26, 26, 26)
                                                        .addComponent(jRadioButton100)))
                                                .addGap(24, 24, 24)
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jRadioButton87)
                                                    .addComponent(jRadioButton88)
                                                    .addComponent(jRadioButton89)
                                                    .addComponent(jRadioButton101))
                                                .addGap(28, 28, 28)
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                                        .addComponent(jRadioButton102)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jRadioButton103))
                                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jRadioButton90)
                                                            .addComponent(jRadioButton91)
                                                            .addComponent(jRadioButton92))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jRadioButton93)
                                                            .addComponent(jRadioButton94)
                                                            .addComponent(jRadioButton95))))))
                                        .addGap(35, 35, 35)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton96)
                                            .addComponent(jRadioButton97)
                                            .addComponent(jRadioButton98)
                                            .addComponent(jRadioButton104)))
                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel146)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jRadioButton55)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel147)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jRadioButton56)))
                                        .addGap(18, 18, 18)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel148)
                                            .addComponent(jRadioButton57))
                                        .addGap(18, 18, 18)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton58)
                                            .addComponent(jLabel175))
                                        .addGap(25, 25, 25)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel176)
                                            .addComponent(jRadioButton59)))
                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel49)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel50)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel51))
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(48, 48, 48))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sf12PanelLayout.createSequentialGroup()
                                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jRadioButton76)
                                                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)))
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                                        .addComponent(jRadioButton74)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jRadioButton75))
                                                    .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sf12PanelLayout.createSequentialGroup()
                                                            .addGap(9, 9, 9)
                                                            .addComponent(jLabel47)
                                                            .addGap(26, 26, 26)
                                                            .addComponent(jLabel48))
                                                        .addGroup(sf12PanelLayout.createSequentialGroup()
                                                            .addComponent(jRadioButton53)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jRadioButton54)
                                                            .addGap(16, 16, 16)))
                                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(jRadioButton77)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jRadioButton78)))))
                                        .addGap(18, 18, 18)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel52)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel78))
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addComponent(jRadioButton79)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton80))))))))
                    .addGroup(sf12PanelLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103)
                            .addComponent(jRadioButton81)
                            .addComponent(jRadioButton82)
                            .addComponent(jRadioButton83))
                        .addGap(18, 18, 18)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton86)
                            .addComponent(jRadioButton85)
                            .addComponent(jRadioButton84))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel125)))
                .addContainerGap())
        );
        sf12PanelLayout.setVerticalGroup(
            sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf12PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(jLabel147)
                    .addComponent(jLabel148)
                    .addComponent(jLabel175)
                    .addComponent(jLabel176))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sf12PanelLayout.createSequentialGroup()
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton55)
                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton56)
                                .addComponent(jRadioButton57)
                                .addComponent(jRadioButton58)
                                .addComponent(jRadioButton59)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton60)
                                        .addComponent(jRadioButton67)
                                        .addComponent(jRadioButton68))))
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButton65)
                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton66)
                                .addComponent(jRadioButton69)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton70)
                            .addComponent(jRadioButton71))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton72)
                            .addComponent(jRadioButton73))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton53)
                                    .addComponent(jRadioButton54))
                                .addGap(18, 18, 18)
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton74)
                                    .addComponent(jRadioButton75))
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel50)
                                                    .addComponent(jLabel51))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jRadioButton76)
                                                    .addComponent(jRadioButton77)))
                                            .addComponent(jLabel49)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sf12PanelLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton78))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sf12PanelLayout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton79)
                                    .addComponent(jRadioButton80))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel125))
                            .addComponent(jLabel103))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(sf12PanelLayout.createSequentialGroup()
                                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jRadioButton81))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jRadioButton82))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jRadioButton83)))
                                        .addGroup(sf12PanelLayout.createSequentialGroup()
                                            .addComponent(jRadioButton86)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRadioButton85)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRadioButton84)))
                                    .addGroup(sf12PanelLayout.createSequentialGroup()
                                        .addComponent(jRadioButton90)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton91)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton92))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sf12PanelLayout.createSequentialGroup()
                                        .addComponent(jRadioButton93)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton94)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton95))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sf12PanelLayout.createSequentialGroup()
                                        .addComponent(jRadioButton96)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton97)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton98)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton99)
                                        .addComponent(jRadioButton100)
                                        .addComponent(jRadioButton101)
                                        .addComponent(jRadioButton102)
                                        .addComponent(jRadioButton103)
                                        .addComponent(jRadioButton104)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sf12PanelLayout.createSequentialGroup()
                                .addComponent(jRadioButton87)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton88)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton89))))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(sf12PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(sf12Total))
                .addContainerGap())
        );

        sf12Scroll.setViewportView(sf12Panel);

        sf12Tab.add(sf12Scroll, "card1");

        tabbedPanel.addTab("SF-12", sf12Tab);

        dukeTab.setLayout(new java.awt.CardLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Duke Suport Social Index");

        jLabel31.setText("<html><b><u>Població diana:</u></b> Població general. Es tracta d'un qüestionari <b>autoadministrat");

        jLabel32.setText("<html><b><u>Instruccions per al pacient:</u></b><br>En la següent llista es mostren algunes coses que altres persones fan per nosaltres o ens proporcionen.<br>Esculli per cada una la resposta que millor reflexi la seva situació, segons els següents criteris:");

        dukeQPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qüestionari Duke-UNC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        dukeQPanel.setLayout(new java.awt.GridBagLayout());

        dukeBtnGroup2.add(orientacioBtn14);
        orientacioBtn14.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn14, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn14);
        memoBtn14.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn14, gridBagConstraints);

        dukeBtnGroup2.add(orientacioBtn15);
        orientacioBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn15, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn15);
        memoBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn15, gridBagConstraints);

        dukeBtnGroup2.add(orientacioBtn16);
        orientacioBtn16.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn16, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn16);
        memoBtn16.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn16, gridBagConstraints);

        dukeBtnGroup1.add(memoBtn17);
        memoBtn17.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(memoBtn17, gridBagConstraints);

        dukeBtnGroup2.add(orientacioBtn17);
        orientacioBtn17.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(orientacioBtn17, gridBagConstraints);

        dukeBtnGroup3.add(raoBtn14);
        raoBtn14.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn14, gridBagConstraints);

        dukeBtnGroup3.add(raoBtn15);
        raoBtn15.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn15, gridBagConstraints);

        dukeBtnGroup5.add(raoBtn16);
        raoBtn16.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn16, gridBagConstraints);

        dukeBtnGroup3.add(raoBtn17);
        raoBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(raoBtn17, gridBagConstraints);

        dukeBtnGroup4.add(activitatsFBtn14);
        activitatsFBtn14.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn14, gridBagConstraints);

        dukeBtnGroup4.add(activitatsFBtn15);
        activitatsFBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn15, gridBagConstraints);

        dukeBtnGroup5.add(activitatsFBtn16);
        activitatsFBtn16.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn16, gridBagConstraints);

        dukeBtnGroup5.add(activitatsFBtn17);
        activitatsFBtn17.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsFBtn17, gridBagConstraints);

        dukeBtnGroup6.add(activitatsDBtn14);
        activitatsDBtn14.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsDBtn14, gridBagConstraints);

        dukeBtnGroup6.add(activitatsDBtn15);
        activitatsDBtn15.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(activitatsDBtn15, gridBagConstraints);

        dukeBtnGroup5.add(activitatsDBtn16);
        activitatsDBtn16.setText("1");
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

        dukeBtnGroup7.add(cuidatBtn11);
        cuidatBtn11.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(cuidatBtn11, gridBagConstraints);

        dukeBtnGroup7.add(cuidatBtn12);
        cuidatBtn12.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(cuidatBtn12, gridBagConstraints);

        dukeBtnGroup7.add(cuidatBtn13);
        cuidatBtn13.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(cuidatBtn13, gridBagConstraints);

        jLabel112.setText("<html><center>Molt menys<br>del que desitjo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        dukeQPanel.add(jLabel112, gridBagConstraints);

        jLabel113.setText("<html><center>Menys del<br>que desitjo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        dukeQPanel.add(jLabel113, gridBagConstraints);

        jLabel149.setText("<html><center>Tant com<br>desitjo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        dukeQPanel.add(jLabel149, gridBagConstraints);

        jLabel150.setText("<html><center>Ni molt<br>ni poc");
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

        jLabel156.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        dukeQPanel.add(jLabel156, gridBagConstraints);

        jLabel114.setText("Compto amb persones que es preocupen del que em passa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        dukeQPanel.add(jLabel114, gridBagConstraints);

        jLabel53.setText("Rebo visites dels meus amics i familiars");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel53, gridBagConstraints);

        jLabel54.setText("Rebo ajuda en assumptes relacionats amb casa meva");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        dukeQPanel.add(jLabel54, gridBagConstraints);

        jLabel55.setText("Rebo elogis i reconeixements quan faig bé la meva feina");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel55, gridBagConstraints);

        jLabel56.setText("Rebo amor i afecte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel56, gridBagConstraints);

        jLabel57.setText("Tinc la possibilitat de parlar amb algú dels meus problemes a la feina o a casa");
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

        jLabel59.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        dukeQPanel.add(jLabel59, gridBagConstraints);

        jLabel60.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        dukeQPanel.add(jLabel60, gridBagConstraints);

        jLabel61.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        dukeQPanel.add(jLabel61, gridBagConstraints);

        jLabel62.setText("Tinc la possibilitat de parlar amb algú dels meus problemes personals i familiars");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel62, gridBagConstraints);

        jLabel63.setText("Tinc la possibilitat de parlar amb algú dels meus problemes econòmics");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel63, gridBagConstraints);

        jLabel64.setText("Rebo invitacions per distreure'm i sortir amb altres persones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel64, gridBagConstraints);

        jLabel65.setText("Rebo consells útils quan em passa algun aconteixement important a la meva vida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel65, gridBagConstraints);

        jLabel66.setText("Rebo ajuda quan estic malalt al llit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dukeQPanel.add(jLabel66, gridBagConstraints);

        jLabel67.setText("11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        dukeQPanel.add(jLabel67, gridBagConstraints);

        dukeBtnGroup11.add(jToggleButton35);
        jToggleButton35.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton35, gridBagConstraints);

        dukeBtnGroup11.add(jToggleButton36);
        jToggleButton36.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton36, gridBagConstraints);

        dukeBtnGroup3.add(jToggleButton37);
        jToggleButton37.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton37, gridBagConstraints);

        dukeBtnGroup4.add(jToggleButton38);
        jToggleButton38.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton38, gridBagConstraints);

        dukeBtnGroup4.add(jToggleButton39);
        jToggleButton39.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton39, gridBagConstraints);

        dukeBtnGroup6.add(jToggleButton40);
        jToggleButton40.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton40, gridBagConstraints);

        dukeBtnGroup6.add(jToggleButton41);
        jToggleButton41.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton41, gridBagConstraints);

        dukeBtnGroup7.add(jToggleButton42);
        jToggleButton42.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton42, gridBagConstraints);

        dukeBtnGroup8.add(jToggleButton43);
        jToggleButton43.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton43, gridBagConstraints);

        dukeBtnGroup8.add(jToggleButton44);
        jToggleButton44.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton44, gridBagConstraints);

        dukeBtnGroup8.add(jToggleButton45);
        jToggleButton45.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        dukeQPanel.add(jToggleButton45, gridBagConstraints);

        dukeBtnGroup8.add(jToggleButton46);
        jToggleButton46.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton46, gridBagConstraints);

        dukeBtnGroup9.add(jToggleButton47);
        jToggleButton47.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton47, gridBagConstraints);

        dukeBtnGroup9.add(jToggleButton48);
        jToggleButton48.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton48, gridBagConstraints);

        dukeBtnGroup9.add(jToggleButton49);
        jToggleButton49.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        dukeQPanel.add(jToggleButton49, gridBagConstraints);

        dukeBtnGroup9.add(jToggleButton50);
        jToggleButton50.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton50, gridBagConstraints);

        dukeBtnGroup10.add(jToggleButton51);
        jToggleButton51.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton51, gridBagConstraints);

        dukeBtnGroup10.add(jToggleButton52);
        jToggleButton52.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton52, gridBagConstraints);

        dukeBtnGroup10.add(jToggleButton53);
        jToggleButton53.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        dukeQPanel.add(jToggleButton53, gridBagConstraints);

        dukeBtnGroup10.add(jToggleButton54);
        jToggleButton54.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton54, gridBagConstraints);

        dukeBtnGroup11.add(jToggleButton55);
        jToggleButton55.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        dukeQPanel.add(jToggleButton55, gridBagConstraints);

        dukeBtnGroup11.add(jToggleButton56);
        jToggleButton56.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        dukeQPanel.add(jToggleButton56, gridBagConstraints);

        jLabel141.setText("Puntuació total:");

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
                        .addGroup(dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dukePanelLayout.createSequentialGroup()
                                .addComponent(jLabel141)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dukeTotal))
                            .addGroup(dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dukeQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        dukePanelLayout.setVerticalGroup(
            dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dukePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dukeQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dukePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(dukeTotal))
                .addGap(270, 270, 270))
        );

        dukeScroll.setViewportView(dukePanel);

        dukeTab.add(dukeScroll, "card1");

        tabbedPanel.addTab(" DUKE-UNC ", dukeTab);

        faqTab.setLayout(new java.awt.BorderLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Qüestionari d'ACTIVITAT FUNCIONAL de Pfeffer");

        faqQPanel.setBorder(new javax.swing.border.MatteBorder(null));
        faqQPanel.setLayout(new java.awt.GridBagLayout());

        faqBtnGroup2.add(orientacioBtn18);
        orientacioBtn18.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(orientacioBtn18, gridBagConstraints);

        faqBtnGroup1.add(memoBtn18);
        memoBtn18.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(memoBtn18, gridBagConstraints);

        faqBtnGroup2.add(orientacioBtn19);
        orientacioBtn19.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(orientacioBtn19, gridBagConstraints);

        faqBtnGroup1.add(memoBtn19);
        memoBtn19.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(memoBtn19, gridBagConstraints);

        faqBtnGroup2.add(orientacioBtn21);
        orientacioBtn21.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(orientacioBtn21, gridBagConstraints);

        faqBtnGroup1.add(memoBtn21);
        memoBtn21.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(memoBtn21, gridBagConstraints);

        faqBtnGroup1.add(memoBtn25);
        memoBtn25.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(memoBtn25, gridBagConstraints);

        faqBtnGroup2.add(orientacioBtn25);
        orientacioBtn25.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(orientacioBtn25, gridBagConstraints);

        faqBtnGroup3.add(raoBtn18);
        raoBtn18.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(raoBtn18, gridBagConstraints);

        faqBtnGroup3.add(raoBtn20);
        raoBtn20.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(raoBtn20, gridBagConstraints);

        faqBtnGroup5.add(raoBtn23);
        raoBtn23.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(raoBtn23, gridBagConstraints);

        faqBtnGroup3.add(raoBtn26);
        raoBtn26.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(raoBtn26, gridBagConstraints);

        faqBtnGroup4.add(activitatsFBtn18);
        activitatsFBtn18.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsFBtn18, gridBagConstraints);

        faqBtnGroup4.add(activitatsFBtn19);
        activitatsFBtn19.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsFBtn19, gridBagConstraints);

        faqBtnGroup5.add(activitatsFBtn20);
        activitatsFBtn20.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsFBtn20, gridBagConstraints);

        faqBtnGroup5.add(activitatsFBtn21);
        activitatsFBtn21.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsFBtn21, gridBagConstraints);

        faqBtnGroup6.add(activitatsDBtn18);
        activitatsDBtn18.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsDBtn18, gridBagConstraints);

        faqBtnGroup6.add(activitatsDBtn19);
        activitatsDBtn19.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsDBtn19, gridBagConstraints);

        faqBtnGroup5.add(activitatsDBtn20);
        activitatsDBtn20.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsDBtn20, gridBagConstraints);

        activitatsDBtn21.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(activitatsDBtn21, gridBagConstraints);

        faqBtnGroup7.add(cuidatBtn14);
        cuidatBtn14.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(cuidatBtn14, gridBagConstraints);

        faqBtnGroup7.add(cuidatBtn16);
        cuidatBtn16.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(cuidatBtn16, gridBagConstraints);

        faqBtnGroup7.add(cuidatBtn19);
        cuidatBtn19.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(cuidatBtn19, gridBagConstraints);

        jLabel233.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        faqQPanel.add(jLabel233, gridBagConstraints);

        jLabel234.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        faqQPanel.add(jLabel234, gridBagConstraints);

        jLabel235.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        faqQPanel.add(jLabel235, gridBagConstraints);

        jLabel236.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        faqQPanel.add(jLabel236, gridBagConstraints);

        jLabel237.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        faqQPanel.add(jLabel237, gridBagConstraints);

        jLabel238.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        faqQPanel.add(jLabel238, gridBagConstraints);

        jLabel127.setText("Pot fer-se sol / a el menjar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        faqQPanel.add(jLabel127, gridBagConstraints);

        jLabel70.setText("Gestiona els seus propis diners?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel70, gridBagConstraints);

        jLabel99.setText("Pot fer sol / a la compra (aliments, roba, coses de la casa)?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        faqQPanel.add(jLabel99, gridBagConstraints);

        jLabel100.setText("Pot preparar-se sol / a el cafè o el te i després apagar el foc?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel100, gridBagConstraints);

        jLabel101.setText("Està al corrent de les notícies del seu veïnat, de la seva comunitat?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel101, gridBagConstraints);

        jLabel128.setText("Pot prestar atenció, entendre i discutir les notícies de la ràdio i els programes de TV, llibres, revistes?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel128, gridBagConstraints);

        jLabel129.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        faqQPanel.add(jLabel129, gridBagConstraints);

        jLabel130.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        faqQPanel.add(jLabel130, gridBagConstraints);

        jLabel131.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        faqQPanel.add(jLabel131, gridBagConstraints);

        jLabel132.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        faqQPanel.add(jLabel132, gridBagConstraints);

        jLabel239.setText("Recorda si queda amb algú, les festes familiars (aniversaris, aniversaris), els dies festius?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel239, gridBagConstraints);

        jLabel240.setText("És capaç de gestionar la seva pròpia medicació?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel240, gridBagConstraints);

        jLabel241.setText("És capaç de viatjar sol / a fora del seu barri i tornar a casa?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel241, gridBagConstraints);

        jLabel242.setText("¿Saludar apropiadament a les seves amistats?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel242, gridBagConstraints);

        jLabel243.setText("Pot sortir ala carrer sol / a sense perill?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        faqQPanel.add(jLabel243, gridBagConstraints);

        jLabel244.setText("11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        faqQPanel.add(jLabel244, gridBagConstraints);

        faqBtnGroup11.add(jToggleButton60);
        jToggleButton60.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton60, gridBagConstraints);

        faqBtnGroup11.add(jToggleButton64);
        jToggleButton64.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton64, gridBagConstraints);

        faqBtnGroup3.add(jToggleButton68);
        jToggleButton68.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton68, gridBagConstraints);

        faqBtnGroup4.add(jToggleButton72);
        jToggleButton72.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton72, gridBagConstraints);

        faqBtnGroup4.add(jToggleButton76);
        jToggleButton76.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton76, gridBagConstraints);

        faqBtnGroup6.add(jToggleButton80);
        jToggleButton80.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton80, gridBagConstraints);

        faqBtnGroup6.add(jToggleButton91);
        jToggleButton91.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton91, gridBagConstraints);

        faqBtnGroup7.add(jToggleButton98);
        jToggleButton98.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton98, gridBagConstraints);

        faqBtnGroup8.add(jToggleButton102);
        jToggleButton102.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton102, gridBagConstraints);

        faqBtnGroup8.add(jToggleButton106);
        jToggleButton106.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton106, gridBagConstraints);

        faqBtnGroup8.add(jToggleButton108);
        jToggleButton108.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        faqQPanel.add(jToggleButton108, gridBagConstraints);

        faqBtnGroup8.add(jToggleButton110);
        jToggleButton110.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton110, gridBagConstraints);

        faqBtnGroup9.add(jToggleButton112);
        jToggleButton112.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton112, gridBagConstraints);

        faqBtnGroup9.add(jToggleButton114);
        jToggleButton114.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton114, gridBagConstraints);

        faqBtnGroup9.add(jToggleButton126);
        jToggleButton126.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        faqQPanel.add(jToggleButton126, gridBagConstraints);

        faqBtnGroup9.add(jToggleButton130);
        jToggleButton130.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton130, gridBagConstraints);

        faqBtnGroup10.add(jToggleButton148);
        jToggleButton148.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton148, gridBagConstraints);

        faqBtnGroup10.add(jToggleButton149);
        jToggleButton149.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton149, gridBagConstraints);

        faqBtnGroup10.add(jToggleButton154);
        jToggleButton154.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        faqQPanel.add(jToggleButton154, gridBagConstraints);

        faqBtnGroup10.add(jToggleButton155);
        jToggleButton155.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton155, gridBagConstraints);

        faqBtnGroup11.add(jToggleButton156);
        jToggleButton156.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        faqQPanel.add(jToggleButton156, gridBagConstraints);

        faqBtnGroup11.add(jToggleButton157);
        jToggleButton157.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        faqQPanel.add(jToggleButton157, gridBagConstraints);

        jLabel1.setText("Puntuar cada ítem de la manera següent:");

        jLabel2.setText("<Html> 0 -> Normal; o mai ho va fer però podria fer-ho sol / a <br> 1 -> Amb dificultat però es maneja només; o mai ho va fer i si hagués de fer-ho ara <br><t> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tindria dificultat <br> 2 -> Necessita ajuda (però ho fa) <br> 3 -> Dependent (no pot realitzar-ho) <br>");

        jLabel3.setText("<Html> Una puntuació per sota de 6 indica normalitat (no dependència) <br> Una puntuació de 6 o més indica alteració funcional");

        jLabel140.setText("Puntuació total:");

        faqTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        faqTotal.setText("0");

        javax.swing.GroupLayout faqPanelLayout = new javax.swing.GroupLayout(faqPanel);
        faqPanel.setLayout(faqPanelLayout);
        faqPanelLayout.setHorizontalGroup(
            faqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faqPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jLabel140)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faqTotal)
                .addGap(739, 739, 739))
            .addGroup(faqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(faqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(faqPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29)
                    .addComponent(faqQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        faqPanelLayout.setVerticalGroup(
            faqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, faqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(faqQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(faqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(faqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel140)
                        .addComponent(faqTotal)))
                .addContainerGap())
        );

        faqScroll.setViewportView(faqPanel);

        faqTab.add(faqScroll, java.awt.BorderLayout.CENTER);

        tabbedPanel.addTab("FAQ", faqTab);

        mainPanel.add(tabbedPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptaBtnActionPerformed
        Utils.guardar(tabbedPanel,pacientActual.getId(), "ValCuid");
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
            java.util.logging.Logger.getLogger(ValoracioCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValoracioCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValoracioCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValoracioCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValoracioCuidador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptaBtn;
    private javax.swing.JToggleButton activitatsDBtn14;
    private javax.swing.JToggleButton activitatsDBtn15;
    private javax.swing.JToggleButton activitatsDBtn16;
    private javax.swing.JToggleButton activitatsDBtn17;
    private javax.swing.JToggleButton activitatsDBtn18;
    private javax.swing.JToggleButton activitatsDBtn19;
    private javax.swing.JToggleButton activitatsDBtn20;
    private javax.swing.JToggleButton activitatsDBtn21;
    private javax.swing.JToggleButton activitatsDBtn22;
    private javax.swing.JToggleButton activitatsDBtn23;
    private javax.swing.JToggleButton activitatsDBtn24;
    private javax.swing.JToggleButton activitatsDBtn25;
    private javax.swing.JToggleButton activitatsDBtn26;
    private javax.swing.JToggleButton activitatsDBtn27;
    private javax.swing.JToggleButton activitatsDBtn28;
    private javax.swing.JToggleButton activitatsDBtn29;
    private javax.swing.JToggleButton activitatsDBtn30;
    private javax.swing.JToggleButton activitatsDBtn31;
    private javax.swing.JToggleButton activitatsDBtn32;
    private javax.swing.JToggleButton activitatsDBtn33;
    private javax.swing.JToggleButton activitatsDBtn34;
    private javax.swing.JToggleButton activitatsFBtn14;
    private javax.swing.JToggleButton activitatsFBtn15;
    private javax.swing.JToggleButton activitatsFBtn16;
    private javax.swing.JToggleButton activitatsFBtn17;
    private javax.swing.JToggleButton activitatsFBtn18;
    private javax.swing.JToggleButton activitatsFBtn19;
    private javax.swing.JToggleButton activitatsFBtn20;
    private javax.swing.JToggleButton activitatsFBtn21;
    private javax.swing.JToggleButton activitatsFBtn22;
    private javax.swing.JToggleButton activitatsFBtn23;
    private javax.swing.JToggleButton activitatsFBtn24;
    private javax.swing.JToggleButton activitatsFBtn25;
    private javax.swing.JToggleButton activitatsFBtn26;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelaBtn;
    private javax.swing.JToggleButton cuidatBtn11;
    private javax.swing.JToggleButton cuidatBtn12;
    private javax.swing.JToggleButton cuidatBtn13;
    private javax.swing.JToggleButton cuidatBtn14;
    private javax.swing.JToggleButton cuidatBtn15;
    private javax.swing.JToggleButton cuidatBtn16;
    private javax.swing.JToggleButton cuidatBtn17;
    private javax.swing.JToggleButton cuidatBtn18;
    private javax.swing.JToggleButton cuidatBtn19;
    private javax.swing.JToggleButton cuidatBtn20;
    private javax.swing.JToggleButton cuidatBtn21;
    private javax.swing.JToggleButton cuidatBtn22;
    private javax.swing.JToggleButton cuidatBtn23;
    private javax.swing.JPanel dataPanel;
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
    private javax.swing.JPanel dukeTab;
    private javax.swing.JLabel dukeTotal;
    private javax.swing.ButtonGroup faqBtnGroup1;
    private javax.swing.ButtonGroup faqBtnGroup10;
    private javax.swing.ButtonGroup faqBtnGroup11;
    private javax.swing.ButtonGroup faqBtnGroup2;
    private javax.swing.ButtonGroup faqBtnGroup3;
    private javax.swing.ButtonGroup faqBtnGroup4;
    private javax.swing.ButtonGroup faqBtnGroup5;
    private javax.swing.ButtonGroup faqBtnGroup6;
    private javax.swing.ButtonGroup faqBtnGroup7;
    private javax.swing.ButtonGroup faqBtnGroup8;
    private javax.swing.ButtonGroup faqBtnGroup9;
    private javax.swing.JPanel faqPanel;
    private javax.swing.JPanel faqQPanel;
    private javax.swing.JScrollPane faqScroll;
    private javax.swing.JPanel faqTab;
    private javax.swing.JLabel faqTotal;
    private javax.swing.ButtonGroup hadButtonGroup1;
    private javax.swing.ButtonGroup hadButtonGroup10;
    private javax.swing.ButtonGroup hadButtonGroup11;
    private javax.swing.ButtonGroup hadButtonGroup12;
    private javax.swing.ButtonGroup hadButtonGroup13;
    private javax.swing.ButtonGroup hadButtonGroup14;
    private javax.swing.ButtonGroup hadButtonGroup2;
    private javax.swing.ButtonGroup hadButtonGroup3;
    private javax.swing.ButtonGroup hadButtonGroup4;
    private javax.swing.ButtonGroup hadButtonGroup5;
    private javax.swing.ButtonGroup hadButtonGroup6;
    private javax.swing.ButtonGroup hadButtonGroup7;
    private javax.swing.ButtonGroup hadButtonGroup8;
    private javax.swing.ButtonGroup hadButtonGroup9;
    private javax.swing.JLabel hadInterpretacioA;
    private javax.swing.JLabel hadInterpretacioD;
    private javax.swing.JPanel hadPanel;
    private javax.swing.JScrollPane hadScroll;
    private javax.swing.JPanel hadTab;
    private javax.swing.JLabel hadTotalA;
    private javax.swing.JLabel hadTotalD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton100;
    private javax.swing.JRadioButton jRadioButton101;
    private javax.swing.JRadioButton jRadioButton102;
    private javax.swing.JRadioButton jRadioButton103;
    private javax.swing.JRadioButton jRadioButton104;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton41;
    private javax.swing.JRadioButton jRadioButton42;
    private javax.swing.JRadioButton jRadioButton43;
    private javax.swing.JRadioButton jRadioButton44;
    private javax.swing.JRadioButton jRadioButton45;
    private javax.swing.JRadioButton jRadioButton46;
    private javax.swing.JRadioButton jRadioButton47;
    private javax.swing.JRadioButton jRadioButton48;
    private javax.swing.JRadioButton jRadioButton49;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton50;
    private javax.swing.JRadioButton jRadioButton51;
    private javax.swing.JRadioButton jRadioButton52;
    private javax.swing.JRadioButton jRadioButton53;
    private javax.swing.JRadioButton jRadioButton54;
    private javax.swing.JRadioButton jRadioButton55;
    private javax.swing.JRadioButton jRadioButton56;
    private javax.swing.JRadioButton jRadioButton57;
    private javax.swing.JRadioButton jRadioButton58;
    private javax.swing.JRadioButton jRadioButton59;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton60;
    private javax.swing.JRadioButton jRadioButton61;
    private javax.swing.JRadioButton jRadioButton62;
    private javax.swing.JRadioButton jRadioButton63;
    private javax.swing.JRadioButton jRadioButton64;
    private javax.swing.JRadioButton jRadioButton65;
    private javax.swing.JRadioButton jRadioButton66;
    private javax.swing.JRadioButton jRadioButton67;
    private javax.swing.JRadioButton jRadioButton68;
    private javax.swing.JRadioButton jRadioButton69;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton70;
    private javax.swing.JRadioButton jRadioButton71;
    private javax.swing.JRadioButton jRadioButton72;
    private javax.swing.JRadioButton jRadioButton73;
    private javax.swing.JRadioButton jRadioButton74;
    private javax.swing.JRadioButton jRadioButton75;
    private javax.swing.JRadioButton jRadioButton76;
    private javax.swing.JRadioButton jRadioButton77;
    private javax.swing.JRadioButton jRadioButton78;
    private javax.swing.JRadioButton jRadioButton79;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton80;
    private javax.swing.JRadioButton jRadioButton81;
    private javax.swing.JRadioButton jRadioButton82;
    private javax.swing.JRadioButton jRadioButton83;
    private javax.swing.JRadioButton jRadioButton84;
    private javax.swing.JRadioButton jRadioButton85;
    private javax.swing.JRadioButton jRadioButton86;
    private javax.swing.JRadioButton jRadioButton87;
    private javax.swing.JRadioButton jRadioButton88;
    private javax.swing.JRadioButton jRadioButton89;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton jRadioButton90;
    private javax.swing.JRadioButton jRadioButton91;
    private javax.swing.JRadioButton jRadioButton92;
    private javax.swing.JRadioButton jRadioButton93;
    private javax.swing.JRadioButton jRadioButton94;
    private javax.swing.JRadioButton jRadioButton95;
    private javax.swing.JRadioButton jRadioButton96;
    private javax.swing.JRadioButton jRadioButton97;
    private javax.swing.JRadioButton jRadioButton98;
    private javax.swing.JRadioButton jRadioButton99;
    private javax.swing.JToggleButton jToggleButton100;
    private javax.swing.JToggleButton jToggleButton101;
    private javax.swing.JToggleButton jToggleButton102;
    private javax.swing.JToggleButton jToggleButton103;
    private javax.swing.JToggleButton jToggleButton104;
    private javax.swing.JToggleButton jToggleButton105;
    private javax.swing.JToggleButton jToggleButton106;
    private javax.swing.JToggleButton jToggleButton107;
    private javax.swing.JToggleButton jToggleButton108;
    private javax.swing.JToggleButton jToggleButton109;
    private javax.swing.JToggleButton jToggleButton110;
    private javax.swing.JToggleButton jToggleButton111;
    private javax.swing.JToggleButton jToggleButton112;
    private javax.swing.JToggleButton jToggleButton113;
    private javax.swing.JToggleButton jToggleButton114;
    private javax.swing.JToggleButton jToggleButton115;
    private javax.swing.JToggleButton jToggleButton116;
    private javax.swing.JToggleButton jToggleButton117;
    private javax.swing.JToggleButton jToggleButton118;
    private javax.swing.JToggleButton jToggleButton119;
    private javax.swing.JToggleButton jToggleButton120;
    private javax.swing.JToggleButton jToggleButton121;
    private javax.swing.JToggleButton jToggleButton122;
    private javax.swing.JToggleButton jToggleButton126;
    private javax.swing.JToggleButton jToggleButton130;
    private javax.swing.JToggleButton jToggleButton134;
    private javax.swing.JToggleButton jToggleButton138;
    private javax.swing.JToggleButton jToggleButton142;
    private javax.swing.JToggleButton jToggleButton146;
    private javax.swing.JToggleButton jToggleButton147;
    private javax.swing.JToggleButton jToggleButton148;
    private javax.swing.JToggleButton jToggleButton149;
    private javax.swing.JToggleButton jToggleButton150;
    private javax.swing.JToggleButton jToggleButton151;
    private javax.swing.JToggleButton jToggleButton152;
    private javax.swing.JToggleButton jToggleButton153;
    private javax.swing.JToggleButton jToggleButton154;
    private javax.swing.JToggleButton jToggleButton155;
    private javax.swing.JToggleButton jToggleButton156;
    private javax.swing.JToggleButton jToggleButton157;
    private javax.swing.JToggleButton jToggleButton158;
    private javax.swing.JToggleButton jToggleButton159;
    private javax.swing.JToggleButton jToggleButton160;
    private javax.swing.JToggleButton jToggleButton161;
    private javax.swing.JToggleButton jToggleButton162;
    private javax.swing.JToggleButton jToggleButton163;
    private javax.swing.JToggleButton jToggleButton164;
    private javax.swing.JToggleButton jToggleButton165;
    private javax.swing.JToggleButton jToggleButton166;
    private javax.swing.JToggleButton jToggleButton167;
    private javax.swing.JToggleButton jToggleButton168;
    private javax.swing.JToggleButton jToggleButton169;
    private javax.swing.JToggleButton jToggleButton170;
    private javax.swing.JToggleButton jToggleButton171;
    private javax.swing.JToggleButton jToggleButton172;
    private javax.swing.JToggleButton jToggleButton173;
    private javax.swing.JToggleButton jToggleButton174;
    private javax.swing.JToggleButton jToggleButton175;
    private javax.swing.JToggleButton jToggleButton176;
    private javax.swing.JToggleButton jToggleButton177;
    private javax.swing.JToggleButton jToggleButton178;
    private javax.swing.JToggleButton jToggleButton179;
    private javax.swing.JToggleButton jToggleButton180;
    private javax.swing.JToggleButton jToggleButton181;
    private javax.swing.JToggleButton jToggleButton182;
    private javax.swing.JToggleButton jToggleButton183;
    private javax.swing.JToggleButton jToggleButton184;
    private javax.swing.JToggleButton jToggleButton185;
    private javax.swing.JToggleButton jToggleButton186;
    private javax.swing.JToggleButton jToggleButton187;
    private javax.swing.JToggleButton jToggleButton188;
    private javax.swing.JToggleButton jToggleButton189;
    private javax.swing.JToggleButton jToggleButton190;
    private javax.swing.JToggleButton jToggleButton191;
    private javax.swing.JToggleButton jToggleButton192;
    private javax.swing.JToggleButton jToggleButton193;
    private javax.swing.JToggleButton jToggleButton194;
    private javax.swing.JToggleButton jToggleButton195;
    private javax.swing.JToggleButton jToggleButton196;
    private javax.swing.JToggleButton jToggleButton197;
    private javax.swing.JToggleButton jToggleButton198;
    private javax.swing.JToggleButton jToggleButton199;
    private javax.swing.JToggleButton jToggleButton200;
    private javax.swing.JToggleButton jToggleButton201;
    private javax.swing.JToggleButton jToggleButton202;
    private javax.swing.JToggleButton jToggleButton203;
    private javax.swing.JToggleButton jToggleButton204;
    private javax.swing.JToggleButton jToggleButton205;
    private javax.swing.JToggleButton jToggleButton206;
    private javax.swing.JToggleButton jToggleButton207;
    private javax.swing.JToggleButton jToggleButton208;
    private javax.swing.JToggleButton jToggleButton209;
    private javax.swing.JToggleButton jToggleButton210;
    private javax.swing.JToggleButton jToggleButton211;
    private javax.swing.JToggleButton jToggleButton212;
    private javax.swing.JToggleButton jToggleButton213;
    private javax.swing.JToggleButton jToggleButton214;
    private javax.swing.JToggleButton jToggleButton215;
    private javax.swing.JToggleButton jToggleButton216;
    private javax.swing.JToggleButton jToggleButton217;
    private javax.swing.JToggleButton jToggleButton218;
    private javax.swing.JToggleButton jToggleButton219;
    private javax.swing.JToggleButton jToggleButton220;
    private javax.swing.JToggleButton jToggleButton221;
    private javax.swing.JToggleButton jToggleButton222;
    private javax.swing.JToggleButton jToggleButton223;
    private javax.swing.JToggleButton jToggleButton224;
    private javax.swing.JToggleButton jToggleButton225;
    private javax.swing.JToggleButton jToggleButton226;
    private javax.swing.JToggleButton jToggleButton227;
    private javax.swing.JToggleButton jToggleButton228;
    private javax.swing.JToggleButton jToggleButton229;
    private javax.swing.JToggleButton jToggleButton230;
    private javax.swing.JToggleButton jToggleButton231;
    private javax.swing.JToggleButton jToggleButton232;
    private javax.swing.JToggleButton jToggleButton233;
    private javax.swing.JToggleButton jToggleButton234;
    private javax.swing.JToggleButton jToggleButton235;
    private javax.swing.JToggleButton jToggleButton236;
    private javax.swing.JToggleButton jToggleButton237;
    private javax.swing.JToggleButton jToggleButton238;
    private javax.swing.JToggleButton jToggleButton239;
    private javax.swing.JToggleButton jToggleButton240;
    private javax.swing.JToggleButton jToggleButton35;
    private javax.swing.JToggleButton jToggleButton36;
    private javax.swing.JToggleButton jToggleButton37;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton41;
    private javax.swing.JToggleButton jToggleButton42;
    private javax.swing.JToggleButton jToggleButton43;
    private javax.swing.JToggleButton jToggleButton44;
    private javax.swing.JToggleButton jToggleButton45;
    private javax.swing.JToggleButton jToggleButton46;
    private javax.swing.JToggleButton jToggleButton47;
    private javax.swing.JToggleButton jToggleButton48;
    private javax.swing.JToggleButton jToggleButton49;
    private javax.swing.JToggleButton jToggleButton50;
    private javax.swing.JToggleButton jToggleButton51;
    private javax.swing.JToggleButton jToggleButton52;
    private javax.swing.JToggleButton jToggleButton53;
    private javax.swing.JToggleButton jToggleButton54;
    private javax.swing.JToggleButton jToggleButton55;
    private javax.swing.JToggleButton jToggleButton56;
    private javax.swing.JToggleButton jToggleButton57;
    private javax.swing.JToggleButton jToggleButton58;
    private javax.swing.JToggleButton jToggleButton59;
    private javax.swing.JToggleButton jToggleButton60;
    private javax.swing.JToggleButton jToggleButton61;
    private javax.swing.JToggleButton jToggleButton62;
    private javax.swing.JToggleButton jToggleButton63;
    private javax.swing.JToggleButton jToggleButton64;
    private javax.swing.JToggleButton jToggleButton65;
    private javax.swing.JToggleButton jToggleButton66;
    private javax.swing.JToggleButton jToggleButton67;
    private javax.swing.JToggleButton jToggleButton68;
    private javax.swing.JToggleButton jToggleButton69;
    private javax.swing.JToggleButton jToggleButton70;
    private javax.swing.JToggleButton jToggleButton71;
    private javax.swing.JToggleButton jToggleButton72;
    private javax.swing.JToggleButton jToggleButton73;
    private javax.swing.JToggleButton jToggleButton74;
    private javax.swing.JToggleButton jToggleButton75;
    private javax.swing.JToggleButton jToggleButton76;
    private javax.swing.JToggleButton jToggleButton77;
    private javax.swing.JToggleButton jToggleButton78;
    private javax.swing.JToggleButton jToggleButton79;
    private javax.swing.JToggleButton jToggleButton80;
    private javax.swing.JToggleButton jToggleButton81;
    private javax.swing.JToggleButton jToggleButton82;
    private javax.swing.JToggleButton jToggleButton83;
    private javax.swing.JToggleButton jToggleButton84;
    private javax.swing.JToggleButton jToggleButton85;
    private javax.swing.JToggleButton jToggleButton86;
    private javax.swing.JToggleButton jToggleButton87;
    private javax.swing.JToggleButton jToggleButton88;
    private javax.swing.JToggleButton jToggleButton89;
    private javax.swing.JToggleButton jToggleButton90;
    private javax.swing.JToggleButton jToggleButton91;
    private javax.swing.JToggleButton jToggleButton92;
    private javax.swing.JToggleButton jToggleButton93;
    private javax.swing.JToggleButton jToggleButton94;
    private javax.swing.JToggleButton jToggleButton95;
    private javax.swing.JToggleButton jToggleButton96;
    private javax.swing.JToggleButton jToggleButton97;
    private javax.swing.JToggleButton jToggleButton98;
    private javax.swing.JToggleButton jToggleButton99;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JToggleButton memoBtn14;
    private javax.swing.JToggleButton memoBtn15;
    private javax.swing.JToggleButton memoBtn16;
    private javax.swing.JToggleButton memoBtn17;
    private javax.swing.JToggleButton memoBtn18;
    private javax.swing.JToggleButton memoBtn19;
    private javax.swing.JToggleButton memoBtn20;
    private javax.swing.JToggleButton memoBtn21;
    private javax.swing.JToggleButton memoBtn22;
    private javax.swing.JToggleButton memoBtn23;
    private javax.swing.JToggleButton memoBtn24;
    private javax.swing.JToggleButton memoBtn25;
    private javax.swing.JToggleButton memoBtn26;
    private javax.swing.JToggleButton memoBtn27;
    private javax.swing.JPanel npi2Panel;
    private javax.swing.JCheckBox npiCheck1;
    private javax.swing.JCheckBox npiCheck10;
    private javax.swing.JCheckBox npiCheck2;
    private javax.swing.JCheckBox npiCheck3;
    private javax.swing.JCheckBox npiCheck4;
    private javax.swing.JCheckBox npiCheck5;
    private javax.swing.JCheckBox npiCheck6;
    private javax.swing.JCheckBox npiCheck7;
    private javax.swing.JCheckBox npiCheck8;
    private javax.swing.JCheckBox npiCheck9;
    private javax.swing.ButtonGroup npiFreqBtnGroup1;
    private javax.swing.ButtonGroup npiFreqBtnGroup10;
    private javax.swing.ButtonGroup npiFreqBtnGroup2;
    private javax.swing.ButtonGroup npiFreqBtnGroup3;
    private javax.swing.ButtonGroup npiFreqBtnGroup4;
    private javax.swing.ButtonGroup npiFreqBtnGroup5;
    private javax.swing.ButtonGroup npiFreqBtnGroup6;
    private javax.swing.ButtonGroup npiFreqBtnGroup7;
    private javax.swing.ButtonGroup npiFreqBtnGroup8;
    private javax.swing.ButtonGroup npiFreqBtnGroup9;
    private javax.swing.ButtonGroup npiGravBtnGroup1;
    private javax.swing.ButtonGroup npiGravBtnGroup10;
    private javax.swing.ButtonGroup npiGravBtnGroup2;
    private javax.swing.ButtonGroup npiGravBtnGroup3;
    private javax.swing.ButtonGroup npiGravBtnGroup4;
    private javax.swing.ButtonGroup npiGravBtnGroup5;
    private javax.swing.ButtonGroup npiGravBtnGroup6;
    private javax.swing.ButtonGroup npiGravBtnGroup7;
    private javax.swing.ButtonGroup npiGravBtnGroup8;
    private javax.swing.ButtonGroup npiGravBtnGroup9;
    private javax.swing.JPanel npiPanel;
    private javax.swing.JScrollPane npiScroll;
    private javax.swing.JPanel npiTab;
    private javax.swing.JLabel npiTotal;
    private javax.swing.JLabel npiTotal1;
    private javax.swing.JLabel npiTotal10;
    private javax.swing.JLabel npiTotal2;
    private javax.swing.JLabel npiTotal3;
    private javax.swing.JLabel npiTotal4;
    private javax.swing.JLabel npiTotal5;
    private javax.swing.JLabel npiTotal6;
    private javax.swing.JLabel npiTotal7;
    private javax.swing.JLabel npiTotal8;
    private javax.swing.JLabel npiTotal9;
    private javax.swing.JToggleButton orientacioBtn14;
    private javax.swing.JToggleButton orientacioBtn15;
    private javax.swing.JToggleButton orientacioBtn16;
    private javax.swing.JToggleButton orientacioBtn17;
    private javax.swing.JToggleButton orientacioBtn18;
    private javax.swing.JToggleButton orientacioBtn19;
    private javax.swing.JToggleButton orientacioBtn20;
    private javax.swing.JToggleButton orientacioBtn21;
    private javax.swing.JToggleButton orientacioBtn22;
    private javax.swing.JToggleButton orientacioBtn23;
    private javax.swing.JToggleButton orientacioBtn24;
    private javax.swing.JToggleButton orientacioBtn25;
    private javax.swing.JToggleButton orientacioBtn26;
    private javax.swing.JToggleButton orientacioBtn27;
    private javax.swing.JToggleButton raoBtn14;
    private javax.swing.JToggleButton raoBtn15;
    private javax.swing.JToggleButton raoBtn16;
    private javax.swing.JToggleButton raoBtn17;
    private javax.swing.JToggleButton raoBtn18;
    private javax.swing.JToggleButton raoBtn19;
    private javax.swing.JToggleButton raoBtn20;
    private javax.swing.JToggleButton raoBtn21;
    private javax.swing.JToggleButton raoBtn22;
    private javax.swing.JToggleButton raoBtn23;
    private javax.swing.JToggleButton raoBtn24;
    private javax.swing.JToggleButton raoBtn25;
    private javax.swing.JToggleButton raoBtn26;
    private javax.swing.JToggleButton raoBtn27;
    private javax.swing.JToggleButton raoBtn28;
    private javax.swing.JToggleButton raoBtn29;
    private javax.swing.JToggleButton raoBtn30;
    private javax.swing.ButtonGroup sf12BtnGroup1;
    private javax.swing.ButtonGroup sf12BtnGroup10;
    private javax.swing.ButtonGroup sf12BtnGroup11;
    private javax.swing.ButtonGroup sf12BtnGroup12;
    private javax.swing.ButtonGroup sf12BtnGroup2;
    private javax.swing.ButtonGroup sf12BtnGroup3;
    private javax.swing.ButtonGroup sf12BtnGroup4;
    private javax.swing.ButtonGroup sf12BtnGroup5;
    private javax.swing.ButtonGroup sf12BtnGroup6;
    private javax.swing.ButtonGroup sf12BtnGroup7;
    private javax.swing.ButtonGroup sf12BtnGroup8;
    private javax.swing.ButtonGroup sf12BtnGroup9;
    private javax.swing.JPanel sf12Panel;
    private javax.swing.JScrollPane sf12Scroll;
    private javax.swing.JPanel sf12Tab;
    private javax.swing.JLabel sf12Total;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.ButtonGroup zaritBtnGroup1;
    private javax.swing.ButtonGroup zaritBtnGroup10;
    private javax.swing.ButtonGroup zaritBtnGroup11;
    private javax.swing.ButtonGroup zaritBtnGroup12;
    private javax.swing.ButtonGroup zaritBtnGroup13;
    private javax.swing.ButtonGroup zaritBtnGroup14;
    private javax.swing.ButtonGroup zaritBtnGroup15;
    private javax.swing.ButtonGroup zaritBtnGroup16;
    private javax.swing.ButtonGroup zaritBtnGroup17;
    private javax.swing.ButtonGroup zaritBtnGroup18;
    private javax.swing.ButtonGroup zaritBtnGroup19;
    private javax.swing.ButtonGroup zaritBtnGroup2;
    private javax.swing.ButtonGroup zaritBtnGroup20;
    private javax.swing.ButtonGroup zaritBtnGroup21;
    private javax.swing.ButtonGroup zaritBtnGroup22;
    private javax.swing.ButtonGroup zaritBtnGroup3;
    private javax.swing.ButtonGroup zaritBtnGroup4;
    private javax.swing.ButtonGroup zaritBtnGroup5;
    private javax.swing.ButtonGroup zaritBtnGroup6;
    private javax.swing.ButtonGroup zaritBtnGroup7;
    private javax.swing.ButtonGroup zaritBtnGroup8;
    private javax.swing.ButtonGroup zaritBtnGroup9;
    private javax.swing.JPanel zaritPanel2;
    private javax.swing.JPanel zaritQPanel;
    private javax.swing.JScrollPane zaritScroll1;
    private javax.swing.JPanel zaritTab;
    private javax.swing.JLabel zaritTotal;
    // End of variables declaration//GEN-END:variables
}
