package Lab12andLab10ed.Visitor;

public class Canteen implements VisitedItem {
    @Override
    public void isVisited() {
        System.out.println("Canteen is visited");
    }
}
