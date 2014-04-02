package br.com.angelica.jogobatalhanaval.model;

public class PortaAvioes extends Navio {
	
	private String parte1;
	private String parte2;
	private String parte3;
	private String parte4;
	private String parte5;

	/**
	 * Construtor padrão.
	 */
	public PortaAvioes() {
		
		super(5);
		
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

	public String getParte4() {
		return parte4;
	}

	public void setParte4(String parte4) {
		this.parte4 = parte4;
	}

	public String getParte5() {
		return parte5;
	}

	public void setParte5(String parte5) {
		this.parte5 = parte5;
	}

	
}
