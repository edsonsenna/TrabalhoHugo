/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhohugo;

/**
 *
 * @author Edson
 */
public class Tree {
    private int vertices[];
    private int matArestas[][];
    private int numArestas;

    public Tree(int numVertices){
        this.vertices = new int[numVertices];
        this.matArestas = new int[numVertices][(((numVertices*numVertices)-numVertices)/2)];
        this.numArestas=0;
        System.out.println("Algoritimo Genérico para MSTs");
    }
    
    public int[] getVertices() {
        return vertices;
    }


    public void setVertices(int[] vertices) {
        this.vertices = vertices;
    }

    public int[][] getMatArestas() {
        return matArestas;
    }

    public int getNumArestas() {
        return numArestas;
    }

    public void setNumArestas(int numArestas) {
        this.numArestas = numArestas;
    }
    
    

    public void setMatArestas(int[][] matArestas) {
        this.matArestas = matArestas;
    }
    
    public boolean visitaVertice(int i){
        if(this.vertices[i]==1) {
            return false;
        }
        else{
            this.vertices[i]=1;
            return true;
        }
    }
    
    public void insereAresta(int i, int j, int peso){
        this.matArestas[i][this.numArestas] = peso;
        this.matArestas[j][this.numArestas] = peso;
        System.out.println("Aresta e"+(this.numArestas+1)+":("+i+", "+j+") com Peso:"+peso);
        this.numArestas++;
    }
    
    public void imprimeMat(){
        for(int i=0;i<this.vertices.length;i++){
            for(int j=0;j<this.numArestas;j++){
                if(this.matArestas[i][j]!=0 && i>j) System.out.println((j+1)+" "+(i+1)+" "+this.matArestas[i][j]);
                
            }
        }
        System.out.println("Teste");
    }
    
    
}
