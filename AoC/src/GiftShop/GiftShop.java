package GiftShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiftShop {
    public static void main(String[] args) {
        try {
            File file = new File("src/GiftShop/input.txt");
            Scanner scanner = new Scanner(file);
            String[] strs = scanner.nextLine().split(",");
            long returnVal = 0L;
            for (int i = 0; i < strs.length; i++){
                long right = Long.parseLong(strs[i].split("-")[1]);
                for (long left = Long.parseLong(strs[i].split("-")[0]); left <= right; left++){
                    String value = Long.toString(left);
                    for (int j = value.length()/2; j > 0; j--){
                        String[] splitVal = value.split(value.substring(0, j));
                        if (allSameChecker(splitVal)){
                            j = 0;
                            returnVal += left;
                        }
                    }
                }
            }
            System.out.println(returnVal);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public static boolean allSameChecker(String[] splitVal){
        for (int i = 1; i < splitVal.length; i++){
            if (!splitVal[0].equals(splitVal[i])){
                return false;
            }
        }
        return true;
    }
}
