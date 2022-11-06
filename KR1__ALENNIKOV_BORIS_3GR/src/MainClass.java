import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        Security a = new Security("vhgv", "ascjkb", 2,13,3);
        Security b = new Security("vawd", "awd", 22,13,34334);
        Security c = new Security("v", "grdv", 2,53,31);

        Saleman d = new Saleman("sdncj", "owqo", 73, 13276, 326);
        Saleman e = new Saleman("sd;ak,a,ncj", "owqao", 3, 136, 56);

        ArrayList<Employee> organisation = new ArrayList<>();
        organisation.add(a);
        organisation.add(b);
        organisation.add(c);
        organisation.add(d);
        organisation.add(e);

        for (Employee employee : organisation){
            System.out.print(employee.toString());
        }

        System.out.println();

        for (int i = 0; i < organisation.size(); ++i){
            System.out.print(Business.getBySalary(organisation).get(i).toString());
        }

        System.out.println();

        for (int i = 0; i < organisation.size(); ++i){
            System.out.print(Business.getByCoefficient(organisation).get(i).toString());
        }

        System.out.println();


        System.out.print(Business.getAverageSalary(organisation, "awd"));



        BusinessFrame frame = new BusinessFrame();
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
