package SecretEntrance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecretEntrance {
    public static void main(String[] args) {
        try {
            File file = new File("src/SecretEntrance/input.txt");
            Scanner scanner = new Scanner(file);
            int pos = 50;
            long counter = 0L;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                char dir = line.charAt(0);
                int delta = Integer.parseInt(line.substring(1));
                int fullCycles = delta / 100;
                int rem = delta % 100;
                counter += fullCycles;
                int step = (dir == 'L') ? -1 : 1;
                for (int i = 0; i < rem; i++) {
                    pos += step;
                    if (pos == 100) pos = 0;
                    else if (pos == -1) pos = 99;
                    if (pos == 0) {
                        counter++;
                    }
                }
            }
            System.out.println(counter);
            scanner.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
