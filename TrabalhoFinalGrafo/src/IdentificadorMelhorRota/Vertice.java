/**
 * Classe contendo informações do vertice.
 *  
 * @author Angelica B. Bortolini
 * @author Ederson Souza
 * @author Fillipe Welausen
 * @author Misael C. Homem
 *
 */
package IdentificadorMelhorRota;
import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice>{
	private int numeroVertice;
    private double latitude;
    private double longitude;
    private double distancia;
	private boolean visitado = false;
    private Vertice pai;
    private List<Aresta> arestas = new ArrayList<Aresta>();
    private List<Vertice> vizinhos = new ArrayList<Vertice>();
    
    /**
     * Construtor padrão
     */
    public Vertice() {}
    
    /**
     * Construtor sobrecarregado
     * 
     * @param numeroVertice O número de vertices
     * @param latitude A latitide
     * @param longitude A longitude
     */
    public Vertice(int numeroVertice, double latitude, double longitude) {
        
        this.numeroVertice = numeroVertice;
        this.latitude      = latitude;
        this.longitude     = longitude;
        
    }
    
    public int getNumeroVertice() {
        return numeroVertice;
    }
    
    public void setNumeroVertice(int numeroVertice) {
        this.numeroVertice = numeroVertice;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPai(Vertice pai){
        
        this.pai = pai;
	}
	
	public Vertice getPai(){
	       
	        return this.pai;
	}
	
	public double getDistancia() {
		return distancia;
	}
	
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
		
	public void setVizinhos(List<Vertice> vizinhos) {
	       
	        this.vizinhos.addAll(vizinhos);
	                       
	}
	
	public void visitar() {

		this.visitado = true;
	}

	public boolean verificarVisita() {

		return visitado;
	}
	
	public List<Vertice> getVizinhos(){
	       
	        return this.vizinhos;
	}
	
	public void setArestas(List <Aresta> arestas){
	       
	        this.arestas.addAll(arestas);
	       
	}
	
	public List<Aresta> getArestas() {
	       
	        return arestas;
	}

	public int compareTo(Vertice vertice) {
		if (this.getDistancia() < vertice.getDistancia())
			return -1;
		else if (this.getDistancia() == vertice.getDistancia())
			return 0;

		return 1;

	}
	
	@Override		
	public boolean equals(Object obj) {
		if (obj instanceof Vertice) {
			Vertice vRef = (Vertice) obj;
			if (this.getNumeroVertice() == vRef.getNumeroVertice())
				return true;
		}
		return false;
	}
	
	
   
}
