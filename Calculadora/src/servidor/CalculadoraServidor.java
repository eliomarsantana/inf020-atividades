package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculadoraServidor {

	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor = new ServerSocket(5000);
		Socket cliente = null;
		Scanner s = null;
		int num1;
		int num2;
		Calculadora calculadora = new Calculadora();
		int resultado = 0;
		
		try {
			while (true) {
				cliente = servidor.accept();
				s = new Scanner(cliente.getInputStream());
		
				while (s.hasNextLine()) {
					
					String opcao = s.nextLine().toLowerCase(); 
					num1 = Integer.parseInt(s.nextLine());
					num2 = Integer.parseInt(s.nextLine());
					
					switch(opcao) {
						case "1":
							resultado = calculadora.somar(num1, num2);
						break;
	    		
						case "2":
							resultado = calculadora.subtrair(num1, num2);
						break;
	    		
						case "3":
							resultado = calculadora.multiplicar(num1, num2);
						break;
	    		
						case "4":
							resultado = calculadora.dividir(num1, num2);
						break;
					}
	    	
	    	System.out.println("Resultado:"+ resultado);
	     }

		} 
		}catch(IOException ex) {
		
		}
		finally {
			cliente.close();
			s.close();
		}
	}

}
