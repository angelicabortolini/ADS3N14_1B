package br.com.angelica.jogobatalhanaval.view;

import java.util.Scanner;

public class Console {
	/**
	 * Construtor padrão da classe.
	 */
	public Console() { }
	
	/**
	 * Imprime valores informados definidos.
	 * 
	 * @param valor a ser definido, uma mensagem, etc.
	 */
	public void imprimir(String valor) {
		
		System.out.println(valor);
		
	}
	
	/**
	 * Cursor para console, recebendo a entrada do teclado. 
	 * 
	 * @param dialogo Uma mensagem para o usuário.
	 * @return Retorna uma String com o valor que o usuário informou.
	 */
	public String cursor(String dialogo) {
		
		String valor = "";
		System.out.print(dialogo + ": ");
		@SuppressWarnings("resource")
		Scanner cursor = new Scanner(System.in);
		valor = cursor.next();
		return valor;
		
	}
}
