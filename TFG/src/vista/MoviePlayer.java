/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.net.URI;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Duration;
/**
 *
 * @author Sergi
 */
public class MoviePlayer extends Application{

    public static void main(String[] args){
        launch(args);
    }
    public MoviePlayer(){
        
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Movie Player");
        Group root = new Group();
        String path = "src"+ File.separator+"resources"+ File.separator+"video.mp4";
        //String path = "C:\\Users\\user\\Desktop\\Rememory\\TFG\\src\\resources\\video.mp4";
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
        hbox.getChildren().add(playButton);
        final Slider slider = new Slider();
        vbox.getChildren().add(slider);
        
        /*final HBox hbox = new HBox(2);
        final int bands = player.getAudioSpectrumNumBands();
        final Rectangle[] rects = new Rectangle[bands];
        for(int i=0;i<rects.length;i++){
            rects[i] = new Rectangle();
            rects[i].setFill(Color.GREENYELLOW);
            hbox.getChildren().add(rects[i]);
        }
        
        vbox.getChildren().add(hbox);*/
        root.getChildren().add(view);
        root.getChildren().add(vbox);
        root.getChildren().add(hbox);
        Scene scene = new Scene(root,400,400, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        player.play();
        
        player.setOnReady(new Runnable(){
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                
                /*hbox.setMinWidth(w);
                int bandWidth = w/rects.length;
                for(Rectangle r:rects){
                    r.setWidth(bandWidth);
                    r.setHeight(2);
                }*/
                //hbox.setMinHeight(bands);
                primaryStage.setMinWidth(w);
                primaryStage.setMinHeight(h);
                
                
                vbox.setMinSize(w, 100);
                vbox.setTranslateY(h-50);
                
                slider.setMin(0.0);
                slider.setValue(0.0);
                slider.setMax(player.getTotalDuration().toSeconds());
                
                slideIn.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                        new KeyValue(vbox.translateYProperty(),h),
                        new KeyValue(vbox.opacityProperty(),0.0)
                        ),
                        new KeyFrame(new Duration(300),
                        new KeyValue(vbox.translateYProperty(),h-50),
                        new KeyValue(vbox.opacityProperty(),0.9)
                        )
                );
                
                                
                slideOut.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                        new KeyValue(vbox.translateYProperty(),h-50),
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
        /*player.setAudioSpectrumListener(new AudioSpectrumListener(){
            @Override
            public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
                for(int i=0;i<rects.length;i++){
                   //double h = mags[i]+60;
                   rects[i].setHeight(player.getMedia().getHeight());
                }
            }       
        });*/
    }
}
