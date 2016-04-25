package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarManager extends UnicastRemoteObject implements ICarManager {

    protected CarManager() throws RemoteException {}

    @Override
    public void addCar(String modele) throws RemoteException {
        System.out.println("I added a new car : "+modele);
    }
}
