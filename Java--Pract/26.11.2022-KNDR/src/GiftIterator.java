public class GiftIterator extends MyIterator<SweetOrigin>{
    private Gift gift;
    private int index;

    public GiftIterator(Gift gift) {
        this.gift = gift;
        index = 0;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public boolean isDone() {
        return index >= gift.size();
    }

    @Override
    public void next() {
        ++index;
    }

    @Override
    public SweetOrigin currentItem() {
        return isDone() ? null : gift.get(index);
    }
}
