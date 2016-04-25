package serveur;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerLauncher {

    public static void main(String[] args) throws MalformedURLException, RemoteException, UnknownHostException {

        CarManager cm = new CarManager();
        Registry reg = LocateRegistry.getRegistry(1099);
        reg.rebind("test", cm);

        System.out.println("Serveur lancé");

    }
}
