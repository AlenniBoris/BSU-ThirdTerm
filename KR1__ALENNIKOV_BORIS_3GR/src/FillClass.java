import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FillClass {
    public static ArrayList<Security> getSecurityFromFile(File file) throws IOException {
        Scanner sc = new Scanner(file);
        ArrayList<Security> students = new ArrayList<>();
        while(sc.hasNext()){
            students.add(new Security(sc.next(), sc.next(), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next())));
        }
        return students;
    }

    public static ArrayList<Saleman> getSalemanFromFile(File file) throws IOException {
        Scanner sc = new Scanner(file);
        ArrayList<Saleman> salemen = new ArrayList<>();
        while(sc.hasNext()){
            salemen.add(new Saleman(sc.next(), sc.next(), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next())));
        }
        return salemen;
    }
}
