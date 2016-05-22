import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public class ClientLauncher {

    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException {

        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        IRegistreUniversel reg = (IRegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");
        IServices service = (IServices) reg.lookup("service");

        ArrayList<Car> l = service.trierParPrixInfereieurA(10000000);
        System.out.println(l);
    }
}
