public class StackIterator implements Iterator {
    int index;
    Stack stack;

    public StackIterator(Stack stack) {
        this.stack = stack;
        index = 0;
    }


    @Override
    public void first() {
        index = 0;
    }

    @Override
    public boolean isDone() {
        return index >= stack.size();
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public Object currentItem() {
        return stack.getElements().get(index);
    }
}
