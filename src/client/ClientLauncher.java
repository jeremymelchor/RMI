package client;

import serveur.CouleurEnum;
import serveur.acheteur.IServices;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClientLauncher {

    public static void main(String args[]) throws RemoteException, NotBoundException {

        Registry reg = LocateRegistry.getRegistry();
        IServices interf = (IServices) reg.lookup("client");
        System.out.println(interf.trierParCouleur(CouleurEnum.));
    }
}
