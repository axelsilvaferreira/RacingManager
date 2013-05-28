/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.Random;
import java.lang.Math.*;
//import javax.jws.Oneway;

/**
 * Classe que repsresenta um veiculo do tipo PC1
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class PC1 extends Veiculo implements Serializable 
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    private static final int  tClassVolta = 0; // Tempo em seg do desvio da classe ao tempo medio.
    private static final double fiabilidade = 85; // Fiabilidade do carro

    public PC1() 
    {   super(); }

    public PC1(String equipa, String marca, String modelo, Piloto p1, Piloto p2, boolean pAtual, Integer h, int cv, double f) 
    {   super(equipa, marca, modelo, p1, p2, pAtual, h, 6000, cv, f); }

    public PC1(Veiculo v) 
    {   super(v); 
        this.setCC();
    }

    
    
    public void setCC()
    { super.setCC(6000); }
    
    
    public Veiculo clone()
    { Veiculo v = new PC1(this);
      return v;
    }
    
    @Override
    public void geraFiabilidade(int nVoltas)
    { double f = fiabilidade;
      Random ran = new Random();
      double r = showRandomInteger(-7, 7, ran);
      double hib = Double.parseDouble(getHibrido().toString());
      double h = 0;
      
      h = (int) Math.log(hib);
      
        f = (1/(f + r + h));
    
        setFiabilidade(f);
    }
    
    @Override
    public int tempoProximaVolta(Corrida c) 
    {   boolean weather = c.getisRain();
        double timeD, hibr;
        int time, skill;  
        Piloto pilot;
        Random ran = new Random();
        double r = showRandomInteger(0, 100, ran);
        double f = this.getFiabilidade();
        
        // Verifica se completa a volta
        if (f >= r)
        {return Integer.MAX_VALUE;}
        
        // Escolhe o Piloto
        if (this.getPAtual())
        {pilot = this.getPiloto1();}
        else {pilot = this.getPiloto2();}
        
        // Verifica as condições climatéricas e dá a skill correspondente
        if (weather)    
        {skill = pilot.getwSkill();}           // Se chover
        else {skill = pilot.getSkill();}       // Se não chover
        // Calcula a skill para a formula
        timeD = skill;
        skill = (int) Math.log(timeD);
        
        // Tempo médio de uma volta á pista para esta classe para as condições climatéricas atuais
        time = ((c.getCircuito().gettMedio()) + tClassVolta);   
        if (weather) {time *= c.getCircuito().gettWett();}    // Acrescenta o tempo extra da chuva se chover
        
        // Calcula a redução do motor hibrido no tempo
        timeD = this.getHibrido();
        if (timeD > 0)
        { hibr = Math.log(timeD); }
        else { hibr = timeD; }
        
        // Verifica se troca de piloto
        if ((c.getCircuito().getnVoltas() /2) > c.getVoltaActual())
        { this.setPAtual(!getPAtual()); }
        
        //Calcula o tempo da volta
        timeD = time;
        
        time = (int) timeD;
        
        return time;
    }

    /*
    @Override
    public String toString() 
    {   StringBuilder str = new StringBuilder();
    
        str.append(this.getClass().toString());
        str.append(this.getMarca());
        str.append(this.getModelo());
        str.append(this.getPiloto1().toString());
        str.append(this.getPiloto2().toString());
        if (this.getPAtual())
        {str.append(this.getPiloto1().toString());}
        else {str.append(this.getPiloto2().toString());}
        
        return str.toString();
    }
    */
    
    @Override
    public boolean equals(Object o) 
    {      boolean bool=false;

        if (o instanceof PC1)
            { PC1 c = (PC1) o;
                
                if ( //FORMA SIMPLES
                        this.toString().equals(c.toString()) 
                     /* FORMA COMPLEXA
                     super.getMarca().equals(c.getMarca())      &&
                     super.getModelo().equals(c.getModelo()))   &&
                     super.getPiloto1().equals(c.getPiloto1())  &&
                     super.getPiloto2().equals(c.getPiloto2())      
                     */ 
                   )
                 {bool = true;}
            }
        return bool;  
    }
    
    private static int showRandomInteger(int aStart, int aEnd, Random aRandom)
    { if ( aStart > aEnd ) 
      {  throw new IllegalArgumentException("Start cannot exceed End."); }
      //get the range, casting to long to avoid overflow problems
      long range = (long)aEnd - (long)aStart + 1;
      // compute a fraction of the range, 0 <= frac < range
      long fraction = (long)(range * aRandom.nextDouble());
      int randomNumber =  (int)(fraction + aStart);    
      return randomNumber;
    }
    
}
