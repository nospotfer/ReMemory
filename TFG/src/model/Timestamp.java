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
public class Timestamp {
    private int idTimestamp;
    private float temps;
    private Sessio sessio;

    public Timestamp(){}
    
    public Timestamp(float temps, Sessio sessio){
        this.temps=temps;
        this.sessio = sessio;
    }
    /**
     * @return the idTimestamp
     */
    public int getIdTimestamp() {
        return idTimestamp;
    }

    /**
     * @param idTimestamp the idTimestamp to set
     */
    public void setIdTimestamp(int idTimestamp) {
        this.idTimestamp = idTimestamp;
    }

    /**
     * @return the temps
     */
    public float getTemps() {
        return temps;
    }

    /**
     * @param temps the temps to set
     */
    public void setTemps(float temps) {
        this.temps = temps;
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
