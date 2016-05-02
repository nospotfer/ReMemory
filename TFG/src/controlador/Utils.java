/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.toedter.calendar.JDateChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import vista.NewUser;

/**
 *
 * @author USER
 */
public class Utils {
    
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
    public static void getProperty(Properties prop, String nom, JTextArea tf){
        tf.setText(prop.getProperty(nom));
    }
    public static void setProperty(Properties prop, String nom, JTextArea tf){
        prop.setProperty(nom, tf.getText());
    }
}
