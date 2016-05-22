import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class CarManager extends UnicastRemoteObject implements ICarManager {

    private Hashtable<Car,Integer> database = Database.getDatabase();

    public CarManager() throws RemoteException {
    }

    @Override
    public void ajouter(Car car) throws RemoteException {
        if (database.containsKey(car)) {
            int count = database.get(car);
            database.put(car,++count);
        }
        else database.put(car,1);
    }

    @Override
    public boolean supprimer(Car car) throws RemoteException {
        if (database.containsKey(car) && database.get(car) > 1) {
            int count = database.get(car);
            database.put(car,--count);
            return true;
        }
        else if (database.containsKey(car)) {
            database.remove(car);
            return true;
        }
        else return false;
    }

    @Override
    public Car updateMarque(Car car, MarqueEnum marque) throws RemoteException {
        Set<Car> listKey = database.keySet();
        for (Car c : listKey) {
            if (c.equals(car)) {
                car.setMarque(marque);
                ajouter(car);
                supprimer(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public Car updateCarburant(Car car, CarburantEnum carburant) throws RemoteException {
        Set<Car> listKey = database.keySet();
        for (Car c : listKey) {
            if (c.equals(car)) {
                car.setCarburant(carburant);
                ajouter(car);
                supprimer(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public Car updateCouleur(Car car, CouleurEnum couleur) throws RemoteException {
        Set<Car> listKey = database.keySet();
        for (Car c : listKey) {
            if (c.equals(car)) {
                car.setCouleur(couleur);
                ajouter(car);
                supprimer(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public Car updateAnnee(Car car, int annee) throws RemoteException {
        Set<Car> listKey = database.keySet();
        for (Car c : listKey) {
            if (c.equals(car)) {
                car.setAnnee(annee);
                ajouter(car);
                supprimer(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public Car updatePrix(Car car, int prix) throws RemoteException {
        Set<Car> listKey = database.keySet();
        for (Car c : listKey) {
            if (c.equals(car)) {
                car.setPrix(prix);
                ajouter(car);
                supprimer(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public Car getCar(Car car) throws RemoteException {
        Set<Car> listKey = database.keySet();
        for (Car c : listKey) {
            if (c.equals(car)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Car> getListCar() throws RemoteException {
        List<Car> result = new ArrayList<>();
        result.addAll(database.keySet());
        return result;
    }

    @Override
    public String getDatabase() throws RemoteException {
        return Database.getDatabase().toString();
    }
}
