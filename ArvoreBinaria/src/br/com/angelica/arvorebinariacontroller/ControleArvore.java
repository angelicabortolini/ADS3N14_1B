package br.com.angelica.arvorebinariacontroller;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import br.com.angelica.arvorebinaria.model.Arquivo;
import br.com.angelica.arvorebinaria.model.Arvore;
import br.com.angelica.arvorebinaria.model.No;
import br.com.angelica.arvorebinaria.view.ConsoleArvore;
import br.com.angelica.arvorebinaria.model.Contato;

public class ControleArvore {

	private ConsoleArvore console;
	private Arvore arvore;
	private No no;
	//private No<String> anterior = null;	
	private Arquivo arquivo ;
	
	
	/**
	 * Construtor padrão inicializando os campos.
	 * @throws FileNotFoundException 
	 */
	public ControleArvore() throws FileNotFoundException {
		
		console = new ConsoleArvore();
		arvore = new Arvore();
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
				no = new No();
				arvore.insereNoArvore(no,valores[0],valores[1]);
				
			} 
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insereValor(String nome, String telefone) throws IOException{
		
		String linhaArquivo = nome + "|" + telefone;	
		no = new No();
		arvore.insereNoArvore(no,nome,telefone);
	    arquivo.gravar(linhaArquivo);
		
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
			
			console.exibirMenu();
			operacao = console.capturarOperacao();
			
			switch(operacao) {
			
			case 1:
				
				console.exibirTituloOpcao("Incluir um contato telefônico");
				console.exibirMensagem("Informe o nome: ", false);
				nome = console.capturarNome();
				console.exibirMensagem("Informe o telefône: ", false);
				telefone = console.capturarNumeroTel();
				
				try {
					insereValor(nome, telefone);
				} catch(IOException e) {
					
				}
				
				console.exibirMensagem("Contato adicionado", true);
				break;
				
			case 2:
				
				console.exibirTituloOpcao("Excluir contato telefônico");
				console.exibirMensagem("Informe o nome: ", false);
				nome = console.capturarNome();
				
				try {
					
					arvore.deletaNoArvore(nome);
					
				} catch (Exception e) {
					
					console.exibirMensagem("Erro: " + e.getMessage(), true);
				}
					
				break;
				
			case 3:
				

				
				break;
				
			case 4:
				
				console.exibirTituloOpcao("Consultar modo Infixado");		
				console.imprimirLista(arvore.travessiaInfixada(arvore.getRaiz(), null));
				
				break;
				
			case 5:
				
				console.exibirTituloOpcao("Consultar modo Prefixado");		
				console.imprimirLista(arvore.travesiaPrefixada(arvore.getRaiz(), null));
				
				break;
				
			case 6:
				
				console.exibirTituloOpcao("Consultar modo Posfixado");		
				console.imprimirLista(arvore.travesiaPrefixada(arvore.getRaiz(), null));
				
				break;
			
			case 7:
				
				break;
			
			case 8:
				
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
		
		console.exibirTituloOpcao("Finalizando aplicação");
		System.exit(0);
		
	}
}
