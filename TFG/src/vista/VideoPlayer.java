/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorHibernate;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sergi
 */
public class VideoPlayer {
    
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
    static String folderPath;
    static ControladorHibernate controlador;
    
    static double tempsInici;
    static double timeEnd;
    static long timeStart;
    
    static Button stopRecord;
    static Button timestampButton;
    
     private static void initAndShowGUI(String path, int idPacient, int numSessio) {
        // This method is invoked on the EDT thread
        controlador = new ControladorHibernate();
        frame = new JFrame("Video");       
        final JFXPanel fxPanel = new JFXPanel();
        Platform.setImplicitExit(false);    
      
        JButton acceptButton = new JButton("Acceptar");
        acceptButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
               frame.dispose();
            }
        });
        
        JButton closeButton = new JButton("Sortir");
         closeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
              int reply = JOptionPane.showConfirmDialog(null, "Segur que vols sortir?", "Exit", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    player.stop();
                    frame.dispose();
                }    
            }
        });      
        
        JPanel panel =  new JPanel();
        panel.add(acceptButton);
        panel.add(closeButton);
        frame.add(fxPanel,BorderLayout.CENTER);
        frame.add(panel, BorderLayout.PAGE_END);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel, path, idPacient, numSessio);   
            }
       });
    }
     
     
       private static void initFX(JFXPanel fxPanel, String path, int idPacient, int numSessio) {
        Scene scene = createScene(path,idPacient, numSessio);
        fxPanel.setScene(scene);
    }
    
    private static Scene createScene(String path, int idPacient, int numSessio) {
        Group root = new Group();
        String pathVideo = path + File.separator+"video.mp4";
        File f = new File(pathVideo);
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
            }
        });
        
         final Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.pause();
            }
        });
        
        
        
        final Button stopButton = new Button("Stop");
        stopButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.stop();
            }
        });
        
        hbox.getChildren().add(playButton);
        hbox.getChildren().add(pauseButton);
        hbox.getChildren().add(stopButton);
        
        final VBox vbox = new VBox();
        slider = new Slider();   
        vbox.getChildren().add(slider);
        vbox.setMinWidth(600);
        Scene  scene  =  new  Scene(root, media.getWidth() ,media.getHeight(),Color.ALICEBLUE);            
        
          final HBox hbox2 = new HBox();
        
        Button record = new Button("Start recording");
        record.setOnAction(new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent event) {
                wavFile = new File(path+File.separator+"gravacio.wav");
                one = new Thread(){
                @Override
                public void run(){      
                    timeStart =  System.currentTimeMillis();
                    StartRecording();           
                    
                }
            };
            one.start();
            }
        });
        
        stopRecord = new Button("Stop recording");
        stopRecord.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               line.stop();
               line.close();
               one.interrupt();
               
                stopRecord.setDisable(true);
                timestampButton.setDisable(true);
            }
        });
        stopRecord.setDisable(false);

        timestampButton = new Button("Timestamp");       
        timestampButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
                timeEnd = (System.currentTimeMillis() - timeStart)-1000;
                System.out.println( timeEnd);
                controlador.crearTimestamp((float)timeEnd, idPacient, numSessio);
            }
        });
        timestampButton.setDisable(true);
        
        hbox2.getChildren().add(record);
        hbox2.getChildren().add(timestampButton);
        hbox2.getChildren().add(stopRecord);
       

        
        root.getChildren().add(view);
        root.getChildren().add(hbox);
        root.getChildren().add(vbox);
        root.getChildren().add(hbox2);
        
        player.setOnReady(new Runnable(){
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                frame.setSize(w, h+150);
                vbox.setTranslateY(h-10);
                hbox.setTranslateY(h);
                hbox2.setTranslateY(h+50);
                hbox2.setTranslateX((w/2)-125);
                
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
          Platform.setImplicitExit(false);
        return (scene);
    }
        
       public void prova(String path, int idPacient, int numSessio) {
           
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                  Platform.setImplicitExit(false);
                initAndShowGUI(path, idPacient, numSessio);
                Platform.setImplicitExit(false);

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
        boolean micro = true;
        AudioFormat format = getAudioFormat();
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, getAudioFormat());
        // checks if system supports the data line
       if (!AudioSystem.isLineSupported(info)) {
           System.out.println("Line not supported");
           JOptionPane.showConfirmDialog(null, "El microfon no s'ha detectat", "Error", JOptionPane.DEFAULT_OPTION);
            micro= false;
       }
       if(micro){
            stopRecord.setDisable(false);
            timestampButton.setDisable(false);
            try {
                line = (TargetDataLine) AudioSystem.getLine(info);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VideoPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                line.open(format);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VideoPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
           line.start();   // start capturing

           System.out.println("Start capturing...");
           AudioInputStream ais = new AudioInputStream(line);
           System.out.println("Start recording...");
            try {
                // start recording
                AudioSystem.write(ais, fileType, wavFile);
            } catch (IOException ex) {
                Logger.getLogger(VideoPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
