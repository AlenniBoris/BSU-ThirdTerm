import jdk.incubator.vector.VectorOperators;

import java.beans.Expression;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;


public class funcCl<T extends Comparable<T> & Predicate<? super T>>{
    private T _elem;
    private T[] _arr;

    public funcCl(T[] arr, T elem) {
        this._arr = arr;
        this._elem = elem;
    }

    public String firstTask(){
        for (T el : _arr){
            if (el.compareTo(_elem) == 0){
                return "exists";
            }
        }
        return "doesn't exist";
    }

    public int secondTask(){
        int res = 0;
        for (T el : _arr){
            if (el.compareTo(_elem) == 0){
                ++res;
            }
        }
        return res;
    }

    public int thirdTask(){
        int res = 0;
        for (T el : _arr){
            if (el.compareTo(_elem) > 0){
                ++res;
            }
        }
        return res;
    }

    public T fourthTask(){
        T res = null;
        try{
          res = Arrays.stream(_arr).reduce(0, (a,b) -> a + b);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return res;
    }
}
