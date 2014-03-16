package br.com.angelica.listatelefonica.controller;
import java.awt.HeadlessException;
import java.io.IOException;
import br.com.angelica.listatelefonica.model.Arquivo;
import br.com.angelica.listatelefonica.model.ListaEncadeada;
import br.com.angelica.listatelefonica.model.Nodo;

public class ControllerListaTelefonica {

	
	/**
	 * Inicializa lista conforme valores gravados no arquivo listaTelefonica.txt
	 * @throws HeadlessException
	 * @throws IOException
	 */
	public void inicializaLista() throws HeadlessException, IOException{
		
		try {
			
			ListaEncadeada<String> lista = new ListaEncadeada<String>();	
			
			Arquivo arquivo = new Arquivo();
			
			String linhaArquivo;
			while( (linhaArquivo = arquivo.consultar())!= null) {
			
				String[] valores = linhaArquivo.split("|");
				
				if(valores[2] == "A"){
					Nodo<String> anterior = null;	
					if(lista.getHead().equals("")){
						Nodo<String> nodo = new Nodo<String>(linhaArquivo);
						lista.insert(nodo);
						anterior = nodo;
				    }else{
				    	Nodo<String> nodo = new Nodo<String>(linhaArquivo);
				    	lista.insert(nodo,anterior);
				    	anterior = nodo;
				    }
			    
				}
			} 
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insereValor(String nome, String telefone) throws IOException{
		
		ListaEncadeada<String> lista = new ListaEncadeada<String>();		
		Arquivo arquivo = new Arquivo();
		
		String linhaArquivo = nome + "|" + telefone + "|A";
		Nodo<String> anterior = null;	
		if(lista.getHead().equals("")){
			Nodo<String> nodo = new Nodo<String>(linhaArquivo);
			lista.insert(nodo);
			anterior = nodo;
			arquivo.gravar(linhaArquivo);
		}else{
	    	Nodo<String> nodo = new Nodo<String>(linhaArquivo);
	    	lista.insert(nodo,anterior);
	    	anterior = nodo;
	    	arquivo.gravar(linhaArquivo);
		}

	}
}
