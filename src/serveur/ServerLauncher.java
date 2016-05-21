package serveur;

import serveur.acheteur.Services;
import serveur.vendeur.CarManager;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerLauncher {

    public static void main(String[] args) throws MalformedURLException, RemoteException, UnknownHostException {

        CarManager cm = new CarManager();
        Services services = new Services();
        //Registry reg = LocateRegistry.getRegistry(1099);
        Registry reg = LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/vendeur", cm);
        //reg.rebind("vendeur", cm);
        //reg.rebind("client",services);

        System.setProperty("java.security.policy","file:./security.policy");
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        //inscription du registre universel
        //Naming.rebind("rmi://localhost:1099/registreuniversel", ru);

        System.out.println("Serveur lancé");

    }
}
