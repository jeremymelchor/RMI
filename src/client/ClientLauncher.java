package client;

import serveur.ICarManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientLauncher {

    public static void main(String args[]) throws RemoteException, NotBoundException {

        Registry reg = LocateRegistry.getRegistry();
        ICarManager interf = (ICarManager) reg.lookup("test");
        interf.addCar("ferrari");
    }
}
