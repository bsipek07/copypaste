import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Unesite putanju:");
            String putanja = input.nextLine();

            File izvor = new File(putanja);
            File cilj = new File("C:\\Users\\PC\\Downloads\\probacopy.jpeg");


            if (!izvor.exists()) {
                throw new FileNotFoundException("Datoteka ne postoji");
            }
            if (!izvor.canRead()) {
                throw new SecurityException("Nemate pravo čitanja datoteke");
            }

            FileInputStream inputFile = new FileInputStream(izvor);
            FileOutputStream outputFile = new FileOutputStream(cilj);

            byte[] buffer = new byte[1024];
            int c;
            while ((c = inputFile.read(buffer)) != -1) {
                outputFile.write(buffer, 0, c);
            }

            inputFile.close();
            outputFile.close();


            if (cilj.exists() && izvor.length() == cilj.length()) {
                System.out.println("Datoteka je uspješno kopirana.");

                cilj.delete();
            } else {
                System.out.println("Kopiranje nije uspjelo (provjera nije prošla).");
            }

        } catch (SecurityException e) {
            System.out.println(" Sigurnosna greška: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka nije pronađena: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" IO greška: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
