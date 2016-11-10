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
public class Segment {
    private int idSegment;
    private int horaInici;
    private int minutInici;
    private int segonInici;
    private int horaFinal;
    private int minutFinal;
    private int segonFinal;
    private Dia dia;
    private Set<Pregunta> preguntes;
    private Set<Imatge> imatges;
    private Set<DescripcioSegment> descripcions;
    
    public Segment(){
    }
    
    public Segment(int idSegment, int horaInici,int minutInici, int segonInici, int horaFinal, int minutFinal, Dia dia){
        this.idSegment = idSegment;
        this.horaInici = horaInici;
        this.minutInici = minutInici;
        this.segonInici = segonInici;
        this.horaFinal = horaFinal;
        this.minutFinal = minutFinal;
        this.segonFinal = segonFinal;
        this.dia = dia;
    
    }

    /**
     * @return the idSegment
     */
    public int getIdSegment() {
        return idSegment;
    }

    /**
     * @param idSegment the idSegment to set
     */
    public void setIdSegment(int idSegment) {
        this.idSegment = idSegment;
    }

    /**
     * @return the horaInici
     */
    public int getHoraInici() {
        return horaInici;
    }

    /**
     * @param horaInici the horaInici to set
     */
    public void setHoraInici(int horaInici) {
        this.horaInici = horaInici;
    }

    /**
     * @return the minutInici
     */
    public int getMinutInici() {
        return minutInici;
    }

    /**
     * @param minutInici the minutInici to set
     */
    public void setMinutInici(int minutInici) {
        this.minutInici = minutInici;
    }

    /**
     * @return the segonInici
     */
    public int getSegonInici() {
        return segonInici;
    }

    /**
     * @param segonInici the segonInici to set
     */
    public void setSegonInici(int segonInici) {
        this.segonInici = segonInici;
    }

    /**
     * @return the horaFinal
     */
    public int getHoraFinal() {
        return horaFinal;
    }

    /**
     * @param horaFinal the horaFinal to set
     */
    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * @return the minutFinal
     */
    public int getMinutFinal() {
        return minutFinal;
    }

    /**
     * @param minutFinal the minutFinal to set
     */
    public void setMinutFinal(int minutFinal) {
        this.minutFinal = minutFinal;
    }

    /**
     * @return the segonFinal
     */
    public int getSegonFinal() {
        return segonFinal;
    }

    /**
     * @param segonFinal the segonFinal to set
     */
    public void setSegonFinal(int segonFinal) {
        this.segonFinal = segonFinal;
    }

    /**
     * @return the dia
     */
    public Dia getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(Dia dia) {
        this.dia = dia;
    }

    /**
     * @return the preguntes
     */
    public Set<Pregunta> getPreguntes() {
        return preguntes;
    }

    /**
     * @param preguntes the preguntes to set
     */
    public void setPreguntes(Set<Pregunta> preguntes) {
        this.preguntes = preguntes;
    }

    /**
     * @return the imatges
     */
    public Set<Imatge> getImatges() {
        return imatges;
    }

    /**
     * @param imatges the imatges to set
     */
    public void setImatges(Set<Imatge> imatges) {
        this.imatges = imatges;
    }

    /**
     * @return the descripcions
     */
    public Set<DescripcioSegment> getDescripcions() {
        return descripcions;
    }

    /**
     * @param descripcions the descripcions to set
     */
    public void setDescripcions(Set<DescripcioSegment> descripcions) {
        this.descripcions = descripcions;
    }
    
}
