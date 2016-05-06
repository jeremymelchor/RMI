package serveur.vendeur;

import java.io.Serializable;


public class Car implements Serializable {

    private int annee;
    private int prix;
    private String modele;
    private String marque;
    private String carburant;
    private String couleur;

    public Car(String modele, String marque, String carburant, String couleur, int annee, int prix) {
        this.annee = annee;
        this.prix = prix;
        this.modele = modele;
        this.marque = marque;
        this.carburant = carburant;
        this.couleur = couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getCarburant() {
        return carburant;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getAnnee() {
        return annee;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (annee != car.annee) return false;
        if (!modele.equals(car.modele)) return false;
        if (!marque.equals(car.marque)) return false;
        if (!carburant.equals(car.carburant)) return false;
        return couleur.equals(car.couleur);

    }

    @Override
    public int hashCode() {
        int result = annee;
        result = 31 * result + modele.hashCode();
        result = 31 * result + marque.hashCode();
        result = 31 * result + carburant.hashCode();
        result = 31 * result + couleur.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "annee=" + annee +
                ", prix=" + prix +
                ", modele='" + modele + '\'' +
                ", marque='" + marque + '\'' +
                ", carburant='" + carburant + '\'' +
                ", couleur='" + couleur + '\'' +
                '}';
    }

}
