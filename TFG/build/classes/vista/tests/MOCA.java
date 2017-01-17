/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import controlador.Utils;
import model.Pacient;

/**
 *
 * @author a630703
 */
public class MOCA extends Test {

    /**
     * Creates new form Moca
     * @param pacientActual
     */
    public MOCA(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "MOCA";
        numPaginesTotal = this.getComponentCount();
        
        initMoca();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // MOCA
        Utils.setProperty(prop,"puntTotalMoca1",puntTotalMoca1);
    }

    private void initMoca() {
        
        if (pacientActual.getAnysEscola() < 11){
            puntTotalMoca1.setText("1");
        }
        
        this.checkVisuoEspacial1.addActionListener(createMocaActionListener(puntVisuo));
        this.checkVisuoEspacial2.addActionListener(createMocaActionListener(puntVisuo));
        this.checkVisuoEspacial3.addActionListener(createMocaActionListener(puntVisuo));
        this.checkVisuoEspacial4.addActionListener(createMocaActionListener(puntVisuo));
        this.checkVisuoEspacial5.addActionListener(createMocaActionListener(puntVisuo));
        
        this.checkIdentificacio1.addActionListener(createMocaActionListener(puntIdentificacio));
        this.checkIdentificacio2.addActionListener(createMocaActionListener(puntIdentificacio));
        this.checkIdentificacio3.addActionListener(createMocaActionListener(puntIdentificacio));
        
        this.checkAtencio1.addActionListener(createMocaActionListener(puntAtencio1));
        this.checkAtencio2.addActionListener(createMocaActionListener(puntAtencio1));
        
        this.checkAtencio3.addActionListener(createMocaActionListener(puntAtencio2));
        
        ActionListener actionListenerAtencio3 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int puntInicial = Integer.parseInt(puntAtencio3.getText());
                int count = 0;
                JCheckBox jCheckBox = (JCheckBox) actionEvent.getSource();
                if (checkAtencio4.isSelected()){
                    count++;
                }
                if (checkAtencio5.isSelected()){
                    count++;
                }
                if (checkAtencio6.isSelected()){
                    count++;
                }
                if (checkAtencio7.isSelected()){
                    count++;
                }
                if (checkAtencio8.isSelected()){
                    count++;
                }
                
                if (count == 0){
                    puntAtencio3.setText("0");
                    puntTotalMoca1.setText((Integer.parseInt(puntTotalMoca1.getText())-puntInicial)+"");
                }else if (count == 1){
                    puntAtencio3.setText("1");
                    puntTotalMoca1.setText((Integer.parseInt(puntTotalMoca1.getText())+(1-puntInicial))+"");
                } else if (count < 4){
                    puntAtencio3.setText("2");
                    puntTotalMoca1.setText((Integer.parseInt(puntTotalMoca1.getText())+(2-puntInicial))+"");
                } else {
                    puntAtencio3.setText("3");
                    puntTotalMoca1.setText((Integer.parseInt(puntTotalMoca1.getText())+(3-puntInicial))+"");
                }
            }
        };
        
        this.checkAtencio4.addActionListener(actionListenerAtencio3);
        this.checkAtencio5.addActionListener(actionListenerAtencio3);
        this.checkAtencio6.addActionListener(actionListenerAtencio3);
        this.checkAtencio7.addActionListener(actionListenerAtencio3);
        this.checkAtencio8.addActionListener(actionListenerAtencio3);
        
        this.checkLlenguatge1.addActionListener(createMocaActionListener(puntLlenguatge1));
        this.checkLlenguatge2.addActionListener(createMocaActionListener(puntLlenguatge1));
        
        this.checkLlenguatge3.addActionListener(createMocaActionListener(puntLlenguatge2));
        
        this.checkAbstraccio1.addActionListener(createMocaActionListener(puntAbstraccio));
        this.checkAbstraccio2.addActionListener(createMocaActionListener(puntAbstraccio));
        
        this.checkRecord1.addActionListener(createMocaActionListener(puntRecord));
        this.checkRecord2.addActionListener(createMocaActionListener(puntRecord));
        this.checkRecord3.addActionListener(createMocaActionListener(puntRecord));
        this.checkRecord4.addActionListener(createMocaActionListener(puntRecord));
        this.checkRecord5.addActionListener(createMocaActionListener(puntRecord));
        
        this.checkOrientacio1.addActionListener(createMocaActionListener(puntOrientacio));
        this.checkOrientacio2.addActionListener(createMocaActionListener(puntOrientacio));
        this.checkOrientacio3.addActionListener(createMocaActionListener(puntOrientacio));
        this.checkOrientacio4.addActionListener(createMocaActionListener(puntOrientacio));
        this.checkOrientacio5.addActionListener(createMocaActionListener(puntOrientacio));
        this.checkOrientacio6.addActionListener(createMocaActionListener(puntOrientacio));
    }

    private ActionListener createMocaActionListener(JLabel jLabel) {
        
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JCheckBox jCheckBox = (JCheckBox) actionEvent.getSource();
                if (jCheckBox.isSelected()){
                    jLabel.setText((Integer.parseInt(jLabel.getText())+1)+"");
                    puntTotalMoca1.setText((Integer.parseInt(puntTotalMoca1.getText())+1)+"");
                } else {
                    jLabel.setText((Integer.parseInt(jLabel.getText())-1)+"");
                    puntTotalMoca1.setText((Integer.parseInt(puntTotalMoca1.getText())-1)+"");
                }
            }
        };
        
        return actionListener;
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

        mocaScroll = new javax.swing.JScrollPane();
        mocaPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        checkVisuoEspacial1 = new javax.swing.JCheckBox();
        jLabel224 = new javax.swing.JLabel();
        checkVisuoEspacial2 = new javax.swing.JCheckBox();
        checkVisuoEspacial3 = new javax.swing.JCheckBox();
        checkVisuoEspacial4 = new javax.swing.JCheckBox();
        checkVisuoEspacial5 = new javax.swing.JCheckBox();
        jLabel232 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        puntVisuo = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        checkIdentificacio1 = new javax.swing.JCheckBox();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        checkIdentificacio3 = new javax.swing.JCheckBox();
        checkIdentificacio2 = new javax.swing.JCheckBox();
        jLabel234 = new javax.swing.JLabel();
        puntIdentificacio = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel225 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        checkAtencio1 = new javax.swing.JCheckBox();
        checkAtencio2 = new javax.swing.JCheckBox();
        jLabel247 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        puntAtencio1 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel253 = new javax.swing.JLabel();
        checkAtencio3 = new javax.swing.JCheckBox();
        jLabel256 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        puntAtencio2 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        checkAtencio4 = new javax.swing.JCheckBox();
        jLabel259 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        puntAtencio3 = new javax.swing.JLabel();
        checkAtencio5 = new javax.swing.JCheckBox();
        checkAtencio6 = new javax.swing.JCheckBox();
        checkAtencio7 = new javax.swing.JCheckBox();
        checkAtencio8 = new javax.swing.JCheckBox();
        jLabel254 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        checkLlenguatge1 = new javax.swing.JCheckBox();
        checkLlenguatge2 = new javax.swing.JCheckBox();
        jLabel248 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        puntLlenguatge1 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        puntLlenguatge2 = new javax.swing.JLabel();
        checkLlenguatge3 = new javax.swing.JCheckBox();
        jTextField54 = new javax.swing.JTextField();
        jLabel255 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel262 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jTextField64 = new javax.swing.JTextField();
        jLabel275 = new javax.swing.JLabel();
        checkRecord1 = new javax.swing.JCheckBox();
        checkRecord5 = new javax.swing.JCheckBox();
        checkRecord4 = new javax.swing.JCheckBox();
        checkRecord3 = new javax.swing.JCheckBox();
        checkRecord2 = new javax.swing.JCheckBox();
        jLabel270 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        puntRecord = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        checkOrientacio1 = new javax.swing.JCheckBox();
        checkOrientacio2 = new javax.swing.JCheckBox();
        checkOrientacio3 = new javax.swing.JCheckBox();
        checkOrientacio4 = new javax.swing.JCheckBox();
        checkOrientacio5 = new javax.swing.JCheckBox();
        checkOrientacio6 = new javax.swing.JCheckBox();
        jLabel272 = new javax.swing.JLabel();
        puntOrientacio = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel308 = new javax.swing.JLabel();
        puntTotalMoca1 = new javax.swing.JLabel();
        jLabel325 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        checkAbstraccio1 = new javax.swing.JCheckBox();
        checkAbstraccio2 = new javax.swing.JCheckBox();
        jLabel273 = new javax.swing.JLabel();
        puntAbstraccio = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("MONTREAL COGNITIVE ASSESSMENT (MoCA)");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VISUOESPACIAL / EXECUTIVA ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/moca1.png"))); // NOI18N

        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/moca2.png"))); // NOI18N

        checkVisuoEspacial3.setText("Contorn");

        checkVisuoEspacial4.setText("Números");

        checkVisuoEspacial5.setText("Agulles");

        jLabel232.setText("<html><b>Dibuixar un rellotge</b> (onze i deu)");

        jLabel229.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel229.setText("Punts:");

        puntVisuo.setText("0");

        jLabel233.setText("/ 5");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel222)
                        .addGap(4, 4, 4)
                        .addComponent(checkVisuoEspacial1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel224)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkVisuoEspacial2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(checkVisuoEspacial3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkVisuoEspacial4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkVisuoEspacial5))
                            .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel229)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntVisuo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel233)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkVisuoEspacial3)
                            .addComponent(checkVisuoEspacial4)
                            .addComponent(checkVisuoEspacial5)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkVisuoEspacial1)
                            .addComponent(jLabel222)
                            .addComponent(jLabel224)
                            .addComponent(checkVisuoEspacial2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel229)
                    .addComponent(puntVisuo)
                    .addComponent(jLabel233))
                .addContainerGap())
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IDENTIFICACIÓ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/moca3.png"))); // NOI18N

        jLabel236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/moca4.png"))); // NOI18N

        jLabel237.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/moca5.png"))); // NOI18N

        jLabel234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel234.setText("Punts:");

        puntIdentificacio.setText("0");

        jLabel239.setText("/ 3");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel235)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkIdentificacio1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel236)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkIdentificacio2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel237)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkIdentificacio3))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel234)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntIdentificacio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel239)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkIdentificacio3)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel237)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel236)
                            .addComponent(checkIdentificacio1)
                            .addComponent(jLabel235)
                            .addComponent(checkIdentificacio2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel234)
                    .addComponent(puntIdentificacio)
                    .addComponent(jLabel239))
                .addContainerGap())
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MEMÒRIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel26.setLayout(new java.awt.GridBagLayout());

        jLabel225.setText("1er intent");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel26.add(jLabel225, gridBagConstraints);

        jLabel240.setText("<html>Llegeix la llista de paraules, el pacient ha de repetir-les.<br>Fagi dos intents.<br>Recordi-les 5 minuts més tard.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        jPanel26.add(jLabel240, gridBagConstraints);

        jLabel241.setText("2n intent");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel26.add(jLabel241, gridBagConstraints);

        jLabel242.setText("ROSTRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanel26.add(jLabel242, gridBagConstraints);

        jLabel243.setText("SEDA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
        jPanel26.add(jLabel243, gridBagConstraints);

        jLabel244.setText("ESGLÉSIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        jPanel26.add(jLabel244, gridBagConstraints);

        jLabel245.setText("VERMELL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanel26.add(jLabel245, gridBagConstraints);

        jLabel246.setText("CLAVELL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanel26.add(jLabel246, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField39, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField40, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField41, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField42, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField43, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField44, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField45, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField46, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField47, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel26.add(jTextField48, gridBagConstraints);

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ATENCIÓ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Llegeixi la sèrie de números (1 núm/seg)"));

        jLabel249.setText("El pacient ha de repetir-la");

        jLabel250.setText("El pacient ha de repetir-la a l'inversa");

        checkAtencio1.setText("2 1 8 5 4");

        checkAtencio2.setText("7 4 2");

        jLabel247.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel247.setText("Punts:");

        jLabel251.setText("/ 2");

        puntAtencio1.setText("0");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel250)
                    .addComponent(jLabel249))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(checkAtencio2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel247)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntAtencio1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel251)
                        .addGap(255, 255, 255))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(checkAtencio1)
                        .addGap(333, 333, 333))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel249)
                    .addComponent(checkAtencio1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel247)
                        .addComponent(puntAtencio1)
                        .addComponent(jLabel251))
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel250)
                        .addComponent(checkAtencio2)))
                .addContainerGap())
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Llegeixi la sèrie de lletres."));

        jLabel253.setText("El pacient ha de fer un cop amb la ma cada vegada que es digui la lletra A. No s'assignen punts si >= 2 errors.");

        checkAtencio3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAtencio3.setText("FBACMNAAJKLBAFAKDEAAAJAMOFAAB");

        jLabel256.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel256.setText("Punts:");

        jLabel257.setText("/ 1");

        puntAtencio2.setText("0");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel253)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(checkAtencio3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel256)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntAtencio2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel257)
                        .addGap(53, 53, 53))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel253)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel256)
                        .addComponent(puntAtencio2)
                        .addComponent(jLabel257))
                    .addComponent(checkAtencio3))
                .addContainerGap())
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Restar de 7 en 7 començant des de 100."));

        checkAtencio4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAtencio4.setText("93");

        jLabel259.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel259.setText("Punts:");

        jLabel260.setText("/ 3");

        puntAtencio3.setText("0");

        checkAtencio5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAtencio5.setText("86");

        checkAtencio6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAtencio6.setText("79");

        checkAtencio7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAtencio7.setText("72");

        checkAtencio8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAtencio8.setText("65");

        jLabel254.setText("<html>4 o 5 substraccions correctes: <b>3 punts</b>, 2 o 3 correctes: <b>2 punts</b>, 1 correcta: <b>1 punt</b>, 0 correctes: <b>0 punts</b>.");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel254, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(checkAtencio4)
                        .addGap(18, 18, 18)
                        .addComponent(checkAtencio5)
                        .addGap(18, 18, 18)
                        .addComponent(checkAtencio6)
                        .addGap(18, 18, 18)
                        .addComponent(checkAtencio7)
                        .addGap(18, 18, 18)
                        .addComponent(checkAtencio8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel259)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntAtencio3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel260)
                        .addGap(43, 43, 43))))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkAtencio4)
                    .addComponent(checkAtencio5)
                    .addComponent(checkAtencio6)
                    .addComponent(checkAtencio7)
                    .addComponent(checkAtencio8)
                    .addComponent(jLabel259)
                    .addComponent(puntAtencio3)
                    .addComponent(jLabel260))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel254, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LLENGUATGE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Repetir:"));

        checkLlenguatge1.setText("El gat s'amaga sota el sofà quan els gossos entren a la sala.");
        checkLlenguatge1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        checkLlenguatge2.setText("Espero que ell li lliuri el missatge quan ella li ho demani.");
        checkLlenguatge2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel248.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel248.setText("Punts:");

        jLabel263.setText("/ 2");

        puntLlenguatge1.setText("0");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(checkLlenguatge1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(checkLlenguatge2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel248)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntLlenguatge1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel263)
                        .addGap(53, 53, 53))))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkLlenguatge1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel248)
                        .addComponent(puntLlenguatge1)
                        .addComponent(jLabel263))
                    .addComponent(checkLlenguatge2))
                .addGap(17, 17, 17))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder("Fluïdesa del llenguatge."));

        jLabel266.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel266.setText("Punts:");

        jLabel267.setText("/ 1");

        puntLlenguatge2.setText("0");

        checkLlenguatge3.setText("Dir el major nombre de paraules que comencin per la lletra \"P\" en 1 minut.");
        checkLlenguatge3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel255.setText("(N >= 11 paraules)");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel266)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntLlenguatge2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel267)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(checkLlenguatge3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel255)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkLlenguatge3)
                    .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel255))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel266)
                    .addComponent(puntLlenguatge2)
                    .addComponent(jLabel267))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECORD DIFERIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel34.setLayout(new java.awt.GridBagLayout());

        jLabel262.setText("Pista de categoria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel34.add(jLabel262, gridBagConstraints);

        jLabel265.setText("Optatiu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        jPanel34.add(jLabel265, gridBagConstraints);

        jLabel269.setText("Pista elecció múltiple");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel34.add(jLabel269, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField55, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField56, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField57, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField58, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField59, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField60, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField61, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField62, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField63, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel34.add(jTextField64, gridBagConstraints);

        jLabel275.setText("<html><CENTER>Ha de recordar-se de les paraules<br>SENSE PISTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel34.add(jLabel275, gridBagConstraints);

        checkRecord1.setText("ROSTRE");
        checkRecord1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkRecord1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel34.add(checkRecord1, gridBagConstraints);

        checkRecord5.setText("VERMELL");
        checkRecord5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkRecord5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel34.add(checkRecord5, gridBagConstraints);

        checkRecord4.setText("CLAVELL");
        checkRecord4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkRecord4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel34.add(checkRecord4, gridBagConstraints);

        checkRecord3.setText("ESGLÉSIA");
        checkRecord3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkRecord3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel34.add(checkRecord3, gridBagConstraints);

        checkRecord2.setText("SEDA");
        checkRecord2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkRecord2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        jPanel34.add(checkRecord2, gridBagConstraints);

        jLabel270.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel270.setText("Punts: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        jPanel34.add(jLabel270, gridBagConstraints);

        jLabel271.setText("<HTML>Punts per<br>records<br>SENSE PISTES<br>únicament");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel34.add(jLabel271, gridBagConstraints);

        puntRecord.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        jPanel34.add(puntRecord, gridBagConstraints);

        jLabel301.setText(" / 5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        jPanel34.add(jLabel301, gridBagConstraints);

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ORIENTACIÓ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        checkOrientacio1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkOrientacio1.setText("<html>Dia del mes<br>(data)");

        checkOrientacio2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkOrientacio2.setText("Mes");

        checkOrientacio3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkOrientacio3.setText("Any");

        checkOrientacio4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkOrientacio4.setText("<html>Dia de la<br>setmana");

        checkOrientacio5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkOrientacio5.setText("Lloc");

        checkOrientacio6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkOrientacio6.setText("Localitat");

        jLabel272.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel272.setText("Punts:");

        puntOrientacio.setText("0");

        jLabel274.setText("/ 6");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel272)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntOrientacio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel274)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(checkOrientacio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkOrientacio2)
                        .addGap(18, 18, 18)
                        .addComponent(checkOrientacio3)
                        .addGap(18, 18, 18)
                        .addComponent(checkOrientacio4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkOrientacio5)
                        .addGap(18, 18, 18)
                        .addComponent(checkOrientacio6)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOrientacio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOrientacio2)
                    .addComponent(checkOrientacio3)
                    .addComponent(checkOrientacio4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOrientacio5)
                    .addComponent(checkOrientacio6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel272)
                    .addComponent(puntOrientacio)
                    .addComponent(jLabel274))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel308.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel308.setText("TOTAL:");

        puntTotalMoca1.setText("0");

        jLabel325.setText("/ 30");

        jLabel231.setText("(1 punt més si te < 11 anys d'estudi)");

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ABSTRACCIÓ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        checkAbstraccio1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAbstraccio1.setText("<html>tren-bicicleta");

        checkAbstraccio2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkAbstraccio2.setText("rellotge-regle");

        jLabel273.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel273.setText("Punts:");

        puntAbstraccio.setText("0");

        jLabel300.setText("/ 2");

        jLabel74.setText("Similitud entre p. ex. poma-taronja = fruita");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel273)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(puntAbstraccio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel300))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(checkAbstraccio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkAbstraccio2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkAbstraccio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAbstraccio2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel273)
                    .addComponent(puntAbstraccio)
                    .addComponent(jLabel300))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mocaPanelLayout = new javax.swing.GroupLayout(mocaPanel);
        mocaPanel.setLayout(mocaPanelLayout);
        mocaPanelLayout.setHorizontalGroup(
            mocaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mocaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mocaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mocaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel308)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntTotalMoca1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel325)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel231))
                    .addGroup(mocaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mocaPanelLayout.setVerticalGroup(
            mocaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mocaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mocaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel308)
                    .addComponent(puntTotalMoca1)
                    .addComponent(jLabel325)
                    .addComponent(jLabel231))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mocaScroll.setViewportView(mocaPanel);

        add(mocaScroll, "card1");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkAbstraccio1;
    private javax.swing.JCheckBox checkAbstraccio2;
    private javax.swing.JCheckBox checkAtencio1;
    private javax.swing.JCheckBox checkAtencio2;
    private javax.swing.JCheckBox checkAtencio3;
    private javax.swing.JCheckBox checkAtencio4;
    private javax.swing.JCheckBox checkAtencio5;
    private javax.swing.JCheckBox checkAtencio6;
    private javax.swing.JCheckBox checkAtencio7;
    private javax.swing.JCheckBox checkAtencio8;
    private javax.swing.JCheckBox checkIdentificacio1;
    private javax.swing.JCheckBox checkIdentificacio2;
    private javax.swing.JCheckBox checkIdentificacio3;
    private javax.swing.JCheckBox checkLlenguatge1;
    private javax.swing.JCheckBox checkLlenguatge2;
    private javax.swing.JCheckBox checkLlenguatge3;
    private javax.swing.JCheckBox checkOrientacio1;
    private javax.swing.JCheckBox checkOrientacio2;
    private javax.swing.JCheckBox checkOrientacio3;
    private javax.swing.JCheckBox checkOrientacio4;
    private javax.swing.JCheckBox checkOrientacio5;
    private javax.swing.JCheckBox checkOrientacio6;
    private javax.swing.JCheckBox checkRecord1;
    private javax.swing.JCheckBox checkRecord2;
    private javax.swing.JCheckBox checkRecord3;
    private javax.swing.JCheckBox checkRecord4;
    private javax.swing.JCheckBox checkRecord5;
    private javax.swing.JCheckBox checkVisuoEspacial1;
    private javax.swing.JCheckBox checkVisuoEspacial2;
    private javax.swing.JCheckBox checkVisuoEspacial3;
    private javax.swing.JCheckBox checkVisuoEspacial4;
    private javax.swing.JCheckBox checkVisuoEspacial5;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JPanel mocaPanel;
    private javax.swing.JScrollPane mocaScroll;
    private javax.swing.JLabel puntAbstraccio;
    private javax.swing.JLabel puntAtencio1;
    private javax.swing.JLabel puntAtencio2;
    private javax.swing.JLabel puntAtencio3;
    private javax.swing.JLabel puntIdentificacio;
    private javax.swing.JLabel puntLlenguatge1;
    private javax.swing.JLabel puntLlenguatge2;
    private javax.swing.JLabel puntOrientacio;
    private javax.swing.JLabel puntRecord;
    private javax.swing.JLabel puntTotalMoca1;
    private javax.swing.JLabel puntVisuo;
    // End of variables declaration//GEN-END:variables
}
