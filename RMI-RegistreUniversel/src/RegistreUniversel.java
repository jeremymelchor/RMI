import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class RegistreUniversel extends UnicastRemoteObject implements IRegistreUniversel {

    Hashtable<String, Object> registry;
    Stack results = new Stack();
    Stack keys = new Stack();
    Hashtable<String,Integer> popularity = new Hashtable<>();

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
        results.push(object);
        keys.push(url);
        return true;
    }

    @Override
    public Object lookup(String url) throws RemoteException {
        if (popularity.containsKey(url)) {
            int count = popularity.get(url);
            popularity.put(url,++count);
        }
        else popularity.put(url,1);

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

    @Override
    public List<Object> getLastXResults(int nbKeys) {
        List<Object> result = new ArrayList<>();
        for (int i=0; i < nbKeys; i++) {
            if (results.isEmpty()) break;
            result.add(results.pop());
        }
        System.out.println(result);
        return result;
    }

    @Override
    public List<String> getLastXKeys(int nbKeys) throws RemoteException {
        List<String> result = new ArrayList<>();
        for (int i=0; i < nbKeys; i++) {
            if (keys.isEmpty()) break;
            result.add((String) keys.pop());
        }
        System.out.println(result);
        return result;
    }

    @Override
    public Hashtable<String, Integer> getPopularKeys() throws RemoteException {
        return popularity;
    }
}
