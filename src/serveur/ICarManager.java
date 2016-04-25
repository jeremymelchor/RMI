package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarManager extends Remote {

    void addCar(String modele) throws RemoteException;
}
