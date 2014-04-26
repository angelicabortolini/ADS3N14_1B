package br.com.angelica.arvorebinaria.model;

public class No {

	private Contato valor;
	private No esquerda;
	private No direita;
	private No raiz;
	
	public No(){}
	
	public Contato getValor() {
		return valor;
	}
	
	public void setValor(Contato valor) {
		this.valor = valor;
	}
	
	public No getEsquerda() {
		return esquerda;
	}
	
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	
	public No getDireita() {
		return direita;
	}
	
	public void setDireita(No direita) {
		this.direita = direita;
	}
	
	public No getRaiz() {
		return raiz;
	}
	
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
		
	public void insertNo(String nome, String telefone,No esquerda, No direita, No raiz){
		this.valor = new Contato(nome,telefone);
		this.esquerda = esquerda;
		this.direita = direita;
		this.raiz = raiz;	
	}
}

