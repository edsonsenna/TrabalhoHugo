/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhohugo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Edson
 */
public class AlgoritmoGenerico {
    private int matriz[][];
    public AlgoritmoGenerico(){
        Scanner ler = new Scanner(System.in);
        try {
          FileReader fr = new FileReader("Grafo.dat");
          BufferedReader br = new BufferedReader(fr);
          String linha = br.readLine();
          this.matriz = new int[Integer.parseInt(linha)][Integer.parseInt(linha)];
           System.out.printf(Integer.parseInt(linha)+"\n");
          while ((linha = br.readLine()) != null) {
            System.out.printf(linha+"\n");    
            String filtro[] = linha.split(" ");
            matriz[Integer.parseInt(filtro[0])][Integer.parseInt(filtro[1])] = Integer.parseInt(filtro[2]);
            matriz[Integer.parseInt(filtro[1])][Integer.parseInt(filtro[0])] = Integer.parseInt(filtro[2]);
          }
          fr.close();
          for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
          }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage());
        }
    }
}
