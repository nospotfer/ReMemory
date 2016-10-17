/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.Utils;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import model.Pacient;

/**
 *
 * @author a630703
 */
public class UPSA extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public UPSA(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "UPSA";
        numPaginesTotal = this.getComponentCount();

        initUpsa1();
        initUpsa2();
        initUpsa3();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // UPSA
        Utils.setProperty(prop,"upsaTotal",upsaTotal);
        Utils.setProperty(prop,"comunicacioSub",comunicacioSub);
        Utils.setProperty(prop,"comprensioSub",comprensioSub);
    }

    private void initUpsa1() {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                mocaPunts2.setText(sumPuntsUpsa1()+"");
            }
        };
        
        Collections.list(upsaButtonGroup1.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn1));
        });
        Collections.list(upsaButtonGroup2.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn2));
        });
        Collections.list(upsaButtonGroup3.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn3));
        });
        Collections.list(upsaButtonGroup4.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn4));
        });
        Collections.list(upsaButtonGroup5.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn5));
        });
        Collections.list(upsaButtonGroup6.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn6));
        });
        Collections.list(upsaButtonGroup7.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn7));
        });
        Collections.list(upsaButtonGroup8.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn8));
        });
        Collections.list(upsaButtonGroup9.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn9));
        });
        Collections.list(upsaButtonGroup10.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn10));
        });
        Collections.list(upsaButtonGroup11.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn11));
        });
        Collections.list(upsaButtonGroup12.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comuBtn12));
        });
    }

    private ActionListener upsaGetActionListener(JToggleButton toggle){
        ActionListener actionListener2 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String text = actionEvent.getActionCommand();
                toggle.setText(text);
                if (text == "1"){
                    toggle.setSelected(true);
                } else {
                    toggle.setSelected(false);
                }
                actualitzaPuntsComprensio();
                actualitzaPuntsComuniacio();
            }
        };
        return actionListener2;
    }

    private ActionListener upsaGetActionListener(ButtonGroup bG){
        ActionListener actionListener2 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Enumeration<AbstractButton> e = bG.getElements();
                while(e.hasMoreElements()){
                    JToggleButton jT = (JToggleButton)e.nextElement();
                    if (actionEvent.getActionCommand() == jT.getActionCommand()){
                        jT.setSelected(true);
                    } else {
                        jT.setSelected(false);
                    }
                }
                actualitzaPuntsComprensio();
                actualitzaPuntsComuniacio();
            }
        };
        return actionListener2;
    }
    
    private int sumPuntsUpsa1(){
       int count = 0;
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup1);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup2);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup3);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup4);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup5);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup6);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup7);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup8);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup9);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup10);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup11);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup12);
       return count;
    }
    
    private void initUpsa2() {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                mocaPunts3.setText(sumPuntsUpsa2()+"");
            }
        };
        Collections.list(upsaButtonGroup13.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comprensioBtn1));
        });
        Collections.list(upsaButtonGroup14.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comprensioBtn2));
        });
        Collections.list(upsaButtonGroup15.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(comprensioBtn3));
        });
        Collections.list(upsaButtonGroup16.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(upsaButtonGrup21));
        });
        Collections.list(upsaButtonGroup17.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(upsaButtonGrup22));
        });
        Collections.list(upsaButtonGroup18.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(upsaButtonGrup23));
        });
        Collections.list(upsaButtonGroup19.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(upsaButtonGrup24));
        });
        Collections.list(upsaButtonGroup20.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(actionListener);
            rb.addActionListener(upsaGetActionListener(upsaButtonGrup25));
        });
    }
    
    private int sumPuntsUpsa2(){
       int count = 0;
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup13);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup14);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup15);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup16);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup17);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup18);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup19);
       count += Utils.getPunctuationFromButtonGroup(upsaButtonGroup20);
       return count;
    }

    private void initUpsa3() {
        ActionListener comunicacioAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(((JToggleButton)e.getSource()).getText().equals("0")){
                    ((JToggleButton)e.getSource()).setText("1");
                } else {
                    ((JToggleButton)e.getSource()).setText("0");
                }
                actualitzaPuntsComuniacio();
            }
        };
        for (Component com : comunicacioPanel.getComponents()){
            if (com instanceof JToggleButton){
                ((JToggleButton)com).addActionListener(comunicacioAction);
            }
        }

        ActionListener comprensioAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(((JToggleButton)e.getSource()).getText().equals("0")){
                    ((JToggleButton)e.getSource()).setText("1");
                } else {
                    ((JToggleButton)e.getSource()).setText("0");
                }
                actualitzaPuntsComprensio();
            }
        };
        comprensioBtn1.addActionListener(comprensioAction);
        comprensioBtn2.addActionListener(comprensioAction);
        comprensioBtn3.addActionListener(comprensioAction);

        ActionListener comprensioAction2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualitzaPuntsComprensio();
            }
        };

        Collections.list(upsaButtonGrup21.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(comprensioAction2);
        });
        Collections.list(upsaButtonGrup22.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(comprensioAction2);
        });
        Collections.list(upsaButtonGrup23.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(comprensioAction2);
        });
        Collections.list(upsaButtonGrup24.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(comprensioAction2);
        });
        Collections.list(upsaButtonGrup25.getElements()).stream().forEach((rb) -> {
            rb.addActionListener(comprensioAction2);
        });

    }

    private void actualitzaPuntsComuniacio() {
        int comuTotal = sumPuntsUpsaParcials(comunicacioPanel);
        comunicacioTotal.setText(comuTotal+"");
        double comuPercent = (new Double(comuTotal))/12;
        comunicacioPercent.setText(String.format("%.2f",comuPercent).replace(',', '.'));
        double comuSub = comuPercent*25;
        String comuSubString;
        if ((comuSub*10)%10 > 0){
            comuSubString = String.format("%.2f",comuSub).replace(',', '.');
        } else {
            comuSubString = (int)comuSub+"";
        }
        comunicacioSub.setText(comuSubString+"");
        calculaTotalUpsa();
    }

    private void actualitzaPuntsComprensio() {
        int compTotal = sumPuntsUpsaParcials(comprensioPanel);
        System.out.println(compTotal);
        comprensioTotal.setText(compTotal+"");
        double compPercent = (new Double(compTotal))/13;
        comprensioPercent.setText(String.format("%.2f",compPercent).replace(',', '.'));
        double compSub = compPercent*25;
        String compSubString;
        if ((compSub*10)%10 > 0){
            compSubString = String.format("%.2f",compSub).replace(',', '.');
        } else {
            compSubString = (int)compSub+"";
        }
        comprensioSub.setText(compSubString+"");
        calculaTotalUpsa();
    }

    private void calculaTotalUpsa() {

        Double totalComunicacio = Double.parseDouble(comunicacioSub.getText());
        Double totalComprensio = Double.parseDouble(comprensioSub.getText());

        Double total = totalComprensio+totalComunicacio;

        String totalUpsa;

        if ((total*10)%10 > 0){
            totalUpsa = String.format("%.2f",total).replace(',', '.');
        } else {
            totalUpsa = (int)total.doubleValue()+"";
        }

        upsaTotal.setText(totalUpsa+"");
    }

    private int sumPuntsUpsaParcials(JPanel panel){
        int count = 0;
        for (Component com : panel.getComponents()){
            if (com instanceof JToggleButton){
                if (((JToggleButton)com).isSelected()) {
                    count += Integer.parseInt(((JToggleButton) com).getText());
                }
            }
        }
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

        upsaButtonGrup21 = new javax.swing.ButtonGroup();
        upsaButtonGrup22 = new javax.swing.ButtonGroup();
        upsaButtonGrup23 = new javax.swing.ButtonGroup();
        upsaButtonGrup24 = new javax.swing.ButtonGroup();
        upsaButtonGrup25 = new javax.swing.ButtonGroup();
        upsaButtonGroup1 = new javax.swing.ButtonGroup();
        upsaButtonGroup2 = new javax.swing.ButtonGroup();
        upsaButtonGroup3 = new javax.swing.ButtonGroup();
        upsaButtonGroup4 = new javax.swing.ButtonGroup();
        upsaButtonGroup5 = new javax.swing.ButtonGroup();
        upsaButtonGroup6 = new javax.swing.ButtonGroup();
        upsaButtonGroup7 = new javax.swing.ButtonGroup();
        upsaButtonGroup8 = new javax.swing.ButtonGroup();
        upsaButtonGroup9 = new javax.swing.ButtonGroup();
        upsaButtonGroup10 = new javax.swing.ButtonGroup();
        upsaButtonGroup11 = new javax.swing.ButtonGroup();
        upsaButtonGroup12 = new javax.swing.ButtonGroup();
        upsaButtonGroup13 = new javax.swing.ButtonGroup();
        upsaButtonGroup14 = new javax.swing.ButtonGroup();
        upsaButtonGroup15 = new javax.swing.ButtonGroup();
        upsaButtonGroup16 = new javax.swing.ButtonGroup();
        upsaButtonGroup17 = new javax.swing.ButtonGroup();
        upsaButtonGroup18 = new javax.swing.ButtonGroup();
        upsaButtonGroup19 = new javax.swing.ButtonGroup();
        upsaButtonGroup20 = new javax.swing.ButtonGroup();
        upsaScroll1 = new javax.swing.JScrollPane();
        mocaPanel1 = new javax.swing.JPanel();
        jLabel276 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel328 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jToggleButton31 = new javax.swing.JToggleButton();
        jToggleButton32 = new javax.swing.JToggleButton();
        jLabel326 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel329 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jToggleButton33 = new javax.swing.JToggleButton();
        jToggleButton34 = new javax.swing.JToggleButton();
        jLabel286 = new javax.swing.JLabel();
        jToggleButton68 = new javax.swing.JToggleButton();
        jToggleButton72 = new javax.swing.JToggleButton();
        jPanel49 = new javax.swing.JPanel();
        jLabel330 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        jToggleButton60 = new javax.swing.JToggleButton();
        jToggleButton64 = new javax.swing.JToggleButton();
        jPanel50 = new javax.swing.JPanel();
        jLabel331 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel332 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jToggleButton76 = new javax.swing.JToggleButton();
        jToggleButton80 = new javax.swing.JToggleButton();
        jLabel288 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jToggleButton91 = new javax.swing.JToggleButton();
        jToggleButton98 = new javax.swing.JToggleButton();
        jToggleButton102 = new javax.swing.JToggleButton();
        jLabel290 = new javax.swing.JLabel();
        jToggleButton106 = new javax.swing.JToggleButton();
        jToggleButton108 = new javax.swing.JToggleButton();
        jLabel291 = new javax.swing.JLabel();
        jToggleButton110 = new javax.swing.JToggleButton();
        jToggleButton112 = new javax.swing.JToggleButton();
        jLabel292 = new javax.swing.JLabel();
        jToggleButton114 = new javax.swing.JToggleButton();
        jPanel52 = new javax.swing.JPanel();
        jLabel333 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jToggleButton126 = new javax.swing.JToggleButton();
        jToggleButton130 = new javax.swing.JToggleButton();
        jLabel295 = new javax.swing.JLabel();
        jToggleButton148 = new javax.swing.JToggleButton();
        jToggleButton149 = new javax.swing.JToggleButton();
        jPanel53 = new javax.swing.JPanel();
        jLabel334 = new javax.swing.JLabel();
        jLabel296 = new javax.swing.JLabel();
        jLabel297 = new javax.swing.JLabel();
        jToggleButton154 = new javax.swing.JToggleButton();
        jToggleButton155 = new javax.swing.JToggleButton();
        jLabel335 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        mocaPunts2 = new javax.swing.JLabel();
        upsaScroll2 = new javax.swing.JScrollPane();
        mocaPanel2 = new javax.swing.JPanel();
        jLabel285 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel336 = new javax.swing.JLabel();
        jLabel337 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jLabel303 = new javax.swing.JLabel();
        jLabel338 = new javax.swing.JLabel();
        jLabel304 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel342 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jToggleButton164 = new javax.swing.JToggleButton();
        jToggleButton165 = new javax.swing.JToggleButton();
        jLabel310 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        jToggleButton170 = new javax.swing.JToggleButton();
        jLabel313 = new javax.swing.JLabel();
        jToggleButton171 = new javax.swing.JToggleButton();
        jToggleButton172 = new javax.swing.JToggleButton();
        jLabel314 = new javax.swing.JLabel();
        jToggleButton173 = new javax.swing.JToggleButton();
        jLabel343 = new javax.swing.JLabel();
        jLabel344 = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jLabel317 = new javax.swing.JLabel();
        jToggleButton174 = new javax.swing.JToggleButton();
        jToggleButton175 = new javax.swing.JToggleButton();
        jToggleButton176 = new javax.swing.JToggleButton();
        jLabel318 = new javax.swing.JLabel();
        jToggleButton177 = new javax.swing.JToggleButton();
        jToggleButton178 = new javax.swing.JToggleButton();
        jToggleButton179 = new javax.swing.JToggleButton();
        jLabel319 = new javax.swing.JLabel();
        jToggleButton180 = new javax.swing.JToggleButton();
        jToggleButton181 = new javax.swing.JToggleButton();
        jToggleButton182 = new javax.swing.JToggleButton();
        jToggleButton183 = new javax.swing.JToggleButton();
        jLabel322 = new javax.swing.JLabel();
        jToggleButton184 = new javax.swing.JToggleButton();
        jToggleButton185 = new javax.swing.JToggleButton();
        jToggleButton186 = new javax.swing.JToggleButton();
        jToggleButton187 = new javax.swing.JToggleButton();
        jLabel323 = new javax.swing.JLabel();
        jToggleButton188 = new javax.swing.JToggleButton();
        jLabel345 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jLabel321 = new javax.swing.JLabel();
        mocaPunts3 = new javax.swing.JLabel();
        upsaScroll3 = new javax.swing.JScrollPane();
        upsa2Panel = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        comunicacioPanel = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        comuBtn6 = new javax.swing.JToggleButton();
        comuBtn5 = new javax.swing.JToggleButton();
        comuBtn4 = new javax.swing.JToggleButton();
        comuBtn7 = new javax.swing.JToggleButton();
        comuBtn8 = new javax.swing.JToggleButton();
        comuBtn9 = new javax.swing.JToggleButton();
        comuBtn10 = new javax.swing.JToggleButton();
        comuBtn11 = new javax.swing.JToggleButton();
        comuBtn12 = new javax.swing.JToggleButton();
        comuBtn1 = new javax.swing.JToggleButton();
        comuBtn2 = new javax.swing.JToggleButton();
        comuBtn3 = new javax.swing.JToggleButton();
        comprensioPanel = new javax.swing.JPanel();
        comprensioBtn1 = new javax.swing.JToggleButton();
        comprensioBtn2 = new javax.swing.JToggleButton();
        comprensioBtn3 = new javax.swing.JToggleButton();
        raoBtn21 = new javax.swing.JToggleButton();
        activitatsDBtn22 = new javax.swing.JToggleButton();
        cuidatBtn15 = new javax.swing.JToggleButton();
        jLabel166 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
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
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        activitatsDBtn25 = new javax.swing.JToggleButton();
        jToggleButton150 = new javax.swing.JToggleButton();
        jToggleButton151 = new javax.swing.JToggleButton();
        jToggleButton152 = new javax.swing.JToggleButton();
        jToggleButton153 = new javax.swing.JToggleButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel200 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        comunicacioTotal = new javax.swing.JLabel();
        comprensioTotal = new javax.swing.JLabel();
        comunicacioPercent = new javax.swing.JLabel();
        comprensioPercent = new javax.swing.JLabel();
        comunicacioSub = new javax.swing.JLabel();
        comprensioSub = new javax.swing.JLabel();
        upsaTotal = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel276.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel276.setText("2. HABILITATS DE COMUNICACIÓ: Telèfon i carta");

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("1. Col·loqueu el telèfon davant del subjecte i dóna-li les següents instruccions:"));

        jLabel328.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel328.setText("<html>Utilitzarem aquest telèfon per durant les properes tasques. Encara que l'aparell està desconnectat, mostra com utilitza el telèfon habitualment.<br><br>En primer lloc, mostra com farà per demanar ajuda en cas que tingués una emergència.");

        jLabel280.setText("1 - 1 - 2 (marcar)");

        jLabel281.setText("Resposta:");

        upsaButtonGroup1.add(jToggleButton31);
        jToggleButton31.setText("0");

        upsaButtonGroup1.add(jToggleButton32);
        jToggleButton32.setText("1");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel328, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel280)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton32))
                    .addComponent(jLabel281)))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel328, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel281)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton31)
                        .addComponent(jToggleButton32))
                    .addComponent(jLabel280))
                .addContainerGap())
        );

        jLabel326.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel326.setText("Material");

        jLabel277.setText("<html>Targeta de joc de rols - Carta de cita Mèdica.<br>Nota: La data de la cita Mèdica ha d'ésser de Almenys un o dos mesos Després de la Data d'administració de la UPSA. Aquesta data s'ha de modificar amb Freqüència.<br>Anoteu la data del dilluns imprimació de Cada mes, o de l'segon dilluns del mes si dilluns imprimació és dóna festiu.");

        jLabel278.setText("<html>Telèfon amb botons depresibles (desconnectat). Assegureu-vos que els botons per marcar són a la base del telèfon i NO a l'auricular. A més, en cas que sigui possible,<br>escolliu un model de telèfon en què es requereixi aixecar l'auricular per marcar el número.");

        jLabel327.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel327.setText("Procediment");

        jLabel279.setText("<html><p align=\"justify\">Aquesta tasca requereix que el subjecte demostri que sap com utilitzar el telèfon. Els passos a seguir inclouen agafar l'auricular, tocar els botons per marcar el número de telèfon, i parlar pel micròfon de l'auricular. El pacient ha de posar l'auricular al seu lloc i repetir aquesta seqüència en cadascuna de les tasques següents. Les instruccions es donaran una sola vegada, excepte en la tasca de marcar un número de memòria.");

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("2. Indiqueu el subjecte que realitzi el següent:"));

        jLabel329.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel329.setText("Marqueu el nombre de casa i digui que va a arribar tard a dinar.");

        jLabel282.setText("Nº de telèfon (marcar)");

        jLabel283.setText("Resposta:");

        upsaButtonGroup2.add(jToggleButton33);
        jToggleButton33.setText("0");

        upsaButtonGroup2.add(jToggleButton34);
        jToggleButton34.setText("1");

        jLabel286.setText("Nº de telèfon (marcar)");

        upsaButtonGroup3.add(jToggleButton68);
        jToggleButton68.setText("0");

        upsaButtonGroup3.add(jToggleButton72);
        jToggleButton72.setText("1");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel329)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel282)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton34))
                    .addComponent(jLabel283)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel286)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton72)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel329)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel283)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel282)
                    .addComponent(jToggleButton33)
                    .addComponent(jToggleButton34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel286)
                    .addComponent(jToggleButton68)
                    .addComponent(jToggleButton72))
                .addGap(10, 10, 10))
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("3. Indiqueu el subjecte que realitzi el següent:"));

        jLabel330.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel330.setText("<html>Escolta atentament aquest número i marqui'l de memòria:<br><center>596 6996");

        jLabel284.setText("<html><div style=\"text-align:justify\"><b><u>NOTA A L'AVALUADOR:</b></u> El nombre ha de ser marcat de memòria però es pot repetir si el subjecte ho sol·licita. Si el subjecte comença a marcar el número i després demana que es repeteixi el nombre, l'avaluador pot repetir tot el nombre de nou. El subjecte pot marcar els números restants per ordre o pot penjar i marcar tot el número. Si el subjecte sol·licita que l'entrevistador repeteixi el nombre una tercera vegada, l'entrevistador ha de indicar-li al subjecte que marqui el que recordi.");

        upsaButtonGroup4.add(jToggleButton60);
        jToggleButton60.setText("0");

        upsaButtonGroup4.add(jToggleButton64);
        jToggleButton64.setText("1");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel284, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel330, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton64)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel330, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton60)
                        .addComponent(jToggleButton64)))
                .addGap(18, 18, 18)
                .addComponent(jLabel284, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder("4. Indiqueu el subjecte que llegeixi la carta de la seva cita amb el metge dient:"));

        jLabel331.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel331.setText("<html>Imagineu que aquesta és una carta del seu metge. Llegiu aquesta carta en alt i presti molta atenció perquè posteriorment li faré algunes preguntes sobre això.");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel331, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel331, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder("5. Després que el pacient hagi llegit la carta, doni-li les següents instruccions (no a part o tapi la carta de cita mèdica):"));

        jLabel332.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel332.setText("<html>Truqui a la consulta del metge i deixi un missatge al contestador automàtic demanant que li canviï la cita per el dia següent a la mateixa hora. Assegureu-vos d'incloure tota la informació necessària.");

        jLabel287.setText("<html><div style=\"text-align:justify\"><b><u>NOTA A L'AVALUADOR:</b></u> El pacient ha de trobar el número de telèfon per reprogramar la seva cita que està escrit en la carta (96) 324.561 i marcar el nœmero correctament (1 punt), ha de donar el seu nom (1 punt), la data actual de la cita DILLUNS, 6 DE JUNY (la data que correspongui en cada cas) a les 8:00 (1 punt), la data de la nova cita (1 punt), i deixar un número de telèfon perquè li puguin tornar la trucada (1 punt) .");

        upsaButtonGroup5.add(jToggleButton76);
        jToggleButton76.setText("0");

        upsaButtonGroup5.add(jToggleButton80);
        jToggleButton80.setText("1");

        jLabel288.setText("Marcar telèfon");

        jLabel289.setText("Donar el seu nom");

        upsaButtonGroup6.add(jToggleButton91);
        jToggleButton91.setText("0");

        upsaButtonGroup6.add(jToggleButton98);
        jToggleButton98.setText("1");

        upsaButtonGroup7.add(jToggleButton102);
        jToggleButton102.setText("0");

        jLabel290.setText("Dir data cita actual");

        upsaButtonGroup7.add(jToggleButton106);
        jToggleButton106.setText("1");

        upsaButtonGroup8.add(jToggleButton108);
        jToggleButton108.setText("0");

        jLabel291.setText("Data cita nova");

        upsaButtonGroup8.add(jToggleButton110);
        jToggleButton110.setText("1");

        upsaButtonGroup9.add(jToggleButton112);
        jToggleButton112.setText("1");

        jLabel292.setText("Deixar núm. telèfon");

        upsaButtonGroup9.add(jToggleButton114);
        jToggleButton114.setText("0");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel287, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel332, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel292)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton112))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel290)
                            .addComponent(jLabel289)
                            .addComponent(jLabel288)
                            .addComponent(jLabel291))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel51Layout.createSequentialGroup()
                                .addComponent(jToggleButton108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton110))
                            .addGroup(jPanel51Layout.createSequentialGroup()
                                .addComponent(jToggleButton76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton80))
                            .addGroup(jPanel51Layout.createSequentialGroup()
                                .addComponent(jToggleButton91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton98))
                            .addGroup(jPanel51Layout.createSequentialGroup()
                                .addComponent(jToggleButton102)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton106))))))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel332, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton76)
                    .addComponent(jToggleButton80)
                    .addComponent(jLabel288))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton91)
                    .addComponent(jToggleButton98)
                    .addComponent(jLabel289))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton102)
                    .addComponent(jToggleButton106)
                    .addComponent(jLabel290))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton108)
                    .addComponent(jToggleButton110)
                    .addComponent(jLabel291))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton114)
                    .addComponent(jToggleButton112)
                    .addComponent(jLabel292))
                .addGap(18, 18, 18)
                .addComponent(jLabel287, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder("6. Deseu o amagui la targeta de role-play i pregunti el següent:"));

        jLabel333.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel333.setText("Quines dues coses ha de portar a la seva cita mèdica segons la carta que ha rebut?");

        jLabel293.setText("Targeta sanitària");

        jLabel294.setText("Resposta:");

        upsaButtonGroup10.add(jToggleButton126);
        jToggleButton126.setText("0");

        upsaButtonGroup10.add(jToggleButton130);
        jToggleButton130.setText("1");

        jLabel295.setText("Llista de medicaments");

        upsaButtonGroup11.add(jToggleButton148);
        jToggleButton148.setText("0");

        upsaButtonGroup11.add(jToggleButton149);
        jToggleButton149.setText("1");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel333)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel293)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton130))
                    .addComponent(jLabel294)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel295)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton149)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel333)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel294)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel293)
                    .addComponent(jToggleButton126)
                    .addComponent(jToggleButton130))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel295)
                    .addComponent(jToggleButton148)
                    .addComponent(jToggleButton149))
                .addGap(10, 10, 10))
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder("7. Faci-li la pregunta següent:"));

        jLabel334.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel334.setText("Quina altra cosa indicava la carta que havia de fer per preparar-se per la seva cita mèdica?");

        jLabel296.setText("No ingerir menjar ni líquids excepte aigua durant les 12 hores prèvies a la cita.");

        jLabel297.setText("Resposta:");

        upsaButtonGroup12.add(jToggleButton154);
        jToggleButton154.setText("0");

        upsaButtonGroup12.add(jToggleButton155);
        jToggleButton155.setText("1");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel334)
                    .addComponent(jLabel296)
                    .addComponent(jLabel297)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jToggleButton154)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton155)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel334)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel297)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel296)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton154)
                    .addComponent(jToggleButton155))
                .addContainerGap())
        );

        jLabel335.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel335.setText("Puntuació i duració");

        jLabel298.setText("<html><p align=\"justify\">S'atorga un punt per cada resposta correcta i 0 punts per cada resposta incorrecta. Aquesta tasca dura aproximadament cinc minuts i es puntua en un rang de 0 a 12.");

        jLabel299.setText("Puntuació total:");

        mocaPunts2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mocaPunts2.setText("0");

        javax.swing.GroupLayout mocaPanel1Layout = new javax.swing.GroupLayout(mocaPanel1);
        mocaPanel1.setLayout(mocaPanel1Layout);
        mocaPanel1Layout.setHorizontalGroup(
            mocaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mocaPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mocaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel276, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel326, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel327, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mocaPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(mocaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel335)
                            .addGroup(mocaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel278, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel277, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel279, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(mocaPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel299)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mocaPunts2))
                            .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        mocaPanel1Layout.setVerticalGroup(
            mocaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mocaPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel276)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel326)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel277, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel278, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel327)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel279, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel335)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(mocaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel299)
                    .addComponent(mocaPunts2))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        upsaScroll1.setViewportView(mocaPanel1);

        add(upsaScroll1, "card1");

        jLabel285.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel285.setText("3. COMPRENSIÓ I PLANIFICACIÓ: La platja");

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("1. Mostri-li al pacient la targeta de role-play (la platja) i doni-li les següents instruccions:"));

        jLabel336.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel336.setText("<html>Si us plau llegiu aquesta història sobre un viatge a la platja en veu alta. Llegiu-lo atentament perquè després li faré algunes preguntes sobre això.");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel336, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel336, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel337.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel337.setText("Material");

        jLabel302.setText("<html>Targeta de role-play: article del diari sobre la \"Obertura de la temporada de bany a la platja\".");

        jLabel303.setText("<html>Ulleres (si són necessàries perquè el pacient llegeixi la tasca)");

        jLabel338.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel338.setText("Procediment");

        jLabel304.setText("<html><p align=\"justify\">Aquesta tasca requereix que el subjecte demostri que sap com utilitzar el telèfon. Els passos a seguir inclouen agafar l'auricular, tocar els botons per marcar el número de telèfon, i parlar pel micròfon de l'auricular. El pacient ha de posar l'auricular al seu lloc i repetir aquesta seqüència en cadascuna de les tasques següents. Les instruccions es donaran una sola vegada, excepte en la tasca de marcar un número de memòria.");

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder("2. Quan el subjecte hagi acabat de llegir, tapi o amagui la targeta i faci les següents preguntes:"));

        jLabel342.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel342.setText("<html>Segons la història que acaba de llegir, com pot arribar a la platja?");

        jLabel309.setText("<html><div style=\"text-align:justify\"><b><u>NOTA A L'AVALUADOR:</b></u> Veure apèndix A per més exemples de respostes apropiades i inapropiades sobre les coses que es poden portar o vestir per passar un dia sencer a la platja.");

        upsaButtonGroup13.add(jToggleButton164);
        jToggleButton164.setSelected(true);
        jToggleButton164.setText("0");

        upsaButtonGroup13.add(jToggleButton165);
        jToggleButton165.setText("1");

        jLabel310.setText("Tren i després autobus");

        jLabel311.setText("<html><i>Respostes acceptables:</i> esports aquàtics, nedar, prendre el sol / bronzejar-se, patinar, jugar a les pales, anar amb bici, Bibliomar, parc saludable.");

        jLabel312.setText("<html><i>Respostes inadequades:</i> beure cervesa, pràctiques de tir ...");

        upsaButtonGroup14.add(jToggleButton170);
        jToggleButton170.setSelected(true);
        jToggleButton170.setText("0");

        jLabel313.setText("Activitat platja 1:");

        upsaButtonGroup14.add(jToggleButton171);
        jToggleButton171.setText("1");

        upsaButtonGroup15.add(jToggleButton172);
        jToggleButton172.setText("1");

        jLabel314.setText("Activitat platja 2:");

        upsaButtonGroup15.add(jToggleButton173);
        jToggleButton173.setSelected(true);
        jToggleButton173.setText("0");

        jLabel343.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel343.setText("Digueu-me dues activitats que vostè pot fer a la platja.");

        jLabel344.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel344.setText("<html>Imagini que pretén passar el dia a la platja. Hi pot haver moltes coses que li agradés portar, però digui <u>CINC</u> coses que són <u>NECESSÀRIES</u> per vestir o portar amb vostè durant tot aquest dóna a la platja");

        jLabel315.setText("<html><i>Respostes acceptables:</i> vestit de bany, loció solar, tovallola, aigua per beure, esmorzar, muda de roba, paraigües, impermeable, etc.");

        jLabel316.setText("(Almenys una resposta ha de reflectir el fet que el temps empitjorarà)");

        jLabel317.setText("Article necessari 1:");

        upsaButtonGroup16.add(jToggleButton174);
        jToggleButton174.setSelected(true);
        jToggleButton174.setText("0");

        upsaButtonGroup16.add(jToggleButton175);
        jToggleButton175.setText("1");

        upsaButtonGroup16.add(jToggleButton176);
        jToggleButton176.setText("2");

        jLabel318.setText("Article necessari 2:");

        upsaButtonGroup17.add(jToggleButton177);
        jToggleButton177.setText("0");

        upsaButtonGroup17.add(jToggleButton178);
        jToggleButton178.setText("1");

        upsaButtonGroup17.add(jToggleButton179);
        jToggleButton179.setText("2");

        jLabel319.setText("Article necessari 3:");

        upsaButtonGroup18.add(jToggleButton180);
        jToggleButton180.setSelected(true);
        jToggleButton180.setText("0");

        upsaButtonGroup18.add(jToggleButton181);
        jToggleButton181.setText("2");

        upsaButtonGroup18.add(jToggleButton182);
        jToggleButton182.setText("1");

        upsaButtonGroup19.add(jToggleButton183);
        jToggleButton183.setSelected(true);
        jToggleButton183.setText("0");

        jLabel322.setText("Article necessari 4:");

        upsaButtonGroup19.add(jToggleButton184);
        jToggleButton184.setText("2");

        upsaButtonGroup19.add(jToggleButton185);
        jToggleButton185.setText("1");

        upsaButtonGroup20.add(jToggleButton186);
        jToggleButton186.setText("2");

        upsaButtonGroup20.add(jToggleButton187);
        jToggleButton187.setText("1");

        jLabel323.setText("Article necessari 5:");

        upsaButtonGroup20.add(jToggleButton188);
        jToggleButton188.setSelected(true);
        jToggleButton188.setText("0");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel309, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel315, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel344, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel342, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel310)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton164)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton165))
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel314)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton173)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton172))
                            .addComponent(jLabel311, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel313)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton170)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton171))
                            .addComponent(jLabel312, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel343, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel316)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel317)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton174)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton175)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton176))
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel318)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton177)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton178)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton179))
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel319)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton180)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton182)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton181))
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel322)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton183)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton185)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton184))
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel323)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton188)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton187)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton186)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel342, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton164)
                    .addComponent(jToggleButton165)
                    .addComponent(jLabel310))
                .addGap(18, 18, 18)
                .addComponent(jLabel343)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel311, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel312, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton170)
                    .addComponent(jToggleButton171)
                    .addComponent(jLabel313))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton173)
                    .addComponent(jToggleButton172)
                    .addComponent(jLabel314))
                .addGap(18, 18, 18)
                .addComponent(jLabel344, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel315, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel316)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton174)
                    .addComponent(jToggleButton175)
                    .addComponent(jLabel317)
                    .addComponent(jToggleButton176))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton177)
                    .addComponent(jToggleButton178)
                    .addComponent(jLabel318)
                    .addComponent(jToggleButton179))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton180)
                    .addComponent(jToggleButton182)
                    .addComponent(jLabel319)
                    .addComponent(jToggleButton181))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton183)
                    .addComponent(jToggleButton185)
                    .addComponent(jLabel322)
                    .addComponent(jToggleButton184))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton188)
                    .addComponent(jToggleButton187)
                    .addComponent(jLabel323)
                    .addComponent(jToggleButton186))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel309, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel345.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel345.setText("Puntuació i duració");

        jLabel320.setText("<html><p align=\"justify\">S'atorgarà un punt per cada resposta correcta i 0 punts per respostes inapropiades. Aquesta tasca dura aproximadament cinc minuts i es puntua en un rang de 0 a 13. En l'últim apartat es puntuaran les cinc activitats que es poden realitzar a la platja com: 2 (resposta correcta), 1 (resposta dubtosa) o 0 (resposta incorrecta).");

        jLabel321.setText("Puntuació total:");

        mocaPunts3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mocaPunts3.setText("0");

        javax.swing.GroupLayout mocaPanel2Layout = new javax.swing.GroupLayout(mocaPanel2);
        mocaPanel2.setLayout(mocaPanel2Layout);
        mocaPanel2Layout.setHorizontalGroup(
            mocaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mocaPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mocaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel285, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel337, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel338, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mocaPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(mocaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel345)
                            .addComponent(jLabel303, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel302, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel304, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mocaPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel321)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mocaPunts3))
                            .addGroup(mocaPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel320, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        mocaPanel2Layout.setVerticalGroup(
            mocaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mocaPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel285)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel337)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel302, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel303, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel338)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel304, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel345)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel320, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(mocaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel321)
                    .addComponent(mocaPunts3))
                .addContainerGap())
        );

        upsaScroll2.setViewportView(mocaPanel2);

        add(upsaScroll2, "card2");

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("<html><center><b>HABILITATS DE COMUNICACIÓ: Telèfon i carta</b>");

        comunicacioPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "2. HABILITAT DE COMUNICACIÓ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        comunicacioPanel.setLayout(new java.awt.GridBagLayout());

        jLabel116.setText("<html><center>Correcte/<br> Incorrecte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 2, 4);
        comunicacioPanel.add(jLabel116, gridBagConstraints);

        jLabel189.setText("Resposta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 2, 50);
        comunicacioPanel.add(jLabel189, gridBagConstraints);

        jLabel196.setText("Marcar nº de memòria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        comunicacioPanel.add(jLabel196, gridBagConstraints);

        jLabel78.setText("Trucada nº emergència");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel78, gridBagConstraints);

        jLabel79.setText("Trucada a casa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        comunicacioPanel.add(jLabel79, gridBagConstraints);

        jLabel80.setText("Missatge apropiat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel80, gridBagConstraints);

        jLabel81.setText("Marcar nº de la carta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel81, gridBagConstraints);

        jLabel82.setText("Nom del pacient");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel82, gridBagConstraints);

        jLabel94.setText("Data cita actual");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel94, gridBagConstraints);

        jLabel103.setText("Data de la nova cita");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel103, gridBagConstraints);

        jLabel197.setText("Nº per tornar la trucada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel197, gridBagConstraints);

        jLabel198.setText("Targeta sanitària");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel198, gridBagConstraints);

        jLabel199.setText("Llista de medicaments");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel199, gridBagConstraints);

        jLabel201.setText("Dejú per extracció");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comunicacioPanel.add(jLabel201, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comunicacioPanel.add(jTextField12, gridBagConstraints);

        comuBtn6.setText("0");
        comuBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn6, gridBagConstraints);

        comuBtn5.setText("0");
        comuBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn5, gridBagConstraints);

        comuBtn4.setText("0");
        comuBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn4, gridBagConstraints);

        comuBtn7.setText("0");
        comuBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn7, gridBagConstraints);

        comuBtn8.setText("0");
        comuBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn8, gridBagConstraints);

        comuBtn9.setText("0");
        comuBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn9, gridBagConstraints);

        comuBtn10.setText("0");
        comuBtn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn10, gridBagConstraints);

        comuBtn11.setText("0");
        comuBtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn11, gridBagConstraints);

        comuBtn12.setText("0");
        comuBtn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn12, gridBagConstraints);

        comuBtn1.setText("0");
        comuBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn1, gridBagConstraints);

        comuBtn2.setText("0");
        comuBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn2, gridBagConstraints);

        comuBtn3.setText("0");
        comuBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comuBtn3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comunicacioPanel.add(comuBtn3, gridBagConstraints);

        comprensioPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "3. COMPRENSÓ / PLANIFICACIÓ Viatge a la platja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        comprensioPanel.setLayout(new java.awt.GridBagLayout());

        comprensioBtn1.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(comprensioBtn1, gridBagConstraints);

        comprensioBtn2.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(comprensioBtn2, gridBagConstraints);

        comprensioBtn3.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(comprensioBtn3, gridBagConstraints);

        upsaButtonGrup21.add(raoBtn21);
        raoBtn21.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(raoBtn21, gridBagConstraints);

        upsaButtonGrup21.add(activitatsDBtn22);
        activitatsDBtn22.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(activitatsDBtn22, gridBagConstraints);

        upsaButtonGrup23.add(cuidatBtn15);
        cuidatBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(cuidatBtn15, gridBagConstraints);

        jLabel166.setText("Correcte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        comprensioPanel.add(jLabel166, gridBagConstraints);

        jLabel190.setText("Dubtós");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        comprensioPanel.add(jLabel190, gridBagConstraints);

        jLabel191.setText("Resposta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 2, 50);
        comprensioPanel.add(jLabel191, gridBagConstraints);

        jLabel83.setText("Com arribar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comprensioPanel.add(jLabel83, gridBagConstraints);

        jLabel84.setText("Activitat a la platja 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        comprensioPanel.add(jLabel84, gridBagConstraints);

        jLabel85.setText("Activitat a la platja 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comprensioPanel.add(jLabel85, gridBagConstraints);

        jLabel86.setText("Article necessari 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comprensioPanel.add(jLabel86, gridBagConstraints);

        jLabel192.setText("Article necessari 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comprensioPanel.add(jLabel192, gridBagConstraints);

        jLabel193.setText("Article necessari 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comprensioPanel.add(jLabel193, gridBagConstraints);

        jLabel194.setText("Article necessari 4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comprensioPanel.add(jLabel194, gridBagConstraints);

        jLabel202.setText("Article necessari 5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        comprensioPanel.add(jLabel202, gridBagConstraints);

        upsaButtonGrup22.add(jToggleButton118);
        jToggleButton118.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton118, gridBagConstraints);

        upsaButtonGrup22.add(jToggleButton122);
        jToggleButton122.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton122, gridBagConstraints);

        upsaButtonGrup23.add(jToggleButton134);
        jToggleButton134.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton134, gridBagConstraints);

        upsaButtonGrup24.add(jToggleButton138);
        jToggleButton138.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton138, gridBagConstraints);

        upsaButtonGrup24.add(jToggleButton142);
        jToggleButton142.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton142, gridBagConstraints);

        upsaButtonGrup25.add(jToggleButton146);
        jToggleButton146.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton146, gridBagConstraints);

        upsaButtonGrup25.add(jToggleButton147);
        jToggleButton147.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton147, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField16, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField17, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField18, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField19, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField20, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        comprensioPanel.add(jTextField24, gridBagConstraints);

        jLabel195.setText("Incorrecte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        comprensioPanel.add(jLabel195, gridBagConstraints);

        jLabel206.setText("<html><center>Correcte/<br> Incorrecte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        comprensioPanel.add(jLabel206, gridBagConstraints);

        upsaButtonGrup21.add(activitatsDBtn25);
        activitatsDBtn25.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(activitatsDBtn25, gridBagConstraints);

        upsaButtonGrup22.add(jToggleButton150);
        jToggleButton150.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton150, gridBagConstraints);

        upsaButtonGrup23.add(jToggleButton151);
        jToggleButton151.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton151, gridBagConstraints);

        upsaButtonGrup24.add(jToggleButton152);
        jToggleButton152.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton152, gridBagConstraints);

        upsaButtonGrup25.add(jToggleButton153);
        jToggleButton153.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        comprensioPanel.add(jToggleButton153, gridBagConstraints);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FULL DE RESUM DE PUNTUACIÓ DE LA Sp-UPSA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel25.setLayout(new java.awt.GridBagLayout());

        jLabel200.setText("<html><center>Puntuació<br>total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 5);
        jPanel25.add(jLabel200, gridBagConstraints);

        jLabel203.setText("<html><center> Puntuació<br>subescala");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 5);
        jPanel25.add(jLabel203, gridBagConstraints);

        jLabel204.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel204, gridBagConstraints);

        jLabel140.setText("Domini");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel140, gridBagConstraints);

        jLabel205.setText("Comunicació");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel205, gridBagConstraints);

        jLabel207.setText("<html>Comprensió/<br>Planificació");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel207, gridBagConstraints);

        jLabel208.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel208, gridBagConstraints);

        jLabel209.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel209, gridBagConstraints);

        jLabel210.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel210, gridBagConstraints);

        jLabel211.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel211, gridBagConstraints);

        jLabel212.setText("÷");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel212, gridBagConstraints);

        jLabel214.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel214, gridBagConstraints);

        jLabel215.setText("=");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 0);
        jPanel25.add(jLabel215, gridBagConstraints);

        jLabel216.setText("÷ 13");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel216, gridBagConstraints);

        jLabel218.setText("<html><center>Puntuació total<br>UPSA<br><font color=\"red\">Rang 0 - 50");
        jLabel218.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 5);
        jPanel25.add(jLabel218, gridBagConstraints);

        jLabel219.setText("X25");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel219, gridBagConstraints);

        jLabel221.setText("X 25");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        jPanel25.add(jLabel221, gridBagConstraints);

        jLabel223.setText("X 25");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel25.add(jLabel223, gridBagConstraints);

        jLabel226.setText("=");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 0);
        jPanel25.add(jLabel226, gridBagConstraints);

        jLabel227.setText("=");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 0);
        jPanel25.add(jLabel227, gridBagConstraints);

        jLabel228.setText("÷ 12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        jPanel25.add(jLabel228, gridBagConstraints);

        jLabel230.setText("<html><center>Percentatge<br>correcte(%)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 5);
        jPanel25.add(jLabel230, gridBagConstraints);

        comunicacioTotal.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel25.add(comunicacioTotal, gridBagConstraints);

        comprensioTotal.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        jPanel25.add(comprensioTotal, gridBagConstraints);

        comunicacioPercent.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        jPanel25.add(comunicacioPercent, gridBagConstraints);

        comprensioPercent.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        jPanel25.add(comprensioPercent, gridBagConstraints);

        comunicacioSub.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        jPanel25.add(comunicacioSub, gridBagConstraints);

        comprensioSub.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        jPanel25.add(comprensioSub, gridBagConstraints);

        upsaTotal.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        jPanel25.add(upsaTotal, gridBagConstraints);

        javax.swing.GroupLayout upsa2PanelLayout = new javax.swing.GroupLayout(upsa2Panel);
        upsa2Panel.setLayout(upsa2PanelLayout);
        upsa2PanelLayout.setHorizontalGroup(
            upsa2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upsa2PanelLayout.createSequentialGroup()
                .addGroup(upsa2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(upsa2PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(upsa2PanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(comunicacioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comprensioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        upsa2PanelLayout.setVerticalGroup(
            upsa2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upsa2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(upsa2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comunicacioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comprensioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        upsaScroll3.setViewportView(upsa2Panel);

        add(upsaScroll3, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void comuBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn6ActionPerformed

    private void comuBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn5ActionPerformed

    private void comuBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn4ActionPerformed

    private void comuBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn7ActionPerformed

    private void comuBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn8ActionPerformed

    private void comuBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn9ActionPerformed

    private void comuBtn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn10ActionPerformed

    private void comuBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn11ActionPerformed

    private void comuBtn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn12ActionPerformed

    private void comuBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn1ActionPerformed

    private void comuBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn2ActionPerformed

    private void comuBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comuBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comuBtn3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton activitatsDBtn22;
    private javax.swing.JToggleButton activitatsDBtn25;
    private javax.swing.JToggleButton comprensioBtn1;
    private javax.swing.JToggleButton comprensioBtn2;
    private javax.swing.JToggleButton comprensioBtn3;
    private javax.swing.JPanel comprensioPanel;
    private javax.swing.JLabel comprensioPercent;
    private javax.swing.JLabel comprensioSub;
    private javax.swing.JLabel comprensioTotal;
    private javax.swing.JToggleButton comuBtn1;
    private javax.swing.JToggleButton comuBtn10;
    private javax.swing.JToggleButton comuBtn11;
    private javax.swing.JToggleButton comuBtn12;
    private javax.swing.JToggleButton comuBtn2;
    private javax.swing.JToggleButton comuBtn3;
    private javax.swing.JToggleButton comuBtn4;
    private javax.swing.JToggleButton comuBtn5;
    private javax.swing.JToggleButton comuBtn6;
    private javax.swing.JToggleButton comuBtn7;
    private javax.swing.JToggleButton comuBtn8;
    private javax.swing.JToggleButton comuBtn9;
    private javax.swing.JPanel comunicacioPanel;
    private javax.swing.JLabel comunicacioPercent;
    private javax.swing.JLabel comunicacioSub;
    private javax.swing.JLabel comunicacioTotal;
    private javax.swing.JToggleButton cuidatBtn15;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel328;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel334;
    private javax.swing.JLabel jLabel335;
    private javax.swing.JLabel jLabel336;
    private javax.swing.JLabel jLabel337;
    private javax.swing.JLabel jLabel338;
    private javax.swing.JLabel jLabel342;
    private javax.swing.JLabel jLabel343;
    private javax.swing.JLabel jLabel344;
    private javax.swing.JLabel jLabel345;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton102;
    private javax.swing.JToggleButton jToggleButton106;
    private javax.swing.JToggleButton jToggleButton108;
    private javax.swing.JToggleButton jToggleButton110;
    private javax.swing.JToggleButton jToggleButton112;
    private javax.swing.JToggleButton jToggleButton114;
    private javax.swing.JToggleButton jToggleButton118;
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
    private javax.swing.JToggleButton jToggleButton164;
    private javax.swing.JToggleButton jToggleButton165;
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
    private javax.swing.JToggleButton jToggleButton31;
    private javax.swing.JToggleButton jToggleButton32;
    private javax.swing.JToggleButton jToggleButton33;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JToggleButton jToggleButton60;
    private javax.swing.JToggleButton jToggleButton64;
    private javax.swing.JToggleButton jToggleButton68;
    private javax.swing.JToggleButton jToggleButton72;
    private javax.swing.JToggleButton jToggleButton76;
    private javax.swing.JToggleButton jToggleButton80;
    private javax.swing.JToggleButton jToggleButton91;
    private javax.swing.JToggleButton jToggleButton98;
    private javax.swing.JPanel mocaPanel1;
    private javax.swing.JPanel mocaPanel2;
    private javax.swing.JLabel mocaPunts2;
    private javax.swing.JLabel mocaPunts3;
    private javax.swing.JToggleButton raoBtn21;
    private javax.swing.JPanel upsa2Panel;
    private javax.swing.ButtonGroup upsaButtonGroup1;
    private javax.swing.ButtonGroup upsaButtonGroup10;
    private javax.swing.ButtonGroup upsaButtonGroup11;
    private javax.swing.ButtonGroup upsaButtonGroup12;
    private javax.swing.ButtonGroup upsaButtonGroup13;
    private javax.swing.ButtonGroup upsaButtonGroup14;
    private javax.swing.ButtonGroup upsaButtonGroup15;
    private javax.swing.ButtonGroup upsaButtonGroup16;
    private javax.swing.ButtonGroup upsaButtonGroup17;
    private javax.swing.ButtonGroup upsaButtonGroup18;
    private javax.swing.ButtonGroup upsaButtonGroup19;
    private javax.swing.ButtonGroup upsaButtonGroup2;
    private javax.swing.ButtonGroup upsaButtonGroup20;
    private javax.swing.ButtonGroup upsaButtonGroup3;
    private javax.swing.ButtonGroup upsaButtonGroup4;
    private javax.swing.ButtonGroup upsaButtonGroup5;
    private javax.swing.ButtonGroup upsaButtonGroup6;
    private javax.swing.ButtonGroup upsaButtonGroup7;
    private javax.swing.ButtonGroup upsaButtonGroup8;
    private javax.swing.ButtonGroup upsaButtonGroup9;
    private javax.swing.ButtonGroup upsaButtonGrup21;
    private javax.swing.ButtonGroup upsaButtonGrup22;
    private javax.swing.ButtonGroup upsaButtonGrup23;
    private javax.swing.ButtonGroup upsaButtonGrup24;
    private javax.swing.ButtonGroup upsaButtonGrup25;
    private javax.swing.JScrollPane upsaScroll1;
    private javax.swing.JScrollPane upsaScroll2;
    private javax.swing.JScrollPane upsaScroll3;
    private javax.swing.JLabel upsaTotal;
    // End of variables declaration//GEN-END:variables
}
