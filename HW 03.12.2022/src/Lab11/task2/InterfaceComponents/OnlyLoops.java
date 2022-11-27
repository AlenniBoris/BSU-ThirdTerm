package Lab11.task2.InterfaceComponents;

import Lab11.task2.Interface.*;
import Lab11.task2.Student.*;

import java.util.ArrayList;
import java.util.Comparator;

public class OnlyLoops implements Strategy {
    private ArrayList<Student> elements;

    public OnlyLoops(ArrayList<Student> elements) {
        this.elements = elements;
    }

    @Override
    public String[] getResult() {
        ArrayList<String> resultArr = new ArrayList<>();
        for(Student t : elements){
            resultArr.add(t.getSubject());
        }
        for (int i = 0; i < resultArr.size() - 1; i++) {
            for (int j = i + 1; j < resultArr.size(); j++) {
                if (resultArr.get(i).equals(resultArr.get(j))){
                    resultArr.remove(j);
                }
            }

        }
        resultArr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return resultArr.toArray(String[]::new);
    }
}
