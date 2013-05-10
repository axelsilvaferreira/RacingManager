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
        private String marca;        // Marca
        private String modelo;       // Modelo
        private Piloto piloto1;      // Primeiro Piloto
        private Piloto piloto2;      // Seguno Piloto 
        private boolean pAtual;      // Piloto atual
        private boolean hibrido;     // V - Hibrido / F - Não Hibrido
        private int cc;              // Cilindrada
        private int cv;              // Potencia
        
   

    /**
     * Construtor Default de objectos da categoria Veiculo
     */
    public Veiculo() 
    {   // initialização das variáveis de instância
        this.marca       = "";
        this.modelo      = "";
        this.piloto1     = null;
        this.piloto2     = null;
        this.pAtual      = true;
        this.hibrido     = false;
        this.cc          = 0;
        this.cv          = 0;
        
    }
    
    /**
     * Construtor da categoria Veiculo com argumentos
     */
    public Veiculo(String marca, String modelo, Piloto p1, Piloto p2, boolean pAtual,boolean h, int cc, int cv) 
    {   // initialização das variáveis de instância
        this.marca       = marca;
        this.modelo      = modelo;
        this.piloto1     = p1;
        this.piloto2     = p2;
        this.pAtual      = pAtual;
        this.hibrido     = h;
        this.cc          = cc;
        this.cv          = cv;
       
    }
    
    /**
     * Construtor da categoria Veiculo apartir de um veiculo
     */
    public Veiculo(Veiculo v) 
    {   // initialização das variáveis de instância
        this.marca       = v.getMarca();
        this.modelo      = v.getModelo();
        this.piloto1     = v.getPiloto2();
        this.piloto2     = v.getPiloto1();
        this.pAtual      = v.getpAtual();
        this.hibrido     = v.getHibrido();
        this.cc          = v.getCC();
        this.cv          = v.getCV();
                
    }

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
    
    public boolean getpAtual() 
    { return this.pAtual; }
    
    public void setPiloto2(boolean pa)
    {   this.pAtual = pa;   }
    
    public boolean getHibrido()
    {   return this.hibrido; }

    public void setHibrido(boolean hibrido) 
    {   this.hibrido = hibrido;   }

    public int getCC() 
    { return this.cc; }
    
    public void setCC(int cc)
    {   this.cc = p;   }
    
    public int getCV() 
    { return this.cv; }
    
    public void setCV(int cv)
    {   this.cv = p;   }
    
    /**
     * Metodo abstrato que calcula o tempo da proxima volta para um veiculo.
     * Este método tem que ser implementado nas subclasses de cada categoria de veiculo.
     * @return tempo em segundos da proxima volta
     */
    public abstract int tempoProximaVolta();
    
    
    
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
    public abstract boolean equals();
    
    
    
    
    
    
    
    
    
    
    
}
