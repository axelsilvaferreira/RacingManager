/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/**
 *
 * @author joaorua
 */
public class FileInput {
    public static ArrayList<String> carInput (){
        ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("carros.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) linhas.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return linhas;
    }
    
    public static ArrayList<String> cirInput (){
        ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("circuitos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) linhas.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return linhas;
    }
    
    public static ArrayList<String> pilInput (){
        ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("pilotos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) linhas.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return linhas;
    }

    public static void carToString () {
        ArrayList<String> carros = carInput();
        Frota f = new Frota();
        Integer pAtual,hibrido,cc,cv,tTotal;
        
        Veiculo v = new Veiculo();
        int index = 0;
        
        while (index < carros.size()) {
        String linha = carros.get(index);
        
        String[] campos = linha.split(",");
        
        StringBuilder output = new StringBuilder();
        
        output.append("|Carro| Index nº" + index + "\n\n");
        for (int i=0; i < campos.length; i++) {
            output.append("Campo " + i + ": " + campos[i] + "\n");
        }
        // Adicionar a Frota
        v.setEquipa(campos[0]);
        v.setMarca(campos[1]);
        v.setModelo(campos[2]);
        pAtual = Integer.parseInt(campos[6]);
        v.setPAtual(pAtual);
        
        f.adVeiculo(v);
        
        System.out.println(output);
        output = null;
        index++;
        }
    }
    
    public static void cirToString () {
        ArrayList<String> circuitos = cirInput();
        int index = 0;
        
        while (index < circuitos.size()) {
        String linha = circuitos.get(index);
        
        String[] campos = linha.split(",");
        
        StringBuilder output = new StringBuilder();
        
        output.append("|Circuito| Index nº" + index + "\n\n");
        for (int i=0; i < campos.length; i++) {
            output.append("Campo " + i + ": " + campos[i] + "\n");
        }
        System.out.println(output);
        output = null;
        index++;
        }
    }
    
    public static void pilToString () {
        ArrayList<String> pilotos = pilInput();
        int index = 0;
        
        while (index < pilotos.size()) {
        String linha = pilotos.get(index);
        
        String[] campos = linha.split(",");
        
        StringBuilder output = new StringBuilder();
        
        output.append("|Piloto| Index nº" + index + "\n\n");
        for (int i=0; i < campos.length; i++) {
            output.append("Campo " + i + ": " + campos[i] + "\n");
        }
        System.out.println(output);
        output = null;
        index++;
        }
    }
}
