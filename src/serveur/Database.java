package serveur;

import serveur.vendeur.Car;

import java.util.Hashtable;

/**
 * Created by melchor on 05/05/2016.
 */
public class Database {

    private static Hashtable<Car,Integer> database;

    public Database() {
        database = new Hashtable<>();
    }

    public static Hashtable<Car, Integer> getDatabase() {
        return database;
    }
}
