/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorHibernate;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
/**
 *
 * @author Sergi
 */
public class MoviePlayer extends Application{

   /* public static void main(String[] args){
        launch(args);
    }
    */
    ControladorHibernate controlador;
    TargetDataLine line;
    File wavFile;
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    Thread one;
    float start;
    
   
    
    public void test() throws Exception{
        launch();
        //start(new Stage());
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        controlador = new ControladorHibernate();
        primaryStage.setTitle("Movie Player");
        Group root = new Group();
        String path = "src"+ File.separator+"resources"+ File.separator+"video.mp4";
        File f = new File(path);
        URI u = f.toURI();
        Media media = new Media(u.toString());
        final MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        
        final Timeline slideIn = new Timeline();
        final Timeline slideOut = new Timeline();
        root.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                slideIn.play();
            }      
        });
        root.setOnMouseExited(new EventHandler<MouseEvent>(){
        @Override
            public void handle(MouseEvent event) {
                slideOut.play();
            }      
        });
        final VBox vbox = new VBox();
        final HBox hbox = new HBox();
        final Button playButton = new Button("Play");
        playButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.play();
            }
        
        });
          
        final Button stopButton = new Button("Stop");
        stopButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.stop();
            }
        
        });
        final Button timestampButton = new Button("Timestamp");
        timestampButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                int idPacient =0;
                int numSessio=0;
                
                Duration segons = player.currentTimeProperty().get();

                System.out.println("Timestamp: "+(float)segons.toSeconds());
                //controlador.crearTimestamp((float)segons.toSeconds(), idPacient, numSessio);
                //System.out.println("Temps: "+player.currentTimeProperty());
            }
        
        });
        
        final Button recordButton = new Button("Start Recording");
        recordButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                wavFile = new File("src"+ File.separator+"resources"+File.separator+"test.wav");
                one = new Thread(){
                @Override
                public void run(){
                    startRecording();
                }
            };
            one.start();
            }
        });
        
       final Button stopRecording = new Button("stop Recording");
        timestampButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               line.stop();
               line.close();
               one.interrupt();
            }
        
        });
        hbox.getChildren().add(playButton);
        hbox.getChildren().add(stopButton);
        hbox.getChildren().add(timestampButton);
        hbox.getChildren().add(recordButton);
        hbox.getChildren().add(stopRecording);
        
        final Slider slider = new Slider();
        vbox.getChildren().add(slider);
        
        
        root.getChildren().add(view);
        root.getChildren().add(vbox);
        root.getChildren().add(hbox);
        Scene scene = new Scene(root,400,400, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
       // player.play();
        
        player.setOnReady(new Runnable(){
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                
               
                primaryStage.setMinWidth(w);
                primaryStage.setMinHeight(h);
                
                
                vbox.setMinSize(w, 100);
                vbox.setTranslateY(h-20);
                hbox.setTranslateY(h-8);
                
                slider.setMin(0.0);
                slider.setValue(0.0);
                slider.setMax(player.getTotalDuration().toSeconds());
                
                slideIn.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                        new KeyValue(vbox.translateYProperty(),h),
                        new KeyValue(vbox.opacityProperty(),0.0)                       
                        ),
                        new KeyFrame(new Duration(300),
                        new KeyValue(vbox.translateYProperty(),h-20),
                        new KeyValue(vbox.opacityProperty(),0.9)
                        )
                );
                
                                
                slideOut.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                        new KeyValue(vbox.translateYProperty(),h-20),
                        new KeyValue(vbox.opacityProperty(),0.9)
                        ),
                        new KeyFrame(new Duration(300),
                        new KeyValue(vbox.translateYProperty(),h),
                        new KeyValue(vbox.opacityProperty(),0.0)
                        )
                );
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
        
       primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            
        }
});
    }
    
    
    AudioFormat getAudioFormat() { 
        float sampleRate = 6000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        return format;
    }
    
    
    public void startRecording(){
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
