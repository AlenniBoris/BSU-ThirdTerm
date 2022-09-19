import java.util.Scanner;

public class task1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = sc.nextLine();
        str = str.replaceAll("([a-zA-Z]+)0+([1-9]+)", "$1$2");
        str = str.replaceAll("^0+","");
        System.out.println(str);
    }
}
