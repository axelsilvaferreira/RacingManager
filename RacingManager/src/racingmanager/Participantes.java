/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.*;

/**
 * Classe que contem os participantes
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class Participantes implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    //Estrutura de Dados
    
    private TreeMap<Integer,Veiculo> participantes;
    
    
   public void insertVeiculo(Veiculo v){
       participantes.put(v.gettTotal(),v);
   }
   
   public void removeVeiculo(Integer t){
       participantes.remove(t);
    }
 
   public 
   
   
   
   
   
   }