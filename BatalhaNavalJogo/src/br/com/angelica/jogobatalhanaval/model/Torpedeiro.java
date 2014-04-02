package br.com.angelica.jogobatalhanaval.model;

public class Torpedeiro extends Navio {

	private String parte1;
	private String parte2;
	
	/**
	 * Construtor padrão.
	 */
	public Torpedeiro() {
		
		super(2);
		
	}

	public String getParte1() {
		return parte1;
	}

	public void setParte1(String parte1) {
		this.parte1 = parte1;
	}

	public String getParte2() {
		return parte2;
	}

	public void setParte2(String parte2) {
		this.parte2 = parte2;
	}
	
}
