package br.com.angelica.jogobatalhanaval.model;


public abstract class Navio {
	
	private int tamanho = 0;
	
	/**
	 * Construtor padrão.
	 */
	public Navio() {}
	
	public Navio(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
