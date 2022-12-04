package Lab12andLab10ed;

import Lab12andLab10ed.Visitor.Canteen;
import Lab12andLab10ed.Visitor.WebsiteFPMI;
import Lab12andLab10ed.Visitor.Dean;
import Lab12andLab10ed.Visitor.Professor;
import Lab12andLab10ed.Visitor.Student;


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
