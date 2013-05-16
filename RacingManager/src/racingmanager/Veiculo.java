/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;

/**
 * Superclass abstrata que representa um Veiculo
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public abstract class Veiculo implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
        // Estrutura de dados
        private String equipa;       // Equipa
        private String marca;        // Marca
        private String modelo;       // Modelo
        private Piloto piloto1;      // Primeiro Piloto
        private Piloto piloto2;      // Seguno Piloto 
        private boolean pAtual;      // Piloto atual
        private int hibrido;         // Potencia do motor hibrido ou 0 se não tiver
        private int cc;              // Cilindrada
        private int cv;              // Potencia
        private int tTotal;          // Tempo acomulado da corrida
   

    /**
     * Construtor Default de objectos da categoria Veiculo
     */
    public Veiculo() 
    {   // initialização das variáveis de instância
        this.equipa      = "";
        this.marca       = "";
        this.modelo      = "";
        this.piloto1     = null;
        this.piloto2     = null;
        this.pAtual      = true;
        this.hibrido     = 0;
        this.cc          = 0;
        this.cv          = 0;
        this.tTotal      = 0;
        
    }
    
    /**
     * Construtor da categoria Veiculo com argumentos
     */
    public Veiculo(String equipa, String marca, String modelo, Piloto p1, Piloto p2, boolean pAtual, Integer h, int cc, int cv) 
    {   // initialização das variáveis de instância
        this.equipa      = equipa;
        this.marca       = marca;
        this.modelo      = modelo;
        this.piloto1     = p1;
        this.piloto2     = p2;
        this.pAtual      = pAtual;
        this.hibrido     = h;
        this.cc          = cc;
        this.cv          = cv;
        this.tTotal      = 0;
    }
    
    /**
     * Construtor da categoria Veiculo apartir de um veiculo
     */
    public Veiculo(Veiculo v) 
    {   // initialização das variáveis de instância
        this.equipa      = v.getEquipa();
        this.marca       = v.getMarca();
        this.modelo      = v.getModelo();
        this.piloto1     = v.getPiloto2();
        this.piloto2     = v.getPiloto1();
        this.pAtual      = v.getpAtual();
        this.hibrido     = v.getHibrido();
        this.cc          = v.getCC();
        this.cv          = v.getCV();
        this.tTotal      = v.gettTotal();
                
    }

    public String getEquipa() 
    {   return equipa;  }

    public void setEquipa(String equipa) 
    {   this.equipa = equipa;  }
    
    public String getMarca() 
    {   return marca;  }

    public void setMarca(String marca) 
    {   this.marca = marca;  }

    public String getModelo() 
    {   return modelo;   }

    public void setModelo(String modelo) 
    {   this.modelo = modelo;  }
    
    /** Metodo que devolve o piloto
     * @param i numero do piloto 1 / 2.
     * @return O Nome do Piloto correspondente ao indice.
     */
    public Piloto getPiloto1() 
    { return this.piloto1; }
    
    public void setPiloto1(Piloto p)
    {   this.piloto1 = p;   }
    
    /* Metodo que devolve o array de pilotos
     * @return p O array de pilotos.
     */
    public Piloto getPiloto2() 
    { return this.piloto2; }
    
    public void setPiloto2(Piloto p)
    {   this.piloto2 = p;   }
    
    public boolean getPAtual() 
    { return this.pAtual; }
    
    public void setPAtual(boolean pa)
    {   this.pAtual = pa;   }
    
    public Integer getHibrido()
    {   return this.hibrido; }

    public void setHibrido(Integer hibrido) 
    {   this.hibrido = hibrido;   }

    public int getCC() 
    { return this.cc; }
    
    public void setCC(int cc)
    {   this.cc = cc;   }
    
    public int getCV() 
    { return this.cv; }
    
    public void setCV(int cv)
    {   this.cv = cv;   }
    
    public int gettTotal() 
    { return this.tTotal; }
    
    public void settTotal(int t)
    {   this.tTotal = t;   }
    
    /**
     * Metodo abstrato que calcula o tempo da proxima volta para um veiculo.
     * Este método tem que ser implementado nas subclasses de cada categoria de veiculo.
     * @return tempo em segundos da proxima volta
     */
    public abstract int tempoProximaVolta(Corrida c);
    
    
    
    @Override
    public abstract String toString();
    /*{ StringBuilder s = new StringBuilder;
        s.append(Veiculo);
        s.append(this.getMarca());
        s.append("\n");
        return s.toString();
    }*/
    
    /**
     * Metodo que compara o veiculo com outro.
     * @return Verdeiro ou Falso.
     */
    public abstract boolean equals(Object o);
    
    
    
    
    
    
    
    
    
    
    
}
