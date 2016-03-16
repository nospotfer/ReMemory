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
public class Evaluador extends Persona{

    private String password;
    
    public Evaluador(String nom, String id, String rol, String password) {
        super(nom, id, rol);
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public JSONObject toJSON() throws JSONException{
        JSONObject o = new JSONObject();
        o.put("id",id);
        o.put("name", nom.toLowerCase());
        o.put("password", password);
        o.put("role","evaluador");
        return o;
    }
}
