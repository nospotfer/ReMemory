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
public class Resposta {
    private int idResposta;
    private String resposta;
    private PacientDatabase pacient;
    private String pregunta;
    
    public Resposta(){}
    
    public Resposta(String resposta, String pregunta, PacientDatabase pacient){
        this.resposta = resposta;
        this.pregunta = pregunta;
        this.pacient = pacient;
    }

    /**
     * @return the idResposta
     */
    public int getIdResposta() {
        return idResposta;
    }

    /**
     * @param idResposta the idResposta to set
     */
    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the pacient
     */
    public PacientDatabase getPacient() {
        return pacient;
    }

    /**
     * @param pacient the pacient to set
     */
    public void setPacient(PacientDatabase pacient) {
        this.pacient = pacient;
    }

    /**
     * @return the pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
}
