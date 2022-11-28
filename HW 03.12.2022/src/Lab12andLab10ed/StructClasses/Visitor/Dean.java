package Lab12andLab10ed.StructClasses.Visitor;

import Lab12andLab10ed.Interfaces.Visitor.VisitedItem;
import Lab12andLab10ed.Interfaces.Visitor.Visitor;

public class Dean implements Visitor {
    @Override
    public void visit(VisitedItem item){
        item.isVisited();
    }
}
