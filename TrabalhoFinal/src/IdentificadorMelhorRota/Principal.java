/**
 * Classe principal.
 *  
 * @author Angelica B. Bortolini
 * @author Ederson Souza
 * @author Fillipe Welausen
 * @author Misael C. Homem
 *
 */

package IdentificadorMelhorRota;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		
		Viagem viagem = new Viagem();
		//viagem.gravaListas();
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println(df.format(viagem.calcularDinstanciaGeodesica(390.1466, 556.8571, 595.2804, 226.5575)));
	    
	}

}
