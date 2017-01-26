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
import java.text.DecimalFormat;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import model.Descripcio;
import model.Gravacio;
import model.Timestamp;

/**
 *
 * @author Sergi
 */
public class Transcripcio {
    
 
    static MediaPlayer player;
    static MediaPlayer player2;
    static HBox hbox = new HBox();
    static HBox hbox5;
    static Label time;
    static int h,w;
    static TargetDataLine line;
    static File wavFile;
    static AudioInputStream ais;
    static AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    static Thread one;
    static Slider slider ;
    static JFrame frame;
    static String folderPath;
    static ControladorHibernate controlador;
    static VBox nova;
    static Slider slider2;
    
     private static void initAndShowGUI(String path, int idPacient, int numSessio) {
        // This method is invoked on the EDT thread
        frame = new JFrame("Transcripción");
        nova = new VBox();
        
        /*Setting fram configurations*/
        final JFXPanel fxPanel = new JFXPanel();
        controlador = new ControladorHibernate();
        JLabel label = new JLabel("             ");
       
        label.setBackground( new java.awt.Color(240,248,255));
        label.setOpaque(true);
        frame.add(label,BorderLayout.WEST); 
       
        JLabel label2 = new JLabel("             ");
        label2.setBackground( new java.awt.Color(240,248,255));
        label2.setOpaque(true);
        frame.add(label2,BorderLayout.PAGE_START);
       
        frame.add(fxPanel,BorderLayout.CENTER);   
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                player.stop();
                player2.stop();                      
                frame.setVisible(false);
            }
        });
        
        time = new Label();
        Platform.runLater(() -> {
            initFX(fxPanel, path, idPacient, numSessio);
        });
    }
     
     
       private static void initFX(JFXPanel fxPanel, String path , int idPacient, int numSessio) {
        // This method is invoked on the JavaFX thread
        Scene scene;
        scene = createScene(path, idPacient, numSessio);
        fxPanel.setScene(scene);
    }
    
    private static Scene createScene(String path, int idPacient, int numSessio) {
        Group root = new Group();
        
        File dir = new File(path);
        String nomVideo="";
        /*We choose the video to play*/
        for (File file : dir.listFiles()) {  
            if (file.getName().endsWith((".mp4"))) {
                nomVideo = file.getName();
            }
        }
        String pathVideo = path + File.separator+nomVideo;
        File f = new File(pathVideo);
        URI u = f.toURI();
        Media media = new Media(u.toString());
        media.getWidth();
        player = new MediaPlayer(media);
        hbox = new HBox();
        MediaView view = new MediaView(player);
        
        /*Creation of Buttons*/
        final Button playButton = new Button("Play video"); 
        playButton.setOnAction((ActionEvent event) -> {
            player.play();
        });
        
        
        Button pauseButton = new Button("Pausar video");
        pauseButton.setOnAction((ActionEvent event) -> {
            player.pause();
        });
        
        
        Button stopButton = new Button("Parar video");
        stopButton.setOnAction((ActionEvent event) -> {
            player.stop();
        });
        
        Button changeButton = new Button("Cambiar gravación");
        changeButton.setOnAction((ActionEvent event) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            boolean existeix = controlador.checkGravacio(idPacient, numSessio, chooser.getSelectedFile().getName());
            if (chooser.getSelectedFile()!=null && existeix==true) {
                String path1 = chooser.getSelectedFile().getAbsolutePath();
                String filename=chooser.getSelectedFile().getName();
                //System.out.println(filename);
                wavFile = new File(path1);
                URI uri = wavFile.toURI();
                Media media2 = new Media(uri.toString());
                player2 = new MediaPlayer(media2);
                MediaView view2 = new MediaView(player2);
                final DecimalFormat df = new DecimalFormat("####0.00");
                
                
                player2.setOnReady(() -> {
                    slider2.setMin(0.0);
                    slider2.setValue(0.0);
                    slider2.setMax(player2.getTotalDuration().toSeconds());
                    time.setText("0.00"+" : "+String.valueOf(df.format(player2.totalDurationProperty().getValue().toSeconds())));
                });
                player2.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration duration, Duration current) -> {
                    slider2.setValue(current.toSeconds());
                    DecimalFormat df1 = new DecimalFormat("####0.00");
                    time.setText(String.valueOf(df1.format(current.toSeconds())) + " : " + String.valueOf(df1.format(player2.totalDurationProperty().getValue().toSeconds())));
                });
                hbox5.getChildren().clear();
                List timestamps = controlador.getTimestamps(idPacient, numSessio, filename);
                for(int i=0;i<timestamps.size();i++){
                    
                    Timestamp timestamp = (Timestamp)timestamps.get(i);
                    Label timestampLabel = new Label();
  
                    timestampLabel.setText(String.valueOf(df.format(timestamp.getTemps())));
                    timestampLabel.setPadding(new Insets(0, 0, 0, 10));
                    
                    timestampLabel.setOnMouseClicked((MouseEvent mouseEvent) -> {
                        slider2.setValue(timestamp.getTemps());
                        player2.seek(Duration.seconds(slider2.getValue()));
                    });
                    
                    hbox5.getChildren().add(timestampLabel);                      
                }
            }
        });
        
        HBox hbox9 = new HBox();
        hbox9.getChildren().add(changeButton);
        hbox.getChildren().add(playButton);
        hbox.getChildren().add(pauseButton);
        hbox.getChildren().add(stopButton);
        //hbox.getChildren().add(changeButton);
        
        final VBox vbox = new VBox();      
        
        VBox vbox2 = new VBox();
        Gravacio gravacio = controlador.getFirstGravacio(idPacient, numSessio);
        String nomGravacio="";
        if(gravacio!= null){
            nomGravacio = gravacio.getNom();
            wavFile = new File(path+File.separator+nomGravacio);         
            u = wavFile.toURI();
            Media media2 = new Media(u.toString());
            player2 = new MediaPlayer(media2);
            MediaView view2 = new MediaView(player2);
            vbox2.getChildren().add(view2);
        }
         
        HBox hbox3 = new HBox();
        Button playMusicButton = new Button("Play");
        playMusicButton.setOnAction((ActionEvent event) -> {
            player2.play();
            //playButton.setText("Stop");
        });
        
        Button pauseMusicButton = new Button("Pausa");
        pauseMusicButton.setOnAction((ActionEvent event) -> {
            player2.pause();
            //playButton.setText("Stop");
        });
        
        
        Button stopMusicButton = new Button("Stop");
        stopMusicButton.setOnAction((ActionEvent event) -> {
            player2.stop();
            //playButton.setText("Stop");
        });
        slider2 = new Slider();
        hbox3.getChildren().add(playMusicButton);
        hbox3.getChildren().add(pauseMusicButton);
        hbox3.getChildren().add(stopMusicButton);
        hbox3.getChildren().add(slider2);

            player2.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration duration, Duration current) -> {
                slider2.setValue(current.toSeconds());
                DecimalFormat df = new DecimalFormat("####0.00");
                time.setText(String.valueOf(df.format(current.toSeconds()))+" : "+String.valueOf(df.format(player2.totalDurationProperty().getValue().toSeconds())));
            });   
            slider2.setOnMousePressed((MouseEvent event) -> {
                player2.seek(Duration.seconds(slider2.getValue()));
                DecimalFormat df = new DecimalFormat("####0.00");
                df.format(Duration.seconds(slider2.getValue()).toSeconds());        
                time.setText(String.valueOf(df.format(Duration.seconds(slider2.getValue()).toSeconds()))+" : "+String.valueOf(df.format(player2.totalDurationProperty().getValue().toSeconds())));
            });
         /*Called when the recording is loaded*/
            player2.setOnReady(() -> {
                int w1 = player.getMedia().getWidth()+200;
                int h1 = player.getMedia().getHeight()+275;
                hbox3.setTranslateY(h1 + 100);
                hbox3.setPrefWidth(w1+20);
                slider2.setMin(0.0);
                slider2.setValue(0.0);
                slider2.setPrefWidth(w1 - 150);
                slider2.setMax(player2.getTotalDuration().toSeconds());
                DecimalFormat df = new DecimalFormat("####0.00");
                time.setText("0.00"+" : "+String.valueOf(df.format(player2.totalDurationProperty().getValue().toSeconds())));
            });   
        slider = new Slider();   
        vbox.getChildren().add(slider);
        vbox.setMinWidth(600);
        hbox5 = new HBox();
        hbox5.getChildren().clear();
        if(nomGravacio!=""){
            List timestamps = controlador.getTimestamps(idPacient, numSessio, nomGravacio);
            for(int i=0;i<timestamps.size();i++){

                Timestamp timestamp = (Timestamp)timestamps.get(i);
                Label timestampLabel = new Label();

                DecimalFormat df = new DecimalFormat("####0.00");
                timestampLabel.setText(String.valueOf(df.format(timestamp.getTemps())));
                timestampLabel.setPadding(new Insets(0, 0, 0, 10));

                timestampLabel.setOnMouseClicked((MouseEvent mouseEvent) -> {
                    slider2.setValue(timestamp.getTemps());
                    player2.seek(Duration.seconds(slider2.getValue()));
                });

                  hbox5.getChildren().add(timestampLabel);
            }   
        }
        HBox hbox6 = new HBox();
        TextArea textarea = new TextArea();
        hbox6.getChildren().add(textarea);
        
        HBox hbox7 = new HBox();
        Button acceptButton = new Button("Añadir Descripción");
         acceptButton.setOnAction((ActionEvent event) -> {
             String data=textarea.getText().trim();
            if (!data.equals("")) {
                controlador.crearDescripcio(textarea.getText(), numSessio, idPacient);
                List descripcions = controlador.getDescripcions(idPacient, numSessio);
                Label descripcio = new Label();
                descripcio.setText(textarea.getText());
                nova.getChildren().add(descripcio);
                textarea.setText("");
                int w1 = player.getMedia().getWidth();
                int h1 = player.getMedia().getHeight();
            }
        });
         
         Button closeButton = new Button("Cerrar");
         closeButton.setOnAction((ActionEvent event) -> {
            player.stop();
            player2.stop();
            frame.setVisible(false);
        });
        hbox7.getChildren().add(acceptButton);
        hbox7.getChildren().add(closeButton);
        
        HBox hbox8 = new HBox();
        hbox8.getChildren().add(time);
        
        /*All components are added to the frame*/
        Scene  scene  =  new  Scene(root, media.getWidth() ,media.getHeight(),Color.ALICEBLUE);
        view.setScaleX(2.5);
        view.setScaleY(2.5);
        root.getChildren().add(view);
        root.getChildren().add(hbox);
        root.getChildren().add(vbox);
        root.getChildren().add(vbox2);
        root.getChildren().add(hbox3);
        root.getChildren().add(hbox5);
        root.getChildren().add(hbox6);
        root.getChildren().add(hbox7);
        root.getChildren().add(hbox8);
        root.getChildren().add(hbox9);
        
        player.setOnReady(() -> {
            int w1 = player.getMedia().getWidth()+200;
            int h1 = player.getMedia().getHeight()+275;
            frame.setSize(w1 + 400, h1 + 400);
            vbox.setTranslateY(h1 - 10);
            hbox.setTranslateY(h1);
            hbox5.setTranslateY(h1 + 80);
            hbox5.setPrefWidth(w1);
            textarea.setPrefColumnCount(45);
            textarea.setPrefRowCount(5);
            hbox6.setTranslateY(h1 + 170);
            hbox7.setTranslateY(h1 + 275);
            hbox7.setTranslateX(w1 - 125);
            hbox8.setTranslateY(h1 + 138);
            
            hbox9.setTranslateY(h1 +40);
            slider.setMin(0.0);
            slider.setValue(0.0);
            slider.setMaxWidth(w1+10);
            slider.setMax(player.getTotalDuration().toSeconds());
            //VBox nova = new VBox();
            /*Saber mida segons el numero de descripcions*/
            List descripcions = controlador.getDescripcions(idPacient, numSessio);
            //Label descripcio = new Label();
            Label textInicial = new Label("Descripcions: ");
            nova.getChildren().add(textInicial);
            for(int i=0;i<descripcions.size();i++){
                Label descripcio = new Label();
                Descripcio desc = (Descripcio) descripcions.get(i);
                descripcio.setText(desc.getDescripcio()+"\n");
                nova.getChildren().add(descripcio);
                
            }
            nova.setTranslateX(player.getMedia().getWidth()+25);        
            root.getChildren().add(nova);
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
   
}
