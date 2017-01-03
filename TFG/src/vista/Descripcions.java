/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorHibernate;
import java.awt.BorderLayout;
import java.io.File;
import java.net.URI;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Timestamp;

/**
 *
 * @author Sergi
 */
public class Descripcions {
    
 
    static MediaPlayer player;
    static MediaPlayer player2;
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
    
     private static void initAndShowGUI(String path, int idPacient, int numSessio) {
        // This method is invoked on the EDT thread
        frame = new JFrame("Descipricio");
        final JFXPanel fxPanel = new JFXPanel();
        controlador = new ControladorHibernate();
       
        frame.add(fxPanel,BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel, path, idPacient, numSessio);   
            }
       });
    }
     
     
       private static void initFX(JFXPanel fxPanel, String path , int idPacient, int numSessio) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene(path, idPacient, numSessio);
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
        
        
        final Button pauseButton = new Button("Pausa");
        playButton.setOnAction(new EventHandler<ActionEvent>(){
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
        hbox.getChildren().add(stopButton);
        
        final VBox vbox = new VBox();
        
        
        
        
        final VBox vbox2 = new VBox();
        wavFile = new File(path+File.separator+"gravacio.wav");         
        u = wavFile.toURI();
        Media media2 = new Media(u.toString());
        player2 = new MediaPlayer(media2);
        MediaView view2 = new MediaView(player2);
        vbox2.getChildren().add(view2);
        
         
        final HBox hbox3 = new HBox();
        final Button playMusicButton = new Button("Play gravació");
        playMusicButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player2.play();
                //playButton.setText("Stop");
            }
        });
        
        final Button stopMusicButton = new Button("Stop gravacio");
        stopMusicButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player2.stop();
                //playButton.setText("Stop");
            }
        });
        
        Slider slider2 = new Slider();
        hbox3.getChildren().add(playMusicButton);
        hbox3.getChildren().add(stopMusicButton);
        hbox3.getChildren().add(slider2);
        
        player2.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration duration, Duration current) {
                slider2.setValue(current.toSeconds());
            }
        });   
        slider2.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                player2.seek(Duration.seconds(slider2.getValue()));
            }
        });
         
        player2.setOnReady(new Runnable(){
            @Override
            public void run() {
               int w = player.getMedia().getWidth();
               int h = player.getMedia().getHeight();
               
               hbox3.setTranslateY(h+65);
               hbox3.setPrefWidth(w);
               slider2.setMin(0.0);
               slider2.setValue(0.0);
               slider2.setPrefWidth(w-150);
               slider2.setMax(player2.getTotalDuration().toSeconds());
            }
        
        });   
        
        slider = new Slider();   
        vbox.getChildren().add(slider);
        vbox.setMinWidth(600);
        
        HBox hbox5 = new HBox();
        Label timestampLabel = new Label();
        List timestamps = controlador.getTimestamps(idPacient, 1);
        String tempTimestamps="";
        for(int i=0;i<timestamps.size();i++){
            Timestamp timestamp = (Timestamp) timestamps.get(i);
            tempTimestamps += " " + timestamp.getTemps();
        }
        timestampLabel.setText(tempTimestamps);
        timestampLabel.setStyle("-fx-border-color: black;");
        hbox5.getChildren().add(timestampLabel);
        
        HBox hbox6 = new HBox();
        TextArea textarea = new TextArea();
        hbox6.getChildren().add(textarea);
        
        HBox hbox7 = new HBox();
        Button acceptButton = new Button("Afegir descripcio");
         acceptButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) { 
                String data=textarea.getText().trim();//read contents of text area into 'data'
                if(!data.equals("")){
                    controlador.crearDescripcio(textarea.getText(), numSessio, idPacient);
                    textarea.setText("");
                }
            }
        });
         
         Button closeButton = new Button("Tancar");
         closeButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {              
                int reply = JOptionPane.showConfirmDialog(null, "Segur que vols sortir?", "Exit", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    player.stop();
                    player2.stop();
                    frame.dispose();
                }                       
            }
        });
        hbox7.getChildren().add(acceptButton);
        hbox7.getChildren().add(closeButton);
        
        
        Scene  scene  =  new  Scene(root, media.getWidth() ,media.getHeight(),Color.ALICEBLUE);
        root.getChildren().add(view);
        root.getChildren().add(hbox);
        root.getChildren().add(vbox);
        root.getChildren().add(view2);
        root.getChildren().add(hbox3);
        root.getChildren().add(hbox5);
        root.getChildren().add(hbox6);
        root.getChildren().add(hbox7);
        
        player.setOnReady(new Runnable(){
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                
                frame.setSize(w+40, h+300);
                
                vbox.setTranslateY(h-10);

                hbox.setTranslateY(h);

                hbox5.setTranslateY(h+35);

                timestampLabel.setPrefWidth(w);

                textarea.setPrefColumnCount(55);
                textarea.setPrefRowCount(5);

                hbox6.setTranslateY(h+105);

                hbox7.setTranslateY(h+225);
                hbox7.setTranslateX(w-120);
                
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
        
       public void prova(String path, int idPacient, int numSessio) {
           
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                initAndShowGUI(path, idPacient, numSessio);
            }
        });
    }
   
}
