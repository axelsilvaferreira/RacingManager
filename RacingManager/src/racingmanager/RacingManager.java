/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.util.ArrayList;

/**
 *
 * @author axelferreira
 */
public class RacingManager {
    private static Circuito cir;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
      // TODO code application logic here 
      Campeonato c = new Campeonato();
      Circuito cir;
      Corrida cor;
      //FileInput.carToString();
      //FileInput.cirToString();
      //FileInput.pilToString();
      c = FileInput.loadAll();
      
      cir = c.getPistas().getCircuitoAtual();
      
      cor = new Corrida(null, null, null, cir, c.getFrota());

      cor.execCorrida();
      
      System.out.println(c.toString());
      
      //Record rec = new Record();
      //Veiculo carro = new GT();
      
      /*
      int i = monaco.getnVoltas();
      
      
      for(;i>0;i++)
      { i = carro.tempoProximaVolta(monaco.gettMedio(), monaco.gettWett(), )
          
      }
        
     */   
        
        
    }
}
