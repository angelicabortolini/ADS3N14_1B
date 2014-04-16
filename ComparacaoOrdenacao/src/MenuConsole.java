import java.util.Scanner;


public class MenuConsole {

	/**
	 * Construtor padrão.
	 */
	public MenuConsole() { }
	
	public String cursor(String dialogo) {
		
		String valor = "";
		System.out.print(dialogo + ": ");
		@SuppressWarnings("resource")
		Scanner cursor = new Scanner(System.in);
		valor = cursor.next();
		return valor;
		
	}
	
	public void imprimir(String valor) {
		
		System.out.println(valor);
		
	}
	
	

}
