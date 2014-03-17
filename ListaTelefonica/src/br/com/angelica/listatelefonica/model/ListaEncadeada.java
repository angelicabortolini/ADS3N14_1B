package br.com.angelica.listatelefonica.model;
import static java.lang.System.out;
import java.awt.HeadlessException;
import java.io.IOException;

public class ListaEncadeada<T extends Comparable<T>> {

	protected Nodo<T> head;
	protected Nodo<T> tail;
	
	/**
	 * Metodo para insercao do primeiro nodo.
	 * @param novo o nodo da lista.
	 */
	public void insert(Nodo<T> novo){
		novo.setNext(head);
		novo.setPreview(head);
		head = novo;
		if (tail == null){
			tail = novo;
		}
	}
	
	public void insert(Nodo<T> novo, Nodo<T> anterior){
		
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
		novo.setPreview(anterior);
		if (anterior == tail){
			tail = novo;
		}
	}

	public Nodo<T> getHead() {
		return head;
	}

	public void setHead(Nodo<T> head) {
		this.head = head;
	}

	public Nodo<T> getTail() {
		return tail;
	}

	public void setTail(Nodo<T> tail) {
		this.tail = tail;
	}
	
	public String imprimir() {
		
		Nodo<T> elem = head;
		String valores = "";
		
		do {
			valores += elem.getData() + "\r\n";
			elem = elem.getNext();
		} while (elem != null);
		
		return valores;

	}
	
	public Nodo<T> procurarNoPorValorInicial(T valor) {
		
		Nodo<T> nodo = head;
		Nodo<T> anterior = null;
		
		while (nodo != null) {
			
			String letraInicial = String.valueOf( ((String) nodo.getData()).charAt(0) ); 
			
			int cmp = letraInicial.compareTo((String) valor);
			
			if (cmp == 0) {
				return nodo;
			}			
			
			anterior = nodo;
			nodo = nodo.getNext();
			
		}
		
		return nodo;
	}
	
	@SuppressWarnings("null")
	public void delete(T valor){
		
		Nodo<T> nodo = head;
		Nodo<T> anterior = null;
		Nodo<T> proximo = null;
		Nodo<T> aux = null; 
		
		// percorre a lista procurando o nodo que devera ser excluido
		while (nodo != null) {
			int cmp = nodo.getData().compareTo(valor);
			
			if (cmp == 0){
				if(nodo.getPreview() == null){
					//se o nodo a excluir for o head
					proximo = nodo.getNext();
					
				}else if(nodo.getNext() == null){
					//se o nodo a excluir for o tail
					anterior = nodo.getPreview();
				}else{
					//se o nodo a excluir for do meio
					proximo = nodo.getNext();
					anterior = nodo.getPreview();
				}
				
				break;
			}
			
			anterior = nodo;
			nodo = nodo.getNext();
		}
		
		
		if(nodo.getPreview() == null){
			//se o nodo a excluir for o head
			proximo.setPreview(nodo.getPreview());
			head = proximo;
			
		}else if(nodo.getNext() == null){
			//se o nodo a excluir for o tail
			anterior.setNext(nodo.getNext());
			tail = anterior;
		}else{
			//se o nodo a excluir for do meio
			aux = nodo.getPreview();
			anterior.setNext(nodo.getNext());
			proximo.setPreview(aux);
		}
		
	}
	
}
