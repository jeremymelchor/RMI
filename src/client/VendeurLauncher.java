package client;

import serveur.CarburantEnum;
import serveur.CouleurEnum;
import serveur.MarqueEnum;
import serveur.vendeur.ICarManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class VendeurLauncher {

    public static void main(String args[]) throws RemoteException, NotBoundException {

        Registry reg = LocateRegistry.getRegistry();
        ICarManager interf = (ICarManager) reg.lookup("vendeur");
        interf.ajouter("406", MarqueEnum.AUDI, CarburantEnum.DIESEL, CouleurEnum.BLEU,1999,20);
        System.out.println(interf.getListCar());
    }
}
