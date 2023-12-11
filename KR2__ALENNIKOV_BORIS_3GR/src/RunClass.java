import iterator.Iterator;
import mvc.Multitude;
import gui.MainFrame;
import strategy.StrategyIterator;
import strategy.StrategyVisitor;
import visitor.VisitorPerson;

//М – Multitude(пассивная)
//V – View
//С – Controller

public class RunClass {
    public static void main(String[] args){
        Multitude multitude = new Multitude();
        multitude.add(2);
        multitude.add(4);
        multitude.add(1);
        multitude.add(8);

        System.out.println(multitude.toString());

        Iterator iterator = multitude.getIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        System.out.println(multitude.cardinality(new StrategyVisitor(multitude, new VisitorPerson())));
        System.out.println(multitude.cardinality(new StrategyIterator(multitude)));

        MainFrame frame = new MainFrame();
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}


