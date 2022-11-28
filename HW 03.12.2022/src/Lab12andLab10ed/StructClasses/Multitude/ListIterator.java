package Lab12andLab10ed.StructClasses.Multitude;

import Lab12andLab10ed.Interfaces.Iterator.Iterator;

public class ListIterator implements Iterator {
    int index;
    Multitude multitude;

    public ListIterator(Multitude multitude){
        this.multitude = multitude;
        index = 0;
    }

    @Override
    public void First() {
        index = 0;
    }

    @Override
    public void Next() {
        ++index;
    }

    @Override
    public Object CurrentItem() {
        return IsDone() ? null : multitude.getArrayList().get(index);
    }

    @Override
    public boolean IsDone() {
        return index >= multitude.size();
    }
}
