package ExamWork2.MVC;

import ExamWork2.Stack;
import ExamWork2.Strategy.StrategyIterator;
import ExamWork2.Strategy.StrategyVisitor;
import ExamWork2.Visitor.VisitorPerson;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View{
    private final Stack stack;
    private final JLabel stackLabel = new JLabel("Stack is empty");
    private final JLabel visitorLabel = new JLabel("Visitor length = 0");
    private final JLabel iteratorLabel = new JLabel("Iterator length = 0");

    public View(Stack stack) {
        this.stack = stack;
    }

    public JPanel getViewPanel(){
        JPanel viewPanel = new JPanel(new GridLayout(3,1));

        viewPanel.add(stackLabel);
        viewPanel.add(visitorLabel);
        viewPanel.add(iteratorLabel);

        return viewPanel;
    }

    public void update(){
        stackLabel.setText(stack.getElements().toString());
        visitorLabel.setText("Visitor length = " + stack.strategySize(new StrategyVisitor(stack, new VisitorPerson())));
        iteratorLabel.setText("Iterator length = " + stack.strategySize(new StrategyIterator(stack.getNewStack())));
    }

    public ArrayList<String> getLabelsText(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add(stackLabel.getText());
        strings.add(visitorLabel.getText());
        strings.add(iteratorLabel.getText());
        return strings;
    }
}
