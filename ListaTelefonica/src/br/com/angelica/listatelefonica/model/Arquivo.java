package br.com.angelica.listatelefonica.model;

import java.awt.HeadlessException;
import java.io.BufferedReader;
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
	
	/**
	 * Construtor padrão da classe sem inicializações.
	 */
	public Arquivo() {}

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
	 * 
	 * @throws HeadlessException Disparado quando o código que é dependente de um teclado, monitor ou mouse<br>
	 * é chamado em um ambiente que não suporta um teclado, monitor ou mouse.
	 * 
	 * @throws IOException Disparado se caso houver falha de Entrada/Saída.
	 */
	public String consultar() throws HeadlessException, IOException {
		
		FileReader arq = new FileReader(CAMINHO_ARQUIVO);
		BufferedReader lerArq = new BufferedReader(arq);

		String linha = lerArq.readLine();
		 return linha;
		//arq.close();
		
	}
	
}
