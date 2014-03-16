package br.com.angelica.listatelefonica;
import br.com.angelica.listatelefonica.controller.ControllerListaTelefonica;


/**
 * Classe contendo o m�todo principal para execu��o do programa.
 * @author Angelica Bortolini
 */
public class Principal {
	
	/**
	 * M�todo principal da aplica��o.
	 * @param args argumento de linha de comando.
	 */
	public static void main(String []args) {

		new ControllerListaTelefonica().iniciar();
		
	}
	
}
