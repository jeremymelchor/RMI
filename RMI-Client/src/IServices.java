import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface IServices extends Remote {

    ArrayList<Car> trierParMarque(MarqueEnum marque) throws RemoteException;
    ArrayList<Car> trierParCouleur(CouleurEnum couleur) throws RemoteException;
    ArrayList<Car> trierParCarburant(CarburantEnum carburant) throws RemoteException;

    ArrayList<Car> trierParPrix(int prix) throws RemoteException;
    ArrayList<Car> trierParPrixSuperieurA(int prix) throws RemoteException;
    ArrayList<Car> trierParPrixInfereieurA(int prix) throws RemoteException;

    ArrayList<Car> trierParDate(int annee) throws RemoteException;
    ArrayList<Car> trierParDateSuperieureA(int annee) throws RemoteException;
    ArrayList<Car> tierParDateInferieurA(int annee) throws RemoteException;
}
