/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sergi
 */
public class Javafx {
    
      MoviePlayer player;
      private static void initAndShowGUI() {
             // This method is invoked on Swing thread
             JFrame frame = new JFrame("FX");
             final JFXPanel fxPanel = new JFXPanel();
             frame.add(fxPanel);
             frame.setVisible(true);
             
             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                     initFX(fxPanel);
                 }
             });
         }

         private static void initFX(JFXPanel fxPanel) {
             // This method is invoked on JavaFX thread
             //Scene scene = createScene();
             //fxPanel.setScene(scene);
         }

         public static void main(String[] args) {
             SwingUtilities.invokeLater(new Runnable() {
                 @Override
                 public void run() {
                     initAndShowGUI();
                 }
             });
         }
    
}
