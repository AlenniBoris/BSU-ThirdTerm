import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Series {
    private double first;
    private double stepSrs;
    private int elemPos;

    public Series(double first, double stepSrs, int elemPos) {
        this.first = first;
        this.stepSrs = stepSrs;
        this.elemPos = elemPos;
    }

    public double getFirst() {
        return first;
    }

    public double getStepSrs() {
        return stepSrs;
    }

    public int getElemPos() {
        return elemPos;
    }

    public abstract double getElem(double first, double stepSrs, int elemPos);

    public double getSum(){
        double res = 0;
        for (int i = 1; i < elemPos + 1; i++) {
            res += getElem(first, stepSrs, i);
        }
        return res;
    }

    public String toString(){
        ArrayList<Double> arr = new ArrayList<>();
        for (int i = 1; i < elemPos + 1; i++) {
            arr.add(getElem(first, stepSrs, i));
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
