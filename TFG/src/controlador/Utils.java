/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.NewUser;

/**
 *
 * @author USER
 */
public class Utils {
   
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
}
