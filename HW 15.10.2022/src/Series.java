import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Series {
    private final double _stepSrs;
    private final int _elemPos;
    private final double _first;

    public Series(double stepSrs, int elemPos, double first) {
        this._stepSrs = stepSrs;
        this._elemPos = elemPos;
        this._first = first;
    }

    public abstract double getElem(double first, double stepSrs, int elemPos);

    public double getSum(){
        double res = 0;
        for (int i = 1; i < _elemPos + 1; i++) {
            res += getElem(_first, _stepSrs, i);
        }
        return res;
    }

    public String toString(){
        ArrayList<Double> arr = new ArrayList<>();
        for (int i = 1; i < _elemPos + 1; i++) {
            arr.add(getElem(_first, _stepSrs, i));
        }
        return arr.toString();
    }

    public void writeSeriesToFile(String fileName){
        try(FileWriter fw = new FileWriter(fileName)) {
            fw.write(toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
