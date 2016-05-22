import java.io.Serializable;


public class Car implements Serializable {

    private int annee;
    private int prix;
    private String marque;
    private String carburant;
    private String couleur;

    public Car() {}

    public void setCouleur(CouleurEnum couleur) {
        this.couleur = couleur.getCouleur();
    }

    public void setCarburant(CarburantEnum carburant) {
        this.carburant = carburant.getCarburant();
    }

    public void setMarque(MarqueEnum marque) {
        this.marque = marque.getMarque();
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
        if (prix != car.prix) return false;
        if (marque != null ? !marque.equals(car.marque) : car.marque != null) return false;
        if (carburant != null ? !carburant.equals(car.carburant) : car.carburant != null) return false;
        return couleur != null ? couleur.equals(car.couleur) : car.couleur == null;

    }

    @Override
    public int hashCode() {
        int result = annee;
        result = 31 * result + prix;
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        result = 31 * result + (carburant != null ? carburant.hashCode() : 0);
        result = 31 * result + (couleur != null ? couleur.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "annee=" + annee +
                ", prix=" + prix +
                ", marque='" + marque + '\'' +
                ", carburant='" + carburant + '\'' +
                ", couleur='" + couleur + '\'' +
                '}';
    }

}
