package KP_Test_Var;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyCollection<T extends Comparable<T>>{
    private ArrayList<T> collection;

    public MyCollection(ArrayList<T> collection){
        this.collection = collection;
    }

    public T max(){
        Optional<T> val = collection.stream().max(Comparator.naturalOrder());
        return val.get();
    }

    public T min(){
        Optional<T> val = collection.stream().min(Comparator.naturalOrder());
        return val.get();
    }

    public ArrayList<T> getCollection(){
        return collection;
    }


    public void deleteElement(int posInList){
        collection.remove(posInList);
    }


    public String[] toArray(){
        String[] arr = new String[collection.size()];
        for (int i = 0; i < collection.size(); ++i){
            arr[i] = collection.get(i).toString();
        }
        return arr;
    }

}