package serveur.acheteur;

import serveur.CarburantEnum;
import serveur.CouleurEnum;
import serveur.Database;
import serveur.MarqueEnum;
import serveur.vendeur.Car;

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
    public String trierParModele(String modele) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getModele().equals(modele))
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParMarque(MarqueEnum marque) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getMarque().equals(marque.getMarque()))
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParCouleur(CouleurEnum couleur) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getCouleur().equals(couleur.getCouleur()))
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParCarburant(CarburantEnum carburant) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getCarburant().equals(carburant.getCarburant()))
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParDate(int annee) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getAnnee() == annee)
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParPrix(int prix) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getPrix() == prix)
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParPrixSuperieurA(int prix) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getPrix() >= prix)
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParPrixInfereieurA(int prix) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getPrix() <= prix)
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String tierParDateInferieurA(int annee) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getAnnee() <= annee)
                result.add(key);
        }
        return getResult(result);
    }

    @Override
    public String trierParDateSuperieureA(int annee) throws RemoteException {
        ArrayList<Car> result = new ArrayList<>();
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            if (key.getAnnee() >= annee)
                result.add(key);
        }
        return getResult(result);
    }

    private String getResult(ArrayList<Car> list) {
        String result = "";
        if (list.isEmpty())
            return "Aucun élément ne correspond à votre recherche";
        for (Car c : list)
            result += c.toString() + "\n";
        return result;
    }
}
