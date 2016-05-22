import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Services extends UnicastRemoteObject implements IServices {

    private Hashtable<Car,Integer> database = Database.getDatabase();

    public Services() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Car> trierParMarque(MarqueEnum marque) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        System.out.println(e);
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getMarque().equals(marque.getMarque())) {
                result.add(key);
                System.out.println("PAREIL !");
            }
        }
        return result;
    }

    @Override
    public ArrayList<Car> trierParCouleur(CouleurEnum couleur) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getCouleur().equals(couleur.getCouleur()))
                result.add(key);
        }
        return result;
    }

    @Override
    public ArrayList<Car> trierParCarburant(CarburantEnum carburant) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getCarburant().equals(carburant.getCarburant()))
                result.add(key);
        }
        return result;
    }

    @Override
    public ArrayList<Car> trierParDate(int annee) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getAnnee() == annee)
                result.add(key);
        }
        return result;
    }

    @Override
    public ArrayList<Car> trierParPrix(int prix) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getPrix() == prix)
                result.add(key);
        }
        return result;
    }

    @Override
    public ArrayList<Car> trierParPrixSuperieurA(int prix) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getPrix() >= prix)
                result.add(key);
        }
        return result;
    }

    @Override
    public ArrayList<Car> trierParPrixInfereieurA(int prix) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getPrix() <= prix)
                result.add(key);
        }
        return result;
    }

    @Override
    public ArrayList<Car> tierParDateInferieurA(int annee) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getAnnee() <= annee)
                result.add(key);
        }
        return result;
    }

    @Override
    public ArrayList<Car> trierParDateSuperieureA(int annee) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getAnnee() >= annee)
                result.add(key);
        }
        return result;
    }
}
