/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.Utils;
import java.awt.CardLayout;
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
import javax.swing.Timer;
import model.Pacient;
import vista.Sessio1;

/**
 *
 * @author a630703
 */
public class FiveDigit extends Test {

    private Timer fdtimer;
    private long fdstartTime;
    DecimalFormat timeFormatter;
    JButton[] llistaBtn5digits;

    /**
     * Creates new form FiveDigit
     * @param pacientActual
     */
    public FiveDigit(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "FIVE DIGIT";

        numPaginesTotal = this.getComponentCount();

        initTimer();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // Five digit
        Utils.setProperty(prop,"lecturaTemps",fdlecturaTemps);
        Utils.setProperty(prop,"lecturaTempsPCField",fdlecturaTempsPCField);
        Utils.setProperty(prop,"lecturaErrorsField",fdlecturaErrors);
        Utils.setProperty(prop,"lecturaErrorsPCField",fdlecturaErrorsPCField);
        // Five digit
        Utils.setProperty(prop,"compteigTemps",fdcompteigTemps);
        Utils.setProperty(prop,"compteigTempsPCField",fdcompteigTempsPCField);
        Utils.setProperty(prop,"compteigErrors",fdcompteigErrors);
        Utils.setProperty(prop,"compteigErrorsPCField",fdfdfd);
        // Five digit
        Utils.setProperty(prop,"eleccioTemps",fdeleccioTemps);
        Utils.setProperty(prop,"eleccioTempsPCField",fdeleccioTempsPCField);
        Utils.setProperty(prop,"eleccioErrorsField",fdeleccioErrors);
        Utils.setProperty(prop,"eleccioErrorsPCField",fdeleccioErrorsPCField);
        // Five digit
        Utils.setProperty(prop,"alternTemps",fdalternTemps);
        Utils.setProperty(prop,"alternTempsPCField",fdalternTempsPCField);
        Utils.setProperty(prop,"alternErrors",fdalternErrors);
        Utils.setProperty(prop,"alternErrorsPCField",fdalternErrorsPCField);
        // Five digit
        Utils.setProperty(prop,"inhibicioPCField",fdinhibicioPCField);
        Utils.setProperty(prop,"flexibilitatPCField",fdflexibilitatPCField);
    }

    @Override
    public void paginaSeguent(){
        if (fdtimer.isRunning()){
            fdtimer.stop();
        }
        CardLayout card = (CardLayout)this.getLayout();
        pagina++;
        card.show(this, "card"+(pagina));

        String error;
        switch (pagina) {
            case 2:
            {
                int err1 = (!fdlecturaError1.getText().equals("")) ? Integer.parseInt(fdlecturaError1.getText()) : 0;
                int err2 = (!fdlecturaError2.getText().equals("")) ? Integer.parseInt(fdlecturaError2.getText()) : 0;
                error = err1 + err2 + "";
                fdlecturaErrors.setText(error);
                break;
            }
            case 3:
            {
                int err1 = (!fdcompteigError1.getText().equals("")) ? Integer.parseInt(fdcompteigError1.getText()) : 0;
                int err2 = (!fdcompteigError2.getText().equals("")) ? Integer.parseInt(fdcompteigError2.getText()) : 0;
                error = err1 + err2 + "";
                fdcompteigErrors.setText(error);
                break;
            }
            case 4:
            {
                int err1 = (!fdeleccioError1.getText().equals("")) ? Integer.parseInt(fdeleccioError1.getText()) : 0;
                int err2 = (!fdeleccioError2.getText().equals("")) ? Integer.parseInt(fdeleccioError2.getText()) : 0;
                error = err1 + err2 + "";
                fdeleccioErrors.setText(error);
                break;
            }
            case 5:
            {
                int err1 = (!fdalternError1.getText().equals("")) ? Integer.parseInt(fdalternError1.getText()) : 0;
                int err2 = (!fdalternError2.getText().equals("")) ? Integer.parseInt(fdalternError2.getText()) : 0;
                error = err1 + err2 + "";
                fdalternErrors.setText(error);
                break;
            }
            default:
                break;
        }
    }

    private void initTimer() {
        this.llistaBtn5digits = new JButton[4];
        llistaBtn5digits[0] = fiveDigitStart1;
        llistaBtn5digits[1] = fiveDigitStart2;
        llistaBtn5digits[2] = fiveDigitStart3;
        llistaBtn5digits[3] = fiveDigitStart4;
        timeFormatter = new DecimalFormat("00");
        fdtimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                long now = System.currentTimeMillis();
                long dif = now - fdstartTime;

                long minutes = dif / (60 * 1000);
                dif = Math.round(dif % (60 * 1000));
                long seconds = dif / 1000;
                dif = Math.round(dif % 1000);
                long centiseconds = dif / 10;

                llistaBtn5digits[pagina-1].setText(timeFormatter.format(minutes) + ":"
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

        fiveDigitsScroll = new javax.swing.JScrollPane();
        fdPanel = new javax.swing.JPanel();
        fdjLabel33 = new javax.swing.JLabel();
        fdjPanel4 = new javax.swing.JPanel();
        fdjLabel15 = new javax.swing.JLabel();
        fdjLabel16 = new javax.swing.JLabel();
        fdjLabel18 = new javax.swing.JLabel();
        fdjLabel19 = new javax.swing.JLabel();
        fiveDigitStart1 = new javax.swing.JButton();
        fiveDigitsButton5 = new javax.swing.JButton();
        fiveDigitsButton10 = new javax.swing.JButton();
        fdjLabel21 = new javax.swing.JLabel();
        fdjLabel22 = new javax.swing.JLabel();
        fdjLabel23 = new javax.swing.JLabel();
        fdjLabel24 = new javax.swing.JLabel();
        fdjLabel25 = new javax.swing.JLabel();
        fdjLabel26 = new javax.swing.JLabel();
        fdjLabel27 = new javax.swing.JLabel();
        fdjLabel28 = new javax.swing.JLabel();
        fdjLabel57 = new javax.swing.JLabel();
        fdjLabel70 = new javax.swing.JLabel();
        fdjLabel20 = new javax.swing.JLabel();
        fdjLabel78 = new javax.swing.JLabel();
        fdtemps1 = new javax.swing.JLabel();
        fdtemps2 = new javax.swing.JLabel();
        fdjLabel95 = new javax.swing.JLabel();
        fdjLabel96 = new javax.swing.JLabel();
        fdlecturaError1 = new javax.swing.JTextField();
        fdlecturaError2 = new javax.swing.JTextField();
        fiveDigitsScroll1 = new javax.swing.JScrollPane();
        fdPanel1 = new javax.swing.JPanel();
        fdjLabel93 = new javax.swing.JLabel();
        fdjPanel6 = new javax.swing.JPanel();
        fdjLabel94 = new javax.swing.JLabel();
        fdjLabel97 = new javax.swing.JLabel();
        fdjLabel98 = new javax.swing.JLabel();
        fdjLabel99 = new javax.swing.JLabel();
        fiveDigitStart2 = new javax.swing.JButton();
        fiveDigitsButton11 = new javax.swing.JButton();
        fiveDigitsButton12 = new javax.swing.JButton();
        fiveDigitsLabel100 = new javax.swing.JLabel();
        fiveDigitsLabel101 = new javax.swing.JLabel();
        fiveDigitsLabel102 = new javax.swing.JLabel();
        fiveDigitsLabel103 = new javax.swing.JLabel();
        fiveDigitsLabel104 = new javax.swing.JLabel();
        fiveDigitsLabel105 = new javax.swing.JLabel();
        fiveDigitsLabel108 = new javax.swing.JLabel();
        fiveDigitsLabel115 = new javax.swing.JLabel();
        fiveDigitsLabel116 = new javax.swing.JLabel();
        fiveDigitsLabel117 = new javax.swing.JLabel();
        fiveDigitsLabel118 = new javax.swing.JLabel();
        fiveDigitsLabel119 = new javax.swing.JLabel();
        fdtemps3 = new javax.swing.JLabel();
        fdtemps4 = new javax.swing.JLabel();
        fiveDigitsLabel120 = new javax.swing.JLabel();
        fiveDigitsLabel121 = new javax.swing.JLabel();
        fdcompteigError1 = new javax.swing.JTextField();
        fdcompteigError2 = new javax.swing.JTextField();
        fiveDigitsScroll2 = new javax.swing.JScrollPane();
        fdPanel2 = new javax.swing.JPanel();
        fiveDigitsLabel122 = new javax.swing.JLabel();
        fdjPanel13 = new javax.swing.JPanel();
        fiveDigitsLabel123 = new javax.swing.JLabel();
        fiveDigitsLabel124 = new javax.swing.JLabel();
        fiveDigitsLabel125 = new javax.swing.JLabel();
        fiveDigitsLabel126 = new javax.swing.JLabel();
        fiveDigitStart3 = new javax.swing.JButton();
        fiveDigitsButton13 = new javax.swing.JButton();
        fiveDigitsButton14 = new javax.swing.JButton();
        fiveDigitsLabel127 = new javax.swing.JLabel();
        fiveDigitsLabel128 = new javax.swing.JLabel();
        fiveDigitsLabel129 = new javax.swing.JLabel();
        fiveDigitsLabel130 = new javax.swing.JLabel();
        fiveDigitsLabel131 = new javax.swing.JLabel();
        fiveDigitsLabel132 = new javax.swing.JLabel();
        fiveDigitsLabel133 = new javax.swing.JLabel();
        fdjLabel134 = new javax.swing.JLabel();
        fdjLabel135 = new javax.swing.JLabel();
        fdjLabel136 = new javax.swing.JLabel();
        fdjLabel137 = new javax.swing.JLabel();
        fdjLabel138 = new javax.swing.JLabel();
        fdtemps5 = new javax.swing.JLabel();
        fdtemps6 = new javax.swing.JLabel();
        fdjLabel139 = new javax.swing.JLabel();
        fdjLabel140 = new javax.swing.JLabel();
        fdeleccioError1 = new javax.swing.JTextField();
        fdeleccioError2 = new javax.swing.JTextField();
        fiveDigitsScroll3 = new javax.swing.JScrollPane();
        fdPanel3 = new javax.swing.JPanel();
        fdjLabel141 = new javax.swing.JLabel();
        fdjPanel14 = new javax.swing.JPanel();
        fdjLabel142 = new javax.swing.JLabel();
        fdjLabel143 = new javax.swing.JLabel();
        fdjLabel144 = new javax.swing.JLabel();
        fdjLabel145 = new javax.swing.JLabel();
        fiveDigitStart4 = new javax.swing.JButton();
        fiveDigitsButton15 = new javax.swing.JButton();
        fiveDigitsButton16 = new javax.swing.JButton();
        fdjLabel146 = new javax.swing.JLabel();
        fdjLabel147 = new javax.swing.JLabel();
        fdjLabel148 = new javax.swing.JLabel();
        fdjLabel149 = new javax.swing.JLabel();
        fdjLabel150 = new javax.swing.JLabel();
        fdjLabel151 = new javax.swing.JLabel();
        fdjLabel152 = new javax.swing.JLabel();
        fdjLabel153 = new javax.swing.JLabel();
        fdjLabel154 = new javax.swing.JLabel();
        fdjLabel155 = new javax.swing.JLabel();
        fdjLabel156 = new javax.swing.JLabel();
        fdjLabel157 = new javax.swing.JLabel();
        fdtemps7 = new javax.swing.JLabel();
        fdtemps8 = new javax.swing.JLabel();
        fdjLabel158 = new javax.swing.JLabel();
        fdjLabel159 = new javax.swing.JLabel();
        fdalternError1 = new javax.swing.JTextField();
        fdalternError2 = new javax.swing.JTextField();
        fiveDigitsScroll4 = new javax.swing.JScrollPane();
        fdPanel4 = new javax.swing.JPanel();
        fdjLabel160 = new javax.swing.JLabel();
        fdjPanel15 = new javax.swing.JPanel();
        fdjLabel161 = new javax.swing.JLabel();
        fdjLabel162 = new javax.swing.JLabel();
        fdjLabel163 = new javax.swing.JLabel();
        fdlecturaTemps = new javax.swing.JLabel();
        fdjLabel166 = new javax.swing.JLabel();
        fdjLabel167 = new javax.swing.JLabel();
        fdjLabel170 = new javax.swing.JLabel();
        fdjLabel171 = new javax.swing.JLabel();
        fdjLabel172 = new javax.swing.JLabel();
        fdcompteigTemps = new javax.swing.JLabel();
        fdjLabel176 = new javax.swing.JLabel();
        fdjLabel177 = new javax.swing.JLabel();
        fdjLabel179 = new javax.swing.JLabel();
        fdjLabel180 = new javax.swing.JLabel();
        fdjLabel181 = new javax.swing.JLabel();
        fdeleccioTemps = new javax.swing.JLabel();
        fdjLabel185 = new javax.swing.JLabel();
        fdjLabel186 = new javax.swing.JLabel();
        fdjLabel188 = new javax.swing.JLabel();
        fdjLabel189 = new javax.swing.JLabel();
        fdjLabel190 = new javax.swing.JLabel();
        fdalternTemps = new javax.swing.JLabel();
        fdjLabel194 = new javax.swing.JLabel();
        fdjLabel195 = new javax.swing.JLabel();
        fdlecturaTempsPCField = new javax.swing.JTextField();
        fdlecturaErrorsPCField = new javax.swing.JTextField();
        fdcompteigTempsPCField = new javax.swing.JTextField();
        fdfdfd = new javax.swing.JTextField();
        fdeleccioTempsPCField = new javax.swing.JTextField();
        fdeleccioErrorsPCField = new javax.swing.JTextField();
        fdalternTempsPCField = new javax.swing.JTextField();
        fdalternErrorsPCField = new javax.swing.JTextField();
        fdlecturaErrors = new javax.swing.JLabel();
        fdcompteigErrors = new javax.swing.JLabel();
        fdeleccioErrors = new javax.swing.JLabel();
        fdalternErrors = new javax.swing.JLabel();
        fdjPanel16 = new javax.swing.JPanel();
        fdjLabel198 = new javax.swing.JLabel();
        fdjLabel199 = new javax.swing.JLabel();
        fdjLabel233 = new javax.swing.JLabel();
        fdjSeparator1 = new javax.swing.JSeparator();
        fdjLabel202 = new javax.swing.JLabel();
        fdjLabel205 = new javax.swing.JLabel();
        fdjSeparator2 = new javax.swing.JSeparator();
        fdeleccioTemps2Field = new javax.swing.JTextField();
        fdlecturaTemps2Field = new javax.swing.JTextField();
        fdinhibicioPDField = new javax.swing.JTextField();
        fdinhibicioPCField = new javax.swing.JTextField();
        fdjPanel17 = new javax.swing.JPanel();
        fdjLabel206 = new javax.swing.JLabel();
        fdjLabel234 = new javax.swing.JLabel();
        fdjSeparator3 = new javax.swing.JSeparator();
        fdjLabel210 = new javax.swing.JLabel();
        fdjLabel213 = new javax.swing.JLabel();
        fdjSeparator4 = new javax.swing.JSeparator();
        fdjLabel207 = new javax.swing.JLabel();
        fdalternanTemps2Field = new javax.swing.JTextField();
        fdcompteigTemps2Field = new javax.swing.JTextField();
        fdflexibilitatPDField = new javax.swing.JTextField();
        fdflexibilitatPCField = new javax.swing.JTextField();
        fdcalculPercentilsFiveDigit = new javax.swing.JButton();
        fddataFive = new javax.swing.JLabel();
        fiveDigitsButton22 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        fdjLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fdjLabel33.setText("Five digit test");

        fdjPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 1. Processos Automàtics: LECTURA"));

        fdjLabel15.setText("1a fila: \"Vull que llegeixi un nombre en cada quadre: un, dos ...\" (... tres, quatre, cinc).");

        fdjLabel16.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        fdjLabel18.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        fdjLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel19.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        fdjLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart1.setText("<html><center>Comença Crono<br>Lectura");
        fiveDigitStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart1ActionPerformed(evt);
            }
        });

        fiveDigitsButton5.setText("Marcar Temps");
        fiveDigitsButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton5ActionPerformed(evt);
            }
        });

        fiveDigitsButton10.setText("Parar Crono");
        fiveDigitsButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton10ActionPerformed(evt);
            }
        });

        fdjLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel21.setText("1 4 3 2 5");
        fdjLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel22.setText("4 3 1 5 2");
        fdjLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel23.setText("5 4 2 3 1");
        fdjLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel24.setText("2 5 1 4 3");
        fdjLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel25.setText("1 3 2 5 4");
        fdjLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel26.setText("3 5 4 1 2");
        fdjLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel27.setText("1 4 3 2 5");
        fdjLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel28.setText("4 1 5 3 2");
        fdjLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel57.setText("5 2 1 4 3");
        fdjLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel57.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel70.setText("2 5 3 1 4");
        fdjLabel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel70.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel20.setText("Temps:");

        fdjLabel78.setText("Temps:");

        fdtemps1.setText("00:00:00");

        fdtemps2.setText("00:00:00");

        fdjLabel95.setText("Errors:");

        fdjLabel96.setText("Errors:");

        javax.swing.GroupLayout fdjPanel4Layout = new javax.swing.GroupLayout(fdjPanel4);
        fdjPanel4.setLayout(fdjPanel4Layout);
        fdjPanel4Layout.setHorizontalGroup(
            fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjLabel16)
                    .addComponent(fdjLabel15)
                    .addGroup(fdjPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(fdjLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fdjPanel4Layout.createSequentialGroup()
                        .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fiveDigitsButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitsButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitStart1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fdjLabel18)
                            .addGroup(fdjPanel4Layout.createSequentialGroup()
                                .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel4Layout.createSequentialGroup()
                                        .addComponent(fdjLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fdjLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps1))
                                    .addGroup(fdjPanel4Layout.createSequentialGroup()
                                        .addComponent(fdjLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fdjLabel78)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps2)))
                                .addGap(18, 18, 18)
                                .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel4Layout.createSequentialGroup()
                                        .addComponent(fdjLabel95)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdlecturaError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(fdjPanel4Layout.createSequentialGroup()
                                        .addComponent(fdjLabel96)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdlecturaError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fdjPanel4Layout.setVerticalGroup(
            fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fdjLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel18)
                    .addComponent(fiveDigitStart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton5)
                    .addComponent(fdjLabel21)
                    .addComponent(fdjLabel22)
                    .addComponent(fdjLabel23)
                    .addComponent(fdjLabel24)
                    .addComponent(fdjLabel25)
                    .addComponent(fdjLabel20)
                    .addComponent(fdtemps1)
                    .addComponent(fdjLabel95)
                    .addComponent(fdlecturaError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton10)
                    .addComponent(fdjLabel26)
                    .addComponent(fdjLabel27)
                    .addComponent(fdjLabel28)
                    .addComponent(fdjLabel57)
                    .addComponent(fdjLabel70)
                    .addComponent(fdjLabel78)
                    .addComponent(fdtemps2)
                    .addComponent(fdjLabel96)
                    .addComponent(fdlecturaError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fdPanelLayout = new javax.swing.GroupLayout(fdPanel);
        fdPanel.setLayout(fdPanelLayout);
        fdPanelLayout.setHorizontalGroup(
            fdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjLabel33)
                    .addComponent(fdjPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        fdPanelLayout.setVerticalGroup(
            fdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fdPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fiveDigitsScroll.setViewportView(fdPanel);

        add(fiveDigitsScroll, "card1");

        fdjLabel93.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fdjLabel93.setText("Five digit test");

        fdjPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 2. Processos Automàtics: COMPTEIG"));

        fdjLabel94.setText("1a fila: \"Vull que compti un nombre en cada quadre: un, dos ...\" (... tres, quatre, cinc).");

        fdjLabel97.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        fdjLabel98.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        fdjLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel99.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        fdjLabel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel99.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart2.setText("<html><center>Comença Crono<br>Compteig");
        fiveDigitStart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart2ActionPerformed(evt);
            }
        });

        fiveDigitsButton11.setText("Marcar Temps");
        fiveDigitsButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton11ActionPerformed(evt);
            }
        });

        fiveDigitsButton12.setText("Parar Crono");
        fiveDigitsButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton12ActionPerformed(evt);
            }
        });

        fiveDigitsLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel100.setText("1 4 3 2 5");
        fiveDigitsLabel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel100.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel101.setText("4 3 1 5 2");
        fiveDigitsLabel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel101.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel102.setText("5 4 2 3 1");
        fiveDigitsLabel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel102.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel103.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel103.setText("2 5 1 4 3");
        fiveDigitsLabel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel103.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel104.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel104.setText("1 3 2 5 4");
        fiveDigitsLabel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel104.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel105.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel105.setText("3 5 4 1 2");
        fiveDigitsLabel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel105.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel108.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel108.setText("1 4 3 2 5");
        fiveDigitsLabel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel108.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel115.setText("4 1 5 3 2");
        fiveDigitsLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel115.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel116.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel116.setText("5 2 1 4 3");
        fiveDigitsLabel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel116.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel117.setText("2 5 3 1 4");
        fiveDigitsLabel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel117.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel118.setText("Temps:");

        fiveDigitsLabel119.setText("Temps:");

        fdtemps3.setText("00:00:00");

        fdtemps4.setText("00:00:00");

        fiveDigitsLabel120.setText("Errors:");

        fiveDigitsLabel121.setText("Errors:");

        javax.swing.GroupLayout fdjPanel6Layout = new javax.swing.GroupLayout(fdjPanel6);
        fdjPanel6.setLayout(fdjPanel6Layout);
        fdjPanel6Layout.setHorizontalGroup(
            fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjLabel97)
                    .addComponent(fdjLabel94)
                    .addGroup(fdjPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(fdjLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fdjPanel6Layout.createSequentialGroup()
                        .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fiveDigitsButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitsButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitStart2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fdjLabel98)
                            .addGroup(fdjPanel6Layout.createSequentialGroup()
                                .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel6Layout.createSequentialGroup()
                                        .addComponent(fiveDigitsLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fiveDigitsLabel118)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps3))
                                    .addGroup(fdjPanel6Layout.createSequentialGroup()
                                        .addComponent(fiveDigitsLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fiveDigitsLabel119)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps4)))
                                .addGap(18, 18, 18)
                                .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel6Layout.createSequentialGroup()
                                        .addComponent(fiveDigitsLabel120)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdcompteigError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(fdjPanel6Layout.createSequentialGroup()
                                        .addComponent(fiveDigitsLabel121)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdcompteigError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fdjPanel6Layout.setVerticalGroup(
            fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel94)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fdjLabel97)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel98)
                    .addComponent(fiveDigitStart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton11)
                    .addComponent(fiveDigitsLabel100)
                    .addComponent(fiveDigitsLabel101)
                    .addComponent(fiveDigitsLabel102)
                    .addComponent(fiveDigitsLabel103)
                    .addComponent(fiveDigitsLabel104)
                    .addComponent(fiveDigitsLabel118)
                    .addComponent(fdtemps3)
                    .addComponent(fiveDigitsLabel120)
                    .addComponent(fdcompteigError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton12)
                    .addComponent(fiveDigitsLabel105)
                    .addComponent(fiveDigitsLabel108)
                    .addComponent(fiveDigitsLabel115)
                    .addComponent(fiveDigitsLabel116)
                    .addComponent(fiveDigitsLabel117)
                    .addComponent(fiveDigitsLabel119)
                    .addComponent(fdtemps4)
                    .addComponent(fiveDigitsLabel121)
                    .addComponent(fdcompteigError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fdPanel1Layout = new javax.swing.GroupLayout(fdPanel1);
        fdPanel1.setLayout(fdPanel1Layout);
        fdPanel1Layout.setHorizontalGroup(
            fdPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjLabel93)
                    .addComponent(fdjPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        fdPanel1Layout.setVerticalGroup(
            fdPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fdPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fiveDigitsScroll1.setViewportView(fdPanel1);

        add(fiveDigitsScroll1, "card2");

        fiveDigitsLabel122.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fiveDigitsLabel122.setText("Five digit test");

        fdjPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 3. Processos Automàtics: ELECCIÓ"));

        fiveDigitsLabel123.setText("<html>1a fila: \"Ara vull que compti quants números hi ha en cada quadre. <br> Recordi que ha de comptar els nombres en lloc de llegir-los: un, dos, tres ... \"(quatre, cinc).");

        fiveDigitsLabel124.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        fiveDigitsLabel125.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        fiveDigitsLabel126.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel126.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        fiveDigitsLabel126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel126.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart3.setText("<html><center>Comença Crono<br>Elecció");
        fiveDigitStart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart3ActionPerformed(evt);
            }
        });

        fiveDigitsButton13.setText("Marcar Temps");
        fiveDigitsButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton13ActionPerformed(evt);
            }
        });

        fiveDigitsButton14.setText("Parar Crono");
        fiveDigitsButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton14ActionPerformed(evt);
            }
        });

        fiveDigitsLabel127.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel127.setText("1 4 3 2 5");
        fiveDigitsLabel127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel127.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel128.setText("4 3 1 5 2");
        fiveDigitsLabel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel128.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel129.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel129.setText("5 4 2 3 1");
        fiveDigitsLabel129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel129.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel130.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel130.setText("2 5 1 4 3");
        fiveDigitsLabel130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel130.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel131.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel131.setText("1 3 2 5 4");
        fiveDigitsLabel131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel131.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel132.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel132.setText("3 5 4 1 2");
        fiveDigitsLabel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel132.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitsLabel133.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fiveDigitsLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveDigitsLabel133.setText("1 4 3 2 5");
        fiveDigitsLabel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fiveDigitsLabel133.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel134.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel134.setText("4 1 5 3 2");
        fdjLabel134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel134.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel135.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel135.setText("5 2 1 4 3");
        fdjLabel135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel135.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel136.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel136.setText("2 5 3 1 4");
        fdjLabel136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel136.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel137.setText("Temps:");

        fdjLabel138.setText("Temps:");

        fdtemps5.setText("00:00:00");

        fdtemps6.setText("00:00:00");

        fdjLabel139.setText("Errors:");

        fdjLabel140.setText("Errors:");

        javax.swing.GroupLayout fdjPanel13Layout = new javax.swing.GroupLayout(fdjPanel13);
        fdjPanel13.setLayout(fdjPanel13Layout);
        fdjPanel13Layout.setHorizontalGroup(
            fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fiveDigitsLabel124)
                    .addComponent(fiveDigitsLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fdjPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(fiveDigitsLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fdjPanel13Layout.createSequentialGroup()
                        .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fiveDigitsButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitsButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitStart3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fiveDigitsLabel125)
                            .addGroup(fdjPanel13Layout.createSequentialGroup()
                                .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel13Layout.createSequentialGroup()
                                        .addComponent(fiveDigitsLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fdjLabel137)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps5))
                                    .addGroup(fdjPanel13Layout.createSequentialGroup()
                                        .addComponent(fiveDigitsLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiveDigitsLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fdjLabel138)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps6)))
                                .addGap(18, 18, 18)
                                .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel13Layout.createSequentialGroup()
                                        .addComponent(fdjLabel139)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdeleccioError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(fdjPanel13Layout.createSequentialGroup()
                                        .addComponent(fdjLabel140)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdeleccioError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fdjPanel13Layout.setVerticalGroup(
            fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fiveDigitsLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fiveDigitsLabel124)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fiveDigitsLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsLabel125)
                    .addComponent(fiveDigitStart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton13)
                    .addComponent(fiveDigitsLabel127)
                    .addComponent(fiveDigitsLabel128)
                    .addComponent(fiveDigitsLabel129)
                    .addComponent(fiveDigitsLabel130)
                    .addComponent(fiveDigitsLabel131)
                    .addComponent(fdjLabel137)
                    .addComponent(fdtemps5)
                    .addComponent(fdjLabel139)
                    .addComponent(fdeleccioError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton14)
                    .addComponent(fiveDigitsLabel132)
                    .addComponent(fiveDigitsLabel133)
                    .addComponent(fdjLabel134)
                    .addComponent(fdjLabel135)
                    .addComponent(fdjLabel136)
                    .addComponent(fdjLabel138)
                    .addComponent(fdtemps6)
                    .addComponent(fdjLabel140)
                    .addComponent(fdeleccioError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fdPanel2Layout = new javax.swing.GroupLayout(fdPanel2);
        fdPanel2.setLayout(fdPanel2Layout);
        fdPanel2Layout.setHorizontalGroup(
            fdPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fiveDigitsLabel122)
                    .addComponent(fdjPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        fdPanel2Layout.setVerticalGroup(
            fdPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fdPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fiveDigitsLabel122)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fiveDigitsScroll2.setViewportView(fdPanel2);

        add(fiveDigitsScroll2, "card3");

        fdjLabel141.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fdjLabel141.setText("Five digit test");

        fdjPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 3. Processos Automàtics: ALTERNANÇA"));

        fdjLabel142.setText("<html>1a fila: \"Ara ha de comptar els números com ha fet abans, però quan arribi a un quadre amb la vora més gruixuda (assenyalar) <br> ha de canviar la regla i llegir el número: un, dos, tres ...\" (quatre, cinc).");

        fdjLabel143.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        fdjLabel144.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        fdjLabel145.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel145.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel145.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        fdjLabel145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel145.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart4.setText("<html><center>Comença Crono<br>Alternança");
        fiveDigitStart4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart4ActionPerformed(evt);
            }
        });

        fiveDigitsButton15.setText("Marcar Temps");
        fiveDigitsButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton15ActionPerformed(evt);
            }
        });

        fiveDigitsButton16.setText("Parar Crono");
        fiveDigitsButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton16ActionPerformed(evt);
            }
        });

        fdjLabel146.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel146.setText("1 4 3 2 5");
        fdjLabel146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel146.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel147.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel147.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel147.setText("4 3 1 5 2");
        fdjLabel147.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel147.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel148.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel148.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel148.setText("5 4 2 3 1");
        fdjLabel148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel148.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel149.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel149.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel149.setText("2 5 1 4 3");
        fdjLabel149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel149.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel150.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel150.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel150.setText("1 3 2 5 4");
        fdjLabel150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel150.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel151.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel151.setText("3 5 4 1 2");
        fdjLabel151.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel151.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel152.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel152.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel152.setText("1 4 3 2 5");
        fdjLabel152.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel152.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel153.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel153.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel153.setText("4 1 5 3 2");
        fdjLabel153.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel153.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel154.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel154.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel154.setText("5 2 1 4 3");
        fdjLabel154.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel154.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel155.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdjLabel155.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdjLabel155.setText("2 5 3 1 4");
        fdjLabel155.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fdjLabel155.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fdjLabel156.setText("Temps:");

        fdjLabel157.setText("Temps:");

        fdtemps7.setText("00:00:00");

        fdtemps8.setText("00:00:00");

        fdjLabel158.setText("Errors:");

        fdjLabel159.setText("Errors:");

        javax.swing.GroupLayout fdjPanel14Layout = new javax.swing.GroupLayout(fdjPanel14);
        fdjPanel14.setLayout(fdjPanel14Layout);
        fdjPanel14Layout.setHorizontalGroup(
            fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjLabel143)
                    .addComponent(fdjLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fdjPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(fdjLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fdjPanel14Layout.createSequentialGroup()
                        .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fiveDigitsButton16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitsButton15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiveDigitStart4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fdjLabel144)
                            .addGroup(fdjPanel14Layout.createSequentialGroup()
                                .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel14Layout.createSequentialGroup()
                                        .addComponent(fdjLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fdjLabel156)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps7))
                                    .addGroup(fdjPanel14Layout.createSequentialGroup()
                                        .addComponent(fdjLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdjLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fdjLabel157)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdtemps8)))
                                .addGap(18, 18, 18)
                                .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel14Layout.createSequentialGroup()
                                        .addComponent(fdjLabel158)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdalternError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(fdjPanel14Layout.createSequentialGroup()
                                        .addComponent(fdjLabel159)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fdalternError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fdjPanel14Layout.setVerticalGroup(
            fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fdjLabel143)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel144)
                    .addComponent(fiveDigitStart4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton15)
                    .addComponent(fdjLabel146)
                    .addComponent(fdjLabel147)
                    .addComponent(fdjLabel148)
                    .addComponent(fdjLabel149)
                    .addComponent(fdjLabel150)
                    .addComponent(fdjLabel156)
                    .addComponent(fdtemps7)
                    .addComponent(fdjLabel158)
                    .addComponent(fdalternError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdjPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveDigitsButton16)
                    .addComponent(fdjLabel151)
                    .addComponent(fdjLabel152)
                    .addComponent(fdjLabel153)
                    .addComponent(fdjLabel154)
                    .addComponent(fdjLabel155)
                    .addComponent(fdjLabel157)
                    .addComponent(fdtemps8)
                    .addComponent(fdjLabel159)
                    .addComponent(fdalternError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fdPanel3Layout = new javax.swing.GroupLayout(fdPanel3);
        fdPanel3.setLayout(fdPanel3Layout);
        fdPanel3Layout.setHorizontalGroup(
            fdPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjLabel141)
                    .addComponent(fdjPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        fdPanel3Layout.setVerticalGroup(
            fdPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fdPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel141)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fiveDigitsScroll3.setViewportView(fdPanel3);

        add(fiveDigitsScroll3, "card4");

        fdjLabel160.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fdjLabel160.setText("RESUM DE PUNTUACIONS");

        fdjPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Processos Automàtics"));

        fdjLabel161.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fdjLabel161.setText("Lectura:");

        fdjLabel162.setText("Temps:");

        fdjLabel163.setText("Errors:");

        fdlecturaTemps.setText("00:00:00");

        fdjLabel166.setText("Pc:");

        fdjLabel167.setText("Pc:");

        fdjLabel170.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fdjLabel170.setText("Compteig:");

        fdjLabel171.setText("Temps:");

        fdjLabel172.setText("Pc:");

        fdcompteigTemps.setText("00:00:00");

        fdjLabel176.setText("Pc:");

        fdjLabel177.setText("Errors:");

        fdjLabel179.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fdjLabel179.setText("Elecció:");

        fdjLabel180.setText("Temps:");

        fdjLabel181.setText("Pc:");

        fdeleccioTemps.setText("00:00:00");

        fdjLabel185.setText("Pc:");

        fdjLabel186.setText("Errors:");

        fdjLabel188.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fdjLabel188.setText("Alternança:");

        fdjLabel189.setText("Temps:");

        fdjLabel190.setText("Pc:");

        fdalternTemps.setText("00:00:00");

        fdjLabel194.setText("Pc:");

        fdjLabel195.setText("Errors:");

        fdlecturaErrors.setText("0");

        fdcompteigErrors.setText("0");

        fdeleccioErrors.setText("0");

        fdalternErrors.setText("0");

        javax.swing.GroupLayout fdjPanel15Layout = new javax.swing.GroupLayout(fdjPanel15);
        fdjPanel15.setLayout(fdjPanel15Layout);
        fdjPanel15Layout.setHorizontalGroup(
            fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fdjLabel161)
                            .addComponent(fdjLabel170)
                            .addComponent(fdjLabel179)
                            .addComponent(fdjLabel188))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fdjPanel15Layout.createSequentialGroup()
                                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fdjLabel186)
                                            .addComponent(fdjLabel180))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdeleccioTemps)
                                            .addComponent(fdeleccioErrors))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdjLabel185)
                                            .addComponent(fdjLabel181))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdeleccioTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fdeleccioErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fdjLabel177)
                                            .addComponent(fdjLabel171))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdcompteigTemps)
                                            .addComponent(fdcompteigErrors))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdjLabel176)
                                            .addComponent(fdjLabel172))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fdcompteigTempsPCField, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                            .addComponent(fdfdfd))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(fdjPanel15Layout.createSequentialGroup()
                                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fdjPanel15Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fdjLabel195)
                                            .addComponent(fdjLabel189))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdalternTemps)
                                            .addComponent(fdalternErrors))
                                        .addGap(18, 18, 18)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdjLabel194)
                                            .addComponent(fdjLabel190))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdalternTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fdalternErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fdjLabel163)
                                            .addComponent(fdjLabel162))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(fdjPanel15Layout.createSequentialGroup()
                                                .addComponent(fdlecturaErrors)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(fdjLabel166)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fdlecturaErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(fdjPanel15Layout.createSequentialGroup()
                                                .addComponent(fdlecturaTemps)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(fdjLabel167)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fdlecturaTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(11, 11, 11))))))
        );
        fdjPanel15Layout.setVerticalGroup(
            fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel161)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fdjLabel162)
                        .addComponent(fdlecturaTemps))
                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fdlecturaTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fdjLabel167))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fdlecturaErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fdjLabel166)
                            .addComponent(fdjLabel163)
                            .addComponent(fdlecturaErrors))))
                .addGap(18, 18, 18)
                .addComponent(fdjLabel170)
                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fdjLabel171)
                        .addComponent(fdcompteigTemps)
                        .addComponent(fdjLabel172)
                        .addComponent(fdcompteigTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fdfdfd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fdjLabel176)
                            .addComponent(fdjLabel177)
                            .addComponent(fdcompteigErrors))))
                .addGap(18, 18, 18)
                .addComponent(fdjLabel179)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdeleccioTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fdjLabel181)
                    .addComponent(fdeleccioTemps)
                    .addComponent(fdjLabel180))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdeleccioErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fdjLabel185)
                    .addComponent(fdjLabel186)
                    .addComponent(fdeleccioErrors))
                .addGap(18, 18, 18)
                .addComponent(fdjLabel188)
                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fdjLabel190)
                        .addComponent(fdalternTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fdjPanel15Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fdjLabel189)
                                    .addComponent(fdalternTemps))
                                .addGroup(fdjPanel15Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fdjLabel195)
                                        .addComponent(fdalternErrors))))
                            .addGroup(fdjPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fdalternErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fdjLabel194)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fdjPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inhibició", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        fdjLabel198.setText("Temps d'elecció:");

        fdjLabel199.setText("Temps de lectura:");

        fdjLabel233.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fdjLabel233.setText("-");

        fdjLabel202.setText("PD inhibició:");

        fdjLabel205.setText("Pc:");

        javax.swing.GroupLayout fdjPanel16Layout = new javax.swing.GroupLayout(fdjPanel16);
        fdjPanel16.setLayout(fdjPanel16Layout);
        fdjPanel16Layout.setHorizontalGroup(
            fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjSeparator2)
                    .addGroup(fdjPanel16Layout.createSequentialGroup()
                        .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fdjPanel16Layout.createSequentialGroup()
                                .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fdjLabel199)
                                    .addComponent(fdjLabel198)
                                    .addComponent(fdjLabel202))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fdinhibicioPDField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(fdjPanel16Layout.createSequentialGroup()
                                        .addComponent(fdjLabel233)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fdeleccioTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fdlecturaTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(fdjPanel16Layout.createSequentialGroup()
                                .addComponent(fdjLabel205)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fdinhibicioPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fdjSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fdjPanel16Layout.setVerticalGroup(
            fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel198)
                    .addComponent(fdeleccioTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel199)
                    .addComponent(fdjLabel233)
                    .addComponent(fdlecturaTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel202)
                    .addComponent(fdinhibicioPDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fdjPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel205)
                    .addComponent(fdinhibicioPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fdjPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flexibilitat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        fdjLabel206.setText("Temps de compteig:");

        fdjLabel234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fdjLabel234.setText("-");

        fdjLabel210.setText("PD flexibilitat:");

        fdjLabel213.setText("Pc:");

        fdjLabel207.setText("Temps d'alternança:");

        javax.swing.GroupLayout fdjPanel17Layout = new javax.swing.GroupLayout(fdjPanel17);
        fdjPanel17.setLayout(fdjPanel17Layout);
        fdjPanel17Layout.setHorizontalGroup(
            fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjSeparator4)
                    .addGroup(fdjPanel17Layout.createSequentialGroup()
                        .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fdjLabel207)
                            .addGroup(fdjPanel17Layout.createSequentialGroup()
                                .addComponent(fdjLabel213)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fdflexibilitatPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fdjPanel17Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fdjLabel206)
                                    .addComponent(fdjLabel210))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fdjLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fdalternanTemps2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addComponent(fdcompteigTemps2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addComponent(fdflexibilitatPDField, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addComponent(fdjSeparator3))))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fdjPanel17Layout.setVerticalGroup(
            fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdjPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel207)
                    .addComponent(fdalternanTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel234)
                    .addComponent(fdjLabel206)
                    .addComponent(fdcompteigTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel210)
                    .addComponent(fdflexibilitatPDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fdjSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fdjPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdjLabel213)
                    .addComponent(fdflexibilitatPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fdcalculPercentilsFiveDigit.setText("Marcar data");
        fdcalculPercentilsFiveDigit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdcalculPercentilsFiveDigitActionPerformed(evt);
            }
        });

        fiveDigitsButton22.setText("Veure taula");
        fiveDigitsButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitsButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fdPanel4Layout = new javax.swing.GroupLayout(fdPanel4);
        fdPanel4.setLayout(fdPanel4Layout);
        fdPanel4Layout.setHorizontalGroup(
            fdPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fdPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fdPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdjLabel160)
                    .addGroup(fdPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(fdPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fdPanel4Layout.createSequentialGroup()
                                .addComponent(fdcalculPercentilsFiveDigit)
                                .addGap(18, 18, 18)
                                .addComponent(fddataFive))
                            .addGroup(fdPanel4Layout.createSequentialGroup()
                                .addComponent(fdjPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(fdPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fdjPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fdjPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fiveDigitsButton22))))
                .addContainerGap())
        );
        fdPanel4Layout.setVerticalGroup(
            fdPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fdPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdjLabel160)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fdPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fdPanel4Layout.createSequentialGroup()
                        .addComponent(fdjPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fdjPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fdjPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(fdPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdcalculPercentilsFiveDigit)
                    .addComponent(fddataFive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fiveDigitsButton22)
                .addContainerGap())
        );

        fiveDigitsScroll4.setViewportView(fdPanel4);

        add(fiveDigitsScroll4, "card5");
    }// </editor-fold>//GEN-END:initComponents

    private void fiveDigitStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart1ActionPerformed
        fdtemps1.setText("00:00.00");
        fdtemps2.setText("00:00.00");
        fdstartTime = System.currentTimeMillis();
        fdtimer.start();
        fiveDigitStart1.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart1ActionPerformed

    private void fiveDigitsButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton5ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps1.setText(this.fiveDigitStart1.getText());
        }
    }//GEN-LAST:event_fiveDigitsButton5ActionPerformed

    private void fiveDigitsButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton10ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps2.setText(this.fiveDigitStart1.getText());
            fdtimer.stop();
            fiveDigitStart1.setText("<html><center>Comença Crono<br>Lectura");
            this.fdlecturaTemps.setText(this.fdtemps2.getText());
            fiveDigitStart1.setEnabled(true);
        }else {
            fiveDigitStart1.setText("<html><center>Comença Crono<br>Lectura");
            fiveDigitStart1.setEnabled(true);
        }
    }//GEN-LAST:event_fiveDigitsButton10ActionPerformed

    private void fiveDigitStart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart2ActionPerformed
        fdtemps3.setText("00:00.00");
        fdtemps4.setText("00:00.00");
        fdstartTime = System.currentTimeMillis();
        fdtimer.start();
        fiveDigitStart2.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart2ActionPerformed

    private void fiveDigitsButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton11ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps3.setText(this.fiveDigitStart2.getText());
        }
    }//GEN-LAST:event_fiveDigitsButton11ActionPerformed

    private void fiveDigitsButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton12ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps4.setText(this.fiveDigitStart2.getText());
            fdtimer.stop();
            fiveDigitStart2.setText("<html><center>Comença Crono<br>Compteig");
            this.fdcompteigTemps.setText(this.fdtemps4.getText());
            fiveDigitStart2.setEnabled(true);
        }else {
            fiveDigitStart2.setText("<html><center>Comença Crono<br>Compteig");
            fiveDigitStart2.setEnabled(true);
        }
    }//GEN-LAST:event_fiveDigitsButton12ActionPerformed

    private void fiveDigitStart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart3ActionPerformed
        fdtemps5.setText("00:00.00");
        fdtemps6.setText("00:00.00");
        fdstartTime = System.currentTimeMillis();
        fdtimer.start();
        fiveDigitStart3.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart3ActionPerformed

    private void fiveDigitsButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton13ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps5.setText(this.fiveDigitStart3.getText());
        }
    }//GEN-LAST:event_fiveDigitsButton13ActionPerformed

    private void fiveDigitsButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton14ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps6.setText(this.fiveDigitStart3.getText());
            fdtimer.stop();
            fiveDigitStart3.setText("<html><center>Comença Crono<br>Elecció");
            this.fdeleccioTemps.setText(this.fdtemps6.getText());
            fiveDigitStart3.setEnabled(true);
        }else {
            fiveDigitStart3.setText("<html><center>Comença Crono<br>Elecció");
            fiveDigitStart3.setEnabled(true);
        }
    }//GEN-LAST:event_fiveDigitsButton14ActionPerformed

    private void fiveDigitStart4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart4ActionPerformed
        fdtemps7.setText("00:00.00");
        fdtemps8.setText("00:00.00");
        fdstartTime = System.currentTimeMillis();
        fdtimer.start();
        fiveDigitStart4.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart4ActionPerformed

    private void fiveDigitsButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton15ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps7.setText(this.fiveDigitStart4.getText());
        }
    }//GEN-LAST:event_fiveDigitsButton15ActionPerformed

    private void fiveDigitsButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton16ActionPerformed
        if (fdtimer.isRunning()){
            fdtemps8.setText(this.fiveDigitStart4.getText());
            fdtimer.stop();
            fiveDigitStart4.setText("<html><center>Comença Crono<br>Alternança");
            this.fdalternTemps.setText(this.fdtemps8.getText());
            fiveDigitStart4.setEnabled(true);
        }else {
            fiveDigitStart4.setText("<html><center>Comença Crono<br>Alternança");
            fiveDigitStart4.setEnabled(true);
        }
    }//GEN-LAST:event_fiveDigitsButton16ActionPerformed

    private void fdcalculPercentilsFiveDigitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fdcalculPercentilsFiveDigitActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        fddataFive.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_fdcalculPercentilsFiveDigitActionPerformed

    private void fiveDigitsButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitsButton22ActionPerformed
        File file = new File(Utils.RES_PATH+"FiveDigit.pdf");
        if (file.exists()){
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_fiveDigitsButton22ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fdPanel;
    private javax.swing.JPanel fdPanel1;
    private javax.swing.JPanel fdPanel2;
    private javax.swing.JPanel fdPanel3;
    private javax.swing.JPanel fdPanel4;
    private javax.swing.JTextField fdalternError1;
    private javax.swing.JTextField fdalternError2;
    private javax.swing.JLabel fdalternErrors;
    private javax.swing.JTextField fdalternErrorsPCField;
    private javax.swing.JLabel fdalternTemps;
    private javax.swing.JTextField fdalternTempsPCField;
    private javax.swing.JTextField fdalternanTemps2Field;
    private javax.swing.JButton fdcalculPercentilsFiveDigit;
    private javax.swing.JTextField fdcompteigError1;
    private javax.swing.JTextField fdcompteigError2;
    private javax.swing.JLabel fdcompteigErrors;
    private javax.swing.JLabel fdcompteigTemps;
    private javax.swing.JTextField fdcompteigTemps2Field;
    private javax.swing.JTextField fdcompteigTempsPCField;
    private javax.swing.JLabel fddataFive;
    private javax.swing.JTextField fdeleccioError1;
    private javax.swing.JTextField fdeleccioError2;
    private javax.swing.JLabel fdeleccioErrors;
    private javax.swing.JTextField fdeleccioErrorsPCField;
    private javax.swing.JLabel fdeleccioTemps;
    private javax.swing.JTextField fdeleccioTemps2Field;
    private javax.swing.JTextField fdeleccioTempsPCField;
    private javax.swing.JTextField fdfdfd;
    private javax.swing.JTextField fdflexibilitatPCField;
    private javax.swing.JTextField fdflexibilitatPDField;
    private javax.swing.JTextField fdinhibicioPCField;
    private javax.swing.JTextField fdinhibicioPDField;
    private javax.swing.JLabel fdjLabel134;
    private javax.swing.JLabel fdjLabel135;
    private javax.swing.JLabel fdjLabel136;
    private javax.swing.JLabel fdjLabel137;
    private javax.swing.JLabel fdjLabel138;
    private javax.swing.JLabel fdjLabel139;
    private javax.swing.JLabel fdjLabel140;
    private javax.swing.JLabel fdjLabel141;
    private javax.swing.JLabel fdjLabel142;
    private javax.swing.JLabel fdjLabel143;
    private javax.swing.JLabel fdjLabel144;
    private javax.swing.JLabel fdjLabel145;
    private javax.swing.JLabel fdjLabel146;
    private javax.swing.JLabel fdjLabel147;
    private javax.swing.JLabel fdjLabel148;
    private javax.swing.JLabel fdjLabel149;
    private javax.swing.JLabel fdjLabel15;
    private javax.swing.JLabel fdjLabel150;
    private javax.swing.JLabel fdjLabel151;
    private javax.swing.JLabel fdjLabel152;
    private javax.swing.JLabel fdjLabel153;
    private javax.swing.JLabel fdjLabel154;
    private javax.swing.JLabel fdjLabel155;
    private javax.swing.JLabel fdjLabel156;
    private javax.swing.JLabel fdjLabel157;
    private javax.swing.JLabel fdjLabel158;
    private javax.swing.JLabel fdjLabel159;
    private javax.swing.JLabel fdjLabel16;
    private javax.swing.JLabel fdjLabel160;
    private javax.swing.JLabel fdjLabel161;
    private javax.swing.JLabel fdjLabel162;
    private javax.swing.JLabel fdjLabel163;
    private javax.swing.JLabel fdjLabel166;
    private javax.swing.JLabel fdjLabel167;
    private javax.swing.JLabel fdjLabel170;
    private javax.swing.JLabel fdjLabel171;
    private javax.swing.JLabel fdjLabel172;
    private javax.swing.JLabel fdjLabel176;
    private javax.swing.JLabel fdjLabel177;
    private javax.swing.JLabel fdjLabel179;
    private javax.swing.JLabel fdjLabel18;
    private javax.swing.JLabel fdjLabel180;
    private javax.swing.JLabel fdjLabel181;
    private javax.swing.JLabel fdjLabel185;
    private javax.swing.JLabel fdjLabel186;
    private javax.swing.JLabel fdjLabel188;
    private javax.swing.JLabel fdjLabel189;
    private javax.swing.JLabel fdjLabel19;
    private javax.swing.JLabel fdjLabel190;
    private javax.swing.JLabel fdjLabel194;
    private javax.swing.JLabel fdjLabel195;
    private javax.swing.JLabel fdjLabel198;
    private javax.swing.JLabel fdjLabel199;
    private javax.swing.JLabel fdjLabel20;
    private javax.swing.JLabel fdjLabel202;
    private javax.swing.JLabel fdjLabel205;
    private javax.swing.JLabel fdjLabel206;
    private javax.swing.JLabel fdjLabel207;
    private javax.swing.JLabel fdjLabel21;
    private javax.swing.JLabel fdjLabel210;
    private javax.swing.JLabel fdjLabel213;
    private javax.swing.JLabel fdjLabel22;
    private javax.swing.JLabel fdjLabel23;
    private javax.swing.JLabel fdjLabel233;
    private javax.swing.JLabel fdjLabel234;
    private javax.swing.JLabel fdjLabel24;
    private javax.swing.JLabel fdjLabel25;
    private javax.swing.JLabel fdjLabel26;
    private javax.swing.JLabel fdjLabel27;
    private javax.swing.JLabel fdjLabel28;
    private javax.swing.JLabel fdjLabel33;
    private javax.swing.JLabel fdjLabel57;
    private javax.swing.JLabel fdjLabel70;
    private javax.swing.JLabel fdjLabel78;
    private javax.swing.JLabel fdjLabel93;
    private javax.swing.JLabel fdjLabel94;
    private javax.swing.JLabel fdjLabel95;
    private javax.swing.JLabel fdjLabel96;
    private javax.swing.JLabel fdjLabel97;
    private javax.swing.JLabel fdjLabel98;
    private javax.swing.JLabel fdjLabel99;
    private javax.swing.JPanel fdjPanel13;
    private javax.swing.JPanel fdjPanel14;
    private javax.swing.JPanel fdjPanel15;
    private javax.swing.JPanel fdjPanel16;
    private javax.swing.JPanel fdjPanel17;
    private javax.swing.JPanel fdjPanel4;
    private javax.swing.JPanel fdjPanel6;
    private javax.swing.JSeparator fdjSeparator1;
    private javax.swing.JSeparator fdjSeparator2;
    private javax.swing.JSeparator fdjSeparator3;
    private javax.swing.JSeparator fdjSeparator4;
    private javax.swing.JTextField fdlecturaError1;
    private javax.swing.JTextField fdlecturaError2;
    private javax.swing.JLabel fdlecturaErrors;
    private javax.swing.JTextField fdlecturaErrorsPCField;
    private javax.swing.JLabel fdlecturaTemps;
    private javax.swing.JTextField fdlecturaTemps2Field;
    private javax.swing.JTextField fdlecturaTempsPCField;
    private javax.swing.JLabel fdtemps1;
    private javax.swing.JLabel fdtemps2;
    private javax.swing.JLabel fdtemps3;
    private javax.swing.JLabel fdtemps4;
    private javax.swing.JLabel fdtemps5;
    private javax.swing.JLabel fdtemps6;
    private javax.swing.JLabel fdtemps7;
    private javax.swing.JLabel fdtemps8;
    private javax.swing.JButton fiveDigitStart1;
    private javax.swing.JButton fiveDigitStart2;
    private javax.swing.JButton fiveDigitStart3;
    private javax.swing.JButton fiveDigitStart4;
    private javax.swing.JButton fiveDigitsButton10;
    private javax.swing.JButton fiveDigitsButton11;
    private javax.swing.JButton fiveDigitsButton12;
    private javax.swing.JButton fiveDigitsButton13;
    private javax.swing.JButton fiveDigitsButton14;
    private javax.swing.JButton fiveDigitsButton15;
    private javax.swing.JButton fiveDigitsButton16;
    private javax.swing.JButton fiveDigitsButton22;
    private javax.swing.JButton fiveDigitsButton5;
    private javax.swing.JLabel fiveDigitsLabel100;
    private javax.swing.JLabel fiveDigitsLabel101;
    private javax.swing.JLabel fiveDigitsLabel102;
    private javax.swing.JLabel fiveDigitsLabel103;
    private javax.swing.JLabel fiveDigitsLabel104;
    private javax.swing.JLabel fiveDigitsLabel105;
    private javax.swing.JLabel fiveDigitsLabel108;
    private javax.swing.JLabel fiveDigitsLabel115;
    private javax.swing.JLabel fiveDigitsLabel116;
    private javax.swing.JLabel fiveDigitsLabel117;
    private javax.swing.JLabel fiveDigitsLabel118;
    private javax.swing.JLabel fiveDigitsLabel119;
    private javax.swing.JLabel fiveDigitsLabel120;
    private javax.swing.JLabel fiveDigitsLabel121;
    private javax.swing.JLabel fiveDigitsLabel122;
    private javax.swing.JLabel fiveDigitsLabel123;
    private javax.swing.JLabel fiveDigitsLabel124;
    private javax.swing.JLabel fiveDigitsLabel125;
    private javax.swing.JLabel fiveDigitsLabel126;
    private javax.swing.JLabel fiveDigitsLabel127;
    private javax.swing.JLabel fiveDigitsLabel128;
    private javax.swing.JLabel fiveDigitsLabel129;
    private javax.swing.JLabel fiveDigitsLabel130;
    private javax.swing.JLabel fiveDigitsLabel131;
    private javax.swing.JLabel fiveDigitsLabel132;
    private javax.swing.JLabel fiveDigitsLabel133;
    private javax.swing.JScrollPane fiveDigitsScroll;
    private javax.swing.JScrollPane fiveDigitsScroll1;
    private javax.swing.JScrollPane fiveDigitsScroll2;
    private javax.swing.JScrollPane fiveDigitsScroll3;
    private javax.swing.JScrollPane fiveDigitsScroll4;
    // End of variables declaration//GEN-END:variables
}
