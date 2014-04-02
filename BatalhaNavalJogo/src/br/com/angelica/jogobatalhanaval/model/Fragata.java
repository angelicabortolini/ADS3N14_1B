package br.com.angelica.jogobatalhanaval.model;

public class Fragata extends Navio {

	private String parte1;
	private String parte2;
	private String parte3;
	
	/**
	 * Construtor padrão.
	 */
	public Fragata() {
		
		super(3);
		
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

	public String getParte3() {
		return parte3;
	}

	public void setParte3(String parte3) {
		this.parte3 = parte3;
	}
	
}
