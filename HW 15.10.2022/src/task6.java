import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        String[] arr = new String[10];

        System.out.print("Fill your array:");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }

        System.out.print("Enter element for search = ");
        String srchSymb = sc.next();

        showExist(arr, srchSymb);
        showEquals(arr, srchSymb);
    }



    public static void showExist(String[] arr, String symb){
        System.out.println("Your symbol " + existCheck(arr, symb));
    }

    public static String existCheck(String[] arr, String symb){
        for (String s : arr) {
            if (s.equals(symb)) {
                return "exists";
            }
        }
        return "doesn't exist";
    }

    public static void showEquals(String[] arr, String symb){
        System.out.println("Number of equals " + equalsCheck(arr, symb));
    }

    public static int equalsCheck(String[] arr, String symb){
        int res = 0;
        for (String s : arr) {
            if (s.equals(symb)) {
                ++res;
            }
        }
        return res;
    }

}
