package iterator;

import mvc.Multitude;

public class MultitudeIterator implements Iterator {
    int index;
    Multitude multitude;

    public MultitudeIterator(Multitude multitude) {
        this.multitude = multitude;
    }

    @Override
    public Object next() {
        return hasNext() ? multitude.getResults().get(index++) : null;
    }

    @Override
    public boolean hasNext() {
        return index < multitude.getResults().size();
    }
}
