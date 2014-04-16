package br.com.angelica.comparacaoordenacao.controller;
import br.com.angelica.comparacaoordenacao.model.ComparacaoOrdenacao;
import br.com.angelica.comparacaoordenacao.view.MenuConsole;

public class ControllerPrincipal {
	private MenuConsole   MenuConsole;
	private ComparacaoOrdenacao AlgoritimoOrdenacao;
	
	public ControllerPrincipal() {
		
		MenuConsole   = new MenuConsole();
		AlgoritimoOrdenacao = new ComparacaoOrdenacao();
		
	}
	
	public void iniciar() {
		
		String opcao = "";
		
		do {
			
			MenuConsole.imprimir("*** Menu ***\n");
			MenuConsole.imprimir("1 - Executar ordena��o.");
			MenuConsole.imprimir("0 - Encerrar programa.");
			
			opcao = MenuConsole.cursor("Op��o");
			
			switch (opcao) {
			
			case "1":
						
				AlgoritimoOrdenacao.gerarArray(Integer.parseInt(MenuConsole.cursor("Informe o tamanho do array")));		
				AlgoritimoOrdenacao.InsertSort();
				AlgoritimoOrdenacao.QuickSort();
				
				MenuConsole.imprimir("Quantidade de compara��es:");
				MenuConsole.imprimir("Insert Sort:\t" + AlgoritimoOrdenacao.getCountComparacoesInsertSort());
				MenuConsole.imprimir("Quick Sort:\t"   + AlgoritimoOrdenacao.getCountComparacoesQuickSort());
				
				MenuConsole.imprimir("Quantidade de Trocas:");
				MenuConsole.imprimir("Insert Sort:\t" + AlgoritimoOrdenacao.getCountTrocasInsertSort());
				MenuConsole.imprimir("Quick Sort:\t"   + AlgoritimoOrdenacao.getCountTrocasQuickSort());
				
				// Inicia o valor dos campos da Ordena��o.
				AlgoritimoOrdenacao.setCountComparacoesInsertSort(0);
				AlgoritimoOrdenacao.setCountComparacoesQuickSort(0);
				AlgoritimoOrdenacao.setCountTrocasInsertSort(0);
				AlgoritimoOrdenacao.setCountTrocasQuickSort(0);
				
				break;

			case "0":
				
				this.fim();
				break;
				
			default:
				
				MenuConsole.imprimir("Escolha uma das op��es do menu.");
				break;
				
			}
		
		} while(true);
		
	}
	
	public void fim() {
		
		MenuConsole.imprimir("Fim da execu��o.");
		System.exit(0);
		
	}
}
