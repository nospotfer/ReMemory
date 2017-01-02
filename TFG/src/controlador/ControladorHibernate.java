/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import model.Sessio;
import model.Imatge;
import model.PacientDatabase;
import model.Descripcio;
import model.Timestamp;
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
        
        session.save(pacient);
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
    
    public void crearSessio(int numSessio,int any, int mes, int numDia, int idPacient){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction(); 
        Query query = session.createQuery("from Sessio where idPacient = :idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        List list = query.list();
        if(list.isEmpty()){
            Sessio sessio = (Sessio)list.get(0);
            Sessio sessioPacient = (Sessio) session.get(Sessio.class, sessio.getIdSessio());
            
            PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
            //Sessio sessio = new Sessio(idSessio, numSessio, any, mes, numDia, pacient);
            //sessio.setIdSessio(idSessio);
            sessio.setAny(any);
            sessio.setMes(mes);
            sessio.setDia(numDia);
            sessio.setPacient(pacient);       

            session.save(sessio);
            tx.commit();
        }
        
        session.close(); 
    }

    
    public void crearImatge(String nomImatge, String path, int hora, int minut, int segon, int idSessio){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        Sessio sessio = (Sessio) session.get(Sessio.class, idSessio);
        
        Imatge imatge = new Imatge(nomImatge, path, hora, minut, segon, sessio);
        imatge.setNomImatge(nomImatge);
        imatge.setPath(path);
        imatge.setHora(hora);
        imatge.setMinut(minut);
        imatge.setSegon(segon);
        imatge.setSessio(sessio);
        
        session.saveOrUpdate(imatge);
        tx.commit();
        session.close();         
    }
    
    
        public void crearDescripcio(String textDescripcio, int numSessio, int idPacient){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println("numSessio: "+numSessio);
        System.out.println("idPacient: "+idPacient);
       // Sessio sessio = (Sessio) session.get(Sessio.class, idSessio);
        
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient = :idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        Sessio sessio = (Sessio) list.get(0);
        int id = sessio.getIdSessio();
        
        Sessio sessioDescripcio = (Sessio) session.get(Sessio.class, id);
        
        Descripcio descripcio = new Descripcio(textDescripcio, sessioDescripcio); 
        descripcio.setDescripcio(textDescripcio);
        descripcio.setSessio(sessio);
   
        session.saveOrUpdate(descripcio);
        tx.commit();
        session.close();          
    }
        
    public void crearTimestamp(float temps, int idPacient, int numSessio){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        Query query = session.createQuery("from Sessio where idPacient = :idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        Sessio sessio = (Sessio) list.get(0);
        int id = sessio.getIdSessio();
             
        Timestamp timestamp = new Timestamp(temps,sessio);
        timestamp.setTemps(temps);
        timestamp.setSessio(sessio);
        session.saveOrUpdate(timestamp);
        tx.commit();
        session.close();  
    }  
    
    public List getDescripcions(int idPacient, int numSessio){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        List finalList = new ArrayList();
        List tempList = new ArrayList();
        //Sessio sessio =(Sessio)list.get(0);
        Sessio sessio;
        
        for(int i=0; i< list.size();i++){
            sessio =(Sessio)list.get(i);
            query = session.createQuery("from Descripcio where idSessio =:idSessio");
            query.setParameter("idSessio",sessio.getIdSessio());
            tempList = query.list();
            finalList.addAll(tempList);
        }
        
        
       /* query = session.createQuery("from Descripcio where idSessio =:idSessio");
        query.setParameter("idSessio",sessio.getIdSessio());
        list = query.list();*/
        if(finalList.isEmpty()){
            System.out.println("No hi havia cap descripcio");
        }
        else{
            System.out.println("Hi havien descripcions");
        }
        session.close();
        return finalList;
    }
 
    
    public List getTimestamps(int idPacient, int numSessio){
         Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        List finalList = new ArrayList();
        List tempList = new ArrayList();
        //Sessio sessio =(Sessio)list.get(0);
        Sessio sessio;
        
        for(int i=0; i< list.size();i++){
            sessio =(Sessio)list.get(i);
            query = session.createQuery("from Timestamp where idSessio =:idSessio");
            query.setParameter("idSessio",sessio.getIdSessio());
            tempList = query.list();
            finalList.addAll(tempList);
        }
        
        
        
       /* query = session.createQuery("from Descripcio where idSessio =:idSessio");
        query.setParameter("idSessio",sessio.getIdSessio());
        list = query.list();*/
        if(finalList.isEmpty()){
            System.out.println("No hi havia cap descripcio");
        }
        else{
            System.out.println("Hi havien descripcions");
        }
        session.close();
        return finalList;
    }
    
    /*public List getSessionsOfDescripcions(){
    }*/
    

}
