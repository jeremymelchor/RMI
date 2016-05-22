import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.List;

public interface ICarManager extends Remote {

    void ajouter(Car car) throws RemoteException;
    boolean supprimer(Car car) throws RemoteException;

    Car updateMarque(Car car, MarqueEnum marque) throws RemoteException;
    Car updateCarburant(Car car, CarburantEnum carburant) throws RemoteException;
    Car updateCouleur(Car car, CouleurEnum couleur) throws RemoteException;
    Car updateAnnee(Car car, int annee) throws RemoteException;
    Car updatePrix(Car car, int prix) throws RemoteException;

    List<Car> getListCar() throws RemoteException;
    String getDatabase() throws RemoteException;
    Car getCar(Car car) throws RemoteException;
}

