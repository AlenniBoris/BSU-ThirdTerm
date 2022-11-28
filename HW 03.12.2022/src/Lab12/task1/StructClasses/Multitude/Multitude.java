package Lab12.task1.StructClasses.Multitude;

import Lab12.task1.Interfaces.Iterator.Iterator;
import Lab12.task1.Interfaces.Visitor.VisitedItem;
import Lab12.task1.Interfaces.Visitor.VisitedProject;
import Lab12.task1.Interfaces.Visitor.Visitor;
import Lab12.task1.StructClasses.VisitedItem.Canteen;
import Lab12.task1.StructClasses.VisitedItem.WebsiteFPMI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Formattable;
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

    public DefaultListModel listModel(){
        DefaultListModel listModel = new DefaultListModel<>();
        for (var el : arrayList){
            listModel.addElement(el);
        }
        return listModel;
    }

    @Override
    public String toString() {
        Iterator iter = getIterator();
        StringBuilder str = new StringBuilder();
        while (iter.hasNext()){
            str.append(" ").append(iter.next());
        }
        return str.toString();
    }

    public Iterator getIterator(){
        return new ListIterator();
    }

    @Override
    public void visit(Visitor visitor) {
        for(VisitedItem item : arrayList){
            visitor.visit(item);
        }
    }

    private class ListIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < arrayList.size();
        }

        @Override
        public Object next() {
            return (this.hasNext()) ? arrayList.get(index++) : null;
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
