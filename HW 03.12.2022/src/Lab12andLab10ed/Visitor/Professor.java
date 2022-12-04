package Lab12andLab10ed.Visitor;

public class Professor implements Visitor {
    @Override
    public void visit(VisitedItem item){
        item.isVisited();
    }
}
