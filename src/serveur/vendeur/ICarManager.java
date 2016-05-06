package serveur.vendeur;

import serveur.CarburantEnum;
import serveur.CouleurEnum;
import serveur.MarqueEnum;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarManager extends Remote {

    String ajouter(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix) throws RemoteException;
    String supprimer(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix) throws RemoteException;

    String updateModele(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newModele) throws RemoteException;
    String updateMarque(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newMarque) throws RemoteException;
    String updateCarburant(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newCarburant) throws RemoteException;
    String updateCouleur(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, String newCouleur) throws RemoteException;
    String updateAnnee(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, int newAnnee) throws RemoteException;
    String updatePrix(String modele, MarqueEnum marque, CarburantEnum carburant, CouleurEnum couleur, int annee, int prix, int newPrix) throws RemoteException;

    String getListCar() throws RemoteException;
}

