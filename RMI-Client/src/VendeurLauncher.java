import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class VendeurLauncher {

    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException {

        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        IRegistreUniversel reg = (IRegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");
        ICarManager cm = (ICarManager) reg.lookup("vendeur");

        /******************** TEST DES SERVICES ************************/

        Car a = new Car();
        a.setPrix(10000);
        a.setMarque(MarqueEnum.AUDI);
        a.setAnnee(2010);
        a.setCouleur(CouleurEnum.BLANC);
        a.setCarburant(CarburantEnum.DIESEL);

        cm.ajouter(a);

        Car b = new Car();
        b.setPrix(10000);
        b.setMarque(MarqueEnum.BMW);
        b.setAnnee(2010);
        b.setCouleur(CouleurEnum.BLANC);
        b.setCarburant(CarburantEnum.DIESEL);

        cm.ajouter(b);

        //cm.updateMarque(cm.getCar(a),MarqueEnum.CITROEN);

        System.out.println("\n"+cm.getDatabase());

        // Pour montrer que l'ajout d'objet directement dans le registre marche
        reg.rebind("voiture1",a);
        System.out.println(reg.lookup("voiture1"));

        Car car = (Car) reg.lookup("racecar");
        System.out.println(car.toString());
    }
}
