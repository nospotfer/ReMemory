/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import model.Dia;
import model.Imatge;
import model.PacientDatabase;
import model.Pregunta;
import model.Segment;
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
        session.close();
        
    }
    
    public PacientDatabase getPacient(int id){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, id);
        session.close();
        
        return pacient;
    }
    
    public void borrarPacient(int id) {
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, id);
        session.delete(pacient);
        
        tx.commit();
        session.close();
    }
    
    public void crearDia(int any, int mes, int numDia, int idPacient){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        PacientDatabase pacient = getPacient(idPacient);
        Dia dia = new Dia(any, mes, numDia, pacient);
        dia.setAny(any);
        dia.setMes(mes);
        dia.setDia(numDia);
        dia.setPacient(pacient);
       
        session.saveOrUpdate(dia);
        tx.commit();
        session.close();   
    }
    
    public void crearSegment(int idSegment, int horaInici, int minutInici, int segonInici, int horaFinal, int minutFinal, int segonFinal, String anymesdia){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        Dia dia = (Dia) session.get(Dia.class, anymesdia);
        Segment segment = new Segment(idSegment, horaInici,minutInici, segonInici, horaFinal, minutFinal, segonFinal, dia);
        segment.setIdSegment(idSegment);
        segment.setHoraInici(horaInici);
        segment.setMinutInici(minutInici);
        segment.setSegonInici(segonInici);
        segment.setHoraFinal(horaFinal);
        segment.setMinutFinal(minutFinal);
        segment.setSegonFinal(segonFinal);
        segment.setDia(dia);
        
        session.saveOrUpdate(dia);
        tx.commit();
        session.close(); 
    }
    
    public void crearImatge(String nomImatge, String path, int hora, int minut, int segon, int idSegment){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        Segment segment = (Segment) session.get(Segment.class, idSegment);
        
        Imatge imatge = new Imatge(nomImatge, path, hora, minut, segon, segment);
        imatge.setNomImatge(nomImatge);
        imatge.setPath(path);
        imatge.setHora(hora);
        imatge.setMinut(minut);
        imatge.setSegon(segon);
        imatge.setSegment(segment);
        
        session.saveOrUpdate(imatge);
        tx.commit();
        session.close();         
    }
    
    public void crearPregunta(int idPregunta,String textPregunta, String resposta, int idSegment){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        Segment segment = (Segment) session.get(Segment.class, idSegment);
        
        Pregunta pregunta = new Pregunta(idPregunta, textPregunta, resposta, segment);
        pregunta.setIdPregunta(idPregunta);
        pregunta.setPregunta(textPregunta);
        pregunta.setResposta(resposta);
        pregunta.setSegment(segment);
        
        session.saveOrUpdate(pregunta);
        tx.commit();
        session.close();                 
    
    }
        
    
    
    

}
