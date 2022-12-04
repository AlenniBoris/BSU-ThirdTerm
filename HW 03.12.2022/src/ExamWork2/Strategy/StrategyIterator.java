package ExamWork2.Strategy;

import ExamWork2.Iterator.Iterator;
import ExamWork2.Stack;

public class StrategyIterator implements Strategy {
    private Stack iterStack;

    public StrategyIterator(Stack stack) {
        this.iterStack = stack;
    }

    @Override
    public Integer getSize() {
        Iterator iterator = iterStack.getIterator();
        int size = 0;
        while(iterator.hasNext()){
            iterator.next();
            ++size;
        }
        return size;
    }
}
