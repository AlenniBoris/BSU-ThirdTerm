import java.util.Scanner;
import java.util.ArrayList;

public class task15 {
    public static void main(String[] args){
        usualArr();
    }

    static void usualArr(){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[30];
        System.out.println("Enter number of rows");
        int numRow = sc.nextInt();
        for (int i = 0; i < numRow; i++) {
            for (int k = numRow; k > i; k--) {
                System.out.print(" ");
            }
            arr[i] = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i] + " ");
                arr[i] = arr[i] * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> listArr(int n) {
        ArrayList<ArrayList<Integer>> finArr = new ArrayList<>();
        if (n == 0)
            return finArr;
        if (n < 0)
            throw new IllegalArgumentException();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        finArr.add(row);
        int k = 2;
        for (int i = 1; i < n; ++i) {
            ArrayList<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 1; j < k - 1; ++j) {
                level.add(finArr.get(i - 1).get(j - 1) + finArr.get(i - 1).get(j));
            }
            level.add(1);
            finArr.add(level);
            ++k;
        }
        return finArr;
    }
}
