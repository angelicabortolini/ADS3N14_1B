package br.com.angelica.listatelefonica.model;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe responsável por gerar um arquivo no disco e gravar informações.
 * 
 * @author Angelica Bortolini
 */
public class Arquivo {
	
	private final String CAMINHO_ARQUIVO = "Dados\\listaTelefonica.txt";
	private FileReader arq ;
	private BufferedReader lerArq;
	
	/**
	 * Construtor padrão da classe sem inicializações.
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
	 * @throws IOException Disparado se caso houver falha de Entrada/Saída.
	 */
	public void gravar(String registroLinha) throws IOException  {
		
		FileWriter arq = new FileWriter(CAMINHO_ARQUIVO, true);
		PrintWriter gravaArq = new PrintWriter(arq);
		
		gravaArq.println(registroLinha);
		arq.close();
		
		//System.out.println("Valor gravador com sucesso!");
		
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
	

}
