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
			textoMenu += "0 - Encerrar Aplicação.\n";
			
			System.out.println(textoMenu);
			System.out.print("Opção: ");
			
		}
		
		/**
		 *  Obtém o valor de operação do menu informado pelo usuário.
		 *  
		 * @return O valor da operação escolhida.
		 */
		public int capturarOperacao() {
			
			int valor = 0;
			@SuppressWarnings("resource")
			Scanner leitura = new Scanner(System.in);
			
			valor = leitura.nextInt();
			
			return valor;
			
		}
		
		/**
		 * Obtém o nome de contato telefônico informado pelo usuário.
		 * 
		 * @return Uma string contendo o nome do contato telefônico.
		 */
		public String capturarNome() {
			
			String nome = "";
			@SuppressWarnings("resource")
			Scanner leitura = new Scanner(System.in);
			nome = leitura.next();
			
			return nome;
			
		}
		
		/**
		 * Obtém o número telefônico do contato informado pelo usuário.
		 * 
		 * @return Uma string contendo o número telefônico.
		 */
		public String capturarNumeroTel() {
			
			String tel = "";
			@SuppressWarnings("resource")
			Scanner leitura = new Scanner(System.in);
			tel = leitura.next();
					
			return tel;
		}
		
		/**
		 * Método resposável por tratar os títulos de cada seção do console.
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
		 * @param quebraLinha Se true haverá quebra de linha ao final da mensagem. Caso false, a mensagem é exibida sem quebra de linha.
		 */
		public void exibirMensagem(String mensagem, boolean quebraLinha) {
			
			// Linha deve ser quebrada após mensagem?
			if(quebraLinha) {
				System.out.println(mensagem);
			} else {
				System.out.print(mensagem);
			}
			
			
		}
		
		/**
		 * Trata a impressão dos valores da lista encadeada.
		 * 
		 * @param lista valores contidos na lista.
		 */
		public void imprimirLista(String lista) {
			
			System.out.println(lista);
			
		}
}
