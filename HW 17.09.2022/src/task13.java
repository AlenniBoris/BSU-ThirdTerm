import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class task13 {

    public static void main(String[] args){
        usualArr();
        listArr();
    }

    static void usualArr(){
        int[] arr = new int[20];
        int[] finArr = new int[6];
        int numElem;
        int min = 1, max = 49;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*((max - min) + 1) + min);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            max = arr.length - 1;
            numElem = (int) (Math.random()*(max + 1));
            finArr[i] = arr[numElem];
        }
        Arrays.sort(finArr);
        System.out.print(Arrays.toString(finArr));
    }

    static void listArr(){
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> finArr = new ArrayList<>();
        int min = 1, max = 49;
        for (int i = 0; i < 20; i++) {
            arr.add((int) (Math.random()*((max - min) + 1) + min));
        }
        for (int i = 1; i < 7; ++i){
            max = arr.size() - 1;
            int numElem;
            numElem = (int) (Math.random()*(max + 1));
            finArr.add(arr.get(numElem));
        }
        System.out.print(arr);
        System.out.println();
        Collections.sort(finArr);
        System.out.print(finArr);
    }
}
