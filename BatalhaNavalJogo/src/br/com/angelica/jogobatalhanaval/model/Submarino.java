package br.com.angelica.jogobatalhanaval.model;

public class Submarino extends Navio {
	
	private String parte1;

	/**
	 * Construtor padrão.
	 */
	public Submarino() {
		
		super(1);
		
	}

	public String getParte1() {
		return parte1;
	}

	public void setParte1(String parte1) {
		this.parte1 = parte1;
	}
	
}
