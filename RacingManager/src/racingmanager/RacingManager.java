/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

/**
 *
 * @author axelferreira
 */
public class RacingManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       // TODO code application logic here                 
      Record rec = new Record();
      Veiculo carro = new GT();
      Circuito monaco = new Circuito("Monaco",50,118,15,10,20);
      
      
      
      int i = monaco.getnVoltas();
      
      
      for(;i>0;i++)
      { i = carro.tempoProximaVolta(monaco.gettMedio(), monaco.gettWett(), )
          
      }
        
        
        
        
    }
}
