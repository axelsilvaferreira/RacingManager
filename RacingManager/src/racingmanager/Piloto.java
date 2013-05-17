/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;

/**
 * Superclass que representa um Piloto
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class Piloto implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    //Estrutura de dados
    
    private String nome;
    private String nacionalidade;
    private Integer skill;          // Skill (1-100)
    private Integer wSkill;         // skill tempo molhado (1-100)
    private Integer vitorias;
    private String equipa;

    public Piloto(String nome, String nacionalidade, Integer Skill, Integer wSkill, Integer vitorias, String equipa) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.skill = Skill;
        this.wSkill = wSkill;
        this.vitorias = vitorias;
        this.equipa = equipa;
    }
   
       public Piloto() {
        this.nome = "";
        this.nacionalidade = "";
        this.skill = 0;
        this.wSkill = 0;
        this.vitorias = 0;
        this.equipa = "";
    }
       public Piloto (Piloto p) {
        this.nome = p.getNome(); 
        this.nacionalidade = p.getNacionalidade();
        this.skill = p.getSkill();
        this.wSkill = p.getwSkill();
        this.vitorias = p.getVitorias();
        this.equipa = this.getEquipa();
        
       
       }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer Skill) {
        this.skill = Skill;
    }

    public Integer getwSkill() {
        return wSkill;
    }

    public void setwSkill(Integer wSkill) {
        this.wSkill = wSkill;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

 
    
    
    
    
}