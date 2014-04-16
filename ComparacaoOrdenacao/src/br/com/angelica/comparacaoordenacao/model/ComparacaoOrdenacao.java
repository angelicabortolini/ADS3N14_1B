package br.com.angelica.comparacaoordenacao.model;

import java.util.Random;

public class ComparacaoOrdenacao {

	private int countComparacoesInsertSort;
	private int countComparacoesQuickSort;
	private int countTrocasInsertSort;
	private int countTrocasQuickSort;
	private int[] array;
	
	public ComparacaoOrdenacao() {}
	

	public int getCountComparacoesInsertSort() {
		return countComparacoesInsertSort;
	}


	public void setCountComparacoesInsertSort(int countComparacoesInsertSort) {
		this.countComparacoesInsertSort = countComparacoesInsertSort;
	}


	public int getCountComparacoesQuickSort() {
		return countComparacoesQuickSort;
	}


	public void setCountComparacoesQuickSort(int countComparacoesQuickSort) {
		this.countComparacoesQuickSort = countComparacoesQuickSort;
	}


	public int getCountTrocasInsertSort() {
		return countTrocasInsertSort;
	}


	public void setCountTrocasInsertSort(int countTrocasInsertSort) {
		this.countTrocasInsertSort = countTrocasInsertSort;
	}


	public int getCountTrocasQuickSort() {
		return countTrocasQuickSort;
	}


	public void setCountTrocasQuickSort(int countTrocasQuickSort) {
		this.countTrocasQuickSort = countTrocasQuickSort;
	}


	/**
	 * Gera um array de inteiros aleatórios. 
	 */
	public int[] gerarArray(int num) {
		
		Random random = new Random();
		array = new int[num];
		
		for(int i = 0; i < array.length; i++) {
			
			array[i] = random.nextInt(num + 1);
			
		}
		
		return array;
		
	}
	
	public void InsertSort() {
		
		int[] arrayInsert = array;
		
        for(int fixo = 1; fixo <= arrayInsert.length; fixo++) {
        	 
        	int x = fixo - 1;
        	int y = fixo;
 
        	while(y != 0 && y != arrayInsert.length && arrayInsert[x] > arrayInsert[y]) {
    			
        		countComparacoesInsertSort++;
        		countTrocasInsertSort++;
        		int a = arrayInsert[x];
        		arrayInsert[x] = arrayInsert[y];
        		arrayInsert[y] = a;
        		x--;
        		y--;
        		
           }
        	
        }
		
	}
	
	public void QuickSort(){
		
		int[] arrayQuickSort = array;
		Ordenar(arrayQuickSort, 0, arrayQuickSort.length - 1);
	}

	 private void Ordenar(int[] vetor, int inicio, int fim)
	   {
	      if (inicio < fim)
	      {
	         int posicaoPivo = Separar(vetor, inicio, fim);
	         Ordenar(vetor, inicio, posicaoPivo - 1);
	         Ordenar(vetor, posicaoPivo + 1, fim);
	      }
	   }
	 
	   private int Separar(int[] vetor, int inicio, int fim)
	   {
	      int pivo = vetor[inicio];
	      int i = inicio + 1, f = fim;
	      while (i <= f)
	      {
	    	  countComparacoesQuickSort++;
	         if (vetor[i] <= pivo)
	            i++;
	         else if (pivo < vetor[f])
	            f--;
	         else
	         {
	        	countTrocasQuickSort++;
	            int troca = vetor[i];
	            vetor[i] = vetor[f];
	            vetor[f] = troca;
	            i++;
	            f--;
	         }
	      }
	      
	      
	      vetor[inicio] = vetor[f];
	      vetor[f] = pivo;
	      return f;
	   }
}
