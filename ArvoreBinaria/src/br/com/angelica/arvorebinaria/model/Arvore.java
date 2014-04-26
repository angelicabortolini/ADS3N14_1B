package br.com.angelica.arvorebinaria.model;

public class Arvore {

	private No raiz;
	private int profundidade;
	private int largura;
	
	public No getRaiz() {
		return raiz;
	}
	
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	public int getProfundidade() {
		return profundidade;
	}
	
	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}
	
	public int getLargura() {
		return largura;
	}
	
	public void setLargura(int largura) {
		this.largura = largura;
	}
	
	public void insereNoArvore(No no,String nome,String telefone){

		if(this.raiz == null){
			
			no.insertNo(nome, telefone, null, null, null);
			this.raiz = no;

		}else{
		
         /*if (valor < node.valor) {
        		
	            if (node.esquerda != null) {
	                inserir(node.esquerda, valor);
	            } else {

	                System.out.println("  Inserindo " + valor + " a esquerda de " + node.valor);
	                node.esquerda = new No(valor);
	            }
	        } else if (valor > node.valor) {

	            if (node.direita != null) {
	                inserir(node.direita, valor);
	            } else {

	                System.out.println("  Inserindo " + valor + " a direita de " + node.valor);
	                node.direita = new No(valor);
	            }
	        }*/
		}
	}
	
	public void deletaNoArvore(String nome){
		
	}
	
	public void buscaNoArvore(){
		
	} 
	
	public String travesiaPrefixada(No no, String travessia) {
	        
	 	if(no != null){
        	travessia += no.getValor() + " ";
        	travesiaPrefixada(no.getEsquerda(),travessia);
        	travesiaPrefixada(no.getDireita(),travessia);
        }
        
        return travessia;
	}
	 
	public String travessiaPosfixada(No no,String travessia) {
		  	
        if(no != null){
        	travessiaPosfixada(no.getEsquerda(),travessia);
        	travessiaPosfixada(no.getDireita(),travessia);
        	travessia += no.getValor() + " ";
        }
        
        return travessia;
	}
	  
	public String travessiaInfixada(No no, String travessia) {

        if(no != null){
        	travessiaInfixada(no.getEsquerda(),travessia);
        	travessia += no.getValor() + " ";
			travessiaInfixada(no.getDireita(),travessia);
        }
        
        return travessia;
	}
	
}
