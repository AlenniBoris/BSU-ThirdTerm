import java.util.ArrayList;
import java.util.List;

public class CostStrategy extends Strategy {
    private final Gift gift;

    public CostStrategy(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void scaleParameter(int scale) {
        for (SweetOrigin sweet : gift.getSweets()){
            sweet.setCost(sweet.getCost() / scale);
        }
    }

    @Override
    public void reduceParameter(String reduceSweet) {
        List<SweetOrigin> arr = gift.getSweets().stream().filter(el -> !el.getType().equals(reduceSweet)).toList();
        gift.setSweets(new ArrayList<>(arr));
    }
}
