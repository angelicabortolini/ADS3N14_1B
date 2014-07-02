/**
 * Classe principal.
 *  
 * @author Angelica B. Bortolini
 * @author Ederson Souza
 * @author Fillipe Welausen
 * @author Misael C. Homem
 *
 */

package IdentificadorMelhorRota;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		//new FrmGrafo();
		
		Grafo grafo = new Grafo();
		//teste.buscaMenorCaminho(teste, 1, 10);
		
		grafo.setVertices(grafo.gravaListas());
	    Vertice i1 = new Vertice();
		Vertice i2 = new Vertice();
		i1 = grafo.encontrarVertice(1);
		i2 = grafo.encontrarVertice(40);

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
		
		//Grafo viagem = new Grafo();
		//viagem.gravaListas();
		//DecimalFormat df = new DecimalFormat("#,###.00");
		//System.out.println(df.format(viagem.calcularDinstanciaGeodesica(390.1466, 556.8571, 595.2804, 226.5575)));
	    
	}

}
