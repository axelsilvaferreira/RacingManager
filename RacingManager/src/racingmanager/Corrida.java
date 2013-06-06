/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;


import java.util.Random;
import java.util.*;
import java.io.*;

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
    private HistApostas apostas;
    private Integer voltaActual;

    public Corrida(Record primeiro, Record segundo, Record terceiro, Circuito circuito, Participantes participante){
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.terceiro = terceiro;
        this.circuito = circuito;
        this.participante = participante;
        
    }
    
    public Corrida() {
        this.primeiro = new Record();
        this.segundo = new Record();
        this.terceiro = new Record();
        this.circuito = new Circuito();
        this.apostas = new HistApostas();
        this.participante = new Participantes();
        
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

    public Integer getVoltaActual() {
        return voltaActual;
    }

    public void setVoltaActual(Integer voltaActual) {
        this.voltaActual = voltaActual;
    }

    public void setAposta(Aposta aposta) {
        this.apostas.addAposta(aposta);
    }
    
    public String execCorrida(){
        this.participante.preparaCorrida(this.circuito.getnVoltas());
        StringBuilder rank = new StringBuilder();
        if(this.isChuva){rank.append("Weather : Sol" + "\n");}
        else{rank.append("Tempo : Chuva" + "\n");}
        Collection c = this.participante.getFrota().values();
        this.setVoltaActual(this.circuito.getnVoltas());
        TreeMap<Integer ,Veiculo> p;
        p = new TreeMap<Integer,Veiculo>();
        while(this.getVoltaActual()>0){
           Iterator<Veiculo> itr = c.iterator();
           rank.append("Volta:" + this.getVoltaActual() + "\n");
           int i2 = 0;
        while(itr.hasNext()){
            Veiculo v = itr.next();
            if(v.gettTotal() != Integer.MAX_VALUE){
        Integer i1 = v.tempoProximaVolta(this);
        if(i1 < this.circuito.getRecord().getTime()){
            Piloto p1;
            Record r;
           if (v.getPAtual()) {p1 = v.getPiloto1();} else {p1 = v.getPiloto2();}
            r = new Record(i1, v.getEquipa(), p1.getNome());
        }
          if(i1 != Integer.MAX_VALUE){
            v.settTotal(v.gettTotal() + i1);
            p.put(i1,v);
            while(i2==0){
                rank.append(v.getEquipa() + ":" + i1.toString() + "\n");
                i2++;
                    }
               }
            else{
            v.settTotal(Integer.MAX_VALUE);
                rank.append("DNF " + v.getEquipa() + "\n");
                p.put(Integer.MAX_VALUE, v);
                  }
               }
            }
            this.setVoltaActual(this.getVoltaActual()-1);
          }     
        Collection n = p.values();
        Iterator<Veiculo> it = n.iterator();
        TreeMap<Integer,Veiculo> ranking;
        ranking = new TreeMap<Integer,Veiculo>();
        while(it.hasNext()){
          Veiculo vi = it.next();
        ranking.put(vi.gettTotal(),vi.clone());
       }
        Collection o = ranking.values();
        Iterator<Veiculo> itr1 = o.iterator();
        int i3 = 0;
        rank.append("Ranking" + "\n");
        while(itr1.hasNext()){
            Veiculo v1 = itr1.next();
            Piloto ps;
            Record r;
            if(v1.gettTotal() != Integer.MAX_VALUE){
            if (v1.getPAtual()) {ps = v1.getPiloto1();} else {ps = v1.getPiloto2();}
            r = new Record(v1.gettTotal(), v1.getEquipa(), ps.getNome());
            switch (i3){
                case 0 : this.setPrimeiro(r);
                case 1 : this.setSegundo(r);
                case 2 : this.setTerceiro(r);
               }
            }
            if(v1.gettTotal()!=Integer.MAX_VALUE){rank.append(v1.getEquipa() + ":" + v1.gettTotal() + "\n");
            v1.setPontos(v1.getPontos()+ranking.size()-(i3-1));}
            else {rank.append("DNF" + ":" + v1.getEquipa() + "\n");}
            i3++;
           }
        return rank.toString();
       }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append("1º Lugar:\n");
        if (primeiro != null) s.append(primeiro.toString() + "\n");
        s.append("2º Lugar:\n");
        if (segundo != null) s.append(segundo.toString() + "\n");
        s.append("3º Lugar:\n");
        if (terceiro != null) s.append(terceiro.toString() + "\n");
        s.append("Circuito:\n");
        s.append(circuito.toString() + "\n");
        s.append("Participantes:\n");
        s.append(participante.toString() + "\n");
        s.append("Chuva: " + isChuva + "\n");
        s.append("Apostas:\n");
        if (apostas != null) s.append(apostas.toString() + "\n");
        s.append("Volta Actual: " + voltaActual + "\n");
     
        return s.toString();
    }
 }     

