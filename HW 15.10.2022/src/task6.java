import java.util.Scanner;
import java.util.function.IntToLongFunction;
import java.util.function.Predicate;

public class task6{

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];

        System.out.print("Fill your array:");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element for search = ");
        int srchSymb = sc.nextInt();

        funcCl a = new funcCl(arr, srchSymb);
        System.out.println("Exist " + a.firstTask());
        System.out.println("Number equals " + a.secondTask());
        System.out.println("Number bigger " + a.thirdTask());
        System.out.println("Number sum " + a.fourthTask());
        System.out.println("Mid num " + a.fifthTask());
        Predicate<Integer> pr = i -> i < 0;
        System.out.println("Predicate check " + a.sixthTask(pr));
    }

}
