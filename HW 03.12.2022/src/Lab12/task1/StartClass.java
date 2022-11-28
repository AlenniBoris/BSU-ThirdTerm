package Lab12.task1;

import Lab12.task1.Interfaces.Iterator.Iterator;
import Lab12.task1.Interfaces.Visitor.VisitedItem;
import Lab12.task1.StructClasses.Multitude.Multitude;
import Lab12.task1.StructClasses.VisitedItem.Canteen;
import Lab12.task1.StructClasses.VisitedItem.WebsiteFPMI;
import Lab12.task1.StructClasses.Visitor.Dean;
import Lab12.task1.StructClasses.Visitor.Professor;
import Lab12.task1.StructClasses.Visitor.Student;


public class StartClass {
    public static void main(String[] args) {
        Multitude multitude = new Multitude();

        Dean Orlovich = new Dean();
        Professor Kastrica = new Professor();
        Student Alennikov = new Student();

        Canteen canteen = new Canteen();
        WebsiteFPMI websiteFPMI = new WebsiteFPMI();

        multitude.add(canteen);
        multitude.add(websiteFPMI);

        System.out.println("Orlovich \n");
        multitude.visit(Orlovich);
        System.out.println("\n Kastrica \n");
        multitude.visit(Kastrica);
        System.out.println("\n Alennikov \n");
        multitude.visit(Alennikov);
    }
}
