/**
 * Classe contendo métodos para calculos específicos.
 *  
 * @author Angelica B. Bortolini
 * @author Ederson Souza
 * @author Fillipe Welausen
 * @author Misael C. Homem
 *
 */
package IdentificadorMelhorRota;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Viagem {
	private List<Aresta> arestas;
    private List<Vertice> vertices;
    private Arquivo arquivo ;
    private String tipoDado = "";
    public final double R = 6372.8; // em quilometros
    
    public Viagem() throws FileNotFoundException {
    
        arestas  = new ArrayList<Aresta>();
        vertices = new ArrayList<Vertice>();
        arquivo  = new Arquivo();
        
    }
    
    
    public void gravaListas(){

		try {
			
			String linhaArquivo;
			while( (linhaArquivo = arquivo.consultar())!= null) {
				
				String[] valores = linhaArquivo.split("\\ ");
				
				if (valores[0].equalsIgnoreCase("vertices") && !valores[0].equalsIgnoreCase("arestas") ) {
					this.tipoDado = "vertice";
				}else if (!valores[0].equalsIgnoreCase("vertices") && valores[0].equalsIgnoreCase("arestas") ) {
					this.tipoDado = "aresta";
				}	
				
				if(this.tipoDado == "vertice" && !valores[0].equalsIgnoreCase("vertices") && !valores[0].equalsIgnoreCase("arestas")){
					
					int valor0 = Integer.parseInt(valores[0]);
					double valor1 = Double.parseDouble(valores[1]);
					double valor2 = Double.parseDouble(valores[2]);					
					gravaListaVertice(valor0,valor1,valor2);
	
				}else if(this.tipoDado == "aresta" && !valores[0].equalsIgnoreCase("vertices") && !valores[0].equalsIgnoreCase("arestas")) {
					
					
					int valor0 = Integer.parseInt(valores[0]);
					int valor1 = Integer.parseInt(valores[1]);
					double valor2 = Double.parseDouble(valores[2]);
					gravaListaAresta(valor0,valor1,valor2);
				}
			} 
		}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    /**
     * 
     * @param verticeA
     * @param verticeB
     * @param custo
     */
    private void gravaListaAresta(int verticeA, int verticeB, double custo) {
    
        arestas.add(new Aresta(verticeA, verticeB, custo));
        System.out.println("Aresta: " + verticeA + " " + verticeB + " " + custo);
    
    }
    
    /**
     * Grava a lista do tipo vértice
     * 
     * @param numeroVertice
     * @param latitude
     * @param longitude
     */
    private void gravaListaVertice(int numeroVertice, double latitude, double longitude) {
    
        vertices.add(new Vertice(numeroVertice, latitude, longitude));
        System.out.println("vertices: " + numeroVertice + " " + latitude + " " + longitude );
    
    }
       
    /**
     *    Calcula a dinstância entre dois pontos a partir de suas latitudes e longitudes.
     */
    public double calcularDinstanciaGeodesica(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
    
    /**
     *    Calcula o custo da rota considerando:<br>
     *    - distância geodésica;<br> 
     *    - custo da aresta;<br>
     *    - Consumo de Combustível: 15 Km/l;<br>
     *    - Autonomia do veículo: 600 Km;<br>
     *    - Velocidade média de viagem: 80Km/h;<br>
     *    - Tempo máximo de direção sem paradas: 3h;
     */
    public void calculaCustoRota() {}
    
    /**
     * Método
     */
    public void dijkstra() {}
}
