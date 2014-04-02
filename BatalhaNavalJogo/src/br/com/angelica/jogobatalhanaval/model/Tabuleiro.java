package br.com.angelica.jogobatalhanaval.model;

public class Tabuleiro {
	
	private String[][]  tabCoord;
	private PortaAvioes  portaAviao;
	private Destroyer   destroyer;
	private Fragata     fragata;
	private Torpedeiro  torpedeiro;
	private Submarino   submarino;
	
	/**
	 * Construtor padrão.
	 */
	public Tabuleiro() {
		
		tabCoord   = new String[10][10];
		portaAviao = new PortaAvioes();
		destroyer  = new Destroyer();
		fragata    = new Fragata();
		torpedeiro = new Torpedeiro();
		submarino  = new Submarino();
		
	}
	
	/**
	 * Incia o tabuleiro preenchendo cada índice da matriz com pontos.
	 */
	public void iniciar() {
		
		for(int c = 0; c < tabCoord.length ; c++) {
			for(int l = 0; l < tabCoord[c].length ; l++) {
				tabCoord[c][l] = ".\t";
			}
		}
		
	}
	
	
	/**
	 * Seta coordenadas
	 */
	public void distribuirNavios() {
		
		// Considerar 1º digito a linha e o 2º a coluna.
		
		portaAviao.setParte1("11");
		portaAviao.setParte2("12");
		portaAviao.setParte3("13");
		portaAviao.setParte4("14");
		portaAviao.setParte5("15");
		
		destroyer.setParte1("21");
		destroyer.setParte2("31");
		destroyer.setParte3("41");
		destroyer.setParte4("51");
		
		fragata.setParte1("46");
		fragata.setParte2("56");
		fragata.setParte3("66");
		
		torpedeiro.setParte1("78");
		torpedeiro.setParte2("89");
		
		submarino.setParte1("54");
		
	}
	
	public void receberCoordenadaNavio(String coordenada) {
		
		int cordLinha = Integer.valueOf(String.valueOf(coordenada.charAt(0)));
		int cordColuna = 0;
		
		// Equivalência das coordenadas
		// A - 0    F - 5
		// B - 1    G - 6
		// C - 2    H - 7
		// D - 3    I - 8
		// E - 4    J - 9
 
		switch (coordenada.charAt(1)) {
		case 'A':
			cordColuna = 0;
			break;
		
		case 'B':
			cordColuna = 1;
			break;
		
		case 'C':
			cordColuna = 2;
			break;
			
		case 'D':
			cordColuna = 3;
			break;
		
		case 'E':
			cordColuna = 4;
			break;
		
		case 'F':
			cordColuna = 5;
			break;
			
		case 'G':
			cordColuna = 6;
			break;
		
		case 'H':
			cordColuna = 7;
			break;
		
		case 'I':
			cordColuna = 8;
			break;
			
		case 'J':
			cordColuna = 9;
			break;
			
		}
		
		coordenada = String.valueOf(cordLinha) + String.valueOf(cordColuna); 
		
		if(coordenada.equals(portaAviao.getParte1())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			portaAviao.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(portaAviao.getParte2())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			portaAviao.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(portaAviao.getParte3())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			portaAviao.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(portaAviao.getParte4())) {

			tabCoord[cordLinha][cordColuna] = "O\t";
			portaAviao.setParte1("");
			return;
			
		}
		

		if(coordenada.equals(portaAviao.getParte5())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			portaAviao.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(destroyer.getParte1())) {

			tabCoord[cordLinha][cordColuna] = "O\t";
			destroyer.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(destroyer.getParte2())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			destroyer.setParte1("");
			return;
			
		}
		

		if(coordenada.equals(destroyer.getParte3())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			destroyer.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(destroyer.getParte4())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			destroyer.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(fragata.getParte1())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			fragata.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(fragata.getParte2())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			fragata.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(fragata.getParte3())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			fragata.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(torpedeiro.getParte1())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			torpedeiro.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(torpedeiro.getParte2())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			torpedeiro.setParte1("");
			return;
			
		}
		
		if(coordenada.equals(submarino.getParte1())) {
			
			tabCoord[cordLinha][cordColuna] = "O\t";
			submarino.setParte1("");
			return;
			
		}
		
		tabCoord[cordLinha][cordColuna] = "-\t";
		
	}

	
	

	public String[][] getTabCoord() {
		return tabCoord;
	}

	public PortaAvioes getPortaAviao() {
		return portaAviao;
	}

	public Destroyer getDestroyer() {
		return destroyer;
	}

	public Fragata getFragata() {
		return fragata;
	}

	public Torpedeiro getTorpedeiro() {
		return torpedeiro;
	}

	public Submarino getSubmarino() {
		return submarino;
	}
	
	/**
	 * Imprime a matriz formatada
	 * 
	 * @return Uma String representando o contéudo da matriz.
	 */
	public String imprimir() {
		
		String tabuleiro = "";
		int cordLinha = 0;
		
		for(int c = 0; c < tabCoord.length; c++) {
			for(int l = 0; l < tabCoord[c].length; l++) {
				tabuleiro += tabCoord[c][l];
			}
			
			tabuleiro += cordLinha + "\n";
			cordLinha++;
			
		}
		
		tabuleiro += "A\tB\tC\tD\tE\tF\tG\tH\tI\tJ\n";
		return tabuleiro;
		
	}

}
