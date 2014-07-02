package IdentificadorMelhorRota;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

	// Atributos usados na funcao encontrarMenorCaminho

	// Lista que guarda os vertices pertencentes ao menor caminho encontrado
	List<Vertice> menorCaminho = new ArrayList<Vertice>();

	// Variavel que recebe os vertices pertencentes ao menor caminho
	Vertice verticeCaminho = new Vertice();

	// Variavel que guarda o vertice que esta sendo visitado
	Vertice atual = new Vertice();

	// Variavel que marca o vizinho do vertice atualmente visitado
	Vertice vizinho = new Vertice();

	// Lista dos vertices que ainda nao foram visitados
	List<Vertice> naoVisitados = new ArrayList<Vertice>();

	// Algoritmo de Dijkstra
	public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1,	Vertice v2) throws FileNotFoundException {

		// Adiciona a origem na lista do menor caminho
		menorCaminho.add(v1);

		// Colocando a distancias iniciais
		for (int i = 0; i < grafo.getVertices().size(); i++) {

			// Vertice atual tem distancia zero, e todos os outros,
			// 9999999999("infinita")
			if (grafo.getVertices().get(i).getNumeroVertice() == v1.getNumeroVertice()) {

				grafo.getVertices().get(i).setDistancia(0);

			} else {

				grafo.getVertices().get(i).setDistancia(999999999);

			}
			// Insere o vertice na lista de vertices nao visitados
			this.naoVisitados.add(grafo.getVertices().get(i));
		}

		Collections.sort(naoVisitados);

		// O algoritmo continua ate que todos os vertices sejam visitados
		while (!this.naoVisitados.isEmpty()) {

			// Toma-se sempre o vertice com menor distancia, que eh o primeiro
			// da
			// lista

			atual = this.naoVisitados.get(0);
			System.out.println("Pegou esse vertice:  " + atual.getNumeroVertice());
			/*
			 * Para cada vizinho (cada aresta), calcula-se a sua possivel
			 * distancia, somando a distancia do vertice atual com a da aresta
			 * correspondente. Se essa distancia for menor que a distancia do
			 * vizinho, esta eh atualizada.
			 */
			for (int i = 0; i < atual.getArestas().size(); i++) {

				vizinho = atual.getArestas().get(i).getVerticeB();
				Grafo calculaDistancia = new Grafo();
				vizinho.setDistancia(calculaDistancia.calcularDinstanciaGeodesica(atual.getArestas().get(i).getVerticeA().getLatitude(), atual.getArestas().get(i).getVerticeA().getLongitude(), vizinho.getLatitude(), vizinho.getLongitude()));
				System.out.println("Olhando o vizinho de " + atual.getNumeroVertice() + ": " + vizinho.getNumeroVertice());
				if (!vizinho.verificarVisita()) {

					// Comparando a distância do vizinho com a possível
					// distância
					if (vizinho.getDistancia() > (atual.getDistancia() + atual.getArestas().get(i).getCusto())) {

						vizinho.setDistancia(atual.getDistancia()+ atual.getArestas().get(i).getCusto());
						vizinho.setPai(atual);

						/*
						 * Se o vizinho eh o vertice procurado, e foi feita uma
						 * mudanca na distancia, a lista com o menor caminho
						 * anterior eh apagada, pois existe um caminho menor
						 * vertices pais, ateh o vertice origem.
						 */
						if (vizinho == v2) {
							menorCaminho.clear();
							verticeCaminho = vizinho;
							menorCaminho.add(vizinho);
							while (verticeCaminho.getPai() != null) {

								menorCaminho.add(verticeCaminho.getPai());
								verticeCaminho = verticeCaminho.getPai();

							}
							// Ordena a lista do menor caminho, para que ele
							// seja exibido da origem ao destino.
							Collections.sort(menorCaminho);

						}
					}
				}

			}
			// Marca o vertice atual como visitado e o retira da lista de nao
			// visitados
			atual.visitar();
			this.naoVisitados.remove(atual);
			/*
			 * Ordena a lista, para que o vertice com menor distancia fique na
			 * primeira posicao
			 */

			Collections.sort(naoVisitados);
			boolean primeiro = true;
			String verticesNaoVisitados = "[";
			for (int i = 0; i < naoVisitados.size(); i++) {
				if(primeiro){
					verticesNaoVisitados += naoVisitados.get(i).getNumeroVertice();
					primeiro = false;
				}else{
					verticesNaoVisitados += "," + naoVisitados.get(i).getNumeroVertice();
				}
			}	
			System.out.println("Nao foram visitados ainda:" + verticesNaoVisitados + "]");

		}

		return menorCaminho;
	}

}