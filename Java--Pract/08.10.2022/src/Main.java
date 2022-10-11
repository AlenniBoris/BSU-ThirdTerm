import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        solveRs("C:\\Proga for BSU\\BSU-Third\\Java--Pract\\08.10.2022\\input.txt");
    }

    public static double solveRs(String file) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(file));
        sc.useLocale(Locale.US);
        sc.useDelimiter(".");
        double res = 0;
        while(sc.hasNext()){
            String nextStr = sc.next();
            if (nextStr.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                res += Double.parseDouble(nextStr);
            }
        }

        return res;
    }
}
