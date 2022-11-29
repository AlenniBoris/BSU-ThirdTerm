package ExamWork2;

import ExamWork2.Strategy.StrategyIterator;
import ExamWork2.Strategy.StrategyVisitor;
import ExamWork2.Visitor.VisitorPerson;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    public MainFrame(Stack stack){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        setLayout(new GridLayout(2,1));

        JLabel visitorLabel = new JLabel("Visitor size = " + stack.strategySize(new StrategyVisitor(stack, new VisitorPerson())));
        JLabel iteratorLabel = new JLabel("Iterator size = " + stack.strategySize(new StrategyIterator(stack)));

        add(iteratorLabel);
        add(visitorLabel);
    }
}
