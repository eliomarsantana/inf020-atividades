import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculaInterface  extends Remote{
	public void somar(int x, int y) throws RemoteException;	
	public void subtrair(int x, int y) throws RemoteException;	
	public void multiplicar(int x, int y) throws RemoteException;
	public void dividir(int x, int y) throws RemoteException;
}
