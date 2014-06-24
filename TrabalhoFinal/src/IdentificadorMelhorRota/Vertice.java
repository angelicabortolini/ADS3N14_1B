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

public class Vertice {
	private int numeroVertice;
    private double latitude;
    private double longitude;

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
    
    public void setNumeroVerice(int numeroVertice) {
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
}
