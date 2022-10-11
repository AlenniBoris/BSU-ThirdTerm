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

    public int fourthTask(){
        int res = 0;
        try{
            for (T el : _arr){
                res += el;
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
