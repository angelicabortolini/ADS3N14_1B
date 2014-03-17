package br.com.angelica.listatelefonica.controller;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import br.com.angelica.listatelefonica.model.Arquivo;
import br.com.angelica.listatelefonica.model.ListaEncadeada;
import br.com.angelica.listatelefonica.model.Nodo;
import br.com.angelica.listatelefonica.view.ConsoleListaTelefonica;

public class ControllerListaTelefonica {

	private ConsoleListaTelefonica clt;
	private ListaEncadeada<String> lista;
	private Nodo<String> novo;
	private Nodo<String> anterior = null;	
	private Arquivo arquivo ;
	
	
	/**
	 * Construtor padrão inicializando os campos.
	 * @throws FileNotFoundException 
	 */
	public ControllerListaTelefonica() throws FileNotFoundException {
		
		clt = new ConsoleListaTelefonica();
		lista = new ListaEncadeada<String>();
		arquivo = new Arquivo();
	}
	
	
	/**
	 * Inicializa lista conforme valores gravados no arquivo listaTelefonica.txt
	 * 
	 * @throws HeadlessException
	 * @throws IOException
	 */
	public void inicializaLista() throws HeadlessException, IOException{
		
		try {
			
			String linhaArquivo;
			while( (linhaArquivo = arquivo.consultar())!= null) {
			
				String[] valores = linhaArquivo.split("\\|");
				
	            // se a linha do arquivo está ativa grava o valor na lista
				if(valores[2].equals("A")){
						
					// se a lista está vazia insere o primeiro nodo.
					if(lista.getHead() == null){
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
		
		String linhaArquivo = nome + "|" + telefone + "|A";
		//quando a lista está vazia insere primeiro nodo.
		
		if(lista.getHead() == null){
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
	
	
	/**
	 * Busca um contato apenas utilizando a inicial do nome.
	 * 
	 * @param inicial Uma única String representando a inicial do nome do contato.
	 * @return O valor do registro. Caso não encontrado retorna mensagem: Não possível localizar contato.
	 */
	public String buscarIncial(String inicial) {
		
		Nodo<String> no = lista.procurarNoPorValorInicial(inicial);
		
		if(no == null) {
			return "Não possível localizar contato.";
		} else {
			return no.getData();
		}
		
	}
	
	/**
	 * Trata o início da aplicação, fazendo chamada dos métodos que estão no ConListaTelefonica.
	 */
	public void iniciar() {
		
		try {
			this.inicializaLista();
		} catch(IOException e) {
			
		}
		
		int operacao = 0;
		boolean finalizar = true;
		
		do {
			
			String nome = "";
			String telefone = "";
			String inicial = "";
			
			clt.exibirMenu();
			operacao = clt.capturarOperacao();
			
			switch(operacao) {
			
			case 1:
				
				clt.exibirTituloOpcao("Incluir um contato telefônico");
				clt.exibirMensagem("Informe o nome: ", false);
				nome = clt.capturarNome();
				clt.exibirMensagem("Informe o telefône: ", false);
				telefone = clt.capturarNumeroTel();
				
				try {
					insereValor(nome, telefone);
				} catch(IOException e) {
					
				}
				
				clt.exibirMensagem("Contato adicionado", true);
				break;
				
			case 2:
				
				clt.exibirTituloOpcao("Excluir contato telefônico");
				
				clt.exibirMensagem("Informe o nome: ", false);
				clt.capturarNome();
				try {
					arquivo.excluiItemLista("misael");
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				clt.exibirMensagem("Contato excluido.", true);
				break;
				
			case 3:
				
				clt.exibirTituloOpcao("Consultar um contato telefônico");
				
				clt.exibirMensagem("Informe o nome: ", false);
				clt.capturarNome();
				
				// Imprimindo toda a lista.
				clt.imprimirLista(lista.imprimir());
				
				break;
				
			case 4:
				
				clt.exibirTituloOpcao("Consultar contato pela letra inicial");
				clt.exibirMensagem("Informe a letra inicial: ", false);
				inicial = String.valueOf(clt.capturarNome().charAt(0));
				
				clt.imprimirLista(buscarIncial(inicial));
				
				break;
				
			case 0:
				
				finalizar = false;
				break;
			
			}
			
		} while(finalizar);
		
		this.finalizar();
		
	}

	/**
	 * Trata a finalização da aplicação.
	 */
	public void finalizar() {
		
		clt.exibirTituloOpcao("Finalizando aplicação");
		System.exit(1);
		
	}
}
