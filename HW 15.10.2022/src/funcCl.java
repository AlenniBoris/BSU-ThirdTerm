import java.util.List;

public class funcCl<T extends Comparable<T>>{
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

    public double fourthTask(){
        double sum = 0.0;
        for (T el : _arr){
            if (Integer.class.equals(el.getClass())) {
                sum += (Integer) el;
            }
            else if (Double.class.equals(el.getClass())) {
                sum += (Double) el;
            }
            else if (Float.class.equals(el.getClass())) {
                sum += (Float) el;
            }
            else if (Short.class.equals(el.getClass())) {
                sum += (Short) el;
            }
            else if (Long.class.equals(el.getClass())) {
                sum += (Long) el;
            }
            else { throw new IllegalArgumentException("Check your types"); }
        }

        return sum;
    }

    public double fifthTask(){
        return fourthTask()/ _arr.length;
    }
}
