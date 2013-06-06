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
public class Circuitos implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Circuito> circuitos;      // Estrutura de Circuitos
    private int atual;                 // Circuito Atual

    
  // Construtor de Classe
  public Circuitos()  
    {  circuitos  = new ArrayList<Circuito>(); 
       atual = 0;
    }  

    public int getAtual()
    {   return atual; }

    public void setAtual(int atual)
    {   this.atual = atual; }
    
  /**
   * Método que adiciona um veiculo a circuitos
   * @param v veiculo a adicionar
   */
  public void addCircuito(Circuito c) 
    {   circuitos.add(c);  }
  
  /**
   * Método que verifica se um veiculo pertense a circuitos
   * @param v veiculo a verificar
   * @return veiculo se encontrado
   */
  public boolean contemCircuito(Circuito c)
    {   return circuitos.contains(c); }
  
  
  public Circuito getCircuitoAtual()
  { Circuito c=null;
  
    if ((circuitos.size() > 0) && (circuitos.size() >= atual))
    { c = circuitos.get(atual);}
    
    return c;
  }
  
  public int numeroCircuitos(){
      return circuitos.size();
  }
  
  public Circuito getNextCircuito()
  { Circuito c=null;
  
    if ((circuitos.size() > 0) && (circuitos.size() >= (atual+1)))
    { c = circuitos.get(atual+1); }
    
    return c;
  }
  
  public String toString () {
      StringBuilder s = new StringBuilder();
      
      for (Circuito c : circuitos){
          s.append(c.toString());
      }
      return s.toString();
  }
  
  
  /**
   * Método que prepara os veiculos para a proxima corrida
   * /
  public void preparaCorrida()
  {  for (Circuito cir: circuitos)
     {     
     }
   }  
  
  */
  
  
  
  
  
  
  
  
  
  
  
  /**
   * Método que cria um array de objectos com os campos de um veiculo
   * @return array de objectos
   * /
  public Object[] campos()
    { Object[] aCampos = {"Modelo","Matricula","Custo Base","Capacidade","Usado","Tipo","Localizacao","Racio de Carga"};
        return aCampos;
    }
  
    
  / **
     * Método que cria um array de objectos com as caracteristicas de um veiculo
     * @return array de objectos
     * /
    public Object[][] toObjects()
    { Object[][] tabela = new Object[circuitos.keySet().size()][8];
      int indice=0;
      
        for (String chave : circuitos.keySet())
        {   Circuitoc circuitos.get(chave);
            tabela[indice][0] =cgetID();
            tabela[indice][1] =cgetMatricula();
            tabela[indice][2] =cgetCusto();
            tabela[indice][3] =cgetCarga();
            tabela[indice][4] =cgetUsado();
            tabela[indice][5] =cgetTipo();
            tabela[indice][6] =cgetLocalizacao();
            tabela[indice][7] =cgetRacio();
            indice ++;
        }
        return tabela;
    } */
  

    /**
     * Método que ordena Circuitos por um critério
     * @param alg String com o critério pelo qual se pretende ordenar
     * @return Iterador do veiculo
     * @throws Exception excepção de critério inexistente
     * /
    public Iterator<Circuito> ordVei(Integer alg) throws Exception
    {
        Comparator<Circuito> cmp = comps.get(alg);
        
        if (cmp == null) throw new Exception("O algoritmo "+alg+"nao existe.");
        TreeSet<Circuito> ordSet = new TreeSet<Circuito>(cmp);
        ordSet.addAll(circuitos);
        
        return ordSet.iterator();
    }    
    */  
    
    
    
  
}