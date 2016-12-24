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

    private Timer timer;
    private long startTime;
    DecimalFormat timeFormatter;
    JButton[] llistaBtn5digits;

    /**
     * Creates new form FiveDigit
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
        Utils.setProperty(prop,"lecturaTemps",lecturaTemps);
        Utils.setProperty(prop,"lecturaTempsPCField",lecturaTempsPCField);
        Utils.setProperty(prop,"lecturaErrorsField",lecturaErrors);
        Utils.setProperty(prop,"lecturaErrorsPCField",lecturaErrorsPCField);
        // Five digit
        Utils.setProperty(prop,"compteigTemps",compteigTemps);
        Utils.setProperty(prop,"compteigTempsPCField",compteigTempsPCField);
        Utils.setProperty(prop,"compteigErrors",compteigErrors);
        Utils.setProperty(prop,"compteigErrorsPCField",compteigErrorsPCField);
        // Five digit
        Utils.setProperty(prop,"lecturaTemps",eleccioTemps);
        Utils.setProperty(prop,"lecturaTempsPCField",eleccioTempsPCField);
        Utils.setProperty(prop,"lecturaErrorsField",eleccioErrors);
        Utils.setProperty(prop,"lecturaErrorsPCField",eleccioErrorsPCField);
        // Five digit
        Utils.setProperty(prop,"alternTemps",alternTemps);
        Utils.setProperty(prop,"alternTempsPCField",alternTempsPCField);
        Utils.setProperty(prop,"alternErrors",alternErrors);
        Utils.setProperty(prop,"alternErrorsPCField",alternErrorsPCField);
        // Five digit
        Utils.setProperty(prop,"inhibicioPCField",inhibicioPCField);
        Utils.setProperty(prop,"flexibilitatPCField",flexibilitatPCField);
    }

    @Override
    public void paginaSeguent(){
        if (timer.isRunning()){
            timer.stop();
        }
        CardLayout card = (CardLayout)this.getLayout();
        pagina++;
        card.show(this, "card"+(pagina));

        String error;
        switch (pagina) {
            case 0:
            {
                int err1 = (!lecturaError1.getText().equals("")) ? Integer.parseInt(lecturaError1.getText()) : 0;
                int err2 = (!lecturaError2.getText().equals("")) ? Integer.parseInt(lecturaError2.getText()) : 0;
                error = err1 + err2 + "";
                lecturaErrors.setText(error);
                break;
            }
            case 1:
            {
                int err1 = (!compteigError1.getText().equals("")) ? Integer.parseInt(compteigError1.getText()) : 0;
                int err2 = (!compteigError2.getText().equals("")) ? Integer.parseInt(compteigError2.getText()) : 0;
                error = err1 + err2 + "";
                compteigErrors.setText(error);
                break;
            }
            case 2:
            {
                int err1 = (!eleccioError1.getText().equals("")) ? Integer.parseInt(eleccioError1.getText()) : 0;
                int err2 = (!eleccioError2.getText().equals("")) ? Integer.parseInt(eleccioError2.getText()) : 0;
                error = err1 + err2 + "";
                eleccioErrors.setText(error);
                break;
            }
            case 3:
            {
                int err1 = (!alternError1.getText().equals("")) ? Integer.parseInt(alternError1.getText()) : 0;
                int err2 = (!alternError2.getText().equals("")) ? Integer.parseInt(alternError2.getText()) : 0;
                error = err1 + err2 + "";
                alternErrors.setText(error);
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

                llistaBtn5digits[pagina].setText(timeFormatter.format(minutes) + ":"
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
        Panel = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fiveDigitStart1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        temps1 = new javax.swing.JLabel();
        temps2 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        lecturaError1 = new javax.swing.JTextField();
        lecturaError2 = new javax.swing.JTextField();
        fiveDigitsScroll1 = new javax.swing.JScrollPane();
        Panel1 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        fiveDigitStart2 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        temps3 = new javax.swing.JLabel();
        temps4 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        compteigError1 = new javax.swing.JTextField();
        compteigError2 = new javax.swing.JTextField();
        fiveDigitsScroll2 = new javax.swing.JScrollPane();
        Panel2 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        fiveDigitStart3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        temps5 = new javax.swing.JLabel();
        temps6 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        eleccioError1 = new javax.swing.JTextField();
        eleccioError2 = new javax.swing.JTextField();
        fiveDigitsScroll3 = new javax.swing.JScrollPane();
        Panel3 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        fiveDigitStart4 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        temps7 = new javax.swing.JLabel();
        temps8 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        alternError1 = new javax.swing.JTextField();
        alternError2 = new javax.swing.JTextField();
        fiveDigitsScroll4 = new javax.swing.JScrollPane();
        Panel4 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        lecturaTemps = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        compteigTemps = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        eleccioTemps = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        alternTemps = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        lecturaTempsPCField = new javax.swing.JTextField();
        lecturaErrorsPCField = new javax.swing.JTextField();
        compteigTempsPCField = new javax.swing.JTextField();
        compteigErrorsPCField = new javax.swing.JTextField();
        eleccioTempsPCField = new javax.swing.JTextField();
        eleccioErrorsPCField = new javax.swing.JTextField();
        alternTempsPCField = new javax.swing.JTextField();
        alternErrorsPCField = new javax.swing.JTextField();
        lecturaErrors = new javax.swing.JLabel();
        compteigErrors = new javax.swing.JLabel();
        eleccioErrors = new javax.swing.JLabel();
        alternErrors = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel202 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        eleccioTemps2Field = new javax.swing.JTextField();
        lecturaTemps2Field = new javax.swing.JTextField();
        inhibicioPDField = new javax.swing.JTextField();
        inhibicioPCField = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel206 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel210 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel207 = new javax.swing.JLabel();
        alternanTemps2Field = new javax.swing.JTextField();
        compteigTemps2Field = new javax.swing.JTextField();
        flexibilitatPDField = new javax.swing.JTextField();
        flexibilitatPCField = new javax.swing.JTextField();
        calculPercentilsFiveDigit = new javax.swing.JButton();
        dataFive = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Five digit test");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 1. Processos Automàtics: LECTURA"));

        jLabel15.setText("1a fila: \"Vull que llegeixi un nombre en cada quadre: un, dos ...\" (... tres, quatre, cinc).");

        jLabel16.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        jLabel18.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart1.setText("<html><center>Comença Crono<br>Lectura");
        fiveDigitStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart1ActionPerformed(evt);
            }
        });

        jButton5.setText("Marcar Temps");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton10.setText("Parar Crono");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("1 4 3 2 5");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("4 3 1 5 2");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("5 4 2 3 1");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("2 5 1 4 3");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("1 3 2 5 4");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("3 5 4 1 2");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("1 4 3 2 5");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("4 1 5 3 2");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("5 2 1 4 3");
        jLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel57.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("2 5 3 1 4");
        jLabel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel70.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel20.setText("Temps:");

        jLabel78.setText("Temps:");

        temps1.setText("00:00:00");

        temps2.setText("00:00:00");

        jLabel95.setText("Errors:");

        jLabel96.setText("Errors:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fiveDigitStart1, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel18)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel20)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps1))
                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel78)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps2)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                .addComponent(jLabel95)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(lecturaError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                .addComponent(jLabel96)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(lecturaError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(fiveDigitStart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel20)
                                        .addComponent(temps1)
                                        .addComponent(jLabel95)
                                        .addComponent(lecturaError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton10)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel57)
                                        .addComponent(jLabel70)
                                        .addComponent(jLabel78)
                                        .addComponent(temps2)
                                        .addComponent(jLabel96)
                                        .addComponent(lecturaError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel33)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        fiveDigitsScroll.setViewportView(Panel);

        add(fiveDigitsScroll, "card1");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel93.setText("Five digit test");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 2. Processos Automàtics: COMPTEIG"));

        jLabel94.setText("1a fila: \"Vull que compti un nombre en cada quadre: un, dos ...\" (... tres, quatre, cinc).");

        jLabel97.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        jLabel98.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        jLabel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel99.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart2.setText("<html><center>Comença Crono<br>Compteig");
        fiveDigitStart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart2ActionPerformed(evt);
            }
        });

        jButton11.setText("Marcar Temps");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Parar Crono");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("1 4 3 2 5");
        jLabel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel100.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("4 3 1 5 2");
        jLabel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel101.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("5 4 2 3 1");
        jLabel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel102.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("2 5 1 4 3");
        jLabel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel103.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("1 3 2 5 4");
        jLabel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel104.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("3 5 4 1 2");
        jLabel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel105.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("1 4 3 2 5");
        jLabel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel108.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("4 1 5 3 2");
        jLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel115.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setText("5 2 1 4 3");
        jLabel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel116.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("2 5 3 1 4");
        jLabel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel117.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel118.setText("Temps:");

        jLabel119.setText("Temps:");

        temps3.setText("00:00:00");

        temps4.setText("00:00:00");

        jLabel120.setText("Errors:");

        jLabel121.setText("Errors:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel97)
                                        .addComponent(jLabel94)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fiveDigitStart2, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel98)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel118)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps3))
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel119)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps4)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel120)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(compteigError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel121)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(compteigError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel94)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel98)
                                        .addComponent(fiveDigitStart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton11)
                                        .addComponent(jLabel100)
                                        .addComponent(jLabel101)
                                        .addComponent(jLabel102)
                                        .addComponent(jLabel103)
                                        .addComponent(jLabel104)
                                        .addComponent(jLabel118)
                                        .addComponent(temps3)
                                        .addComponent(jLabel120)
                                        .addComponent(compteigError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton12)
                                        .addComponent(jLabel105)
                                        .addComponent(jLabel108)
                                        .addComponent(jLabel115)
                                        .addComponent(jLabel116)
                                        .addComponent(jLabel117)
                                        .addComponent(jLabel119)
                                        .addComponent(temps4)
                                        .addComponent(jLabel121)
                                        .addComponent(compteigError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
                Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel93)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        Panel1Layout.setVerticalGroup(
                Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        fiveDigitsScroll1.setViewportView(Panel1);

        add(fiveDigitsScroll1, "card2");

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel122.setText("Five digit test");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 3. Processos Automàtics: ELECCIÓ"));

        jLabel123.setText("<html>1a fila: \"Ara vull que compti quants números hi ha en cada quadre. <br> Recordi que ha de comptar els nombres en lloc de llegir-los: un, dos, tres ... \"(quatre, cinc).");

        jLabel124.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        jLabel125.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        jLabel126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel126.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart3.setText("<html><center>Comença Crono<br>Elecció");
        fiveDigitStart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart3ActionPerformed(evt);
            }
        });

        jButton13.setText("Marcar Temps");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Parar Crono");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("1 4 3 2 5");
        jLabel127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel127.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("4 3 1 5 2");
        jLabel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel128.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("5 4 2 3 1");
        jLabel129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel129.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("2 5 1 4 3");
        jLabel130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel130.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("1 3 2 5 4");
        jLabel131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel131.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("3 5 4 1 2");
        jLabel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel132.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel133.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("1 4 3 2 5");
        jLabel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel133.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setText("4 1 5 3 2");
        jLabel134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel134.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setText("5 2 1 4 3");
        jLabel135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel135.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel136.setText("2 5 3 1 4");
        jLabel136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel136.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel137.setText("Temps:");

        jLabel138.setText("Temps:");

        temps5.setText("00:00:00");

        temps6.setText("00:00:00");

        jLabel139.setText("Errors:");

        jLabel140.setText("Errors:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel124)
                                        .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fiveDigitStart3, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel125)
                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                                                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel137)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps5))
                                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                                                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel138)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps6)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                                                .addComponent(jLabel139)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(eleccioError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                                                .addComponent(jLabel140)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(eleccioError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel125)
                                        .addComponent(fiveDigitStart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton13)
                                        .addComponent(jLabel127)
                                        .addComponent(jLabel128)
                                        .addComponent(jLabel129)
                                        .addComponent(jLabel130)
                                        .addComponent(jLabel131)
                                        .addComponent(jLabel137)
                                        .addComponent(temps5)
                                        .addComponent(jLabel139)
                                        .addComponent(eleccioError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton14)
                                        .addComponent(jLabel132)
                                        .addComponent(jLabel133)
                                        .addComponent(jLabel134)
                                        .addComponent(jLabel135)
                                        .addComponent(jLabel136)
                                        .addComponent(jLabel138)
                                        .addComponent(temps6)
                                        .addComponent(jLabel140)
                                        .addComponent(eleccioError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
                Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel122)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        Panel2Layout.setVerticalGroup(
                Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel122)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        fiveDigitsScroll2.setViewportView(Panel2);

        add(fiveDigitsScroll2, "card3");

        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel141.setText("Five digit test");

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Part 3. Processos Automàtics: ALTERNANÇA"));

        jLabel142.setText("<html>1a fila: \"Ara ha de comptar els números com ha fet abans, però quan arribi a un quadre amb la vora més gruixuda (assenyalar) <br> ha de canviar la regla i llegir el número: un, dos, tres ...\" (quatre, cinc).");

        jLabel143.setText("2a fila: \"Continuï\" (Repetiu la tasca fins que l'examinat no cometi cap error).");

        jLabel144.setText("\"D'acord, ara comenci aquí dalt i treballi el més de pressa que pugui\" (comenci a cronometrar el temps)");

        jLabel145.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel145.setText("<html>1 2 3 4 5<br>5 2 3 1 4");
        jLabel145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel145.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fiveDigitStart4.setText("<html><center>Comença Crono<br>Alternança");
        fiveDigitStart4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDigitStart4ActionPerformed(evt);
            }
        });

        jButton15.setText("Marcar Temps");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Parar Crono");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel146.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel146.setText("1 4 3 2 5");
        jLabel146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel146.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel147.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel147.setText("4 3 1 5 2");
        jLabel147.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel147.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel148.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel148.setText("5 4 2 3 1");
        jLabel148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel148.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel149.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel149.setText("2 5 1 4 3");
        jLabel149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel149.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel150.setText("1 3 2 5 4");
        jLabel150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel150.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel151.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel151.setText("3 5 4 1 2");
        jLabel151.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel151.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel152.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel152.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel152.setText("1 4 3 2 5");
        jLabel152.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel152.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel153.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel153.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel153.setText("4 1 5 3 2");
        jLabel153.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel153.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel154.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel154.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel154.setText("5 2 1 4 3");
        jLabel154.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel154.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel155.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel155.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel155.setText("2 5 3 1 4");
        jLabel155.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel155.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel156.setText("Temps:");

        jLabel157.setText("Temps:");

        temps7.setText("00:00:00");

        temps8.setText("00:00:00");

        jLabel158.setText("Errors:");

        jLabel159.setText("Errors:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel143)
                                        .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fiveDigitStart4, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel144)
                                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                                                .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel156)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps7))
                                                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                                                .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel157)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(temps8)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                                                .addComponent(jLabel158)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(alternError1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                                                .addComponent(jLabel159)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(alternError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel143)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel144)
                                        .addComponent(fiveDigitStart4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton15)
                                        .addComponent(jLabel146)
                                        .addComponent(jLabel147)
                                        .addComponent(jLabel148)
                                        .addComponent(jLabel149)
                                        .addComponent(jLabel150)
                                        .addComponent(jLabel156)
                                        .addComponent(temps7)
                                        .addComponent(jLabel158)
                                        .addComponent(alternError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton16)
                                        .addComponent(jLabel151)
                                        .addComponent(jLabel152)
                                        .addComponent(jLabel153)
                                        .addComponent(jLabel154)
                                        .addComponent(jLabel155)
                                        .addComponent(jLabel157)
                                        .addComponent(temps8)
                                        .addComponent(jLabel159)
                                        .addComponent(alternError2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
                Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel141)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        Panel3Layout.setVerticalGroup(
                Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel141)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        fiveDigitsScroll3.setViewportView(Panel3);

        add(fiveDigitsScroll3, "card4");

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel160.setText("RESUM DE PUNTUACIONS");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Processos Automàtics"));

        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel161.setText("Lectura:");

        jLabel162.setText("Temps:");

        jLabel163.setText("Errors:");

        lecturaTemps.setText("00:00:00");

        jLabel166.setText("PC:");

        jLabel167.setText("PC:");

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel170.setText("Compteig:");

        jLabel171.setText("Temps:");

        jLabel172.setText("PC:");

        compteigTemps.setText("00:00:00");

        jLabel176.setText("PC:");

        jLabel177.setText("Errors:");

        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel179.setText("Elecció:");

        jLabel180.setText("Temps:");

        jLabel181.setText("PC:");

        eleccioTemps.setText("00:00:00");

        jLabel185.setText("PC:");

        jLabel186.setText("Errors:");

        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel188.setText("Alternança:");

        jLabel189.setText("Temps:");

        jLabel190.setText("PC:");

        alternTemps.setText("00:00:00");

        jLabel194.setText("PC:");

        jLabel195.setText("Errors:");

        lecturaErrors.setText("0");

        compteigErrors.setText("0");

        eleccioErrors.setText("0");

        alternErrors.setText("0");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel161)
                                                        .addComponent(jLabel170)
                                                        .addComponent(jLabel179)
                                                        .addComponent(jLabel188))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel186)
                                                                                        .addComponent(jLabel180))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(eleccioTemps)
                                                                                        .addComponent(eleccioErrors))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel185)
                                                                                        .addComponent(jLabel181))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(eleccioTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(eleccioErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel177)
                                                                                        .addComponent(jLabel171))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(compteigTemps)
                                                                                        .addComponent(compteigErrors))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel176)
                                                                                        .addComponent(jLabel172))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(compteigTempsPCField, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                                                                        .addComponent(compteigErrorsPCField))))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel195)
                                                                                        .addComponent(jLabel189))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(alternTemps)
                                                                                        .addComponent(alternErrors))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel194)
                                                                                        .addComponent(jLabel190))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(alternTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(alternErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel163)
                                                                                        .addComponent(jLabel162))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                                                                .addComponent(lecturaErrors)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jLabel166)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(lecturaErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                                                                .addComponent(lecturaTemps)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jLabel167)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(lecturaTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(11, 11, 11))))))
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel161)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel162)
                                                .addComponent(lecturaTemps))
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lecturaTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel167))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lecturaErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel166)
                                                        .addComponent(jLabel163)
                                                        .addComponent(lecturaErrors))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel170)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel171)
                                                .addComponent(compteigTemps)
                                                .addComponent(jLabel172)
                                                .addComponent(compteigTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(compteigErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel176)
                                                        .addComponent(jLabel177)
                                                        .addComponent(compteigErrors))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel179)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eleccioTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel181)
                                        .addComponent(eleccioTemps)
                                        .addComponent(jLabel180))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eleccioErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel185)
                                        .addComponent(jLabel186)
                                        .addComponent(eleccioErrors))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel188)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel190)
                                                .addComponent(alternTempsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel189)
                                                                        .addComponent(alternTemps))
                                                                .addGroup(jPanel15Layout.createSequentialGroup()
                                                                        .addGap(29, 29, 29)
                                                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel195)
                                                                                .addComponent(alternErrors))))
                                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(alternErrorsPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel194)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inhibició", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel198.setText("Temps d'elecció:");

        jLabel199.setText("Temps de lectura:");

        jLabel233.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel233.setText("-");

        jLabel202.setText("PD inhibició:");

        jLabel205.setText("PC:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2)
                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel199)
                                                                        .addComponent(jLabel198)
                                                                        .addComponent(jLabel202))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(inhibicioPDField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                                                .addComponent(jLabel233)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(eleccioTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(lecturaTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                                .addComponent(jLabel205)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(inhibicioPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel198)
                                        .addComponent(eleccioTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel199)
                                        .addComponent(jLabel233)
                                        .addComponent(lecturaTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel202)
                                        .addComponent(inhibicioPDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel205)
                                        .addComponent(inhibicioPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flexibilitat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel206.setText("Temps de compteig:");

        jLabel234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel234.setText("-");

        jLabel210.setText("PD flexibilitat:");

        jLabel213.setText("PC:");

        jLabel207.setText("Temps d'alternança:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4)
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel207)
                                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                                .addComponent(jLabel213)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(flexibilitatPCField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel206)
                                                                        .addComponent(jLabel210))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(alternanTemps2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                                                        .addComponent(compteigTemps2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                                                        .addComponent(flexibilitatPDField, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                                                        .addComponent(jSeparator3))))
                                                .addGap(0, 39, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel207)
                                        .addComponent(alternanTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel234)
                                        .addComponent(jLabel206)
                                        .addComponent(compteigTemps2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel210)
                                        .addComponent(flexibilitatPDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel213)
                                        .addComponent(flexibilitatPCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calculPercentilsFiveDigit.setText("Marcar data");
        calculPercentilsFiveDigit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculPercentilsFiveDigitActionPerformed(evt);
            }
        });

        jButton22.setText("Veure taula");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
                Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel160)
                                        .addGroup(Panel4Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(Panel4Layout.createSequentialGroup()
                                                                .addComponent(calculPercentilsFiveDigit)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dataFive))
                                                        .addGroup(Panel4Layout.createSequentialGroup()
                                                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jButton22))))
                                .addContainerGap())
        );
        Panel4Layout.setVerticalGroup(
                Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel160)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel4Layout.createSequentialGroup()
                                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(calculPercentilsFiveDigit)
                                        .addComponent(dataFive))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton22)
                                .addContainerGap())
        );

        fiveDigitsScroll4.setViewportView(Panel4);

        add(fiveDigitsScroll4, "card5");
    }// </editor-fold>//GEN-END:initComponents

    private void fiveDigitStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart1ActionPerformed
        temps1.setText("00:00.00");
        temps2.setText("00:00.00");
        startTime = System.currentTimeMillis();
        timer.start();
        fiveDigitStart1.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (timer.isRunning()){
            temps1.setText(this.fiveDigitStart1.getText());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (timer.isRunning()){
            temps2.setText(this.fiveDigitStart1.getText());
            timer.stop();
            fiveDigitStart1.setText("<html><center>Comença Crono<br>Lectura");
            lecturaTemps.setText(this.temps2.getText());
            fiveDigitStart1.setEnabled(true);
        }else {
            fiveDigitStart1.setText("<html><center>Comença Crono<br>Lectura");
            fiveDigitStart1.setEnabled(true);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void fiveDigitStart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart2ActionPerformed
        temps3.setText("00:00.00");
        temps4.setText("00:00.00");
        startTime = System.currentTimeMillis();
        timer.start();
        fiveDigitStart2.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (timer.isRunning()){
            temps3.setText(this.fiveDigitStart2.getText());
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (timer.isRunning()){
            temps4.setText(this.fiveDigitStart2.getText());
            timer.stop();
            fiveDigitStart2.setText("<html><center>Comença Crono<br>Lectura");
            compteigTemps.setText(this.temps4.getText());
            fiveDigitStart2.setEnabled(true);
        }else {
            fiveDigitStart2.setText("<html><center>Comença Crono<br>Lectura");
            fiveDigitStart2.setEnabled(true);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void fiveDigitStart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart3ActionPerformed
        temps5.setText("00:00.00");
        temps6.setText("00:00.00");
        startTime = System.currentTimeMillis();
        timer.start();
        fiveDigitStart3.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (timer.isRunning()){
            temps5.setText(this.fiveDigitStart3.getText());
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (timer.isRunning()){
            temps6.setText(this.fiveDigitStart3.getText());
            timer.stop();
            fiveDigitStart3.setText("<html><center>Comença Crono<br>Lectura");
            eleccioTemps.setText(this.temps6.getText());
            fiveDigitStart3.setEnabled(true);
        }else {
            fiveDigitStart3.setText("<html><center>Comença Crono<br>Lectura");
            fiveDigitStart3.setEnabled(true);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void fiveDigitStart4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDigitStart4ActionPerformed
        temps7.setText("00:00.00");
        temps8.setText("00:00.00");
        startTime = System.currentTimeMillis();
        timer.start();
        fiveDigitStart4.setEnabled(false);
    }//GEN-LAST:event_fiveDigitStart4ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (timer.isRunning()){
            temps7.setText(this.fiveDigitStart4.getText());
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (timer.isRunning()){
            temps8.setText(this.fiveDigitStart4.getText());
            timer.stop();
            fiveDigitStart4.setText("<html><center>Comença Crono<br>Lectura");
            this.alternTemps.setText(this.temps8.getText());
            fiveDigitStart4.setEnabled(true);
        }else {
            fiveDigitStart4.setText("<html><center>Comença Crono<br>Lectura");
            fiveDigitStart4.setEnabled(true);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void calculPercentilsFiveDigitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculPercentilsFiveDigitActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataFive.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_calculPercentilsFiveDigitActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        File file = new File(Utils.RES_PATH+"FiveDigit.pdf");
        if (file.exists()){
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton22ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JTextField alternError1;
    private javax.swing.JTextField alternError2;
    private javax.swing.JLabel alternErrors;
    private javax.swing.JTextField alternErrorsPCField;
    private javax.swing.JLabel alternTemps;
    private javax.swing.JTextField alternTempsPCField;
    private javax.swing.JTextField alternanTemps2Field;
    private javax.swing.JButton calculPercentilsFiveDigit;
    private javax.swing.JTextField compteigError1;
    private javax.swing.JTextField compteigError2;
    private javax.swing.JLabel compteigErrors;
    private javax.swing.JTextField compteigErrorsPCField;
    private javax.swing.JLabel compteigTemps;
    private javax.swing.JTextField compteigTemps2Field;
    private javax.swing.JTextField compteigTempsPCField;
    private javax.swing.JLabel dataFive;
    private javax.swing.JTextField eleccioError1;
    private javax.swing.JTextField eleccioError2;
    private javax.swing.JLabel eleccioErrors;
    private javax.swing.JTextField eleccioErrorsPCField;
    private javax.swing.JLabel eleccioTemps;
    private javax.swing.JTextField eleccioTemps2Field;
    private javax.swing.JTextField eleccioTempsPCField;
    private javax.swing.JButton fiveDigitStart1;
    private javax.swing.JButton fiveDigitStart2;
    private javax.swing.JButton fiveDigitStart3;
    private javax.swing.JButton fiveDigitStart4;
    private javax.swing.JScrollPane fiveDigitsScroll;
    private javax.swing.JScrollPane fiveDigitsScroll1;
    private javax.swing.JScrollPane fiveDigitsScroll2;
    private javax.swing.JScrollPane fiveDigitsScroll3;
    private javax.swing.JScrollPane fiveDigitsScroll4;
    private javax.swing.JTextField flexibilitatPCField;
    private javax.swing.JTextField flexibilitatPDField;
    private javax.swing.JTextField inhibicioPCField;
    private javax.swing.JTextField inhibicioPDField;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
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
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField lecturaError1;
    private javax.swing.JTextField lecturaError2;
    private javax.swing.JLabel lecturaErrors;
    private javax.swing.JTextField lecturaErrorsPCField;
    private javax.swing.JLabel lecturaTemps;
    private javax.swing.JTextField lecturaTemps2Field;
    private javax.swing.JTextField lecturaTempsPCField;
    private javax.swing.JLabel temps1;
    private javax.swing.JLabel temps2;
    private javax.swing.JLabel temps3;
    private javax.swing.JLabel temps4;
    private javax.swing.JLabel temps5;
    private javax.swing.JLabel temps6;
    private javax.swing.JLabel temps7;
    private javax.swing.JLabel temps8;
    // End of variables declaration//GEN-END:variables
}
