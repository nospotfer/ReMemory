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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
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
    //public static final String PACIENT_DATA_PATH = System.getenv("APPDATA")+SEP+"ReMemory"+SEP+"pacientData"+SEP;
    //public static final String USERS_PATH = System.getenv("APPDATA")+SEP+"ReMemory"+SEP+"res"+SEP+"users.json";
    public static final String PACIENT_DATA_PATH = "res"+SEP+"pacientData"+SEP;
    public static final String USERS_PATH = "res"+SEP+"users.json";
     public static final String RES_PATH ="res"+SEP;
    //public static final String RES_PATH = System.getenv("APPDATA")+SEP+"ReMemory"+SEP+"res"+SEP;
    
    public static String getStringFile(String file) {
	BufferedReader reader = null;
	try {
	    reader = new BufferedReader( new FileReader (file));
	    String line;
	    StringBuilder stringBuilder = new StringBuilder();
	    String ls = System.getProperty("line.separator");
            System.out.println ("El separador de sistema es: "+ls);
            
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
        if (prop.getProperty(nom)!= null) {
            cb.setSelectedItem(prop.getProperty(nom));
        }
    }
    
    public static void getProperty(Properties prop, String nom, JTextField tf){
        if (prop.getProperty(nom)!=null) {
            tf.setText(prop.getProperty(nom));
        }
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
        if (prop.getProperty(nom) != null) {
            tf.setText(prop.getProperty(nom));
        }
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
            //System.out.println(buttonGroup.getSelection().getActionCommand());
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

    public static void initTaula(final JPanel panel, final JLabel label){
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

    public static void guardar(Object obj, String idPacient, String test) {
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

            for (Component component : ((JTabbedPane) obj).getComponents()) {
                setComponents(prop, component);
            }

            //setComponents(prop, obj);
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

    public static void setComponents(Properties prop, Object obj) {

        Class aClass = obj.getClass();
        try {
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                if(JTextField.class == field.getType()){
                    Utils.setProperty(prop, field.getName(),(JTextField)field.get(obj));
                }
                else if (JComboBox.class == field.getType()){
                    Utils.setProperty(prop, field.getName(), (JComboBox) field.get(obj));
                }
                else if (JTextArea.class == field.getType()){
                    Utils.setProperty(prop, field.getName(), (JTextArea) field.get(obj));
                }
                else if (JToggleButton.class == field.getType() && !(JCheckBox.class == field.getType()) && !(JRadioButton.class == field.getType()) && !(JButton.class == field.getType())){
                    Utils.setProperty(prop, field.getName(), (JToggleButton) field.get(obj));
                    setPropertyText(prop, field.getName()+"text",(JToggleButton) field.get(obj));
                }
                else if (JButton.class == field.getType()){
                    setPropertyText(prop, field.getName(),(JButton) field.get(obj));
                }
                else if (JRadioButton.class == field.getType()){
                    Utils.setProperty(prop, field.getName(), (JRadioButton) field.get(obj));
                }
                else if (JCheckBox.class == field.getType()){
                    Utils.setProperty(prop, field.getName(), (JCheckBox) field.get(obj));
                }
                else if (JLabel.class == field.getType()){
                    Utils.setProperty(prop, field.getName(), (JLabel) field.get(obj));
                }
                else if (JXTable.class == field.getType()){
                    setProperty(prop, field.getName() ,(JXTable)field.get(obj));
                }
            }
        } catch (SecurityException ex) {
            Logger.getLogger(aClass.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(aClass.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(aClass.getName()).log(Level.SEVERE, null, ex);
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
                
                for (Component component : ((JTabbedPane) panel).getComponents()) {
                    getComponents(prop, component);
                }
                
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

    public static void getComponents(Properties prop,Object obj) {
        Class aClass = obj.getClass();
        try {
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                if(JTextField.class == field.getType()){
                    Utils.getProperty(prop, field.getName(), (JTextField)field.get(obj));
                }
                else if (JComboBox.class == field.getType()){
                    Utils.getProperty(prop, field.getName(), (JComboBox) field.get(obj));
                }
                else if (JTextArea.class == field.getType()){
                    Utils.getProperty(prop, field.getName(), (JTextArea) field.get(obj));
                }
                else if (JToggleButton.class == field.getType() && !(JCheckBox.class == field.getType()) && !(JRadioButton.class == field.getType()) && !(JButton.class == field.getType())){
                    Utils.getProperty(prop, field.getName(), (JToggleButton) field.get(obj));
                    getPropertyText(prop, field.getName()+"text", (JToggleButton) field.get(obj));
                }
                else if (JButton.class == field.getType()){
                    getPropertyText(prop, field.getName(),(JButton) field.get(obj));
                }
                else if (JRadioButton.class == field.getType()){
                    Utils.getProperty(prop, field.getName(), (JRadioButton) field.get(obj));
                }
                else if (JCheckBox.class == field.getType()){
                    Utils.getProperty(prop, field.getName(), (JCheckBox) field.get(obj));
                }
                else if (JLabel.class == field.getType()){
                    getProperty(prop, field.getName(), (JLabel) field.get(obj));
                }
                else if (JXTable.class == field.getType()){
                    getProperty(prop, field.getName(), (JXTable)field.get(obj));
                }
            }
        } catch (SecurityException ex) {
            Logger.getLogger(aClass.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(aClass.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(aClass.getName()).log(Level.SEVERE, null, ex);
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
        File outFilePacient = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"Resultats_"+idPacient+".csv");
        File outFileGeneral = new File(Utils.RES_PATH+"Resultats.csv");
        try {
            if (!outFilePacient.exists()){
                outFilePacient.createNewFile();
            }
            if (!outFileGeneral.exists()){
                outFileGeneral.createNewFile();
                Writer w = new OutputStreamWriter(
                        new FileOutputStream(outFileGeneral), "UTF-8");
                writeHeader(w, idPacient);
                w.flush();
                w.close();
            }

	        Writer writer = new OutputStreamWriter(
                    new FileOutputStream(outFilePacient), "UTF-8");
            writeHeader(writer, idPacient);

            escriuResultatsPacient(idPacient, writer);

            escriuResultatsTotal(idPacient,outFileGeneral);

            csvToXLSX(idPacient);

        }
        catch(IOException e)
        {
             e.printStackTrace();
        }
    }

    private static void escriuResultatsTotal(String idPacient, File outFileGeneral) throws IOException {

        String data = getPacientDataFromCSV(idPacient);

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(outFileGeneral), StandardCharsets.UTF_8));
        String  line = "";
        ArrayList<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null){
            lines.add(line);
        }

        int index = getIndexPacient(idPacient,lines);

        escriuData(outFileGeneral, data, lines, index);


    }

    private static void escriuData(File outFileGeneral, String data, ArrayList<String> lines, int index) throws IOException {
        if (index == -1){
            Writer writer = new OutputStreamWriter(
                    new FileOutputStream(outFileGeneral,true), "UTF-8");
            writer.append("\n");
            writer.append(data);
            writer.flush();
            writer.close();

        } else {
            lines.set(index, data);

            Writer writer = new OutputStreamWriter(
                    new FileOutputStream(outFileGeneral), "UTF-8");

            for (int i = 0; i<lines.size(); i++) {
                if (i == 0) {
                    writer.append(lines.get(i));
                } else {
                    writer.append("\n");
                    writer.append(lines.get(i));
                }

            }

            writer.flush();
            writer.close();
        }
    }

    private static int getIndexPacient(String idPacient, ArrayList<String> lines) {
        int index = -1;
        int i = 0;
        for (String line : lines) {
            if (line.split(";")[0].equals(idPacient)){
                index = i;
            }
            i++;
        }
        return index;
    }

    private static String getPacientDataFromCSV(String idPacient) throws IOException {
        String data = "";
        File outFilePacient = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"Resultats_"+idPacient+".csv");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(outFilePacient), StandardCharsets.UTF_8));
        String  line;
        ArrayList<String> lines = new ArrayList<>();

        while ((line = in.readLine()) != null){
            lines.add(line);
        }

        if (lines.size() > 1){
            data = lines.get(1);
        }

        return data;
    }

    private static void escriuResultatsPacient(String idPacient, Writer writer) throws IOException {
        writer.append('\n');
        writer.append(idPacient);
        writer.append(';');
        writeFitxa(idPacient,writer);
        writeValoracioCognitivaPrevia(idPacient,writer);
        for (int i=1; i<=3; i++){
            writer.append(';');
            writeSessio1(idPacient, i, writer);
            writer.append(';');
            writeSessio2(idPacient, i, writer);
            writer.append(';');
            writeValoracioCuidador(idPacient, i, writer);
            //writer.append(';'); Experiment
        }
        writer.flush();
        writer.close();
    }

    private static void writeHeader(Writer writer, String idPacient) throws IOException {
        writeLineCSV(writer,"ID");

        //Fitxa

        writeLineCSV(writer, "ID ReMemory");
        // Dades sociodemografiques
        writeLineCSV(writer, "Sexe");
        writeLineCSV(writer, "Idioma");
        writeLineCSV(writer, "Data naixement");
        writeLineCSV(writer, "Nivell escolaritat");
        writeLineCSV(writer, "Anys escolaritat");
        writeLineCSV(writer, "Estat civil");
        writeLineCSV(writer, "Professio");
        writeLineCSV(writer, "Categoria professional");
        writeLineCSV(writer, "Situacio laboral");
        writeLineCSV(writer, "Nivell socioeconomic");
        // Dades cliniques
        writeLineCSV(writer, "Fumador/a actualment");
        writeLineCSV(writer, "Cigarrets / dia");
        writeLineCSV(writer, "Anys que ha fumat");
        writeLineCSV(writer, "Edat inici fumar");
        writeLineCSV(writer, "Consum d'alcohol actual");
        writeLineCSV(writer, "Num. i tipus de begudes alcoholiques/dia");
        writeLineCSV(writer, "UBE/dia");
        writeLineCSV(writer, "Anys consum alcohol");
        writeLineCSV(writer, "Edat inici alcohol");
        writeLineCSV(writer, "Malalties croniqus concomitants");
        // Terapia no farmacologica
        writeLineCSV(writer, "Temps en tractament no farmacologic");

        // Dades mediques
        writeLineCSV(writer, "Malaltia d'Alzheimer");
        writeLineCSV(writer, "Malaltia de Parkinson");
        writeLineCSV(writer, "Sindrome de Down");
        writeLineCSV(writer, "Altres demencies");
        writeLineCSV(writer, "Antecedents del pare");
        writeLineCSV(writer, "Antecedents de la mare");
        writeLineCSV(writer, "Altres familiars");
        // Dades cliniques
        writeLineCSV(writer, "Cafe i te");
        writeLineCSV(writer, "Tabac");
        writeLineCSV(writer, "Alcohol");
        writeLineCSV(writer, "Cannabis");
        writeLineCSV(writer, "Feina i toxics laborals");
        writeLineCSV(writer, "Altres antecedents personals");
        // Antecedents patologics personals
        //  Cardiovascular
        writeLineCSV(writer, "Hipertensio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Insuficiencia cardiaca");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Infart de miocardi");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Cardiopatia isquemica");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Arritmia");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Malaltia vascular periferica arterial");
        writeLineCSV(writer, "Data");
        // Endocrino/Metabolic
        writeLineCSV(writer, "Diabetis");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Obesitat");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Dislipemia");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Patologia de tiroides");
        writeLineCSV(writer, "Data");
        //  Digestiu
        writeLineCSV(writer, "Ulcus");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Gastritis");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Colelitiasis/colecistectomia");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Hepatopatia");
        writeLineCSV(writer, "Data");
        //  Psiquiatric/Abus
        writeLineCSV(writer, "Depressio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Ansietat");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Psicosis");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Abus d'alcohol");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Abus de drogues");
        writeLineCSV(writer, "Data");
        //  Neurologic
        writeLineCSV(writer, "AVC establert");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "AVC transitori");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Epilepsia");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Trauma craneal greu");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Malaltia de Parkinson");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Esclerosis multiple");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Cefalea");
        writeLineCSV(writer, "Data");
        //  Respiratori
        writeLineCSV(writer, "Asma");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "EPOC");
        writeLineCSV(writer, "Data");
        //  Hematologic
        writeLineCSV(writer, "Anemia");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Leucosis");
        writeLineCSV(writer, "Data");
        //  Immunologic
        writeLineCSV(writer, "Al.lergia");
        writeLineCSV(writer, "Data");
        //  Oftalmologic
        writeLineCSV(writer, "Glaucoma");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Cataractes");
        writeLineCSV(writer, "Data");
        //  Genito-urinari
        writeLineCSV(writer, "Insuficiencia renal");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Incontinencia urinaria");
        writeLineCSV(writer, "Data");
        //  Musculo-esqueletic
        writeLineCSV(writer, "Artosi");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Artitis");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Fibromialgia");
        writeLineCSV(writer, "Data");
        //  Neoplassic general
        writeLineCSV(writer, "Benigne");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Maligne");
        writeLineCSV(writer, "Data");
        //  Tractament farmacologic actual
        //   Farmacs sistema nervios
        writeLineCSV(writer, "Ansiolitics i sedants");
        writeLineCSV(writer, "Hipnotics");
        writeLineCSV(writer, "Antidepresius");
        writeLineCSV(writer, "Animaniacs");
        writeLineCSV(writer, "Anipsicotics/Neuroleptics");
        writeLineCSV(writer, "Animigranyosos");
        writeLineCSV(writer, "Opioides");
        writeLineCSV(writer, "Antiepileptics/Anticonvulsivants");
        writeLineCSV(writer, "Antiparkinsonians");
        writeLineCSV(writer, "Farmacs i muscul estriat");
        writeLineCSV(writer, "Vasodilatadors cerebrals i nootropics");
        writeLineCSV(writer, "Alzheimer: inhibidors de la Ac-esterasa");
        writeLineCSV(writer, "Alzheimer: memantina");
        writeLineCSV(writer, "Psicoestimulants");
        writeLineCSV(writer, "Substancies d'abus");
        writeLineCSV(writer, "Deshabituacio de substancies d'abus");
        //    Altres farmacs
        writeLineCSV(writer, "Antiacids/protectors gastrics");
        writeLineCSV(writer, "Antidiabetics");
        writeLineCSV(writer, "Antitrombotics/Anticoagulants");
        writeLineCSV(writer, "Antiagregants");
        writeLineCSV(writer, "Cardiotonics/Antiarritmics");
        writeLineCSV(writer, "Antihipertenius");
        writeLineCSV(writer, "Diuretics");
        writeLineCSV(writer, "Hipolipemiants");
        writeLineCSV(writer, "Dermatologics");
        writeLineCSV(writer, "Hormones sexuals");
        writeLineCSV(writer, "Urologics");
        writeLineCSV(writer, "Corticosteroides sintetics");
        writeLineCSV(writer, "Terapia tiroidea");
        writeLineCSV(writer, "Antineapastics/Immunomoduladors");
        writeLineCSV(writer, "Antiinflamatoris/Antirreumatics");
        writeLineCSV(writer, "Analgesics/Antipiretics");
        writeLineCSV(writer, "Broncodilatadors");
        writeLineCSV(writer, "Oftalmologics");

        // Proves complementaries
        writeLineCSV(writer, "ECG: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Analitica de sang: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Analitica d'orina: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Analitica de LCR: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Genetica: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "RX de torax: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "EEG: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Potencials evocats: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "EMG: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "N-TMS: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "Anatomia patologica: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");

        // Neuroimatge
        writeLineCSV(writer, "TC: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "RM: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "RM funcional: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "RM tractografia: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "SPECT: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "SISCOM: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "DaT-Scan: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");
        writeLineCSV(writer, "PET: codi resultat");
        writeLineCSV(writer, "Descripcio");
        writeLineCSV(writer, "Data");


        //Valoracio cognitiva previa
        
        writeLineCSV(writer,"CDR");
        writeLineCSV(writer,"CRC total");
        writeLineCSV(writer,"CRC Rang"); //NOU
        writeLineCSV(writer,"TAP total");
        writeLineCSV(writer,"TAP CI estimat");
        writeLineCSV(writer,"MMSE total");
        writeLineCSV(writer,"MMSE Comentarios");
        

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
            writeLineCSV(writer, "Five Digits - Inhibicio PC_T"+i);
            writeLineCSV(writer, "Five Digits - Flexibilitat PC_T"+i);
            // Fluencia verbal
            writeLineCSV(writer, "Fluencia verbal - P_T"+i);
            writeLineCSV(writer, "FV - M_T"+i);
            writeLineCSV(writer, "FV - R_T"+i);
            writeLineCSV(writer, "FV - Animals_T"+i);
            writeLineCSV(writer, "Fluencia verbal NSSA - P_T"+i);
            writeLineCSV(writer, "FV NSSA - M_T"+i);
            writeLineCSV(writer, "FV NSSA - R_T"+i);
            writeLineCSV(writer, "FV NSSA - Animals_T"+i);

            writer.append(";");

            //Sessio 2
            writeLineCSV(writer, "EPT_T"+i);
            writeLineCSV(writer, "MoCA_T"+i);
            writeLineCSV(writer, "UPSA Comunicacio_T"+i);
            writeLineCSV(writer, "UPSA Comprensio_T"+i);
            writeLineCSV(writer, "UPSA total_T"+i);
            writeLineCSV(writer, "MFE_T"+i);
            writeLineCSV(writer, "HAD-A_T"+i);
            writeLineCSV(writer, "HAD-D_T"+i);
            writeLineCSV(writer, "QoL-AD_T"+i);
            writeLineCSV(writer, "Duke_T"+i);
            writeLineCSV(writer, "Rosemberg_T"+i);
            writeLineCSV(writer, "OHQSF_T"+i);
            writeLineCSV(writer, "IMAGE_T"+i);
            writeLineCSV(writer, "PANAS_afect-positivo_T"+i);
            writeLineCSV(writer, "PANAS_afect-negativo_T"+i);
            writeLineCSV(writer, "PANAS_TOTAL_T"+i);
            writeLineCSV(writer, "MOS_Amigos_T"+i);
            writeLineCSV(writer, "MOS_Familia_T"+i);
            writeLineCSV(writer, "MOS_ApoyoEmocional_T"+i);
            writeLineCSV(writer, "MOS_AyudaMaterial_T"+i);
            writeLineCSV(writer, "MOS_SocialOcio_T"+i);
            writeLineCSV(writer, "MOS_ApoyoAfectivo_T"+i);
            writeLineCSV(writer, "MOS_TOTAL_T"+i);

            writer.append(";");

            //Valoracio cuidador
            writeLineCSV(writer, "EPTTotalCuidador_T"+i);
            writeLineCSV(writer, "FAQ_T"+i);
            writeLineCSV(writer, "NPI_T"+i);
            writeLineCSV(writer, "HAD-A_T"+i);
            writeLineCSV(writer, "HAD-D_T"+i);
            writeLineCSV(writer, "ZARIT_T"+i);
            writeLineCSV(writer, "SF-12_T"+i);
            writeLineCSV(writer, "Duke_T"+i);
            writeLineCSV(writer, "OHQSF_T_VC"+i);

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
                // Five digit lectura
                propertyToCSV(writer,prop,"lecturaTemps");
                propertyToCSV(writer,prop,"lecturaTempsPCField");
                propertyToCSV(writer,prop,"lecturaErrorsField");
                propertyToCSV(writer,prop,"lecturaErrorsPCField");
                // Five digit comtpeig
                propertyToCSV(writer,prop,"compteigTemps");
                propertyToCSV(writer,prop,"compteigTempsPCField");
                propertyToCSV(writer,prop,"compteigErrors");
                propertyToCSV(writer,prop,"compteigErrorsPCField");
                // Five digit eleccio
                propertyToCSV(writer,prop,"eleccioTemps");
                propertyToCSV(writer,prop,"eleccioTempsPCField");
                propertyToCSV(writer,prop,"eleccioErrorsField");
                propertyToCSV(writer,prop,"eleccioErrorsPCField");
                // Five digit temps
                propertyToCSV(writer,prop,"alternTemps");
                propertyToCSV(writer,prop,"alternTempsPCField");
                propertyToCSV(writer,prop,"alternErrors");
                propertyToCSV(writer,prop,"alternErrorsPCField");
                // Five digit resum
                propertyToCSV(writer,prop,"inhibicioPCField");
                propertyToCSV(writer,prop,"flexibilitatPCField");
                // Fluencia verbal
                propertyToCSV(writer,prop,"fluenciaP");
                propertyToCSV(writer,prop,"fluenciaM");
                propertyToCSV(writer,prop,"fluenciaR");
                propertyToCSV(writer,prop,"fluenciaAnimals");
                propertyToCSV(writer,prop,"fluenciaPNSSA");
                propertyToCSV(writer,prop,"fluenciaMNSSA");
                propertyToCSV(writer,prop,"fluenciaRNSSA");
                propertyToCSV(writer,prop,"fluenciaAnimalsNSSA");


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
        if (c != null){
            c.setCellType(XSSFCell.CELL_TYPE_STRING);
            return c.getStringCellValue();
        } else {
            System.out.println("cell "+cell +" from Cogstate XLS is null!! Skipping...\n");
            //c.setCellType(XSSFCell.CELL_TYPE_STRING);
            return "";
        }
       
    }

    private static void writeFitxa(String idPacient, Writer writer){

        Properties prop = new Properties();
        InputStream input = null;
        try {
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+idPacient+"Fitxa"+".dat");
            if(!file.exists()) {
                writeBlank(writer,206);
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                // Carrega el codi del subjecte
                propertyToCSV(writer,prop,"codiSubjecte");

                // Carrega les dades basiques
                propertyToCSV(writer,prop,"sexe");
                propertyToCSV(writer,prop,"idioma");
                propertyToCSV(writer,prop,"dataNaixement");
                propertyToCSV(writer,prop,"nivellEscolaritat");
                propertyToCSV(writer,prop,"anysEscolaritat");
                propertyToCSV(writer,prop,"estatCivil");
                propertyToCSV(writer,prop,"professio");
                propertyToCSV(writer,prop,"categoriaPro");
                propertyToCSV(writer,prop,"situacioLaboral");
                propertyToCSV(writer,prop,"nivellSocioeconomic");

                propertyToCSV(writer,prop,"fumador");
                propertyToCSV(writer,prop,"numCigarrets");
                propertyToCSV(writer,prop,"anysFumar");
                propertyToCSV(writer,prop,"edatFumar");
                propertyToCSV(writer,prop,"consumAlcohol");
                propertyToCSV(writer,prop,"numBegudes");
                propertyToCSV(writer,prop,"ubeDia");
                propertyToCSV(writer,prop,"anysAlcohol");
                propertyToCSV(writer,prop,"edatAlcohol");
                propertyToCSV(writer,prop,"malaltiesCroniques");

                propertyToCSV(writer,prop,"tempsTractament");

                // Carrega les dades mediques
                propertyToCSV(writer,prop,"alzheimer");
                propertyToCSV(writer,prop,"parkinson");
                propertyToCSV(writer,prop,"sindromeDown");
                propertyToCSV(writer,prop,"altresDemencies");
                propertyToCSV(writer,prop,"antecedentsPare");
                propertyToCSV(writer,prop,"antecedentsMare");
                propertyToCSV(writer,prop,"altresFamiliars");

                propertyToCSV(writer,prop,"cafe");
                propertyToCSV(writer,prop,"tabac");
                propertyToCSV(writer,prop,"alcohol");
                propertyToCSV(writer,prop,"cannabis");
                propertyToCSV(writer,prop,"toxicsLaborals");
                propertyToCSV(writer,prop,"antecedentsPersonals");

                propertyToCSV(writer,prop,"hipertensio");
                propertyToCSV(writer,prop,"hipertensioData");
                propertyToCSV(writer,prop,"insuficienciaCardiaca");
                propertyToCSV(writer,prop,"insuficienciaCardiacaData");
                propertyToCSV(writer,prop,"infart");
                propertyToCSV(writer,prop,"infartData");
                propertyToCSV(writer,prop,"cardiopatia");
                propertyToCSV(writer,prop,"cardiopatiaData");
                propertyToCSV(writer,prop,"arritmia");
                propertyToCSV(writer,prop,"arritmiaData");
                propertyToCSV(writer,prop,"malaltiaVascularPeriferica");
                propertyToCSV(writer,prop,"malaltiaVascularData");

                propertyToCSV(writer,prop,"diabetis");
                propertyToCSV(writer,prop,"diabetisData");
                propertyToCSV(writer,prop,"obesitat");
                propertyToCSV(writer,prop,"obesitatData");
                propertyToCSV(writer,prop,"dislipemia");
                propertyToCSV(writer,prop,"dislipemiaData");
                propertyToCSV(writer,prop,"patologiaTiroides");
                propertyToCSV(writer,prop,"patologiaTiroidesData");

                propertyToCSV(writer,prop,"ulcus");
                propertyToCSV(writer,prop,"ulcusData");
                propertyToCSV(writer,prop,"gastritis");
                propertyToCSV(writer,prop,"gastritisData");
                propertyToCSV(writer,prop,"colelitiasis");
                propertyToCSV(writer,prop,"colelitiasisData");
                propertyToCSV(writer,prop,"hepatopatia");
                propertyToCSV(writer,prop,"hepatopatiaData");

                propertyToCSV(writer,prop,"depresio");
                propertyToCSV(writer,prop,"depresioData");
                propertyToCSV(writer,prop,"ansietat");
                propertyToCSV(writer,prop,"ansietatData");
                propertyToCSV(writer,prop,"psicosis");
                propertyToCSV(writer,prop,"psicosisData");
                propertyToCSV(writer,prop,"abusAlcohol");
                propertyToCSV(writer,prop,"abusAlcoholData");
                propertyToCSV(writer,prop,"abusDrogues");
                propertyToCSV(writer,prop,"abusDroguesData");

                propertyToCSV(writer,prop,"avcEstablert");
                propertyToCSV(writer,prop,"avcEstablertData");
                propertyToCSV(writer,prop,"avcTransitori");
                propertyToCSV(writer,prop,"avcTransitoriData");
                propertyToCSV(writer,prop,"epilepsia");
                propertyToCSV(writer,prop,"epilepsiaData");
                propertyToCSV(writer,prop,"traumaCraneal");
                propertyToCSV(writer,prop,"traumaCranealData");
                propertyToCSV(writer,prop,"malaltiaParkinson");
                propertyToCSV(writer,prop,"malaltiaParkinsonData");
                propertyToCSV(writer,prop,"esclerosis");
                propertyToCSV(writer,prop,"esclerosisData");
                propertyToCSV(writer,prop,"cefalea");
                propertyToCSV(writer,prop,"cefaleaData");

                propertyToCSV(writer,prop,"asma");
                propertyToCSV(writer,prop,"asmaData");
                propertyToCSV(writer,prop,"epoc");
                propertyToCSV(writer,prop,"epocData");

                propertyToCSV(writer,prop,"anemia");
                propertyToCSV(writer,prop,"anemiaData");
                propertyToCSV(writer,prop,"leucosis");
                propertyToCSV(writer,prop,"leucosisData");

                propertyToCSV(writer,prop,"alergia");
                propertyToCSV(writer,prop,"alergiaData");

                propertyToCSV(writer,prop,"glaucoma");
                propertyToCSV(writer,prop,"glaucomaData");
                propertyToCSV(writer,prop,"cataractes");
                propertyToCSV(writer,prop,"cataractesData");

                propertyToCSV(writer,prop,"insuficienciaRenal");
                propertyToCSV(writer,prop,"insuficienciaRenalData");
                propertyToCSV(writer,prop,"incontinencia");
                propertyToCSV(writer,prop,"incontinenciaData");

                propertyToCSV(writer,prop,"artrosi");
                propertyToCSV(writer,prop,"artrosiData");
                propertyToCSV(writer,prop,"artritis");
                propertyToCSV(writer,prop,"artritisData");
                propertyToCSV(writer,prop,"fibromialgia");
                propertyToCSV(writer,prop,"fibromialgiaData");

                propertyToCSV(writer,prop,"benigne");
                propertyToCSV(writer,prop,"benigneData");
                propertyToCSV(writer,prop,"maligne");
                propertyToCSV(writer,prop,"maligneData");

                propertyToCSV(writer,prop,"ansiolitics");
                propertyToCSV(writer,prop,"hipnotics");
                propertyToCSV(writer,prop,"antidepresius");
                propertyToCSV(writer,prop,"antimaniacs");
                propertyToCSV(writer,prop,"antipsicotics");
                propertyToCSV(writer,prop,"antimigranyosos");
                propertyToCSV(writer,prop,"opioides");
                propertyToCSV(writer,prop,"antiepileptics");
                propertyToCSV(writer,prop,"antiparkinsonians");
                propertyToCSV(writer,prop,"musculEstriat");
                propertyToCSV(writer,prop,"vasodilatadors");
                propertyToCSV(writer,prop,"ACEsterasa");
                propertyToCSV(writer,prop,"memantina");
                propertyToCSV(writer,prop,"psicoestimulants");
                propertyToCSV(writer,prop,"substanciesAbus");
                propertyToCSV(writer,prop,"deshabituacio");

                propertyToCSV(writer,prop,"antiacids");
                propertyToCSV(writer,prop,"antidiabetics");
                propertyToCSV(writer,prop,"antitrombotics");
                propertyToCSV(writer,prop,"antiagregants");
                propertyToCSV(writer,prop,"cardiotonics");
                propertyToCSV(writer,prop,"antihipertensius");
                propertyToCSV(writer,prop,"diuretics");
                propertyToCSV(writer,prop,"hipolipemiants");
                propertyToCSV(writer,prop,"dermatologics");
                propertyToCSV(writer,prop,"hormones");
                propertyToCSV(writer,prop,"urologics");
                propertyToCSV(writer,prop,"corticosteroides");
                propertyToCSV(writer,prop,"terapiaTiroidea");
                propertyToCSV(writer,prop,"antineopasics");
                propertyToCSV(writer,prop,"antiinflamatoris");
                propertyToCSV(writer,prop,"analgesics");
                propertyToCSV(writer,prop,"broncodilatadors");
                propertyToCSV(writer,prop,"oftalmologics");

                // Carrega les proves complementaries
                propertyToCSV(writer,prop,"ecgCodi");
                propertyToCSV(writer,prop,"ecgDescripcio");
                propertyToCSV(writer,prop,"ecgData");

                propertyToCSV(writer,prop,"analiticaSangCodi");
                propertyToCSV(writer,prop,"analiticaSangDescripcio");
                propertyToCSV(writer,prop,"analiticaSangData");

                propertyToCSV(writer,prop,"analiticaOrina");
                propertyToCSV(writer,prop,"analiticaOrinaDescripcio");
                propertyToCSV(writer,prop,"analiticaOrinaData");

                propertyToCSV(writer,prop,"analiticaLcrCodi");
                propertyToCSV(writer,prop,"analiticaLcrDescripcio");
                propertyToCSV(writer,prop,"analiticaLcrData");

                propertyToCSV(writer,prop,"geneticaCodi");
                propertyToCSV(writer,prop,"geneticaDescripcio");
                propertyToCSV(writer,prop,"geneticaData");

                propertyToCSV(writer,prop,"toraxCodi");
                propertyToCSV(writer,prop,"toraxDescripcio");
                propertyToCSV(writer,prop,"toraxData");

                propertyToCSV(writer,prop,"eegCodi");
                propertyToCSV(writer,prop,"eegDescripcio");
                propertyToCSV(writer,prop,"eegData");

                propertyToCSV(writer,prop,"potencialsCodi");
                propertyToCSV(writer,prop,"potencialsDescripcio");
                propertyToCSV(writer,prop,"potencialsData");

                propertyToCSV(writer,prop,"emgCodi");
                propertyToCSV(writer,prop,"emgDescripcio");
                propertyToCSV(writer,prop,"emgData");

                propertyToCSV(writer,prop,"ntmsCodi");
                propertyToCSV(writer,prop,"ntmsDescripcio");
                propertyToCSV(writer,prop,"ntmsData");

                propertyToCSV(writer,prop,"anatomiaCodi");
                propertyToCSV(writer,prop,"anatomiaDescripcio");
                propertyToCSV(writer,prop,"anatomiaData");

                // Carrega la neuroimatge

                propertyToCSV(writer,prop,"tcCodi");
                propertyToCSV(writer,prop,"tcDescripcio");
                propertyToCSV(writer,prop,"tcData");

                propertyToCSV(writer,prop,"rmCodi");
                propertyToCSV(writer,prop,"rmDescripcio");
                propertyToCSV(writer,prop,"rmData");

                propertyToCSV(writer,prop,"rmFuncionalCodi");
                propertyToCSV(writer,prop,"rmFuncionalDescripcio");
                propertyToCSV(writer,prop,"rmFuncionalData");

                propertyToCSV(writer,prop,"rmTractografiaCodi");
                propertyToCSV(writer,prop,"rmTractografiaDescripcio");
                propertyToCSV(writer,prop,"rmTractografiaData");

                propertyToCSV(writer,prop,"spectCodi");
                propertyToCSV(writer,prop,"spectDescripcio");
                propertyToCSV(writer,prop,"spectData");

                propertyToCSV(writer,prop,"siscomCodi");
                propertyToCSV(writer,prop,"siscomDescripcio");
                propertyToCSV(writer,prop,"siscomData");

                propertyToCSV(writer,prop,"datScanCodi");
                propertyToCSV(writer,prop,"datScanDescripcio");
                propertyToCSV(writer,prop,"datScanData");

                propertyToCSV(writer,prop,"petCodi");
                propertyToCSV(writer,prop,"petDescripcio");
                propertyToCSV(writer,prop,"petData");


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
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+"resultsSessio2_A"+i+".dat");
            if(!file.exists()) {
                writeBlank(writer,13);
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);
                
                // EPT
                propertyToCSV(writer,prop,"EPTTotal");
                
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
                
                //OHQSF
                propertyToCSV(writer,prop,"OHQSFTotal");
                //IMAGE
                propertyToCSV(writer,prop,"IMAGETotal");
                //PANAS
                propertyToCSV(writer,prop,"AfectPositivo");
                propertyToCSV(writer,prop,"AfectNegativo");
                propertyToCSV(writer,prop,"PanasTotal");
                //MOS
                propertyToCSV(writer,prop,"MOSAmigos");
                propertyToCSV(writer,prop,"MOSFamilia");
                propertyToCSV(writer,prop,"ApoyoEmocional");
                propertyToCSV(writer,prop,"AyudaMaterial");
                propertyToCSV(writer,prop,"SocialOcio");
                propertyToCSV(writer,prop,"ApoyoAfectivo");
                propertyToCSV(writer,prop,"MOSTotal");
            
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
                writeBlank(writer, 8);
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                //EPT (NOU)
                propertyToCSV(writer,prop,"EPTTotalCuidador");
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
                // OHQSF
                propertyToCSV(writer,prop,"OHQSFTotal");

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
                writeBlank(writer, 7);
            }
            else{
                input = new FileInputStream(file);

                // load a properties file
                prop.load(input);

                // CDR
                propertyToCSV(writer,prop,"cdr");
                // CRC
                propertyToCSV(writer,prop,"crcTotal");
                propertyToCSV(writer,prop,"rangLabel"); //
                // TAP
                propertyToCSV(writer,prop,"tapTotal");
                propertyToCSV(writer,prop,"tapCi");
                // MMSE
                propertyToCSV(writer,prop,"totalMMSE");
                propertyToCSV(writer,prop,"notasMMSE");

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
//        System.out.println("Propietat: "+string);
//        System.out.println("Valor: "+str+".");
        writer.append(str);
        writer.append(';');
    }

    public static void csvToXLSX(String idPacient) {
        try {
            String csvFileAddress = Utils.PACIENT_DATA_PATH+idPacient+File.separator+"Resultats_"+idPacient+".csv"; //csv file address
            String xlsxFileAddress = Utils.PACIENT_DATA_PATH+idPacient+File.separator+"Resultats_REM-G"+idPacient+".xlsx"; //xlsx file address
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("sheet1");
            String currentLine=null;
            int RowNum=0;
            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
            while ((currentLine = br.readLine()) != null) {
                String str[] = currentLine.split(";");
                XSSFRow currentRow=sheet.createRow(RowNum);
                RowNum++;
                for(int i=0;i<str.length;i++){
                    currentRow.createCell(i).setCellValue(str[i]);
                }
            }

            FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Done");
        } catch (Exception ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()+"Exception in try");
        }
    }

        //Retorna una imatge escalada de la imatge que se li passa
    public Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    } 
    
    public void crearCarpeta(String path){
        
        File carpeta = new File(path);
        if (carpeta.mkdir()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }  
    }
}
