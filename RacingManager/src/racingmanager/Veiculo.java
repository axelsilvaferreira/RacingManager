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
        private String[] pilotos;    // Estrutura de Pilotos
        private boolean hibrido;     // V - Hibrido / F - Não Hibrido
        //private String categoria;       // Classe do Veiculo
   

    /**
     * Construtor Default de objectos da categoria Veiculo
     */
    public Veiculo() 
    {   // initialização das variáveis de instância
        this.marca       = "";
        this.modelo      = "";
        this.pilotos     = new String[2]; // ****** Sera necessario inicializar?
        this.hibrido     = false;
        this.categoria   = "";
    }
    
    /**
     * Construtor da categoria Veiculo com argumentos
     */
    public Veiculo(String marca, String modelo, String p1, String p2, boolean h, String categoria) 
    {   // initialização das variáveis de instância
        this.marca       = marca;
        this.modelo      = modelo;
        this.pilotos     = new String[2];
        this.pilotos[0]  = p1;
        this.pilotos[1]  = p2;
        this.hibrido     = h;
       // this.categoria   = categoria;
    }
    
    /**
     * Construtor da categoria Veiculo apartir de um veiculo
     */
    public Veiculo(Veiculo v) 
    {   // initialização das variáveis de instância
        this.marca       = v.getMarca();
        this.modelo      = v.getModelo();
        this.pilotos     = new String[2];
        this.pilotos[0]  = v.getPiloto(1);
        this.pilotos[1]  = v.getPiloto(2);
        this.hibrido     = v.getHibrido();
       // this.categoria   = v.getCategoria();
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
    public String getPiloto(int i) 
    { return this.pilotos[i-1]; }
    
    /* Metodo que devolve o array de pilotos
     * @return p O array de pilotos.
     */
    public String[] getPiloto() 
    { /* String[] p = new String[2];
      int i;
      
      for (i=0;i<2;i++)
      { p[i] = this.pilotos[i];}            // ***** VER SE È NECESSARIO
       
      return p;
     */
        return this.pilotos;
    }
    
    public boolean getHibrido()
    {   return this.hibrido; }
    
    public void setPilotos(String[] pilotos) 
    {   this.pilotos = pilotos;   }

    public boolean isHibrido() 
    {   return hibrido;  }

    public void setHibrido(boolean hibrido) 
    {   this.hibrido = hibrido;   }
/*
    public String getCategoria() 
    {   return categoria;  }

    public void setCategoria(String categoria) 
    {   this.categoria = categoria;  }
 */   
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
