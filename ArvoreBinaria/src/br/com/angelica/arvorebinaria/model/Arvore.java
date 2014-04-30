package br.com.angelica.arvorebinaria.model;

public class Arvore {

	private No raiz;
	private int profundidade;
	private int largura;
	private String retorno;

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
	
	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
	// insere nós na arvore
	public void insereNoArvore(No no,String nome,String telefone){

		if(this.raiz == null){
			no = new No();
			no.insertNo(nome, telefone, null, null, null);
			this.raiz = no;
			this.retorno = "Contato inserido com sucesso.";
			
		}else{
		
			 int comparador = 0;
			 comparador = nome.compareTo(no.getValor().getNome());
			 
			 if(comparador < 0){
				 if(no.getEsquerda() != null){
					 insereNoArvore(no.getEsquerda(),nome,telefone);
				 }else{	
					 No novo = new No();			
					 novo.insertNo(nome, telefone, null, null, null);	
					 no.setEsquerda(novo);
					 this.retorno = "Contato inserido com sucesso.";
				 }
			 }else if(comparador > 0){
				 if(no.getEsquerda() != null){
					 insereNoArvore(no.getDireita(),nome,telefone);
				 }else{	
					 No novo = new No();					
					 novo.insertNo(nome, telefone, null, null, null);
					 no.setDireita(novo);
					 this.retorno = "Contato inserido com sucesso.";
				 } 
			 }else{
				 this.retorno = "O contato já existe na base de dados .";
			 }
		}
		
	}
	
	
	public void deletaNoArvore(String nome){
		
	}
	
	public String buscaNoArvore(No no, String nome, String retorno){
		
		 
		 return retorno;
	} 
	
	public void travesiaPrefixada(No no) {
	        
	 	if(no != null){
        	this.retorno += no.getValor().getNome() + " ";
        	travesiaPrefixada(no.getEsquerda());
        	travesiaPrefixada(no.getDireita());
        }
        
	}
	 
	public void travessiaPosfixada(No no) {
		  	
        if(no != null){
        	travessiaPosfixada(no.getEsquerda());
        	travessiaPosfixada(no.getDireita());
        	this.retorno += no.getValor().getNome() + " ";
        }
        
	}
	  
	public void travessiaInfixada(No no) {

        if(no != null){
        	travessiaInfixada(no.getEsquerda());
        	this.retorno += no.getValor().getNome() + " ";
			travessiaInfixada(no.getDireita());
        }
        

	}
	
}
