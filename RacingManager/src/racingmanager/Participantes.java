package racingmanager;


import java.io.Serializable;
import java.util.*;


/**
 *Conjunto de todos os veiculos que a empresa possuí
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class Participantes implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // Variáveis de Instâmcia
    private TreeMap<Integer, Veiculo> frota;
    

    
  // Construtor de Classe
  public Participantes()  
    {   frota = new TreeMap<Integer, Veiculo>();  }  
    
  /**
   * Método que adiciona um veiculo a frota
   * @param v veiculo a adicionar
   */
  public void adVeiculo(Veiculo v) 
    {   frota.put(v.gettTotal(), v);  }
  
  /**
   * Método que verifica se o veiculo com uma dada matricula esta na frota
   * @param mat matricula usada para verificar
   * @return true se pertencer ou false se nao
   */
  public boolean contemIndice(Integer mat)
    {   return frota.containsKey(mat);  }
  
  /**
   * Método que verifica se um veiculo pertense a frota
   * @param v veiculo a verificar
   * @return veiculo se encontrado
   */
  public boolean contemVeiculo(Veiculo v)
    {   return frota.containsKey(v.getEquipa());   }
  
    /**
     * Método que remove um veiculo da frota
     * @param mat matricula do veiculo a remover
     */
  public void remVeiculo(String equipa)
  {
      frota.remove(equipa);
  }
  
  /**
   * Método que devolve o veiculo com a matricula passada
   * @param mat matricula do veiculo a devolver
   * @return veiculo localizado
   */
  public Veiculo localizaVeiculo(String mat)
  {
      return frota.get(mat);
  }
  
  /**
   * Método que selecciona um veiculo para um dado servico
   * @param s servico a realizar
   * @return v veiculo que realizara o servico
   * /
  public Veiculo escolheVeiculo(Servico s){
    Collection c = frota.values();
    Iterator<Veiculo> itr = c.iterator();
    Veiculo v=null;
    
        while (itr.hasNext() && !(v.podeTransportar(s))) 
            { v = itr.next();            
            }
    
        if ( !(v.podeTransportar(s))) 
             { v = null; }            
            
    return v;
    }  
  */
  /**
   * Método que cria um array de objectos com os campos de um veiculo
   * @return array de objectos
   */
  public Object[] campos()
    { Object[] aCampos = {"Modelo","Matricula","Custo Base","Capacidade","Usado","Tipo","Localizacao","Racio de Carga"};
        return aCampos;
    }
  
    
  /**
     * Método que cria um array de objectos com as caracteristicas de um veiculo
     * @return array de objectos
     * /
    public Object[][] toObjects()
    { Object[][] tabela = new Object[frota.keySet().size()][8];
      int indice=0;
      
        for (String chave : frota.keySet())
        {   Veiculo v = frota.get(chave);
            tabela[indice][0] = v.getID();
            tabela[indice][1] = v.getMatricula();
            tabela[indice][2] = v.getCusto();
            tabela[indice][3] = v.getCarga();
            tabela[indice][4] = v.getUsado();
            tabela[indice][5] = v.getTipo();
            tabela[indice][6] = v.getLocalizacao();
            tabela[indice][7] = v.getRacio();
            indice ++;
        }
        return tabela;
    } */
  

    /**
     * Método que ordena Veiculos por um critério
     * @param alg String com o critério pelo qual se pretende ordenar
     * @return Iterador do veiculo
     * @throws Exception excepção de critério inexistente
     * /
    public Iterator<Veiculo> ordVei(String alg) throws Exception
    {
        Comparator<Veiculo> cmp = comps.get(alg);
        
        if (cmp == null) throw new Exception("O algoritmo "+alg+"nao existe.");
        TreeSet<Veiculo> ordSet = new TreeSet<Veiculo>(cmp);
        ordSet.addAll(frota);
        
        return ordSet.iterator();
    }    
    */  
    
    
    
  
}