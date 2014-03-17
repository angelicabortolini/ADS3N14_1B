package br.com.angelica.listatelefonica;
import java.io.FileNotFoundException;

import br.com.angelica.listatelefonica.controller.ControllerListaTelefonica;


/**
 * Classe contendo o m�todo principal para execu��o do programa.
 * @author Angelica Bortolini
 */
public class Principal {
	
	/**
	 * M�todo principal da aplica��o.
	 * @param args argumento de linha de comando.
	 * @throws FileNotFoundException 
	 */
	public static void main(String []args) throws FileNotFoundException {

		new ControllerListaTelefonica().iniciar();
		
	}
	
}
