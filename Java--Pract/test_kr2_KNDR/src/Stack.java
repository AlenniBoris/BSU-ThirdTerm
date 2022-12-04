import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> elements;

    public Stack(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    public Stack() {
        elements = new ArrayList<>();
    }

    public Integer size() { return elements.size(); }

    public Iterator getIterator(){ return new StackIterator(this); }

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void Push(int element){ elements.add(element); }

    public Integer Pop(){
        int element = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return element;
    }

    public void clear(){
        Iterator iterator = this.getIterator();
    for (iterator.first();!iterator.isDone();iterator.next()){
            this.Pop();
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + elements +
                '}';
    }
}
