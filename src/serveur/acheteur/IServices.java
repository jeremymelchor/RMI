package serveur.acheteur;

import serveur.CarburantEnum;
import serveur.CouleurEnum;
import serveur.MarqueEnum;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IServices extends Remote {

    String trierParModele(String modele) throws RemoteException;
    String trierParMarque(MarqueEnum marque) throws RemoteException;
    String trierParCouleur(CouleurEnum couleur) throws RemoteException;
    String trierParCarburant(CarburantEnum carburant) throws RemoteException;

    String trierParPrix(int prix) throws RemoteException;
    String trierParPrixSuperieurA(int prix) throws RemoteException;
    String trierParPrixInfereieurA(int prix) throws RemoteException;

    String trierParDate(int annee) throws RemoteException;
    String trierParDateSuperieureA(int annee) throws RemoteException;
    String tierParDateInferieurA(int annee) throws RemoteException;
}
