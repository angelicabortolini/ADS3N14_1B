package br.com.angelica.arvorebinaria.view;
import java.util.Scanner;

public class ConsoleArvore {

		public void exibirMenu() {
			
			String textoMenu = "*** Menu ***\n\n";
			
			textoMenu += "1 - Incluir Contato.\n";
			textoMenu += "2 - Excluir Contato.\n";
			textoMenu += "3 - Buscar Contato.\n";
			textoMenu += "4 - Travessia (Infixa).\n";
			textoMenu += "5 - Travessia (Prefixa).\n";
			textoMenu += "6 - Travessia (Posfixa).\n";
			textoMenu += "7 - Consultar largura.\n";
			textoMenu += "8 - Consultar profundidade.\n";
			textoMenu += "0 - Encerrar Aplica��o.\n";
			
			System.out.println(textoMenu);
			System.out.print("Op��o: ");
			
		}
		
		/**
		 *  Obt�m o valor de opera��o do menu informado pelo usu�rio.
		 *  
		 * @return O valor da opera��o escolhida.
		 */
		public int capturarOperacao() {
			
			int valor = 0;
			@SuppressWarnings("resource")
			Scanner leitura = new Scanner(System.in);
			
			valor = leitura.nextInt();
			
			return valor;
			
		}
		
		/**
		 * Obt�m o nome de contato telef�nico informado pelo usu�rio.
		 * 
		 * @return Uma string contendo o nome do contato telef�nico.
		 */
		public String capturarNome() {
			
			String nome = "";
			@SuppressWarnings("resource")
			Scanner leitura = new Scanner(System.in);
			nome = leitura.next();
			
			return nome;
			
		}
		
		/**
		 * Obt�m o n�mero telef�nico do contato informado pelo usu�rio.
		 * 
		 * @return Uma string contendo o n�mero telef�nico.
		 */
		public String capturarNumeroTel() {
			
			String tel = "";
			@SuppressWarnings("resource")
			Scanner leitura = new Scanner(System.in);
			tel = leitura.next();
					
			return tel;
		}
		
		/**
		 * M�todo respos�vel por tratar os t�tulos de cada se��o do console.
		 * 
		 * @param titulo
		 */
		public void exibirTituloOpcao(String titulo) {
			
			System.out.println("*** " + titulo + " ***\n\n");
			
		}

		/**
		 * Exibe uma mensagem a ser definida pelo programador.
		 * 
		 * @param mensagem String represetando uma mensagem.
		 * @param quebraLinha Se true haver� quebra de linha ao final da mensagem. Caso false, a mensagem � exibida sem quebra de linha.
		 */
		public void exibirMensagem(String mensagem, boolean quebraLinha) {
			
			// Linha deve ser quebrada ap�s mensagem?
			if(quebraLinha) {
				System.out.println(mensagem);
			} else {
				System.out.print(mensagem);
			}
			
			
		}
		
		/**
		 * Trata a impress�o dos valores da lista encadeada.
		 * 
		 * @param lista valores contidos na lista.
		 */
		public void imprimirLista(String lista) {
			
			System.out.println(lista);
			
		}
}
