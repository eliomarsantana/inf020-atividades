package servidor;

public class Calculadora {
	
	public int somar(int x, int y) {
		return x + y;
	}
	
	public int subtrair(int x, int y) {
		return x - y;
	}
	
	public int multiplicar(int x, int y) {
		return x * y;
	}
	
	public int dividir(int x, int y) {
		int resultado = 0;
		
		try {
			resultado = x / y;
		}catch(NumberFormatException ex) {
			ex.printStackTrace();
		}
		
		return resultado;
	}
}
