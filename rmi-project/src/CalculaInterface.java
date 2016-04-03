import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculaInterface  extends Remote{
	public abstract int somar(int x, int y) throws RemoteException;	
	public abstract  int subtrair(int x, int y) throws RemoteException;	
	public abstract  int multiplicar(int x, int y) throws RemoteException;
	public abstract  int dividir(int x, int y) throws RemoteException;
}
