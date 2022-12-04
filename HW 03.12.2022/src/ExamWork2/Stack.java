package ExamWork2;

import ExamWork2.Iterator.Iterator;
import ExamWork2.Strategy.Strategy;
import ExamWork2.Visitor.Visited;
import ExamWork2.Visitor.Visitor;
import ExamWork2.Iterator.StackIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Stack implements Visited {
    private ArrayList<Integer> elements;

    public Stack(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    public Stack() {
        elements = new ArrayList<>();
    }

    public Integer size() { return elements.size(); }

    public Iterator getIterator(){ return new StackIterator(this); }

    public void Push(int element){ elements.add(element); }

    public Integer Pop(){
        int element = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return element;
    }

    public Stack getNewStack(){
        Stack copied = new Stack();
        for (Integer el : elements){
            copied.Push(el);
        }
        return copied;
    }

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void setFromFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            elements.add(Integer.parseInt(sc.next()));
        }
    }

    public void setToFile(File file, ArrayList<String> Text) throws IOException {
        FileWriter fw = new FileWriter(file);
        for(String str : Text){
            fw.write(str + "\n");
        }
        fw.close();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + elements +
                '}';
    }

    public Integer strategySize(Strategy strategy){
        return strategy.getSize();
    }

    @Override
    public Integer beCounted(Visitor visitor) {
        return visitor.count(this);
    }
}
