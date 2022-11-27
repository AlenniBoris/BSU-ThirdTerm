public abstract class MyIterator<T>{
    public abstract void first();

    public abstract boolean isDone();

    public abstract void next();

    public abstract T currentItem();
}