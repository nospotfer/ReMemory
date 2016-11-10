/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sergi
 */
public class Imatge {
    private String nomImatge;
    private String path;
    private int hora;
    private int minut;
    private int segon;
    private Segment segment;
    
    public Imatge(){
    }
    
    public Imatge(String nomImatge, String path, int hora, int minut, int segon, Segment segment){
        this.nomImatge = nomImatge;
        this.path = path;
        this.hora = hora;
        this.minut = minut;
        this.segon = segon;
        this.segment = segment;
    }

    /**
     * @return the nomImatge
     */
    public String getNomImatge() {
        return nomImatge;
    }

    /**
     * @param nomImatge the nomImatge to set
     */
    public void setNomImatge(String nomImatge) {
        this.nomImatge = nomImatge;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the minut
     */
    public int getMinut() {
        return minut;
    }

    /**
     * @param minut the minut to set
     */
    public void setMinut(int minut) {
        this.minut = minut;
    }

    /**
     * @return the segon
     */
    public int getSegon() {
        return segon;
    }

    /**
     * @param segon the segon to set
     */
    public void setSegon(int segon) {
        this.segon = segon;
    }

    /**
     * @return the segment
     */
    public Segment getSegment() {
        return segment;
    }

    /**
     * @param segment the segment to set
     */
    public void setSegment(Segment segment) {
        this.segment = segment;
    }
    
}
