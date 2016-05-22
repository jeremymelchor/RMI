import java.util.Enumeration;
import java.util.Hashtable;

public class Database {

    private static Hashtable<Car,Integer> database;

    public Database() {
        database = new Hashtable<>();
    }

    public static Hashtable<Car, Integer> getDatabase() {
        return database;
    }

    @Override
    public String toString() {
        String result = "";
        Enumeration e = database.keys();
        while (e.hasMoreElements()) {
            Car key = (Car) e.nextElement();
            result += key + " : " + database.get(key) + "\n";
        }
        return result;
    }
}
