import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class RmiServer extends java.rmi.server.UnicastRemoteObject implements CalculaInterface
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int      thisPort;
    String   thisAddress;
    Registry registry;    // rmi registry for lookup the remote objects.

    public void exibirSoma(){
    	
    }

    public RmiServer() throws RemoteException
    {
        try{
            // get the address of this host.
            thisAddress= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }
		thisPort=3232;  // this port(registrys port)
        System.out.println("this address="+thisAddress+",port="+thisPort);
        try{
        // create the registry and bind the name and object.
        registry = LocateRegistry.createRegistry( thisPort );
            registry.rebind("rmiServer", this);
        }
        catch(RemoteException e){
        throw e;
        }
    }
   
    static public void main(String args[])
    {
        try{
        RmiServer s=new RmiServer();
    }
    catch (Exception e) {
           e.printStackTrace();
           System.exit(1);
    }
     }

	public void somar(int x, int y) throws RemoteException {
		System.out.println("Soma: "+ (x + y));
	}

	public void subtrair(int x, int y) throws RemoteException {
		System.out.println("Subtracao: "+ (x - y));
	}

	public void multiplicar(int x, int y) throws RemoteException {
		System.out.println("Multiplicacao: "+ (x * y));
	}

	public void dividir(int x, int y) throws RemoteException {
		System.out.println("Divisao: "+ (x / y));
	}
}
