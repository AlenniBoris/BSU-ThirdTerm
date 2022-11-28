package Lab12.task1.Interfaces.Visitor;

import Lab12.task1.StructClasses.VisitedItem.Canteen;
import Lab12.task1.StructClasses.VisitedItem.WebsiteFPMI;

public interface Visitor {
    public void visit(VisitedItem item);
}
