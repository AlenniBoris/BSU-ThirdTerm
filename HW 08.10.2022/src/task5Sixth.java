import java.util.Scanner;

public class task5Sixth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("\\b(\\d+)\\b", "");
        System.out.println(str);
    }
}
