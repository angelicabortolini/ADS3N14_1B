package br.com.angelica.listatelefonica.view;

public class ConsoleMenu {
	
	public ConsoleMenu() {}
	
	public void exibir() {
		
		String texto = "Menu\n\n";
		
		texto += "1 - Incluir\n";
		texto += "2 - Excluir\n";
		texto += "3 - Consultar\n";
		
		System.out.println(texto);
		
	}

}
