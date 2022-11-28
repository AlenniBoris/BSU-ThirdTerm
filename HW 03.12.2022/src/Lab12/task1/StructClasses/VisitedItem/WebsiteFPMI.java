package Lab12.task1.StructClasses.VisitedItem;

import Lab12.task1.Interfaces.Visitor.VisitedItem;

public class WebsiteFPMI implements VisitedItem {
    @Override
    public void isVisited() {
        System.out.println("FPMI website is visited");
    }
}
