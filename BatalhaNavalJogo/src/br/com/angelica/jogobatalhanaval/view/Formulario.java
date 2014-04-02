package br.com.angelica.jogobatalhanaval.view;
import java.util.Scanner;

public class Formulario{
	/**
	 * Construtor padrão da classe.
	 */
	public Formulario() { }
	
	/**
	 * Cursor do teclado
	 * 
	 * @param mensagem para o usuario
	 * @return String
	 */
	public String cursor(String mensagem) {
		
		String valor = "";
		System.out.print(mensagem + ": ");
		@SuppressWarnings("resource")
		Scanner cursor = new Scanner(System.in);
		valor = cursor.next();
		return valor;
		
	}
	
	/**
	 * Imprime valores
	 * 
	 * @param String a ser definida.
	 */
	public void imprimir(String valor) {
		
		System.out.println(valor);
		
	}
}
