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
    private Sessio sessio;
    private String pregunta;
    
    public Resposta(){}
    
    public Resposta(String resposta, String pregunta, Sessio sessio){
        this.resposta = resposta;
        this.pregunta = pregunta;
        this.sessio = sessio;
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

    /**
     * @return the sessio
     */
    public Sessio getSessio() {
        return sessio;
    }

    /**
     * @param sessio the sessio to set
     */
    public void setSessio(Sessio sessio) {
        this.sessio = sessio;
    }
    
}
