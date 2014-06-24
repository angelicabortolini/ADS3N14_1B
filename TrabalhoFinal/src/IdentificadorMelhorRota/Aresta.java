/**
 * Classe contendo os dados de informa��o da aresta.
 *  
 * @author Angelica B. Bortolini
 * @author Ederson Souza
 * @author Fillipe Welausen
 * @author Misael C. Homem
 *
 */
package IdentificadorMelhorRota;

public class Aresta {
	private int verticeA;
    private int verticeB;
    private double custo;

    /**
     * Construtor padr�o
     */
    public Aresta() {}
    
    /**
     * Construtor sobrecarregado
     * 
     * @param verticeA
     * @param verticeB
     * @param custo
     */
    public Aresta(int verticeA, int verticeB, double custo) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.custo = custo;
    }
    
    public int getVerticeA() {
        return verticeA;
    }
    
    public void setVerticeA(int verticeA) {
        this.verticeA = verticeA;
    }
    
    public int getVerticeB() {
        return verticeB;
    }
    
    public void setVerticeB(int verticeB) {
        this.verticeB = verticeB;
    }
    
    public double getCusto() {
        return custo;
    }
    
    public void setCusrto(double custo) {
        this.custo = custo;
    }
}
