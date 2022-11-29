package ExamWork2.Visitor;

import ExamWork2.Interface.Visitor;
import ExamWork2.Stack;

public class VisitorPerson implements Visitor {
    @Override
    public Integer count(Stack stack) {
        int size = 0;
        while(stack.size() > 0){
            ++size;
            stack.Pop();
        }
        return size;
    }
}
