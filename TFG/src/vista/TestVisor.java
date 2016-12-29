/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sergi
 */
public class TestVisor {
    
    static MediaPlayer player;
    static final HBox hbox = new HBox();
    static int h,w;
    static TargetDataLine line;
    static File wavFile;
    static AudioInputStream ais;
    static AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    static Thread one;
    static Button stopRecordButton;
    static Slider slider ;
    static JFrame frame;
    
     private static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
        JButton record = new JButton("Start recording");
        
        
        record.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                wavFile = new File("src"+ File.separator+"resources"+File.separator+"test.wav");
                one = new Thread(){
                @Override
                public void run(){
                     stopRecordButton.setDisable(true);
                    StartRecording();                 
                }
            };
            one.start();
            }
        });
        
        JButton stopRecord = new JButton("Stop recording");
        
         stopRecord.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
               line.stop();
               line.close();
               one.interrupt();
            }
        });
         
         JButton timestampButton = new JButton("Stop recording");
        
         timestampButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                Duration segons = player.currentTimeProperty().get();
                System.out.println("Timestamp: "+(float)segons.toSeconds());
            }
        });
        
        
        JPanel panel =  new JPanel();
        panel.add(record);
        panel.add(stopRecord);
        panel.add(timestampButton);
        frame.add(fxPanel,BorderLayout.CENTER);
        frame.add(panel, BorderLayout.PAGE_END);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        //Scene scene = new Scene(root,400,400, Color.BLACK);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        String path = "src"+ File.separator+"resources"+ File.separator+"video.mp4";
        File f = new File(path);
        
        URI u = f.toURI();
        Media media = new Media(u.toString());
        media.getWidth();
        player = new MediaPlayer(media);

        MediaView view = new MediaView(player);
        stopRecordButton = new Button("Stop Recording");
         
        final Button playButton = new Button("Play");
        playButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.play();
                //playButton.setText("Stop");
            }
        });
        
        
        final Button stopButton = new Button("Stop");
        stopButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.stop();
                //playButton.setText("Stop");
            }
        });
        
        hbox.getChildren().add(playButton);
        hbox.getChildren().add(stopButton);
        
        final VBox vbox = new VBox();
        slider = new Slider();   
        vbox.getChildren().add(slider);
        vbox.setMinWidth(600);
        Scene  scene  =  new  Scene(root, media.getWidth() ,media.getHeight(),Color.ALICEBLUE);
        //scene.getWidth();
        //vbox.setTranslateY(350);
        //hbox.setTranslateY(370);
        root.getChildren().add(view);
        root.getChildren().add(hbox);
        root.getChildren().add(vbox);
        player.setOnReady(new Runnable(){
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                frame.setSize(w, h+100);
                vbox.setTranslateY(h-10);
                hbox.setTranslateY(h);
                
               slider.setMin(0.0);
               slider.setValue(0.0);
               slider.setMax(player.getTotalDuration().toSeconds());
            }
        
        });
        
         player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration duration, Duration current) {
                slider.setValue(current.toSeconds());
            }
        });   
        slider.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                player.seek(Duration.seconds(slider.getValue()));
            }
        });
        
        
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
       
     private static AudioFormat getAudioFormat() { 
        float sampleRate = 6000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        return format;
    }
    
    
    public static void  StartRecording(){
                AudioFormat format = getAudioFormat();
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, getAudioFormat());
                // checks if system supports the data line
               if (!AudioSystem.isLineSupported(info)) {
                   System.out.println("Line not supported");
                   System.exit(0);
               }
                try {
                    line = (TargetDataLine) AudioSystem.getLine(info);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(MoviePlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    line.open(format);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(MoviePlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
               line.start();   // start capturing

               System.out.println("Start capturing...");
               AudioInputStream ais = new AudioInputStream(line);
               System.out.println("Start recording...");
                try {
                    // start recording
                    AudioSystem.write(ais, fileType, wavFile);
                } catch (IOException ex) {
                    Logger.getLogger(MoviePlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
