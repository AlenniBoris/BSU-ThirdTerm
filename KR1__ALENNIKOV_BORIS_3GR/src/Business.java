import java.util.ArrayList;
import java.util.Comparator;

public class Business<T> {
public static ArrayList<? extends Employee> getBySalary(ArrayList<? extends Employee> arrayList){
    arrayList =  new ArrayList<>(arrayList.stream().sorted().toList());
    return arrayList;
}

public static ArrayList<? extends Employee> getByCoefficient(ArrayList<? extends Employee> arrayList){
    arrayList = new ArrayList<>(arrayList.stream().sorted(new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) ((o1.getSalary()/ o1.getWorkCoefficient()) - (o2.getSalary())/ o2.getWorkCoefficient());
        }
    }).toList());
    return arrayList;
}

public static ArrayList<String> getListWithOrganisation(ArrayList<? extends Employee> arrayList){
    ArrayList<? extends Employee> temp = new ArrayList<>(arrayList.stream().filter(e -> e.getOrganization().charAt(0) == 'B').distinct().toList());
    ArrayList<String> res = new ArrayList<>();
    for(Employee employee : temp){
        res.add(employee.getOrganization());
    }
    return res;
}

public static double getAverageSalary(ArrayList<? extends Employee> arrayList, String nameOrganisation){
    double res = 0;
    int count = 0;
    for(Employee employee : arrayList){
        if (nameOrganisation.equals((employee).getOrganization())){
            res += (employee).getSalary();
            ++count;
        }
    }
    return res/count;
}

public static String[] getArrOfPeople(ArrayList<? extends Employee> arrayList){
    String[] res = new String[arrayList.size()];
    for (int i = 0; i < arrayList.size(); ++i){
        res[i] = arrayList.get(i).toString();
    }
    return res;
}
}
