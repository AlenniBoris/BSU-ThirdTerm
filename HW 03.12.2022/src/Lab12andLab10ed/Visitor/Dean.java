package Lab12andLab10ed.Visitor;

public class Dean implements Visitor {
    @Override
    public void visit(VisitedItem item){
        item.isVisited();
    }
}
