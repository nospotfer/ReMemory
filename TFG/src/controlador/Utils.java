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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

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
    private static int tButton = 0;
    private static int button = 0;
    private static int label = 0;
    private static int radioButton = 0;

    public static final String PACIENT_DATA_PATH = "pacientData"+File.separator;
    
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
            File file = new File(Utils.PACIENT_DATA_PATH+idPacient+File.separator+idPacient+test+".dat");
            if(!file.exists()) {
                file.createNewFile();
            }
            output = new FileOutputStream(file);

            label = textF = combo = check = textA = tButton = button = radioButton = 0;
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

                label = textF = combo = check = textA = tButton = button = 0;
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
            if (com instanceof JLabel){
                getProperty(prop, "label"+label, (JLabel) com);
                label++;
            }
            else if (com instanceof Container){
                getComponents(prop, (Container) com);
            }
        }
    }

}
