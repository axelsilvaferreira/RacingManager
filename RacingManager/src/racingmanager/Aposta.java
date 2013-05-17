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
public class Aposta 
{
    private static final long serialVersionUID = 1L;

    private String apostador;       // Nome do apostador
    private String equipa;          // equipa que foi apostada
    private Integer montante;       // montante apostado
    private Corrida corrida;        // Corrida onde foi feita a aposta

    public Aposta() 
    {   apostador   = "";
        equipa      = "";
        montante    = 0;
        corrida     = null;
    }

    public Aposta(String apostador, String equipa, Integer montante, Corrida corrida) 
    {   this.apostador = apostador;
        this.equipa = equipa;
        this.montante = montante;
        this.corrida = corrida;
    }
    
    public Aposta(Aposta a) 
    {   apostador   = a.getApostador();
        equipa      = a.getEquipa();
        montante    = a.getMontante();
        corrida     = a.getCorrida();
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

   
    
    
    
    
    
    
    
}
