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
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Grafo {
	private List<Aresta> arestas;
    private List<Vertice> vertices;
    private Arquivo arquivo ;
	private String tipoDado = "";
    private final double R = 6372.8; // em quilometros
    private double valorGasolina;
    private List<Vertice> grafo = new ArrayList<Vertice>();
    
    public Grafo() throws FileNotFoundException {
    
        arestas  = new ArrayList<Aresta>();
        vertices = new ArrayList<Vertice>();
        arquivo  = new Arquivo();
        
    }
    
    public void setValorGasolina(double valorGasolina) {
		this.valorGasolina = valorGasolina;
	}  
    

	public void setVertices(List<Vertice> vertices) {

		this.grafo.addAll(vertices);
	}

	public void adicionarVertice(Vertice novoVertice) {

		this.grafo.add(novoVertice);
	}

	public List<Vertice> getVertices() {

		return this.grafo;
	}
    
    public List<Vertice> gravaListas() throws FileNotFoundException {

		Grafo grafo = new Grafo();
		String linhaArquivo;

		try {
		
			while( (linhaArquivo = arquivo.consultar())!= null) {

				String[] valores = linhaArquivo.split("\\ ");
				
				//verifica se o dado a ser gravado é vertice ou aresta
				if (valores[0].equalsIgnoreCase("vertices") && !valores[0].equalsIgnoreCase("arestas") ) {
					this.tipoDado = "vertice";
				}else if (!valores[0].equalsIgnoreCase("vertices") && valores[0].equalsIgnoreCase("arestas") ) {
					this.tipoDado = "aresta";
				}					
				
				if(this.tipoDado == "vertice" && !valores[0].equalsIgnoreCase("vertices") && !valores[0].equalsIgnoreCase("arestas")){
					//grava vertices
					int valor0 = Integer.parseInt(valores[0]);
					double valor1 = Double.parseDouble(valores[1]);
					double valor2 = Double.parseDouble(valores[2]);					
					gravaListaVertice(valor0,valor1,valor2);
				}else if(this.tipoDado == "aresta" && !valores[0].equalsIgnoreCase("vertices") && !valores[0].equalsIgnoreCase("arestas")){
					//grava arestas				
					Vertice verticeAresta0 = null;
					Vertice verticeAresta1 = null;				
					int valor0 = Integer.parseInt(valores[0]);
					int valor1 = Integer.parseInt(valores[1]);
					double valor2 = Double.parseDouble(valores[2]);
					
					//lê vertices para gravar nas arestas
					for (int i = 0; i < vertices.size(); i++) {
						if (vertices.get(i).getNumeroVertice() == valor0) {
							verticeAresta0 = new Vertice(vertices.get(i).getNumeroVertice(),vertices.get(i).getLatitude(), vertices.get(i).getLongitude());
						}
						
						if(vertices.get(i).getNumeroVertice() == valor1){
							verticeAresta1 = new Vertice(vertices.get(i).getNumeroVertice(),vertices.get(i).getLatitude(), vertices.get(i).getLongitude());
						}						 
					}				
					gravaListaAresta(verticeAresta0,verticeAresta1,valor2);
				}
			}
			
			//atualiza vertices com seus visinhos e arestas
			for (int i = 0; i < vertices.size(); i++) {
				
				List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
				List<Aresta> arestasAtual = new ArrayList<Aresta>();
				
				for (int j = 0; j < arestas.size(); j++) {				
					if (arestas.get(j).getVerticeA().getNumeroVertice() == vertices.get(i).getNumeroVertice()) {	
						
						vizinhosAtual.add(new Vertice(arestas.get(j).getVerticeA().getNumeroVertice(), arestas.get(j).getVerticeA().getLatitude(), arestas.get(j).getVerticeA().getLongitude()));
						arestasAtual.add(new Aresta(arestas.get(j).getVerticeA(),arestas.get(j).getVerticeB(),arestas.get(j).getCusto()));
					
					}else if (arestas.get(j).getVerticeB().getNumeroVertice() == vertices.get(i).getNumeroVertice()) {
						
						vizinhosAtual.add(new Vertice(arestas.get(j).getVerticeB().getNumeroVertice(), arestas.get(j).getVerticeB().getLatitude(), arestas.get(j).getVerticeB().getLongitude()));
						arestasAtual.add(new Aresta(arestas.get(j).getVerticeA(),arestas.get(j).getVerticeB(),arestas.get(j).getCusto()));

					}
				}	
				
				vertices.get(i).setVizinhos(vizinhosAtual);
				vertices.get(i).setArestas(arestasAtual);
				
				grafo.adicionarVertice(vertices.get(i));
			}
		}	
			
		// catch do readLine
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Retornando os vertices
		return grafo.getVertices();
	}
    
    /**
     * 
     * @param verticeA
     * @param verticeB
     * @param custo
     */
    private void gravaListaAresta(Vertice verticeA, Vertice verticeB, double custo) {
    
        arestas.add(new Aresta(verticeA, verticeB, custo));
        //System.out.println("Aresta: " + verticeA.getNumeroVertice() + " " + verticeB.getNumeroVertice() + " " + custo);
    
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
        //System.out.println("vertices: " + numeroVertice + " " + latitude + " " + longitude );
    
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
    public double calculaCustoRota(Vertice verticeA, Vertice verticeB, double custoAresta) {
    	
    	double distancia = calcularDinstanciaGeodesica(verticeA.getLatitude(), verticeA.getLongitude(), verticeB.getLatitude(),verticeB.getLongitude());
    	double tempo;
    	double valorEmReais = 0;
    	double novoCustoAresta = 0;
 
    	if(distancia != 100000000){
	      tempo = distancia / 80;
	
	      if(tempo >= 3){// se o tempo de viagem for maior que 3 horas
	         tempo = tempo / 3;
	         tempo = distancia / 80 + tempo; // adiciona 1 hora de descanço para o motora a cada 3 horas de viagem
	      }
	
	      valorEmReais = distancia * (15 / this.valorGasolina);//

    	}
    	
    	novoCustoAresta = custoAresta + valorEmReais;
    	
    	return novoCustoAresta;
    }

	// Método que retorna o vértice cujo numero é igual à procurada.
	public Vertice encontrarVertice(int numeroVertice) {

		for (int i = 0; i < this.getVertices().size(); i++) {

			if (numeroVertice == this.getVertices().get(i).getNumeroVertice()) {

				return this.getVertices().get(i);

			}
		}
		return null;

	}
    
	public String buscaMenorCaminho(Grafo grafo, int origem, int destino) throws FileNotFoundException{
				
		grafo.setVertices(grafo.gravaListas());
	    Vertice i1 = new Vertice();
		Vertice i2 = new Vertice();
		i1 = grafo.encontrarVertice(origem);
		i2 = grafo.encontrarVertice(destino);

		List<Vertice> resultado = new ArrayList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		
		resultado = algoritmo.encontrarMenorCaminhoDijkstra(grafo, i1,i2);
		boolean primeiro = true;
		String menorCaminho = "[";
		for (int i = 0; i < resultado.size(); i++) {
			if(primeiro){
				menorCaminho += resultado.get(i).getNumeroVertice();
				primeiro = false;
			}else{
				menorCaminho += "," + resultado.get(i).getNumeroVertice();
			}
		}
		
		System.out.println("Esse é o menor caminho feito pelo algoritmo:" + menorCaminho + "]");
		return menorCaminho;
	}
	
}
