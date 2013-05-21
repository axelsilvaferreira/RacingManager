/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;


import java.util.Random;
import java.util.*;
import java.io.*;
import java.io.Serializable;

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

    public Corrida(Record primeiro, Record segundo, Record terceiro, Circuito circuito, Participantes participante){
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.terceiro = terceiro;
        this.circuito = circuito;
        this.participante = participante;
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
    
    public Circuito getCircuito(){
        return circuito;
    }
    
    public void setCircuito(Circuito c){
        this.circuito = c;
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
    
    public void execCorrida(){
        Collection c = this.participante.getFrota().values();
        Iterator<Veiculo> itr = c.iterator();
        Veiculo v = itr.next();
        int i = v.tempoProximaVolta(this);
            TreeMap<Integer ,Veiculo> p;
            p = new TreeMap<Integer,Veiculo>();
        while(this.circuito.getnVoltas()>=0){
        while(itr.hasNext()){
            if(i == -1){
                v.settTotal(-1);
            System.out.print("DNF");}
            else{
            v.settTotal(v.gettTotal() + i);
            p.put(i,v);
            System.out.print(p.firstEntry());
            p.remove(p.firstKey());
            System.out.print(p.firstEntry());
            p.remove(p.firstKey());
            System.out.print(p.firstEntry());
                }
             }
         this.circuito.setnVoltas(this.circuito.getnVoltas()-1);
          }
        participante.adVeiculo(v);
       }
    }     
  
