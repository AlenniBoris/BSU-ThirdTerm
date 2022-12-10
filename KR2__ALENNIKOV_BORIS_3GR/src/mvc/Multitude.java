package mvc;

import iterator.Iterator;
import iterator.MultitudeIterator;
import strategy.Strategy;
import visitor.Visited;
import visitor.Visitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Multitude implements Visited {
    private final ArrayList<Integer> multitude;
    private int top;

    public Multitude(ArrayList<Integer> multitude) {
        this.multitude = multitude;
        top = 0;
    }

    public Multitude() {
        multitude = new ArrayList<>();
        top = 0;
    }

    @Override
    public String toString() {
        return "mvc.Multitude{" +
                "multitude=" + multitude +
                '}';
    }

    public ArrayList<Integer> getMultitude() {
        return multitude;
    }

    public Iterator getIterator(){
        return new MultitudeIterator(this);
    }

    public void add(Integer number){
        if (number < 0)
            throw new IllegalArgumentException("Not correct data");
        if (number >= top) {
            for (int i = top + 1; i <= number; ++i) {
                multitude.add(0);
            }
            multitude.add(1);
            top = number + 1;
        } else {
            multitude.set(number, 1);
        }
    }

    public ArrayList<Integer> getResults(){
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < multitude.size(); ++i){
            if (multitude.get(i) == 1){
                results.add(i);
            }
        }
        return results;
    }

    public void save(File filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (int i = 0; i < multitude.size(); ++i){
            if (multitude.get(i) == 1){
                writer.write(i + " ");
            }
        }
        writer.close();
    }

    @Override
    public Integer cardinalityVisitor(Visitor visitor) {
        return visitor.cardinality(this);
    }

    public Integer cardinality(Strategy strategy){
        return strategy.cardinality();
    }
}
