package ExamWork2;

import ExamWork2.Strategy.StrategyVisitor;
import ExamWork2.Visitor.VisitorPerson;

public class RunClass {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);
        stack.Push(5);
        System.out.println(stack.toString());
//        System.out.println(stack.Pop());
//        System.out.println(stack.toString());
//
//        Iterator iterator = stack.getIterator();
//
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
        System.out.println(stack.size());
//        stack.strategySize(new StrategyIterator(stack));
        MainFrame mainFrame = new MainFrame(stack);
    }
}
