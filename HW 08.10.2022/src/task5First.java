import java.util.Scanner;

public class task5First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("0+(.+)\\.", "$1.");
        str = str.replaceAll("0+\\.", "0.");
        System.out.println(str);
    }
}
