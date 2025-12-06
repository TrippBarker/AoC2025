package SecretEntrance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecretEntrance {
    public static void main(String[] args){
        try {
            File file = new File("src/SecretEntrance/testInput.txt");
            Scanner scanner = new Scanner(file);
            int val = 50;
            int counter = 0;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                char dir = line.charAt(0);
                int delta = Integer.parseInt(line.substring(1));
                
            }
            System.out.println(counter);
            scanner.close();
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }
}
