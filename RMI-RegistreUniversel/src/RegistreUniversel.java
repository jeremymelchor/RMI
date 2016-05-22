import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class RegistreUniversel extends UnicastRemoteObject implements IRegistreUniversel {

    Hashtable<String, Object> registry;

    public RegistreUniversel() throws RemoteException {
        super();
        registry = new Hashtable<String,Object>();
    }

    public RegistreUniversel(int port) throws RemoteException{
        super(port);
        registry = new Hashtable<String,Object>();

    }

    @Override
    public boolean rebind(String url, Object object) throws RemoteException{
        registry.put(url, object);
        return true;
    }

    @Override
    public Object lookup(String url) throws RemoteException {
        return registry.get(url);
    }

    @Override
    public void unbind(String url) throws RemoteException {
        registry.remove(url);
    }

    @Override
    public String[] list() throws RemoteException {
        String tab[] = new String [registry.size()];
        int i = 0;
        for (String s : registry.keySet()) {
            tab[i] = s;
            i++;
        }
        return tab;

    }
}
