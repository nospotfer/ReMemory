/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import model.Pacient;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import controlador.ZipDirectory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import controlador.Utils;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author USER
 */
public class MenuEvaluador extends javax.swing.JFrame {

    private boolean pacient = false;
    private Pacient pacientActual;
    private Utils utils;
    private String idPacient = "";
    private String evaluador;
    private ArrayList<Pacient> llistaPacients = new ArrayList<>();
    
    /**
     * Creates new form mainMenu
     */
    public MenuEvaluador(String evaluador) {
        Utils.setIcon(this);
        initComponents();
        this.evaluador = evaluador;
        evaluadorLabel.setText(evaluador.toUpperCase());
        this.setLocationRelativeTo(null);
        utils = new Utils();
        pacientActual = null;
        idText.requestFocusInWindow();
        this.getRootPane().setDefaultButton(seleccionaBtn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nomText = new javax.swing.JTextField();
        nouPacientBtn = new javax.swing.JButton();
        eliminaBtn = new javax.swing.JButton();
        seleccionaBtn = new javax.swing.JButton();
        fitxaBtn = new javax.swing.JButton();
        importaBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        evaluadorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú evaluador");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacient"));

        jLabel4.setText("ID:");

        idText.setEditable(false);

        jLabel5.setText("Nom:");

        nomText.setEditable(false);

        nouPacientBtn.setText("Nou pacient");
        nouPacientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nouPacientBtnActionPerformed(evt);
            }
        });

        eliminaBtn.setText("Elimina");
        eliminaBtn.setEnabled(false);
        eliminaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaBtnActionPerformed(evt);
            }
        });

        seleccionaBtn.setText("Selecciona");
        seleccionaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionaBtnActionPerformed(evt);
            }
        });

        fitxaBtn.setText("Fitxa");
        fitxaBtn.setEnabled(false);
        fitxaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fitxaBtnActionPerformed(evt);
            }
        });

        importaBtn.setText("Importa pacient");
        importaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomText)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fitxaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminaBtn)
                        .addGap(10, 10, 10)
                        .addComponent(nouPacientBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(importaBtn)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seleccionaBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionaBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nomText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fitxaBtn)
                    .addComponent(nouPacientBtn)
                    .addComponent(importaBtn)
                    .addComponent(eliminaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tests"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/test.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tests textuals");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pictureTest.png"))); // NOI18N
        jButton3.setEnabled(false);

        jLabel2.setText("Tests visuals");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Evaluació"));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/evaluacio.png"))); // NOI18N
        jButton2.setEnabled(false);

        jLabel3.setText("Full de càlcul");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backBtn.setText("Surt al menú principal");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Evaluador:");

        evaluadorLabel.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(evaluadorLabel))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(jLabel6)
                    .addComponent(evaluadorLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nouPacientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nouPacientBtnActionPerformed
        NewPacient nP = new NewPacient(this,true);
        nP.setVisible(true);
    }//GEN-LAST:event_nouPacientBtnActionPerformed

    private void seleccionaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionaBtnActionPerformed
        if (!pacient){
            try {
                try {
                    llistaPacients.clear();
                    JSONObject obj;
                    obj = new JSONObject(Utils.getStringFile(Utils.USERS_PATH));
                    org.json.JSONArray users = obj.getJSONArray("Users");
                    for (int i=0; i<users.length();i++){
                        if (users.getJSONObject(i).getString("role").equals("pacient")){
                            String nom = users.getJSONObject(i).getString("name");
                            String id = users.getJSONObject(i).getString("id");
                            Pacient pacient = new Pacient(nom, id, 0, 0);
                            llistaPacients.add(pacient);
                        }
                    }
                    if (llistaPacients.size() > 0) {
                        Object[] ids = new Object[llistaPacients.size()];
                        for (int i = 0; i < llistaPacients.size(); i++) {
                            ids[i] = llistaPacients.get(i).getId();
                        }
                        String s = (String) JOptionPane.showInputDialog(
                                this,
                                "Pacients: ",
                                "Llistat de pacients",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                ids,
                                ids[0]);

                        //If a string was returned, say so.
                        if ((s != null) && (s.length() > 0)) {
                            idText.setText(s);
                            checkPacient();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No s'ha introduït cap pacient a la base de dades");
                    }
                } catch (JSONException ex) {
                    Logger.getLogger(MenuEvaluador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(MenuEvaluador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            idText.setText("");
            nomText.setText("");
            seleccionaBtn.setText("Selecciona");
            importaBtn.setText("Importa pacient");
            pacient = false;
            eliminaBtn.setEnabled(false);
            fitxaBtn.setEnabled(false);
            idPacient = "";
        }
    }//GEN-LAST:event_seleccionaBtnActionPerformed

    private void fitxaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fitxaBtnActionPerformed
        FitxaPacient nF = new FitxaPacient(this,true,idPacient);
        nF.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        nF.setSize(screenSize.width, screenSize.height-30);
        nF.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                try {
                    guardarDadesPacient();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        nF.setVisible(true);
    }//GEN-LAST:event_fitxaBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Login l = new Login();
        l.pack();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (idPacient != ""){
            MenuValoracions mV = new MenuValoracions(this,true,pacientActual);
//            mT.addWindowListener(new WindowAdapter()
//            {
//                public void windowClosed(WindowEvent e)
//                {
//                  back();
//                }
//            });
            mV.pack();
            mV.setVisible(true);
            this.toBack();
        } else {
            JOptionPane.showMessageDialog(this,
            "Introdueix un pacient",
            "Alerta",
            JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void importaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importaBtnActionPerformed
        JFileChooser c = new JFileChooser();
        if (idPacient != ""){
            JSONObject o = new JSONObject();
            try {
                o.put("id",pacientActual.getId());
                o.put("name", pacientActual.getNom());
                o.put("role", "pacient");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            File outFile = null;
            PrintWriter out = null;
            try {
                File dataDir = new File(Utils.PACIENT_DATA_PATH+idPacient);
                if (!dataDir.exists()){
                    dataDir.mkdir();
                }
                outFile = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"pacient.json");
                try {
                    outFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = new PrintWriter(outFile.getAbsolutePath());

                out.write(o.toString());
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // Demonstrate "Save" dialog:
            int rVal = c.showSaveDialog(this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                String saveDir = c.getSelectedFile().getAbsoluteFile()+File.separator+idPacient;
                ZipDirectory.zipDirectory(new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator),saveDir);
            }
            outFile.delete();

        }  else {
            FileFilter filter = new FileNameExtensionFilter("ReMemory file","ReMemoryPacient");
            c.addChoosableFileFilter(filter);
            c.setAcceptAllFileFilterUsed(false);
            int rVal = c.showOpenDialog(this);

            if (rVal == JFileChooser.APPROVE_OPTION) {
                File file = c.getSelectedFile();
                String id = ZipDirectory.unZipIt(file.getAbsolutePath());
                addPacientFromFile(id);
                File dataFile = new File(Utils.PACIENT_DATA_PATH+id+ File.separator+"pacient.json");
                dataFile.delete();
            }

        }

    }//GEN-LAST:event_importaBtnActionPerformed

    private void eliminaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaBtnActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Segur que vols eliminar el pacient?", "Eliminar?",  JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            Iterator<Pacient> iter = llistaPacients.iterator();

            while (iter.hasNext()) {
                Pacient pacient = iter.next();

                if (pacient.getId().equals(pacientActual.getId()))
                    iter.remove();
            }
            guardarJSON();
            seleccionaBtn.doClick();
        }

    }//GEN-LAST:event_eliminaBtnActionPerformed

    private void guardarJSON() {
        JSONArray usr = new JSONArray();
        JSONObject obj = new JSONObject();

        getUsers(usr);

        for (Pacient e : llistaPacients){
            try {
                usr.put(e.toJSON());
            } catch (JSONException ex) {
                Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            obj.put("Users", usr);
        } catch (JSONException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(Utils.USERS_PATH);
            out.write(obj.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private void getUsers(JSONArray u) {
        JSONObject obj;
        try {
            obj = new JSONObject(Utils.getStringFile(Utils.USERS_PATH));
            JSONArray users = obj.getJSONArray("Users");
            for (int i=0; i<users.length();i++){
                if (!users.getJSONObject(i).getString("role").equals("pacient")){
                    u.put(users.getJSONObject(i));
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addPacientFromFile(String id) {
        JSONObject obj = null;
        JSONObject pacient = null;
        try {
            obj = new JSONObject(Utils.getStringFile(Utils.USERS_PATH));
            pacient = new JSONObject(Utils.getStringFile(Utils.PACIENT_DATA_PATH+id+ File.separator+"pacient.json"));

            JSONArray users = obj.getJSONArray("Users");
            int i = 0;
            boolean trobat = false;
            while ( i < users.length() && !trobat){
                if (users.getJSONObject(i).getString("name").equals(pacient.getString("name"))){
                    trobat = true;
                }
                i++;
            }

            if (trobat){
                /*
                int result = JOptionPane.showConfirmDialog(this, "El pacient ja existeix, el vols sobreescrire?",
        "Alerta", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    importaPacient(obj, pacient, users);
                    System.out.println("pacient importat");
                }else {
                    System.out.println("pacient no importat");
                }
                */
            } else{
                importaPacient(obj, pacient, users);
            }
        } catch (JSONException ex) {
            Logger.getLogger(NewPacient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewPacient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void importaPacient(JSONObject obj, JSONObject pacient, JSONArray users) throws JSONException, FileNotFoundException {
        int i;
        JSONArray usr = new JSONArray();
        for (i = 0; i < users.length(); i++){
            usr.put(users.getJSONObject(i));
        }

        usr.put(pacient);

        obj.put("Users", usr);
        PrintWriter out = new PrintWriter(Utils.USERS_PATH);
        out.write(obj.toString());
        out.close();
    }

    private void back(){
        this.toBack();
    }
    
    private void checkPacient() throws JSONException, IOException{
        JSONObject obj;
        obj = new JSONObject(utils.getStringFile(Utils.USERS_PATH));
        org.json.JSONArray pacients = obj.getJSONArray("Users");
        int i = 0;
        boolean trobat = false;
        while ( i < pacients.length() && !trobat){
            if (pacients.getJSONObject(i).getString("id").equals(idText.getText().toLowerCase()) && pacients.getJSONObject(i).getString("role").equals("pacient")){
                trobat = true;
            }
            else{
                i++;
            }
        }
        if (trobat){
            idText.setEditable(false);
            idPacient = pacients.getJSONObject(i).getString("id");
            seleccionaBtn.setText("Canvia pacient");
            importaBtn.setText("Exporta pacient");
            String nom = pacients.getJSONObject(i).getString("name");
            nomText.setText(nom.toUpperCase());

            guardarDadesPacient();
            pacient = true;
            eliminaBtn.setEnabled(true);
            fitxaBtn.setEnabled(true);
        } else{
//            System.out.println(trobat);
        }
    }

    private void guardarDadesPacient() throws IOException {
        File file = new File(Utils.PACIENT_DATA_PATH+Utils.SEP+idPacient+Utils.SEP+idPacient+"Fitxa.dat");
        System.out.println(file.getAbsolutePath());
        Properties prop = new Properties();
        InputStream input = null;

        int anysEscola = -1;
        int edat = -1;

        if(!file.exists()) {

        }
        else{
            input = new FileInputStream(file);

            // load a properties file
            prop.load(input);
            if (prop.get("anysEscolaritat") != null){
                anysEscola = Integer.parseInt((String)prop.get("anysEscolaritat"));
            }

            if (prop.getProperty("dataNaixement") != null){
                if (!prop.getProperty("dataNaixement").equals("")){
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date data;
                    try {
                        data = df.parse(prop.getProperty("dataNaixement"));
                        System.out.println(data);
                        LocalDate today = LocalDate.now();
                        LocalDate birthday = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;

                        Period p = Period.between(birthday, today);
                        edat = p.getYears();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        pacientActual = new Pacient(nomText.getText().toLowerCase(),idPacient,edat,anysEscola);
        System.out.println("EDAT: "+edat+"\nANYS ESCOLA: "+anysEscola);
    }

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
            java.util.logging.Logger.getLogger(MenuEvaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEvaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEvaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEvaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEvaluador("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton eliminaBtn;
    private javax.swing.JLabel evaluadorLabel;
    private javax.swing.JButton fitxaBtn;
    private javax.swing.JTextField idText;
    private javax.swing.JButton importaBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nomText;
    private javax.swing.JButton nouPacientBtn;
    private javax.swing.JButton seleccionaBtn;
    // End of variables declaration//GEN-END:variables
}
