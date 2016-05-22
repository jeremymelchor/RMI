import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServerLauncher {

    public static void main(String[] args) throws MalformedURLException, RemoteException, UnknownHostException, NotBoundException {

        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        // Création de la base de donnée
        new Database();

        CarManager cm = new CarManager();
        RaceCar rc = new RaceCar(9000);
        Services services = new Services();

        IRegistreUniversel  regU = (IRegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");

        regU.rebind("vendeur", cm);
        regU.rebind("service", services);
        regU.rebind("racecar", rc);

        System.out.println("Serveur lancé");

    }
}
