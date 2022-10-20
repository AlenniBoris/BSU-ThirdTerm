import java.util.ArrayList;

public class StackWithList<E> {
    private ArrayList<E> arr;

    StackWithList(){
        arr = new ArrayList<>();
    }

    public void push(E value){
        arr.add(value);
    }

    public E pop(){
        return arr.remove(arr.size() - 1);
    }

    public boolean isEmpty(){
        return arr.isEmpty();
    }
}
