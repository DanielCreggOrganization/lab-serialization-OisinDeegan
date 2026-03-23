package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> films = new ArrayList<>();
        films.add(new Movie("Tumbling Tea", "Oisin Deegan", 2025, 10.0));
        films.add(new Movie("Batman", "Bruce Wayne", 1932, 8.7));
        films.add(new Movie("1wdqwdwsaf", "Random man", 2077, 6.9));
        System.out.println("Original catalog:");
        films.forEach(System.out::println);

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("resources/weekend_screening.ser"))) {
            out.writeObject(films);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Movie> weekendScreening = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("resources/weekend_screening.ser"))) {
            weekendScreening = (List<Movie>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nDeserialized catalog:");
        weekendScreening.forEach(System.out::println);

        Bankaccount credit = new Bankaccount("6769420", "Saxton Hale", 1000000000, "drowssap");

        System.out.println(credit);

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("resources/account.ser"))) {
            out.writeObject(credit);
            System.out.println("Account has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("resources/account.ser"))) {
            Bankaccount deserializedUser = (Bankaccount) in.readObject();
            System.out.println("User has been deserialized");
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Game> BotW = new ArrayList<>();
        BotW.add(new Game("Oisin", 12378612, 3));
        BotW.add(new Game("Sonic Boom", 123456789, 1));

        String filename = "resources/Game_saves.ser";
        System.out.println("Original Saves (Version 1):");
        BotW.forEach(System.out::println);
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(BotW);
            System.out.println("\nGame saves have been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            List<Game> loadedGames = (List<Game>) in.readObject();
            System.out.println("Game saves have been deserialized");
            loadedGames.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}