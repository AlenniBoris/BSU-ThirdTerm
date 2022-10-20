import java.lang.reflect.Array;
import java.util.Arrays;

public class StackWithArray<E> {
    private E[] arr;
    private int size = 0;

    public StackWithArray(int sizeArr) {
        Object[] genericArray = new Object[sizeArr];
        arr = (E[])genericArray;
    }

    public void push(E value){
        if (size == arr.length){
            int newSize = arr.length * 2;
            arr = Arrays.copyOf(arr, newSize);
        }
        arr[size++] = value;
    }

    public E pop(){
        return arr[--size];
    }

    public boolean isEmpty(){
        return arr.length == 0;
    }
}
