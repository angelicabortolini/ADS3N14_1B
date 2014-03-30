package br.com.angelica.listatelefonica.model;
import java.util.Arrays;

public class PesquisaBinaria<T extends Comparable<T>> extends ListaEncadeada<T> {

	private String[] listaBinaria; 
	
	private void gravaArray(){
		
		Nodo<T> nodo = head;
		int i = 0;
		while (nodo != null) {
				
			listaBinaria[i] =  nodo.getData().toString();
		    i++;
		    
		    nodo = nodo.getNext();
		}

		Arrays.sort(listaBinaria);
	}
	
	public String buscaBinaria(String[] array, String chave) {
	    return buscaBinariaRecursiva(array, 0, array.length - 1, chave);
	 }

	private String buscaBinariaRecursiva(String[] array, int primeiroIndice, int ultimoIndice, String nome) {
	
	    int indiceMeio = (primeiroIndice + ultimoIndice) / 2;     
	    String[] nomeDoIndice = array[indiceMeio].split("\\|");
	    
	    if (primeiroIndice > ultimoIndice)
	        return "";
	    else if(nomeDoIndice.toString().compareTo(nome) == 0)
	        return array[indiceMeio];
	   else if (nomeDoIndice.toString().compareTo(nome) > 0)
	        return buscaBinariaRecursiva(array, indiceMeio+1, ultimoIndice, nome);
	    else
	        return buscaBinariaRecursiva(array, primeiroIndice, indiceMeio-1, nome);
	    
	}

}	

