package Lobby;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Lobby {
    public static void main(String[] args) {
        try {
            File file = new File("src/Lobby/input.txt");
            Scanner scanner = new Scanner(file);
            long total = 0L;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                int[] jolts = new int[12];
                for (int i = 0; i < 12; i++){
                    jolts[11-i] = (line.charAt(line.length()-1)) - '0';
                    line = line.substring(0, line.length()-1);
                }
                while (!line.isEmpty()) {
                    StringBuilder jolt = new StringBuilder();
                    for (int j : jolts) {
                        jolt.append(j);
                    }
                    int digit = (line.charAt(line.length()-1)) - '0';
                    if (digit >= jolts[0]){
                        int temp = jolts[0];
                        for (int i = 1; i < jolts.length; i++){
                            if (jolts[i] <= temp){
                                int temp2 = temp;
                                temp = jolts[i];
                                jolts[i] = temp2;
                            } else  {
                                i = jolts.length;
                            }
                        }
                        jolts[0] = digit;
                    }
                    line = line.substring(0, line.length()-1);
                }
                StringBuilder jolt = new StringBuilder();
                for (int j : jolts) {
                    jolt.append(j);
                }
                total += Long.parseLong(jolt.toString());
            }
            System.out.println(total);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
