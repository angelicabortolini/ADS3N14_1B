package br.com.angelica.jogobatalhanaval.model;

public class Pontuacao {

	private int valor = 0;

	/**
	 * Construtor padrão.
	 */
	public Pontuacao() {
		this.valor = 15;		
	}

	public int getPontuacao() {
		return valor;
	}

	public void setPontuacao(int valor) {
		this.valor = valor;
	}
	
}
