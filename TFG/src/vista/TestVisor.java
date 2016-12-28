/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.net.URI;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sergi
 */
public class TestVisor {
    
    static MediaPlayer player;
    
     private static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }
     
     
       private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
    
        private static Scene createScene() {
        Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
        Text  text  =  new  Text();
        text.setX(40);
        text.setY(100);
        Font font=new Font("Monospaced", 36);
        text.setFont(font);
        text.setText("Welcome JavaFX!");

        String path = "src"+ File.separator+"resources"+ File.separator+"video.mp4";
        File f = new File(path);
        URI u = f.toURI();
        Media media = new Media(u.toString());
        player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        
        
        root.getChildren().add(view);
        root.getChildren().add(text);
                player.play();
        return (scene);
    }
        
       public void prova() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();

            }
        });
    }
}
