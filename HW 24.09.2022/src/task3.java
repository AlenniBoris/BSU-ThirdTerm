import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class task3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.trim();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str.split(" ")));
        System.out.println(arr);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() == 1) {
                arr.remove(i);
                --i;
            }
        }
        str = String.join("", arr);
        System.out.println(str);
    }
}
