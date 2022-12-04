package ExamWork2.Visitor;

import ExamWork2.Stack;

public class VisitorPerson implements Visitor {
    @Override
    public Integer count(Stack stack) {
        int size = 0;
        for (Integer elem : stack.getElements()){
            ++size;
        }
        return size;
    }
}
