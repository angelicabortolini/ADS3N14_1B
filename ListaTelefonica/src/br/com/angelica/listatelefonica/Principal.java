package br.com.angelica.listatelefonica;
import br.com.angelica.listatelefonica.controller.ControllerListaTelefonica;


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

		new ControllerListaTelefonica().iniciar();
		
	}
	
}
