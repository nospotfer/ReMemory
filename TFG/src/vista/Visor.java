/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorHibernate;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.sound.sampled.*;
/*import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;*/

/**
 *
 * @author Sergi
 */
public class Visor extends JFrame {

    BufferedImage imagen;
    private BufferedImage img;
    JButton button;
    GridBagConstraints c;
    JLabel lblImageHolder;
    TargetDataLine line;
    public boolean pause = false;
    ArrayList<Float> timeStamps = new ArrayList<>();
    File wavFile;
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    Thread one;
    float start;
    JButton stopButton;
    JButton stampButton;
    ControladorHibernate controlador;
    
    public Visor(BufferedImage imagen, String nomPacient, int numSessio, int idPacient) {      
        //Dimension size = new Dimension(320,240);
        //this.setSize(500, 500);
        controlador = new ControladorHibernate();
        wavFile = new File("src"+ File.separator+"resources"+File.separator+nomPacient+File.separator+nomPacient+"-sessio"+String.valueOf(numSessio)+".wav");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel contentPane = new JPanel();          
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        lblImageHolder = new JLabel();
        c.gridwidth = 4;
        c.gridheight = 4;
        c.gridx = 0;
        c.gridy = 0;      
        this.add(lblImageHolder, c);
        
        JButton playButton = new JButton("Play");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady=0;
        c.ipadx = 150;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.insets = new Insets(10,0,0,0); /*(top,)*/
        playButton.addActionListener((ActionEvent ae) -> {
            if(pause==true){
                pause=false;
                playButton.setText("Pausa");
            }
            else if(pause==false){        
                pause=true;
                playButton.setText("Play");
            }
        });
        this.add(playButton, c);
        
        JButton recordButton = new JButton("Start recording");
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 5;
        recordButton.addActionListener((ActionEvent ae) -> {
            stopButton.setEnabled(true);
            stampButton.setEnabled(true);
            start = System.currentTimeMillis();
            one = new Thread(){
                @Override
                public void run(){
                    try {                        
                        startRecording();                      
                    } catch (LineUnavailableException | IOException ex) {
                        Logger.getLogger(Visor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            };
            one.start();
           
        });
        this.add(recordButton, c);
        
        stopButton = new JButton("Stop Recording");
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 5;
        stopButton.setEnabled(false);
        stopButton.addActionListener((ActionEvent ae) -> {
            finish();
            Thread.currentThread().interrupt();
        });
        
        this.add(stopButton, c);

        stampButton = new JButton("Time Stamp");
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 5;
        stampButton.addActionListener((ActionEvent ae) -> {
            float timeStamp = System.currentTimeMillis();
            controlador.crearTimestamp(start-timeStamp, idPacient, numSessio);
            timeStamps.add(timeStamp);
        });      
        stampButton.setEnabled(false);
        this.add(stampButton, c);
        
        if (imagen != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            float screenWidth = (screenSize.width/2);
            float screenHeight = (screenSize.height/2)*1.33f;
            BufferedImage resizedImg = resizeImage(imagen, imagen.getType(),screenSize.width/2, Math.round(screenHeight));
            ImageIcon icono = new ImageIcon((Image) resizedImg);
            lblImageHolder.setIcon(icono);
        }
    }
   
    public void ChangeImatge(BufferedImage imagen) {     
        if (imagen != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            BufferedImage resizedImg = resizeImage(imagen, imagen.getType(),screenSize.width/2,screenSize.height/2);
            ImageIcon icono = new ImageIcon((Image) resizedImg);
            
            lblImageHolder.setIcon(icono);                            
        }
    }
    
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int type, Integer img_width, Integer img_height)
    {
        BufferedImage resizedImage = new BufferedImage(img_width, img_height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, img_width, img_height, null);
        g.dispose();

        return resizedImage;
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
    
    
    void startRecording() throws LineUnavailableException, IOException{
        
        AudioFormat format = getAudioFormat();
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, getAudioFormat());
         // checks if system supports the data line
        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported");
            System.exit(0);
        }
        line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();   // start capturing

        System.out.println("Start capturing...");
        AudioInputStream ais = new AudioInputStream(line);
        System.out.println("Start recording...");
        // start recording
        AudioSystem.write(ais, fileType, wavFile);
    
    }
    
    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }
    
}
