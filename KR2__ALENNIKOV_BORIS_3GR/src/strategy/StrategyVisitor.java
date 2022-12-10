package strategy;

import visitor.Visitor;
import mvc.Multitude;

public class StrategyVisitor implements Strategy {
    private Multitude multitude;
    private Visitor visitor;

    public StrategyVisitor(Multitude multitude, Visitor visitor) {
        this.multitude = multitude;
        this.visitor = visitor;
    }

    @Override
    public Integer cardinality() {
        return multitude.cardinalityVisitor(visitor);
    }
}
