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
    
    public String execCorrida(){
        StringBuilder rank = new StringBuilder();
        StringBuilder str = new StringBuilder();
        Collection c = this.participante.getFrota().values();
        Iterator<Veiculo> itr = c.iterator();
        Veiculo v = itr.next();
        Integer i1 = v.tempoProximaVolta(this);
            TreeMap<Integer ,Veiculo> p;
            p = new TreeMap<Integer,Veiculo>();
            this.setVoltaActual(this.circuito.getnVoltas());
        while(this.getVoltaActual()>0){
        while(itr.hasNext()){
          if(i1 != Integer.MAX_VALUE){
       v.settTotal(v.gettTotal() + i1);
         p.put(i1,v);
           int i2 = 0;
            Collection t = p.values();
            Iterator<Veiculo> it = t.iterator();
            Veiculo vi = it.next();
            while(i2<=1 && it.hasNext()){
                str.append(v.getEquipa() + i1.toString() + "\n");
                i2++;
               }
          }
            else{
            v.settTotal(Integer.MAX_VALUE);
                str.append("DNF " + v.getEquipa() + "\n");
         }
                
             
         this.setVoltaActual(this.getVoltaActual()-1);
          }
        Collection n = p.values();
        Iterator<Veiculo> it = n.iterator();
        Veiculo vi = it.next();
        TreeMap<Integer,Veiculo> ranking;
        ranking = new TreeMap<Integer,Veiculo>();
       while(it.hasNext()){
        ranking.put(vi.gettTotal(),vi.clone());
       }
        Collection o = ranking.values();
        Iterator<Veiculo> itr1 = o.iterator();
        Veiculo v1 = itr1.next();
        while(itr1.hasNext()){
            int i3 = 0;
            Piloto ps;
            Record r;
            v1.setPontos(v1.getPontos()+ranking.size()-(i3-1));
            if (v1.getPAtual()) {ps = v1.getPiloto1();} else {ps = v1.getPiloto2();}
            r = new Record(v1.gettTotal(), v1.getEquipa(), ps.getNome());
            switch (i3){
                case 0 : this.setPrimeiro(r);
                case 1 : this.setSegundo(r);
                case 2 : this.setTerceiro(r);
                    i3++;
            }
            rank.append(v1.getEquipa());
            if(v1.gettTotal()!=Integer.MAX_VALUE){System.out.print(v1.gettTotal());}
            else {System.out.print("DNF");}
             }
          }
        return rank.toString();
       }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append("1º Lugar:\n");
        s.append(primeiro.toString() + "\n");
        s.append("2º Lugar:\n");
        s.append(segundo.toString() + "\n");
        s.append("3º Lugar:\n");
        s.append(terceiro.toString() + "\n");
        s.append("Circuito:\n");
        s.append(circuito.toString() + "\n");
        s.append("Participantes:\n");
        s.append(participante.toString() + "\n");
        s.append("Chuva: " + isChuva + "\n");
        s.append("Apostas:\n");
        s.append(apostas.toString() + "\n");
        s.append("Volta Actual: " + voltaActual + "\n");
     
        return s.toString();
    }
 }     

