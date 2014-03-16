package br.com.angelica.listatelefonica.controller;

import br.com.angelica.listatelefonica.view.ConsoleMenu;

public class ControllerPrograma {
	
	private ConsoleMenu conMenu;
	
	public ControllerPrograma() {
		
		conMenu = new ConsoleMenu();
		
	}
	
	public void iniciar() {
		
		conMenu.exibir();
		
	}

}
