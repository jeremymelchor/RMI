import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.List;

public interface IRegistreUniversel extends Remote{

    boolean rebind(String url, Object object) throws RemoteException;

    Object lookup(String url) throws RemoteException;

    void unbind(String url) throws RemoteException;

    String [] list() throws RemoteException;

    List<Object> getLastXResults(int nbKeys) throws RemoteException;

    List<String> getLastXKeys(int nbKeys) throws RemoteException;

    Hashtable<String,Integer> getPopularKeys() throws RemoteException;
}
