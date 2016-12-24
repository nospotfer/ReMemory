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
public class Descripcio {
    private int idDescripcio;
    private String descripcio;
    private Sessio sessio;

    public Descripcio(){}
    
    public Descripcio(String descripcio, Sessio sessio){
        //this.idDescripcio = idDescripcio;
        this.descripcio = descripcio;
        this.sessio = sessio;
        
    }
    /**
     * @return the idDescripcio
     */
    public int getIdDescripcio() {
        return idDescripcio;
    }

    /**
     * @param idDescripcio the idDescripcio to set
     */
    public void setIdDescripcio(int idDescripcio) {
        this.idDescripcio = idDescripcio;
    }

    /**
     * @return the descripcio
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * @param descripcio the descripcio to set
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
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

    /**
     * @return the idSessio
     */

    
}
