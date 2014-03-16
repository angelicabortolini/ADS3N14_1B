package br.com.angelica.listatelefonica.model;

public class Nodo<T> {

	private T  dado;
	private Nodo<T> next;
	private Nodo<T> preview;

	public Nodo(T i)
	{
		dado = i;
		next = null;
		preview = null;
	}
	
	public void setData(T i)
	{
		dado = i;
		next = null;
		preview = null;
	}
	
	public T getData()
	{
		return dado;
	}

	public void setNext(Nodo<T> next)
	{
		this.next = next;
	}
	
	public Nodo<T> getNext()
	{
		return next;
	}

	public Nodo<T> getPreview() {
		return preview;
	}

	public void setPreview(Nodo<T> preview) {
		this.preview = preview;
	}
	
}
