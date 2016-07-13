/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.POIDocument;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jdesktop.swingx.JXTable;
import vista.NewUser;

/**
 *
 * @author USER
 */
public class Utils {

    private static int textF = 0;
    private static int combo = 0;
    private static int textA = 0;
    private static int check = 0;
    private static int table = 0;
    private static int tButton = 0;
    private static int button = 0;
    private static int label = 0;
    private static int radioButton = 0;

    public static final String SEP = File.separator;
    public static final String PACIENT_DATA_PATH = System.getenv("APPDATA")+SEP+"ReMemory"+SEP+"pacientData"+SEP;
    public static final String USERS_PATH = System.getenv("APPDATA")+SEP+"ReMemory"+SEP+"res"+SEP+"users.json";
    public static final String RES_PATH = System.getenv("APPDATA")+SEP+"ReMemory"+SEP+"res"+SEP;
    
    public static String getStringFile(String file) {
	BufferedReader reader = null;
	try {
	    reader = new BufferedReader( new FileReader (file));
	    String line;
	    StringBuilder stringBuilder = new StringBuilder();
	    String ls = System.getProperty("line.separator");
	    while( ( line = reader.readLine() ) != null ) {
		stringBuilder.append( line );
		stringBuilder.append( ls );
	    }
	    return stringBuilder.toString();
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		if(reader != null)
		    reader.close();
	    } catch (IOException ex) {
		Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return null;
    }
    
    public static void setProperty(Properties prop, String nom, JComboBox cb){
        prop.setProperty(nom, ((cb.getSelectedIndex()==-1) ? "" : cb.getSelectedItem().toString()));
    }
    
    public static void setProperty(Properties prop, String nom, JTextField tf){
        prop.setProperty(nom, tf.getText());
    }
    
    public static void setProperty(Properties prop, String nom, JDateChooser dc){
        prop.setProperty(nom, ((dc.getDate()==null) ? "" : new SimpleDateFormat("dd/MM/yyyy").format(dc.getDate())));
    }
    
    public static void getProperty(Properties prop, String nom, JComboBox cb){
        cb.setSelectedItem(prop.getProperty(nom));
    }
    
    public static void getProperty(Properties prop, String nom, JTextField tf){
        tf.setText(prop.getProperty(nom));
    }
    
    public static void getProperty(Properties prop, String nom, JDateChooser dc){
        if (prop.getProperty(nom) != null){
            if (!prop.getProperty(nom).equals("")){
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
                Date data;
                try {
                data = df.parse(prop.getProperty(nom));
                dc.setDate(data);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setProperty(Properties prop, String nom, JCheckBox check) {
        String ch = "no";
        if (check.isSelected())ch = "si";
        prop.setProperty(nom, ch);
    }
    
    public static void getProperty(Properties prop, String nom, JCheckBox check) {
        if (prop.getProperty(nom)!= null){
            if ("si".equals(prop.getProperty(nom))){
                check.setSelected(true);
            }
            else {
                check.setSelected(false);
            }
        }
    }
    
    public static void setProperty(Properties prop, String nom, JRadioButton check) {
        String ch = "no";
        if (check.isSelected())ch = "si";
        prop.setProperty(nom, ch);
    }
    
    public static void getProperty(Properties prop, String nom, JRadioButton check) {
        if (prop.getProperty(nom)!= null){
            if ("si".equals(prop.getProperty(nom))){
                check.setSelected(true);
            }
            else {
                check.setSelected(false);
            }
        }
    }
    
    public static void setProperty(Properties prop, String nom, JToggleButton check) {
        String ch = "no";
        if (check.isSelected())ch = "si";
        prop.setProperty(nom, ch);
    }
    
    public static void getProperty(Properties prop, String nom, JToggleButton check) {
        if (prop.getProperty(nom)!= null){
            if ("si".equals(prop.getProperty(nom))){
                check.setSelected(true);
            }
            else {
                check.setSelected(false);
            }
        }
    }

    public static void setPropertyText(Properties prop, String nom, JToggleButton check) {
        prop.setProperty(nom, check.getText());
    }

    public static void getPropertyText(Properties prop, String nom, JToggleButton check) {
        if (prop.getProperty(nom) != null) {
            check.setText(prop.getProperty(nom));
        }
    }

    public static void setPropertyText(Properties prop, String nom, JButton btn) {
        prop.setProperty(nom, btn.getText());
    }

    public static void getPropertyText(Properties prop, String nom, JButton btn) {
        if (prop.getProperty(nom) != null) {
            btn.setText(prop.getProperty(nom));
        }
    }

    public static void getProperty(Properties prop, String nom, JTextArea tf){
        tf.setText(prop.getProperty(nom));
    }
    public static void setProperty(Properties prop, String nom, JTextArea tf){
        prop.setProperty(nom, tf.getText());
    }

    public static void setProperty(Properties prop, String nom, JLabel jLabel) {
        prop.setProperty(nom, jLabel.getText());
    }

    public static void getProperty(Properties prop, String nom, JLabel jLabel) {
        if (prop.getProperty(nom) != null) {
            String text = prop.getProperty(nom);
            jLabel.setText(text);
        }
    }

    public static int getPunctuationFromButtonGroup(ButtonGroup buttonGroup){
        if (buttonGroup.getSelection() != null){
            System.out.println(buttonGroup.getSelection().getActionCommand());
            return Integer.parseInt(buttonGroup.getSelection().getActionCommand());
        } else {
            return 0;
        }
    }

    public static void setActionCommands(Container c){
        Component[] components = c.getComponents();
        for (Component com : components){
            if (com instanceof JToggleButton && !(com instanceof JCheckBox) && !(com instanceof JRadioButton)){
                ((JToggleButton) com).setActionCommand(((JToggleButton)com).getText());
            }
            else if (com instanceof Container){
                setActionCommands((Container) com);
            }
        }
    }

    public static void actualitzaResultatTaula(JPanel panel, JLabel label){
        int count = 0;
        for (Component com : panel.getComponents()){
            if (com instanceof JToggleButton){
                if(((JToggleButton)com).isSelected()){
                    count += Integer.parseInt(((JToggleButton)com).getText());
                }
            }
        }
        label.setText(count+"");
    }

    public static void initTaula(JPanel panel, JLabel label){
        for (Component com : panel.getComponents()){
            if (com instanceof JToggleButton){
                ((JToggleButton)com).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actualitzaResultatTaula(panel,label);
                    }
                });
            }
        }
    }

    public static void guardar(Container panel, String idPacient, String test) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            File f = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator);
            if (!f.exists()){
                f.mkdir();
            }
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+test+".dat");
            if(!file.exists()) {
                file.createNewFile();
            }
            output = new FileOutputStream(file);

            table = label = textF = combo = check = textA = tButton = button = radioButton = 0;
            setComponents(prop, panel);
            prop.store(output, "VALORACIO COGNITIVA PREVIA");
        }
        catch(IOException e){
            System.out.println(e.toString());
            System.out.println("EEEEEERROR");
        }finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("ERROR OUTPUT");
                }
            }
        }
    }

    public static void setComponents(Properties prop,Container c) {
        Component[] components = c.getComponents();
        for (Component com : components){

            if (com instanceof JTextField){
                Utils.setProperty(prop, "textField"+textF, (JTextField) com);
                textF++;
            }
            else if (com instanceof JComboBox){
                Utils.setProperty(prop, "comboBox"+combo, (JComboBox) com);
                combo++;
            }
            else if (com instanceof JTextArea){
                Utils.setProperty(prop, "textArea"+textA, (JTextArea) com);
                textA++;
            }
            else if (com instanceof JToggleButton && !(com instanceof JCheckBox) && !(com instanceof JRadioButton) && !(com instanceof JButton)){
                Utils.setProperty(prop, "toggleButton"+tButton, (JToggleButton) com);
                setPropertyText(prop, "toggleButtonText"+tButton,(JToggleButton) com);
                tButton++;
            }
            else if (com instanceof JButton){
                setPropertyText(prop, "buttonText"+button,(JButton) com);
                button++;
            }
            else if (com instanceof JRadioButton){
                Utils.setProperty(prop, "radioButton"+radioButton, (JRadioButton) com);
                radioButton++;
            }
            else if (com instanceof JCheckBox ){
                Utils.setProperty(prop, "checkBox"+check, (JCheckBox) com);
                check++;
            }
            else if (com instanceof JLabel){
                Utils.setProperty(prop, "label"+label, (JLabel) com);
                label++;
            }
            else if (com instanceof JXTable){
                setProperty(prop, "table"+table ,(JXTable)com);
                table++;
            }
            else if (com instanceof Container){
                setComponents(prop, (Container) com);
            }
        }
    }

    public static void carregar(Container panel, String idPacient, String test) {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+test+".dat");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                table = label = textF = combo = check = textA = tButton = button = radioButton = 0;
                getComponents(prop, panel);
            }
        }
        catch(IOException e){
            System.out.println("EERRRROOOOOOR");
        }finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("ERROR INPUT");
                }
            }
        }
    }

    public static void getComponents(Properties prop,Container c) {
        Component[] components = c.getComponents();
        for (Component com : components){

            if (com instanceof JTextField){
                Utils.getProperty(prop, "textField"+textF, (JTextField) com);
                textF++;
            }
            else if (com instanceof JComboBox){
                Utils.getProperty(prop, "comboBox"+combo, (JComboBox) com);
                combo++;
            }
            else if (com instanceof JTextArea){
                Utils.getProperty(prop, "textArea"+textA, (JTextArea) com);
                textA++;
            }
            else if (com instanceof JToggleButton && !(com instanceof JCheckBox) && !(com instanceof JRadioButton) && !(com instanceof JButton)){
                Utils.getProperty(prop, "toggleButton"+tButton, (JToggleButton) com);
                getPropertyText(prop, "toggleButtonText"+tButton, (JToggleButton) com);
                tButton++;
            }
            else if (com instanceof JButton){
                getPropertyText(prop, "buttonText"+button,(JButton) com);
                button++;
            }
            else if (com instanceof JRadioButton){
                Utils.getProperty(prop, "radioButton"+radioButton, (JRadioButton) com);
                radioButton++;
            }
            else if (com instanceof JCheckBox ){
                Utils.getProperty(prop, "checkBox"+check, (JCheckBox) com);
                check++;
            }
            else if (com instanceof JLabel){
                getProperty(prop, "label"+label, (JLabel) com);
                label++;
            }
            else if (com instanceof JXTable){
                getProperty(prop, "table"+table, (JXTable)com);
                table++;
            }
            else if (com instanceof Container){
                getComponents(prop, (Container) com);
            }
        }
    }

    private static void getProperty(Properties prop, String nom, JXTable com) {

        DefaultTableModel dtm = (DefaultTableModel) com.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                if (prop.getProperty(nom+"_"+i+"_"+j) != null) {
                    dtm.setValueAt(prop.getProperty(nom + "_" + i + "_" + j), i, j);
                }
    }

    private static void setProperty(Properties prop,String nom, JXTable com) {
        Object[][] objects = getTableData(com);
        for(int i=0; i<objects.length; i++) {
            for(int j=0; j<objects[i].length; j++) {
                Object obj = objects[i][j];
                if (obj != null) {
                    prop.setProperty(nom + "_" + i + "_" + j, obj + "");
                }
            }
        }
    }

    public static Object[][] getTableData (JXTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        return tableData;
    }
    
    public static void setIcon(JFrame frame){
        URL url = ClassLoader.getSystemResource("resources/ReMemory.ico");
        URL iconURL = frame.getClass().getResource("/resources/ReMemory.png");
// iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());
    }

    public static void generaResultatsCSV(String idPacient){
        File outFile = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"Resultats.csv");
        try {
            if (!outFile.exists()){
                outFile.createNewFile();
            }
	        Writer writer = new OutputStreamWriter(
                    new FileOutputStream(outFile), "UTF-8");
            writeHeader(writer, idPacient);
            writer.append('\n');
            writer.append(';');
            writeValoracioCognitivaPrevia(idPacient,writer);
            for (int i=1; i<=3; i++){
                writer.append(';');
                writeSessio1(idPacient, i, writer);
                writer.append(';');
                writeSessio2(idPacient, i, writer);
                writer.append(';');
                writeValoracioCuidador(idPacient, i, writer);
                //writer.append('\n');
            }
            writer.flush();
	        writer.close();

            csvToXLSX(idPacient);

        }
        catch(IOException e)
        {
             e.printStackTrace();
        }
    }

    private static void writeHeader(Writer writer, String idPacient) throws IOException {
        writeLineCSV(writer,"Pacient: "+idPacient);
        //Valoracio cognitiva previa
        writeLineCSV(writer,"CDR");
        writeLineCSV(writer,"CRC total");
        writeLineCSV(writer,"TAP total");
        writeLineCSV(writer,"TAP CI estimat");
        writeLineCSV(writer,"MMSE total");

        writer.append(";");

        for (int i=1; i<4; i++) {
            //Sessio1
            // Digits directe
            writeLineCSV(writer, "SpanDD_T"+i);
            writeLineCSV(writer, "Puntuacio directa DD_T"+i);
            writeLineCSV(writer, "Percentil DD_T"+i);
            writeLineCSV(writer, "NSSA DD_T"+i);
            // Digits invers
            writeLineCSV(writer, "SpanDI_T"+i);
            writeLineCSV(writer, "Puntuacio directa DI_T"+i);
            writeLineCSV(writer, "Percentil DI_T"+i);
            writeLineCSV(writer, "NSSA DI_T"+i);
            // MLI
            writeLineCSV(writer, "MLI directa_T"+i);
            writeLineCSV(writer, "MLI escalar_T"+i);
            // COGSTSTATE
            writeLineCSV(writer, "ISL1.DUR_T"+i);
            writeLineCSV(writer, "ISL1.ACC_T"+i);
            writeLineCSV(writer, "ISL1.CORR_T"+i);
            writeLineCSV(writer, "ISL1.ERR_T"+i);
            writeLineCSV(writer, "ISL1.STI_T"+i);
            writeLineCSV(writer, "ISL2.DUR_T"+i);
            writeLineCSV(writer, "ISL2.ACC_T"+i);
            writeLineCSV(writer, "ISL2.CORR_T"+i);
            writeLineCSV(writer, "ISL2.ERR_T"+i);
            writeLineCSV(writer, "ISL2.STI_T"+i);
            writeLineCSV(writer, "ISL3.DUR_T"+i);
            writeLineCSV(writer, "ISL3.ACC_T"+i);
            writeLineCSV(writer, "ISL3.CORR_T"+i);
            writeLineCSV(writer, "ISL3.ERR_T"+i);
            writeLineCSV(writer, "ISL3.STI_T"+i);
            writeLineCSV(writer, "DET.COR_T"+i);
            writeLineCSV(writer, "DET.ERR_T"+i);
            writeLineCSV(writer, "DET.LMN_T"+i);
            writeLineCSV(writer, "DET.LSD_T"+i);
            writeLineCSV(writer, "DET.ACC_T"+i);
            writeLineCSV(writer, "IDN.COR_T"+i);
            writeLineCSV(writer, "IDN.ERR_T"+i);
            writeLineCSV(writer, "IDN.LMN_T"+i);
            writeLineCSV(writer, "IDN.LSD_T"+i);
            writeLineCSV(writer, "IDN.ACC_T"+i);
            writeLineCSV(writer, "OCL.COR_T"+i);
            writeLineCSV(writer, "OCL.ERR_T"+i);
            writeLineCSV(writer, "OCL.LMN_T"+i);
            writeLineCSV(writer, "OCL.LSD_T"+i);
            writeLineCSV(writer, "OCL.ACC_T"+i);
            writeLineCSV(writer, "ONB.COR_T"+i);
            writeLineCSV(writer, "ONB.ERR_T"+i);
            writeLineCSV(writer, "ONB.LMN_T"+i);
            writeLineCSV(writer, "ONB.LSD_T"+i);
            writeLineCSV(writer, "ONB.ACC_T"+i);
            writeLineCSV(writer, "SECT.COR_T"+i);
            writeLineCSV(writer, "SECT.ERR_T"+i);
            writeLineCSV(writer, "SECT.LMN_T"+i);
            writeLineCSV(writer, "SECT.LSD_T"+i);
            writeLineCSV(writer, "SECT.ACC_T"+i);
            writeLineCSV(writer, "ISRL.CORR_T"+i);
            writeLineCSV(writer, "ISRL.ERR_T"+i);
            writeLineCSV(writer, "ISRL.ACC_T"+i);
            writeLineCSV(writer, "ISRL.DUR_T"+i);
            // MLII
            writeLineCSV(writer, "MLII directa_T"+i);
            writeLineCSV(writer, "MLII escalar_T"+i);
            // MLII Reco
            writeLineCSV(writer, "ML Reconeixement_T"+i);
            //BNT
            writeLineCSV(writer, "BNT correctes_T"+i);
            writeLineCSV(writer, "BNT ajuda semantica_T"+i);
            writeLineCSV(writer, "BNT percentil_T"+i);
            writeLineCSV(writer, "BNT NSSA_T"+i);
            // Color trails 1
            writeLineCSV(writer, "Color trails 1 - Time Raw_T"+i);
            writeLineCSV(writer, "CT 1 - Time Standard_T"+i);
            writeLineCSV(writer, "CT 1 - Time Tscore_T"+i);
            writeLineCSV(writer, "CT 1 - Time Percentile_T"+i);
            writeLineCSV(writer, "CT 1 - Errors Raw_T"+i);
            writeLineCSV(writer, "CT 1 - Errors Percentile_T"+i);
            writeLineCSV(writer, "CT 1 - Near-Misses Raw_T"+i);
            writeLineCSV(writer, "CT 1 - Near-Misses Percentile_T"+i);
            writeLineCSV(writer, "CT 1 - Prompts Raw_T"+i);
            writeLineCSV(writer, "CT 1 - Prompts Percentile_T"+i);
            // Color trails 2
            writeLineCSV(writer, "Color trails 2 - Time Raw_T"+i);
            writeLineCSV(writer, "CT 2 - Time Standard_T"+i);
            writeLineCSV(writer, "CT 2 - Time Tscore_T"+i);
            writeLineCSV(writer, "CT 2 - Time Percentile_T"+i);
            writeLineCSV(writer, "CT 2 - Errors Raw_T"+i);
            writeLineCSV(writer, "CT 2 - Errors Percentile_T"+i);
            writeLineCSV(writer, "CT 2 - Near-Misses Raw_T"+i);
            writeLineCSV(writer, "CT 2 - Near-Misses Percentile_T"+i);
            writeLineCSV(writer, "CT 2 - Prompts Raw_T"+i);
            writeLineCSV(writer, "CT 2 - Prompts Percentile_T"+i);
            // Color trails interference Index
            writeLineCSV(writer, "Color trails - Interference index Raw_T"+i);
            writeLineCSV(writer, "CT - Interference index Percentile_T"+i);
            // Five digits
            writeLineCSV(writer, "Five Digits - Lectura Temps_T"+i);
            writeLineCSV(writer, "FD - Lectura Temps PC_T"+i);
            writeLineCSV(writer, "FD - Lectura Errors_T"+i);
            writeLineCSV(writer, "FD - Lectura Errors PC_T"+i);
            writeLineCSV(writer, "Five Digits - Compteig Temps_T"+i);
            writeLineCSV(writer, "FD - Compteig Temps PC_T"+i);
            writeLineCSV(writer, "FD - Compteig Errors_T"+i);
            writeLineCSV(writer, "FD - Compteig Errors PC_T"+i);
            writeLineCSV(writer, "Five Digits - Eleccio Temps_T"+i);
            writeLineCSV(writer, "FD - Eleccio Temps PC_T"+i);
            writeLineCSV(writer, "FD - Eleccio Errors_T"+i);
            writeLineCSV(writer, "FD - Eleccio Errors PC_T"+i);
            writeLineCSV(writer, "Five Digits - Alternança Temps_T"+i);
            writeLineCSV(writer, "FD - Alternança Temps PC_T"+i);
            writeLineCSV(writer, "FD - Alternança Errors_T"+i);
            writeLineCSV(writer, "FD - Alternança Errors PC_T"+i);
            writeLineCSV(writer, "Five Digits - Inhibició PC_T"+i);
            writeLineCSV(writer, "Five Digits - Flexibilitat PC_T"+i);
            // Fluencia verbal
            writeLineCSV(writer, "Fluencia verbal - P_T"+i);
            writeLineCSV(writer, "FV - M_T"+i);
            writeLineCSV(writer, "FV - R_T"+i);
            writeLineCSV(writer, "FV - Animals_T"+i);

            writer.append(";");

            //Sessio 2
            writeLineCSV(writer, "MoCA_T"+i);
            writeLineCSV(writer, "UPSA Comunicacio_T"+i);
            writeLineCSV(writer, "UPSA Comprensió_T"+i);
            writeLineCSV(writer, "UPSA total_T"+i);
            writeLineCSV(writer, "MFE_T"+i);
            writeLineCSV(writer, "HAD-A_T"+i);
            writeLineCSV(writer, "HAD-D_T"+i);
            writeLineCSV(writer, "QoL-AD_T"+i);
            writeLineCSV(writer, "Duke_T"+i);
            writeLineCSV(writer, "Rosemberg_T"+i);

            writer.append(";");

            //Valoracio cuidador
            writeLineCSV(writer, "FAQ_T"+i);
            writeLineCSV(writer, "NPI_T"+i);
            writeLineCSV(writer, "HAD-A_T"+i);
            writeLineCSV(writer, "HAD-D_T"+i);
            writeLineCSV(writer, "ZARIT_T"+i);
            writeLineCSV(writer, "SF-12_T"+i);
            writeLineCSV(writer, "Duke_T"+i);

            writer.append(";");
        }

    }

    private static void writeLineCSV(Writer writer, String s) throws IOException {
        writer.append(s);
        writer.append(';');
    }

    private static void writeSessio1(String idPacient, int i, Writer writer) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"resultsSessio1_T"+i+".dat");
            if(!file.exists()) {
                writeBlank(writer,61);
            }
            else{
                input = new FileInputStream(file);

                    // load a properties file
                prop.load(input);

                // Digits directe
                propertyToCSV(writer,prop,"spanDD");
                propertyToCSV(writer,prop,"puntuacioDirectaDD");
                propertyToCSV(writer,prop,"percentilDD");
                propertyToCSV(writer,prop,"nssaDD");
                // Digits invers
                propertyToCSV(writer,prop,"spanDI");
                propertyToCSV(writer,prop,"puntuacioDirectaDI");
                propertyToCSV(writer,prop,"percentilDI");
                propertyToCSV(writer,prop,"nssaDI");
                // Memoria logica I
                propertyToCSV(writer,prop,"ML1Total");
                propertyToCSV(writer,prop,"puntuacioML1");

                // COGSTATE
                writeCogstate(idPacient, i, writer);

                // Memoria logica II
                propertyToCSV(writer,prop,"ML2Total");
                propertyToCSV(writer,prop,"puntuacioML2");
                // MLII Rec
                propertyToCSV(writer,prop,"totalRec");
                // BNT
                propertyToCSV(writer,prop,"totalBnt"+i);
                propertyToCSV(writer,prop,"semanticaBnt"+i);
                propertyToCSV(writer,prop,"percentilBNT"+i);
                propertyToCSV(writer,prop,"nssaBNT"+i);
                // Color trails 1 time
                propertyToCSV(writer,prop,"color1timeRaw");
                propertyToCSV(writer,prop,"color1timeStandard");
                propertyToCSV(writer,prop,"color1timeTscore");
                propertyToCSV(writer,prop,"color1timePercentile");
                // Color trails 1 errors
                propertyToCSV(writer,prop,"color1errorRaw");
                propertyToCSV(writer,prop,"color1errorPercentile");
                // Color trails 1 Near misses
                propertyToCSV(writer,prop,"color1nearRaw");
                propertyToCSV(writer,prop,"color1nearPercentile");
                // Color trails 1 prompts
                propertyToCSV(writer,prop,"color1promptsRaw");
                propertyToCSV(writer,prop,"color1promptsPercentile");
                // Color trails 2 time in seconds
                propertyToCSV(writer,prop,"color2timeRaw");
                propertyToCSV(writer,prop,"color2timeStandard");
                propertyToCSV(writer,prop,"color2timeTscore");
                propertyToCSV(writer,prop,"color2timePercentile");
                // Color trails 2 errors
                propertyToCSV(writer,prop,"color2errorRaw");
                propertyToCSV(writer,prop,"color2errorPercentile");
                // Color trails 2 Near misses
                propertyToCSV(writer,prop,"color2nearRaw");
                propertyToCSV(writer,prop,"color2nearPercentile");
                // Color trails 2 prompts
                propertyToCSV(writer,prop,"color2promptsRaw");
                propertyToCSV(writer,prop,"color2promptsPercentile");
                // Color trails interference index
                propertyToCSV(writer,prop,"colorInterferenceRaw");
                propertyToCSV(writer,prop,"colorInterferencePercentile");
                // Five digit
                propertyToCSV(writer,prop,"lecturaTemps");
                propertyToCSV(writer,prop,"lecturaTempsPCField");
                propertyToCSV(writer,prop,"lecturaErrorsField");
                propertyToCSV(writer,prop,"lecturaErrorsPCField");
                // Five digit
                propertyToCSV(writer,prop,"compteigTemps");
                propertyToCSV(writer,prop,"compteigTempsPCField");
                propertyToCSV(writer,prop,"compteigErrors");
                propertyToCSV(writer,prop,"compteigErrorsPCField");
                // Five digit
                propertyToCSV(writer,prop,"lecturaTemps");
                propertyToCSV(writer,prop,"lecturaTempsPCField");
                propertyToCSV(writer,prop,"lecturaErrorsField");
                propertyToCSV(writer,prop,"lecturaErrorsPCField");
                // Five digit
                propertyToCSV(writer,prop,"alternTemps");
                propertyToCSV(writer,prop,"alternTempsPCField");
                propertyToCSV(writer,prop,"alternErrors");
                propertyToCSV(writer,prop,"alternErrorsPCField");
                // Five digit
                propertyToCSV(writer,prop,"inhibicioPCField");
                propertyToCSV(writer,prop,"flexibilitatPCField");
                // Fluencia verbal
                propertyToCSV(writer,prop,"fluenciaP");
                propertyToCSV(writer,prop,"fluenciaM");
                propertyToCSV(writer,prop,"fluenciaR");
                propertyToCSV(writer,prop,"fluenciaAnimals");

            }

        } catch (IOException ex) {
                ex.printStackTrace();
        } finally {
                if (input != null) {
                        try {
                                input.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
    }

    private static void writeCogstate(String idPacient, int i, Writer writer) throws IOException {
        File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+idPacient+"COGSTATE_T"+i+".xlsx");
        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook (fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            // ISL1
            writeCell(writer,sheet,"L5");
            writeCell(writer,sheet,"S5");
            writeCell(writer,sheet,"T5");
            writeCell(writer,sheet,"U5");
            writeCell(writer,sheet,"Y5");
            // ISL2
            writeCell(writer,sheet,"L6");
            writeCell(writer,sheet,"S6");
            writeCell(writer,sheet,"T6");
            writeCell(writer,sheet,"U6");
            writeCell(writer,sheet,"Y6");
            //ISL3
            writeCell(writer,sheet,"L7");
            writeCell(writer,sheet,"S7");
            writeCell(writer,sheet,"T7");
            writeCell(writer,sheet,"U7");
            writeCell(writer,sheet,"Y7");
            // DET
            writeCell(writer,sheet,"T3");
            writeCell(writer,sheet,"U3");
            writeCell(writer,sheet,"Q3");
            writeCell(writer,sheet,"R3");
            writeCell(writer,sheet,"S3");
            // IDN
            writeCell(writer,sheet,"T2");
            writeCell(writer,sheet,"U2");
            writeCell(writer,sheet,"Q2");
            writeCell(writer,sheet,"R2");
            writeCell(writer,sheet,"S2");
            // OCL
            writeCell(writer,sheet,"T9");
            writeCell(writer,sheet,"U9");
            writeCell(writer,sheet,"Q9");
            writeCell(writer,sheet,"R9");
            writeCell(writer,sheet,"S9");
            // ONB
            writeCell(writer,sheet,"T10");
            writeCell(writer,sheet,"U10");
            writeCell(writer,sheet,"Q10");
            writeCell(writer,sheet,"R10");
            writeCell(writer,sheet,"S10");
            // SECT
            writeCell(writer,sheet,"T11");
            writeCell(writer,sheet,"U11");
            writeCell(writer,sheet,"Q11");
            writeCell(writer,sheet,"R11");
            writeCell(writer,sheet,"S11");
            // ISRL
            writeCell(writer,sheet,"T8");
            writeCell(writer,sheet,"U8");
            writeCell(writer,sheet,"S8");
            writeCell(writer,sheet,"L8");
        } else {
            writeBlank(writer,44);
        }
    }

    private static void writeCell(Writer writer, XSSFSheet sheet, String cell) throws IOException {
        String line = getStringFromCell(sheet, cell);
        writer.append(line);
        writer.append(";");
    }

    private static String getStringFromCell(XSSFSheet sheet, String cell) {
        System.out.println(cell);
        CellReference cellReference = new CellReference(cell);
        XSSFRow row = sheet.getRow(cellReference.getRow());
        XSSFCell c = row.getCell(cellReference.getCol());
        c.setCellType(XSSFCell.CELL_TYPE_STRING);
        return c.getStringCellValue();
    }

    private static void writeSessio2(String idPacient, int i, Writer writer) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"resultsSessio2_T"+i+".dat");
            if(!file.exists()) {
                writeBlank(writer,9);
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                // MOCA
                propertyToCSV(writer,prop,"puntTotalMoca1");
                // UPSA
                propertyToCSV(writer,prop,"comunicacioSub");
                propertyToCSV(writer,prop,"comprensioSub");
                propertyToCSV(writer,prop,"upsaTotal");
                // MFE
                propertyToCSV(writer,prop,"mfeTotal");
                // HAD
                propertyToCSV(writer,prop,"hadTotalA");
                propertyToCSV(writer,prop,"hadTotalD");
                // QOL-AD
                propertyToCSV(writer,prop,"qolTotal");
                // DUKE
                propertyToCSV(writer,prop,"dukeTotal");
                // RSE
                propertyToCSV(writer,prop,"rseTotal");

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeValoracioCuidador(String idPacient, int i, Writer writer) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"resultsValCuid_T"+i+".dat");
            if(!file.exists()) {
                writeBlank(writer, 6);
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                // FAQ
                propertyToCSV(writer,prop,"faqTotal");
                // NPI
                propertyToCSV(writer,prop,"npiTotal");
                // HAD
                propertyToCSV(writer,prop,"hadTotalA");
                propertyToCSV(writer,prop,"hadTotalD");
                // Zarit
                propertyToCSV(writer,prop,"zaritTotal");
                // SF12
                propertyToCSV(writer,prop,"sf12Total");
                // DUKE
                propertyToCSV(writer,prop,"dukeTotal");

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeValoracioCognitivaPrevia(String idPacient, Writer writer) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"resultsValCogPrev"+".dat");
            if(!file.exists()) {
                writeBlank(writer, 5);
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                // CDR
                propertyToCSV(writer,prop,"cdr");
                // CRC
                propertyToCSV(writer,prop,"crcTotal");
                // TAP
                propertyToCSV(writer,prop,"tapTotal");
                propertyToCSV(writer,prop,"tapCi");
                // MMSE
                propertyToCSV(writer,prop,"totalMMSE");

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeBlank(Writer writer, int n) throws IOException {
        for (int i=0; i<n; i++){
            writer.append(";");
        }
    }

    private static void propertyToCSV(Writer writer, Properties prop, String string) throws IOException {
        String str = prop.getProperty(string,"");
        System.out.println("Propietat: "+string);
        System.out.println("Valor: "+str+".");
        writer.append(str);
        writer.append(';');
    }

    public static void csvToXLSX(String idPacient) {
        try {
            String csvFileAddress = Utils.PACIENT_DATA_PATH+idPacient+File.separator+idPacient+"Resultats.csv"; //csv file address
            String xlsxFileAddress = Utils.PACIENT_DATA_PATH+idPacient+File.separator+idPacient+"Resultats.xls"; //xlsx file address
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet("sheet1");
            String currentLine=null;
            int RowNum=0;
            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
            while ((currentLine = br.readLine()) != null) {
                String str[] = currentLine.split(";");
                RowNum++;
                HSSFRow currentRow=sheet.createRow(RowNum);
                for(int i=0;i<str.length;i++){
                    currentRow.createCell(i).setCellValue(str[i]);
                }
            }

            FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Done");
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+"Exception in try");
        }
    }

}
