package mvc;

import strategy.StrategyIterator;
import strategy.StrategyVisitor;
import visitor.VisitorPerson;

import javax.swing.*;
import java.awt.*;

public class View{
    private final Multitude multitude;
    private final JLabel zeroOneMultitudeLabel = new JLabel("Multitude is empty");
    private final JLabel resultMultitudeLabel = new JLabel("Multitude is empty");
    private final JLabel visitorLabel = new JLabel("Visitor length = 0");
    private final JLabel iteratorLabel = new JLabel("Iterator length = 0");

    public View(Multitude multitude) {
        this.multitude = multitude;
    }

    public JPanel getViewPanel(){
        JPanel viewPanel = new JPanel(new GridLayout(3,1));

        viewPanel.add(zeroOneMultitudeLabel);
        viewPanel.add(resultMultitudeLabel);
        viewPanel.add(visitorLabel);
        viewPanel.add(iteratorLabel);

        return viewPanel;
    }

    public void update(){
        zeroOneMultitudeLabel.setText(multitude.getMultitude().toString());
        resultMultitudeLabel.setText(multitude.getResults().toString());
        visitorLabel.setText("Visitor length = " + multitude.cardinality(new StrategyVisitor(multitude, new VisitorPerson())));
        iteratorLabel.setText("Iterator length = " + multitude.cardinality(new StrategyIterator(multitude)));
    }
}
