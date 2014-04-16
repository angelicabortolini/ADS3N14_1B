package br.com.angelica.controller;

public class ControllerPrincipal {
	private MenuConsole   MenuConsole;
	private AlgoritimoOrdenacao AlgoritimoOrdenacao;
	
	public ControllerPrincipal() {
		
		MenuConsole   = new MenuConsole();
		AlgoritimoOrdenacao = new AlgoritimoOrdenacao();
		
	}
	
	public void iniciar() {
		
		String opcao = "";
		
		do {
			
			MenuConsole.imprimir("*** Menu ***\n");
			MenuConsole.imprimir("1 - Executar ordenação.");
			MenuConsole.imprimir("0 - Encerrar programa.");
			
			opcao = MenuConsole.cursor("Opção");
			
			switch (opcao) {
			
			case "1":
						
				AlgoritimoOrdenacao.gerarArray(Integer.parseInt(console.cursor("Informe o tamanho do array")));		
				AlgoritimoOrdenacao.InsertSort();
				AlgoritimoOrdenacao.HeapSort();
				
				MenuConsole.imprimir("Quantidade de comparações:");
				MenuConsole.imprimir("Insert Sort:\t" + AlgoritimoOrdenacao.getCountComparacoesInsertSort());
				MenuConsole.imprimir("Quick Sort:\t"   + AlgoritimoOrdenacao.getCountComparacoesQueckSort());
				
				MenuConsole.imprimir("Quantidade de Trocas:");
				MenuConsole.imprimir("Insert Sort:\t" + AlgoritimoOrdenacao.getCountTrocasInsertSort());
				MenuConsole.imprimir("Quick Sort:\t"   + AlgoritimoOrdenacao.getCountTrocasQueckSort());
				
				// Inicia o valor dos campos da Ordenação.
				MenuConsole.setCountInsertSort(0);
				MenuConsole.setCountHeapSort(0);
				
				break;

			case "0":
				
				this.fim();
				break;
				
			default:
				
				MenuConsole.imprimir("Escolha uma das opções do menu.");
				break;
				
			}
		
		} while(true);
		
	}
	
	public void fim() {
		
		MenuConsole.imprimir("Fim da execução.");
		System.exit(0);
		
	}
}
