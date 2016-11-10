/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;

/**
 *
 * @author Sergi
 */
public class Dia {
    private int any;
    private int mes;
    private int dia;
    private String anymesdia;
    private Pacient pacient;
    private Set<Segment> segments;
    
    
    public Dia(){
    }
    
    public Dia(int any, int mes, int dia, Pacient pacient){
        anymesdia = String.valueOf(any)+String.valueOf(mes)+String.valueOf(dia);
        this.any =any;
        this.mes = mes;
        this.dia = dia;
        this.pacient = pacient;     
    }

    /**
     * @return the any
     */
    public int getAny() {
        return any;
    }

    /**
     * @param any the any to set
     */
    public void setAny(int any) {
        this.any = any;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the anymesdia
     */
    public String getAnymesdia() {
        return anymesdia;
    }

    /**
     * @param anymesdia the anymesdia to set
     */
    public void setAnymesdia(String anymesdia) {
        this.anymesdia = anymesdia;
    }

    /**
     * @return the pacient
     */
    public Pacient getPacient() {
        return pacient;
    }

    /**
     * @param pacient the pacient to set
     */
    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    /**
     * @return the segments
     */
    public Set<Segment> getSegments() {
        return segments;
    }

    /**
     * @param segments the segments to set
     */
    public void setSegments(Set<Segment> segments) {
        this.segments = segments;
    }
    
}
