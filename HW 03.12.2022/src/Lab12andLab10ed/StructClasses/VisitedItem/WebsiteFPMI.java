package Lab12andLab10ed.StructClasses.VisitedItem;

import Lab12andLab10ed.Interfaces.Visitor.VisitedItem;

public class WebsiteFPMI implements VisitedItem {
    @Override
    public void isVisited() {
        System.out.println("FPMI website is visited");
    }
}
