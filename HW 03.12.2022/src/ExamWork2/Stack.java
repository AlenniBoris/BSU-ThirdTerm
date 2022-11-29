package ExamWork2;

import ExamWork2.Interface.Iterator;
import ExamWork2.Interface.Strategy;
import ExamWork2.Interface.Visited;
import ExamWork2.Interface.Visitor;
import ExamWork2.Iterator.StackIterator;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + elements +
                '}';
    }

    public void strategySize(Strategy strategy){
        System.out.println(strategy.getSize());
    }

    @Override
    public Integer beCounted(Visitor visitor) {
        return visitor.count(this);
    }
}
