package br.com.angelica.listatelefonica.model;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe respons�vel por gerar um arquivo no disco e gravar informa��es.
 * 
 * @author Angelica Bortolini
 */
public class Arquivo {
	
	private final String CAMINHO_ARQUIVO = "Dados\\listaTelefonica.txt";
	private FileReader arq ;
	private BufferedReader lerArq;
	
	/**
	 * Construtor padr�o da classe sem inicializa��es.
	 * @throws FileNotFoundException 
	 */
	public Arquivo() throws FileNotFoundException {
		
		arq = new FileReader(CAMINHO_ARQUIVO);
		lerArq = new BufferedReader(arq);
	}

	/**
	 * Grava um registro no arquivo texto.
	 * 
	 * @param registroLinha O valor para se gravar em uma linha do arquivo texto.
	 * @throws IOException Disparado se caso houver falha de Entrada/Sa�da.
	 */
	public void gravar(String registroLinha) throws IOException  {
		
		FileWriter arq = new FileWriter(CAMINHO_ARQUIVO, true);
		PrintWriter gravaArq = new PrintWriter(arq);
		
		gravaArq.println(registroLinha);
		arq.close();
		
	}

	/**
	 * Consulta o arquivo texto.
	 * @throws IOException 
	 *
	 */
	public String consultar() throws IOException {
		
		String linha = lerArq.readLine();
		 return linha;
		
	}
	
	public boolean excluiItemLista(String nome) throws IOException {
		
		boolean contatoLocalizado = false;
		
		FileReader arq = new FileReader(CAMINHO_ARQUIVO);
		BufferedReader lerArq = new BufferedReader(arq);
		String linhaArquivo;
		String conteudo = "";
		
		while( (linhaArquivo = lerArq.readLine())!= null) {

			String[] valores = linhaArquivo.split("\\|");
			
			// O valor informado � igual ao do contato (ignorando caixa alta ou baixa)
			if(valores[0].equals(nome)) {
				// Atualiza a linha
				conteudo += valores[0] + "|" + valores[1] + "|I,";
				contatoLocalizado = true;
				
			} else {
				conteudo += linhaArquivo + ",";
			}
			
	    }
		
		arq.close();
		
		String[] conteudonovo = conteudo.split("\\,");
		
		// Inicializar o conte�do do arquivo.
		FileWriter zerarArquivo = new FileWriter(CAMINHO_ARQUIVO);
		PrintWriter gravaArqBranco = new PrintWriter(zerarArquivo);
		gravaArqBranco.print("");
		zerarArquivo.close();
		// Fim:  Inicializar o conte�do do arquivo.
		
		// Itera sobre o arquivo, desta anexando todos os dados alterados!
		FileWriter arqnovo = new FileWriter(CAMINHO_ARQUIVO, true);
		PrintWriter gravaArq = new PrintWriter(arqnovo);
		
		for (int i = 0; i < conteudonovo.length; i++) {
			
			gravaArq.println(conteudonovo[i]);
			
		}
		
		arqnovo.close();
		
		return contatoLocalizado;
		
	}

}
