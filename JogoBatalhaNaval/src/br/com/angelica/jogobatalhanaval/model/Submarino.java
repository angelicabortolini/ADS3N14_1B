package br.com.angelica.jogobatalhanaval.model;

public class Submarino extends Navio {
	
	private String posPart1;

	/**
	 * Construtor padrão.
	 */
	public Submarino() {
		
		super(1);
		
	}

	public String getPosPart1() {
		return posPart1;
	}

	public void setPosPart1(String posPart1) {
		this.posPart1 = posPart1;
	}
	
}
