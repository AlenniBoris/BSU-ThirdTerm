package Lab12andLab10ed;

import Lab12andLab10ed.Interfaces.Iterator.Iterator;
import Lab12andLab10ed.StructClasses.Multitude.ListIterator;
import Lab12andLab10ed.StructClasses.Multitude.Multitude;
import Lab12andLab10ed.StructClasses.VisitedItem.Canteen;
import Lab12andLab10ed.StructClasses.VisitedItem.WebsiteFPMI;
import Lab12andLab10ed.StructClasses.Visitor.Dean;
import Lab12andLab10ed.StructClasses.Visitor.Professor;
import Lab12andLab10ed.StructClasses.Visitor.Student;


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
