package Strategy;

import Gift.Gift;
import Interface.GiftStrategy;
import Sweets.Sweet;

import java.util.ArrayList;
import java.util.List;

public class LowWeightStrategy implements GiftStrategy {
    private final Gift gift;

    public LowWeightStrategy(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void scaleParameter(int scale) {
        for (Sweet sweet : gift.getSweets()){
            sweet.setSweetWeight(sweet.getSweetWeight() / scale);
        }
    }

    @Override
    public void reduceParameter(String reduceSweet) {
        List<Sweet> arr = gift.getSweets().stream().filter(el -> !el.getSweetType().equals(reduceSweet)).toList();
        gift.setSweets(new ArrayList<>(arr));
    }
}
