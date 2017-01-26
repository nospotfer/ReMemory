/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;


/**
 *
 * @author USER
 */
public class PacientDatabase {
    
    private int id;
    private String nom;
    private int edat;
    private int anysEscola;
    private Usuari usuari;
    private Set<Sessio> sessions;
    
    
    public PacientDatabase(){
    }
    
    public PacientDatabase(String nom, int id, int edat, int anysEscola, Usuari usuari) {
        this.id=id;
        this.nom=nom;
        this.edat = edat;
        this.anysEscola = anysEscola;
        this.usuari = usuari;
    }

    /**
     * @return the edat
     */
    public int getEdat() {
        return edat;
    }

    /**
     * @param edat the edat to set
     */
    public void setEdat(int edat) {
        this.edat = edat;
    }

    /**
     * @return the anysEscola
     */
    public int getAnysEscola() {
        return anysEscola;
    }

    /**
     * @param anysEscola the anysEscola to set
     */
    public void setAnysEscola(int anysEscola) {
        this.anysEscola = anysEscola;
    }


    /**
     * @return the dies
     */
    public Set<Sessio> getDies() {
        return getSessions();
    }

    /**
     * @param sessions the dies to set
     */
    public void setDies(Set<Sessio> sessions) {
        this.setSessions(sessions);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the sessions
     */
    public Set<Sessio> getSessions() {
        return sessions;
    }

    /**
     * @param sessions the sessions to set
     */
    public void setSessions(Set<Sessio> sessions) {
        this.sessions = sessions;
    }

    /**
     * @return the usuari
     */
    public Usuari getUsuari() {
        return usuari;
    }

    /**
     * @param usuari the usuari to set
     */
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
}
