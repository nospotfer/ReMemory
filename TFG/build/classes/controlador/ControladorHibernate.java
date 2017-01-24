/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import model.Sessio;
import model.PacientDatabase;
import model.Descripcio;
import model.Gravacio;
import model.Resposta;
import model.Timestamp;
import model.Usuari;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sergi
 */
public class ControladorHibernate {
    Conector con = new Conector();

    public void crearPacient(String nom, int idPacient, int edat, int anysEscola, String nomUsuari){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        Query query = session.createQuery("from Usuari where nomUsuari = :nomUsuari");
        query.setParameter("nomUsuari", nomUsuari);
        Usuari usuari = (Usuari)query.list().get(0);
        
        PacientDatabase pacient = new PacientDatabase(nom, idPacient, edat, anysEscola, usuari);
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
            //Sessio sessio = (Sessio)list.get(0);
            //Sessio sessioPacient = (Sessio) session.get(Sessio.class, sessio.getIdSessio());
            
            PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
            Sessio sessio = new Sessio(numSessio, any, mes, numDia, pacient);
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
    
    public void crearResposta(String answer, String pregunta, int idPacient, int numSessio){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        Sessio sessio = (Sessio) query.list().get(0);
        
        Resposta resposta = new Resposta(answer, pregunta, sessio);
        resposta.setResposta(answer);
        resposta.setSessio(sessio);
        
        session.saveOrUpdate(resposta);
        tx.commit();
        session.close();         
    }
    
    public void crearGravacio(String nomGravacio, String data, int numSessio, int idPacient){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        Sessio sessio = (Sessio) list.get(0);
        System.out.println(sessio.getIdSessio());
        
        Gravacio gravacio = new Gravacio(nomGravacio, data, sessio);
        gravacio.setNom(nomGravacio);
        gravacio.setData(data);
        gravacio.setSessio(sessio);
   
        session.saveOrUpdate(gravacio);
        tx.commit();
        session.close();                 
    }
    
    
        public void crearDescripcio(String textDescripcio, int numSessio, int idPacient){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
       // Sessio sessio = (Sessio) session.get(Sessio.class, idSessio);
        
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient = :idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        Sessio sessio = (Sessio) list.get(0);
        
        Descripcio descripcio = new Descripcio(textDescripcio, sessio); 
        descripcio.setDescripcio(textDescripcio);
        descripcio.setSessio(sessio);
   
        session.saveOrUpdate(descripcio);
        tx.commit();
        session.close();          
    }
        
    public void crearTimestamp(float temps, String nomGravacio){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        Query query = session.createQuery("from Gravacio where nom = :nomGravacio");
        query.setParameter("nomGravacio", nomGravacio);
        
        List list = query.list();
        Gravacio gravacio = (Gravacio) list.get(0);
             
        Timestamp timestamp = new Timestamp(temps,gravacio);
        timestamp.setTemps(temps);
        timestamp.setGravacio(gravacio);
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
        session.close();
        return finalList;
    }
 
    
    public List getTimestamps(int idPacient, int numSessio, String nomGravacio){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println(nomGravacio);
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        Sessio sessio = (Sessio) list.get(0);
        
        query = session.createQuery("from Gravacio where idSessio =:idSessio and nom=:nomGravacio");
        query.setParameter("idSessio", sessio.getIdSessio());
        query.setParameter("nomGravacio", nomGravacio);
        
        list = query.list();
        Gravacio gravacio = (Gravacio) list.get(0);
        
        query = session.createQuery("from Timestamp where idGravacio =:idGravacio");
        query.setParameter("idGravacio", gravacio.getIdGravacio());
        
        String test;
        List timestamps = query.list();
        

        session.close();
        return timestamps;
    }
    
    public void borrarDescripcio(int idDescripcio){
         Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        Descripcio descripcio = (Descripcio) session.get(Descripcio.class, idDescripcio);
        session.delete(descripcio);
        
        tx.commit();
        session.close();
    }
    
    
    public String getRespostes(int idPacient, int numSessio){
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        Sessio sessio = (Sessio) query.list().get(0);
        
        query = session.createQuery("from Resposta where idSessio =:idSessio");
        query.setParameter("idSessio", sessio.getIdSessio());
        
        List list = query.list();
        Resposta resposta;
        String total = "";
        
        for(int i=0; i< list.size();i++){
            resposta =(Resposta)list.get(i);
            total += resposta.getPregunta()+"\n"+resposta.getResposta()+"\n\n";
        }
 
        session.close();
        return total;
    }
    
    public int login(String nomUsuari, String password){
    
        Session session = con.getSession();
        Query query = session.createQuery("from Usuari where nomUsuari =:nomUsuari");
        query.setParameter("nomUsuari", nomUsuari);
           
        if(query.list().size() >0){           
            Usuari usuari =((Usuari)query.list().get(0));
            if(usuari.getContrasenya().equals(password)){
                int rol = usuari.getRol();
                session.close();
                return rol;
            }
            else{
                session.close();
                return -1;
            }
        }
        else{
            session.close();
            return -1;
        }
        
    }
    
    
    public List getUsuaris(){
        Session session = con.getSession();
        Query query = session.createQuery("from Usuari");
        
        List list = query.list();
        session.close();
        return list;
    
    }
    
    public boolean checkUsuariExists(String nomUsuari){
        Session session = con.getSession();
        Query query = session.createQuery("from Usuari where nomUsuari =:nomUsuari");
        query.setParameter("nomUsuari", nomUsuari);     
        if(query.list().size() >0){ 
            session.close();
            System.out.println(nomUsuari);
            return true;
        }
        else{       
            session.close(); 
            return false;
        }
    }
    
    public void crearUsuari(String nom, String contrasenya, int rol){
        
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();
        Usuari usuari = new Usuari(nom, contrasenya, rol);
        usuari.setNom(nom);
        usuari.setContrasenya(contrasenya);
        usuari.setRol(rol);
        
        session.save(usuari);
        tx.commit();
        session.close();
    }
    
        public void ModificarUsuari(int id, String nomUsuari, String contrasenya, int rol){
        
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();

        Usuari usuari = (Usuari) session.get(Usuari.class, id);
        
        usuari.setNom(nomUsuari);
        usuari.setContrasenya(contrasenya);
        usuari.setRol(rol);
        
        session.update(usuari);
        tx.commit();
        session.close();
    }
        
    public void borrarUsuari(String nomUsuari) {
        Session session = con.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Usuari where nomUsuari =:nomUsuari");
        query.setParameter("nomUsuari", nomUsuari);   

        Usuari usuari = (Usuari) query.list().get(0);
        session.delete(usuari);

        tx.commit();
        session.close();
    }
    
    public Gravacio getFirstGravacio(int idPacient, int numSessio){
        Session session = con.getSession();
        
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        Sessio sessio = (Sessio) list.get(0);
        
        query = session.createQuery("from Gravacio where idSessio =:idSessio");
        query.setParameter("idSessio", sessio.getIdSessio());
         Gravacio gravacio;
        if(query.list().size()<=0){
            gravacio = null;
        }
        else{
            gravacio = (Gravacio)query.list().get(0);
        }
        
        session.close();
        return gravacio;
    }
 public boolean checkGravacio(int idPacient, int numSessio, String nomGravacio){
        Session session = con.getSession();
        PacientDatabase pacient = (PacientDatabase) session.get(PacientDatabase.class, idPacient);
        Query query = session.createQuery("from Sessio where idPacient =:idPacient AND numSessio =:numSessio");
        query.setParameter("idPacient", idPacient);
        query.setParameter("numSessio", numSessio);
        
        List list = query.list();
        Sessio sessio = (Sessio) list.get(0);
        
        query = session.createQuery("from Gravacio where nom =:nomGravacio AND idSessio =:idSessio");
        query.setParameter("idSessio", sessio.getIdSessio());
        query.setParameter("nomGravacio", nomGravacio);
        System.out.println(sessio.getIdSessio());
        System.out.println(nomGravacio);
        if(query.list().size()<=0){
            session.close();
           return false;
        }
        else{
            session.close();
            return true;
        }      
 }
 
    public Usuari getPacientsFromUsuari(String nomUsuari){
        Session session = con.getSession();
        Query query = session.createQuery("from Usuari where nomUsuari =:nomUsuari");
        query.setParameter("nomUsuari", nomUsuari);
        Usuari usuari = (Usuari) query.list().get(0);
        session.close();
        return usuari;
    }
    
    
    public List getPatients(String nomUsuari){
    
        Session session = con.getSession();
        Query query = session.createQuery("from Usuari where nomUsuari =:nomUsuari");
        query.setParameter("nomUsuari", nomUsuari);
        Usuari usuari = (Usuari) query.list().get(0);
        
        System.out.println(usuari.getPacients().size());
        List list = query.list();
        list.clear();;
        list.addAll(usuari.getPacients());
        
        /*query = session.createQuery("from Pacient where idUsuari =:idUsuari");
        query.setParameter("idUsuari", usuari.getId());
        List pacients = query.list();*/
        session.close();
        return list;
        
    }
}
