/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorHibernate;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.PacientDatabase;

/**
 *
 * @author Sergi
 */
public class VideoPlayer {
    
    static MediaPlayer player;
    static HBox hbox = new HBox();
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
    static boolean soSonant = false;
    static boolean videoEnPlay = false;
    
    static double tempsInici;
    static double timeEnd;
    static long timeStart;
    
    static Button stopRecord;
    static Button timestampButton;
    
    static Date date;
    static String nomGravacio;
    
     private static void initAndShowGUI(String path, int idPacient, int numSessio) {
        // This method is invoked on the EDT thread
        controlador = new ControladorHibernate();
        frame = new JFrame("Video");       
        final JFXPanel fxPanel = new JFXPanel();  
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if(soSonant){
                    line.stop();
                    line.close();
                    one.interrupt();
                }                
               if(videoEnPlay){
                        player.stop();
                    }    
                frame.setVisible(false);
            }
        });         
              
        JButton acceptButton = new JButton("Aceptar");
        acceptButton.addActionListener((java.awt.event.ActionEvent ae) -> {
            if(soSonant){
                line.stop();
                line.close();
                one.interrupt();
            }
            if(videoEnPlay){
                player.stop();
            }
            frame.setVisible(false);
        });
        JButton TranscriptButton = new JButton("Transcripción");
        TranscriptButton.addActionListener((java.awt.event.ActionEvent ae) -> {
            PacientDatabase pacient = controlador.getPacient(idPacient);
            String session = "src"+ File.separator+"resources"+ File.separator+pacient.getNom()+File.separator+"sessio1";
            boolean gravacioExists = controlador.GravacioExisits(idPacient, numSessio);
            if(gravacioExists){
                Transcripcio descripcions = new Transcripcio();
                descripcions.prova(path,idPacient, 1);
            }
            else{
                JOptionPane.showConfirmDialog(null, "No hay ninguna gravación para este episodio", "Salir", JOptionPane.OK_OPTION);
            }
        });
        
        JButton closeButton = new JButton("Salir");
         closeButton.addActionListener((java.awt.event.ActionEvent ae) -> {
             int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
             if (reply == JOptionPane.YES_OPTION) {
                 player.stop();
                 if(soSonant){
                     line.stop();
                     line.close();
                     one.interrupt();
                 }
                 if(videoEnPlay){
                     player.stop();
                 }
                 frame.setVisible(false);
             }
        });      
        
        JPanel panel =  new JPanel();
        panel.add(acceptButton);
        panel.add(TranscriptButton);
        panel.add(closeButton);
     
        JLabel label = new JLabel("              ");
        label.setBackground( new java.awt.Color(240,248,255));
        label.setOpaque(true);
        frame.setLayout(new BorderLayout());
        frame.add(label,BorderLayout.WEST); 
       
        JLabel label2 = new JLabel("             ");
        label2.setBackground( new java.awt.Color(240,248,255));
        label2.setOpaque(true);
       
        frame.add(label2,BorderLayout.PAGE_START);
       
        frame.add(fxPanel,BorderLayout.CENTER); 
        frame.add(panel, BorderLayout.PAGE_END);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Platform.runLater(() -> {
            initFX(fxPanel, path, idPacient, numSessio);
        });
    }
     
     
       private static void initFX(JFXPanel fxPanel, String path, int idPacient, int numSessio) {
        Scene scene = createScene(path,idPacient, numSessio);        
        fxPanel.setScene(scene);
    }
    
    private static Scene createScene(String path, int idPacient, int numSessio) {
        Group root = new Group();
        File dir = new File(path);
        String nomVideo="";
        for (File file : dir.listFiles()) {
             
            if (file.getName().endsWith((".mp4"))) {
                nomVideo = file.getName();
            }
        }
        String pathVideo = path + File.separator+nomVideo;
        File f = new File(pathVideo);
        URI u = f.toURI();
        Media media = new Media(u.toString());
        player = new MediaPlayer(media);

        MediaView view = new MediaView(player);      

        hbox = new HBox();
        final Button playButton = new Button("Play"); 
        playButton.setOnAction((ActionEvent event) -> {
            player.play();
            videoEnPlay= true;
        });
        
         final Button pauseButton = new Button("Pausa");
        pauseButton.setOnAction((ActionEvent event) -> {
            player.pause();
            videoEnPlay=false;
        });
        
        
        
        final Button stopButton = new Button("Parar");
        stopButton.setOnAction((ActionEvent event) -> {
            player.stop();
            videoEnPlay = false;
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
        
        Button record = new Button("Grabar");
        record.setOnAction((ActionEvent event) -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month  = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int hour = cal.get(Calendar.HOUR);
            int min = cal.get(Calendar.MINUTE);
            int sec = cal.get(Calendar.SECOND);
            
            wavFile = new File(path+File.separator+day+month+year+"_"+hour+min+sec+".wav");
            nomGravacio = day+""+month+""+year+"_"+hour+""+min+""+sec+".wav";
            soSonant = true;
            record.setText("Grabando...");
            record.setDisable(true);
            one = new Thread(){
                @Override
                public void run(){      
                    timeStart =  System.currentTimeMillis();
                    controlador.crearGravacio(nomGravacio, day+"/"+month+"/"+year, numSessio, idPacient);
                    StartRecording();           
                }
            };
            one.start();
        });
        
        stopRecord = new Button("Parar grabación");
        stopRecord.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               line.stop();
               line.close();
               one.interrupt();
               soSonant = false;
               record.setText("Grabar");
               stopRecord.setDisable(true);
               timestampButton.setDisable(true);
                record.setDisable(false);
            }
        });
        stopRecord.setDisable(true);

        timestampButton = new Button("Marca de tiempo");       
        timestampButton.setOnAction((ActionEvent event) -> {
            timeEnd = (System.currentTimeMillis() - timeStart)/1000.0f;
            controlador.crearTimestamp((float)timeEnd, nomGravacio);
        });
        timestampButton.setDisable(true);
        
        hbox2.getChildren().add(record);
        hbox2.getChildren().add(timestampButton);
        hbox2.getChildren().add(stopRecord);
       

        view.setScaleX(2.5);
        view.setScaleY(2.5);
        root.getChildren().add(view);
        root.getChildren().add(hbox);
        root.getChildren().add(vbox);
        root.getChildren().add(hbox2);
   
        player.setOnReady(() -> {

            float w1 = player.getMedia().getWidth()*1.5f+95;
            float h1 = player.getMedia().getHeight()*1.5f+95;
            //frame.setSize(w1 + 125, h1 + 200);
            //frame.setSize(w1 + 125, h1 + 200);
            frame.setSize(600,800);
            vbox.setTranslateY(h1-10);
            hbox.setTranslateY(h1);
            hbox2.setTranslateY(h1 + 50);
            hbox2.setTranslateX((w1 / 2) - 125);
            slider.setMin(0.0);
            slider.setValue(0.0);
            slider.setMaxWidth(w1);
            slider.setMax(player.getTotalDuration().toSeconds());
        });
        
         player.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration duration, Duration current) -> {
             slider.setValue(current.toSeconds());
        });   
        slider.setOnMousePressed((MouseEvent event) -> {
            player.seek(Duration.seconds(slider.getValue()));
        });
        return (scene);
    }
        
       public void prova(String path, int idPacient, int numSessio) {
           
        SwingUtilities.invokeLater(() -> {
            initAndShowGUI(path, idPacient, numSessio);
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
           JOptionPane.showConfirmDialog(null, "Microfono no detectado", "Error", JOptionPane.DEFAULT_OPTION);
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
