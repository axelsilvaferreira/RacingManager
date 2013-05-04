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
public class Veiculo implements Serializable
{
 
    
         // Estrutura de dados
        private String id;   // Marca / Modelo
        private String matricula;// Matricula
        private int totalTransportado; // Carga total Transportada
        private float custo; // Custo por Kilometro
        private int carga; // Capacidade de carga em Kg
        private int usado; // Capacidade de carga utilizada
        private String tipo; // Camião, Furgão ou Van
        private boolean localizacao; // Sim se estiver presente | Não se se encontrar ausente
        private static float racio = (3/5);
    
    
    
    
    
    
    
    
}
