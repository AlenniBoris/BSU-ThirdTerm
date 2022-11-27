import java.util.ArrayList;
import java.util.List;

public class WeightStrategy extends Strategy {
    private final Gift gift;

    public WeightStrategy(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void scaleParameter(int scale) {
        GiftIterator iterator = gift.getIterator();
        iterator.first();
        while(!iterator.isDone()){
            iterator.currentItem().setWeight(iterator.currentItem().getWeight()/scale);
            iterator.next();
        }
    }

    @Override
    public void reduceParameter(String reduceSweet) {
        GiftIterator iterator = gift.getIterator();
        iterator.first();
        while(!iterator.isDone()){
            if(iterator.currentItem().getType().equals(reduceSweet)){
                gift.delete(iterator.currentItem());
            }
            iterator.next();
        }
    }
}
