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
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+idPacient+test+".dat");
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
            for (int i=1; i<=3; i++){
                writer.append(';');
                writeValoracioCognitivaPrevia(idPacient,writer);
                writer.append(';');
                writeSessio1(idPacient, i, writer);
                writer.append(';');
                writeSessio2(idPacient, i, writer);
                writer.append(';');
                writeValoracioCuidador(idPacient, i, writer);
                writer.append('\n');
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

        writeLineCSV(writer,"");

        //Sessio1
        // Digits directe
        writeLineCSV(writer,"SpanDD");
        writeLineCSV(writer,"Puntuacio directa DD");
        writeLineCSV(writer,"Percentil DD");
        writeLineCSV(writer,"NSSA DD");
        // Digits invers
        writeLineCSV(writer,"SpanDI");
        writeLineCSV(writer,"Puntuacio directa DI");
        writeLineCSV(writer,"Percentil DI");
        writeLineCSV(writer,"NSSA DI");
        // MLI
        writeLineCSV(writer,"MLI directa");
        writeLineCSV(writer,"MLI escalar");
        // TODO COGSTSTATE Header
        // MLII
        writeLineCSV(writer,"MLII directa");
        writeLineCSV(writer,"MLII escalar");
        // MLII Reco
        writeLineCSV(writer,"ML Reconeixement");
        //BNT
        writeLineCSV(writer,"BNT correctes");
        writeLineCSV(writer,"BNT ajuda semantica");
        writeLineCSV(writer,"BNT percentil");
        writeLineCSV(writer,"BNT NSSA");
        // Color trails 1
        writeLineCSV(writer,"Color trails 1 - Time Raw");
        writeLineCSV(writer,"CT 1 - Time Standard");
        writeLineCSV(writer,"CT 1 - Time Tscore");
        writeLineCSV(writer,"CT 1 - Time Percentile");
        writeLineCSV(writer,"CT 1 - Errors Raw");
        writeLineCSV(writer,"CT 1 - Errors Percentile");
        writeLineCSV(writer,"CT 1 - Near-Misses Raw");
        writeLineCSV(writer,"CT 1 - Near-Misses Percentile");
        writeLineCSV(writer,"CT 1 - Prompts Raw");
        writeLineCSV(writer,"CT 1 - Prompts Percentile");
        // Color trails 2
        writeLineCSV(writer,"Color trails 2 - Time Raw");
        writeLineCSV(writer,"CT 2 - Time Standard");
        writeLineCSV(writer,"CT 2 - Time Tscore");
        writeLineCSV(writer,"CT 2 - Time Percentile");
        writeLineCSV(writer,"CT 2 - Errors Raw");
        writeLineCSV(writer,"CT 2 - Errors Percentile");
        writeLineCSV(writer,"CT 2 - Near-Misses Raw");
        writeLineCSV(writer,"CT 2 - Near-Misses Percentile");
        writeLineCSV(writer,"CT 2 - Prompts Raw");
        writeLineCSV(writer,"CT 2 - Prompts Percentile");
        // Color trails interference Index
        writeLineCSV(writer,"Color trails - Interference index Raw");
        writeLineCSV(writer,"CT - Interference index Percentile");
        // Five digits
        writeLineCSV(writer,"Five Digits - Lectura Temps");
        writeLineCSV(writer,"FD - Lectura Temps PC");
        writeLineCSV(writer,"FD - Lectura Errors");
        writeLineCSV(writer,"FD - Lectura Errors PC");
        writeLineCSV(writer,"Five Digits - Compteig Temps");
        writeLineCSV(writer,"FD - Compteig Temps PC");
        writeLineCSV(writer,"FD - Compteig Errors");
        writeLineCSV(writer,"FD - Compteig Errors PC");
        writeLineCSV(writer,"Five Digits - Eleccio Temps");
        writeLineCSV(writer,"FD - Eleccio Temps PC");
        writeLineCSV(writer,"FD - Eleccio Errors");
        writeLineCSV(writer,"FD - Eleccio Errors PC");
        writeLineCSV(writer,"Five Digits - Alternança Temps");
        writeLineCSV(writer,"FD - Alternança Temps PC");
        writeLineCSV(writer,"FD - Alternança Errors");
        writeLineCSV(writer,"FD - Alternança Errors PC");
        writeLineCSV(writer,"Five Digits - Inhibició PC");
        writeLineCSV(writer,"Five Digits - Flexibilitat PC");
        // Fluencia verbal
        writeLineCSV(writer,"Fluencia verbal - P");
        writeLineCSV(writer,"FV - M");
        writeLineCSV(writer,"FV - R");
        writeLineCSV(writer,"FV - Animals");

        writeLineCSV(writer,"");

        //Sessio 2
        writeLineCSV(writer,"MoCA");
        writeLineCSV(writer,"UPSA Comunicacio");
        writeLineCSV(writer,"UPSA Comprensió");
        writeLineCSV(writer,"UPSA total");
        writeLineCSV(writer,"MFE");
        writeLineCSV(writer,"HAD");
        writeLineCSV(writer,"QoL-AD");
        writeLineCSV(writer,"Duke");
        writeLineCSV(writer,"Rosemberg");

        writeLineCSV(writer,"");

        //Valoracio cuidador
        writeLineCSV(writer,"FAQ");
        writeLineCSV(writer,"NPI");
        writeLineCSV(writer,"HAD");
        writeLineCSV(writer,"ZARIT");
        writeLineCSV(writer,"SF-12");
        writeLineCSV(writer,"Duke");

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

                // TODO COGSTATE

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

    private static void writeSessio2(String idPacient, int i, Writer writer) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"resultsSessio2_T"+i+".dat");
            if(!file.exists()) {

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

            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                // NPI
                propertyToCSV(writer,prop,"npiTotal");
                // UPSA
                propertyToCSV(writer,prop,"zaritTotal");
                // SF12
                propertyToCSV(writer,prop,"sf12Total");
                // HAD
                propertyToCSV(writer,prop,"hadTotalA");
                propertyToCSV(writer,prop,"hadTotalD");
                // QOL-AD
                propertyToCSV(writer,prop,"faqTotal");
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
                for (int i=0; i<5; i++){
                    writeLineCSV(writer,"");
                }
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
