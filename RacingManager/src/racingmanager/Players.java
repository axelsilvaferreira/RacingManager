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
public class Players implements Serializable
{
      private static final long serialVersionUID = 1L;

      private TreeMap<String, Jogador> jogadores;
    

    
  // Construtor de Classe
  public Players()  
    {   jogadores = new TreeMap<String, Jogador>();  }  
    
  /**
   * Método que adiciona um veiculo a jogadores
   * @param v veiculo a adicionar
   */
  public void addPlayer(Jogador v) 
    {   jogadores.put(v.getNome(), v);  }
  
  /**
   * Método que verifica se o veiculo com uma dada matricula esta na jogadores
   * @param mat matricula usada para verificar
   * @return true se pertencer ou false se nao
   */
  public boolean contemIndice(Integer vit)
    {   return jogadores.containsKey(vit);  }
  
  /**
   * Método que verifica se um veiculo pertense a jogadores
   * @param v veiculo a verificar
   * @return veiculo se encontrado
   */
  public boolean contemJogador(Jogador v)
    {   return jogadores.containsKey(v.getNome());   }
  
    /**
     * Método que remove um veiculo da jogadores
     * @param mat matricula do veiculo a remover
     */
  public void remJogador(Jogador j)
  {
      jogadores.remove(j.getNome());
  }
      
      
      
      
      
      
      
      
      
      
      
}
