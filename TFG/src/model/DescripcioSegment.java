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
public class DescripcioSegment {
    private int idDescripcioSegment;
    private String descripcio;
    private Segment segment;
    
    public DescripcioSegment(){
    }
    
    public DescripcioSegment(int idDescripcioSegment, String descripcio, Segment segment){
        this.idDescripcioSegment = idDescripcioSegment;
        this.descripcio =  descripcio;
        this.segment = segment;
    }

    /**
     * @return the idDescripcioSegment
     */
    public int getIdDescripcioSegment() {
        return idDescripcioSegment;
    }

    /**
     * @param idDescripcioSegment the idDescripcioSegment to set
     */
    public void setIdDescripcioSegment(int idDescripcioSegment) {
        this.idDescripcioSegment = idDescripcioSegment;
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
