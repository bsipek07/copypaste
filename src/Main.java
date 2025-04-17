import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {


        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Unesite putanju:");
            String putanja = input.nextLine();
            FileInputStream inputFile = new FileInputStream(putanja);
            FileOutputStream outputFile = new FileOutputStream("C:\\Users\\PC\\Downloads\\probacopy.txt");
            if(!inputFile.exist()){
                throw new FileNotFoundException("Datoteka ne postoji");
            }
            if(!inputFile.canRead() || !inputFile.canWrite()){
                throw  new SecurityException("Nemate pravo pristupa toj datoteci");
            }

            byte[] buffer = new byte[1024];
            int c;
            while((c=inputFile.read(buffer))!=-1)outputFile.write(buffer, 0, c);

            if(outputFile.exist() && inputFile.lenght()==outputFile.lenght()){
                System.out.println("datoteka je uspjesno kopirana");
                outputFile.delete();
            }
            inputFile.close();
            outputFile.close();
            input.close();
        }catch (SecurityException e){
            System.out.println(e.getMessage());
        }catch (FileNotFoundException se){
            System.out.println(se.getMessage());
        }

    }
}
