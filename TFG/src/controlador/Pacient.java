/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author USER
 */
public class Pacient extends Persona{
    
    private int edat;
    private int anysEscola;
    
    public Pacient(String nom, String id, int edat, int anysEscola) {
        super(nom, id, "pacient");
        this.edat = edat;
        this.anysEscola = anysEscola;
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

    public JSONObject toJSON() throws JSONException {
        JSONObject o = new JSONObject();
        o.put("id",id);
        o.put("name", nom.toLowerCase());
        o.put("role","pacient");
        return o;
    }
}
