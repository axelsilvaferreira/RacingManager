/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author axelferreira
 */
public class HistApostas implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Aposta> apostas;      // Estrutura de Circuitos

    
  // Construtor de Classe
  public HistApostas()  
    {  apostas  = new ArrayList<Aposta>(); }  
    
  // Construtor de Classe
  public HistApostas(Aposta c)  
    {  apostas  = new ArrayList<Aposta>(); }  
  
  public void addAposta(Aposta c) 
    {   apostas.add(c); }
  
  public Aposta getApostaAtual(int i)
  { return apostas.get(i); }
  
  public boolean contemAposta(Aposta c)
  {   return apostas.contains(c); }
  
  
  public String toString(){
      StringBuilder s = new StringBuilder();
      
      for (Aposta aposta : apostas){
          s.append(aposta.toString() + "\n");
      }
      
      return s.toString();
  }
}
