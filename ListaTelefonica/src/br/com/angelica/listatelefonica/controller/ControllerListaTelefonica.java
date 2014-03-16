package br.com.angelica.listatelefonica.controller;
import br.com.angelica.listatelefonica.model.Nodo;

public class ControllerListaTelefonica {

	public void print() {
		
		String retorno;
		Nodo<T> elem = head;
		do {
			retorno += elem.getData();
			elem = elem.getNext();
		} while (elem != null);		
	}
}
