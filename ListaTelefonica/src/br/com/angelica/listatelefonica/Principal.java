package br.com.angelica.listatelefonica;

import br.com.angelica.listatelefonica.controller.ControllerPrograma;
import br.com.angelica.listatelefonica.model.ListaEncadeada;
import br.com.angelica.listatelefonica.model.Nodo;

/**
 * Classe contendo o método principal para execução do programa.
 * @author Angelica Bortolini
 */
public class Principal {
	
	/**
	 * Método principal da aplicação.
	 * @param args argumento de linha de comando.
	 */
	public static void main(String []args) {
		
		new ControllerPrograma().iniciar();
				
	}
	
}
