package strategy;

import mvc.Multitude;
import iterator.*;

public class StrategyIterator implements Strategy {
    private Multitude multitude;

    public StrategyIterator(Multitude multitude) {
        this.multitude = multitude;
    }

    @Override
    public Integer cardinality() {
        Iterator iterator = multitude.getIterator();
        int size = 0;
        while(iterator.hasNext()){
            iterator.next();
            ++size;
        }
        return size;
    }
}
