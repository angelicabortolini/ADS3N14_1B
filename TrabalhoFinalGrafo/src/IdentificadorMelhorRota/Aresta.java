/**
 * Classe contendo os dados de informação da aresta.
 *  
 * @author Angelica B. Bortolini
 * @author Ederson Souza
 * @author Fillipe Welausen
 * @author Misael C. Homem
 *
 */
package IdentificadorMelhorRota;

public class Aresta {
	private Vertice verticeA;
    private Vertice verticeB;
    private double custo;

    /**
     * Construtor padrão
     */
    public Aresta() {}
    
    /**
     * Construtor sobrecarregado
     * 
     * @param verticeA
     * @param verticeB
     * @param custo
     */
    public Aresta(Vertice verticeA, Vertice verticeB, double custo) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.custo = custo;
    }
    
    public Vertice getVerticeA() {
        return verticeA;
    }
    
    public void setVerticeA(Vertice verticeA) {
        this.verticeA = verticeA;
    }
    
    public Vertice getVerticeB() {
        return verticeB;
    }
    
    public void setVerticeB(Vertice verticeB) {
        this.verticeB = verticeB;
    }
    
    public double getCusto() {
        return custo;
    }
    
    public void setCusto(double custo) {
        this.custo = custo;
    }
}
