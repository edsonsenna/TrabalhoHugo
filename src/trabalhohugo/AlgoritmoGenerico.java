/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhohugo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Edson
 */
public class AlgoritmoGenerico {
    private int matriz[][];
    private int numArestas=0;
    private int numVertices;
    public AlgoritmoGenerico(){
        Scanner ler = new Scanner(System.in);
        try {   
          FileReader fr = new FileReader("Grafo.dat");
          BufferedReader br = new BufferedReader(fr);
          String linha = br.readLine();
          this.matriz = new int[Integer.parseInt(linha)][Integer.parseInt(linha)];
          //this.numArestas = (((Integer.parseInt(linha)*Integer.parseInt(linha))-Integer.parseInt(linha))/2);
          this.numVertices = Integer.parseInt(linha);
          Tree t = new Tree(Integer.parseInt(linha));
          //System.out.printf(Integer.parseInt(linha)+"\n");
          while ((linha = br.readLine()) != null) {
            //System.out.printf(linha+"\n");    
            String filtro[] = linha.split(" ");
            matriz[Integer.parseInt(filtro[0])][Integer.parseInt(filtro[1])] = Integer.parseInt(filtro[2]);
            matriz[Integer.parseInt(filtro[1])][Integer.parseInt(filtro[0])] = Integer.parseInt(filtro[2]);
            this.numArestas++;
          }
          fr.close();
          Random ger = new Random();
          int verticeArb = 0;
                  //ger.nextInt(this.numVertices);
          t.visitaVertice(verticeArb);
          int pesoAresta, vertice=0;
          while(t.getNumArestas()<(this.numArestas-1)){
            pesoAresta = 1000;
            for(int i=0;i<numVertices;i++){
                if((verticeArb<=i)&&(i!=verticeArb)&& (matriz[verticeArb][i] < pesoAresta) &&(matriz[verticeArb][i]!=0)){
                     pesoAresta = matriz[verticeArb][i];
                     vertice = i;
                    
                }
            }
            if(t.visitaVertice(vertice)){
                  t.insereAresta(verticeArb, vertice, pesoAresta);
                  verticeArb=vertice;
            }else{
                //System.out.println("Fechou ciclo");
                break;
            }          
          }
          t.imprimeMat();
          /*for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
          }*/
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage());
        }
    }
}
