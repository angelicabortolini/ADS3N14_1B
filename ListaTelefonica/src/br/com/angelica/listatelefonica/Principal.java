package br.com.angelica.listatelefonica;
import java.io.FileNotFoundException;

import br.com.angelica.listatelefonica.controller.ControllerListaTelefonica;


/**
 * Classe contendo o método principal para execução do programa.
 * @author Angelica Bortolini
 */
public class Principal {
	
	/**
	 * Método principal da aplicação.
	 * @param args argumento de linha de comando.
	 * @throws FileNotFoundException 
	 */
	public static void main(String []args) throws FileNotFoundException {

		new ControllerListaTelefonica().iniciar();
		
	}
	
}
