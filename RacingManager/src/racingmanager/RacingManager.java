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
      CasaApostas casa = new CasaApostas();
      //FileInput.carToString();
      //FileInput.cirToString();
      //FileInput.pilToString();
      casa = FileInput.loadAll();
      
      cir = casa.getChampionship().getPistas().getCircuitoAtual();
      
      cor = new Corrida(null, null, null, cir, casa.getChampionship().getFrota());

      System.out.println(cir.toString());
      cor.execCorrida();
      
      //System.out.println(casa.toString());
      
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
