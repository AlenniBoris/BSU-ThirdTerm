import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str.split("\\.|,|\\s")));

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i).substring(0,1).toUpperCase() + arr.get(i).substring(1) + " ");
        }
        System.out.println();
        System.out.println(arr);
    }
}
