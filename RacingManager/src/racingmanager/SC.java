/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.Random;

/**
 * Classe que repsresenta um veiculo do tipo SC
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class SC extends Veiculo implements Serializable 
{   // Versão de serialização
    private static final long serialVersionUID = 1L;

    private static final int  tClassVolta = 40; // Tempo em seg do desvio da classe ao tempo medio.
    
    private static float fiabilidade;

    
    
    public SC() 
    { super();
      this.fiabilidade = 0;
    }

    public SC(String equipa, String marca, String modelo, Piloto p1, Piloto p2, boolean pAtual, Integer h, int cv, double f)
    {   super(equipa, marca, modelo, p1, p2, pAtual, h, 2500, cv, f); }

    
    public SC(Veiculo v) 
    {   super(v); 
        this.setCC(2500);
    }

    
    
     @Override
    public void geraFiabilidade(int nVoltas)
    { Random ran = new Random();
      double media = 75.0f; 
      double variancia = 15.0f;
      
      double r = getGaussian(media, variancia);
      
      setFiabilidade(r);
    }
    
    
    public double getGaussian(double aMean, double aVariance)
    {   Random fRandom = new Random();
        fRandom = new Random();   
        
        return aMean + fRandom.nextGaussian() * aVariance; 
    } 
     
    
    @Override
    public int tempoProximaVolta(Corrida c) 
    {   int t, skill, time;
        double timeD;
        Random ran = new Random();
        double r = showRandomInteger(0, 100, ran);
        double f = this.getFiabilidade();
        Piloto pilot;
        boolean weather = c.getisRain();
        
        
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
        
        // Calcular uma variação aleatoria no tempo medio
        int tRan = showRandomInteger(-10, 10, ran);
        
        timeD = time + tRan - skill;
        
        
        t = (int) timeD;
        
        return t;
    }
     
     
    
    public Veiculo clone()
    { Veiculo v = new SC(this);
        
        return v;
    }

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

    @Override
    public boolean equals(Object o) 
    {      boolean bool=false;

        if (o instanceof SC)
            { SC c = (SC) o;
                
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