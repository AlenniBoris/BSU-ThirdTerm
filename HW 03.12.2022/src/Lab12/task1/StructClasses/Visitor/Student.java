package Lab12.task1.StructClasses.Visitor;

import Lab12.task1.Interfaces.Visitor.VisitedItem;
import Lab12.task1.Interfaces.Visitor.Visitor;
import Lab12.task1.StructClasses.VisitedItem.Canteen;
import Lab12.task1.StructClasses.VisitedItem.WebsiteFPMI;

public class Student implements Visitor {
    @Override
    public void visit(VisitedItem item){
        item.isVisited();
    }
}
