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
public class Sessio {
    private int idSessio;
    private int any;
    private int mes;
    private int dia;
    private int numSessio;
    private PacientDatabase pacient;
    private Set<Descripcio> descripcions;
    private Set<Timestamp> timestamps;
    //private String path 
    
    public Sessio(){}
    
    public Sessio(int idSessio, int numSessio, int any, int mes, int dia, PacientDatabase pacient){
        //this.idSessio = idSessio;
        this.numSessio = numSessio;
        this.any = any;
        this.mes = mes;
        this.dia = dia;
        this.pacient = pacient;
    }

    /**
     * @return the idSessio
     */
    public int getIdSessio() {
        return idSessio;
    }

    /**
     * @param idSessio the idSessio to set
     */
    public void setIdSessio(int idSessio) {
        this.idSessio = idSessio;
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
     * @return the pacient
     */
    public PacientDatabase getPacient() {
        return pacient;
    }

    /**
     * @param pacient the pacient to set
     */
    public void setPacient(PacientDatabase pacient) {
        this.pacient = pacient;
    }

    /**
     * @return the descripcions
     */
    public Set<Descripcio> getDescripcions() {
        return descripcions;
    }

    /**
     * @param descripcions the descripcions to set
     */
    public void setDescripcions(Set<Descripcio> descripcions) {
        this.descripcions = descripcions;
    }

    /**
     * @return the timestamps
     */
    public Set<Timestamp> getTimestamps() {
        return timestamps;
    }

    /**
     * @param timestamps the timestamps to set
     */
    public void setTimestamps(Set<Timestamp> timestamps) {
        this.timestamps = timestamps;
    }

    /**
     * @return the numSessio
     */
    public int getNumSessio() {
        return numSessio;
    }

    /**
     * @param numSessio the numSessio to set
     */
    public void setNumSessio(int numSessio) {
        this.numSessio = numSessio;
    }
}
