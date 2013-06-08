/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.*;
import java.lang.String;

/**
 *
 * @author C0ldn3ss
 */
public class Ranking implements Serializable{
    private static final long serialVersionUID = 1L;
    
     // Variáveis de Instâmcia
    private TreeMap<Integer, Veiculo> ranking;
    
    //Construtores de classe
    public Ranking()
    {  ranking = new TreeMap<Integer,Veiculo>(); }
    
    //Metodo que adiciona veiculos ao ranking
    
    public void addVeiculo(Veiculo v)
    {  ranking.put(v.getPontos(),v);}

    public TreeMap<Integer, Veiculo> getRanking() {
        return ranking;
    }

    public void setRanking(TreeMap<Integer, Veiculo> ranking) {
        this.ranking = ranking;
    }
    
    public void clearRanking(){
        this.clearRanking();
    }
    
    public String toString(Veiculo v){
        StringBuilder s = new StringBuilder();
        s.append(v.getEquipa() + v.getPontos() + "\n");
        return s.toString();
    }
    
    public String printRank(){
        StringBuilder r = new StringBuilder();
        Collection o = this.getRanking().values();
        Iterator <Veiculo> itr = o.iterator();
        while(itr.hasNext()){
        Veiculo v = itr.next();
        this.toString(v);
       }
     return r.toString();
   }
}
