/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import model.PacientDatabase;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sergi
 */
public class ControladorHibernate {
    Conector con = new Conector();
    
    public void crearPacient(String nom, int idPacient, int edat, int anysEscola){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        PacientDatabase pacient = new PacientDatabase(nom, idPacient, edat, anysEscola);
        pacient.setNom(nom);
        pacient.setId(idPacient);
        pacient.setEdat(edat);
        pacient.setAnysEscola(anysEscola);
        
        session.saveOrUpdate(pacient);
        tx.commit();
        System.out.println("He creat el pacient correctament");
        session.close();
        
    }
    
    public PacientDatabase getPacient(int id){
        System.out.println("AH!");
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, id);
        session.close();
        System.out.println("id:"+pacient.getId());
        System.out.println("nom:"+pacient.getNom());
        return pacient;
    
    }
    
        
    
    
    

}
