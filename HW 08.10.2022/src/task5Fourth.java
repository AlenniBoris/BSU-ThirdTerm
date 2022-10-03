import java.util.Scanner;

public class task5Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("(ing)\\b", "ed");
        System.out.println(str);
    }
}
