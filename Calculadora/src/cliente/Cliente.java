package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {

	     Socket cliente = new Socket("127.0.0.1", 5000); 
	     Scanner teclado = new Scanner(System.in);
	     PrintStream saida = new PrintStream(cliente.getOutputStream());
	     
	     System.out.println("Escolha uma opção:\n1 - Somar\n2-Subtrair\n3-Multiplicar\n4-Dividir");
	     
	     while (teclado.hasNextLine()) 
	       saida.println(teclado.nextLine());

	     saida.close();
	     teclado.close();
	     cliente.close();

	   }
}
