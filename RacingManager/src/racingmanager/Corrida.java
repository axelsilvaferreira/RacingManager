/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;


import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author axelferreira
 */
public class Corrida implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    //Estrutura de Dados
    
    private Record primeiro;
    private Record segundo;
    private Record terceiro;
    private Circuito circuito;
    private Participantes participante;
    private boolean isChuva;

    public Corrida(Record primeiro, Record segundo, Record terceiro, Circuito circuito, Participantes participant) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.terceiro = terceiro;
        this.circuito = circuito;
        this.participante = participant;
    }
    
    public Corrida() {
        this.primeiro = null;
        this.segundo = null;
        this.terceiro = null;
        this.circuito = null;
        this.participante = null;
    }
    
    public Corrida(Corrida c){
        this.primeiro = c.getPrimeiro();
        this.segundo = c.getSegundo();
        this.terceiro = c.getTerceiro();
    }

    public Record getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Record primeiro) {
        this.primeiro = primeiro;
    }

    public Record getSegundo() {
        return segundo;
    }

    public void setSegundo(Record segundo) {
        this.segundo = segundo;
    }

    public Record getTerceiro() {
        return terceiro;
    }

    public void setTerceiro(Record terceiro) {
        this.terceiro = terceiro;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Participantes getParticipante() {
        return participante;
    }

    public void setParticipante(Participantes participante) {
        this.participante = participante;
    }
    
    public boolean getisRain() {
        return isChuva;
    }
        
    public void setRandomChuva() {
        this.isChuva = new Random().nextInt(this.circuito.getpRain())==0;
    }
       
}
