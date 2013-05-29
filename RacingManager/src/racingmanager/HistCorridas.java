/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author axelferreira
 */
public class HistCorridas implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Corrida> corridas;      // Estrutura de Circuitos
    private Corrida atual;                    // Circuito Atual

    
  // Construtor de Classe
  public HistCorridas()  
    {  corridas  = new ArrayList<Corrida>(); 
       atual = null;
    }  
    
  // Construtor de Classe
  public HistCorridas(Corrida c)  
    {  corridas  = new ArrayList<Corrida>(); 
       atual = c;
    }  
  
  public void addCorrida(Corrida c) 
    {   corridas.add(atual);  
        atual = c;
    }
  
  public Corrida getCorridaAtual()
  { return this.atual;
  }
  
  public boolean contemCorrida(Corrida c)
    {   return corridas.contains(c); }
 
    @Override
  public String toString(){
      StringBuilder s = new StringBuilder();
      
      s.append("Historico de Corridas:\n");
      for (Corrida corrida: corridas){
          s.append(corrida.toString() + "\n");
      }
      s.append("Corrida Actual:\n");
      s.append(atual.toString() + "\n");
      
      return s.toString();
  }
    
}
