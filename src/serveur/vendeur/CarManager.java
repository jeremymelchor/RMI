package serveur.vendeur;

import serveur.CarburantEnum;
import serveur.CouleurEnum;
import serveur.Database;
import serveur.MarqueEnum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class CarManager extends UnicastRemoteObject implements ICarManager {

    private Database db = new Database();
    private Hashtable<Car,Integer> database = db.getDatabase();
    private CouleurEnum enumColor;

    public CarManager() throws RemoteException {
        super();
    }

    @Override
    public String ajouter(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix) throws RemoteException {
        Car newCar = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee,prix);
        if (database.containsKey(newCar)) {
            int count = database.get(newCar);
            database.put(newCar,++count);
        }
        else database.put(newCar,1);
        return "Voiture ajoutée\n";
    }

    @Override
    public String supprimer(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix) throws RemoteException {
        Car delete = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee, prix);
        if (database.containsKey(delete) && database.get(delete) > 1) {
            int count = database.get(delete);
            database.put(delete,--count);
        }
        else database.remove(delete);
        return "Voiture supprimée\n";
    }

    @Override
    public String updateModele(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newModele) throws RemoteException {
        Car modify = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee, prix);
        if (database.containsKey(modify)) {
            int count = database.get(modify);
            database.remove(modify);
            modify.setModele(newModele);
            database.put(modify,count);
            return "Modification effectuée\n";
        }
        else return "La voiture renseignée n'existe pas !\n";
    }

    @Override
    public String updateCouleur(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newCouleur) throws RemoteException {
        Car modify = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee,prix);
        if (database.containsKey(modify)) {
            int count = database.get(modify);
            database.remove(modify);
            modify.setCouleur(newCouleur);
            database.put(modify,count);
            return "Modification effectuée\n";
        }
        else return "La voiture renseignée n'existe pas !\n";
    }


    @Override
    public String updateMarque(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newMarque) throws RemoteException {
        Car modify = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee,prix);
        if (database.containsKey(modify)) {
            int count = database.get(modify);
            database.remove(modify);
            modify.setMarque(newMarque);
            database.put(modify,count);
            return "Modification effectuée\n";
        }
        else return "La voiture renseignée n'existe pas !\n";
    }

    @Override
    public String updateCarburant(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newCarburant) throws RemoteException {
        Car modify = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee,prix);
        if (database.containsKey(modify)) {
            int count = database.get(modify);
            database.remove(modify);
            modify.setCarburant(newCarburant);
            database.put(modify,count);
            return "Modification effectuée\n";
        }
        else return "La voiture renseignée n'existe pas !\n";
    }

    @Override
    public String updateAnnee(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, int newAnnee) throws RemoteException {
        Car modify = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee,prix);
        if (database.containsKey(modify)) {
            int count = database.get(modify);
            database.remove(modify);
            modify.setAnnee(newAnnee);
            database.put(modify,count);
            return "Modification effectuée\n";
        }
        else return "La voiture renseignée n'existe pas !\n";
    }

    @Override
    public String updatePrix(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, int newPrix) throws RemoteException {
        Car modify = new Car(modele,marque.getMarque(),carburant.getCarburant(),couleur.getCouleur(),annee,prix);
        if (database.containsKey(modify)) {
            int count = database.get(modify);
            database.remove(modify);
            modify.setPrix(newPrix);
            database.put(modify,count);
            return "Modification effectuée\n";
        }
        else return "La voiture renseignée n'existe pas !\n";
    }

    @Override
    public String getListCar() throws RemoteException {
        return database.toString();
    }
}
