import java.util.Arrays;

public class StackWithObjectArray<E> {
    private Object[] arr;
    private int size = 0;

    public StackWithObjectArray(int sizeArr) {
        arr = new Object[sizeArr];
    }

    public void push(E value){
        if (size == arr.length){
            int newSize = arr.length * 2;
            arr = Arrays.copyOf(arr, newSize);
        }
        arr[size++] = value;
    }

    public E pop(){
        return (E) arr[--size];
    }

    public boolean isEmpty(){
        return arr.length == 0;
    }
}
