package ExamWork2.Iterator;

import ExamWork2.Interface.Iterator;
import ExamWork2.Stack;

public class StackIterator implements Iterator {
    int index;
    Stack stack;

    public StackIterator(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Object next() {
        return hasNext() ? stack.Pop() : null;
    }

    @Override
    public boolean hasNext() {
        return index < stack.size();
    }
}
