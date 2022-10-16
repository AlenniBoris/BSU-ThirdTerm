import java.util.Arrays;
import java.util.function.Predicate;

public class FunctionsClass6<T extends Number & Comparable<T>>{
    private T _elem;
    private T[] _arr;

    public FunctionsClass6(T[] arr, T elem) {
        this._arr = arr;
        this._elem = elem;
    }

    public boolean firstTask(){
//        for (T el : _arr){
//            if (el.compareTo(_elem) == 0){
//                return "exists";
//            }
//        }
//        return "doesn't exist";
        return Arrays.stream(_arr).anyMatch(_elem::equals);
    }

    public long secondTask(){
//        int res = 0;
//        for (T el : _arr){
//            if (el.compareTo(_elem) == 0){
//                ++res;
//            }
//        }
//        return res;
//
        return Arrays.stream(_arr).filter(_elem::equals).count();
    }

    public long thirdTask(){
//        int res = 0;
//        for (T el : _arr){
//            if (el.compareTo(_elem) > 0){
//                ++res;
//            }
//        }
//        return res;

        return Arrays.stream(_arr).filter(el -> el.compareTo(_elem) > 0).count();
    }

    public double fourthTask(){
//        double sum = 0.0;
//        for (T el : _arr){
//            if (Integer.class.equals(el.getClass())) {
//                sum += (Integer) el;
//            }
//            else if (Double.class.equals(el.getClass())) {
//                sum += (Double) el;
//            }
//            else if (Float.class.equals(el.getClass())) {
//                sum += (Float) el;
//            }
//            else if (Short.class.equals(el.getClass())) {
//                sum += (Short) el;
//            }
//            else if (Long.class.equals(el.getClass())) {
//                sum += (Long) el;
//            }
//            else { throw new IllegalArgumentException("Check your types"); }
//        }
//
//        return sum;

        return Arrays.stream(_arr).mapToDouble(Number::doubleValue).sum();
    }

    public double fifthTask(){
        return fourthTask()/ _arr.length;
    }

    public long sixthTask(Predicate<T> predicate){
        return Arrays.stream(_arr).filter(predicate).count();
    }
}
