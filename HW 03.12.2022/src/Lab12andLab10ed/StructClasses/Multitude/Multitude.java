package Lab12andLab10ed.StructClasses.Multitude;

import Lab12andLab10ed.Interfaces.Iterator.Iterator;
import Lab12andLab10ed.Interfaces.Visitor.VisitedItem;
import Lab12andLab10ed.Interfaces.Visitor.VisitedProject;
import Lab12andLab10ed.Interfaces.Visitor.Visitor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Multitude implements VisitedProject {
    private final ArrayList<VisitedItem> arrayList;

    public Multitude(ArrayList<VisitedItem> arrayList) {
        this.arrayList = arrayList;
    }

    public Multitude() {
        arrayList = new ArrayList<>();
    }

    public ArrayList<VisitedItem> getArrayList() {
        return arrayList;
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    public void clear() {
        arrayList.clear();
    }

    public int size(){
        return arrayList.size();
    }

    public boolean equals(Multitude second) {
        return arrayList.equals(second.arrayList);
    }

    @Override
    public String toString() {
        Iterator iter = getIterator();
        StringBuilder str = new StringBuilder();
        while (iter.IsDone()){
            str.append(" ").append(iter.CurrentItem());
            iter.Next();
        }
        return str.toString();
    }

    public Iterator getIterator(){
        return new ListIterator(this);
    }

    @Override
    public void visit(Visitor visitor) {
        for(VisitedItem item : arrayList){
            visitor.visit(item);
        }
    }

    public void add(VisitedItem element){
        arrayList.add(element);
    }

    public void remove(int index){
        arrayList.remove(index);
    }

    public void addAll(Multitude second_multitude){
        arrayList.addAll(second_multitude.getArrayList());
    }

    public List<VisitedItem> unitMultitude(Multitude second){
        arrayList.addAll(second.getArrayList());
        return arrayList.stream().distinct().toList();
    }

    public List<VisitedItem> interceptionMultitude(Multitude second){
        HashSet<VisitedItem> firstSet = new HashSet<>(arrayList);
        HashSet<VisitedItem> secondSet = new HashSet<>(second.getArrayList());
        List<VisitedItem> res = new ArrayList<>();
        for (VisitedItem element : firstSet){
            if (secondSet.contains(element)){
                res.add(element);
            }
        }
        return res;
    }

    public List<VisitedItem> diffMultitude(Multitude second){
        HashSet<VisitedItem> firstSet = new HashSet<>(arrayList);
        HashSet<VisitedItem> secondSet = new HashSet<>(second.getArrayList());
        List<VisitedItem> res = new ArrayList<>();
        for (VisitedItem element : firstSet){
            if (!secondSet.contains(element)){
                res.add(element);
            }
        }
        return res;
    }
}
