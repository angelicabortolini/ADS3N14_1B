package br.com.angelica.jogobatalhanaval.model;

public class Placar {

	private int pontuacao = 0;

	/**
	 * Construtor padr�o.
	 */
	public Placar() {
		
		// Inicia a pontua��o com 15 pontos.
		this.pontuacao = 15;
		
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
