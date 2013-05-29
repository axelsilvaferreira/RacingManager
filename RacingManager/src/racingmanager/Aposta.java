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
public class Aposta implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String apostador;       // Nome do apostador
    private String equipa;          // equipa que foi apostada
    private Integer montante;       // montante apostado
    private Corrida corrida;        // Corrida onde foi feita a aposta
    private Integer posicao;        //posicao em que foi feita a aposta
    private double ganhos;         //devolve os ganhos sobre a aposta feita
    
    public Aposta() 
    {   apostador   = "";
        equipa      = "";
        montante    = 0;
        corrida     = null;
    }

    public Aposta(String apostador, String equipa, Integer montante, Corrida corrida, Integer posicao, double ganhos) 
    {   this.apostador = apostador;
        this.equipa = equipa;
        this.posicao = posicao;
        this.montante = montante;
        this.corrida = corrida;
        this.posicao = posicao;
        this.ganhos = ganhos;
    }
    
    public Aposta(Aposta a) 
    {   apostador   = a.getApostador();
        equipa      = a.getEquipa();
        montante    = a.getMontante();
        corrida     = a.getCorrida();
        posicao     = a.getPosicao();
        ganhos      = a.getGanhos();
    }

    public String getApostador()
    {   return apostador; }

    public void setApostador(String apostador)
    {   this.apostador = apostador; }

    public String getEquipa()
    {   return equipa;}

    public void setEquipa(String equipa)
    {   this.equipa = equipa;}

    public Integer getMontante()
    {   return montante;}

    public void setMontante(Integer montante)
    {   this.montante = montante;}

    public Corrida getCorrida()
    {   return corrida;}

    public void setCorrida(Corrida corrida)
    {   this.corrida = corrida;}
    
    public void setPosicao(Integer p)
    {   this.posicao = p;}
    
    public Integer getPosicao()
    {   return posicao;}
    
    public void setGanhos(Integer g){
        this.ganhos = g;
    }
    
    public double getGanhos(){
        return ganhos;
    }
    
    public void calculaGanhos(){
        switch (this.posicao){
            case 1: if(corrida.getPrimeiro().getCarro().contentEquals(this.equipa)){
            this.ganhos = this.montante * 2;}
            case 2: if(corrida.getSegundo().getCarro().contentEquals(this.equipa)){
            this.ganhos = this.montante * 1.5;}
            case 3: if(corrida.getTerceiro().getCarro().contentEquals(this.equipa)){
            this.ganhos = this.montante * 1.3;}
        }
        otherwise: this.ganhos = 0;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {   return false; }
        if (getClass() != obj.getClass())
        {   return false; }
        final Aposta other = (Aposta) obj;
        if ((this.apostador == null) ? (other.apostador != null) : !this.apostador.equals(other.apostador))
        {   return false; }
        if ((this.equipa == null) ? (other.equipa != null) : !this.equipa.equals(other.equipa))
        {   return false; }
        if (this.montante != other.montante && (this.montante == null || !this.montante.equals(other.montante)))
        {   return false; }
        if (this.corrida != other.corrida && (this.corrida == null || !this.corrida.equals(other.corrida)))
        {   return false; }
        return true;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append("Nome do Apostador: " + apostador + "\n" );
        s.append("Equipa Apostada: " + equipa + "\n" );
        s.append("Valor Apostado: " + montante + "\n" );
        s.append("Corrida:\n");
        s.append(corrida.toString() + "\n");
        s.append("Posição Apostada: " + posicao + "\n" );
        s.append("Ganhos: " + ganhos + "\n" );
        
        return s.toString();
    }
  
}
