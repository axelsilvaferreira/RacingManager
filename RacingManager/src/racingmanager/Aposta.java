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

   
    
    
    
    
    
    
    
}
