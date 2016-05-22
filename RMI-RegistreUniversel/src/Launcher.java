import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Launcher {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        Registry reg = LocateRegistry.createRegistry(1098);

        IRegistreUniversel ru = new RegistreUniversel();

        Naming.rebind("rmi://localhost:1098/registreuniversel", ru);
    }
}
