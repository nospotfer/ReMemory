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
public class Usuari {
    
    private String nom;
    private String contrasenya;
    private int rol;
    private int id;
    private Set<PacientDatabase> pacients;
     
    public Usuari(){}
    
    public Usuari(String nom, String contrasenya, int rol){
        this.nom = nom;
        this.contrasenya = contrasenya;
        this.rol = rol;
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
     * @return the contrasenya
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * @param contrasenya the contrasenya to set
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    /**
     * @return the rol
     */
    public int getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(int rol) {
        this.rol = rol;
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
     * @return the pacient
     */
    public Set<PacientDatabase> getPacients() {
        return pacients;
    }

    /**
     * @param pacients the pacient to set
     */
    public void setPacients(Set<PacientDatabase> pacients) {
        this.pacients = pacients;
    }
    
}
