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
public class Gravacio {
    private int idGravacio;
    private String nom;
    private String data;
     private Sessio sessio;
    private Set<Timestamp> timestamps;
    
    public Gravacio(){}
    
    public Gravacio(String nom, String data, Sessio sessio){
        this.nom = nom;
        this.data = data;
        this.sessio = sessio;
    }   

    /**
     * @return the idGravacio
     */
    public int getIdGravacio() {
        return idGravacio;
    }

    /**
     * @param idGravacio the idGracavio to set
     */
    public void setIdGravacio(int idGravacio) {
        this.idGravacio = idGravacio;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
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
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the sessio
     */
    public Sessio getSessio() {
        return sessio;
    }

    /**
     * @param sessio the sessio to set
     */
    public void setSessio(Sessio sessio) {
        this.sessio = sessio;
    }
    
}
