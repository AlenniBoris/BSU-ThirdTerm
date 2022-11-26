package Strategy;

import Gift.Gift;
import Interface.GiftStrategy;
import Sweets.Sweet;

public class LowSugarStrategy implements GiftStrategy {
    private final Gift gift;

    public LowSugarStrategy(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void scaleParameter(int scale) {
        for (Sweet sweet : gift.getSweets()){
            sweet.setSweetSugar(sweet.getSweetSugar() / scale);
        }
    }

    @Override
    public void reduceParameter(String reduceSweet) {
        for(Sweet sweet : gift.getSweets()){
            if (sweet.getSweetType().equals(reduceSweet)){
                gift.delete(sweet);
            }
        }
    }
}
