import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Multitude<T> {
    private final ArrayList<T> arrayList;

    public Multitude(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public Multitude() {
        arrayList = new ArrayList<>();
    }

    public ArrayList<T> getArrayList() {
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

    public boolean equals(Multitude<T> second) {
        return arrayList.equals(second.arrayList);
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

    // Код итератора начало
    public Iterator getIterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator{
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
    // Код итератора конец

    public void add(T element){
        arrayList.add(element);
    }

    public void remove(int index){
        arrayList.remove(index);
    }

    public void addAll(Multitude<T> second_multitude){
        arrayList.addAll(second_multitude.getArrayList());
    }

    public List<T> unitMultitude(Multitude<T> second){
        arrayList.addAll(second.getArrayList());
        return arrayList.stream().distinct().toList();
    }

    public List<T> interceptionMultitude(Multitude<T> second){
        HashSet<T> firstSet = new HashSet<>(arrayList);
        HashSet<T> secondSet = new HashSet<>(second.getArrayList());
        List<T> res = new ArrayList<>();
        for (T element : firstSet){
            if (secondSet.contains(element)){
                res.add(element);
            }
        }
        return res;
    }

    public List<T> diffMultitude(Multitude<T> second){
        HashSet<T> firstSet = new HashSet<>(arrayList);
        HashSet<T> secondSet = new HashSet<>(second.getArrayList());
        List<T> res = new ArrayList<>();
        for (T element : firstSet){
            if (!secondSet.contains(element)){
                res.add(element);
            }
        }
        return res;
    }

    public void setFromList(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            arrayList.add((T)(sc.next()));
        }
    }
}
