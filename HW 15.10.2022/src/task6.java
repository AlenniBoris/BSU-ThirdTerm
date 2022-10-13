import java.util.Scanner;

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
        System.out.println("Element " + a.firstTask());
        System.out.println("Number equals " + a.secondTask());
        System.out.println("Number bigger " + a.thirdTask());
        System.out.println("Number sum " + a.fourthTask());
        System.out.println("Arithm num " + a.fifthTask());
    }

}
