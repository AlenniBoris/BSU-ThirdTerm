package ExamWork2.Strategy;

import ExamWork2.Interface.Strategy;
import ExamWork2.Interface.Visitor;
import ExamWork2.Stack;

public class StrategyVisitor implements Strategy {
    private Stack visitStack;
    private Visitor visitor;

    public StrategyVisitor(Stack stack, Visitor visitor) {
        this.visitStack = stack;
        this.visitor = visitor;
    }

    @Override
    public Integer getSize() {
        int size = visitStack.beCounted(visitor);
        return size;
    }
}
